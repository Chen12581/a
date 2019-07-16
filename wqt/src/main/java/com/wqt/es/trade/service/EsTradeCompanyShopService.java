package com.wqt.es.trade.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.es.trade.pojo.EsTradeCompanyShop;

public interface EsTradeCompanyShopService {
	
	/*新增公司信息*/
	public void insertEsTradeCompanyShop(EsTradeCompanyShop esTradeCompanyShop);
	
	/*分页查询交易的公司*/
	public Pagination  selectEsTradeCompanyShopPage(EsTradeCompanyShop esTradeCompanyShop,Pagination pagination);
	
	/*查询单个交易公司*/
	public EsTradeCompanyShop selectEsTradeCompanyShopOne(EsTradeCompanyShop esTradeCompanyShop);
	
	/*修改公司信息*/
	public void updateEsTradeCompanyShop(EsTradeCompanyShop esTradeCompanyShop);
	
	/*删除公司信息*/
	public void deleteCompany(EsTradeCompanyShop esTradeCompanyShop);
}
