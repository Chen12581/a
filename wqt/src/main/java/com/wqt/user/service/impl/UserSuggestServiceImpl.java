package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UserSuggestDao;
import com.wqt.user.pojo.WqtUserSuggest;
import com.wqt.user.service.UserSuggestService;

public class UserSuggestServiceImpl implements UserSuggestService {
   
	@Autowired
	UserSuggestDao userSuggestDao;
	
	@Override
	public void insertUserSuggest(WqtUserSuggest wqtUserSuggest) {
		userSuggestDao.insertUserSuggest(wqtUserSuggest);
	}

	@Override
	public Pagination selectPageUserSuggest(WqtUserSuggest wqtUserSuggest,
			Pagination pagination) {
		return userSuggestDao.selectPageUserSuggest(wqtUserSuggest, pagination);
	}

	@Override
	public void updateUserSuggest(WqtUserSuggest wqtUserSuggest) {
		userSuggestDao.updateUserSuggest(wqtUserSuggest);
	}

	@Override
	public WqtUserSuggest selectUserSuggestById(String suggestid) {
		return userSuggestDao.selectUserSuggestById(suggestid);
	}

	@Override
	public void deleteUserSuggest(String suggestid) {
		userSuggestDao.deleteUserSuggest(suggestid);
	}

}
