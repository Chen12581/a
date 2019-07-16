package com.wqt.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UserBankDao;
import com.wqt.user.pojo.WqtUserBank;
import com.wqt.user.service.UserBankService;

public class UserBankServiceImpl implements UserBankService {
    
	@Autowired
	private UserBankDao userBankDao;
	
	@Override
	public void insertUserBank(WqtUserBank wqtUserBank) {
		userBankDao.insertUserBank(wqtUserBank);
	}

	@Override
	public void deleteUserBank(WqtUserBank wqtUserBank) {
		userBankDao.deleteUserBank(wqtUserBank);
	}

	@Override
	public void updateUserBank(WqtUserBank wqtUserBank) {
		userBankDao.updateUserBank(wqtUserBank);
	}

	@Override
	public WqtUserBank selectOneUser(WqtUserBank wqtUserBank) {
		return userBankDao.selectOneUser(wqtUserBank);
	}

	@Override
	public List<WqtUserBank> selectListUserBank(WqtUserBank wqtUserBank) {
		return userBankDao.selectListUserBank(wqtUserBank);
	}

	@Override
	public Pagination selectPageUserBank(WqtUserBank wqtUserBank,
			Pagination pagination) {
		return userBankDao.selectPageUserBank(wqtUserBank, pagination);
	}

}
