package com.wqt.user.pojo;

/*取消订单处理*/
public class UOrderCancel {
    private int id;               //主键
    private int orderid;          //订单ID
    private String ordercode;     //订单编码
    private int ordertype;        //订单类型1：知识产权服务订单2：知识产权交易订单3：企业服务服务订单4：企业服务交易订单5：网店转让订单
    private int canceltime;       //取消时间
    private int canceluserid;     //取消用户
    private int state;            //处理状态1：表示用户提交2：表示已经处理
    private int workerid;         //处理业务员
    private String remark;        //处理备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public int getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(int ordertype) {
		this.ordertype = ordertype;
	}
	public int getCanceltime() {
		return canceltime;
	}
	public void setCanceltime(int canceltime) {
		this.canceltime = canceltime;
	}
	public int getCanceluserid() {
		return canceluserid;
	}
	public void setCanceluserid(int canceluserid) {
		this.canceluserid = canceluserid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getWorkerid() {
		return workerid;
	}
	public void setWorkerid(int workerid) {
		this.workerid = workerid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
      
      
      
}
