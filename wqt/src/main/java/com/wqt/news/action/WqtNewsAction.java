package com.wqt.news.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.hessian.HessionFactory;
import com.news.pojo.News;
import com.news.pojo.NewsComment;
import com.news.pojo.NewsLabel;
import com.notice.pojo.Notice;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.wqt.cases.pojo.WqtCases;
import com.wqt.cases.service.WqtCasesService;
import com.wqt.common.util.CommonUtil;
import com.wqt.ipr.brand.pojo.IprBrandShop;
import com.wqt.ipr.brand.service.BrandShopService;
import com.wqt.news.pojo.WqtNewsListData;
import com.wqt.news.service.NewsNewsLabelService;
import com.wqt.news.service.NewsService;

public class WqtNewsAction  extends BusinessAction{
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private NewsNewsLabelService newsNewsLabelService;
	
	@Autowired
	private WqtCasesService wqtCasesService;
	
	@Autowired
	private BrandShopService brandShopService;
	
	/*网店新闻对象*/
	private NewsComment wqtNewsComment;
	
	private News wqtnews; 
	
	private WqtNewsListData wqtNewsListData;
	
	public NewsComment getWqtNewsComment() {
		return wqtNewsComment;
	}

	public void setWqtNewsComment(NewsComment wqtNewsComment) {
		this.wqtNewsComment = wqtNewsComment;
	}

	public WqtNewsListData getWqtNewsListData() {
		return wqtNewsListData;
	}

	public void setWqtNewsListData(WqtNewsListData wqtNewsListData) {
		this.wqtNewsListData = wqtNewsListData;
	}

	public News getWqtnews() {
		return wqtnews;
	}
	
	public void setWqtnews(News wqtnews) {
		this.wqtnews = wqtnews;
	}
    
	public String  wqtNewsList() 
    {
   	       HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		   try
		   {
			   String kindid=request.getParameter("kindid");
			   String pagenum=request.getParameter("pagenum");
			   String labelid=request.getParameter("labelid");    //新闻标签
			   
			   if(wqtNewsListData==null)
			   {
				   wqtNewsListData=new WqtNewsListData();
			   }
			   
			  // News  news = new News();
			  // news.setState("2");
			 
			   
			   if(kindid!=null && (!"".equals(kindid)))
			   {
				  if(CommonUtil.isNumber(kindid))
				  {
					  wqtNewsListData.setKindid(kindid);
				      //news.setKindid(Integer.parseInt(kindid));
				  }
				  else
				  {
					   wqtNewsListData.setKindid("1");
				      // news.setKindid(1);
				  }
			   }
			   else
			   {
				   wqtNewsListData.setKindid("1");
			      // news.setKindid(1);
			       kindid="1";
			   }
			   
			   if(pagenum!=null && !"".equals(pagenum))
		       {
				  if(CommonUtil.isInteger(pagenum))
				  {
				    wqtNewsListData.setPagenum(Integer.parseInt(pagenum));
				  }
				  else
				  {
					  wqtNewsListData.setPagenum(1);
					  pagenum="1";
				  }
		       }
			   else
			   {
				  wqtNewsListData.setPagenum(1);
				  pagenum="1";
			   }
			   
			   if(labelid!=null && (!"".equals(labelid)))
			   {
					  if(CommonUtil.isNumber(labelid))
					  {
					     // news.setLabelid(Integer.parseInt(labelid));
					      wqtNewsListData.setLabelid(Integer.parseInt(labelid));
					  }
			   }
			   
			   //wqtNewsListData.setKindid(kindid);
			   wqtNewsListData.setPagenum(Integer.parseInt(pagenum));
			   if("1".equals(kindid) || "2".equals(kindid))
			   {
				  Pagination n1pagination=new Pagination(Integer.parseInt(pagenum),10);
				  News wqtNews=new News();
				  wqtNews.setState("2");
				  wqtNews.setPlateformcode("wqt");
				  wqtNews.setKindid(Integer.parseInt(kindid));
				  if(labelid!=null && (!"".equals(labelid)))
				  {
						  if(CommonUtil.isNumber(labelid))
						  {
							  wqtNews.setLabelid(Integer.parseInt(labelid));
						  }
				  }
				  Pagination page1=newsService.selectWqtNewsPage(wqtNews, n1pagination);
				  if(page1!=null && page1.getList().size()>0)
				  {
					  wqtNewsListData.setL_News(page1.getList());
					  wqtNewsListData.setNewspage(page1.getAllPage());
					  List<News> l_News=page1.getList();
					  for(News rnews:l_News)
					  {
						  List<NewsLabel> l_NewsLabel=newsNewsLabelService.selectWqtNewsNewsLabelList(rnews.getId());
						  rnews.setL_NewsLabel(l_NewsLabel);
					  }
				  }
			   }
			   else  if("4".equals(kindid))
			   {
				   Pagination n3pagination=new Pagination(Integer.parseInt(pagenum),10);
				   Notice notice=new Notice();
				   notice.setState(2);
				   Pagination page3=HessionFactory.noticeHession().selectNoticePage(notice, n3pagination);
				   if(page3!=null && page3.getList().size()>0)
				   {
					  wqtNewsListData.setL_Notice(page3.getList());
					  wqtNewsListData.setNoticepage(page3.getAllPage());
				   }
			   }
			   else  if("3".equals(kindid))
			   {
				   Pagination cpagination=new Pagination(Integer.parseInt(pagenum),10);
				   WqtCases wqtCases=new WqtCases();
				   wqtCases.setState("2");
				   Pagination cpage=wqtCasesService.selectWqtCasesPage(wqtCases, cpagination);
				   if(cpage!=null && cpage.getList().size()>0)
				   {
					  wqtNewsListData.setL_cases(cpage.getList());
					  wqtNewsListData.setCasepage(cpage.getAllPage());
				   }
			   }
			   
			   Pagination hotpagination=new Pagination(1,5);
			   News hotNews=new News();
			   hotNews.setState("2");
			   hotNews.setPlateformcode("wqt");
			   hotNews.setHotrecom(2);  
			   Pagination pagehot=newsService.selectWqtNewsPage(hotNews, hotpagination);
			   if(pagehot!=null && pagehot.getList().size()>0)
			   {
				  wqtNewsListData.setL_hotNews(pagehot.getList());
			   }
				  
			   Pagination brandpagination=new Pagination(1,3);
			   IprBrandShop iprBrandShop=new IprBrandShop();
			   iprBrandShop.setState("2");
			   Pagination brandpage=brandShopService.selectIprBrandShopPage(iprBrandShop, brandpagination);
			   if(brandpage!=null && brandpage.getList().size()>0)
			   {
					  wqtNewsListData.setL_IprBrandShop(brandpage.getList());
			   } 
		   }
		   catch(Exception e)
		   {
			   return "404";
		   }
		  return SUCCESS;
   }
	

	public String  wqtNewsInfo() 
    {
   	       HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();
		 
					  
		   String pathkey=request.getParameter("pathkey");
		   String commentpagenum=request.getParameter("commentpagenum");
		   if(pathkey!=null && (!"".equals(pathkey)))
		   {
			  News wqtNews=new News();
			  wqtNews.setId(pathkey);
			  wqtnews=newsService.selectWqtNewsOne(wqtNews);
			  if(wqtnews!=null)
			  {
				  List<NewsLabel> l_NewsLabel=newsNewsLabelService.selectWqtNewsNewsLabelList(wqtnews.getId());
				  wqtnews.setL_NewsLabel(l_NewsLabel);
				  
				  if(commentpagenum!=null && (!"".equals(commentpagenum)))
				  {
					  if(CommonUtil.isNumber(commentpagenum))
					  {
						  wqtnews.setCommentnum(Integer.parseInt(commentpagenum));
					  }
				  }
				  else
				  {
					  wqtnews.setCommentpage(1);
					  wqtnews.setCommentnum(1);
					  commentpagenum="1";
				  }
				  
				  Pagination commentpage=new Pagination(Integer.parseInt(commentpagenum),10);
				  NewsComment newsComment=new NewsComment();
				  newsComment.setPid(0);
				  newsComment.setNewsid(Integer.parseInt(wqtnews.getId()));
				  Pagination pagecomment=HessionFactory.newsCommentHession().selectNewsCommentPage(newsComment,commentpage);
				  if(pagecomment!=null && pagecomment.getList().size()>0)
				  {
					  List<NewsComment> list_NewsComment=pagecomment.getList();
					  for(NewsComment newsComment1:list_NewsComment)
					  {
						  List<NewsComment> list_SonNewsComment1=HessionFactory.newsCommentHession().selectSonCommentList(newsComment1);
						  List<NewsComment> list_SonNewsComment2=initNewsComment(list_SonNewsComment1,newsComment1.getId());
						  newsComment1.setChildren(list_SonNewsComment2);
					  }
					  wqtnews.setL_NewsComment(list_NewsComment);
					  wqtnews.setCommentpage(pagecomment.getAllPage());
				  }
				  
				  Pagination pagination=new Pagination(1,6);
				  News  wqtNews1 = new News();
				  wqtNews1.setState("2");
				  wqtNews1.setPlateformcode("wqt");
				  Pagination page=newsService.selectWqtNewsPage(wqtNews1, pagination);
				  if(page!=null && page.getList().size()>0)
				  {
				     wqtnews.setL_news(page.getList());
				  }
				  
				  Pagination hotpagination=new Pagination(1,6);
				  News  wqtNews2 = new News();
				  wqtNews2.setState("2");
				  wqtNews2.setHotrecom(1);
				  wqtNews2.setPlateformcode("wqt");
				  Pagination hotpage=newsService.selectWqtNewsPage(wqtNews2, hotpagination);
				  if(hotpage!=null && hotpage.getList().size()>0)
				  {
				     wqtnews.setL_hotNews(hotpage.getList());
				  }
				  
				  
				  News  preWqtNews=newsService.selectPreWqtNews(wqtnews);
				  if(preWqtNews!=null)
				  {
					  wqtnews.setPrevNews(preWqtNews); 
				  }
				  News  nextWqtNews=newsService.selectNextWqtNews(wqtnews);
				  if(nextWqtNews!=null)
				  {
					  wqtnews.setNextNews(nextWqtNews); 
				  }
				  return SUCCESS;
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
	
	/**
	 * @param list
	 * @param parentId
	 * @return
	 */
	protected List<NewsComment> initNewsComment(List<NewsComment> list,int parentId){
		List<NewsComment> treeList=new ArrayList<NewsComment>();
		for(NewsComment rsc : list){
		   if(rsc.getPid()==parentId){
			    NewsComment node=new NewsComment();
				node.setId(rsc.getId());
				node.setNewscomment(rsc.getNewscomment());
				node.setCommenttime(rsc.getCommenttime());
				node.setPid(rsc.getPid());
				node.setUserid(rsc.getUserid());
				node.setUsername(rsc.getUsername());
				node.setChildren(initNewsComment(list,rsc.getId()));
				treeList.add(node);
		   }
		}
		return treeList;
	}
	
	/*评论回复*/
	public String saveNewsComment()
	{   
		 HttpServletRequest  request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 Session session = SessionFactory.getInstance(request, response);
		 Object user = (Object) session.getAttribute("LOGINSESSIOIN");
		    
		 if(wqtNewsComment!=null)
		 {
			 if(wqtNewsComment.getNewsid()!=0 && (!"".equals(wqtNewsComment.getNewscomment())))
			 {
				 if(user!=null)
				 {
					 UserBasic wqtuser = (UserBasic) user;
					 wqtNewsComment.setUserid(Integer.parseInt(wqtuser.getId()));
					 wqtNewsComment.setUsername(wqtuser.getUsername());
				 }
				 else
				 {
					 wqtNewsComment.setUsername("匿名用户"); 
				 }
				 HessionFactory.newsCommentHession().insertNewsComment(wqtNewsComment);
			 }
		 }
		 return SUCCESS;
	}
	
}
