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
import com.wqt.ipr.brand.pojo.IprBrandShop;
import com.wqt.ipr.brand.service.BrandShopService;
import com.wqt.ipr.copyright.pojo.IprCopyrightShop;
import com.wqt.ipr.copyright.service.CopyrightShopService;
import com.wqt.ipr.order.pojo.IprOrderProduct;
import com.wqt.ipr.order.pojo.IprOrderShop;
import com.wqt.ipr.order.service.IprOrderProductService;
import com.wqt.ipr.order.service.IprOrderShopService;
import com.wqt.ipr.patent.pojo.IprPatentShop;
import com.wqt.ipr.patent.service.PatentShopService;
import com.wqt.user.pojo.IprBuyerOrderList;
import com.wqt.user.pojo.UIprOrder;
import com.wqt.user.pojo.UOrderCancel;
import com.wqt.user.service.UIprOrderService;
import com.wqt.user.service.UOrderCancelService;

public class IprOrderAction  extends BusinessAction{
	private static final Logger logger = LoggerFactory.getLogger(OrderPaymentAction.class);
	
	@Autowired
	private UIprOrderService uIprOrderService;
	
	@Autowired
	private IprOrderProductService iprOrderProductService;
	
	@Autowired
	private IprOrderShopService iprOrderShopService;
	
	@Autowired
	private UOrderCancelService uOrderCancelService;
	
	@Autowired
	private BrandShopService  brandShopService;
	
	@Autowired
	private CopyrightShopService  copyrightShopService;
	
	@Autowired
	private PatentShopService  patentShopService;
	
	
	private IprBuyerOrderList iprBuyerOrderList;   //知识产权订单列表页
	
	
	public IprBuyerOrderList getIprBuyerOrderList() {
		return iprBuyerOrderList;
	}

	public void setIprBuyerOrderList(IprBuyerOrderList iprBuyerOrderList) {
		this.iprBuyerOrderList = iprBuyerOrderList;
	}

	/*获取买家用户知识产权订单*/
	public String iprBuyerOrder()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	    
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		
	    try
	  	{
	    	serverurl=serverurl.substring(0, serverurl.indexOf("/order/buyer"));
			String orderstate=request.getParameter("orderstate");
		    String pagenum=request.getParameter("pagenum");
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
			   
			   if(iprBuyerOrderList==null)
			   {
				   iprBuyerOrderList=new IprBuyerOrderList();
			   }
			   
			   iprBuyerOrderList.setPagenum(pagenum);
			   Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
			   UserBasic wqtuser = (UserBasic) user;
			   UIprOrder iprOrder=new UIprOrder();
			   iprOrder.setBuyerid(wqtuser.getId());
			   if(!"0".equals(orderstate))
			   {
				   iprOrder.setOrderstate(orderstate);
			   }
			   iprBuyerOrderList.setOrderstate(orderstate);
			   Pagination page=uIprOrderService.selectIprrOrderPage(iprOrder, pagination);
			   if(page.getList()!=null && page.getList().size()>0)
			   {
				   iprBuyerOrderList.setL_IprOrder(page.getList());
				   iprBuyerOrderList.setOrdercount(String.valueOf(page.getCount()));
				   iprBuyerOrderList.setOrderpage(String.valueOf(page.getAllPage()));
			   }
		   }
		   else
		   {
			   if(pagenum!=null && (!"".equals(pagenum.trim())))
			   {
			        response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/order/buyer/"+orderstate+"/list/"+pagenum);
			   }
			   else
			   {
				   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/order/buyer/"+orderstate+"/list/1");
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
	
	/*取消知识产权订单*/
	public String iprCancelBuyerOrder()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	    Map resultMap = new HashMap();
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		serverurl=serverurl.substring(0, serverurl.indexOf("/order/buyer/cancel"));
	    String ordercode=request.getParameter("ordercode");
	    String ordertype=request.getParameter("ordertype");
	    try
	  	{
	    	if(ordercode!=null && (!"".equals(ordercode.trim())) && ordertype!=null && (!"".equals(ordertype.trim())))
			{
				   if(user!=null)
				   {
					   UserBasic wqtUserBasic = (UserBasic) user;
					   if("1".equals(ordertype))   //服务产品类订单
					   {  
						   IprOrderProduct iprOrderProduct=new IprOrderProduct();
						   iprOrderProduct.setOrdercode(ordercode);
						   iprOrderProduct.setUserid(wqtUserBasic.getId());
						   iprOrderProduct=iprOrderProductService.selectOneIprOrderProduct(iprOrderProduct);
						   if(iprOrderProduct!=null)
						   {
							   iprOrderProduct.setState("5");
							   iprOrderProductService.updateIprOrderProduct(iprOrderProduct);
							   
							   UOrderCancel uOrderCancel=new UOrderCancel();
							   uOrderCancel.setOrderid(Integer.parseInt(iprOrderProduct.getId()));
							   uOrderCancel.setOrdercode(iprOrderProduct.getOrdercode());
							   uOrderCancel.setOrdertype(1);
							   uOrderCancel.setCanceluserid(Integer.parseInt(wqtUserBasic.getId()));
							   uOrderCancel.setState(1);
							   uOrderCancelService.insertUOrderCancel(uOrderCancel);
							   
							   response.sendRedirect(serverurl+"/order/buyer/list");
							   return null;
						   }
						   else
						   {
							   response.sendRedirect(serverurl+"/order/buyer/list");
							   return null;
						   }
					   }
					   else if("2".equals(ordertype))   //交易产品类订单
					   {
						   IprOrderShop  iprOrderShop=new IprOrderShop();
						   iprOrderShop.setOrdercode(ordercode);
						   iprOrderShop.setBuyerid(wqtUserBasic.getId());
						   iprOrderShop=iprOrderShopService.selectOneIprOrderShop(iprOrderShop);
						   if(iprOrderShop!=null)
						   {
							   /*修改订单状态*/
							   iprOrderShop.setState("5");
							   iprOrderShopService.updateIprOrderShop(iprOrderShop);
							   
							   
							   if("2".equals(iprOrderShop.getState()) || "3".equals(iprOrderShop.getState()))  //已付款，需要走退款流程，后续开发
							   {
								   /*恢复交易产品状态*/
								   if("1".equals(iprOrderShop.getOrderkind()))
								   {
									   IprBrandShop iprBrandShop=new IprBrandShop();
									   iprBrandShop.setId(iprOrderShop.getShopid());
									   iprBrandShop.setState("2");
									   brandShopService.updateIprBrandShop(iprBrandShop);
								   }
								   else if("2".equals(iprOrderShop.getOrderkind()))
			                       {
									   IprCopyrightShop iprCopyrightShop=new IprCopyrightShop();
									   iprCopyrightShop.setId(iprOrderShop.getShopid());
									   iprCopyrightShop.setState("2");
									   copyrightShopService.updateCopyrightShop(iprCopyrightShop);
								   } 
								   else if("3".equals(iprOrderShop.getOrderkind()))
			                       {
									   IprPatentShop iprPatentShop=new IprPatentShop();
									   iprPatentShop.setId(iprOrderShop.getShopid());
									   iprPatentShop.setState("2");
									   patentShopService.updatePatentShop(iprPatentShop);
								   }
								   
								   UOrderCancel uOrderCancel=new UOrderCancel();
								   uOrderCancel.setOrderid(Integer.parseInt(iprOrderShop.getId()));
								   uOrderCancel.setOrdercode(iprOrderShop.getOrdercode());
								   uOrderCancel.setOrdertype(2);
								   uOrderCancel.setCanceluserid(Integer.parseInt(wqtUserBasic.getId()));
								   uOrderCancel.setState(1);
								   uOrderCancelService.insertUOrderCancel(uOrderCancel);
							   }
							   response.sendRedirect(serverurl+"/order/buyer/list");
							   return null;
						   }
						   else
						   {
							   response.sendRedirect(serverurl+"/order/buyer/list");
							   return null;
						   }
					   } 
				   }
				   else
				   {
					  response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/order/buyer/list");
					  return null;
				   }
			}
	    	else   //参数不完整
	    	{
	    		 response.sendRedirect(serverurl+"/order/buyer/list");
	    	}
		  
	  	}
	    catch(Exception e)
		{
	    	return "404";
		}
		return SUCCESS;
	}
}
