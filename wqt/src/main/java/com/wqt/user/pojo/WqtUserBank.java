package com.wqt.user.pojo;

/*万企通用户绑定银行信息*/
public class WqtUserBank {
	private String id;
	private String userid;  
	private String bankid;         //银行ID
	private String bankname;       //银行名称
	private String provinceid;     //省份ID
	private String cityid;         //城市ID
	private String mobileno;       //银行手机号
	private String smscode;        //短信验证码
	private String createtime;
	private String accountname;    //账户名称
	private String accountno;      //账号名称
	private String state;
	private String bindtime;
	private String unbindtime;
	
	
	
	public String getSmscode() {
		return smscode;
	}
	public void setSmscode(String smscode) {
		this.smscode = smscode;
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
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBindtime() {
		return bindtime;
	}
	public void setBindtime(String bindtime) {
		this.bindtime = bindtime;
	}
	public String getUnbindtime() {
		return unbindtime;
	}
	public void setUnbindtime(String unbindtime) {
		this.unbindtime = unbindtime;
	} 
}
