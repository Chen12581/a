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
import com.wqt.common.util.PropertiesUtil;
import com.wqt.user.pojo.WqtUserContract;
import com.wqt.user.service.UserContractService;

/*用户合同主体管理*/
public class UserContractAction  extends BusinessAction{
	
	private static final Logger logger = LoggerFactory.getLogger(UserContractAction.class);
	
    
	/*用户合同主体*/
	@Autowired
	private UserContractService userContractService;
	
	private WqtUserContract userContract;

	public WqtUserContract getUserContract() {
		return userContract;
	}

	public void setUserContract(WqtUserContract userContract) {
		this.userContract = userContract;
	}
    
	/*用户合同主体*/
	public String usercontract() {
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
				return SUCCESS;
			}
			else
			{
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/contract");
				return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	}
	
	
	/*合同主体列表*/
	public String contractlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
				
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String srcurl=url.toString();
		srcurl=srcurl.substring(0, srcurl.indexOf("contractlist"));
	    Map resultData = new HashMap();
	    try {
			   if(user!=null)
			   {
				   UserBasic wqtUserBasic = (UserBasic) user;
				   WqtUserContract tempWqtUserContract=new WqtUserContract();
				   tempWqtUserContract.setUserid(wqtUserBasic.getId());

				   if (pagination == null){
					    pagination = new Pagination(1, 10);
				   }
				   Pagination page = null;
				   page=userContractService.selectPageWqtUserContract(tempWqtUserContract, pagination);
				   List<WqtUserContract> l=page.getList();
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
				   resultData.put("msg", "srcurl="+srcurl+"subject");
			   }
		   } catch (Exception e) {
				e.printStackTrace();
		   }
		this.formatData(resultData); 
		return SUCCESS;
	}
	
	/*一个合同主体*/
	public String oneContractInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		String contractid=request.getParameter("id");		
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String srcurl=url.toString();
		srcurl=srcurl.substring(0, srcurl.indexOf("oneContractInfo"));
	    Map resultData = new HashMap();
	    try {
			   if(user!=null)
			   {
				   WqtUserContract tempWqtUserContract=userContractService.selectOneWqtUserContract(contractid);
				   resultData.put("result", "1");
				   resultData.put("msg", tempWqtUserContract);
	           }
			   else
			   {
				   resultData.put("result", "2");
				   resultData.put("msg", "srcurl="+srcurl+"subject");
			   }
		 }catch(Exception e) {
				e.printStackTrace();
	     }
		this.formatData(resultData);
		return SUCCESS;
	}
	
	/*添加用户邮寄地址*/
	public String saveUserContract()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("saveUserContract"));
	   Map resultData = new HashMap();
	   try
	   {
		   if (user != null) {
				 UserBasic wqtUserBasic = (UserBasic) user;
				 userContract.setUserid(wqtUserBasic.getId());
				 List<WqtUserContract> l_WqtUserContract=userContractService.selectListWqtUserContract(userContract);
				 if(l_WqtUserContract!=null && l_WqtUserContract.size()>0)
				 {
					 resultData.put("result", "1");
					 resultData.put("msg", "添加成功");
				 }
				 else
				 {
				    userContractService.insertWqtUserContract(userContract);
				    resultData.put("result", "3");
				    resultData.put("msg", "根据互联网法规,每个用户只能有一个合同主体");
				 }
		   } 
		   else
		   {
			   resultData.put("result", "2");
			   resultData.put("msg", "srcurl="+srcurl+"subject");
		   }
	   } catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "添加失败,请重新操作");
		}
	   this.formatData(resultData);
       return SUCCESS;
	}
	
	/*修改用户合同主体*/
	public String updateUserContract()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   
	   // 获取此请求的地址          
       StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("updateUserContract"));
	   Map resultData = new HashMap();
	   try {
		     if(user!=null)
		     {
		    	  userContractService.updateWqtUserContract(userContract);
		    	  resultData.put("result", "1");
		    	  resultData.put("msg", "修改成功");
		     }
		     else
		     {
		    	 resultData.put("result", "2");
		    	 resultData.put("msg", "srcurl="+srcurl+"subject");
		     }
	   }catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "修改失败,请重新操作");
	   }
	   this.formatData(resultData);
       return SUCCESS;
	}
	
	/*删除用户合同主体*/
	public String delUserContract()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   String contractid=request.getParameter("id");
	   // 获取此请求的地址          
       StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("delUserContract"));
	   Map resultData = new HashMap();
	   try {
		      if(user!=null)
		      {
		    	  userContractService.deleteWqtUserContract(contractid);
		    	  resultData.put("result", "1");
		    	  resultData.put("msg", "删除成功");
		      }
		      else
		      {
		    	  resultData.put("result", "2");
		    	  resultData.put("msg", "srcurl="+srcurl+"subject");
		      }
	   }catch(Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "删除失败,请重新操作");
	   }
	   this.formatData(resultData);
       return SUCCESS;
	}
}
