package com.wqt.user.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.common.util.CommonUtil;
import com.wqt.common.util.PropertiesUtil;
import com.wqt.eshop.pojo.EShopOrder;
import com.wqt.eshop.pojo.EShopShop;
import com.wqt.eshop.service.EShopOrderService;
import com.wqt.eshop.service.EShopShopService;
import com.wqt.user.pojo.EShopBuyerOrderList;
import com.wqt.user.pojo.UEShopOrder;
import com.wqt.user.pojo.UOrderCancel;
import com.wqt.user.service.UEShopOrderService;
import com.wqt.user.service.UOrderCancelService;

/*网店订单*/
public class EShopOrderAction    extends BusinessAction{
	
	private static final Logger logger = LoggerFactory.getLogger(EShopOrderAction.class);
	
	@Autowired
	private UEShopOrderService uEShopOrderService;
	
	@Autowired
	private UOrderCancelService uOrderCancelService;
	
	@Autowired
	private EShopShopService eShopShopService;
	
	@Autowired
	private EShopOrderService  eShopOrderService;
	
	private EShopBuyerOrderList eShopBuyerOrderList;
	
	public EShopBuyerOrderList geteShopBuyerOrderList() {
		return eShopBuyerOrderList;
	}

	public void seteShopBuyerOrderList(EShopBuyerOrderList eShopBuyerOrderList) {
		this.eShopBuyerOrderList = eShopBuyerOrderList;
	}

	/*获取买家用户网店订单*/
	public String eShopBuyerOrder()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	    
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		serverurl=serverurl.substring(0, serverurl.indexOf("/order/wd/buyer"));
		String orderstate=request.getParameter("orderstate");
	    String pagenum=request.getParameter("pagenum");
	    try
	  	{
		   if(user!=null)
		   {
			   if(pagenum!=null && (!"".equals(pagenum.trim())))
			   {
				   if(!CommonUtil.isNumber(pagenum))
				   {
					   pagenum="1";  
				   }
			   }
			   else
			   {
				   pagenum="1"; 
			   }
			   
			   if(orderstate!=null && (!"".equals(orderstate.trim())))
			   {
				   if(!CommonUtil.isNumber(orderstate))
				   {
					   orderstate="0";  
				   }
			   }
			   else
			   {
				   orderstate="0"; 
			   }
			    
			   if(eShopBuyerOrderList==null)
			   {
				   eShopBuyerOrderList=new EShopBuyerOrderList();
			   }
			   
			   eShopBuyerOrderList.setPagenum(Integer.parseInt(pagenum));
			   Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
			   UserBasic wqtuser = (UserBasic) user;
			   //UserBasic wqtuser =new UserBasic();
			   //wqtuser.setId("1");
			   UEShopOrder eShopOrder=new UEShopOrder();
			   if(!"0".equals(orderstate))
			   {
				   eShopOrder.setOrderstate(orderstate);
			   }
			   eShopBuyerOrderList.setOrderstate(orderstate);
			   eShopOrder.setBuyerid(Integer.parseInt(wqtuser.getId()));
			   Pagination page=uEShopOrderService.selectEShopOrderPage(eShopOrder, pagination);
			   if(page.getList()!=null && page.getList().size()>0)
			   {
				   eShopBuyerOrderList.setL_EShopOrder(page.getList());
				   eShopBuyerOrderList.setOrdercount(page.getCount());
				   eShopBuyerOrderList.setOrderpage(page.getAllPage());
			   }
		   }
		   else
		   {
			   if(pagenum!=null && (!"".equals(pagenum.trim())))
			   {
			        response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/order/wd/buyer/"+orderstate+"/list/"+pagenum);
			   }
			   else
			   {
				   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/order/wd/buyer/"+orderstate+"/list/1");
			   }
			   return null;
		   }
	  	}
	    catch(Exception e)
		{
	    	return "404";
		}
		return SUCCESS;
	}
	
	/*取消网店订单*/
	public String eShopCancelBuyerOrder()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	    Map resultMap = new HashMap();
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
	    try
	  	{
	    	serverurl=serverurl.substring(0, serverurl.indexOf("/order/buyer/wd/"));
		    String ordercode=request.getParameter("ordercode");
		    String ordertype=request.getParameter("ordertype");
	    	if(ordercode!=null && (!"".equals(ordercode.trim())) && ordertype!=null && (!"".equals(ordertype.trim())))
			{
				   if(user!=null)
				   {
					   UserBasic wqtUserBasic = (UserBasic) user;
					   if("6".equals(ordertype))   //网店订单
					   {  
						   EShopOrder eShopOrder=new EShopOrder();
						   eShopOrder.setOrdercode(ordercode);
						   eShopOrder.setBuyerid(Integer.parseInt(wqtUserBasic.getId()));
						   eShopOrder=eShopOrderService.selectOneEShopOrder(eShopOrder);
						   if(eShopOrder!=null)
						   {
							   eShopOrder.setState(5);
							   eShopOrderService.updateEShopOrder(eShopOrder);
							   
							   if(eShopOrder.getState()==3 || eShopOrder.getState()==2)
							   {
								   EShopShop eShopShop=new EShopShop();
								   eShopShop.setId(eShopOrder.getShopid());
								   eShopShop.setState(2);
								   eShopShopService.updateEShopShop(eShopShop);
								   
								   UOrderCancel uOrderCancel=new UOrderCancel();
								   uOrderCancel.setOrderid(Integer.parseInt(eShopOrder.getId()));
								   uOrderCancel.setOrdercode(eShopOrder.getOrdercode());
								   uOrderCancel.setOrdertype(5);
								   uOrderCancel.setCanceluserid(Integer.parseInt(wqtUserBasic.getId()));
								   uOrderCancel.setState(1);
								   uOrderCancelService.insertUOrderCancel(uOrderCancel);
							   }
							   response.sendRedirect(serverurl+"/order/wd/buyer/list");
							   return null;
						   }
						   else
						   {
							   response.sendRedirect(serverurl+"/order/wd/buyer/list");
							   return null;
						   }
					   }
				   }
				   else
				   {
					  response.sendRedirect(PropertiesUtil.rs.get("casserver")+"/login?service="+serverurl+"/order/wd/buyer/list");
					  return null;
				   }
			}
	    	else   //参数不完整
	    	{
	    		 response.sendRedirect(serverurl+"/order/wd/buyer/list");
	    	}
		  
	  	}
	    catch(Exception e)
		{
	    	return "404";
		}
		return SUCCESS;
	}
}
