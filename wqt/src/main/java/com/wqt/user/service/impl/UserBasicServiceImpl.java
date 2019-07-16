package com.wqt.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.base.org.security.PwdEncoder;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.user.pojo.UserBasic;
import com.wqt.user.dao.UserBasicDao;
import com.wqt.user.service.UserBasicService;

public class UserBasicServiceImpl implements UserBasicService {

	@Autowired
	private UserBasicDao userBasicDao;
	
	@Autowired
	private PwdEncoder pwdEncoder;
	
	@Override
	public void insertUserBasic(UserBasic wqtUserBasic) {
		 String password=wqtUserBasic.getPassword();
		 wqtUserBasic.setPassword(pwdEncoder.encodePassword(password));
		 userBasicDao.insertUserBasic(wqtUserBasic);
	}

	@Override
	public void deleteUserBasic(String userid) {
		userBasicDao.deleteUserBasic(userid);
	}

	@Override
	public void updateUserBasic(UserBasic wqtUserBasic) {
		if(wqtUserBasic.getPassword()!=null)
		{
			wqtUserBasic.setPassword(pwdEncoder.encodePassword(wqtUserBasic.getPassword()));
		}
		userBasicDao.updateUserBasic(wqtUserBasic);
	}

	@Override
	public UserBasic selectUserById(String userid) {
		return userBasicDao.selectUserById(userid);
	}

	@Override
	public List<UserBasic> selectListUserBasic(UserBasic wqtUserBasic) {
		return userBasicDao.selectListUserBasic(wqtUserBasic);
	}

	@Override
	public Pagination selectPageUserBasic(UserBasic wqtUserBasic,
			Pagination pagination) {
		return userBasicDao.selectPageUserBasic(wqtUserBasic, pagination);
	}

	@Override
	public UserBasic selectUserByUsername(String username) {
		return userBasicDao.selectUserByUsername(username);
	}

	@Override
	public UserBasic selectUserByMobileNo(String mobileno) {
		return userBasicDao.selectUserByMobileNo(mobileno);
	}

	@Override
	public UserBasic userLogin(String userparam) {
		return userBasicDao.userLogin(userparam);
	}

}
