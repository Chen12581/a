package com.wqt.es.order.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.es.order.pojo.EsOrderTrade;

public interface EsOrderTradeService {
	/*删除订单*/
	public void deleteEsOrderTrade(EsOrderTrade esOrderTrade);
	
	/*修改订单*/
	public void updateEsOrderTrade(EsOrderTrade esOrderTrade);
	
	/*查询订单列表*/
	public List<EsOrderTrade> selectEsOrderTradeList(EsOrderTrade esOrderTrade);
	
	/*查询分页订单*/
	public Pagination  selectEsOrderTradePage(EsOrderTrade esOrderTrade,Pagination pagination);
	
	/*查询一个订单*/
	public EsOrderTrade selectOneEsOrderTrade(EsOrderTrade esOrderTrade);
}
