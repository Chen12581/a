package com.wqt.es.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.es.order.dal.EsOrderServiceDao;
import com.wqt.es.order.pojo.EsOrderServices;
import com.wqt.es.order.service.EsOrderServiceService;

public class EsOrderServiceServiceImpl implements EsOrderServiceService {
	@Autowired
	private EsOrderServiceDao esOrderServiceDao;
	
	@Override
	public void deleteEsOrderService(EsOrderServices esOrderServices) {
		esOrderServiceDao.deleteEsOrderService(esOrderServices);
	}

	@Override
	public void updateEsOrderService(EsOrderServices esOrderServices) {
		esOrderServiceDao.updateEsOrderService(esOrderServices);
	}

	@Override
	public List<EsOrderServices> selectEsOrderServiceList(
			EsOrderServices esOrderServices) {
		return esOrderServiceDao.selectEsOrderServiceList(esOrderServices);
	}

	@Override
	public Pagination selectEsOrderServicePage(
			EsOrderServices esOrderServices, Pagination pagination) {
		return esOrderServiceDao.selectEsOrderServicePage(esOrderServices, pagination);
	}

	@Override
	public EsOrderServices selectOneEsOrderService(EsOrderServices esOrderServices) {
		return esOrderServiceDao.selectOneEsOrderService(esOrderServices);
	}

}
