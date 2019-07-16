package com.wqt.user.dao;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.wqt.user.pojo.UOrderCancel;

public class UOrderCancelDao   extends SessionDaoSupport{
	/*新增取消订单*/
	public void insertUOrderCancel(UOrderCancel uOrderCancel) {
		this.getSession().insert("wqtorder.insertUOrderCancel", uOrderCancel);
	}
}
