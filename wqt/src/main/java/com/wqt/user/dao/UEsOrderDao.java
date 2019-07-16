package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UEsOrder;

public class UEsOrderDao  extends SessionDaoSupport{
    
     /*分页查询知识产权订单*/
	 public Pagination  selectEsOrderPage(UEsOrder esOrder,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<UEsOrder> list =this.getSession().selectList("esOrder.selectEsOrderPage", esOrder, pagination);
		pagination.setList(list);
		return pagination;
	 }
}
