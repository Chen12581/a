package com.wqt.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UserBillDao;
import com.wqt.user.pojo.WqtUserBill;
import com.wqt.user.service.UserBillService;

public class UserBillServiceImpl implements UserBillService {
	
	@Autowired
	UserBillDao userBillDao;
	
	@Override
	public void insertWqtUserBill(WqtUserBill wqtUserBill) {
		userBillDao.insertWqtUserBill(wqtUserBill);
	}

	@Override
	public void deleteWqtUserBill(String userContractid) {
		userBillDao.deleteWqtUserBill(userContractid);
	}

	@Override
	public void updateWqtUserBill(WqtUserBill wqtUserBill) {
		userBillDao.updateWqtUserBill(wqtUserBill);
	}

	@Override
	public WqtUserBill selectOneWqtUserBill(String userContractid) {
		return userBillDao.selectOneWqtUserBill(userContractid);
	}

	@Override
	public List<WqtUserBill> selectListWqtUserBill(WqtUserBill wqtUserBill) {
		return userBillDao.selectListWqtUserBill(wqtUserBill);
	}

	@Override
	public Pagination selectPageWqtUserBill(WqtUserBill wqtUserBill,
			Pagination pagination) {
		return userBillDao.selectPageWqtUserBill(wqtUserBill, pagination);
	}

}
