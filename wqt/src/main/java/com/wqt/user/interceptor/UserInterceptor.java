package com.wqt.user.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext; 

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends AbstractInterceptor {
	
	// 拦截Action处理的拦截方法  
    public String intercept(ActionInvocation invocation) throws Exception {  
    	  
        // 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Map<String, Object> session = ctx.getSession();  
        Object user = session.get("LOGINSESSIOIN");

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
     
  
        // 获取此请求的地址          
        StringBuffer url=request.getRequestURL();
        String query = request.getQueryString();
	    if (StringUtils.isNotBlank(query)) {
		   url.append("?").append(query);
         }
	    String fromurl=url.toString();
	    
        
        if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) || request.getParameter("ajax") != null) 
        {
            if(null == user){
            	response.getWriter().write("{\"result\":\"1\",\"fromurl\":\""+fromurl+"\"}");
                return null;
            } 
            else
            {
            	  response.getWriter().write("{\"result\":\"2\",\"fromurl\":\""+fromurl+"\"}");
            	  return null;
            	  //return invocation.invoke();
            }
        }
        else
        {
        	 if(null == user){
        		 response.sendRedirect("http://www.wan7tong.com:8088/wqt/casLogin?service="+fromurl);
        		 return null;
             } 
             else
             {
             	  return invocation.invoke();
             }
        }
    }  
}
