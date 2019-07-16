package com.wqt.ipr.patent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.patent.dal.PatentProductDao;
import com.wqt.ipr.patent.pojo.IprPatentProduct;
import com.wqt.ipr.patent.service.PatentProductService;

public class PatentProductServiceImpl implements PatentProductService {

	@Autowired
	PatentProductDao patentProductDao;


	@Override
	public List<IprPatentProduct> selectIprPatentProductList(
			IprPatentProduct iprPatentProduct) {
		return patentProductDao.selectIprPatentProductList(iprPatentProduct);
	}

	@Override
	public Pagination selectIprPatentProductPage(
			IprPatentProduct iprPatentProduct, Pagination pagination) {
		return patentProductDao.selectIprPatentProductPage(iprPatentProduct, pagination);
	}



	@Override
	public IprPatentProduct selIprPatentProductOne(IprPatentProduct iprPatentProduct) {
		return patentProductDao.selIprPatentProductOne(iprPatentProduct);
	}
}
