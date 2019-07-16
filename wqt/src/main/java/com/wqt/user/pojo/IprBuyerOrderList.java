package com.wqt.user.pojo;

import java.util.List;

/*知识产权订单页对象*/
public class IprBuyerOrderList {
    private List<UIprOrder> l_IprOrder;
    private String pagenum;           //当前页数
    private String ordercount="0";    //总记录
    private String orderpage="0";     //总页数
    private String  orderstate;       //订单状态
    
    
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	
	public List<UIprOrder> getL_IprOrder() {
		return l_IprOrder;
	}
	public void setL_IprOrder(List<UIprOrder> l_IprOrder) {
		this.l_IprOrder = l_IprOrder;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(String ordercount) {
		this.ordercount = ordercount;
	}
	public String getOrderpage() {
		return orderpage;
	}
	public void setOrderpage(String orderpage) {
		this.orderpage = orderpage;
	}
	
}
