package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UEShopOrder;

public class UEShopOrderDao   extends SessionDaoSupport{
	    /*分页查询网店转让订单*/
		 public Pagination  selectEShopOrderPage(UEShopOrder uEShopOrder,Pagination pagination){
			@SuppressWarnings("unchecked")
			List<UEShopOrder> list =this.getSession().selectList("eshopOrder.selectEShopOrderList", uEShopOrder, pagination);
			pagination.setList(list);
			return pagination;
		 }
}
