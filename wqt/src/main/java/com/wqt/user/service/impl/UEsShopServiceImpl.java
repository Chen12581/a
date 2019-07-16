package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UEsShopDao;
import com.wqt.user.pojo.UEsShop;
import com.wqt.user.service.UEsShopService;

public class UEsShopServiceImpl implements UEsShopService {
    
	@Autowired
	private UEsShopDao uEsShopDao;
	
	@Override
	public Pagination selectEsShopPage(UEsShop esShop, Pagination pagination) {
		return uEsShopDao.selectEsShopPage(esShop, pagination);
	}

}
