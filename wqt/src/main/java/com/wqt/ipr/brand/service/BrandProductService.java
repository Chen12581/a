package com.wqt.ipr.brand.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.brand.pojo.IprBrandProduct;

public interface BrandProductService {

	

	/*查询商标服务*/
	public List<IprBrandProduct> selBrandProductList(IprBrandProduct iprBrandProduct);
	
	public Pagination  selBrandProductListPage(IprBrandProduct iprBrandProduct,Pagination pagination);
	
	public IprBrandProduct selBrandProductOne(IprBrandProduct iprBrandProduct);

}
