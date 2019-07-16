package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wqt.user.dao.UOrderCancelDao;
import com.wqt.user.pojo.UOrderCancel;
import com.wqt.user.service.UOrderCancelService;

public class UOrderCancelServiceImpl implements UOrderCancelService {
    
	@Autowired
	private UOrderCancelDao uOrderCancelDao;
	
	@Override
	public void insertUOrderCancel(UOrderCancel uOrderCancel) {
		uOrderCancelDao.insertUOrderCancel(uOrderCancel);
	}

}
