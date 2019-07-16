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
import com.wqt.user.pojo.EsCollectProduct;
import com.wqt.user.pojo.EsCollectShop;
import com.wqt.user.pojo.IprCollectProduct;
import com.wqt.user.pojo.IprCollectShop;
import com.wqt.user.pojo.UserCollect;
import com.wqt.user.pojo.UserCollectData;
import com.wqt.user.service.EsCollectProductService;
import com.wqt.user.service.EsCollectShopService;
import com.wqt.user.service.IprCollectProductService;
import com.wqt.user.service.IprCollectShopService;
import com.wqt.user.service.UserCollectService;

public class UserCollectAction     extends BusinessAction{
	private static final Logger logger = LoggerFactory.getLogger(UserCollectAction.class);
	
	@Autowired
	private UserCollectService userCollectService;
	
	@Autowired
	private IprCollectShopService iprCollectShopService;
	
	@Autowired
	private IprCollectProductService iprCollectProductService;
	
	@Autowired
	private EsCollectShopService esCollectShopService;
	
	@Autowired
	private EsCollectProductService  esCollectProductService;
	
	private UserCollectData userCollectData;
	
	
	
	public UserCollectData getUserCollectData() {
		return userCollectData;
	}
	public void setUserCollectData(UserCollectData userCollectData) {
		this.userCollectData = userCollectData;
	}

	
	/*删除用户收藏*/
	public String delcollect()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
	    Session session = SessionFactory.getInstance(request, response);
	    Object user = (Object) session.getAttribute("LOGINSESSIOIN");
	    
	    // 获取此请求的地址          
		String collectid=request.getParameter("collectid");
		String collectkind=request.getParameter("collectkind");
		Map resultData = new HashMap();
		try
		{
			if(user!=null)
			{
				if(collectid!=null && (!"".equals(collectid.trim())) && collectkind!=null && (!"".equals(collectkind.trim())))
				{
					if("1".equals(collectkind))
					{
						IprCollectProduct iprCollectProduct=new IprCollectProduct();
						iprCollectProduct.setId(collectid);
						iprCollectProductService.delIprCollectProduct(iprCollectProduct);
					}
					else if("2".equals(collectkind))
                    {
						IprCollectShop iprCollectShop=new IprCollectShop();
						iprCollectShop.setId(collectid);
						iprCollectShopService.delIprCollectShop(iprCollectShop);
					}
					else if("3".equals(collectkind))
                    {
						EsCollectProduct esCollectProduct=new EsCollectProduct();
						esCollectProduct.setId(collectid);
						esCollectProductService.delEsCollectProduct(esCollectProduct);
					}
					else if("4".equals(collectkind))
                    {
						EsCollectShop esCollectShop=new EsCollectShop();
						esCollectShop.setId(collectid);
						esCollectShopService.delEsCollectShop(esCollectShop);
					}
					resultData.put("result","1");
					resultData.put("msg", "删除成功");
				}
				else
				{
					 resultData.put("result","0");
					 resultData.put("msg", "系统忙,请稍后再试");
				}
			}
			else
			{
			     response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service=http://www.w7tong.com/user/collection");
				 return null;
			}
		}
	    catch(Exception e)
		{
	    	 resultData.put("result","0");
			 resultData.put("msg", "系统忙,请稍后再试");
		}
		this.formatData(resultData);
	    return SUCCESS;
	}
	
	/*用户收藏页面*/
	public String usercollect()
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
		try
		{
			if(user!=null)
			{
			   if(userCollectData==null)
			   {
				   userCollectData=new UserCollectData();
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
			   
			    userCollectData.setPagenum(pagenum);
			    UserBasic wqtuser=(UserBasic) user;
			    Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
			    UserCollect userCollect=new UserCollect();
			    userCollect.setUserid(wqtuser.getId());
			    Pagination page= userCollectService.selectUserCollectPage(userCollect, pagination);
			    if(page.getList()!=null && page.getList().size()>0)
				{
			    	userCollectData.setL_UserCollect(page.getList());
			    	userCollectData.setCollectcount(String.valueOf(page.getCount()));
			    	userCollectData.setCollectpage(String.valueOf(page.getAllPage()));
				}
				return SUCCESS;
			}
			else
			{
				 if(pagenum!=null && (!"".equals(pagenum.trim())))
				 {
				        response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/collection/"+pagenum);
				 }
				 else
				 {
					   response.sendRedirect(PropertiesUtil.rs.get("casserver")+"?service="+serverurl+"/user/collection");
				 }
				 return null;
			}
		}
	    catch(Exception e)
		{
	    	return "404";
		}
	}
}
