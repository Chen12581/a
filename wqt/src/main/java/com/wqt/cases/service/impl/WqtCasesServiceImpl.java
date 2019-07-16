package com.wqt.cases.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.cases.dal.WqtCasesDao;
import com.wqt.cases.pojo.WqtCases;
import com.wqt.cases.service.WqtCasesService;

public class WqtCasesServiceImpl implements WqtCasesService {
    
	@Autowired
	private WqtCasesDao wqtCasesDao;

	@Override
	public Pagination selectWqtCasesPage(WqtCases wqtCases, Pagination pagination) {
		// TODO Auto-generated method stub
		return wqtCasesDao.selectWqtCasesPage(wqtCases, pagination);
	}

	@Override
	public WqtCases selectWqtCasesOne(WqtCases wqtCases) {
		// TODO Auto-generated method stub
		return wqtCasesDao.selectWqtCasesOne(wqtCases);
	}
}
