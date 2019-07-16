package com.wqt.worker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.worker.pojo.Worker;
import com.wqt.worker.dal.WorkerDao;
import com.wqt.worker.pojo.WqtWorkerKind;
import com.wqt.worker.service.WorkerService;
public class WorkerServiceImpl implements WorkerService {
	
	@Autowired
	WorkerDao workerDao;

	@Override
	public Worker randomWorker(Worker worker) {
		return workerDao.randomWorker(worker);
	}

	@Override
	public List<Worker> selWqtWorkerList(Worker wqtWorker) {
		return workerDao.selWqtWorkerList(wqtWorker);
	}


	@Override
	public Worker selWqtWorkerOne(Worker worker) {
		return workerDao.selWqtWorkerOne(worker);
	}

	@Override
	public Pagination selWqtWorkerListPage(Worker worker, Pagination pagination) {
		return workerDao.selWqtWorkerListPage(worker, pagination);
	}

	@Override
	public List<WqtWorkerKind> selWorkerKind(WqtWorkerKind wqtWorkerKind) {
		return workerDao.selWorkerKind(wqtWorkerKind);
	}

	@Override
	public List<Worker> confirmWorker(Worker worker) {
		return workerDao.confirmWorker(worker);
	}
	
	
}
