package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UEsOrderDao;
import com.wqt.user.dao.UIprOrderDao;
import com.wqt.user.pojo.UEsOrder;
import com.wqt.user.service.UEsOrderService;

public class UEsOrderServiceImpl implements UEsOrderService {
    
	@Autowired
	private UEsOrderDao uEsShopDao;
	 
	@Override
	public Pagination selectEsOrderPage(UEsOrder esOrder, Pagination pagination) {
		return uEsShopDao.selectEsOrderPage(esOrder, pagination);
	}

}
