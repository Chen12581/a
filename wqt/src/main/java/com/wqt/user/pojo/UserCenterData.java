package com.wqt.user.pojo;

import java.util.List;

import com.user.pojo.UserBasic;

/*用户中心数据对象*/
public class UserCenterData {
	
    private UserBasic userbasic;
    private List<UsercenterOrder> l_UsercenterOrder;
    
	public UserBasic getUserbasic() {
		return userbasic;
	}
	
	public void setUserbasic(UserBasic userbasic) {
		this.userbasic = userbasic;
	}
	public List<UsercenterOrder> getL_UsercenterOrder() {
		return l_UsercenterOrder;
	}
	public void setL_UsercenterOrder(List<UsercenterOrder> l_UsercenterOrder) {
		this.l_UsercenterOrder = l_UsercenterOrder;
	}
      
      
}
