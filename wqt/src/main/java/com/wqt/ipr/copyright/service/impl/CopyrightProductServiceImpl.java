package com.wqt.ipr.copyright.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.copyright.dal.CopyrightProductDao;
import com.wqt.ipr.copyright.pojo.IprCopyrightProduct;
import com.wqt.ipr.copyright.service.CopyrightProductService;

public class CopyrightProductServiceImpl implements CopyrightProductService{
	@Autowired
	private CopyrightProductDao copyrightProductDao;
	

	@Override
	public Pagination selectCopyrightProduct(IprCopyrightProduct iprCopyrightProduct,Pagination pagination) {
		// TODO Auto-generated method stub
		List<IprCopyrightProduct> l_copyrightProduct = copyrightProductDao.selectCopyrightProduct(iprCopyrightProduct);
		pagination.setList(l_copyrightProduct);
		return pagination;
	}


	@Override
	public Pagination selectCopyrightProductPage(IprCopyrightProduct iprCopyrightProduct, Pagination pagination) {
		return copyrightProductDao.selectCopyrightProductPage(iprCopyrightProduct, pagination);
	}

	@Override
	public IprCopyrightProduct selectCopyrightProductOne(IprCopyrightProduct iprCopyrightProduct) {
		// TODO Auto-generated method stub
		return copyrightProductDao.selectCopyrightProductOne(iprCopyrightProduct);
	}
	
}
