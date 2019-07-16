package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UEsShop;
import com.wqt.user.pojo.UIprShop;

public class UEsShopDao  extends SessionDaoSupport{
	
	 /*分页查询企业服务发布的商品*/
	 public Pagination  selectEsShopPage(UEsShop esShop,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<UEsShop> list =this.getSession().selectList("esShop.selectEsShopPage", esShop, pagination);
		pagination.setList(list);
		return pagination;
	 }
}
