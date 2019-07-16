package com.wqt.es.order.pojo;

/*企业服务订单*/
public class EsOrderServices {
	    private String id;               // 
	    private String ordercode;        //订单编码 
	    private String userid;           //用户ID 
	    private String ordertime;        //订单时间 
	    private String productid;        //产品ID 
	    private String producticon;      //产品图标
	    private String productname;      //产品名称
	    private String productdesc;      //产品描述
	    private String htmlpath;         //产品路径
	    private String productprice;     //产品单价
	    private String orderallmoney;    //订单总金额
	    private String favourablemoney;  //优惠金额
	    private String ordermoney;       //订单实际金额 
	    private String paymoney;         //已付金额 
	    private String provinceid;       //省份ID
	    private String provincename;
	    private String cityid;           //地市ID
	    private String cityname;
	    private String areaid;           //区县ID
	    private String areaname;
	    private String servicekind;      //服务类型(公司工商注册需要用) 1：商贸贸易类 2：科技类 3：文化传媒类 4：咨询管理类5：经济金融类 6：餐饮服务类 7：其他
	    private String companytype;      //企业类型（工商注册，工商变更用）  1：有限责任公司 2：股份有限公司 3：个人独资公司4：分公司
	    private String state;            //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款7:  订单失效
	    private String statename;        //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款7:  订单失效
	    private String workerid;         //业务顾问ID 
	    private String remark;           //备注 
	    private String suctime;          //订单处理完成时间 

		public String getProvincename() {
			return provincename;
		}
		public void setProvincename(String provincename) {
			this.provincename = provincename;
		}
		public String getCityname() {
			return cityname;
		}
		public void setCityname(String cityname) {
			this.cityname = cityname;
		}
		public String getAreaname() {
			return areaname;
		}
		public void setAreaname(String areaname) {
			this.areaname = areaname;
		}
		public String getProductdesc() {
			return productdesc;
		}
		public void setProductdesc(String productdesc) {
			this.productdesc = productdesc;
		}
		public String getProducticon() {
			return producticon;
		}
		public void setProducticon(String producticon) {
			this.producticon = producticon;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public String getHtmlpath() {
			return htmlpath;
		}
		public void setHtmlpath(String htmlpath) {
			this.htmlpath = htmlpath;
		}
		public String getProductprice() {
			return productprice;
		}
		public void setProductprice(String productprice) {
			this.productprice = productprice;
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
		public String getProvinceid() {
			return provinceid;
		}
		public void setProvinceid(String provinceid) {
			this.provinceid = provinceid;
		}
		public String getCityid() {
			return cityid;
		}
		public void setCityid(String cityid) {
			this.cityid = cityid;
		}
		public String getAreaid() {
			return areaid;
		}
		public void setAreaid(String areaid) {
			this.areaid = areaid;
		}
		public String getServicekind() {
			return servicekind;
		}
		public void setServicekind(String servicekind) {
			this.servicekind = servicekind;
		}
		public String getCompanytype() {
			return companytype;
		}
		public void setCompanytype(String companytype) {
			this.companytype = companytype;
		}
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
		
		public String getOrdertime() {
			return ordertime;
		}
		public void setOrdertime(String ordertime) {
			this.ordertime = ordertime;
		}
		public String getProductid() {
			return productid;
		}
		public void setProductid(String productid) {
			this.productid = productid;
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
