package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UEShopShop;

public class UEShopShopDao   extends SessionDaoSupport{
	/*分页查询挂卖的网店信息*/
	 public Pagination  selectEShopShopPage(UEShopShop eShopShop,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<UEShopShop> list =this.getSession().selectList("eshopShop.selectEShopShopList", eShopShop, pagination);
		pagination.setList(list);
		return pagination;
	 }
}
