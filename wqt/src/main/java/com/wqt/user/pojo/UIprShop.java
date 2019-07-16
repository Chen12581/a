package com.wqt.user.pojo;

public class UIprShop {
	private String  shopuser;       //发布用户ID；
	private String  shopid;         //商品ID
    private String  shopprice;      //商品价格 
    private String  shopcode;       //商品编码
    private String  shopkindcode;   //区分商品(1表示商标，2表示版权 3表示专利)
    private String  shopkind;       //商品所属类别
    private String  shopkindname;   //商品所属类别名称
    private String  shoptype;       //商品所属类型(专利使用 )
    private String  shopdeveloptime;//商品发布时间
    private String  shopicon;       //商品图标
    private String  shopname;       //商品名称
    private String  shopstate;      //商品状态
    private String  shopstart;      //商品开始时间( 商标的注册时间，专利注册时间)
    private String  shopend;        //商品结束时间(商标的过期时间，专利过期时间)
    private String  shopregcode;     //商品注册号(交易类 商标的注册号，专利的专利号)
    private String  htmlpath;        //商品路径
    
    
    
	public String getShoptype() {
		return shoptype;
	}
	public void setShoptype(String shoptype) {
		this.shoptype = shoptype;
	}
	public String getHtmlpath() {
		return htmlpath;
	}
	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}
	public String getShopuser() {
		return shopuser;
	}
	public void setShopuser(String shopuser) {
		this.shopuser = shopuser;
	}
	public String getShopkindcode() {
		return shopkindcode;
	}
	public void setShopkindcode(String shopkindcode) {
		this.shopkindcode = shopkindcode;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getShopprice() {
		return shopprice;
	}
	public void setShopprice(String shopprice) {
		this.shopprice = shopprice;
	}
	public String getShopcode() {
		return shopcode;
	}
	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}
	public String getShopkind() {
		return shopkind;
	}
	public void setShopkind(String shopkind) {
		this.shopkind = shopkind;
	}
	public String getShopkindname() {
		return shopkindname;
	}
	public void setShopkindname(String shopkindname) {
		this.shopkindname = shopkindname;
	}
	public String getShopdeveloptime() {
		return shopdeveloptime;
	}
	public void setShopdeveloptime(String shopdeveloptime) {
		this.shopdeveloptime = shopdeveloptime;
	}
	public String getShopicon() {
		return shopicon;
	}
	public void setShopicon(String shopicon) {
		this.shopicon = shopicon;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShopstate() {
		return shopstate;
	}
	public void setShopstate(String shopstate) {
		this.shopstate = shopstate;
	}
	public String getShopstart() {
		return shopstart;
	}
	public void setShopstart(String shopstart) {
		this.shopstart = shopstart;
	}
	public String getShopend() {
		return shopend;
	}
	public void setShopend(String shopend) {
		this.shopend = shopend;
	}
	public String getShopregcode() {
		return shopregcode;
	}
	public void setShopregcode(String shopregcode) {
		this.shopregcode = shopregcode;
	}
    
    
}
