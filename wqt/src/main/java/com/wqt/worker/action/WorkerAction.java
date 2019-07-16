package com.wqt.worker.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.hessian.HessionFactory;
import com.talkweb.twdpe.core.cache.CacheManager;
import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.user.pojo.UserBasic;
import com.worker.pojo.Worker;
import com.wqt.common.util.CommonUtil;
import com.wqt.worker.pojo.AdviseWorkerData;
import com.wqt.worker.service.WorkerService;

/*业务员管理*/
public class WorkerAction    extends BusinessAction{
	private static final Logger logger = LoggerFactory.getLogger(WorkerAction.class);
    
	@Autowired
	private WorkerService workerService;
	
	
	private AdviseWorkerData adviseWorkerData;
	
	
	public AdviseWorkerData getAdviseWorkerData() {
		return adviseWorkerData;
	}


	public void setAdviseWorkerData(AdviseWorkerData adviseWorkerData) {
		this.adviseWorkerData = adviseWorkerData;
	}



	public String adviser()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
	    HttpServletResponse response = ServletActionContext.getResponse();
	    String pagenum=request.getParameter("pagenum");
	    String workerkind=request.getParameter("workerkind");

	    if(adviseWorkerData==null)
	    {
	    	adviseWorkerData=new AdviseWorkerData();
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
	    
	    adviseWorkerData.setPagenum(pagenum);
	    Pagination pagination=new Pagination(Integer.parseInt(pagenum),10);
	    Worker wqtWorker=new Worker();
	    wqtWorker.setState("1");
	    if(workerkind!=null && (!"".equals(workerkind)))
	    {
	    	wqtWorker.setWorkerkind(workerkind);
	    	adviseWorkerData.setWorkerkind(workerkind);
	    }
	    
	    Pagination page=workerService.selWqtWorkerListPage(wqtWorker, pagination);
	    if(page.getList()!=null && page.getList().size()>0)
		{
	    	adviseWorkerData.setList_adviseWorker(page.getList());
	    	adviseWorkerData.setWorkercount(String.valueOf(page.getCount()));
	    	adviseWorkerData.setWorkerpage(String.valueOf(page.getAllPage()));
		}
	    return SUCCESS;
	}
	
	/*真假客服验证*/
	public String configClient()
	{
		 HttpServletRequest  request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 Map resultMap=new HashMap();
		 String service=request.getParameter("service");
		 if(service!=null && (!"".equals(service.trim())))
		 {
			 Worker worker=new Worker();
			 worker.setTel(service);
			 worker.setMobile(service);
			 worker.setQq(service);
			 worker.setWeixin(service);
			 int result=HessionFactory.workerHession().workerVerify(worker);
			 if(result>0)
			 {
				 resultMap.put("result", true);
			 }
			 else
			 {
				 resultMap.put("result", false); 
			 }
		}
		else
		{
			resultMap.put("result", false); 
		}
		  this.formatData(resultMap);
		 return SUCCESS;
	}
	
}
