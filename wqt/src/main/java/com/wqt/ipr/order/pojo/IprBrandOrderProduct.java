package com.wqt.ipr.order.pojo;

/*商标订单详情*/
public class IprBrandOrderProduct {
	    private String id;               // 
	    private String brandproductname; //商标产品名称
	    private String brandproductdesc; //商标产品简介
	    private String brandicon;        //商标图标
	    private String htmlpath;         //服务连接
	    private String ordercode;        //订单编码 
	    private String userid;           //用户ID 
	    private String username;         //用户名
	    private String ordertime;        //订单时间 
	    private String orderkind;        //订单类别 类别1表示商标 2表示版权 3表示专利 
	    private String productid;        //产品ID 
	    private String usercontractid;   //用户合同主体ID 
	    private String productnum;       //产品数量 
	    private String productprice;     //产品单价 
	    private String state;            //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款7:  订单失效
	    private String statename;        //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款7:  订单失效
	    private String orderallmoney;    //订单总金额 
	    private String favourablemoney;  //优惠金额
	    private String ordermoney;       //订单实际金额 
	    private String paymoney;         //已付金额 
	    private String workerid;         //业务顾问ID 
	    private String remark;           //备注 
	    private String suctime;          //订单处理完成时间 
	    
		
	    
	    public String getBrandicon() {
			return brandicon;
		}
		public void setBrandicon(String brandicon) {
			this.brandicon = brandicon;
		}
		public String getHtmlpath() {
			return htmlpath;
		}
		public void setHtmlpath(String htmlpath) {
			this.htmlpath = htmlpath;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getBrandproductname() {
			return brandproductname;
		}
		public void setBrandproductname(String brandproductname) {
			this.brandproductname = brandproductname;
		}
		public String getBrandproductdesc() {
			return brandproductdesc;
		}
		public void setBrandproductdesc(String brandproductdesc) {
			this.brandproductdesc = brandproductdesc;
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
		public String getFavourablemoney() {
			return favourablemoney;
		}
		public void setFavourablemoney(String favourablemoney) {
			this.favourablemoney = favourablemoney;
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
}
