package com.wqt.cases.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.cases.pojo.WqtCases;

public interface WqtCasesService {
	
	/*分页查询知识产权案列*/
	public Pagination selectWqtCasesPage(WqtCases wqtCases,Pagination pagination);
	
	public WqtCases selectWqtCasesOne(WqtCases wqtCases);
}
