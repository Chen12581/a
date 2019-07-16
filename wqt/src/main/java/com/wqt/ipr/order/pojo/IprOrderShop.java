package com.wqt.ipr.order.pojo;

/*交易商品订单*/
public class IprOrderShop {
    private String id;                 // 
    private String ordercode;          //订单编码 
    private String ordertime;          //订单时间 
    private String orderkind;          //订单类别 类别1表示商标 2表示版权 3表示专利 
    private String shopid;             //交易商品ID
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
    private String favourablemoney;    //买家优惠金额
    private String buytrueordermoney;  //买家订单实际金额
    private String paymoney;           //已付金额
    private String state;              //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款7:  订单失效
    private String statename;          //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款7:  订单失效
    private String workerid;           //业务顾问ID 
    private String remark;             //备注 
    private String suctime;            //订单处理完成时间 
    private String transferfee;            //过户费(商标)
    
    
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
	public String getOrderkind() {
		return orderkind;
	}
	public void setOrderkind(String orderkind) {
		this.orderkind = orderkind;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
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
	public String getTransferfee() {
		return transferfee;
	}
	public void setTransferfee(String transferfee) {
		this.transferfee = transferfee;
	}
    
    
}
