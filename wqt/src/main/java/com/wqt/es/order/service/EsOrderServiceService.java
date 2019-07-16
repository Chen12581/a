package com.wqt.es.order.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.es.order.pojo.EsOrderServices;

public interface EsOrderServiceService {
	public void deleteEsOrderService(EsOrderServices esOrderServices);
	
	public void updateEsOrderService(EsOrderServices esOrderServices);
	
	public List<EsOrderServices> selectEsOrderServiceList(EsOrderServices esOrderServices);
	
	public Pagination  selectEsOrderServicePage(EsOrderServices esOrderServices,Pagination pagination);
	
	public EsOrderServices selectOneEsOrderService(EsOrderServices esOrderServices);
}
