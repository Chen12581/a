package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UserCollectDao;
import com.wqt.user.pojo.UserCollect;
import com.wqt.user.service.UserCollectService;

public class UserCollectServiceImpl implements UserCollectService {
	
    @Autowired
	private  UserCollectDao userCollectDao;

	@Override
	public Pagination selectUserCollectPage(UserCollect userCollect,
			Pagination pagination) {
		return userCollectDao.selectUserCollectPage(userCollect, pagination);
	}
    
	

}
