package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UIprOrder;

public class UIprOrderDao  extends SessionDaoSupport{
    
     /*分页查询知识产权订单*/
	 public Pagination  selectIprrOrderPage(UIprOrder iprOrder,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<UIprOrder> list =this.getSession().selectList("iprOrder.selectIprrOrderPage", iprOrder, pagination);
		pagination.setList(list);
		return pagination;
	 }
}
