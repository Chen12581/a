package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UEShopOrderDao;
import com.wqt.user.pojo.UEShopOrder;
import com.wqt.user.service.UEShopOrderService;

public class UEShopOrderServiceImpl implements UEShopOrderService {
   @Autowired
	private UEShopOrderDao eShopOrderDao;
   
	@Override
	public Pagination selectEShopOrderPage(UEShopOrder eShopOrder,
			Pagination pagination) {
		return eShopOrderDao.selectEShopOrderPage(eShopOrder, pagination);
	}

}
