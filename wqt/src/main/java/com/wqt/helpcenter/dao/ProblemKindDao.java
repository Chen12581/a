package com.wqt.helpcenter.dao;

import java.util.List;

import com.problem.pojo.ProblemKind;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;

public class ProblemKindDao   extends SessionDaoSupport{
	
	/*查询问题分类*/
	public List<ProblemKind> selectWqtProblemKind(ProblemKind problemKind) {
		return	this.getSession().selectList("wqthelp.selectWqtProblemKind",problemKind);
	}
	
	/*去重查询问题分类*/
	public List<ProblemKind> distSelectWqtProblemKind() {
		return	this.getSession().selectList("wqthelp.distSelectWqtProblemKind");
	}
	
	/*查询问题大类*/
	public List<ProblemKind> selectdisProblemKind() {
		return	this.getSession().selectList("wqthelp.selectdisProblemKind");
	
	}
}
