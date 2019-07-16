package com.wqt.three.alipay.login;

/*支付宝用户信息*/
public class AlipayUserInfo {
    private String openId;      //支付宝用户的userId
    private String city;        //市名称
    private String province;   //省份名称
    private String nickName;   //用户昵称 
    private String avatar;     //用户头像地址 
    
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
     
      
     
	
     
}
