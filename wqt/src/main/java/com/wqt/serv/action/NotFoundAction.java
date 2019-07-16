package com.wqt.serv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;


/*404页面处理*/
public class NotFoundAction extends BusinessAction{
    private static final Logger logger = LoggerFactory.getLogger(NotFoundAction.class);
    
    public String notfound()
    {
    	 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 
		 return SUCCESS;
    }

}
