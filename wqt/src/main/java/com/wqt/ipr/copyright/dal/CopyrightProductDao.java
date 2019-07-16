package com.wqt.ipr.copyright.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.brand.pojo.IprBrandProduct;
import com.wqt.ipr.brand.pojo.IprBrandShop;
import com.wqt.ipr.copyright.pojo.IprCopyrightProduct;

public class CopyrightProductDao extends SessionDaoSupport{
	@SuppressWarnings("unchecked")
	public List<IprCopyrightProduct> selectCopyrightProduct(IprCopyrightProduct iprCopyrightProduct){
		return this.getSession().selectList("iprCopyright.selectCopyrightProduct", iprCopyrightProduct);
	}
	
	/*查询版权服务*/
	public IprCopyrightProduct selectCopyrightProductOne(IprCopyrightProduct iprCopyrightProduct){
		return (IprCopyrightProduct) this.getSession().selectOne("iprCopyright.selectCopyrightProductOne",iprCopyrightProduct);
	}
	
	public Pagination  selectCopyrightProductPage(IprCopyrightProduct iprCopyrightProduct,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<IprCopyrightProduct> list =this.getSession().selectList("iprCopyright.selectCopyrightProduct", iprCopyrightProduct, pagination);
		pagination.setList(list);
		return pagination;
	 }
}
