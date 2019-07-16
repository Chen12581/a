package com.wqt.ipr.order.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.order.pojo.IprBrandOrderProduct;
import com.wqt.ipr.order.pojo.IprCopyrightOrderProduct;
import com.wqt.ipr.order.pojo.IprOrderProduct;
import com.wqt.ipr.order.pojo.IprPatentOrderProduct;

public class IprOrderProductDao  extends SessionDaoSupport{
	/*删除订单*/
	public void deleteIprOrderProduct(IprOrderProduct iprOrderProduct) {
		this.getSession().delete("iprOrder.deleteIprOrderProduct", iprOrderProduct);
	}
	/*修改订单*/
	public void updateIprOrderProduct(IprOrderProduct iprOrderProduct) {
		this.getSession().update("iprOrder.updateIprOrderProduct", iprOrderProduct);
	}
	/*查询订单列表*/
	public List<IprOrderProduct> selectIprOrderProductList(IprOrderProduct iprOrderProduct) {
		return this.getSession().selectList("iprOrder.selectIprOrderProductList", iprOrderProduct);
	}
	/*查询一个订单*/
	public IprOrderProduct selectOneIprOrderProduct(IprOrderProduct iprOrderProduct) {
		return (IprOrderProduct)this.getSession().selectOne("iprOrder.selectOneIprOrderProduct", iprOrderProduct);
	}
	/*分页查询订单*/
	public Pagination  selectIprOrderProductPage(IprOrderProduct iprOrderProduct,Pagination pagination){
		List<IprOrderProduct> list =this.getSession().selectList("iprOrder.selectIprOrderProductList", iprOrderProduct, pagination);
		pagination.setList(list);
		return pagination;
	}
	
	/*查询商标订单详情*/
	public IprBrandOrderProduct selectIprBrandOrderProduct(IprOrderProduct iprOrderProduct) {
		return (IprBrandOrderProduct)this.getSession().selectOne("iprOrder.selectIprBrandOrderProduct", iprOrderProduct);
	}
	
	/*查询版权订单详情*/
	public IprCopyrightOrderProduct selectIprCopyrightOrderProduct(IprOrderProduct iprOrderProduct) {
		return (IprCopyrightOrderProduct)this.getSession().selectOne("iprOrder.selectIprCopyrightOrderProduct", iprOrderProduct);
	}
	
	/*查询专利订单详情*/
	public IprPatentOrderProduct selectIprPatentOrderProduct(IprOrderProduct iprOrderProduct) {
		return (IprPatentOrderProduct)this.getSession().selectOne("iprOrder.selectIprPatentOrderProduct", iprOrderProduct);
	}
	
}
