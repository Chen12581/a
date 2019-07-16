package com.wqt.user.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.hessian.HessionFactory;
import com.sms.pojo.Sms;
import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.common.service.WqtCommonSevice;
import com.wqt.common.util.CommonUtil;
import com.wqt.common.util.PropertiesUtil;
import com.wqt.user.pojo.UserBankData;
import com.wqt.user.pojo.WqtUserBank;
import com.wqt.user.service.UserBankService;

public class UserBankAction extends BusinessAction{
	
	private static final Logger logger = LoggerFactory.getLogger(UserBankAction.class);
    
	@Autowired
	private UserBankService userBankService;
	
	@Autowired
	private WqtCommonSevice wqtCommonSevice;
	
	
	private UserBankData userBankData;
	
	private WqtUserBank userBank;
	
	public WqtUserBank getUserBank() {
		return userBank;
	}

	public void setUserBank(WqtUserBank userBank) {
		this.userBank = userBank;
	}

	public UserBankData getUserBankData() {
		return userBankData;
	}

	public void setUserBankData(UserBankData userBankData) {
		this.userBankData = userBankData;
	}



	/*用户绑定银行卡*/
	public String usersBank() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Session session = SessionFactory.getInstance(request, response);
		Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		// 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		serverurl=serverurl.substring(0, serverurl.indexOf("/user/"));
		String pagenum=request.getParameter("pagenum");
		try
		{
			if(user!=null)
			{
			   if(userBankData==null)
			   {
				   userBankData=new UserBankData();
			   }
			   
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
			   WqtUserBank wqtUserBank=new WqtUserBank();
			   wqtUserBank.setUserid(wqtuser.getId());
				userBankData.setPagenum(pagenum);
				Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
				Pagination page= userBankService.selectPageUserBank(wqtUserBank, pagination);
				if(page.getList()!=null && page.getList().size()>0)
				{
					userBankData.setL_WqtUserBank(page.getList());
					userBankData.setBankcount(String.valueOf(page.getCount()));
					userBankData.setBankpage(String.valueOf(page.getAllPage()));
				}
				return SUCCESS;
			}
			else
			{
				 if(pagenum!=null && (!"".equals(pagenum.trim())))
				 {
				        response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/bank/"+pagenum);
				 }
				 else
				 {
					   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/bank");
				 }
				 return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	}
	
	
	/*绑定用户银行卡*/
	public String bindUserBank()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("bindUserBank"));
	   Map resultData = new HashMap();
	   try
	   {
		   if (user != null) {
			    if(userBank!=null)
			    {
			    	 Sms sms=new Sms();
			    	 sms.setMobileno(userBank.getMobileno());
			    	 sms.setContent(userBank.getSmscode());
			    	 sms.setEndtime("1");
			    	 sms=HessionFactory.smsHession().querySms(sms); 
				     if(sms!=null)
			         {
			    	     UserBasic wqtUserBasic = (UserBasic) user;
				    	 WqtUserBank wqtUserBank=new WqtUserBank();
				    	 wqtUserBank.setUserid(wqtUserBasic.getId());
				    	 wqtUserBank.setId(userBank.getId());
				    	 wqtUserBank.setBankid(userBank.getBankid());
				    	 wqtUserBank.setAccountno(userBank.getAccountno());
				    	 wqtUserBank=userBankService.selectOneUser(wqtUserBank);
				    	 if(wqtUserBank!=null)
				    	 {
				    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    		 Date date = new Date();
				    		 String bindtime=sdf.format(date);
				    		 userBank.setBindtime(bindtime);
				    		 userBank.setUserid(wqtUserBasic.getId());
				    		 userBank.setState("2");
				    		 userBankService.updateUserBank(userBank);
				    		 resultData.put("result", "1");
							 resultData.put("msg", "绑定成功");
				    	 }
				    	 else
				    	 {
				    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    		 Date date = new Date();
				    		 String bindtime=sdf.format(date);
				    		 userBank.setBindtime(bindtime);
				    		 userBank.setUserid(wqtUserBasic.getId());
				    		 userBank.setState("2");
				    		 userBankService.insertUserBank(userBank);
				    		 resultData.put("result", "1");
							 resultData.put("msg", "绑定成功");
				    	 }
			       }
			       else
			       {
			    	   resultData.put("result", "3");
					   resultData.put("msg", "短信验证码不正确");
			       }
			    }
		   } 
		   else
		   {
			   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+srcurl+"/user/bank");
			   return null;
			/*   resultData.put("result", "2");
			   resultData.put("msg", "srcurl="+srcurl+"user/bank");*/
		   }
	   } catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "绑定失败,请重新操作");
		}
	   this.formatData(resultData);
       return SUCCESS;
	}
	
	/*解绑用户银行卡*/
	public String unbindUserBank()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("unbindUserBank"));
	   Map resultData = new HashMap();
	   try
	   {
		   if (user != null) {
			    if(userBank!=null)
			    {
			    	 UserBasic wqtUserBasic = (UserBasic) user;
			    	 WqtUserBank wqtUserBank=new WqtUserBank();
			    	 wqtUserBank.setUserid(wqtUserBasic.getId());
			    	 wqtUserBank.setId(userBank.getId());
			    	 wqtUserBank=userBankService.selectOneUser(wqtUserBank);
			    	 if(wqtUserBank!=null)
			    	 {
			    		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    		 Date date = new Date();
			    		 String unbindtime=sdf.format(date);
			    		 userBank.setUnbindtime(unbindtime);
			    		 userBank.setState("1");
			    		 userBankService.updateUserBank(userBank);
			    		 resultData.put("result", "1");
						 resultData.put("msg", "解除绑定成功");
			    	 }
			    	 else
			    	 {
			    		 resultData.put("result", "2");
						 resultData.put("msg", "系统忙,请稍后重试");
			    	 }
			    }
		   } 
		   else
		   {
			   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+srcurl+"/user/bank");
			   return null;
			/*   resultData.put("result", "2");
			   resultData.put("msg", "srcurl="+srcurl+"user/bank");*/
		   }
	   } catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "解除绑定失败,请重新操作");
		}
	   this.formatData(resultData);
       return SUCCESS;
	}
}
