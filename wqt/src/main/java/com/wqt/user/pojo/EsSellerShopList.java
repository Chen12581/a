package com.wqt.user.pojo;

import java.util.List;

/*卖家企业服务页对象*/
public class EsSellerShopList {
    private List<UEsShop> l_EsShop;
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
	public List<UEsShop> getL_EsShop() {
		return l_EsShop;
	}
	public void setL_EsShop(List<UEsShop> l_EsShop) {
		this.l_EsShop = l_EsShop;
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
