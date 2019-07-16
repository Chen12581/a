package com.wqt.user.pojo;

/*企业服务订单*/
public class UEsOrder {
	private String  orderid;         //订单ID
    private String  ordercode;       //订单编码
    private String  ordershopid;     //订单的商品ID
    private String  ordershopcode;   //订单的商品编码(交易类)
    private String  ordershopdesc;   //订单的商品描述(服务类)
    private String  ordershopnum;    //订单的商品数量
    private String  shopprice;       //订单的商品价格
    private String  orderallmoney;   //订单总金额
    private String  orderservicemoney;//订单服务费(交易类的佣金)
    private String  orderkind;       //订单类别
    private String  favourablemoney; //订单优惠金额
    private String  buyerid;         //订单买家ID
    private String  sellerid;        //订单卖家ID
    private String  paymoney;        //订单已付金额
    private String  ordertime;       //订单时间
    private String  ordershopicon;   //订单商品图标
    private String  ordershopname;   //订单商品名称
    private String  orderstate;      //订单状态
    private String  htmlpath;        //订单商品链接
    private String  orderworkername;        //订单业务员名称
    private String  orderworkerqq;        //订单业务员QQ
    private String  orderworkerheader;        //订单业务员头像
    private String  ordercompanytype;   //订单公司类型；
    private String  ordercompanyinduty;  //订单公司行业
    private String  orderprovincename;   //订单省份(服务类指购买服务的省份)
    private String  ordercityname;    //订单地市(服务类指购买服务的地市)
    private String  orderholddate;    //订单经营年限(交易类)
    private String  orderregcapital;  //订单注册资本(交易类)
    private String  orderkindkey;     //订单类型标识
    
    
	public String getOrderkindkey() {
		return orderkindkey;
	}
	public void setOrderkindkey(String orderkindkey) {
		this.orderkindkey = orderkindkey;
	}
	public String getOrdercompanytype() {
		return ordercompanytype;
	}
	public void setOrdercompanytype(String ordercompanytype) {
		this.ordercompanytype = ordercompanytype;
	}
	public String getOrdercompanyinduty() {
		return ordercompanyinduty;
	}
	public void setOrdercompanyinduty(String ordercompanyinduty) {
		this.ordercompanyinduty = ordercompanyinduty;
	}
	public String getOrderprovincename() {
		return orderprovincename;
	}
	public void setOrderprovincename(String orderprovincename) {
		this.orderprovincename = orderprovincename;
	}
	public String getOrdercityname() {
		return ordercityname;
	}
	public void setOrdercityname(String ordercityname) {
		this.ordercityname = ordercityname;
	}
	public String getOrderholddate() {
		return orderholddate;
	}
	public void setOrderholddate(String orderholddate) {
		this.orderholddate = orderholddate;
	}
	public String getOrderregcapital() {
		return orderregcapital;
	}
	public void setOrderregcapital(String orderregcapital) {
		this.orderregcapital = orderregcapital;
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
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
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
    
    
    
}
