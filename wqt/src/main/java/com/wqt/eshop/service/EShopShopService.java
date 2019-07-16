package com.wqt.eshop.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.eshop.pojo.EShopShop;

public interface EShopShopService {
	   
	   public void updateEShopShop(EShopShop eShopShop);
	   
	   public EShopShop  selectOneEShopShop(EShopShop eShopShop);
	  	        
}
