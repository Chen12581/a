package com.wqt.ipr.order.pojo;

/*商标交易订单*/
public class IprBrandOrderShop {
	private String id;                    //
    private String ordercode;             //订单编码
    private String ordertime;             //订单时间
    private String shopid;                //交易产品ID
    private String brandname;             //商标名称
    private String brandkind;             //商标分类
    private String brandstate;            //商标目前状态，是否可售
    private String brandkindname;         //商标分类名称
    private String brandcode;             //商标编号
    private String brandicon;             //商标图标
    private String startvalidity;         //有效期开始时间
	private String endvalidity;           //有效期结束时间
    private String transferfee;           //过户费(商标)
    private String price;
    private String ordermoney;            //订单金额
    private String buycommisionratio;     //买方的佣金比例
    private String commisionbuy;          //买方的佣金
    private String reservepayratio;       //买方预定付款比例
    private String reservemoney;          //买方预定付款金额
    private String buyordermoney;         //买家订单总金额
    private String favourablemoney;        //买家优惠金额
    private String buytrueordermoney;      //买家订单实际金额
    private String paymoney;               //买家已付金额
    private String state;                 //单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款 7:  订单失效
    
    
    
	public String getBrandstate() {
		return brandstate;
	}
	public void setBrandstate(String brandstate) {
		this.brandstate = brandstate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBrandicon() {
		return brandicon;
	}
	public void setBrandicon(String brandicon) {
		this.brandicon = brandicon;
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
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getBrandkind() {
		return brandkind;
	}
	public void setBrandkind(String brandkind) {
		this.brandkind = brandkind;
	}
	public String getBrandkindname() {
		return brandkindname;
	}
	public void setBrandkindname(String brandkindname) {
		this.brandkindname = brandkindname;
	}
	public String getBrandcode() {
		return brandcode;
	}
	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}
	public String getStartvalidity() {
		return startvalidity;
	}
	public void setStartvalidity(String startvalidity) {
		this.startvalidity = startvalidity;
	}
	public String getEndvalidity() {
		return endvalidity;
	}
	public void setEndvalidity(String endvalidity) {
		this.endvalidity = endvalidity;
	}
	public String getTransferfee() {
		return transferfee;
	}
	public void setTransferfee(String transferfee) {
		this.transferfee = transferfee;
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
    
    
    
}
