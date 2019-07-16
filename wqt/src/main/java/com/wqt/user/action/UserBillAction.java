package com.wqt.user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.common.util.CommonUtil;
import com.wqt.common.util.PropertiesUtil;
import com.wqt.user.pojo.UserBillData;
import com.wqt.user.pojo.UsercenterOrder;
import com.wqt.user.pojo.WqtUserBill;
import com.wqt.user.service.UserBillService;
import com.wqt.user.service.UsercenterOrderService;

/*用户发票管理*/
public class UserBillAction    extends BusinessAction{
	private static final Logger logger = LoggerFactory.getLogger(UserBillAction.class);
	
	/*用户开票*/
	@Autowired
	private UserBillService userBillService;
	
	@Autowired
	private UsercenterOrderService usercenterOrderService;
	
	private WqtUserBill userBill;
	
	private UserBillData userBillData;
	
	public WqtUserBill getUserBill() {
		return userBill;
	}
	public void setUserBill(WqtUserBill userBill) {
		this.userBill = userBill;
	}
	
	public UserBillData getUserBillData() {
		return userBillData;
	}
	public void setUserBillData(UserBillData userBillData) {
		this.userBillData = userBillData;
	}
	
	public String userBill()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		serverurl=serverurl.substring(0, serverurl.indexOf("/user/"));
	    String pagenum=request.getParameter("pagenum");
	    try {
			   if(user!=null)
			   {
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
				    
				    
				    if(userBillData==null)
				    {
				    	userBillData=new UserBillData();
				    }
				   
				    userBillData.setPagenum(pagenum);
				    Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
				    UsercenterOrder usercenterOrder=new UsercenterOrder();
				    usercenterOrder.setBuyerid(wqtuser.getId());
				    usercenterOrder.setOrderstate("4");
				    Pagination page=usercenterOrderService.selectUserCenterOrderPage(usercenterOrder, pagination);
				    if(page.getList()!=null && page.getList().size()>0)
					{
				    	userBillData.setL_UsercenterOrder(page.getList());
				    	userBillData.setOrdercount(String.valueOf(page.getCount()));
				    	userBillData.setOrderpage(String.valueOf(page.getAllPage()));
					}
	           }
			   else
			   {
				   if(pagenum!=null && (!"".equals(pagenum.trim())))
				   {
				        response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/bill/"+pagenum);
				   }
				   else
				   {
					   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/bill");
				   }
				   return null;
			   }
		   } catch (Exception e) {
				e.printStackTrace();
			}
		return SUCCESS;
	
	}
	
	
    public String saveUserBill()
    {
    	HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	
	    Map resultData = new HashMap();
	    try {
			   if(user!=null)
			   {
				   UserBasic wqtuser=(UserBasic) user;
				   userBill.setUserid(wqtuser.getId());
				   userBillService.insertWqtUserBill(userBill);
				   resultData.put("result", "1");
				   resultData.put("msg","您的发票申请已收到,我们将为您处理");
	           }
			   else
			   {
				   resultData.put("result", "2");
				   resultData.put("msg", "srcurl=http://www.w7tong.com/user/bill");
			   }
		} catch (Exception e) {
			   resultData.put("result", "0");
			   resultData.put("msg", "系统忙,请稍后重试");
	    }
		this.formatData(resultData); 
		return SUCCESS;
    }
	
	/*发票信息列表*/
	public String userBilllist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
				
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String srcurl=url.toString();
		srcurl=srcurl.substring(0, srcurl.indexOf("userBilllist"));
	    Map resultData = new HashMap();
	    try {
			   if(user!=null)
			   {
				   UserBasic wqtUserBasic = (UserBasic) user;
				   WqtUserBill tempWqtUserBill=new WqtUserBill();
				   tempWqtUserBill.setUserid(wqtUserBasic.getId());

				   if (pagination == null){
					    pagination = new Pagination(1, 10);
				   }
				   Pagination page = null;
				   page=userBillService.selectPageWqtUserBill(tempWqtUserBill, pagination);
				   List<WqtUserBill> l=page.getList();
				   Map<String, Object> jsonMap = new HashMap<String, Object>();
				   jsonMap.put("total", page.getCount());//total键 存放总记录数，必须的  
				   jsonMap.put("pages", page.getAllPage());//total键 存放总记录数，必须的  pa
				   jsonMap.put("rows", l);//rows键 存放每页记录 list  
				   resultData.put("result", "1");
				   resultData.put("msg", jsonMap);
	           }
			   else
			   {
				   resultData.put("result", "2");
				   resultData.put("msg", "srcurl="+srcurl+"bill");
			   }
		} catch (Exception e) {
				e.printStackTrace();
	    }
		this.formatData(resultData); 
		return SUCCESS;
	}
	
	/*一个发票主体*/
	public String oneBillInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		String billid=request.getParameter("id");		
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String srcurl=url.toString();
		srcurl=srcurl.substring(0, srcurl.indexOf("oneBillInfo"));
	    Map resultData = new HashMap();
	    try {
			   if(user!=null)
			   {
				   WqtUserBill tempWqtUserContract=userBillService.selectOneWqtUserBill(billid);
				   resultData.put("result", "1");
				   resultData.put("msg", tempWqtUserContract);
	           }
			   else
			   {
				   resultData.put("result", "2");
				   resultData.put("msg", "srcurl="+srcurl+"bill");
			   }
		 }catch(Exception e) {
				e.printStackTrace();
	     }
		this.formatData(resultData); 
		return SUCCESS;
	}
	
	/*修改用户发票主体*/
	public String updateUserBill()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   
	   // 获取此请求的地址          
       StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("updateUserBill"));
	   Map resultData = new HashMap();
	   try {
		     if(user!=null)
		     {
		    	 userBillService.updateWqtUserBill(userBill);
		    	 resultData.put("result", "1");
		    	 resultData.put("msg", "修改成功");
		     }
		     else
		     {
		    	 resultData.put("result", "2");
		    	 resultData.put("msg", "srcurl="+srcurl+"bill");
		     }
	   }catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "修改失败,请重新操作");
	   }
	   this.formatData(resultData);
       return SUCCESS;
	}
	
	/*删除用户发票主体*/
	public String delUserBill()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   String billid=request.getParameter("id");
	   // 获取此请求的地址          
       StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("delUserBill"));
	   Map resultData = new HashMap();
	   try {
		      if(user!=null)
		      {
		    	  userBillService.deleteWqtUserBill(billid);
		    	  resultData.put("result", "1");
		    	  resultData.put("msg", "删除成功");
		      }
		      else
		      {
		    	  resultData.put("result", "2");
		    	  resultData.put("msg", "srcurl="+srcurl+"bill");
		      }
	   }catch(Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "删除失败,请重新操作");
	   }
	   this.formatData(resultData);
       return SUCCESS;
	}
	
}
