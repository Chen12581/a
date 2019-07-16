package com.wqt.helpcenter.dao;

import java.util.List;

import com.problem.pojo.Problem;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;

public class ProblemDao  extends SessionDaoSupport{
	/*新增问题*/
	public void insertWqtProblem(Problem problem) {
		this.getSession().insert("wqthelp.insertWqtProblem",problem);
	}
	
	/*分页查询问题*/
	@SuppressWarnings("unchecked")
	public Pagination selectWqtProblemPage(Problem problem,Pagination pagination) {
		List<Problem> list=this.getSession().selectList("wqthelp.selectWqtProblemList",problem,pagination);
		pagination.setList(list);;
		return pagination;
	}
	
	/*查询单个问题*/
	public Problem selectWqtProblemOne(Problem problem) {
		return (Problem) this.getSession().selectOne("wqthelp.selectWqtProblemList", problem);
	}
	
	/*修改问题*/
	public void updateWqtProblem(Problem problem) {
		this.getSession().update("wqthelp.updateWqtProblem", problem);
	}
	
	/*删除问题*/
	public void deleteWqtProblem(Problem problem) {
		this.getSession().delete("wqthelp.deleteWqtProblem", problem);
	}
	
	/*查询上一个问题*/
	public Problem selectPreWqtProblem(Problem problem) {
		return (Problem) this.getSession().selectOne("wqthelp.selectPreWqtProblem", problem);
	}
	
	/*查询下一个问题*/
	public Problem selectNextWqtProblem(Problem problem) {
		return (Problem) this.getSession().selectOne("wqthelp.selectNextWqtProblem", problem);
	}
}
