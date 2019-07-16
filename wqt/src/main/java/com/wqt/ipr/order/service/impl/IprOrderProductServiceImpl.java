package com.wqt.ipr.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.order.dal.IprOrderProductDao;
import com.wqt.ipr.order.pojo.IprBrandOrderProduct;
import com.wqt.ipr.order.pojo.IprCopyrightOrderProduct;
import com.wqt.ipr.order.pojo.IprOrderProduct;
import com.wqt.ipr.order.pojo.IprPatentOrderProduct;
import com.wqt.ipr.order.service.IprOrderProductService;

public class IprOrderProductServiceImpl implements IprOrderProductService {
   
	@Autowired
	private IprOrderProductDao iprOrderProductDao;
	
	@Override
	public void deleteIprOrderProduct(IprOrderProduct iprOrderProduct) {
		iprOrderProductDao.deleteIprOrderProduct(iprOrderProduct);
	}

	@Override
	public void updateIprOrderProduct(IprOrderProduct iprOrderProduct) {
		iprOrderProductDao.updateIprOrderProduct(iprOrderProduct);
	}

	@Override
	public List<IprOrderProduct> selectIprOrderProductList(
			IprOrderProduct iprOrderProduct) {
		return iprOrderProductDao.selectIprOrderProductList(iprOrderProduct);
	}

	@Override
	public Pagination selectIprOrderProductPage(
			IprOrderProduct iprOrderProduct, Pagination pagination) {
		return iprOrderProductDao.selectIprOrderProductPage(iprOrderProduct, pagination);
	}

	@Override
	public IprOrderProduct selectOneIprOrderProduct(
			IprOrderProduct iprOrderProduct) {
		return iprOrderProductDao.selectOneIprOrderProduct(iprOrderProduct);
	}

	@Override
	public IprBrandOrderProduct selectIprBrandOrderProduct(
			IprOrderProduct iprOrderProduct) {
		return iprOrderProductDao.selectIprBrandOrderProduct(iprOrderProduct);
	}

	@Override
	public IprCopyrightOrderProduct selectIprCopyrightOrderProduct(
			IprOrderProduct iprOrderProduct) {
		return iprOrderProductDao.selectIprCopyrightOrderProduct(iprOrderProduct);
	}

	@Override
	public IprPatentOrderProduct selectIprPatentOrderProduct(
			IprOrderProduct iprOrderProduct) {
		return iprOrderProductDao.selectIprPatentOrderProduct(iprOrderProduct);
	}

}
