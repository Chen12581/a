package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.UIprShopDao;
import com.wqt.user.pojo.UIprShop;
import com.wqt.user.service.UIprShopService;

public class UIprShopServiceImpl implements UIprShopService {
	
	@Autowired
	private UIprShopDao uIprShopDao;
	
	@Override
	public Pagination selectIprShopPage(UIprShop iprShop, Pagination pagination) {
		return uIprShopDao.selectIprShopPage(iprShop, pagination);
	}

}
