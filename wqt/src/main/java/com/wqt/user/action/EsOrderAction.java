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
import com.wqt.es.order.pojo.EsOrderServices;
import com.wqt.es.order.pojo.EsOrderTrade;
import com.wqt.es.order.service.EsOrderServiceService;
import com.wqt.es.order.service.EsOrderTradeService;
import com.wqt.es.trade.pojo.EsTradeCompanyShop;
import com.wqt.es.trade.service.EsTradeCompanyShopService;
import com.wqt.user.pojo.EsBuyerOrderList;
import com.wqt.user.pojo.EsSellerOrderList;
import com.wqt.user.pojo.UEsOrder;
import com.wqt.user.pojo.UOrderCancel;
import com.wqt.user.service.UEsOrderService;
import com.wqt.user.service.UOrderCancelService;


public class EsOrderAction   extends BusinessAction{
	
	private static final Logger logger = LoggerFactory.getLogger(EsOrderAction.class);
	
	@Autowired
	private EsOrderServiceService esOrderServiceService;
	
	@Autowired
	private EsOrderTradeService esOrderTradeService;

	@Autowired
	private EsTradeCompanyShopService esTradeCompanyShopService;
	
	@Autowired
	private UOrderCancelService uOrderCancelService;
	
	@Autowired
	private UEsOrderService uEsOrderService;
	
	private EsBuyerOrderList esBuyerOrderList;
	
	private EsSellerOrderList esSellerOrderList;
	
	

	public EsBuyerOrderList getEsBuyerOrderList() {
		return esBuyerOrderList;
	}

	public void setEsBuyerOrderList(EsBuyerOrderList esBuyerOrderList) {
		this.esBuyerOrderList = esBuyerOrderList;
	}

	public EsSellerOrderList getEsSellerOrderList() {
		return esSellerOrderList;
	}

	public void setEsSellerOrderList(EsSellerOrderList esSellerOrderList) {
		this.esSellerOrderList = esSellerOrderList;
	}
	
	/*获取买家用户去企业服务订单*/
	public String esBuyerOrder()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	    
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		serverurl=serverurl.substring(0, serverurl.indexOf("/order/es/buyer"));
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
			    
			   if(esBuyerOrderList==null)
			   {
				   esBuyerOrderList=new EsBuyerOrderList();
			   }
			   
			   esBuyerOrderList.setPagenum(pagenum);
			   Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
			   UserBasic wqtuser = (UserBasic) user;
			   //UserBasic wqtuser =new UserBasic();
			  // wqtuser.setId("1");
			   UEsOrder esOrder=new UEsOrder();
			   esOrder.setBuyerid(wqtuser.getId());
			   if(!"0".equals(orderstate))
			   {
				   esOrder.setOrderstate(orderstate);
			   }
			   esBuyerOrderList.setOrderstate(orderstate);
			   Pagination page=uEsOrderService.selectEsOrderPage(esOrder, pagination);
			   if(page.getList()!=null && page.getList().size()>0)
			   {
				   esBuyerOrderList.setL_EsOrder(page.getList());
				   esBuyerOrderList.setOrdercount(String.valueOf(page.getCount()));
				   esBuyerOrderList.setOrderpage(String.valueOf(page.getAllPage()));
			   }
		   }
		   else
		   {
			   if(pagenum!=null && (!"".equals(pagenum.trim())))
			   {
			        response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/order/es/buyer/"+orderstate+"/list/"+pagenum);
			   }
			   else
			   {
				   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/order/es/buyer/"+orderstate+"/list/1");
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
	
	
	/*获取卖家用户的企业服务订单*/
	public String esSellerOrder()
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
	       serverurl=serverurl.substring(0, serverurl.indexOf("/order/es/buyer"));
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
			   			    
			   if(esSellerOrderList==null)
			   {
				   esSellerOrderList=new EsSellerOrderList();
			   }
			   
			   esSellerOrderList.setPagenum(pagenum);
			   Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
			   UserBasic wqtuser = (UserBasic) user;
			   UEsOrder esOrder=new UEsOrder();
			   esOrder.setSellerid(wqtuser.getId());
			   Pagination page=uEsOrderService.selectEsOrderPage(esOrder, pagination);
			   if(page.getList()!=null && page.getList().size()>0)
			   {
				   esSellerOrderList.setL_EsOrder(page.getList());
				   esSellerOrderList.setOrdercount(String.valueOf(page.getCount()));
				   esSellerOrderList.setOrderpage(String.valueOf(page.getAllPage()));
			   }
		   }
		   else
		   {
			   if(pagenum!=null && (!"".equals(pagenum.trim())))
			   {
			        response.sendRedirect(PropertiesUtil.rs.get("casserver")+"/login?service="+serverurl+"/order/es/buyer/list"+pagenum);
			   }
			   else
			   {
				   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"/login?service="+serverurl+"/order/es/buyer/list");
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
	
	/*取消企业服务订单*/
	public String esCancelBuyerOrder()
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
	    	serverurl=serverurl.substring(0, serverurl.indexOf("/order/buyer/es/"));
		    String ordercode=request.getParameter("ordercode");
		    String ordertype=request.getParameter("ordertype");
	    	if(ordercode!=null && (!"".equals(ordercode.trim())) && ordertype!=null && (!"".equals(ordertype.trim())))
			{
				   if(user!=null)
				   {
					   UserBasic wqtUserBasic = (UserBasic) user;
					   if("3".equals(ordertype))   //服务产品类订单
					   {  
						   EsOrderServices esOrderServices=new EsOrderServices();
						   esOrderServices.setOrdercode(ordercode);
						   esOrderServices.setUserid(wqtUserBasic.getId());
						   esOrderServices=esOrderServiceService.selectOneEsOrderService(esOrderServices);
						   if(esOrderServices!=null)
						   {
							   esOrderServices.setState("5");
							   esOrderServiceService.updateEsOrderService(esOrderServices);
							   
							   UOrderCancel uOrderCancel=new UOrderCancel();
							   uOrderCancel.setOrderid(Integer.parseInt(esOrderServices.getId()));
							   uOrderCancel.setOrdercode(esOrderServices.getOrdercode());
							   uOrderCancel.setOrdertype(3);
							   uOrderCancel.setCanceluserid(Integer.parseInt(wqtUserBasic.getId()));
							   uOrderCancel.setState(1);
							   uOrderCancelService.insertUOrderCancel(uOrderCancel);
							   
							   response.sendRedirect(serverurl+"/order/es/buyer/list");
							   return null;
						   }
						   else
						   {
							   response.sendRedirect(serverurl+"/order/es/buyer/list");
							   return null;
						   }
					   }
					   else if("4".equals(ordertype))   //交易产品类订单
					   {
						   EsOrderTrade  esOrderTrade=new EsOrderTrade();
						   esOrderTrade.setOrdercode(ordercode);
						   esOrderTrade.setBuyerid(wqtUserBasic.getId());
						   esOrderTrade=esOrderTradeService.selectOneEsOrderTrade(esOrderTrade);
						   if(esOrderTrade!=null)
						   {
							   /*修改订单状态*/
							   esOrderTrade.setState("5");
							   esOrderTradeService.updateEsOrderTrade(esOrderTrade);
							 
							   if("2".equals(esOrderTrade.getState()) || "3".equals(esOrderTrade.getState()))  //已付款，需要走退款流程，后续开发
							   {
								   EsTradeCompanyShop esTradeCompanyShop=new EsTradeCompanyShop();
								   esTradeCompanyShop.setId(esOrderTrade.getCompanyshopid());
								   esTradeCompanyShop.setState("2");
								   esTradeCompanyShopService.updateEsTradeCompanyShop(esTradeCompanyShop);
								   
								   UOrderCancel uOrderCancel=new UOrderCancel();
								   uOrderCancel.setOrderid(Integer.parseInt(esOrderTrade.getId()));
								   uOrderCancel.setOrdercode(esOrderTrade.getOrdercode());
								   uOrderCancel.setOrdertype(4);
								   uOrderCancel.setCanceluserid(Integer.parseInt(wqtUserBasic.getId()));
								   uOrderCancel.setState(1);
								   uOrderCancelService.insertUOrderCancel(uOrderCancel);
							   }
							   response.sendRedirect(serverurl+"/order/es/buyer/list");
							   return null;
						   }
						   else
						   {
							   response.sendRedirect(serverurl+"/order/es/buyer/list");
							   return null;
						   }
					   } 
				   }
				   else
				   {
					  response.sendRedirect(PropertiesUtil.rs.get("casserver")+"/login?service="+serverurl+"/order/es/buyer/list");
					  return null;
				   }
			}
	    	else   //参数不完整
	    	{
	    		 response.sendRedirect(serverurl+"/order/es/buyer/list");
	    	}
		  
	  	}
	    catch(Exception e)
		{
	    	return "404";
		}
		return SUCCESS;
	}
}
