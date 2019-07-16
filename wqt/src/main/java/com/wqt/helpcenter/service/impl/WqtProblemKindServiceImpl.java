package com.wqt.helpcenter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.problem.pojo.ProblemKind;
import com.wqt.helpcenter.dao.ProblemKindDao;
import com.wqt.helpcenter.service.WqtProblemKindService;

public class WqtProblemKindServiceImpl implements WqtProblemKindService {
    
	@Autowired
	private ProblemKindDao problemKindDao;
	@Override
	public List<ProblemKind> selectWqtProblemKind( ProblemKind problemKind) {
		return problemKindDao.selectWqtProblemKind(problemKind);
	}

	@Override
	public List<ProblemKind> selectdisProblemKind() {
		return problemKindDao.selectdisProblemKind();
	}

	@Override
	public List<ProblemKind> distSelectWqtProblemKind() {
		return problemKindDao.distSelectWqtProblemKind();
	}


}
