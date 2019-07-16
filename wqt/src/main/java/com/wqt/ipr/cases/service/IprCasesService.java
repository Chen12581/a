package com.wqt.ipr.cases.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.cases.pojo.IprCases;

public interface IprCasesService {
	
	/*新增知识产权案列*/
	public void insertIprCases(IprCases iprCases);
	
	/*分页查询知识产权案列*/
	public Pagination selectIprCasesPage(IprCases iprCases,Pagination pagination);
	
	public IprCases selectIprCasesOne(IprCases iprCases);
	
	public void updateIprCases(IprCases iprCases);
	
	public void deleteIprCases(IprCases iprCases);
}
