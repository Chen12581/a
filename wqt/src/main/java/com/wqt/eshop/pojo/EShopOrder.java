package com.wqt.eshop.pojo;

import java.util.Date;

/*网店转让订单*/
public class EShopOrder {
	    private String id;                 //
	    private String ordercode;          //订单编码
	    private int userid;             //用户ID
	    private Date ordertime;            //订单时间
	    private Date suctime;              //完成时间
	    private String plateformcode;       //平台编码
	    private String shopcode;            //商铺编码
	    private String shoptitle;           //店铺标题
	    private String shopid;             //店铺ID
	    private int shopprice;             //商品价格
	    private String  malltypename="/";       //商城类型名
        private String  brandcategoryname="/";  //商标类型名
        private String  brandkindname="/";      //商标分类(天猫,京东用)
        private String  maincategoryid;       //店铺主营类目名 
        private String  maincategoryname;       //店铺主营类目名 
        private String  creditname;         //卖家信用等级内容
	    private int ordermoney;            //订单金额
	    private int state;              //订单状态1：提交待付款 2 : 已付定金 3：已付全款，办理中 4：办理完成 5:  订单取消 6:  订单退款 7:  订单失效
	    private int sellerid;           //卖家USERID
	    private int buyerid;            //买家USERID
	    private double buycommisionratio;  //买方的佣金比例
	    private double commisionbuy;       //买方的佣金
	    private double sailcommisionratio; //卖方佣金比例
	    private double commisionsail;      //卖方佣金
	    private double reservepayratio;    //定金付款比例
	    private double reservemoney;    //定金
	    private double depositmoney;    //消保
	    private double deposittype;    //是否退还消保1:真实消保(需要退还) 2:真实消保(不需要退还)3:信用消保
	    private double techfee;    //技术年费
	    private double techfeereturn;    //是否退换技术年费(1表示不退还 2表示退还)
	    private double techfeeratio;      //技术年费退还比率
	    private double sailordermoney;    //卖家订单总金额
	    private double buyordermoney;    //买家订单总金额
	    private double favourablemoney;    //优惠金额(针对买家)
	    private double buytrueordermoney;  ////买家订单实际金额
	    private double paymoney;    //已付金额
	    private double remark;    //备注
	    private double orderworkerid;    //成交的工作人员ID
	    private double billstatus;    //是否开发票1:表示未开发票2表示已开发票3表示审核未通过
	    private double loanmoney;    //已放款金额
	    
	    
	    
		public String getMaincategoryid() {
			return maincategoryid;
		}
		public void setMaincategoryid(String maincategoryid) {
			this.maincategoryid = maincategoryid;
		}
		public double getTechfeeratio() {
			return techfeeratio;
		}
		public void setTechfeeratio(double techfeeratio) {
			this.techfeeratio = techfeeratio;
		}
		public String getMalltypename() {
			return malltypename;
		}
		public void setMalltypename(String malltypename) {
			this.malltypename = malltypename;
		}
		public String getBrandcategoryname() {
			return brandcategoryname;
		}
		public void setBrandcategoryname(String brandcategoryname) {
			this.brandcategoryname = brandcategoryname;
		}
		public String getBrandkindname() {
			return brandkindname;
		}
		public void setBrandkindname(String brandkindname) {
			this.brandkindname = brandkindname;
		}
		public String getMaincategoryname() {
			return maincategoryname;
		}
		public void setMaincategoryname(String maincategoryname) {
			this.maincategoryname = maincategoryname;
		}
		public String getCreditname() {
			return creditname;
		}
		public void setCreditname(String creditname) {
			this.creditname = creditname;
		}
		public String getPlateformcode() {
			return plateformcode;
		}
		public void setPlateformcode(String plateformcode) {
			this.plateformcode = plateformcode;
		}
		public String getShopcode() {
			return shopcode;
		}
		public void setShopcode(String shopcode) {
			this.shopcode = shopcode;
		}
		public String getShoptitle() {
			return shoptitle;
		}
		public void setShoptitle(String shoptitle) {
			this.shoptitle = shoptitle;
		}
		public double getBuytrueordermoney() {
			return buytrueordermoney;
		}
		public void setBuytrueordermoney(double buytrueordermoney) {
			this.buytrueordermoney = buytrueordermoney;
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
		
		public Date getOrdertime() {
			return ordertime;
		}
		public void setOrdertime(Date ordertime) {
			this.ordertime = ordertime;
		}
		public Date getSuctime() {
			return suctime;
		}
		public void setSuctime(Date suctime) {
			this.suctime = suctime;
		}
		public String getShopid() {
			return shopid;
		}
		public void setShopid(String shopid) {
			this.shopid = shopid;
		}
		public int getShopprice() {
			return shopprice;
		}
		public void setShopprice(int shopprice) {
			this.shopprice = shopprice;
		}
		public int getOrdermoney() {
			return ordermoney;
		}
		public void setOrdermoney(int ordermoney) {
			this.ordermoney = ordermoney;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
		}
		public int getSellerid() {
			return sellerid;
		}
		public void setSellerid(int sellerid) {
			this.sellerid = sellerid;
		}
		public int getBuyerid() {
			return buyerid;
		}
		public void setBuyerid(int buyerid) {
			this.buyerid = buyerid;
		}
		public double getBuycommisionratio() {
			return buycommisionratio;
		}
		public void setBuycommisionratio(double buycommisionratio) {
			this.buycommisionratio = buycommisionratio;
		}
		public double getCommisionbuy() {
			return commisionbuy;
		}
		public void setCommisionbuy(double commisionbuy) {
			this.commisionbuy = commisionbuy;
		}
		public double getSailcommisionratio() {
			return sailcommisionratio;
		}
		public void setSailcommisionratio(double sailcommisionratio) {
			this.sailcommisionratio = sailcommisionratio;
		}
		public double getCommisionsail() {
			return commisionsail;
		}
		public void setCommisionsail(double commisionsail) {
			this.commisionsail = commisionsail;
		}
		public double getReservepayratio() {
			return reservepayratio;
		}
		public void setReservepayratio(double reservepayratio) {
			this.reservepayratio = reservepayratio;
		}
		public double getReservemoney() {
			return reservemoney;
		}
		public void setReservemoney(double reservemoney) {
			this.reservemoney = reservemoney;
		}
		public double getDepositmoney() {
			return depositmoney;
		}
		public void setDepositmoney(double depositmoney) {
			this.depositmoney = depositmoney;
		}
		public double getDeposittype() {
			return deposittype;
		}
		public void setDeposittype(double deposittype) {
			this.deposittype = deposittype;
		}
		public double getTechfee() {
			return techfee;
		}
		public void setTechfee(double techfee) {
			this.techfee = techfee;
		}
		public double getTechfeereturn() {
			return techfeereturn;
		}
		public void setTechfeereturn(double techfeereturn) {
			this.techfeereturn = techfeereturn;
		}
		public double getSailordermoney() {
			return sailordermoney;
		}
		public void setSailordermoney(double sailordermoney) {
			this.sailordermoney = sailordermoney;
		}
		public double getBuyordermoney() {
			return buyordermoney;
		}
		public void setBuyordermoney(double buyordermoney) {
			this.buyordermoney = buyordermoney;
		}
		public double getFavourablemoney() {
			return favourablemoney;
		}
		public void setFavourablemoney(double favourablemoney) {
			this.favourablemoney = favourablemoney;
		}
		public double getPaymoney() {
			return paymoney;
		}
		public void setPaymoney(double paymoney) {
			this.paymoney = paymoney;
		}
		public double getRemark() {
			return remark;
		}
		public void setRemark(double remark) {
			this.remark = remark;
		}
		public double getOrderworkerid() {
			return orderworkerid;
		}
		public void setOrderworkerid(double orderworkerid) {
			this.orderworkerid = orderworkerid;
		}
		public double getBillstatus() {
			return billstatus;
		}
		public void setBillstatus(double billstatus) {
			this.billstatus = billstatus;
		}
		public double getLoanmoney() {
			return loanmoney;
		}
		public void setLoanmoney(double loanmoney) {
			this.loanmoney = loanmoney;
		}	
}
