package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UIprOrder;

public interface UIprOrderService {
	public Pagination  selectIprrOrderPage(UIprOrder iprOrder,Pagination pagination);
}
