package com.wqt.ipr.order.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.order.pojo.IprBrandOrderShop;
import com.wqt.ipr.order.pojo.IprCopyrightOrderShop;
import com.wqt.ipr.order.pojo.IprOrderShop;
import com.wqt.ipr.order.pojo.IprPatentOrderShop;

public interface IprOrderShopService {
	public void deleteIprOrderShop(IprOrderShop iprOrderShop);
	
	public void updateIprOrderShop(IprOrderShop iprOrderShop);
	
	public List<IprOrderShop> selectIprOrderShopList(IprOrderShop iprOrderShop);
	
	public Pagination  selectIprOrderShopPage(IprOrderShop iprOrderShop,Pagination pagination);
	
	public IprOrderShop selectOneIprOrderShop(IprOrderShop iprOrderShop);
	
	/*查询商标订单详情*/
	public IprBrandOrderShop selectIprBrandOrderShop(IprOrderShop iprOrderShop);
	
	/*查询版权订单详情*/
	public IprCopyrightOrderShop selectIprCopyrightOrderShop(IprOrderShop iprOrderShop);
	
	/*查询专利订单详情*/
	public IprPatentOrderShop selectIprPatentOrderShop(IprOrderShop iprOrderShop);
}
