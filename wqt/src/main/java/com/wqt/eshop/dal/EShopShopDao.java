package com.wqt.eshop.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.eshop.pojo.EShopShop;

public class EShopShopDao extends SessionDaoSupport{
	
	/*修改店铺信息*/
	public void updateEShopShop(EShopShop eShopShop)
	{
		this.getSession().update("eshop.updateEShopShop",eShopShop);
	}
	
	/*查询一个店铺*/
	public EShopShop  selectOneEShopShop(EShopShop eShopShop){
		return (EShopShop)this.getSession().selectOne("eshop.selectEShopShopList",eShopShop);
	}
}
