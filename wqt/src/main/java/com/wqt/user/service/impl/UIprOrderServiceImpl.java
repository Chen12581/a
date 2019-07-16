package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UIprOrderDao;
import com.wqt.user.pojo.UIprOrder;
import com.wqt.user.service.UIprOrderService;

public class UIprOrderServiceImpl implements UIprOrderService {
	
    @Autowired
    private UIprOrderDao uIprOrderDao;
    
	@Override
	public Pagination selectIprrOrderPage(UIprOrder iprOrder,
			Pagination pagination) {
		return uIprOrderDao.selectIprrOrderPage(iprOrder, pagination);
	}

}
