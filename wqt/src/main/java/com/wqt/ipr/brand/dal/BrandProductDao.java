package com.wqt.ipr.brand.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.brand.pojo.IprBrandProduct;
import com.wqt.ipr.brand.pojo.IprBrandShop;

public class BrandProductDao extends SessionDaoSupport{
	/*查询商标服务*/
	public List<IprBrandProduct> selBrandProductList(IprBrandProduct iprBrandProduct){
		return this.getSession().selectList("iprbrand.selBrandProductList",iprBrandProduct);
	}
	
	/*查询商标服务*/
	public IprBrandProduct selBrandProductOne(IprBrandProduct iprBrandProduct){
		return (IprBrandProduct) this.getSession().selectOne("iprbrand.selBrandProductOne",iprBrandProduct);
	}
	
	public Pagination  selBrandProductListPage(IprBrandProduct iprBrandProduct,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<IprBrandProduct> list =this.getSession().selectList("iprbrand.selBrandProductList", iprBrandProduct, pagination);
		pagination.setList(list);
		return pagination;
	 }
	
}
