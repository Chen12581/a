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
import com.wqt.user.pojo.CapitalAccountList;
import com.wqt.user.pojo.WqtCapitalAccount;
import com.wqt.user.service.CapitalAccountService;

public class UserCapitalAction  extends BusinessAction{
	private static final Logger logger = LoggerFactory.getLogger(UserCapitalAction.class);
	
	private CapitalAccountList capitalAccountList;
	
	@Autowired
	private CapitalAccountService capitalAccountService;
	public CapitalAccountList getCapitalAccountList() {
		return capitalAccountList;
	}

	public void setCapitalAccountList(CapitalAccountList capitalAccountList) {
		this.capitalAccountList = capitalAccountList;
	}


	public String userCapitalList()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		serverurl=serverurl.substring(0, serverurl.indexOf("/user/"));
	    String pagenum=request.getParameter("pagenum");
	    try {
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
				   
				   UserBasic wqtuser=(UserBasic) user;
				   WqtCapitalAccount wqtCapitalAccount=new WqtCapitalAccount();
				   wqtCapitalAccount.setUserid(wqtuser.getId());
                  
				   if(capitalAccountList==null)
				   {
					   capitalAccountList=new CapitalAccountList();
				   }
				   capitalAccountList.setPagenum(pagenum);
				   Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
				   
				   Pagination page = null;
				   page=capitalAccountService.selectCapitalAccountPage(wqtCapitalAccount, pagination);
				  
				   if(page.getList()!=null && page.getList().size()>0)
				   {
					   capitalAccountList.setL_WqtCapitalAccount(page.getList());
					   capitalAccountList.setAccountcount(String.valueOf(page.getCount()));
					   capitalAccountList.setAccountpage(String.valueOf(page.getAllPage()));
				   }
	           }
			   else
			   {
				   if(pagenum!=null && (!"".equals(pagenum.trim())))
				   {
				        response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/capital/"+pagenum);
				   }
				   else
				   {
					   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/capital");
				   }
				   return null;
			   }
		   } catch (Exception e) {
				e.printStackTrace();
			}
		return SUCCESS;
	}
	
	//用户充值
	public String userRecharge()
	{

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Session session = SessionFactory.getInstance(request, response);
		Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		// 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		serverurl=serverurl.substring(0, serverurl.indexOf("/user/"));
		try
		{
			if(user!=null)
			{
				return SUCCESS;
			}
			else
			{
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/recharge");
				return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	
	}
	
	
	//用户充值
	public String userWithDraw()
	{

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Session session = SessionFactory.getInstance(request, response);
		Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		// 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		serverurl=serverurl.substring(0, serverurl.indexOf("/user/"));
		try
		{
			if(user!=null)
			{
				return SUCCESS;
			}
			else
			{
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/withdraw");
				return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	
	}	
}
