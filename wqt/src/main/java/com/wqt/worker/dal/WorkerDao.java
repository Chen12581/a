package com.wqt.worker.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.worker.pojo.Worker;
import com.wqt.worker.pojo.WqtWorkerKind;
public class WorkerDao extends SessionDaoSupport {
	
	 /*业务员列表*/
	 public List<Worker> selWqtWorkerList(Worker worker)
     {
   	     return this.getSession().selectList("wqtworker.selWqtWorkerList", worker);
     }
  
	 
     /*随机查询业务员信息*/
     public  Worker randomWorker(Worker worker)
     {
   	     return (Worker)this.getSession().selectOne("wqtworker.randomWorker", worker);
     }
     
     @SuppressWarnings("unchecked")
     public Pagination selWqtWorkerListPage(Worker worker , Pagination pagination) {
		List<Worker> list=this.getSession().selectList("wqtworker.selWqtWorkerList",worker,pagination);
		pagination.setList(list);
		return pagination;
     }
     
     public Worker selWqtWorkerOne(Worker worker) {
		return (Worker) this.getSession().selectOne("wqtworker.selWqtWorkerOne", worker);
     }
     
     public List<Worker> confirmWorker(Worker worker) {
 		return  this.getSession().selectList("wqtworker.confirmWorker", worker);
      }
     
     
     public void delWqtWorker(Worker worker) {
    	 this.getSession().delete("wqtworker.delWqtWorker",worker);
     }
     
     public List<WqtWorkerKind> selWorkerKind(WqtWorkerKind wqtWorkerKind){
		return this.getSession().selectList("wqtworker.selWorkerKind",wqtWorkerKind);
    	 
     }
}
