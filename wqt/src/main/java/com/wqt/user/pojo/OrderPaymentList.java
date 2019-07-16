package com.wqt.user.pojo;

import java.util.List;

import com.user.pojo.UserBasic;


/*付款页，如果是多个订单付款，显示列表*/
public class OrderPaymentList {
    private List<OrderPayment> l_OrderPayment;
    
    private String sailflag;   //是否可售的标志 1表示可售 2表示不可售
    
    public String getSailflag() {
		return sailflag;
	}

	public void setSailflag(String sailflag) {
		this.sailflag = sailflag;
	}

	private UserBasic wqtUserBasic;
	
	public UserBasic getWqtUserBasic() {
		return wqtUserBasic;
	}

	public void setWqtUserBasic(UserBasic wqtUserBasic) {
		this.wqtUserBasic = wqtUserBasic;
	}

	public List<OrderPayment> getL_OrderPayment() {
		return l_OrderPayment;
	}

	public void setL_OrderPayment(List<OrderPayment> l_OrderPayment) {
		this.l_OrderPayment = l_OrderPayment;
	}
}
