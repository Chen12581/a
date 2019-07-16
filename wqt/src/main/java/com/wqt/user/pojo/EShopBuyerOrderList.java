package com.wqt.user.pojo;

import java.util.List;

/*网店转让(买家)对象*/
public class EShopBuyerOrderList {
	    private List<UEShopOrder> l_EShopOrder;
	    private int pagenum;          //当前页数
	    private int ordercount=0;    //总记录
	    private int orderpage=0;     //总页数
	    private String  orderstate;  //订单状态
	    
	    
		public String getOrderstate() {
			return orderstate;
		}
		public void setOrderstate(String orderstate) {
			this.orderstate = orderstate;
		}
		public List<UEShopOrder> getL_EShopOrder() {
			return l_EShopOrder;
		}
		public void setL_EShopOrder(List<UEShopOrder> l_EShopOrder) {
			this.l_EShopOrder = l_EShopOrder;
		}
		public int getPagenum() {
			return pagenum;
		}
		public void setPagenum(int pagenum) {
			this.pagenum = pagenum;
		}
		public int getOrdercount() {
			return ordercount;
		}
		public void setOrdercount(int ordercount) {
			this.ordercount = ordercount;
		}
		public int getOrderpage() {
			return orderpage;
		}
		public void setOrderpage(int orderpage) {
			this.orderpage = orderpage;
		}
}
