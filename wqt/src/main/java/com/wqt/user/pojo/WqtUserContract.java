package com.wqt.user.pojo;

/*合同主体*/
public class WqtUserContract {
	    private String id;                 //
	    private String userid;             //用户ID
	    private String kind;               //主体类别1:公司 2表示个人
	    private String name;               //kind=1表示企业名称 kind=2表示个人姓名
	    private String certificatecode;    //kind=1表示营业执照号码 kind=2表示个人身份证号�?
	    private String province;           //省
	    private String city;               //市
	    private String area;               //区
	    private String explicitaddr;       //详细地址
	    private String connector;          //联系人
	    private String mobileno;           //联系电话
	    private String tel;                //固定电话
	    private String email;              //邮箱
	    private String isdefault;          //1表示为默认
	    private String insertdate;         //添加时间
	    
	    
		public String getIsdefault() {
			return isdefault;
		}
		public void setIsdefault(String isdefault) {
			this.isdefault = isdefault;
		}
		public String getInsertdate() {
			return insertdate;
		}
		public void setInsertdate(String insertdate) {
			this.insertdate = insertdate;
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
		public String getKind() {
			return kind;
		}
		public void setKind(String kind) {
			this.kind = kind;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCertificatecode() {
			return certificatecode;
		}
		public void setCertificatecode(String certificatecode) {
			this.certificatecode = certificatecode;
		}
		
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getExplicitaddr() {
			return explicitaddr;
		}
		public void setExplicitaddr(String explicitaddr) {
			this.explicitaddr = explicitaddr;
		}
		public String getConnector() {
			return connector;
		}
		public void setConnector(String connector) {
			this.connector = connector;
		}
		public String getMobileno() {
			return mobileno;
		}
		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
}
