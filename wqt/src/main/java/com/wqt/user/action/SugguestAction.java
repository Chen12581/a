package com.wqt.user.action;

import java.util.HashMap;
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
import com.wqt.user.pojo.SugguestList;
import com.wqt.user.pojo.WqtUserSuggest;
import com.wqt.user.service.UserSuggestService;

/*用户建议管理*/
public class SugguestAction extends BusinessAction{
	
	private static final Logger logger = LoggerFactory.getLogger(SugguestAction.class);
	
	@Autowired
	private UserSuggestService userSuggestService;
	
	private WqtUserSuggest userSuggest;
	
	private SugguestList sugguestList;
	
	
	public SugguestList getSugguestList() {
		return sugguestList;
	}

	public void setSugguestList(SugguestList sugguestList) {
		this.sugguestList = sugguestList;
	}


	public WqtUserSuggest getUserSuggest() {
		return userSuggest;
	}

	public void setUserSuggest(WqtUserSuggest userSuggest) {
		this.userSuggest = userSuggest;
	}
    
	
	/*用户建议*/
	public String usersuggest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Session session = SessionFactory.getInstance(request, response);
		Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		// 获取此请求的地址          
	   /* StringBuffer url=request.getRequestURL();
		String serverurl=url.toString();
		serverurl=serverurl.substring(0, serverurl.indexOf("/user/suggest"));*/
		try
		{
			if(user!=null)
			{
				return SUCCESS;
			}
			else
			{
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service=http://www.w7tong.com/user/suggest");
				return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	}
	
	
	/*用户建议列表*/
	public String userSuggestlist() {
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
				   WqtUserSuggest wqtUserSuggest=new WqtUserSuggest();
				   wqtUserSuggest.setUserid(wqtuser.getId());
 
				   if(sugguestList==null)
				   {
					   sugguestList=new SugguestList();
				   }
				   sugguestList.setPagenum(pagenum);
				   Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
				   
				   Pagination page = null;
				   page=userSuggestService.selectPageUserSuggest(wqtUserSuggest, pagination);
				  
				   if(page.getList()!=null && page.getList().size()>0)
				   {
					   sugguestList.setL_userSuggest(page.getList());
					   sugguestList.setSuggestcount(String.valueOf(page.getCount()));
					   sugguestList.setSuggestpage(String.valueOf(page.getAllPage()));
				   }
				 
	           }
			   else
			   {
				   if(pagenum!=null && (!"".equals(pagenum.trim())))
				   {
				        response.sendRedirect(PropertiesUtil.rs.get("casserver")+"/login?service="+serverurl+"/user/suggestlist/"+pagenum);
				   }
				   else
				   {
					   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"/login?service="+serverurl+"/user/suggestlist");
				   }
				   return null;
			   }
		   } catch (Exception e) {
				e.printStackTrace();
			}
		return SUCCESS;
	}
	
	/*添加用户建议*/
	public String saveUserSuggest()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("saveUserSuggest"));
	   Map resultData = new HashMap();
	   try
	   {
		   if (user != null) {
				 UserBasic wqtUserBasic = (UserBasic) user;
				 userSuggest.setUserid(wqtUserBasic.getId());
				 userSuggestService.insertUserSuggest(userSuggest);
				 resultData.put("result", "1");
				 resultData.put("msg", "添加成功");
		   } 
		   else
		   {
			   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"/login?service="+srcurl+"/user/suggest");
			   return null;
			  /* resultData.put("result", "2");
			   resultData.put("msg", "srcurl="+srcurl+"user/suggest");*/
		   }
	   } catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "添加失败,请重新操作");
		}
	   this.formatData(resultData);
       return SUCCESS;
	}
	
	/*修改用户建议*/
	public String updateUserSuggest()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   
	   // 获取此请求的地址          
       StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("updateUserSuggest"));
	   Map resultData = new HashMap();
	   try {
		      if(user!=null)
		      {
		    	 userSuggestService.updateUserSuggest(userSuggest);
				 resultData.put("result", "1");
				 resultData.put("msg", "修改成功");
		     }
		     else
		     {
		    	 resultData.put("result", "2");
		    	 resultData.put("msg", "srcurl="+srcurl+"usersuggest");
		     }
	   } catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "修改失败,请重新操作");
		}
	   this.formatData(resultData);
       return SUCCESS;
	}
	
	/*删除用户建议*/
	public String delUserSuggest()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   String userSuggestid=request.getParameter("id");
	   // 获取此请求的地址          
       StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("delUserSuggest"));
	   Map resultData = new HashMap();
	   try {
		      if(user!=null)
		      {
		    	  userSuggestService.deleteUserSuggest(userSuggestid);
				 resultData.put("result", "1");
				 resultData.put("msg", "删除成功");
		      }
		      else
		      {
		    	  resultData.put("result", "2");
		    	  resultData.put("msg", "srcurl="+srcurl+"usersuggest");
		      }
	   }catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "删除失败,请重新操作");
	   }
	   this.formatData(resultData);
       return SUCCESS;
	}
}
