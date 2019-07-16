package com.wqt.ipr.copyright.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.copyright.dal.CopyrightShopDao;
import com.wqt.ipr.copyright.pojo.IprCopyrightShop;
import com.wqt.ipr.copyright.service.CopyrightShopService;

public class CopyrightShopServiceImpl implements CopyrightShopService{
	@Autowired
	private CopyrightShopDao copyrightShopDao;

	@Override
	public void updateCopyrightShop(IprCopyrightShop iprCopyrightShop) {
		// TODO Auto-generated method stub
		copyrightShopDao.updateCopyrightShop(iprCopyrightShop);
	}

	@Override
	public List<IprCopyrightShop> selectCopyrightShopList(IprCopyrightShop iprCopyrightShop) {
		return copyrightShopDao.selectCopyrightShopList(iprCopyrightShop);
	}

	public Pagination selectCopyrightShopPage(IprCopyrightShop iprCopyrightShop,
			Pagination pagination) {
		return copyrightShopDao.selectCopyrightShopPage(iprCopyrightShop, pagination);
	}
	
	@Override
	public IprCopyrightShop selectCopyrightShopOne(IprCopyrightShop iprCopyrightShop) {
		return copyrightShopDao.selectCopyrightShopOne(iprCopyrightShop);
	}
}
