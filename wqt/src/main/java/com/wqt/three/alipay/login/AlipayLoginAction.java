package com.wqt.three.alipay.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.three.pojo.WqtUserThreeparty;
import com.wqt.three.service.UserThreepartyService;
import com.wqt.user.service.UserBasicService;

public class AlipayLoginAction  extends BusinessAction{
	
	   @Autowired
       private AlipayLoginService alipayLoginService;
	   
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


	  public String authredirect()
	  {
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   try {
			   //从request中获取授权信息
		       String authCode = request.getParameter("auth_code");
		       String appID = request.getParameter("app_id");
		       String scope = request.getParameter("scope");
		       String sourcefrom=request.getParameter("sourcefrom");
		       System.out.println("----authCode----"+authCode);
		       
		       if (StringUtils.isNotEmpty(authCode)) { //获取access_token
		            String accessToken = alipayLoginService.getAccessToken(authCode);
		            //获取用户信息
		            if (StringUtils.isNotEmpty(accessToken)) { //获取用户信息
		                AlipayUserInfo alipayUser = alipayLoginService.getUserInfoByToken(accessToken);
		                
		                WqtUserThreeparty wqtUserThreeparty=new WqtUserThreeparty();
		                wqtUserThreeparty.setOpenid(alipayUser.getOpenId());
		                wqtUserThreeparty.setKind("4");
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
		                		serviceurl="/user/signup.html?platetype=alipay"+
				                		"&openId="+alipayUser.getOpenId()+"&sourcefrom="+sourcefrom;
		                	}
		                }
		                else
		                {
		                	serviceurl="/user/signup.html?platetype=alipay&"+
			                		"&openId="+alipayUser.getOpenId()+"&sourcefrom="+sourcefrom;
		                }
		                
		                
		                
		            } 
		          }
			   } catch (Exception e) {
				   return "404";
				}
	       return SUCCESS;
	   }
			
	 

}
