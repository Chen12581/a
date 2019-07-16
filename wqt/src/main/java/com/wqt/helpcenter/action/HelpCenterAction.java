package com.wqt.helpcenter.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.problem.pojo.Problem;
import com.problem.pojo.ProblemKind;
import com.talkweb.twdpe.core.cache.CacheManager;
import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.worker.pojo.Worker;
import com.wqt.common.util.CommonUtil;
import com.wqt.helpcenter.pojo.HelpCenterData;
import com.wqt.helpcenter.pojo.ProblemData;
import com.wqt.helpcenter.pojo.ProblemKindData;
import com.wqt.helpcenter.service.WqtProblemKindService;
import com.wqt.helpcenter.service.WqtProblemService;
import com.wqt.worker.service.WorkerService;

/*用户中心及常见问题*/
public class HelpCenterAction  extends BusinessAction{
	     private static final Logger logger = LoggerFactory.getLogger(HelpCenterAction.class);	
	     
	     @Autowired
		 private WqtProblemService wqtProblemService;
	     
	     @Autowired
		 private WqtProblemKindService wqtProblemKindService;
	     
	     @Autowired
		 private  WorkerService workerService;
	     
         private HelpCenterData helpCenterData;
         
         private ProblemData problemData;
         
         private ProblemKindData problemKindData;
         
		 public ProblemKindData getProblemKindData() {
			return problemKindData;
		 }

		 public void setProblemKindData(ProblemKindData problemKindData) {
			this.problemKindData = problemKindData;
		 }

		 public ProblemData getProblemData() {
			return problemData;
		 }

		 public void setProblemData(ProblemData problemData) {
			this.problemData = problemData;
		 }

		 public HelpCenterData getHelpCenterData() {
			return helpCenterData;
		 }

		 public void setHelpCenterData(HelpCenterData helpCenterData) {
			this.helpCenterData = helpCenterData;
		 }
         
		

		 public String helpuser()
         {
        	 HttpServletRequest  request = ServletActionContext.getRequest();
			 HttpServletResponse response = ServletActionContext.getResponse();
			 
			 if(helpCenterData==null)
			 {
				 helpCenterData=new HelpCenterData();
			 }
			 
			 CacheManager _workercache = CacheManager.getInstance();
			 String  workercacheKey = CommonUtil.WORKERS_CACHE+".key";
			 List<Worker> l_wqtWorker = (List<Worker>)_workercache.getObject(CommonUtil.WORKERS_CACHE, workercacheKey);
			 List<Worker> l_Worker=CommonUtil.createRandomList(l_wqtWorker,1);
			 
			 
			 List<Worker> l_iprWorker=(List<Worker>)CommonUtil.RandomKindList(l_wqtWorker,1,"workerkind","ipr");
			 if(l_iprWorker!=null)
			 {
				 helpCenterData.setIprworker(l_iprWorker.get(0));
			 }
			 
			 List<Worker> l_esworker=(List<Worker>)CommonUtil.RandomKindList(l_wqtWorker,1,"workerkind","es");
			 if(l_esworker!=null)
			 {
				 helpCenterData.setEsworker(l_esworker.get(0));
			 }
			 
			 List<Worker> l_serviceworker=(List<Worker>)CommonUtil.RandomKindList(l_wqtWorker,1,"workerkind","service");
			 if(l_serviceworker!=null)
			 {
				 helpCenterData.setServiceworker(l_serviceworker.get(0));
			 }
			 
			 List<Worker> l_partnerworker=(List<Worker>)CommonUtil.RandomKindList(l_wqtWorker,1,"workerkind","partner");
			 if(l_partnerworker!=null)
			 {
				 helpCenterData.setPartnerworker(l_partnerworker.get(0));
			 }
			 
			 List<Worker> l_scheduleworker=(List<Worker>)CommonUtil.RandomKindList(l_wqtWorker,1,"workerkind","schedule");
			 if(l_scheduleworker!=null)
			 {
				 helpCenterData.setScheduleworker(l_scheduleworker.get(0));
			 }
			 
			 List<ProblemKind> l_ProblemKind=new ArrayList<ProblemKind>();
			 List<Problem> l_WqtProblem=new ArrayList<Problem>();
			 List<ProblemKind> l_tProblemKind=wqtProblemKindService.selectdisProblemKind();
			 for(ProblemKind wqtProblemKind:l_tProblemKind)
			 {
				 Pagination pagination=new Pagination(1,5);
				 Problem wqtProblem=new Problem();
				 wqtProblem.setProblemkind(wqtProblemKind.getProblemkind());
				 Pagination page=wqtProblemService.selectWqtProblemPage(wqtProblem, pagination);
				 if(page.getList()!=null && page.getList().size()>0)
				 {
					 l_ProblemKind.add(wqtProblemKind);
					 l_WqtProblem.addAll(page.getList());
				 }
			 }
			 helpCenterData.setL_WqtProblem(l_WqtProblem);
			 helpCenterData.setL_WqtProblemKind(l_ProblemKind);
			 return SUCCESS;
        }
		
		/*常见问题详情页*/
		public String problemInfo()
		{
			 HttpServletRequest  request = ServletActionContext.getRequest();
			 HttpServletResponse response = ServletActionContext.getResponse();
			 String pathkey=request.getParameter("pathkey");
			 
			 if(problemData==null)
			 {
				 problemData=new ProblemData();
			 }
			 
			 List<ProblemKind> l_DisProblemKind=wqtProblemKindService.selectdisProblemKind();
			 List<ProblemKind> l_WqtProblemKind=wqtProblemKindService.selectWqtProblemKind(new ProblemKind());
			 Problem  wqtProblem=new Problem();
			 wqtProblem.setId(pathkey);
			 Problem  rwqtProblem= wqtProblemService.selectWqtProblemOne(wqtProblem);
			 if(rwqtProblem!=null)
			 {
				 problemData.setL_DisProblemKind(l_DisProblemKind);
				 problemData.setL_WqtProblemKind(l_WqtProblemKind);
				 problemData.setWqtProblem(rwqtProblem);
				 
				 Problem tWqtProblem=new Problem();
				 tWqtProblem.setId(rwqtProblem.getId());
				 Problem nextWqtProblem=wqtProblemService.selectNextWqtProblem(tWqtProblem);
				 if(nextWqtProblem!=null)
				 {
					 problemData.setNextwqtProblem(nextWqtProblem); 
				 }
				 
				 Problem preWqtProblem=wqtProblemService.selectPreWqtProblem(tWqtProblem);
				 if(preWqtProblem!=null)
				 {
					 problemData.setPrewqtProblem(preWqtProblem); 
				 }
				 
				 return SUCCESS;
			 }
			 else
			 {
				 return "404";
			 }	
		}
		
		
		/*常见问题分类*/
		public String problemKind()
		{
			 HttpServletRequest  request = ServletActionContext.getRequest();
			 HttpServletResponse response = ServletActionContext.getResponse();
			 String kindkey=request.getParameter("kindkey");
			 String pagenum=request.getParameter("pagenum");
			 String searchkey=request.getParameter("searchkey");
			 
			 if(problemKindData==null)
			 {
				 problemKindData=new ProblemKindData();
			 }
			 problemKindData.setKindkey(kindkey);
			 Pagination pagination=new Pagination(1,10);
			 if(pagenum!=null && !"".equals(pagenum))
		     {
				  if(CommonUtil.isInteger(pagenum))
				  {
				     pagination.setCurrPage(Integer.parseInt(pagenum));
				     problemKindData.setPagenum(pagenum);
				  }
				  else
				  {
					  pagination.setCurrPage(1);
					  problemKindData.setPagenum("1");
				  }
		      }
			 
			 List<ProblemKind> l_DisProblemKind=wqtProblemKindService.selectdisProblemKind();
			 List<ProblemKind> l_WqtProblemKind=wqtProblemKindService.selectWqtProblemKind(new ProblemKind());
			 problemKindData.setL_DisProblemKind(l_DisProblemKind);
			 problemKindData.setL_WqtProblemKind(l_WqtProblemKind);
			 
			 Problem  wqtProblem=new Problem();
			 wqtProblem.setSonproblemkind(kindkey);
			 
			 Pagination page= wqtProblemService.selectWqtProblemPage(wqtProblem, pagination);
			 if(page.getList()!=null && page.getList().size()>0)
			 {
				 problemKindData.setL_WqtProblem(page.getList());
				 problemKindData.setProblemcount(String.valueOf(page.getCount()));
				 problemKindData.setProblempage(String.valueOf(page.getAllPage()));
			 }
			 return SUCCESS;
		}
		
		
		/*常见问题搜索*/
		public String problemSearch()
		{
			 HttpServletRequest  request = ServletActionContext.getRequest();
			 HttpServletResponse response = ServletActionContext.getResponse();
			 String pagenum=request.getParameter("pagenum");
			 String searchkey=request.getParameter("searchkey");
			 
			 if(problemKindData==null)
			 {
				 problemKindData=new ProblemKindData();
			 }
			 problemKindData.setSearchkey(searchkey);
			 Pagination pagination=new Pagination(1,10);
			 if(pagenum!=null && !"".equals(pagenum))
		     {
				  if(CommonUtil.isInteger(pagenum))
				  {
				     pagination.setCurrPage(Integer.parseInt(pagenum));
				     problemKindData.setPagenum(pagenum);
				  }
				  else
				  {
					  pagination.setCurrPage(1);
					  problemKindData.setPagenum("1");
				  }
		      }
			 
			 List<ProblemKind> l_DisProblemKind=wqtProblemKindService.selectdisProblemKind();
			 List<ProblemKind> l_WqtProblemKind=wqtProblemKindService.selectWqtProblemKind(new ProblemKind());
			 problemKindData.setL_DisProblemKind(l_DisProblemKind);
			 problemKindData.setL_WqtProblemKind(l_WqtProblemKind);
			 
			 Problem  wqtProblem=new Problem();
			 wqtProblem.setSearchkey(searchkey);
			 
			 Pagination page= wqtProblemService.selectWqtProblemPage(wqtProblem, pagination);
			 if(page.getList()!=null && page.getList().size()>0)
			 {
				 problemKindData.setL_WqtProblem(page.getList());
				 problemKindData.setProblemcount(String.valueOf(page.getCount()));
				 problemKindData.setProblempage(String.valueOf(page.getAllPage()));
			 }
			 return SUCCESS;
		}
		
		
		/*常见问题搜索*/
		public String aboutus()
		{
			 HttpServletRequest  request = ServletActionContext.getRequest();
			 HttpServletResponse response = ServletActionContext.getResponse();
			 return SUCCESS;
		}
		
}
