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
import com.wqt.user.pojo.WqtUserPost;
import com.wqt.user.service.UserPostService;

/*邮寄地址管理*/
public class PostAddressAction  extends BusinessAction{
	private static final Logger logger = LoggerFactory.getLogger(PostAddressAction.class);
	
	private WqtUserPost  wqtUserPost;

	public WqtUserPost getWqtUserPost() {
		return wqtUserPost;
	}

	public void setWqtUserPost(WqtUserPost wqtUserPost) {
		this.wqtUserPost = wqtUserPost;
	}

	/*用户邮寄地址*/
	@Autowired
	private UserPostService userPostService;
	
	/*邮寄地址管理页面*/
	public String userPostaddr() {
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
				response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/postaddr");
				return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	}
		
	
	/*邮寄地址列表*/
	public String postlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
				
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String srcurl=url.toString();
		srcurl=srcurl.substring(0, srcurl.indexOf("postlist"));
	    Map resultData = new HashMap();
	    try {
			   if(user!=null)
			   {
				   UserBasic wqtUserBasic = (UserBasic) user;
				   WqtUserPost tempwqtUserPost=new WqtUserPost();
				   tempwqtUserPost.setUserid(wqtUserBasic.getId());

				   if (pagination == null) 
				   {
					    pagination = new Pagination(1, 10);
				   }
				   Pagination page = null;
				   page=userPostService.selectPageWqtUserPost(tempwqtUserPost, pagination);
				   List<WqtUserPost> l=page.getList();
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
				   resultData.put("msg", "srcurl="+srcurl+"postaddr");
			   }
		   } catch (Exception e) {
				e.printStackTrace();
			}
		this.formatData(resultData); 
		return SUCCESS;
	}
	
	/*一个邮寄地址*/
	public String onePostInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		String postid=request.getParameter("id");		
	    // 获取此请求的地址          
	    StringBuffer url=request.getRequestURL();
		String srcurl=url.toString();
		srcurl=srcurl.substring(0, srcurl.indexOf("onePostInfo"));
	    Map resultData = new HashMap();
	    try {
			   if(user!=null)
			   {
				   WqtUserPost tempwqtUserPost=userPostService.selectOneWqtUserPost(postid);
				   resultData.put("result", "1");
				   resultData.put("msg", tempwqtUserPost);
	           }
			   else
			   {
				   resultData.put("result", "2");
				   resultData.put("msg", "srcurl="+srcurl+"postaddr");
			   }
		   } catch (Exception e) {
				e.printStackTrace();
			}
		this.formatData(resultData); 
		return SUCCESS;
	}
	
	/*添加用户邮寄地址*/
	public String saveUserPost()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("saveUserPost"));
	   Map resultData = new HashMap();
	   try
	   {
		   if (user != null) {
				 UserBasic wqtUserBasic = (UserBasic) user;
				 wqtUserPost.setUserid(wqtUserBasic.getId());
				 userPostService.insertWqtUserPost(wqtUserPost);
				 resultData.put("result", "1");
				 resultData.put("msg", "添加成功");
		   } 
		   else
		   {
			   resultData.put("result", "2");
			   resultData.put("msg", "srcurl="+srcurl+"postaddr");
		   }
	   } catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "添加失败,请重新操作");
		}
	   this.formatData(resultData);
       return SUCCESS;
	}
	
	/*修改用户邮寄地址*/
	public String updateUserPost()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   
	   // 获取此请求的地址          
       StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("updateUserPost"));
	   Map resultData = new HashMap();
	   try {
		      if(user!=null)
		      {
				 userPostService.updateWqtUserPost(wqtUserPost);
				 resultData.put("result", "1");
				 resultData.put("msg", "修改成功");
		     }
		     else
		     {
		    	 resultData.put("result", "2");
		    	 resultData.put("msg", "srcurl="+srcurl+"postaddr");
		     }
	   } catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "修改失败,请重新操作");
		}
	   this.formatData(resultData);
       return SUCCESS;
	}
	
	/*删除用户邮寄地址*/
	public String delUserPost()
	{  
	   HttpServletRequest request = ServletActionContext.getRequest();
	   HttpServletResponse response = ServletActionContext.getResponse();
	   Session session = SessionFactory.getInstance(request, response);
	   Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	   String userPostid=request.getParameter("id");
	   // 获取此请求的地址          
       StringBuffer url=request.getRequestURL();
	   String srcurl=url.toString();
	   srcurl=srcurl.substring(0, srcurl.indexOf("delUserPost"));
	   Map resultData = new HashMap();
	   try {
		      if(user!=null)
		      {
				 userPostService.deleteWqtUserPost(userPostid);
				 resultData.put("result", "1");
				 resultData.put("msg", "删除成功");
		      }
		      else
		      {
		    	  resultData.put("result", "2");
		    	  resultData.put("msg", "srcurl="+srcurl+"postaddr");
		      }
	   }catch (Exception e) {
		   resultData.put("result","0");
		   resultData.put("msg", "删除失败,请重新操作");
	   }
	   this.formatData(resultData);
       return SUCCESS;
	}
}
