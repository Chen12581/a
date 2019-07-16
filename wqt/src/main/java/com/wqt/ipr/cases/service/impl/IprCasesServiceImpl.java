package com.wqt.ipr.cases.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.cases.dal.IprCasesDao;
import com.wqt.ipr.cases.pojo.IprCases;
import com.wqt.ipr.cases.service.IprCasesService;

public class IprCasesServiceImpl implements IprCasesService{
	
	@Autowired
	private IprCasesDao iprCasesDao;

	@Override
	public void insertIprCases(IprCases iprCases) {
		iprCasesDao.insertIprCases(iprCases);
	}

	@Override
	public Pagination selectIprCasesPage(IprCases iprCases, Pagination pagination) {
		return iprCasesDao.selectIprCasesPage(iprCases, pagination);
	}

	@Override
	public IprCases selectIprCasesOne(IprCases iprCases) {
		return iprCasesDao.selectIprCasesOne(iprCases);
	}

	@Override
	public void updateIprCases(IprCases iprCases) {
		iprCasesDao.updateIprCases(iprCases);
	}

	@Override
	public void deleteIprCases(IprCases iprCases) {
		iprCasesDao.deleteIprCases(iprCases);
	}

}
