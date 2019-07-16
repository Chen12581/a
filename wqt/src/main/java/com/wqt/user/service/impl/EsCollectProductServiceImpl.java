package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.EsCollectProductDao;
import com.wqt.user.pojo.EsCollectProduct;
import com.wqt.user.service.EsCollectProductService;

public class EsCollectProductServiceImpl implements EsCollectProductService {

	@Autowired
	private EsCollectProductDao esCollectProductDao;
	
	
	

	@Override
	public Pagination selectEsCollectProductPage(
			EsCollectProduct esCollectProduct, Pagination pagination) {
		return esCollectProductDao.selectEsCollectProductPage(esCollectProduct, pagination);
	}

	@Override
	public void delEsCollectProduct(EsCollectProduct esCollectProduct) {
		esCollectProductDao.delEsCollectProduct(esCollectProduct);
	}

}
