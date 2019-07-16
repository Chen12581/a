package com.wqt.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.eshop.dal.EShopShopDao;
import com.wqt.eshop.pojo.EShopShop;
import com.wqt.eshop.service.EShopShopService;


public class EShopShopServiceImpl implements EShopShopService {
	
	@Autowired
	private EShopShopDao eShopShopDao;
	

	@Override
	public void updateEShopShop(EShopShop eShopShop) {
		eShopShopDao.updateEShopShop(eShopShop);
	}

	@Override
	public EShopShop selectOneEShopShop(EShopShop eShopShop) {
		return eShopShopDao.selectOneEShopShop(eShopShop);
	}




}
