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
import com.wqt.user.pojo.EShopSellerShopList;
import com.wqt.user.pojo.EsSellerShopList;
import com.wqt.user.pojo.UEShopShop;
import com.wqt.user.pojo.UEsShop;
import com.wqt.user.service.UEShopShopService;

/*发布的网店*/
public class EShopShopAction    extends BusinessAction{
	
	private static final Logger logger = LoggerFactory.getLogger(EShopShopAction.class);
	
	@Autowired
	private UEShopShopService uEShopShopService;
	
	private EShopSellerShopList eShopSellerShopList;
	
	public EShopSellerShopList geteShopSellerShopList() {
		return eShopSellerShopList;
	}

	public void seteShopSellerShopList(EShopSellerShopList eShopSellerShopList) {
		this.eShopSellerShopList = eShopSellerShopList;
	}

  
	public String eShopSellerShop()
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
		       serverurl=serverurl.substring(0, serverurl.indexOf("/shop/wd/seller"));
			   String pagenum=request.getParameter("pagenum");
			   String shopstate=request.getParameter("shopstate");
			   String search_word=request.getParameter("search_word");
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
				    
				   if(eShopSellerShopList==null)
				   {
					   eShopSellerShopList=new EShopSellerShopList();
				   }
				   
				   eShopSellerShopList.setPagenum(pagenum);
				   eShopSellerShopList.setShopstate(Integer.parseInt(shopstate));
				   Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
				
				   UserBasic wqtuser = (UserBasic) user;
				   UEShopShop eShopShop=new UEShopShop();
				   eShopShop.setShopuser(wqtuser.getId());
				   if(!"0".equals(shopstate))
				   {
					   eShopShop.setShopstate(Integer.parseInt(shopstate));
				   }
				   
				   Pagination page=uEShopShopService.selectEShopShopPage(eShopShop, pagination);
				   if(page.getList()!=null && page.getList().size()>0)
				   {
					   eShopSellerShopList.setL_UEShopShop(page.getList());
					   eShopSellerShopList.setShopcount(String.valueOf(page.getCount()));
					   eShopSellerShopList.setShoppage(String.valueOf(page.getAllPage()));
				   }
			   }
			   else
			   {
				   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/shop/wd/seller/list");
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
