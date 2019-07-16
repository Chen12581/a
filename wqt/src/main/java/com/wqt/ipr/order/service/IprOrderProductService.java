package com.wqt.ipr.order.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.order.pojo.IprBrandOrderProduct;
import com.wqt.ipr.order.pojo.IprCopyrightOrderProduct;
import com.wqt.ipr.order.pojo.IprOrderProduct;
import com.wqt.ipr.order.pojo.IprPatentOrderProduct;

public interface IprOrderProductService {
	public void deleteIprOrderProduct(IprOrderProduct iprOrderProduct);
	
	public void updateIprOrderProduct(IprOrderProduct iprOrderProduct);
	
	public List<IprOrderProduct> selectIprOrderProductList(IprOrderProduct iprOrderProduct);
	
	public IprOrderProduct selectOneIprOrderProduct(IprOrderProduct iprOrderProduct);
	
	public Pagination  selectIprOrderProductPage(IprOrderProduct iprOrderProduct,Pagination pagination);
	
	/*查询商标订单详情*/
	public IprBrandOrderProduct selectIprBrandOrderProduct(IprOrderProduct iprOrderProduct);
	
	/*查询版权订单详情*/
	public IprCopyrightOrderProduct selectIprCopyrightOrderProduct(IprOrderProduct iprOrderProduct);
	
	/*查询专利订单详情*/
	public IprPatentOrderProduct selectIprPatentOrderProduct(IprOrderProduct iprOrderProduct);
}
