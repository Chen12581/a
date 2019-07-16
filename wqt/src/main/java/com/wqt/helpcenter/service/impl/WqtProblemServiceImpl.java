package com.wqt.helpcenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.problem.pojo.Problem;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.helpcenter.dao.ProblemDao;
import com.wqt.helpcenter.service.WqtProblemService;

public class WqtProblemServiceImpl implements WqtProblemService {
   
	@Autowired
	private ProblemDao wqtProblemDao;
	@Override
	public void insertWqtProblem(Problem problem) {
		wqtProblemDao.insertWqtProblem(problem);
	}

	@Override
	public Pagination selectWqtProblemPage(Problem problem,
			Pagination pagination) {
		return wqtProblemDao.selectWqtProblemPage(problem, pagination);
	}

	@Override
	public Problem selectWqtProblemOne(Problem problem) {
		return wqtProblemDao.selectWqtProblemOne(problem);
	}

	@Override
	public void updateWqtProblem(Problem problem) {
		wqtProblemDao.updateWqtProblem(problem);
	}

	@Override
	public void deleteWqtProblem(Problem problem) {
		wqtProblemDao.deleteWqtProblem(problem);
	}

	@Override
	public Problem selectPreWqtProblem(Problem problem) {
		return wqtProblemDao.selectPreWqtProblem(problem);
	}

	@Override
	public Problem selectNextWqtProblem(Problem problem) {
		return wqtProblemDao.selectNextWqtProblem(problem);
	}

}
