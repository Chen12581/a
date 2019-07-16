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
import com.wqt.user.pojo.IprSellerShopList;
import com.wqt.user.pojo.UIprShop;
import com.wqt.user.service.UIprShopService;

public class IprShopAction  extends BusinessAction{
	private static final Logger logger = LoggerFactory.getLogger(IprShopAction.class);


	

	@Autowired
	private UIprShopService iprShopService;
	
	
	private IprSellerShopList iprSellerShopList;
	
	public IprSellerShopList getIprSellerShopList() {
		return iprSellerShopList;
	}

	public void setIprSellerShopList(IprSellerShopList iprSellerShopList) {
		this.iprSellerShopList = iprSellerShopList;
	}

	/*获取卖家用户知识产权商品*/
	public String iprSellerShop()
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
	    	serverurl=serverurl.substring(0, serverurl.indexOf("/shop/seller"));
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
			   if(iprSellerShopList==null)
			   {
				   iprSellerShopList=new IprSellerShopList();
			   }
			   
			   iprSellerShopList.setPagenum(pagenum);
			   iprSellerShopList.setShopstate(Integer.parseInt(shopstate));
			   Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
			
			   UserBasic wqtuser = (UserBasic) user;
			   UIprShop iprShop=new UIprShop();
			   iprShop.setShopuser(wqtuser.getId());
			   if(!"0".equals(shopstate))
			   {
				   iprShop.setShopstate(shopstate);
			   }
			   Pagination page=iprShopService.selectIprShopPage(iprShop, pagination);
			   if(page.getList()!=null && page.getList().size()>0)
			   {
				   iprSellerShopList.setL_IprShop(page.getList());
				   iprSellerShopList.setShopcount(String.valueOf(page.getCount()));
				   iprSellerShopList.setShoppage(String.valueOf(page.getAllPage()));
			   }
		   }
		   else
		   {
			   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/shop/seller/list");
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
