package com.wqt.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.eshop.dal.EShopOrderDao;
import com.wqt.eshop.pojo.EShopOrder;
import com.wqt.eshop.service.EShopOrderService;

public class EShopOrderServiceImpl implements EShopOrderService {
    
	@Autowired
	private EShopOrderDao eShopOrderDao;

	@Override
	public void updateEShopOrder(EShopOrder eShopOrder) {
		eShopOrderDao.updateEShopOrder(eShopOrder);
	}

	@Override
	public EShopOrder selectOneEShopOrder(EShopOrder eShopOrder) {
		return eShopOrderDao.selectOneEShopOrder(eShopOrder);
	}
}
