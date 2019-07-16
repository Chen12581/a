package com.wqt.es.order.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.es.order.pojo.EsOrderTrade;

public class EsOrderTradeDao  extends SessionDaoSupport{
	
	/*删除订单*/
	public void deleteEsOrderTrade(EsOrderTrade esOrderTrade) {
		this.getSession().delete("esOrder.deleteEsOrderTrade", esOrderTrade);
	}
	
	/*修改订单*/
	public void updateEsOrderTrade(EsOrderTrade esOrderTrade) {
		this.getSession().update("esOrder.updateEsOrderTrade", esOrderTrade);
	}
	
	/*查询订单列表*/
	public List<EsOrderTrade> selectEsOrderTradeList(EsOrderTrade esOrderTrade) {
		return this.getSession().selectList("esOrder.selectEsOrderTradeList", esOrderTrade);
	}
	
	/*查询分页订单*/
	public Pagination  selectEsOrderTradePage(EsOrderTrade esOrderTrade,Pagination pagination){
		List<EsOrderTrade> list =this.getSession().selectList("esOrder.selectEsOrderTradeList", esOrderTrade, pagination);
		pagination.setList(list);
		return pagination;
	}
	
	/*查询一个订单*/
	public EsOrderTrade selectOneEsOrderTrade(EsOrderTrade esOrderTrade) {
		return (EsOrderTrade)this.getSession().selectOne("esOrder.selectOneEsOrderTrade", esOrderTrade);
	}
}
