package com.wqt.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.outurl.pojo.OutUrl;
import com.talkweb.twdpe.core.cache.CacheManager;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.user.pojo.UserBasic;
import com.wqt.common.util.CommonUtil;
import com.worker.pojo.Worker;

public class WorkerServiceInterceptor extends AbstractInterceptor {
	
    


	// 拦截Action处理的拦截方法  
    public String intercept(ActionInvocation invocation) throws Exception {  
    	  
        // 取得请求相关的ActionContext实例  
       // ActionContext ctx = invocation.getInvocationContext();  
    	HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST); 
    	HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(ServletActionContext.HTTP_RESPONSE); 
    	Session session = SessionFactory.getInstance(request, response);
		Object sessionUser = session.getAttribute("LOGINSESSIOIN");
		UserBasic wqtuser = (UserBasic) sessionUser;
       
		CacheManager _workercache = CacheManager.getInstance();
	    String  workercacheKey = CommonUtil.WORKERS_CACHE+".key";
	    List<Worker> l_WqtWorker = (List<Worker>)_workercache.getObject(CommonUtil.WORKERS_CACHE, workercacheKey);
	    List<Worker> l_servicewqtworker=CommonUtil.createRandomList(l_WqtWorker,6);
	    
	    List<Worker> l_wqtworker=CommonUtil.createRandomList(l_WqtWorker,1);
	    
	    String  outurlcacheKey = CommonUtil.OUTURL_CACHE+".key";
	    List<OutUrl> l_OutUrl = (List<OutUrl>)_workercache.getObject(CommonUtil.OUTURL_CACHE, outurlcacheKey);
	    
	    request.setAttribute("wqt_serviceworker", l_servicewqtworker);
	    request.setAttribute("wqtworker", l_wqtworker.get(0));
	    request.setAttribute("wqtuser", wqtuser);
	    request.setAttribute("wqtouturl", l_OutUrl);
	    
        return invocation.invoke();
    }  
}
