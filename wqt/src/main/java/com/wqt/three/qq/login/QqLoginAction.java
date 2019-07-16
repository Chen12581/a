package com.wqt.three.qq.login;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.common.util.HttpUtils;
import com.wqt.common.util.JsonUtils;
import com.wqt.common.util.StringUtils;
import com.wqt.three.pojo.WqtUserThreeparty;
import com.wqt.three.service.UserThreepartyService;
import com.wqt.user.service.UserBasicService;


public class QqLoginAction   extends BusinessAction{
	   private static final Logger logger = LoggerFactory.getLogger(QqLoginAction.class);
	   
	   /**appID**/
	   private static final String APP_ID = "101518729";
	   
	   private static final String ACCESSTOKEN_URL = "https://graph.qq.com/oauth2.0/token";
	   
	   private static final String APP_KEY="41f1791225cc4cb580ce542bb2acafe9";
	   
	   private static final String REDIRECT_URI="http://www.w7tong.com/qqAuthRedirect";
	   
	   private static final String OpenID_URL="https://graph.qq.com/oauth2.0/me";
	   
	   private static final String USERINFO_URL="https://graph.qq.com/user/get_user_info";
	   
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

	   
	   public String qqAuthRedirect()
	   {
			   HttpServletRequest  request = ServletActionContext.getRequest();
			   HttpServletResponse response = ServletActionContext.getResponse();
			   Session session = SessionFactory.getInstance(request, response);
			   try {
				      String code = request.getParameter("code");
				      String state = request.getParameter("state");
				      String sourcefrom=(String)session.getAttribute("login_sourcefrom");
				      
				      if (StringUtils.isEmpty(state)) 
				      {
				    	  return "404";
					  }
				      else
				      {
				    	    logger.error("sourcefrom =" + sourcefrom);
				    	    Map<String, Object> params = new HashMap<String, Object>();
							params.put("client_id",APP_ID);
							params.put("client_secret", APP_KEY);
							params.put("grant_type", "authorization_code");
							params.put("code", code);
							params.put("redirect_uri",REDIRECT_URI);
							
							String accessTokenReturn = "";
							accessTokenReturn = HttpUtils.URLPost(ACCESSTOKEN_URL, params, HttpUtils.UTF_8);
							
							QQAccessTokenInfo qQAccessTokenInfo = this.getAccessToken(accessTokenReturn);
							logger.error("accessTokenReturn =" + accessTokenReturn);
							
							Map<String, Object> openIdPrams = new HashMap<String, Object>();
							openIdPrams.put("access_token", qQAccessTokenInfo.getAccessToken());

							String openIDReturn = "";
							openIDReturn = HttpUtils.URLPost(OpenID_URL, openIdPrams, HttpUtils.UTF_8);
							logger.error("openIDReturn =" + openIDReturn);
							
							OpenIDReturnInfo openIDReturnInfo = new OpenIDReturnInfo();
							openIDReturnInfo = this.getOpenId(openIDReturn);
							
							Map<String, Object> userInfoParams = new HashMap<String, Object>();
							userInfoParams.put("access_token", qQAccessTokenInfo.getAccessToken());
							userInfoParams.put("oauth_consumer_key", APP_ID);
							userInfoParams.put("openid", openIDReturnInfo.getOpenid());
							String userInfoReturn = "";
							userInfoReturn = HttpUtils.URLPost(USERINFO_URL, userInfoParams, HttpUtils.UTF_8);
							QQUserInfo qqUserInfo = JsonUtils.fromJson(userInfoReturn, QQUserInfo.class);
							if(qqUserInfo!=null)
							{
								qqUserInfo.setOpenId(openIDReturnInfo.getOpenid());
								WqtUserThreeparty wqtUserThreeparty=new WqtUserThreeparty();
							    wqtUserThreeparty.setOpenid(qqUserInfo.getOpenId());
				                wqtUserThreeparty.setKind("2");
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
				                		serviceurl="/user/signup.html?platetype=qq"+
						                		"&openId="+qqUserInfo.getOpenId()+"&sourcefrom="+sourcefrom;
				                	}
				                }
				                else
				                {
				                	serviceurl="/user/signup.html?platetype=qq&"+
					                		"&openId="+qqUserInfo.getOpenId()+"&sourcefrom="+sourcefrom;
				                }
					                
							}
							
				      }
				   
			   } catch (Exception e) {
				   return "404";
				}
	       return SUCCESS;
	   }
	   
	   
	   public OpenIDReturnInfo getOpenId(String url) throws ApiException {
		   OpenIDReturnInfo openIDReturnInfo = new OpenIDReturnInfo();

			Matcher m = Pattern.compile("\"openid\"\\s*:\\s*\"(\\w+)\"").matcher(url);
			if (m.find()) {
				openIDReturnInfo.setOpenid(m.group(1));
			} else {
				throw new ApiException("server error!");
			}
			return openIDReturnInfo;
		}
	   
	   public QQAccessTokenInfo getAccessToken(String url) {
		   QQAccessTokenInfo qQAccessTokenInfo = new QQAccessTokenInfo();
			Matcher m = Pattern.compile("^access_token=(\\w+)&expires_in=(\\w+)&refresh_token=(\\w+)$").matcher(url);
			if (m.find()) {
				qQAccessTokenInfo.setAccessToken(m.group(1));
				qQAccessTokenInfo.setExpireIn(m.group(2));
				qQAccessTokenInfo.setRefreshToken(m.group(3));
			} else {
				Matcher m2 = Pattern.compile("^access_token=(\\w+)&expires_in=(\\w+)$").matcher(url);
				if (m2.find()) {
					qQAccessTokenInfo.setAccessToken(m.group(1));
					qQAccessTokenInfo.setExpireIn(m.group(2));
				}
			}
			return qQAccessTokenInfo;
		}
			

}
