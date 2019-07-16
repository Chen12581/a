package com.wqt.ipr.order.pojo;

/*服务商品订单*/
public class IprOrderProduct {
    private String id;               // 
    private String ordercode;        //订单编码 
    private String userid;           //用户ID 
    private String username;         //用户名
    private String ordertime;        //订单时间 
    private String orderkind;        //订单类别 类别1表示商标 2表示版权 3表示专利 
    private String productid;        //产品ID 
    private String productname;      //产品名称
    private String usercontractid;   //用户合同主体ID 
    private String productnum;       //产品数量 
    private String productprice;     //产品单价 
    private String rebateprice;      //优惠后单价 
    private String state;            //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款7:  订单失效
    private String statename;        //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款7:  订单失效
    private String orderallmoney;    //订单总金额 
    private String ordermoney;       //订单实际金额 
    private String paymoney;         //已付金额 
    private String workerid;         //业务顾问ID 
    private String remark;           //备注 
    private String suctime;          //订单处理完成时间 
    private String favourablemoney;  //优惠金额
    private String reservepayratio;  //预定付款比例
    private String reservemoney;	 //预定付款金额
    
     
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getOrderkind() {
		return orderkind;
	}
	public void setOrderkind(String orderkind) {
		this.orderkind = orderkind;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getUsercontractid() {
		return usercontractid;
	}
	public void setUsercontractid(String usercontractid) {
		this.usercontractid = usercontractid;
	}
	public String getProductnum() {
		return productnum;
	}
	public void setProductnum(String productnum) {
		this.productnum = productnum;
	}
	public String getProductprice() {
		return productprice;
	}
	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}
	public String getRebateprice() {
		return rebateprice;
	}
	public void setRebateprice(String rebateprice) {
		this.rebateprice = rebateprice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getOrderallmoney() {
		return orderallmoney;
	}
	public void setOrderallmoney(String orderallmoney) {
		this.orderallmoney = orderallmoney;
	}
	public String getOrdermoney() {
		return ordermoney;
	}
	public void setOrdermoney(String ordermoney) {
		this.ordermoney = ordermoney;
	}
	public String getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(String paymoney) {
		this.paymoney = paymoney;
	}
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSuctime() {
		return suctime;
	}
	public void setSuctime(String suctime) {
		this.suctime = suctime;
	}
	public String getFavourablemoney() {
		return favourablemoney;
	}
	public void setFavourablemoney(String favourablemoney) {
		this.favourablemoney = favourablemoney;
	}
	public String getReservepayratio() {
		return reservepayratio;
	}
	public void setReservepayratio(String reservepayratio) {
		this.reservepayratio = reservepayratio;
	}
	public String getReservemoney() {
		return reservemoney;
	}
	public void setReservemoney(String reservemoney) {
		this.reservemoney = reservemoney;
	}
	
}
