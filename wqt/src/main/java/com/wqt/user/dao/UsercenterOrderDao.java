package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UsercenterOrder;

public class UsercenterOrderDao   extends SessionDaoSupport{
	 /*分页查询知识产权发布的商品*/
	 public Pagination  selectUserCenterOrderPage(UsercenterOrder usercenterOrder,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<UsercenterOrder> list =this.getSession().selectList("wqtuser.selectUserCenterOrderPage", usercenterOrder, pagination);
		pagination.setList(list);
		return pagination;
	 }
}
