package com.wqt.user.pojo;

import java.util.List;

/*企业服务订单页对象*/
public class EsBuyerOrderList {
    private List<UEsOrder> l_EsOrder;
    private String pagenum;          //当前页数
    private String ordercount="0";    //总记录
    private String orderpage="0";     //总页数
    private String  orderstate;       //订单状态
    
    
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	
	public List<UEsOrder> getL_EsOrder() {
		return l_EsOrder;
	}
	public void setL_EsOrder(List<UEsOrder> l_EsOrder) {
		this.l_EsOrder = l_EsOrder;
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
