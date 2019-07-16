package com.wqt.user.pojo;

import java.util.List;

/*知识产权订单页对象*/
public class IprSellerShopList {
    private List<UIprShop> l_IprShop;
    private int    shopstate;  //店铺状态
    private String pagenum;          //当前页数
    private String shopcount="0";    //总记录
    private String shoppage="0";     //总页数
    
	
	public int getShopstate() {
		return shopstate;
	}
	public void setShopstate(int shopstate) {
		this.shopstate = shopstate;
	}
	public List<UIprShop> getL_IprShop() {
		return l_IprShop;
	}
	public void setL_IprShop(List<UIprShop> l_IprShop) {
		this.l_IprShop = l_IprShop;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getShopcount() {
		return shopcount;
	}
	public void setShopcount(String shopcount) {
		this.shopcount = shopcount;
	}
	public String getShoppage() {
		return shoppage;
	}
	public void setShoppage(String shoppage) {
		this.shoppage = shoppage;
	}
	
}
