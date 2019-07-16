package com.wqt.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.dao.IprCollectProductDao;
import com.wqt.user.pojo.IprCollectProduct;
import com.wqt.user.service.IprCollectProductService;

public class IprCollectProductServiceImpl implements IprCollectProductService {

	@Autowired
	private IprCollectProductDao iprCollectProductDao;
	
	
	@Override
	public Pagination selectIprCollectProductPage(
			IprCollectProduct iprCollectProduct, Pagination pagination) {
		return iprCollectProductDao.selectIprCollectProductPage(iprCollectProduct, pagination);
	}

	@Override
	public void delIprCollectProduct(IprCollectProduct iprCollectProduct) {
		iprCollectProductDao.delIprCollectProduct(iprCollectProduct);
	}

}
