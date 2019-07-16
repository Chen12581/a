package com.wqt.es.trade.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.es.trade.pojo.EsTradeCompanyShop;


public class EsTradeCompanyShopDao extends SessionDaoSupport{
	
	@SuppressWarnings("unchecked")
	public List<EsTradeCompanyShop> selectEsTradeCompanyShopList(EsTradeCompanyShop esTradeCompanyShop) {
		return this.getSession().selectList("estrade.selectEsTradeCompanyShopList", esTradeCompanyShop);
	}
	
	public EsTradeCompanyShop selectEsTradeCompanyShopOne(EsTradeCompanyShop esTradeCompanyShop) {
		return (EsTradeCompanyShop) this.getSession().selectOne("estrade.selectEsTradeCompanyShopOne",esTradeCompanyShop);
	}
	
	/*分页查询交易的公司*/
	public Pagination  selectEsTradeCompanyShopPage(EsTradeCompanyShop esTradeCompanyShop,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<EsTradeCompanyShop> list =this.getSession().selectList("estrade.selectEsTradeCompanyShopList", esTradeCompanyShop, pagination);
		pagination.setList(list);
		return pagination ;
	 } 
	
	@SuppressWarnings("unchecked")
	public List<EsTradeCompanyShop> selectCompanyRecommendList(EsTradeCompanyShop esTradeCompanyShop) {
		return this.getSession().selectList("estrade.selectCompanyRecommendList", esTradeCompanyShop);
	}
	
	/*新增公司信息*/
	public void insertEsTradeCompanyShop(EsTradeCompanyShop esTradeCompanyShop) {
		this.getSession().insert("estrade.insertEsTradeCompanyShop", esTradeCompanyShop);
	}
	
	/*修改公司信息*/
	public void updateEsTradeCompanyShop(EsTradeCompanyShop esTradeCompanyShop) {
		this.getSession().update("estrade.updateEsTradeCompanyShop", esTradeCompanyShop);
	}
	
	/*删除公司信息*/
	public void deleteCompany(EsTradeCompanyShop esTradeCompanyShop) {
		this.getSession().delete("estrade.deleteCompany", esTradeCompanyShop);
	}
	/*修改公司上下线*/
	public void updateEsTradeCompanyShopToCode(EsTradeCompanyShop esTradeCompanyShop) {
		this.getSession().update("estrade.updateEsTradeCompanyShopToCode",esTradeCompanyShop);
	}
}
