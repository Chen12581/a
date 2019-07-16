package com.wqt.es.order.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.es.order.pojo.EsOrderServices;

/*企业服务订单*/
public class EsOrderServiceDao  extends SessionDaoSupport{
	public void deleteEsOrderService(EsOrderServices esOrderServices) {
		this.getSession().delete("esOrder.deleteEsOrderService", esOrderServices);
	}
	
	public void updateEsOrderService(EsOrderServices esOrderServices) {
		this.getSession().update("esOrder.updateEsOrderService", esOrderServices);
	}
	
	@SuppressWarnings("unchecked")
	public List<EsOrderServices> selectEsOrderServiceList(EsOrderServices esOrderServices) {
		return this.getSession().selectList("esOrder.selectEsOrderServiceList", esOrderServices);
	}
	
	public Pagination  selectEsOrderServicePage(EsOrderServices esOrderServices,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<EsOrderServices> list =this.getSession().selectList("esOrder.selectEsOrderServiceList", esOrderServices, pagination);
		pagination.setList(list);
		return pagination;
	}
	
	/*查询一个订单*/
	public EsOrderServices selectOneEsOrderService(EsOrderServices esOrderServices) {
		return (EsOrderServices)this.getSession().selectOne("esOrder.selectOneEsOrderService", esOrderServices);
	}
}
