package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UIprShop;

public interface UIprShopService {
	public Pagination  selectIprShopPage(UIprShop iprShop,Pagination pagination);
}
