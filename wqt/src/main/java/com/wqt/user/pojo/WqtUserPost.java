package com.wqt.user.pojo;

/*用户邮寄地址管理*/
public class WqtUserPost {
	    private String id;                 //
	    private String userid;             //用户ID
	    private String recvname;           //收件人姓�?
	    private String recvprovice;        //收件人省�?
	    private String recvcity;           //收件人地�?
	    private String recvarea;           //收件人区�?
	    private String recvaddr;           //详细地址
	    private String postcode;           //邮政编码
	    private String connecttel;         //联系电话
	    private String isdefault;          //1表示为默认地�?
	    private String insertdate;          //
	    
	    
	    
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
		public String getRecvname() {
			return recvname;
		}
		public void setRecvname(String recvname) {
			this.recvname = recvname;
		}
		public String getRecvprovice() {
			return recvprovice;
		}
		public void setRecvprovice(String recvprovice) {
			this.recvprovice = recvprovice;
		}
		public String getRecvcity() {
			return recvcity;
		}
		public void setRecvcity(String recvcity) {
			this.recvcity = recvcity;
		}
		public String getRecvarea() {
			return recvarea;
		}
		public void setRecvarea(String recvarea) {
			this.recvarea = recvarea;
		}
		public String getRecvaddr() {
			return recvaddr;
		}
		public void setRecvaddr(String recvaddr) {
			this.recvaddr = recvaddr;
		}
		public String getPostcode() {
			return postcode;
		}
		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}
		public String getConnecttel() {
			return connecttel;
		}
		public void setConnecttel(String connecttel) {
			this.connecttel = connecttel;
		}
		public String getIsdefault() {
			return isdefault;
		}
		public void setIsdefault(String isdefault) {
			this.isdefault = isdefault;
		}    
}
