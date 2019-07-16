package com.wqt.user.pojo;

import java.util.List;

/*卖家的网店*/
public class EShopSellerShopList {
	private List<UEShopShop> l_UEShopShop;
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
	public List<UEShopShop> getL_UEShopShop() {
		return l_UEShopShop;
	}
	public void setL_UEShopShop(List<UEShopShop> l_UEShopShop) {
		this.l_UEShopShop = l_UEShopShop;
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
