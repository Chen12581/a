package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.IprCollectProduct;

public class IprCollectProductDao   extends SessionDaoSupport{


    /*分页查询用户收藏*/
    public Pagination  selectIprCollectProductPage(IprCollectProduct iprCollectProduct,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<IprCollectProduct> list =this.getSession().selectList("iprcollect.selectIprCollectProductList", iprCollectProduct, pagination);
		pagination.setList(list);
		return pagination;
	}
    
    /*删除用户收藏*/
	public void delIprCollectProduct(IprCollectProduct iprCollectProduct)
	{
		this.getSession().delete("iprcollect.delIprCollectProduct",iprCollectProduct);
	}
}
