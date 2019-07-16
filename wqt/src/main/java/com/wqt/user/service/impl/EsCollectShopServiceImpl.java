package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.EsCollectShopDao;
import com.wqt.user.pojo.EsCollectShop;
import com.wqt.user.service.EsCollectShopService;

public class EsCollectShopServiceImpl implements EsCollectShopService {

	@Autowired
	private EsCollectShopDao esCollectShopDao;
	

	@Override
	public Pagination selectEsCollectShopPage(
			EsCollectShop esCollectShop, Pagination pagination) {
		return esCollectShopDao.selectEsCollectShopPage(esCollectShop, pagination);
	}

	@Override
	public void delEsCollectShop(EsCollectShop esCollectShop) {
		esCollectShopDao.delEsCollectShop(esCollectShop);
	}

}
