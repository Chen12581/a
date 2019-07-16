package com.wqt.eshop.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.eshop.pojo.EShopOrder;

public class EShopOrderDao   extends SessionDaoSupport{
	
	 /*修改订单*/
	 public void updateEShopOrder(EShopOrder eShopOrder)
	 {
		this.getSession().update("eshopOrder.updateEShopOrder",eShopOrder);
	 }
	
	 /*查询订单*/
	 public EShopOrder selectOneEShopOrder(EShopOrder eShopOrder)
	 {
		 return (EShopOrder)getSession().selectOne("eshopOrder.selectOneEShopOrder",eShopOrder);
	 }
	 
}
