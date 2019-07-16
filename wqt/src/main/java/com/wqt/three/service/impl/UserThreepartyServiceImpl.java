package com.wqt.three.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wqt.three.dao.UserThreepartyDao;
import com.wqt.three.pojo.WqtUserThreeparty;
import com.wqt.three.service.UserThreepartyService;

public class UserThreepartyServiceImpl implements UserThreepartyService {
    
	@Autowired
	private  UserThreepartyDao userThreepartyDao;
	
	@Override
	public void insertUserThreeparty(WqtUserThreeparty wqtUserThreeparty) {
		userThreepartyDao.insertUserThreeparty(wqtUserThreeparty);
	}

	@Override
	public WqtUserThreeparty selectUserThreepartyOne(
			WqtUserThreeparty wqtUserThreeparty) {
		return userThreepartyDao.selectUserThreepartyOne(wqtUserThreeparty);
	}

	@Override
	public void updateUserThreeparty(WqtUserThreeparty wqtUserThreeparty) {
		userThreepartyDao.updateUserThreeparty(wqtUserThreeparty);
	}

	@Override
	public List<WqtUserThreeparty> selectUserThreepartyList(
			WqtUserThreeparty wqtUserThreeparty) {
		return userThreepartyDao.selectUserThreepartyList(wqtUserThreeparty);
	}

}
