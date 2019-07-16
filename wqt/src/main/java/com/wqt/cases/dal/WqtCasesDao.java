package com.wqt.cases.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.cases.pojo.WqtCases;

public class WqtCasesDao  extends SessionDaoSupport{

	/*分页查询知识产权案列*/
	@SuppressWarnings("unchecked")
	public Pagination selectWqtCasesPage(WqtCases wqtCases,Pagination pagination) {
		List<WqtCases> list=getSession().selectList("wqtcases.selectWqtCasesList", wqtCases, pagination);
		pagination.setList(list);
		return pagination;
	}
	
	public WqtCases selectWqtCasesOne(WqtCases wqtCases) {
		return (WqtCases) this.getSession().selectOne("wqtcases.selectWqtCasesOne", wqtCases);
	}
}
