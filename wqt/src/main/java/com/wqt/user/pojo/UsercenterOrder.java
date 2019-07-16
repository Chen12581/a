package com.wqt.user.pojo;

public class UsercenterOrder {
	private String  orderid;         //订单ID
    private String  ordercode;       //订单编码
    private String  ordershopid;     //订单的商品ID
    private String  ordershopcode;   //订单的商品编码(交易类)
    private String  ordershopdesc;   //订单的商品描述(服务类)
    private String  ordershopnum;    //订单的商品数量
    private String  shopprice;       //订单的商品价格
    private String  shopstate;       //卖家发布商品的状态
    private String  orderallmoney;   //订单总金额
    private String  orderservicemoney;//订单服务费(交易类的佣金)
    private String  orderkind;       //订单类别(1,商标服务 2版权服务 3专利服务 4商标交易 5版权交易 6 专利交易  qyjy 表示企业交易其他表示企业服务)
    private String  favourablemoney; //订单优惠金额
    private String  buyerid;         //订单买家ID
    private String  paymoney;        //订单已付金额
    private String  ordertime;       //订单时间
    private String  ordershopicon;   //订单商品图标
    private String  ordershopname;   //订单商品名称
    private String  transferfee;     //订单过户费
    private String  orderstate;      //订单状态
    private String  htmlpath;        //订单商品链接
    private String  ordershopkind;   //订单的商品类别(交易类)
    private String  ordershopkindname;   //订单的商品类别(交易类)
    private String  ordershopregcode; //订单的商品注册号(交易类 商标的注册号，专利的专利号)
    private String  wordermalltypename;      //商城类型
    private String  wordermaincategoryname;  //主营类目
    private String  worderplateformcode;     //平台编码
    private String  wbrandcategoryname;      //商标类型
    private String  wordermaincategoryid;    //主营类目排序
    private String  wordercredit;            //信誉等级
    private String  wordertechfee;  //主营类目
    private String  wordertechfeeratio;     //平台编码
    private String  worderreturntechfee;      //商标类型
    private String  worderdepositmoney;    //主营类目排序
    private String  worderdeposittype;            //信誉等级
    
    
    
	public String getWordertechfee() {
		return wordertechfee;
	}
	public void setWordertechfee(String wordertechfee) {
		this.wordertechfee = wordertechfee;
	}
	public String getWordertechfeeratio() {
		return wordertechfeeratio;
	}
	public void setWordertechfeeratio(String wordertechfeeratio) {
		this.wordertechfeeratio = wordertechfeeratio;
	}
	public String getWorderreturntechfee() {
		return worderreturntechfee;
	}
	public void setWorderreturntechfee(String worderreturntechfee) {
		this.worderreturntechfee = worderreturntechfee;
	}
	public String getWorderdepositmoney() {
		return worderdepositmoney;
	}
	public void setWorderdepositmoney(String worderdepositmoney) {
		this.worderdepositmoney = worderdepositmoney;
	}
	public String getWorderdeposittype() {
		return worderdeposittype;
	}
	public void setWorderdeposittype(String worderdeposittype) {
		this.worderdeposittype = worderdeposittype;
	}
	public String getWordermalltypename() {
		return wordermalltypename;
	}
	public void setWordermalltypename(String wordermalltypename) {
		this.wordermalltypename = wordermalltypename;
	}
	public String getWordermaincategoryname() {
		return wordermaincategoryname;
	}
	public void setWordermaincategoryname(String wordermaincategoryname) {
		this.wordermaincategoryname = wordermaincategoryname;
	}
	public String getWorderplateformcode() {
		return worderplateformcode;
	}
	public void setWorderplateformcode(String worderplateformcode) {
		this.worderplateformcode = worderplateformcode;
	}
	public String getWbrandcategoryname() {
		return wbrandcategoryname;
	}
	public void setWbrandcategoryname(String wbrandcategoryname) {
		this.wbrandcategoryname = wbrandcategoryname;
	}
	public String getWordermaincategoryid() {
		return wordermaincategoryid;
	}
	public void setWordermaincategoryid(String wordermaincategoryid) {
		this.wordermaincategoryid = wordermaincategoryid;
	}
	public String getWordercredit() {
		return wordercredit;
	}
	public void setWordercredit(String wordercredit) {
		this.wordercredit = wordercredit;
	}
	public String getOrdershopregcode() {
		return ordershopregcode;
	}
	public void setOrdershopregcode(String ordershopregcode) {
		this.ordershopregcode = ordershopregcode;
	}
	public String getOrdershopkind() {
		return ordershopkind;
	}
	public void setOrdershopkind(String ordershopkind) {
		this.ordershopkind = ordershopkind;
	}
	public String getOrdershopkindname() {
		return ordershopkindname;
	}
	public void setOrdershopkindname(String ordershopkindname) {
		this.ordershopkindname = ordershopkindname;
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
	public String getShopstate() {
		return shopstate;
	}
	public void setShopstate(String shopstate) {
		this.shopstate = shopstate;
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
	public String getOrderkind() {
		return orderkind;
	}
	public void setOrderkind(String orderkind) {
		this.orderkind = orderkind;
	}
	public String getFavourablemoney() {
		return favourablemoney;
	}
	public void setFavourablemoney(String favourablemoney) {
		this.favourablemoney = favourablemoney;
	}
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
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
	public String getTransferfee() {
		return transferfee;
	}
	public void setTransferfee(String transferfee) {
		this.transferfee = transferfee;
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
	
	
      
      
}
