package com.wqt.user.pojo;

import java.util.List;


public class UserBillData {
    private List<UsercenterOrder> l_UsercenterOrder;
    private String pagenum;          //当前页数
    private String ordercount="0";    //总记录
  	private String orderpage="0";     //总页数
	
  	
  	
	public List<UsercenterOrder> getL_UsercenterOrder() {
		return l_UsercenterOrder;
	}
	public void setL_UsercenterOrder(List<UsercenterOrder> l_UsercenterOrder) {
		this.l_UsercenterOrder = l_UsercenterOrder;
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
