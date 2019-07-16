package com.wqt.three.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.hessian.HessionFactory;
import com.sms.pojo.Sms;
import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.common.service.WqtCommonSevice;
import com.wqt.three.pojo.WqtUserThreeparty;
import com.wqt.three.service.UserThreepartyService;
import com.wqt.user.service.UserBasicService;

public class ThreeLoginAction   extends BusinessAction{
	  private static final Logger logger = LoggerFactory.getLogger(ThreeLoginAction.class);
	  
      @Autowired
      private UserBasicService userBasicService;
      
      @Autowired
      private UserThreepartyService userThreepartyService;
      
      @Autowired
      private WqtCommonSevice wqtCommonSevice;
      
	  public String threeLoginCheck()
	  {
		    HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
		    Session session = SessionFactory.getInstance(request, response);
		    
			   
		    return SUCCESS;
	  }
	  
	  
	  public String threeLoginOauth()
	  {
		    HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
		    Session session = SessionFactory.getInstance(request, response);
		    
			   
		    return SUCCESS;
	  }
	  
	  /*第三方账号与平台账号关联*/
	  public String  relateW7tongUser()
	  {
		    HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			Session session = SessionFactory.getInstance(request, response);
		    Map resultMap = new HashMap();
		    try {
				   String mobileNo=request.getParameter("mobile");
				   String openId=request.getParameter("openId");
				   String nickName=request.getParameter("nickName");
				   String sourcefrom=request.getParameter("sourcefrom");
				   String platetype=request.getParameter("platetype");
				   String smsCode = request.getParameter("smsCode");
				   String validateCode = request.getParameter("validateCode");
			       Object code = session.getAttribute("loginValidateCode");
				   if (code == null || !code.equals(validateCode)) 
				   {
					  // 验证码不正确
					   resultMap.put("result","3");
					   resultMap.put("msg","验证码不正确");
				   }
				   else
				   {
					   if (smsCode != null && !"".equals(smsCode) && mobileNo != null && !"".equals(mobileNo)
							   && openId!= null && !"".equals(openId) && platetype!= null && !"".equals(platetype)) 
					   {
						   if("alipay".equals(platetype) || "qq".equals(platetype) || "wx".equals(platetype) || "wb".equals(platetype))
						   {   
							       Sms sms=new Sms();
							       sms.setMobileno(mobileNo);
							       sms.setContent(smsCode);
							       sms.setEndtime("1");
							       sms=HessionFactory.smsHession().querySms(sms); 
								   if(sms!=null)
							       {
							    	   String kind="";
							    	   String kindname="";
							    	   if("alipay".equals(platetype))
						               {
						                	 kind="4";
						                	 kindname="支付宝";
						               }
						               else if("qq".equals(platetype))
						               {
						                	 kind="2";
						                	 kindname="qq";
						               }
						               else if("wx".equals(platetype))
						               {
						                	 kind="3";
						                	 kindname="微信";
						               }
						               else if("wb".equals(platetype))
						               {
						                	 kind="1";
						                	 kindname="微博";
						               }
							    	   
									   UserBasic userBasic=userBasicService.selectUserByMobileNo(mobileNo);
									   if(userBasic!=null)
				               		   {
										     WqtUserThreeparty wqtUserThreeparty1=new WqtUserThreeparty();
								    	     wqtUserThreeparty1.setKind(kind);
								    	     wqtUserThreeparty1.setUserid(userBasic.getId());
								    	     List<WqtUserThreeparty> l_WqtUserThreeparty=userThreepartyService.selectUserThreepartyList(wqtUserThreeparty1);
								    	     if(l_WqtUserThreeparty!=null && l_WqtUserThreeparty.size()>0)
								    	     {
								    	    	    resultMap.put("result", "4");
								    	    	    resultMap.put("msg",mobileNo+"已关联了"+kindname+",请换一个注册手机号");
											   
								    	     }
								    	     else
								    	     {
								    	    	     WqtUserThreeparty wqtUserThreeparty=new WqtUserThreeparty();
									                 wqtUserThreeparty.setOpenid(openId);
									                 wqtUserThreeparty.setUserid(userBasic.getId());
									                 wqtUserThreeparty.setKind(kind);
									                 
									                 userThreepartyService.insertUserThreeparty(wqtUserThreeparty);
									                 UserBasic sessionUser=new UserBasic();
									 				 sessionUser.setId(userBasic.getId());
									 				 sessionUser.setUsername(userBasic.getUsername());
									 				 sessionUser.setMobileno(userBasic.getMobileno());
									 				 sessionUser.setNickname(userBasic.getNickname());
									 				 session.setAttribute("LOGINSESSIOIN", sessionUser);
									 				 
									 				 resultMap.put("result", "1");
									 				 if(sourcefrom!=null && (!"".equals(sourcefrom.trim())))
									 				 {
									 					resultMap.put("msg",sourcefrom);
									 				 }
									 				 else
									 				 {
									 					resultMap.put("msg","http://www.m7tong.com");
									 				 }
								    	     }
				               		   }
							       }
							       else
							       {
							    	   resultMap.put("result","2");
							    	   resultMap.put("msg","手机验证码不正确");
							       }
						   }
						   else
						   {
							   return "404";
						   }
					   }
					   else
					   {
						   return "404";
					   }
				   }
				   
		    }
		    catch(Exception e)
		    {
		    	return "404";
		    }
		    this.formatData(resultMap); 
			return SUCCESS;
	  }
	  
}
