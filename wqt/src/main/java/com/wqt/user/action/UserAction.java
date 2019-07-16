package com.wqt.user.action;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import sun.misc.BASE64Encoder;

import com.hessian.HessionFactory;
import com.sms.pojo.Sms;
import com.talkweb.twdpe.base.org.security.PwdEncoder;
import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.common.service.WqtCommonSevice;
import com.wqt.common.util.CommonUtil;
import com.wqt.common.util.EncodeUtils;
import com.wqt.common.util.PropertiesUtil;
import com.wqt.common.util.UUIDGenerator;
import com.wqt.user.email.MailSendUtil;
import com.wqt.user.email.UUIDUtils;
import com.wqt.user.pojo.UserCenterData;
import com.wqt.user.pojo.UsercenterOrder;
import com.wqt.user.service.UserBasicService;
import com.wqt.user.service.UsercenterOrderService;

/*用户相关*/
public class UserAction extends BusinessAction {
	private static final Logger logger = LoggerFactory.getLogger(UserAction.class);
	
	
	/**appID**/
	private static final String APP_ID = "101518729";
	   
	 
	private static final String AUTHORIZE_URL = "https://graph.qq.com/oauth2.0/authorize";
	
	private static final String REDIRECT_URI = "http://www.w7tong.com/qqAuthRedirect";
	   
	/*给登陆密码和支付密码进行安全加密*/
	@Autowired
	private PwdEncoder pwdEncoder;
    
	private String srcurl;
	/*用户基础资料*/
	@Autowired
	private UserBasicService userBasicService;
	
	@Autowired
	private WqtCommonSevice wqtCommonSevice;
	
	private String qqloginurl;  //qq登录的地址
	
	private UserBasic  wqtuser;
	
	private UserCenterData userCenterData;
	
	@Autowired
	private UsercenterOrderService  usercenterOrderService;
	

	public UserCenterData getUserCenterData() {
		return userCenterData;
	}

	public void setUserCenterData(UserCenterData userCenterData) {
		this.userCenterData = userCenterData;
	}

	public  String getSrcurl() {
		return srcurl;
	}

	public  void setSrcurl(String srcurl) {
		this.srcurl = srcurl;
	}

	public String getQqloginurl() {
		return qqloginurl;
	}

	public void setQqloginurl(String qqloginurl) {
		this.qqloginurl = qqloginurl;
	}

	public UserBasic getWqtuser() {
		return wqtuser;
	}

	public void setWqtuser(UserBasic wqtuser) {
		this.wqtuser = wqtuser;
	}

	/*生成4位数随机码*/
	private String getvalidateCode()
	{
		String validateCode="";
		int randomnum;
		Random ne=new Random();//实例化一个random的对象ne 
		randomnum=ne.nextInt(999999-100000+1)+100000;//为变量赋随机值1000-9999
        validateCode=String.valueOf(randomnum);
		return validateCode;
	}
   
	/*
	 *注册短信验证码
	 */
	public String regSmsCode()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   Map resultMap = new HashMap();
		   try {
			   String mobileNo=request.getParameter("mobile");
			   String validateCode = request.getParameter("validateCode");
			   Object code = session.getAttribute("loginValidateCode");
			   if (code == null || !code.equals(validateCode)) 
			   {
				   //验证码不正确
				   resultMap.put("result", "0");
				   resultMap.put("msg", "验证码不正确");
			   }
			   else
			   {
				   session.setAttribute("loginValidateCode",null);
				   if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) || request.getParameter("ajax") != null) 
				   {
					    if(mobileNo!=null && (!"".equals(mobileNo)))
					    {
					    	UserBasic wqtUserBasic=userBasicService.selectUserByMobileNo(mobileNo);
					    	if(wqtUserBasic==null)
					    	{
						       String smscode=getvalidateCode();
						       Sms sms=new Sms();
						       sms.setMobileno(mobileNo);
						       HessionFactory.smsHession().delSms(sms);
						       sms.setContent(smscode);
						       Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						       Date now=new Date();
							   String sendtime=format.format(now);
							   sms.setSendtime(sendtime);
							   Date enddate= new Date(now.getTime()+600000);
							   String endtime=format.format(enddate);
							   sms.setEndtime(endtime);
							   sms.setKind("1");
							   HessionFactory.smsHession().sendSms(sms); 
						       resultMap.put("result", "1");
						       resultMap.put("msg", "发送验证码成功");
					    	}
					    	else
					    	{
					    		resultMap.put("result", "2");
							    resultMap.put("msg", "该手机号已被注册");
					    	}
					    	
					    }
					    else
					    {
					    	 
					    }
			       }
				   else
				   {
					   resultMap.put("result", "0");
					   resultMap.put("msg", "系统忙,请稍后再试");
				   }
			 }
		   }catch (Exception e) {
			     resultMap.put("result", "0");
			     resultMap.put("msg", "系统忙,请稍后再试");
		  }
		 
   		  this.formatData(resultMap);
		  return SUCCESS;
	}
	
	/*用户注册页*/
	public String register()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
	       return SUCCESS;
	}
	
	
	/*
	 *登录、短信验证码
	 */
	public String loginSmsCode()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   Map resultMap = new HashMap();
		   try {
			   String mobileNo=request.getParameter("mobile");
			   String validateCode = request.getParameter("validateCode");
			   Object code = session.getAttribute("loginValidateCode");
			   if (code == null || !code.equals(validateCode)) 
			   {
				   //验证码不正确
				   resultMap.put("result", "0");
				   resultMap.put("msg", "验证码不正确");
			   }
			   else
			   {
				   //session.setAttribute("loginValidateCode",null);
				   if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) || request.getParameter("ajax") != null) 
				   {
					    if(mobileNo!=null && (!"".equals(mobileNo)))
					    {
						       String smscode=getvalidateCode();
						       Sms sms=new Sms();
						       sms.setMobileno(mobileNo);
						       HessionFactory.smsHession().delSms(sms);
						       sms.setContent(smscode);
						       Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						       Date now=new Date();
							   String sendtime=format.format(now);
							   sms.setSendtime(sendtime);
							   Date enddate= new Date(now.getTime()+600000);
							   String endtime=format.format(enddate);
							   sms.setEndtime(endtime);
							   sms.setKind("1");
							   HessionFactory.smsHession().sendSms(sms); 
						       resultMap.put("result", "1");
						       resultMap.put("msg", "发送验证码成功");
					    }
					    else
					    {
					    	 resultMap.put("result", "2");
							 resultMap.put("msg", "系统忙,请稍后再试");
					    }
			       }
				   else
				   {
					   resultMap.put("result", "2");
					   resultMap.put("msg", "系统忙,请稍后再试");
				   }
			 }
		   }catch (Exception e) {
			     resultMap.put("result", "2");
			     resultMap.put("msg", "系统忙,请稍后再试");
		  }
		 
   		  this.formatData(resultMap);
		  return SUCCESS;
	}
	
	/**
	 * 获取一个范围内的随机数字
	 * @return
	 */
	private  int getRadomInt(int min,int max){
		Random rand=new Random();
		return rand.nextInt(max-min+1)+min;
	}
	
	/**
	 * 随机获取一个小写字母
	 * @param args
	 */
	private  char getLetter(){
		Random rand=new Random();
		char c=(char)(rand.nextInt(122-97+1)+97);
		//char c=(char)getRadomInt(97, 122);
		return c;
	}
	
	/*用户手机登录*/
	public String mobilelogin()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   Map resultData = new HashMap();
		   try {
				   String service=request.getParameter("service");
				   String mobile=request.getParameter("mobile");
				   String smscode=request.getParameter("smscode");
				   String validateCode = request.getParameter("validateCode");
			       Object code = session.getAttribute("loginValidateCode");
				   if (code == null || !code.equals(validateCode)) 
				   {
					 // 验证码不正确
					 resultData.put("result","5");
	        		 resultData.put("msg","验证码不正确");
				   }
				   else
				   {
					   if(mobile!=null && (!"".equals(mobile)) && smscode!=null && (!"".equals(smscode)))
					   {
						   Sms sms=new Sms();
						   sms.setMobileno(mobile);
						   sms.setContent(smscode);
						   sms.setEndtime("1");
						   sms= HessionFactory.smsHession().querySms(sms);
					       if(sms!=null)
					       {
					    	   UserBasic userBasic=userBasicService.selectUserByMobileNo(mobile);
					    	   if(userBasic==null)
					    	   {
					    		   UserBasic ruserBasic=new UserBasic();
					    		   String username="w7t_"+getLetter()+mobile.substring(3);
					    		   ruserBasic.setUsername(username);
					    		   ruserBasic.setNickname(username);
					    		   ruserBasic.setMobileno(mobile);
					    		   ruserBasic.setPassword(mobile);
						    	   userBasicService.insertUserBasic(ruserBasic);
						    	   userBasic= userBasicService.selectUserByMobileNo(mobile);
					    	   }
		                       // 保存用户信息到Session
					    	   UserBasic user=new UserBasic();
							   user = new UserBasic();
							   user.setId(userBasic.getId());
							   user.setUsername(userBasic.getUsername());
							   user.setMobileno(userBasic.getMobileno());
							   user.setNickname(userBasic.getNickname());
							   //保存用户信息到自己应用的Session
							   session.setAttribute("LOGINSESSIOIN", user);
							   if(service!=null && (!"".equals(service)))   
							   {
								   //如果后面有源页面,需要跳转到登录前的页面
								   resultData.put("result","3");
					        	   resultData.put("msg",service);
							  }
							  else
							  {
								  //如果后面没有源页面,就跳转到用户中心
								  resultData.put("result","3");
					        	  resultData.put("msg","http://www.w7tong.com");
							  }
					       }
					       else
					       {
					    	   resultData.put("result","1");
							   resultData.put("msg","手机验证码不正确");
					       }
					   }
					   else
					   {
						   resultData.put("result","2");
						   resultData.put("msg","登录失败,请稍后再试 ");
					   }
				   }
		   } catch (Exception e) {
				resultData.put("result","0");
				resultData.put("msg","登陆失败,请稍后再试");
		  }
		   this.formatData(resultData);
		   return SUCCESS;
	}
	
	public String tologin()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   
		   String sourefrom=request.getParameter("service");
		   if(sourefrom!=null && (!"".equals(sourefrom)))
		   {
			   session.setAttribute("login_sourcefrom", sourefrom); 
		   }
		   
		   String state = UUIDGenerator.getUUID();
		   session.setAttribute("qq_connect_state", state);
		   qqloginurl=AUTHORIZE_URL+"?client_id=" + APP_ID
					+ "&redirect_uri=" + EncodeUtils.urlEncode(REDIRECT_URI) + "&response_type=code"
					+ "&state=" + state + "&scope= get_user_info";
		   return SUCCESS;
	}
	
	/*用户登录*/
	public String userlogin()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   String service=request.getParameter("service");
		   Map resultData = new HashMap();
		   try {
			     String userparam=request.getParameter("userparam");
			     String password=request.getParameter("password");
			     String validateCode = request.getParameter("validateCode");
			     Object code = session.getAttribute("loginValidateCode");
				 if (code == null || !code.equals(validateCode)) 
				 {
					 // 验证码不正确
					 resultData.put("result","5");
	        		 resultData.put("msg","验证码不正确");
				 }
				 else
				 {
					 if(userparam!=null && (!"".equals(userparam)) && password!=null && (!"".equals(password)))
					 {
						 UserBasic userBasic=userBasicService.userLogin(userparam);
				         if(userBasic!=null)
				         {
				        	 if(userBasic.getPassword().equals(password))  //pwdEncoder.encodePassword(password))
				        	 {
				        		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 				 Date date = new Date();
				 				 String lastlogindate = sdf.format(date);
				 				 UserBasic lUserBasic=new UserBasic();
				 				 lUserBasic.setId(userBasic.getId());
				 				 lUserBasic.setLastlogindate(lastlogindate);
				 				 userBasicService.updateUserBasic(lUserBasic);
				 				 
				 				 UserBasic sessionUser=new UserBasic();
				 				 sessionUser.setId(userBasic.getId());
				 				 sessionUser.setUsername(userBasic.getUsername());
				 				 sessionUser.setMobileno(userBasic.getMobileno());
				 				 sessionUser.setNickname(userBasic.getNickname());
				        		/* Map<String, Object> userMap = new HashMap<String, Object>();
								 userMap.put("id", userBasic.getId());
								 userMap.put("username", userBasic.getUsername());
								 userMap.put("username", userBasic.getUsername());*/
								 session.setAttribute("LOGINSESSIOIN", sessionUser);
							
								 if(service!=null && (!"".equals(service)))   
								 {
									  //如果后面有源页面,需要跳转到登录前的页面
									 resultData.put("result","3");
					        		 resultData.put("msg",service);
									 //response.sendRedirect(service);
									 //return null;
								 }
								 else
								 {
									 //如果后面没有源页面,就跳转到用户中心
									 //response.sendRedirect("http://www.w7tong.com");
									 //return null;
									 
									 resultData.put("result","3");
					        		 resultData.put("msg","http://www.w7tong.com");
								 }
				        	 }
				        	 else
				        	 {
				        		  //密码不正确
				        		 resultData.put("result","2");
				        		 resultData.put("msg","密码不正确");
				        	 }
				         }
				         else
				         {
				        	 //用户不存在
				        	 resultData.put("result","1");
				        	 resultData.put("msg","用户不存在");
				         }
					 }
					 else
					 {
						 resultData.put("result","3");
						 resultData.put("msg","参数不正确");
					 }
				 }
	       } catch (Exception e) {
				resultData.put("result","0");
				resultData.put("msg","登陆失败");
		  }
		   this.formatData(resultData);
		   return SUCCESS;
	}

	
	public String autoLoginCas()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   String sourcefrom=request.getParameter("sourcefrom");
		   String username=request.getParameter("username");
		   String password=request.getParameter("password");
		 
		   srcurl=PropertiesUtil.rs.getProperty("casserver")+"/registerLogin?myaccount="+username+"&mypass="+password+"&service="+sourcefrom;
	       return SUCCESS;
	}
	
	
	/*
	 * wqtuserbasic  用户
	 * 编辑用户信息
	 */
	public String editUser()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   Object sessionUser = session.getAttribute("LOGINSESSIOIN");
					
		   // 获取此请求的地址          
		   StringBuffer url=request.getRequestURL();
		   String srcurl=url.toString();
		   srcurl=srcurl.substring(0, srcurl.indexOf("editUser"));
		   Map map = new HashMap();
		   try {
			     if(sessionUser!=null)
			     {
			    	  UserBasic wqtUserBasic = (UserBasic) sessionUser;
			    	  wqtuser.setId(wqtUserBasic.getId());
				      userBasicService.updateUserBasic(wqtuser);
				      map.put("result","1");
				      map.put("msg","您的信息保存成功");
			     }
			     else
			     {
			    	    response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+srcurl+"/user/personalinfo");
						return null;
			     }
		   }catch (Exception e) {
			    map.put("result","3");
			    map.put("msg","您的信息保存失败");
				request.setAttribute("throw", e);
				//this.setErrorMessage("验证手机号码失败", e);
				logger.error(e.getMessage(), e);
				e.printStackTrace();
		  }
   		  this.formatData(map);
		  return SUCCESS;
	}
	
	/*跳转到用户修改密码页面*/
	public String modifypassword()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
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
				    response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/password");
					return null;
			   }
			}
		    catch(Exception e)
			{
		    	return "404";
			}
	}
	
	/*确认用户手机号码*/
	public String confirmUserMobile()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		   String smscode=request.getParameter("smscode");
		   Map map = new HashMap();
		   if(user!=null)
		   {
				wqtuser=(UserBasic) user;
				Sms sms=new Sms();
				sms.setMobileno(wqtuser.getMobileno());
				sms.setContent(smscode);
				sms.setEndtime("1");
				sms=HessionFactory.smsHession().querySms(sms); 
			    if(sms!=null)
			    {
			    	  map.put("result","1");
		        	  map.put("msg","验证码正确");
			    }
			    else
			    {
			    	map.put("result","2");
		        	map.put("msg","验证码不正确");
			    }
		   }
		   else
		   {
			    map.put("result","0");
	        	map.put("msg","系统忙,请稍后再试 "); 
		   }
		   this.formatData(map);
		   return SUCCESS;
	}
	
	public String updateUserMobile()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		   String smscode=request.getParameter("smscode");
		   String mobile=request.getParameter("mobile");
		   Map map = new HashMap();
		   if(user!=null)
		   {
				wqtuser=(UserBasic) user;
				Sms sms=new Sms();
				sms.setMobileno(mobile);
				sms.setContent(smscode);
			    sms.setEndtime("1");
				sms=HessionFactory.smsHession().querySms(sms); 
			    if(sms!=null)
			    {
			    	  UserBasic wqtUserBasic=new UserBasic();
			    	  wqtUserBasic.setId(wqtuser.getId());
			    	  wqtUserBasic.setMobileno(mobile);
			    	  userBasicService.updateUserBasic(wqtUserBasic);
			    	  map.put("result","1");
		        	  map.put("msg","修改完成");
			    }
			    else
			    {
			    	map.put("result","2");
		        	map.put("msg","验证码不正确");
			    }
		   }
		   else
		   {
			    map.put("result","0");
	        	map.put("msg","系统忙,请稍后再试 "); 
		   }
		   this.formatData(map);
		   return SUCCESS;
	}

	/*
	 * mobile  用户手机号码 
	 * 验证手机号码是否已注册
	 */
	public String checkMobile()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Map map = new HashMap();
		   String mobileno=request.getParameter("mobileno");
		   try {
			    if(CommonUtil.isInteger(mobileno))
			    {
			     if(mobileno!=null && !"".equals(mobileno.trim()))
			     {
				      UserBasic wqtUserBasic=new UserBasic();
				      wqtUserBasic.setMobileno(mobileno);
				      List<UserBasic> l=userBasicService.selectListUserBasic(wqtUserBasic);
			          if(l.size()>0)
			          {
			        	  map.put("result","1");
			        	  map.put("msg","手机号码已注册");
			          }
			          else
			          {
			        	  map.put("result","2");
			        	  map.put("msg","手机号码可注册");
			          }
			     }
			     else
			     {
			    	 map.put("result","3");
		        	 map.put("msg","系统忙,请稍后再试");
			     }
			    }
			    else
			    {
			    	 map.put("result","3");
		        	 map.put("msg","系统忙,请稍后再试");
			    }
		   }catch (Exception e) {
			     map.put("result","0");
	        	 map.put("msg","系统忙,请稍后再试");
		  }
   		  this.formatData(map);
		  return SUCCESS;
	}
	
	/*
	 * username  用户名
	 * 验证手机号码是否已注册
	 */
	public String checkUsername()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		   Map map = new HashMap();
		   String username=request.getParameter("username");
		   try {
			    if(user!=null)
			    {
				     if(username!=null && !"".equals(username.trim()))
				     {
					      UserBasic wqtUserBasic=new UserBasic();
					      wqtUserBasic.setUsername(username);
					      List<UserBasic> l=userBasicService.selectListUserBasic(wqtUserBasic);
				          if(l.size()>0)
				          {
				        	  map.put("result","1");
				        	  map.put("msg","用户名已使用");
				          }
				          else
				          {
				        	  map.put("result","2");
				        	  map.put("msg","用户名可使用");
				          }
				     }
				     else
				     {
				    	 map.put("result","3");
			        	 map.put("msg","系统忙,请稍后再试");
				     }
			    }
			    else
			    {
			    	map.put("result","0");
		        	map.put("msg","系统忙,请稍后再试");
			    }
		   }catch (Exception e) {
			     map.put("result","0");
	        	 map.put("msg","系统忙,请稍后再试");
		  }
   		  this.formatData(map);
		  return SUCCESS;
	}
	/*用户注册*/
	public String userReg()
	{  
		   HttpServletRequest request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   Map resultData = new HashMap();
		   try {
			       Sms sms=new Sms();
		           sms.setMobileno(wqtuser.getMobileno());
		           sms.setContent(wqtuser.getSmscode());
		           sms.setEndtime("1");
			       sms=HessionFactory.smsHession().querySms(sms); 
		           if(sms!=null)
			       {
			    	   Map map=new HashMap();
			    	   String username="w7t_"+getLetter()+wqtuser.getMobileno().substring(3);
			    	   wqtuser.setUsername(username);
			    	   wqtuser.setNickname(username);
			    	   String encryptusername = null;  
			    	   encryptusername = new BASE64Encoder().encode(username.getBytes()); // 加密后  
			    	   map.put("username", encryptusername);
			    	   String encryptpassword = null;  
			    	   encryptpassword = new BASE64Encoder().encode(wqtuser.getPassword().getBytes()); 
			    	   map.put("password", encryptusername);
			    	   userBasicService.insertUserBasic(wqtuser);
                       wqtuser= userBasicService.selectUserByMobileNo(wqtuser.getMobileno());
			    	   
                       // 保存用户信息到Session
			    	   UserBasic user=new UserBasic();
					   user = new UserBasic();
					   user.setId(wqtuser.getId());
					   user.setUsername(wqtuser.getUsername());
					   user.setMobileno(wqtuser.getMobileno());
					   user.setNickname(wqtuser.getNickname());
					   //保存用户信息到自己应用的Session
					   session.setAttribute("LOGINSESSIOIN", user);
					   resultData.put("result", 1);
			    	   resultData.put("user",map);
			       }
			       else    //验证码过期或者错误
			       {
			    	   resultData.put("result",2);
			    	   resultData.put("msg", "验证码错误或者超过有效时间");
			       }
		   } catch (Exception e) {
				 resultData.put("result",0);
				 resultData.put("msg", "系统忙，请稍后再试");
		   }
		   this.formatData(resultData);
           return SUCCESS;
	}
	
	/*用户注销*/
	@SuppressWarnings("unchecked")
	public String loginOut() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Session session = SessionFactory.getInstance(request, response);
		session.invalidate();
		return SUCCESS;
	}
	
	//用户中心主页面
	public String userCenter()
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
				wqtuser=(UserBasic) user;
				if(userCenterData==null)
				  userCenterData=new UserCenterData();
				UserBasic userbasic=userBasicService.selectUserById(wqtuser.getId());
				userCenterData.setUserbasic(userbasic);
				
				Pagination pagination = new Pagination(1, 10);
				UsercenterOrder usercenterOrder=new UsercenterOrder();
				usercenterOrder.setBuyerid(wqtuser.getId());
				Pagination page=usercenterOrderService.selectUserCenterOrderPage(usercenterOrder, pagination); 
				if(page.getList()!=null && page.getList().size()>0)
				{
					userCenterData.setL_UsercenterOrder(page.getList());
				}
				
				return SUCCESS;
			}
			else
			{
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/center");
				return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	}
	
	
	//用户基本信息页面
	public String userBasic()
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
				wqtuser=(UserBasic) user;
				wqtuser=userBasicService.selectUserById(wqtuser.getId());
				return SUCCESS;
			}
			else
			{
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/personalinfo");
				return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	}
	
	/*跳转到修改手机号页面*/
    public String modifymobile()
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
				wqtuser=(UserBasic) user;
				return SUCCESS;
			}
			else
			{
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/mobile");
				return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
		
    }
    
    
    /*跳转到绑定邮箱页面*/
    public String findemail()
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
				wqtuser=(UserBasic) user;
				return SUCCESS;
			}
			else
			{
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/email");
				return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
    }
    
    public String verityEmail()
    {
    	HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String emailcode=request.getParameter("emailcode");
		String resultMsg="";
		if(emailcode!=null && (!"".equals(emailcode)))
		{
		     UserBasic userBasic=new UserBasic();
		     userBasic.setEmailcode(emailcode);
		     List<UserBasic> l_user=userBasicService.selectListUserBasic(userBasic);
		     if(l_user!=null && l_user.size()>0)
		     {
		    	 userBasic=l_user.get(0);
		    	 userBasic.setCheckemail("2");
		    	 userBasicService.updateUserBasic(userBasic);
		    	 resultMsg="恭喜您,您的邮箱激活成功";
		     }
	    	
		 }
		 else
		 {
			 resultMsg="系统忙,请稍后再试";
		 }
		 this.formatData(resultMsg);
	     return SUCCESS;
    }
    
    
    public String bandEmail()
    {
    	HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Session session = SessionFactory.getInstance(request, response);
		Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		String email=request.getParameter("email");
		Map resultData = new HashMap();

		 try
		 {
			if(user!=null)
			{
				 if(email!=null && (!"".equals(email)))
				 {
				     wqtuser=(UserBasic) user;
				     UserBasic userBasic=new UserBasic();
				     userBasic.setId(wqtuser.getId());
				     userBasic.setEmail(email);
				     userBasic.setEmailcode(UUIDUtils.getUUID());
				     userBasicService.updateUserBasic(userBasic);
				     new Thread(new MailSendUtil(email, userBasic.getEmailcode())).start();
				     resultData.put("result",1);
			    	 resultData.put("msg","您的邮箱将收到我们发送一份激活邮件,请点击链接激活邮箱");
				 }
				 else
				 {
					 resultData.put("result",2);
			    	 resultData.put("msg","系统忙,请稍后再试");
				 }
			}
			else
			{
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service=http://www.w7tong.com/user/email");
				return null;
			}
			 
		 }
		 catch(Exception e)
		 {
			 resultData.put("result",0);
	    	 resultData.put("msg","系统忙,请稍后再试");
		 }
		 this.formatData(resultData);
		return SUCCESS;
    }
    	
	/*跳转到找回密码页面*/
    public String findPassword()
    {
   	     HttpServletRequest  request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 Session session = SessionFactory.getInstance(request, response);
		 Object sessionUser = session.getAttribute("LOGINSESSIOIN");
		 wqtuser = (UserBasic) sessionUser;
		 
		return SUCCESS;
    }
    
    /*跳转到找回密码页面*/
    public String findPasswordnext()
    {
   	     HttpServletRequest  request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 Session session = SessionFactory.getInstance(request, response);
		 Object sessionUser = session.getAttribute("LOGINSESSIOIN");
		 String smscode=request.getParameter("smscode");
		 String mobile=request.getParameter("mobile");
		 Map resultData = new HashMap();
		 try
		 {
			 if(mobile!=null && (!"".equals(mobile)) && smscode!=null && (!"".equals(smscode)))
			 {
				 Sms sms=new Sms();
			     sms.setMobileno(mobile);
			     sms.setContent(smscode);
			     sms.setEndtime("1");
			     sms=HessionFactory.smsHession().querySms(sms); 
			     if(sms!=null)
		         {
		        	 resultData.put("result", 1);
			    	 resultData.put("msg","验证码正确");
		         }
		         else
		         {
		        	 resultData.put("result",2);
			    	 resultData.put("msg","验证码错误");
		         }
			 }
			 else
			 {
				 resultData.put("result",0);
		    	 resultData.put("msg","系统忙,请稍后再试");
			 }
		 }
		 catch(Exception e)
		 {
			 resultData.put("result",0);
	    	 resultData.put("msg","系统忙,请稍后再试");
		 }
		 this.formatData(resultData);
		 return SUCCESS;
    }
	
    //修改用户密码
    public String updatePassword()
    {
    	 HttpServletRequest  request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 Session session = SessionFactory.getInstance(request, response);
		 Object sessionUser = session.getAttribute("LOGINSESSIOIN");
		 String mobile=request.getParameter("mobile");
		 String password=request.getParameter("password");
		 Map resultData = new HashMap();
		 try
		 {
			 if(mobile!=null && (!"".equals(mobile)) && password!=null && (!"".equals(password)))
			 {
				 UserBasic userbasic=userBasicService.selectUserByMobileNo(mobile);
				 if(userbasic!=null)
				 {
					 UserBasic updateuser=new UserBasic();
					 updateuser.setPassword(password);
					 updateuser.setId(userbasic.getId());
					 userBasicService.updateUserBasic(updateuser);
					 resultData.put("result",1);
			    	 resultData.put("msg","您的账号密码已经重置成功");
				 }
				 else
				 {
					 resultData.put("result",2);
			    	 resultData.put("msg","您的账号不存在,请确认");
				 }
			 }
			 else
			 {
				 resultData.put("result",0);
		    	 resultData.put("msg","系统忙,请稍后再试");
			 }
		 }
		 catch(Exception e)
		 {
			 resultData.put("result",0);
	    	 resultData.put("msg","系统忙,请稍后再试");
		 }
		 this.formatData(resultData);
		 return SUCCESS;
    }
    
    public static void main(String[] args)
    {
	 // Date now = new Date();
	 // SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd");
	  //String s = outFormat.format(now);
	
	
	 // String userid = UUID.randomUUID().toString().replaceAll("-", "");
	 // System.out.println(userid);
    	UserAction tt=new UserAction(); 
    	System.out.println(tt.getLetter());
	  
   }
}
