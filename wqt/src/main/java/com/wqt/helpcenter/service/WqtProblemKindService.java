package com.wqt.helpcenter.service;

import java.util.List;

import com.problem.pojo.ProblemKind;

public interface WqtProblemKindService {
	   public List<ProblemKind> selectWqtProblemKind(ProblemKind problemKind);
	   
	   /*去重查询问题分类*/
		public List<ProblemKind> distSelectWqtProblemKind();
	   
	   public List<ProblemKind> selectdisProblemKind();
}
