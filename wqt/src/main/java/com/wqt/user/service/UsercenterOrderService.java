package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UsercenterOrder;

public interface UsercenterOrderService {
	 public Pagination  selectUserCenterOrderPage(UsercenterOrder usercenterOrder,Pagination pagination);
}
