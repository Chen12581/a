package com.wqt.ipr.patent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.copyright.pojo.IprCopyrightShop;
import com.wqt.ipr.patent.dal.PatentShopDao;
import com.wqt.ipr.patent.pojo.IprPatentShop;
import com.wqt.ipr.patent.service.PatentShopService;

public class PatentShopServiceImpl implements PatentShopService {
	
	@Autowired
	private PatentShopDao patentShopDao;

	@Override
	public Pagination selectPatentShopList(IprPatentShop iprPatentShop,Pagination pagination) {
		List<IprPatentShop>lists=patentShopDao.selectPatentShopList(iprPatentShop);
		pagination.setList(lists);
		return  pagination;
		
	}
	
	@Override
	public Pagination selectPatentShopPage(IprPatentShop iprPatentShop, Pagination pagination) {
		return patentShopDao.selectPatentShopPage(iprPatentShop, pagination);
	}
	


	@Override
	public IprPatentShop selectPatentShopOne(IprPatentShop iprPatentShop) {
		return patentShopDao.selectPatentShopOne(iprPatentShop);
	}

	
	@Override
	public void updatePatentShop(IprPatentShop iprPatentShop) {
		patentShopDao.updatePatentShop(iprPatentShop);
	}


}
