package com.wqt.eshop.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.eshop.pojo.EShopOrder;

public interface EShopOrderService {
	
	 /*修改订单*/
	 public void updateEShopOrder(EShopOrder eShopOrder);
	
	
	 /*查询订单*/ 
	 public EShopOrder selectOneEShopOrder(EShopOrder eShopOrder);
	 
  
}
