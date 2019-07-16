package com.wqt.ipr.cases.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.cases.pojo.IprCases;

public class IprCasesDao extends SessionDaoSupport{
	
	/*新增知识产权案列*/
	public void insertIprCases(IprCases iprCases) {
		this.getSession().insert("iprcases.insertIprCases", iprCases);
	}
	
	/*分页查询知识产权案列*/
	@SuppressWarnings("unchecked")
	public Pagination selectIprCasesPage(IprCases iprCases,Pagination pagination) {
		List<IprCases> list=getSession().selectList("iprcases.selectIprCasesList", iprCases, pagination);
		pagination.setList(list);
		return pagination;
	}
	
	public IprCases selectIprCasesOne(IprCases iprCases) {
		return (IprCases) this.getSession().selectOne("iprcases.selectIprCasesOne", iprCases);
	}
	
	public void updateIprCases(IprCases iprCases) {
		this.getSession().update("iprcases.updateIprCases",iprCases);
	}
	
	public void deleteIprCases(IprCases iprCases) {
		this.getSession().delete("iprcases.deleteIprCases",iprCases);
	}
}
