package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UEsShop;

public interface UEsShopService {
	public Pagination  selectEsShopPage(UEsShop esShop,Pagination pagination);
}
