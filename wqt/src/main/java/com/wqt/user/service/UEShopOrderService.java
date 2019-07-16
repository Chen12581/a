package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UEShopOrder;

public interface UEShopOrderService {
	 public Pagination  selectEShopOrderPage(UEShopOrder eShopOrder,Pagination pagination);
}
