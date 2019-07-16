package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.IprCollectShopDao;
import com.wqt.user.pojo.IprCollectShop;
import com.wqt.user.service.IprCollectShopService;

public class IprCollectShopServiceImpl implements IprCollectShopService {

	@Autowired
	private IprCollectShopDao iprCollectShopDao;
	
	
	

	@Override
	public Pagination selectIprCollectShopPage(
			IprCollectShop iprCollectShop, Pagination pagination) {
		return iprCollectShopDao.selectIprCollectShopPage(iprCollectShop, pagination);
	}

	@Override
	public void delIprCollectShop(IprCollectShop iprCollectShop) {
		iprCollectShopDao.delIprCollectShop(iprCollectShop);
	}

}
