package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UIprShop;

public class UIprShopDao  extends SessionDaoSupport{
	
	 /*分页查询知识产权发布的商品*/
	 public Pagination  selectIprShopPage(UIprShop iprShop,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<UIprShop> list =this.getSession().selectList("iprShop.selectIprShopPage", iprShop, pagination);
		pagination.setList(list);
		return pagination;
	 }
}
