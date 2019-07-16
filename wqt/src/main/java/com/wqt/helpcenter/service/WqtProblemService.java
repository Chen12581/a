package com.wqt.helpcenter.service;

import java.util.List;

import com.problem.pojo.Problem;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;

public interface WqtProblemService {
	
	/*新增问题*/
	public void insertWqtProblem(Problem problem);
	
	/*分页查询问题*/
	@SuppressWarnings("unchecked")
	public Pagination selectWqtProblemPage(Problem problem,Pagination pagination);
	
	/*查询单个问题*/
	public Problem selectWqtProblemOne(Problem problem);
	
	/*修改问题*/
	public void updateWqtProblem(Problem problem);
	
	/*删除问题*/
	public void deleteWqtProblem(Problem problem);
	
	/*查询上一个问题*/
	public Problem selectPreWqtProblem(Problem problem);
	
	/*查询下一个问题*/
	public Problem selectNextWqtProblem(Problem problem);
}
