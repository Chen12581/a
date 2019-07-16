package com.wqt.ipr.brand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.brand.dal.BrandProductDao;
import com.wqt.ipr.brand.pojo.IprBrandProduct;
import com.wqt.ipr.brand.service.BrandProductService;

public class BrandProductServiceImpl implements BrandProductService {

	@Autowired
	private BrandProductDao brandProductDao;
	
	

	@Override
	public List<IprBrandProduct> selBrandProductList(IprBrandProduct iprBrandProduct) {
		return brandProductDao.selBrandProductList(iprBrandProduct);
	}

	@Override
	public Pagination selBrandProductListPage(IprBrandProduct iprBrandProduct, Pagination pagination) {
		return brandProductDao.selBrandProductListPage(iprBrandProduct, pagination);
	}
	
	@Override
	public IprBrandProduct selBrandProductOne(IprBrandProduct iprBrandProduct) {
		return brandProductDao.selBrandProductOne(iprBrandProduct);
	}
}
