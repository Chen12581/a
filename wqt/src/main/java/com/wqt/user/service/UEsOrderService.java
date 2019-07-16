package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UEsOrder;

public interface UEsOrderService {
	public Pagination  selectEsOrderPage(UEsOrder esOrder,Pagination pagination);
}
