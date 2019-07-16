package com.wqt.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UserPostDao;
import com.wqt.user.pojo.WqtUserPost;
import com.wqt.user.service.UserPostService;

public class UserPostServiceImpl implements UserPostService {
	
	@Autowired
	UserPostDao userPostDao;
	
	@Override
	public void insertWqtUserPost(WqtUserPost wqtUserPost) {
		userPostDao.insertWqtUserPost(wqtUserPost);
	}

	@Override
	public void deleteWqtUserPost(String userPostid) {
		userPostDao.deleteWqtUserPost(userPostid);
	}

	@Override
	public void updateWqtUserPost(WqtUserPost wqtUserPost) {
		userPostDao.updateWqtUserPost(wqtUserPost);
	}

	@Override
	public WqtUserPost selectOneWqtUserPost(String userPostid) {
		return userPostDao.selectOneWqtUserPost(userPostid);
	}

	@Override
	public List<WqtUserPost> selectListWqtUserPost(WqtUserPost wqtUserPost) {
		return userPostDao.selectListWqtUserPost(wqtUserPost);
	}

	@Override
	public Pagination selectPageWqtUserPost(WqtUserPost wqtUserPost,
			Pagination pagination) {
		return userPostDao.selectPageWqtUserPost(wqtUserPost, pagination);
	}

}
