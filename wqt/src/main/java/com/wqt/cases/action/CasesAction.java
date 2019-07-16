package com.wqt.cases.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.wqt.cases.pojo.WqtCases;
import com.wqt.cases.pojo.WqtCasesList;
import com.wqt.cases.service.WqtCasesService;
import com.wqt.common.util.CommonUtil;

public class CasesAction extends BusinessAction {
	
	@Autowired
	private WqtCasesService wqtCasesService;

	/*案例对象*/
	private WqtCases wqtCases;
	
	/*案例频道对象*/
	private WqtCasesList  wqtCasesList;
	
	public WqtCases getWqtCases() {
		return wqtCases;
	}

	public void setWqtCases(WqtCases wqtCases) {
		this.wqtCases = wqtCases;
	}

	public WqtCasesList getWqtCasesList() {
		return wqtCasesList;
	}

	public void setWqtCasesList(WqtCasesList wqtCasesList) {
		this.wqtCasesList = wqtCasesList;
	}
	
	/*跳转到案例页面*/
	public String wqtCasesList()
	{
		   HttpServletRequest  request = ServletActionContext.getRequest();
		   HttpServletResponse response = ServletActionContext.getResponse();	
					
		  String pagenum=request.getParameter("pagenum");
		  
		  if(wqtCasesList==null)
			  wqtCasesList=new WqtCasesList();
		  
		  Pagination caselistpage=new Pagination(1, 10);
		  if(pagenum!=null && !"".equals(pagenum))
	      {
			  if(CommonUtil.isInteger(pagenum))
			  {
				  caselistpage.setCurrPage(Integer.parseInt(pagenum));
				  wqtCasesList.setPagenum(pagenum);
			  }
			  else
			  {
				  caselistpage.setCurrPage(1);
				  wqtCasesList.setPagenum("1");
			  }
	      }
		  else
		  {
			  caselistpage.setCurrPage(1);
			  wqtCasesList.setPagenum("1");
		  }
		  WqtCases  wqtcases = new WqtCases();
		  wqtcases.setState("2");
		  Pagination page=wqtCasesService.selectWqtCasesPage(wqtcases, caselistpage);
		  if(page!=null && page.getSize()>0)
		  {
			  wqtCasesList.setL_WqtCases(page.getList());
			  wqtCasesList.setCasescount(String.valueOf(page.getCount()));
			  wqtCasesList.setCasepage(String.valueOf(page.getAllPage()));
		  }
		  
		  return SUCCESS;
	}

	/*案例详情页*/
    public String  wqtCasesInfo() 
    {
   	     HttpServletRequest  request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
					
		 String pathkey=request.getParameter("pathkey");
		 if(pathkey!=null && (!"".equals(pathkey)))
		 {
			    WqtCases wqtCases1=new WqtCases();
			    wqtCases1.setPathkey(pathkey);
			    wqtCases=wqtCasesService.selectWqtCasesOne(wqtCases1);
			    if(wqtCases!=null)
			    {
				  Pagination pagination=new Pagination(1,10);
				  WqtCases wqtCases2=new WqtCases();
				  wqtCases2.setState("2");
				  Pagination page=wqtCasesService.selectWqtCasesPage(wqtCases2, pagination);
				  if(page.getList()!=null && page.getList().size()>0)
					  wqtCases.setL_WqtCases(page.getList());
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
	

}
