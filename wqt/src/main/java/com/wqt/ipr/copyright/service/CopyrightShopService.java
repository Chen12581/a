package com.wqt.ipr.copyright.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.copyright.pojo.IprCopyrightShop;

public interface CopyrightShopService {
	public void updateCopyrightShop(IprCopyrightShop iprCopyrightShop) ;
	
	public List<IprCopyrightShop> selectCopyrightShopList(IprCopyrightShop iprCopyrightShop) ;
	
	public IprCopyrightShop selectCopyrightShopOne(IprCopyrightShop iprCopyrightShop) ;

	public Pagination selectCopyrightShopPage(IprCopyrightShop iprCopyrightShop, Pagination pagination);
	
}
