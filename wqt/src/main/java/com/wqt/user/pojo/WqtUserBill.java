package com.wqt.user.pojo;

/*用户申请发票*/
public class WqtUserBill {
	private String id;                 //
    private String userid;             //用户ID
    private String orderid;       //买家关联定单ID,卖家通过订单去找店铺ID
    private String kind;      //发票类型 1：个人  2：企业
    private String dutycode;      //纳税人识别号/身份证号码    kind=1 就是身份证号码kind=2 就是纳税人识别号
    private String billtitle;        //发票抬头名称
    private String billcode;    //发票编码
    private String billmoney;          //开票金额
    private String billcontent;        //开票的内容（服务费，店铺费）
    private String provinceid;          //发票寄送省ID
    private String cityid;       //收寄人地市ID
    private String recvaddr;          //发票寄送地址
    private String recvname;       //收寄人姓名
    private String recvmobile;       //收寄人电话
    private String billtime;        //添加时间
    private String state;        //状态 1表示用户申请 2表示已经处理处理
    private String succtime;        //处理完成时间
    private String postcode;        //寄送快递单号
    private String postcompany;    //寄送快递公司
    private String remark;        //备注
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getDutycode() {
		return dutycode;
	}
	public void setDutycode(String dutycode) {
		this.dutycode = dutycode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getBilltitle() {
		return billtitle;
	}
	public void setBilltitle(String billtitle) {
		this.billtitle = billtitle;
	}
	public String getBillcode() {
		return billcode;
	}
	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}
	public String getBillmoney() {
		return billmoney;
	}
	public void setBillmoney(String billmoney) {
		this.billmoney = billmoney;
	}
	public String getBillcontent() {
		return billcontent;
	}
	public void setBillcontent(String billcontent) {
		this.billcontent = billcontent;
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
	public String getRecvaddr() {
		return recvaddr;
	}
	public void setRecvaddr(String recvaddr) {
		this.recvaddr = recvaddr;
	}
	public String getRecvname() {
		return recvname;
	}
	public void setRecvname(String recvname) {
		this.recvname = recvname;
	}
	public String getRecvmobile() {
		return recvmobile;
	}
	public void setRecvmobile(String recvmobile) {
		this.recvmobile = recvmobile;
	}
	public String getBilltime() {
		return billtime;
	}
	public void setBilltime(String billtime) {
		this.billtime = billtime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSucctime() {
		return succtime;
	}
	public void setSucctime(String succtime) {
		this.succtime = succtime;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPostcompany() {
		return postcompany;
	}
	public void setPostcompany(String postcompany) {
		this.postcompany = postcompany;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
