package com.wqt.ipr.order.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.order.pojo.IprBrandOrderShop;
import com.wqt.ipr.order.pojo.IprCopyrightOrderShop;
import com.wqt.ipr.order.pojo.IprOrderShop;
import com.wqt.ipr.order.pojo.IprPatentOrderShop;

public class IprOrderShopDao  extends SessionDaoSupport{
	
	public void deleteIprOrderShop(IprOrderShop iprOrderShop) {
		this.getSession().delete("iprOrder.deleteIprOrderShop", iprOrderShop);
	}
	
	public void updateIprOrderShop(IprOrderShop iprOrderShop) {
		this.getSession().update("iprOrder.updateIprOrderShop", iprOrderShop);
	}
	
	@SuppressWarnings("unchecked")
	public List<IprOrderShop> selectIprOrderShopList(IprOrderShop iprOrderShop) {
		return this.getSession().selectList("iprOrder.selectIprOrderShopList", iprOrderShop);
	}
	
	public Pagination  selectIprOrderShopPage(IprOrderShop iprOrderShop,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<IprOrderShop> list =this.getSession().selectList("iprOrder.selectIprOrderShopList", iprOrderShop, pagination);
		pagination.setList(list);
		return pagination;
	}
	
	/*查询一个订单*/
	public IprOrderShop selectOneIprOrderShop(IprOrderShop iprOrderShop) {
		return (IprOrderShop)this.getSession().selectOne("iprOrder.selectOneIprOrderShop", iprOrderShop);
	}
	
	/*查询商标订单详情*/
	public IprBrandOrderShop selectIprBrandOrderShop(IprOrderShop iprOrderShop)
	{
		return (IprBrandOrderShop)this.getSession().selectOne("iprOrder.selectIprBrandOrderShop", iprOrderShop);
	}
	
	/*查询版权订单详情*/
	public IprCopyrightOrderShop selectIprCopyrightOrderShop(IprOrderShop iprOrderShop)
	{
		return (IprCopyrightOrderShop)this.getSession().selectOne("iprOrder.selectIprCopyrightOrderShop", iprOrderShop);
	}
	
	/*查询专利订单详情*/
	public IprPatentOrderShop selectIprPatentOrderShop(IprOrderShop iprOrderShop)
	{
		return (IprPatentOrderShop)this.getSession().selectOne("iprOrder.selectIprPatentOrderShop", iprOrderShop);
	}
}
