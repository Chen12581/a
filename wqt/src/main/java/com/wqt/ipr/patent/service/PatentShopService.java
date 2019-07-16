package com.wqt.ipr.patent.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.patent.pojo.IprPatentShop;

public interface PatentShopService {
	

	
	/*查询专利列表*/
	public Pagination selectPatentShopList(IprPatentShop iprPatentShop,Pagination pagination); 
	
	public Pagination selectPatentShopPage(IprPatentShop iprPatentShop,Pagination pagination); 
	
	/*修改专利信息*/
	public void updatePatentShop(IprPatentShop iprPatentShop);
	
	/*查询单个专利*/
	public IprPatentShop selectPatentShopOne(IprPatentShop iprPatentShop);
	
	
}
