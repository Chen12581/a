package com.wqt.three.wx.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.three.pojo.WqtUserThreeparty;
import com.wqt.three.service.UserThreepartyService;
import com.wqt.user.service.UserBasicService;

/*微信登录*/
public class WxLoginAction  extends BusinessAction{
	   private static final Logger logger = LoggerFactory.getLogger(WxLoginAction.class);
	
	   @Autowired
	   private WxLoginService wxLoginService;
	   
	   @Autowired
       private UserThreepartyService userThreepartyService;
	   
	   @Autowired
       private UserBasicService userBasicService;
	   
	   private  String serviceurl;
	   
	   
	   public String getServiceurl() {
		return serviceurl;
	  }


	  public void setServiceurl(String serviceurl) {
		this.serviceurl = serviceurl;
	  }

	  public String wxAuthredirect()
	  {
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   try {
			   //从request中获取授权信息
		       String authCode = request.getParameter("code");
		      // String appID = request.getParameter("state");
		     
		       String sourcefrom=(String)session.getAttribute("login_sourcefrom");
		       System.out.println("----authCode----"+authCode);
		       System.out.println("---wx---sourcefrom----"+sourcefrom);
		       
		       if (StringUtils.isNotEmpty(authCode)) { //获取access_token
		    	    WxUserInfo wxUserInfo = wxLoginService.weixinLogin(authCode);
		         
	                WqtUserThreeparty wqtUserThreeparty=new WqtUserThreeparty();
	                wqtUserThreeparty.setOpenid(wxUserInfo.getOpenid());
	                wqtUserThreeparty.setKind("3");
	                wqtUserThreeparty=userThreepartyService.selectUserThreepartyOne(wqtUserThreeparty);
	                if(wqtUserThreeparty!=null)
	                {
	                	if(wqtUserThreeparty.getUserid()!=null &&(!"".equals(wqtUserThreeparty.getUserid())))
	                	{
	                		UserBasic userBasic=userBasicService.selectUserById(wqtUserThreeparty.getUserid());
	                		if(userBasic!=null)
	                		{
	                			 UserBasic sessionUser=new UserBasic();
				 				 sessionUser.setId(userBasic.getId());
				 				 sessionUser.setUsername(userBasic.getUsername());
				 				 sessionUser.setMobileno(userBasic.getMobileno());
				 				 sessionUser.setNickname(userBasic.getNickname());
				 				 
				 				 session.setAttribute("LOGINSESSIOIN", sessionUser);
				 				 serviceurl=sourcefrom;
	                		}
	                		else
	                		{
	                			return "404";
	                		}
	                		
	                	}
	                	else
	                	{ 
	                		
	                		serviceurl="/user/signup.html?platetype=wx"+
			                		"&openId="+wxUserInfo.getOpenid()+"&sourcefrom="+sourcefrom;
	                	}
	                }
	                else
	                {
	                	serviceurl="/user/signup.html?platetype=wx"+
		                		"&openId="+wxUserInfo.getOpenid()+"&sourcefrom="+sourcefrom;
	                }
		          }
			   } catch (Exception e) {
				   return "404";
				}
	       return SUCCESS;
	   }
			
	 

}
