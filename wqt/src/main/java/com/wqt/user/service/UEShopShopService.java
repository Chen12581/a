package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UEShopShop;

public interface UEShopShopService {
	public Pagination  selectEShopShopPage(UEShopShop eShopShop,Pagination pagination);
}
