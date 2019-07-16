package com.wqt.user.action;

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
import com.wqt.user.pojo.EsSellerShopList;
import com.wqt.user.pojo.UEsShop;
import com.wqt.user.service.UEsShopService;

public class EsShopAction  extends BusinessAction{
	private static final Logger logger = LoggerFactory.getLogger(EsShopAction.class);

	@Autowired
	private UEsShopService esShopService;
	
	
	private EsSellerShopList esSellerShopList;
	


	public EsSellerShopList getEsSellerShopList() {
		return esSellerShopList;
	}

	public void setEsSellerShopList(EsSellerShopList esSellerShopList) {
		this.esSellerShopList = esSellerShopList;
	}


    
	/*获取卖家用户企业服务商品*/
	public String esSellerShop()
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
	       serverurl=serverurl.substring(0, serverurl.indexOf("/shop/es/seller"));
		   String pagenum=request.getParameter("pagenum");
		   String shopstate=request.getParameter("shopstate");
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
			   
			   if(shopstate!=null && (!"".equals(shopstate.trim())))
			   {
				   if(!CommonUtil.isNumber(shopstate))
				   {
					   shopstate="0";  
				   }
			   }
			   else
			   {
				   shopstate="0"; 
			   }
			   
			    
			   if(esSellerShopList==null)
			   {
				   esSellerShopList=new EsSellerShopList();
			   }
			   
			   esSellerShopList.setPagenum(pagenum);
			   esSellerShopList.setShopstate(Integer.parseInt(shopstate));
			   Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
			
			   UserBasic wqtuser = (UserBasic) user;
			   UEsShop esShop=new UEsShop();
			   if(!"0".equals(shopstate))
			   {
				   esShop.setShopstate(shopstate);
			   }
			   
			   esShop.setShopuser(wqtuser.getId());
			   Pagination page=esShopService.selectEsShopPage(esShop, pagination);
			   if(page.getList()!=null && page.getList().size()>0)
			   {
				   esSellerShopList.setL_EsShop(page.getList());
				   esSellerShopList.setShopcount(String.valueOf(page.getCount()));
				   esSellerShopList.setShoppage(String.valueOf(page.getAllPage()));
			   }
		   }
		   else
		   {
			   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/shop/es/seller/list");
			   return null;
		   }
	  	}
	    catch(Exception e)
		{
	    	return "404";
		}
		return SUCCESS;
	}
}
