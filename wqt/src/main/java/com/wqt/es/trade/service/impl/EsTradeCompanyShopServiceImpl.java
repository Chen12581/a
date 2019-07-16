package com.wqt.es.trade.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.es.trade.dal.EsTradeCompanyShopDao;
import com.wqt.es.trade.pojo.EsTradeCompanyShop;
import com.wqt.es.trade.service.EsTradeCompanyShopService;

public class EsTradeCompanyShopServiceImpl implements EsTradeCompanyShopService{
	
	@Autowired
	private EsTradeCompanyShopDao esTradeCompanyShopDao;

	@Override
	public void insertEsTradeCompanyShop(EsTradeCompanyShop esTradeCompanyShop) {
		esTradeCompanyShopDao.insertEsTradeCompanyShop(esTradeCompanyShop);
	}

	@Override
	public Pagination selectEsTradeCompanyShopPage(EsTradeCompanyShop esTradeCompanyShop, Pagination pagination) {
		return esTradeCompanyShopDao.selectEsTradeCompanyShopPage(esTradeCompanyShop, pagination);
	}

	@Override
	public EsTradeCompanyShop selectEsTradeCompanyShopOne(EsTradeCompanyShop esTradeCompanyShop) {
		return esTradeCompanyShopDao.selectEsTradeCompanyShopOne(esTradeCompanyShop);
	}

	@Override
	public void updateEsTradeCompanyShop(EsTradeCompanyShop esTradeCompanyShop) {
		esTradeCompanyShopDao.updateEsTradeCompanyShop(esTradeCompanyShop);
	}

	@Override
	public void deleteCompany(EsTradeCompanyShop esTradeCompanyShop) {
		esTradeCompanyShopDao.deleteCompany(esTradeCompanyShop);
	}
	


}
