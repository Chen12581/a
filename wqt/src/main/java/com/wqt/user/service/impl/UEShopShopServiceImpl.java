package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UEShopShopDao;
import com.wqt.user.pojo.UEShopShop;
import com.wqt.user.service.UEShopShopService;

public class UEShopShopServiceImpl implements UEShopShopService {
    
	@Autowired
	private UEShopShopDao eShopShopDao;
	
	@Override
	public Pagination selectEShopShopPage(UEShopShop eShopShop,
			Pagination pagination) {
		return eShopShopDao.selectEShopShopPage(eShopShop, pagination);
	}

}
