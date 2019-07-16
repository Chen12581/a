package com.wqt.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UserContractDao;
import com.wqt.user.pojo.WqtUserContract;
import com.wqt.user.service.UserContractService;

public class UserContractServiceImpl implements UserContractService {
	
	@Autowired
	UserContractDao userContractDao;
	
	@Override
	public void insertWqtUserContract(WqtUserContract wqtUserContract) {
		userContractDao.insertWqtUserContract(wqtUserContract);
	}

	@Override
	public void deleteWqtUserContract(String userContractid) {
		userContractDao.deleteWqtUserContract(userContractid);
	}

	@Override
	public void updateWqtUserContract(WqtUserContract wqtUserContract) {
		userContractDao.updateWqtUserContract(wqtUserContract);
	}

	@Override
	public WqtUserContract selectOneWqtUserContract(String userContractid) {
		return userContractDao.selectOneWqtUserContract(userContractid);
	}

	@Override
	public List<WqtUserContract> selectListWqtUserContract(
			WqtUserContract wqtUserContract) {
		return userContractDao.selectListWqtUserContract(wqtUserContract);
	}

	@Override
	public Pagination selectPageWqtUserContract(
			WqtUserContract wqtUserContract, Pagination pagination) {
		return userContractDao.selectPageWqtUserContract(wqtUserContract, pagination);
	}

}
