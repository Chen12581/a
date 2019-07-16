package com.wqt.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.wqt.common.util.PropertiesUtil;

public class UserSecurityAction extends BusinessAction{
	private static final Logger logger = LoggerFactory.getLogger(UserSecurityAction.class);
	
	/*安全设置页面*/
	public String userSecurity() {
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
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/security");
				return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	}
}
