package com.wqt.ipr.brand.service;

import java.util.List;

import javax.servlet.ServletContext;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.brand.pojo.IprBrandShop;

public interface BrandShopService {
	
	 /*修改交易商标*/
	 public void updateIprBrandShop(IprBrandShop iprBrandShop);
	 
	 /*查询交易商标*/
     public List<IprBrandShop> selectIprBrandShopList(IprBrandShop iprBrandShop);
     
     /*分页查询交易商标*/
	 public Pagination  selectIprBrandShopPage(IprBrandShop iprBrandShop,Pagination pagination);	 

	 public IprBrandShop selectBrandShopOne(IprBrandShop brandShop);
}
