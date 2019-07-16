package com.wqt.es.order.pojo;

/*企业交易订单*/
public class EsOrderTrade {
	private String id;                 // 
    private String ordercode;          //订单编码 
    private String ordertime;          //订单时间 
    private String companyshopid;      //交易企业ID
    private String companyshopname;    //交易企业名称
    private String companyshopicon;    //交易企业图标
    private String shopcode;			//交易企业编码
    private String companyindustry;		//企业行业
    private String companyindustryname; //企业行业
	private String holddate;			//经营年限
	private String dutytype;			//纳税类型
	private String regcapital;			//注册资本类型
	private String companytype;			//企业类型
    private String htmlpath;           //交易企业链接
    private String sellerid;           //卖家ID
    private String buyerid;            //买家ID
    private String ordermoney;         //订单金额
    private String buycommisionratio;  //买方的佣金比例
    private String commisionbuy;       //买方的佣金
    private String sailcommisionratio; //卖方佣金比例
    private String commisionsail;     //卖方佣金
    private String reservepayratio;    //买方预定付款比例
    private String reservemoney;       //买方预定付款金额
    private String sailordermoney;     //卖家订单总金额
    private String buyordermoney;      //买家订单总金额
    private String favourablemoney;    //买家买家优惠金额
    private String buytrueordermoney;  //买家订单实际金额
    private String paymoney;           //已付金额
    private String state;              //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款7:  订单失效
    private String statename;          //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款7:  订单失效
    private String workerid;           //业务顾问ID 
    private String remark;             //备注 
    private String suctime;            //订单处理完成时间 
    
    
	public String getCompanyindustryname() {
		return companyindustryname;
	}
	public void setCompanyindustryname(String companyindustryname) {
		this.companyindustryname = companyindustryname;
	}
	public String getShopcode() {
		return shopcode;
	}
	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}
	public String getCompanyindustry() {
		return companyindustry;
	}
	public void setCompanyindustry(String companyindustry) {
		this.companyindustry = companyindustry;
	}
	public String getHolddate() {
		return holddate;
	}
	public void setHolddate(String holddate) {
		this.holddate = holddate;
	}
	public String getDutytype() {
		return dutytype;
	}
	public void setDutytype(String dutytype) {
		this.dutytype = dutytype;
	}
	public String getRegcapital() {
		return regcapital;
	}
	public void setRegcapital(String regcapital) {
		this.regcapital = regcapital;
	}
	public String getCompanytype() {
		return companytype;
	}
	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}
	public String getHtmlpath() {
		return htmlpath;
	}
	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}
	public String getCompanyshopicon() {
		return companyshopicon;
	}
	public void setCompanyshopicon(String companyshopicon) {
		this.companyshopicon = companyshopicon;
	}
	public String getCompanyshopname() {
		return companyshopname;
	}
	public void setCompanyshopname(String companyshopname) {
		this.companyshopname = companyshopname;
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
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getCompanyshopid() {
		return companyshopid;
	}
	public void setCompanyshopid(String companyshopid) {
		this.companyshopid = companyshopid;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
	}
	public String getOrdermoney() {
		return ordermoney;
	}
	public void setOrdermoney(String ordermoney) {
		this.ordermoney = ordermoney;
	}
	public String getBuycommisionratio() {
		return buycommisionratio;
	}
	public void setBuycommisionratio(String buycommisionratio) {
		this.buycommisionratio = buycommisionratio;
	}
	public String getCommisionbuy() {
		return commisionbuy;
	}
	public void setCommisionbuy(String commisionbuy) {
		this.commisionbuy = commisionbuy;
	}
	public String getSailcommisionratio() {
		return sailcommisionratio;
	}
	public void setSailcommisionratio(String sailcommisionratio) {
		this.sailcommisionratio = sailcommisionratio;
	}
	
	public String getCommisionsail() {
		return commisionsail;
	}
	public void setCommisionsail(String commisionsail) {
		this.commisionsail = commisionsail;
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
	public String getSailordermoney() {
		return sailordermoney;
	}
	public void setSailordermoney(String sailordermoney) {
		this.sailordermoney = sailordermoney;
	}
	public String getBuyordermoney() {
		return buyordermoney;
	}
	public void setBuyordermoney(String buyordermoney) {
		this.buyordermoney = buyordermoney;
	}
	public String getFavourablemoney() {
		return favourablemoney;
	}
	public void setFavourablemoney(String favourablemoney) {
		this.favourablemoney = favourablemoney;
	}
	public String getBuytrueordermoney() {
		return buytrueordermoney;
	}
	public void setBuytrueordermoney(String buytrueordermoney) {
		this.buytrueordermoney = buytrueordermoney;
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
