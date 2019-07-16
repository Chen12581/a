package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UsercenterOrderDao;
import com.wqt.user.pojo.UsercenterOrder;
import com.wqt.user.service.UsercenterOrderService;

public class UsercenterOrderServiceImpl implements UsercenterOrderService {
    
	@Autowired
	private UsercenterOrderDao usercenterOrderDao;
	
	@Override
	public Pagination selectUserCenterOrderPage(
			UsercenterOrder usercenterOrder, Pagination pagination) {
		return usercenterOrderDao.selectUserCenterOrderPage(usercenterOrder, pagination);
	}

}
