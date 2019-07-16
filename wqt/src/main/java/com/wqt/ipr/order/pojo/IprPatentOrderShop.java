package com.wqt.ipr.order.pojo;
/*交易专利订单详情*/
public class IprPatentOrderShop {
	private String id;                    //
    private String ordercode;             //订单编码
    private String ordertime;             //订单时间
    private String shopid;                //交易产品ID
    private String patentname;//专利名
    private String patentstatus;//专利交易状态
	private String patentstate;//专利状态
	private String applydate;//申请时间
    private String patenttype;//专利类型1：发明专利2：实用新型3：外观设计 
	private String kindid;//行业分类见表
	private String kindname;//行业分类见表
	private String patentno;//专利号
	private String shopcode;//商品编号
	private String validitydate;//有效期
	private String patenticon;//专利图片地址
	private String price;//出售价格
    private String transferfee;           //过户费(商标)
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
    

	public String getPatentstatus() {
		return patentstatus;
	}
	public void setPatentstatus(String patentstatus) {
		this.patentstatus = patentstatus;
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
	public String getPatentname() {
		return patentname;
	}
	public void setPatentname(String patentname) {
		this.patentname = patentname;
	}
	public String getPatentstate() {
		return patentstate;
	}
	public void setPatentstate(String patentstate) {
		this.patentstate = patentstate;
	}
	public String getApplydate() {
		return applydate;
	}
	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	public String getPatenttype() {
		return patenttype;
	}
	public void setPatenttype(String patenttype) {
		this.patenttype = patenttype;
	}
	public String getKindid() {
		return kindid;
	}
	public void setKindid(String kindid) {
		this.kindid = kindid;
	}
	public String getKindname() {
		return kindname;
	}
	public void setKindname(String kindname) {
		this.kindname = kindname;
	}
	public String getPatentno() {
		return patentno;
	}
	public void setPatentno(String patentno) {
		this.patentno = patentno;
	}
	public String getShopcode() {
		return shopcode;
	}
	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}
	public String getValiditydate() {
		return validitydate;
	}
	public void setValiditydate(String validitydate) {
		this.validitydate = validitydate;
	}
	public String getPatenticon() {
		return patenticon;
	}
	public void setPatenticon(String patenticon) {
		this.patenticon = patenticon;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
