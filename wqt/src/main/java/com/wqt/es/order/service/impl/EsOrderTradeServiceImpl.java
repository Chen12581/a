package com.wqt.es.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.es.order.dal.EsOrderTradeDao;
import com.wqt.es.order.pojo.EsOrderTrade;
import com.wqt.es.order.service.EsOrderTradeService;

public class EsOrderTradeServiceImpl implements EsOrderTradeService {
	
	@Autowired
	private EsOrderTradeDao esOrderTradeDao;
	
	@Override
	public void deleteEsOrderTrade(EsOrderTrade esOrderTrade) {
		esOrderTradeDao.deleteEsOrderTrade(esOrderTrade);
	}

	@Override
	public void updateEsOrderTrade(EsOrderTrade esOrderTrade) {
		esOrderTradeDao.updateEsOrderTrade(esOrderTrade);
	}

	@Override
	public List<EsOrderTrade> selectEsOrderTradeList(EsOrderTrade esOrderTrade) {
		return esOrderTradeDao.selectEsOrderTradeList(esOrderTrade);
	}

	@Override
	public Pagination selectEsOrderTradePage(EsOrderTrade esOrderTrade,
			Pagination pagination) {
		return esOrderTradeDao.selectEsOrderTradePage(esOrderTrade, pagination);
	}

	@Override
	public EsOrderTrade selectOneEsOrderTrade(EsOrderTrade esOrderTrade) {
		return esOrderTradeDao.selectOneEsOrderTrade(esOrderTrade);
	}

}
