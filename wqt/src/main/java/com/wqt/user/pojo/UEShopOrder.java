package com.wqt.user.pojo;

import java.util.Date;

/*用户中心网店转让订单*/
public class UEShopOrder {
	
	private String  orderid;         //订单ID
    private String  ordercode;       //订单编码
    private String  ordershopid;     //订单的商品ID
    private String  ordershopcode;   //订单的商品编码
    private String  ordershopdesc;   //订单的商品描述
    private String  orderplateformcode; //平台编码
    private String  ordershopnum;    //订单的商品数量
    private String  shopprice;       //订单的商品价格
    private String  orderallmoney;   //订单总金额
    private String  orderservicemoney;//订单服务费(交易类的佣金)
    private String  favourablemoney; //订单优惠金额
    private int     buyerid;         //订单买家ID
    private int     sellerid;        //订单卖家ID
    private String  paymoney;        //订单已付金额
    private String  ordertime;       //订单时间
    private String  ordershopicon;   //订单商品图标
    private String  ordershopname;   //订单商品名称
    private String  orderstate;      //订单状态
    private String  htmlpath;        //订单商品链接
    private String  orderworkername;        //订单业务员名称
    private String  orderworkerqq;        //订单业务员QQ
    private String  orderworkerheader;        //订单业务员头像
    private String  ordermalltypename;   //商城类型；
    private String  orderbrandcategoryname;  //商标类型
    private String  ordermaincategoryname;   //主营类目
    private String  ordermaincategoryid;   //主营类目
    private String  ordercredit;
    
    
    
	public String getOrdermaincategoryid() {
		return ordermaincategoryid;
	}
	public void setOrdermaincategoryid(String ordermaincategoryid) {
		this.ordermaincategoryid = ordermaincategoryid;
	}
	public String getOrdercredit() {
		return ordercredit;
	}
	public void setOrdercredit(String ordercredit) {
		this.ordercredit = ordercredit;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	
	public String getOrderplateformcode() {
		return orderplateformcode;
	}
	public void setOrderplateformcode(String orderplateformcode) {
		this.orderplateformcode = orderplateformcode;
	}
	public String getOrdershopid() {
		return ordershopid;
	}
	public void setOrdershopid(String ordershopid) {
		this.ordershopid = ordershopid;
	}
	public String getOrdershopcode() {
		return ordershopcode;
	}
	public void setOrdershopcode(String ordershopcode) {
		this.ordershopcode = ordershopcode;
	}
	public String getOrdershopdesc() {
		return ordershopdesc;
	}
	public void setOrdershopdesc(String ordershopdesc) {
		this.ordershopdesc = ordershopdesc;
	}
	public String getOrdershopnum() {
		return ordershopnum;
	}
	public void setOrdershopnum(String ordershopnum) {
		this.ordershopnum = ordershopnum;
	}
	public String getShopprice() {
		return shopprice;
	}
	public void setShopprice(String shopprice) {
		this.shopprice = shopprice;
	}
	public String getOrderallmoney() {
		return orderallmoney;
	}
	public void setOrderallmoney(String orderallmoney) {
		this.orderallmoney = orderallmoney;
	}
	public String getOrderservicemoney() {
		return orderservicemoney;
	}
	public void setOrderservicemoney(String orderservicemoney) {
		this.orderservicemoney = orderservicemoney;
	}
	
	public String getFavourablemoney() {
		return favourablemoney;
	}
	public void setFavourablemoney(String favourablemoney) {
		this.favourablemoney = favourablemoney;
	}
	
	public int getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public String getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(String paymoney) {
		this.paymoney = paymoney;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getOrdershopicon() {
		return ordershopicon;
	}
	public void setOrdershopicon(String ordershopicon) {
		this.ordershopicon = ordershopicon;
	}
	public String getOrdershopname() {
		return ordershopname;
	}
	public void setOrdershopname(String ordershopname) {
		this.ordershopname = ordershopname;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public String getHtmlpath() {
		return htmlpath;
	}
	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}
	public String getOrderworkername() {
		return orderworkername;
	}
	public void setOrderworkername(String orderworkername) {
		this.orderworkername = orderworkername;
	}
	public String getOrderworkerqq() {
		return orderworkerqq;
	}
	public void setOrderworkerqq(String orderworkerqq) {
		this.orderworkerqq = orderworkerqq;
	}
	public String getOrderworkerheader() {
		return orderworkerheader;
	}
	public void setOrderworkerheader(String orderworkerheader) {
		this.orderworkerheader = orderworkerheader;
	}
	public String getOrdermalltypename() {
		return ordermalltypename;
	}
	public void setOrdermalltypename(String ordermalltypename) {
		this.ordermalltypename = ordermalltypename;
	}
	public String getOrderbrandcategoryname() {
		return orderbrandcategoryname;
	}
	public void setOrderbrandcategoryname(String orderbrandcategoryname) {
		this.orderbrandcategoryname = orderbrandcategoryname;
	}
	public String getOrdermaincategoryname() {
		return ordermaincategoryname;
	}
	public void setOrdermaincategoryname(String ordermaincategoryname) {
		this.ordermaincategoryname = ordermaincategoryname;
	}
    
    
	
}
