package com.wqt.worker.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.worker.pojo.Worker;
import com.wqt.worker.pojo.WqtWorkerKind;

public interface WorkerService {
	
    public Worker randomWorker(Worker worker);
    
    public List<Worker> selWqtWorkerList(Worker worker);
	 
    public Pagination selWqtWorkerListPage(Worker worker , Pagination pagination);
    
    /*修改业务员信息*/
    public Worker selWqtWorkerOne(Worker worker);
    
    
    public List<WqtWorkerKind> selWorkerKind(WqtWorkerKind wqtWorkerKind);
    
    public List<Worker> confirmWorker(Worker worker);
}
