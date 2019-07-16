package com.wqt.common.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.hessian.HessionFactory;
import com.sms.pojo.Sms;
import com.talkweb.twdpe.core.cache.CacheManager;
import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.common.pojo.WqtArea;
import com.wqt.common.pojo.WqtBank;
import com.wqt.common.pojo.WqtCity;
import com.wqt.common.pojo.WqtProvince;
import com.wqt.common.service.WqtCommonSevice;
import com.wqt.common.util.CommonUtil;
import com.wqt.common.util.SmsUtil;

public class CommonAction extends BusinessAction{
    private static final Logger logger = LoggerFactory.getLogger(CommonAction.class);	

	
	@Autowired
	private WqtCommonSevice wqtCommonSevice;
	private WqtCity wqtcity;
	private WqtArea wqtarea;
	
	
	public WqtCity getWqtcity() {
		return wqtcity;
	}

	public void setWqtcity(WqtCity wqtcity) {
		this.wqtcity = wqtcity;
	}

	public WqtArea getWqtarea() {
		return wqtarea;
	}

	public void setWqtarea(WqtArea wqtarea) {
		this.wqtarea = wqtarea;
	}
	
	/*生成4位数随机码*/
	private String getvalidateCode()
	{
		String validateCode="";
		int randomnum;
		Random ne=new Random();//实例化一个random的对象ne 
		randomnum=ne.nextInt(9999-1000+1)+1000;//为变量赋随机值1000-9999
        validateCode=String.valueOf(randomnum);
		return validateCode;
	}
	
	
	/*
	 *带图形验证的短信验证码
	 */
	public String commonSmsCode()
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
					    if(mobileNo!=null && (!"".equals(mobileNo.trim())))
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
   
	/*
	 *登录用户的短信验证码
	 */
	public String getSmsCode()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   Session session = SessionFactory.getInstance(request, response);
		   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		   Map resultMap = new HashMap();
		   String result="0";
		   String revmobile=request.getParameter("mobile");
		   try {
			     if(user!=null)
			     {
				   if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) || request.getParameter("ajax") != null) 
				   {
				       String validateCode=getvalidateCode();
				       Sms sms=new Sms();
				       if(revmobile!=null && (!"".equals(revmobile)))
				       {
				    	   sms.setMobileno(revmobile);
				       }
				       else
				       {
				    	   UserBasic wqtuser=(UserBasic) user;
				    	   sms.setMobileno(wqtuser.getMobileno());
				       }
				       HessionFactory.smsHession().delSms(sms);
				       
				       sms.setContent(validateCode);
				       Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				       Date now=new Date();
					   String sendtime=format.format(now);
					   sms.setSendtime(sendtime);
					   Date enddate= new Date(now.getTime()+180000);
					   String endtime=format.format(enddate);
					   sms.setEndtime(endtime);
					   sms.setKind("1");
					   HessionFactory.smsHession().sendSms(sms);
				       result="1";
				   }
			     }
		   }catch (Exception e) {
			   result="0";
		  }
		  resultMap.put("msg", result);
   		  this.formatData(resultMap);
		  return SUCCESS;
	}
	
	
	/*
	 *基础银行信息
	 */
	public String getBank()  
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   List<WqtBank> l_WqtBank=new ArrayList<WqtBank>();
		   try {
			      CacheManager _bankcache = CacheManager.getInstance();
			      String  bankcachekey = CommonUtil.BANKS_CACHE+".key";
			      l_WqtBank = (List<WqtBank>)_bankcache.getObject(CommonUtil.BANKS_CACHE, bankcachekey);
		   }catch (Exception e) {
				request.setAttribute("throw", e);
				logger.error(e.getMessage(), e);
				e.printStackTrace();
		  }
   		  this.formatData(l_WqtBank);
		  return SUCCESS;
	}
	
	
	/*
	 *省份
	 */
	public String getProvince()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   List<WqtProvince> l_WqtProvince=new ArrayList<WqtProvince>();
		   try {
			      CacheManager _provincecache = CacheManager.getInstance();
			      String  provincecachekey = CommonUtil.PROVINCE_CACHE+".key";
			      l_WqtProvince = (List<WqtProvince>)_provincecache.getObject(CommonUtil.PROVINCE_CACHE, provincecachekey);
		   }catch (Exception e) {
				request.setAttribute("throw", e);
				logger.error(e.getMessage(), e);
				e.printStackTrace();
		  }
   		  this.formatData(l_WqtProvince);
		  return SUCCESS;
	}
	
	/*
	 *地市
	 */
	public String getCity()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   String provinceid=request.getParameter("provinceid");   /*省ID*/
		   try {
				CacheManager _cache = CacheManager.getInstance();
				String  citycachekey = CommonUtil.CITY_CACHE+".key";
				List<WqtCity> l_City= (List<WqtCity>)_cache.getObject(CommonUtil.CITY_CACHE, citycachekey);
				List<WqtCity> l_ResultCity=(List<WqtCity>)CommonUtil.findListFromList(l_City,"provinceid",provinceid);
				formatData(l_ResultCity);
		   }catch (Exception e) {
				request.setAttribute("throw", e);
				logger.error(e.getMessage(), e);
				e.printStackTrace();
		  }
		  return SUCCESS;
	}
	
	/*
	 *区县
	 */
	public String getArea()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String cityid=request.getParameter("cityid");   /*省ID*/
		CacheManager _cache = CacheManager.getInstance();
		String  areacachekey = CommonUtil.AREA_CACHE+".key";
		List<WqtArea> l_Area= (List<WqtArea>)_cache.getObject(CommonUtil.AREA_CACHE, areacachekey);
		List<WqtArea> l_ResultArea=(List<WqtArea>)CommonUtil.findListFromList(l_Area,"cityid",cityid);
		formatData(l_ResultArea);
		return SUCCESS;
	}
	
	public String getTemplateXls() throws IOException {
		HttpServletRequest  request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		request.setCharacterEncoding("UTF-8");
	    String name = "tempxls.xlsx";//获取要下载的文件名
	    //第一步：设置响应类型
	    response.setContentType("application/force-download");//应用程序强制下载
	    //第二读取文件
	    String path = ServletActionContext.getServletContext().getRealPath("/WebContent/template"+name);
	    InputStream in = new FileInputStream(path);
	    //设置响应头，对文件进行url编码
	    name = URLEncoder.encode(name, "UTF-8");
	    response.setHeader("Content-Disposition", "attachment;filename="+name);   
	    response.setContentLength(in.available());
	    
	    //第三步：老套路，开始copy
	    OutputStream out = response.getOutputStream();
	    byte[] b = new byte[1024];
	    int len = 0;
	    while((len = in.read(b))!=-1){
	      out.write(b, 0, len);
	    }
	    out.flush();
	    out.close();
	    in.close();
	    return SUCCESS;
	}
	
}
