package com.wqt.ipr.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.order.dal.IprOrderShopDao;
import com.wqt.ipr.order.pojo.IprBrandOrderShop;
import com.wqt.ipr.order.pojo.IprCopyrightOrderShop;
import com.wqt.ipr.order.pojo.IprOrderShop;
import com.wqt.ipr.order.pojo.IprPatentOrderShop;
import com.wqt.ipr.order.service.IprOrderShopService;

public class IprOrderShopServiceImpl implements IprOrderShopService {
	@Autowired
	private IprOrderShopDao  iprOrderShopDao;
	
	@Override
	public void deleteIprOrderShop(IprOrderShop iprOrderShop) {
		iprOrderShopDao.deleteIprOrderShop(iprOrderShop);
	}

	@Override
	public void updateIprOrderShop(IprOrderShop iprOrderShop) {
		iprOrderShopDao.updateIprOrderShop(iprOrderShop);
	}

	@Override
	public List<IprOrderShop> selectIprOrderShopList(IprOrderShop iprOrderShop) {
		return iprOrderShopDao.selectIprOrderShopList(iprOrderShop);
	}

	@Override
	public Pagination selectIprOrderShopPage(IprOrderShop iprOrderShop,
			Pagination pagination) {
		return iprOrderShopDao.selectIprOrderShopPage(iprOrderShop, pagination);
	}

	@Override
	public IprOrderShop selectOneIprOrderShop(IprOrderShop iprOrderShop) {
		return iprOrderShopDao.selectOneIprOrderShop(iprOrderShop);
	}

	@Override
	public IprBrandOrderShop selectIprBrandOrderShop(IprOrderShop iprOrderShop) {
		return iprOrderShopDao.selectIprBrandOrderShop(iprOrderShop);
	}

	@Override
	public IprCopyrightOrderShop selectIprCopyrightOrderShop(
			IprOrderShop iprOrderShop) {
		return iprOrderShopDao.selectIprCopyrightOrderShop(iprOrderShop);
	}

	@Override
	public IprPatentOrderShop selectIprPatentOrderShop(IprOrderShop iprOrderShop) {
		return iprOrderShopDao.selectIprPatentOrderShop(iprOrderShop);
	}

}
