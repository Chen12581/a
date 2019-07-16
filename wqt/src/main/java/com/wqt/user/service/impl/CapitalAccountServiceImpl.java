package com.wqt.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.CapitalAccountDao;
import com.wqt.user.pojo.WqtCapitalAccount;
import com.wqt.user.service.CapitalAccountService;

public class CapitalAccountServiceImpl implements CapitalAccountService {
   
	@Autowired
	private CapitalAccountDao capitalAccountDao;
	
	@Override
	public void insertCapitalAccount(WqtCapitalAccount wqtCapitalAccount) {
		capitalAccountDao.insertCapitalAccount(wqtCapitalAccount);
	}

	@Override
	public void updateCapitalAccount(WqtCapitalAccount wqtCapitalAccount) {
		capitalAccountDao.updateCapitalAccount(wqtCapitalAccount);
	}

	@Override
	public void deleteCapitalAccount(String capitalaccountid) {
		capitalAccountDao.deleteCapitalAccount(capitalaccountid);
	}

	@Override
	public WqtCapitalAccount selectCapitalAccountById(String capitalaccountid) {
		return capitalAccountDao.selectCapitalAccountById(capitalaccountid);
	}

	@Override
	public WqtCapitalAccount selectOneCapitalAccount(
			WqtCapitalAccount wqtCapitalAccount) {
		return capitalAccountDao.selectOneCapitalAccount(wqtCapitalAccount);
	}

	@Override
	public List<WqtCapitalAccount> selectCapitalAccountList(
			WqtCapitalAccount wqtCapitalAccount) {
		return capitalAccountDao.selectCapitalAccountList(wqtCapitalAccount);
	}

	@Override
	public Pagination selectCapitalAccountPage(
			WqtCapitalAccount wqtCapitalAccount, Pagination pagination) {
		return capitalAccountDao.selectCapitalAccountPage(wqtCapitalAccount, pagination);
	}

}
