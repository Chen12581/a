package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.EsCollectProduct;

public class EsCollectProductDao   extends SessionDaoSupport{
	
    /*分页查询用户收藏*/
    public Pagination  selectEsCollectProductPage(EsCollectProduct esCollectProduct,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<EsCollectProduct> list =this.getSession().selectList("escollect.selectEsCollectProductList", esCollectProduct, pagination);
		pagination.setList(list);
		return pagination;
	}
    
    /*删除用户收藏*/
	public void delEsCollectProduct(EsCollectProduct esCollectProduct)
	{
		this.getSession().delete("escollect.delEsCollectProduct",esCollectProduct);
	}
}
