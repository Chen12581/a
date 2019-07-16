package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtUserBill;

public class UserBillDao  extends SessionDaoSupport{
	public void insertWqtUserBill(WqtUserBill wqtUserBill)
	{
		getSession().insert("wqtuser.insertWqtUserBill",wqtUserBill);
	}
	
	public void deleteWqtUserBill(String userContractid)
	{
	    getSession().delete("wqtuser.deleteWqtUserBill",userContractid);
	}

	public void updateWqtUserBill(WqtUserBill wqtUserBill)
	{
		getSession().update("wqtuser.updateWqtUserBill",wqtUserBill);
	}
	
	public WqtUserBill selectOneWqtUserBill(String userContractid)
	{
		return (WqtUserBill)getSession().selectOne("wqtuser.selectOneWqtUserBill",userContractid);
	}

	public List<WqtUserBill> selectListWqtUserBill(WqtUserBill wqtUserBill)
	{
		return getSession().selectList("wqtuser.selectListWqtUserBill",wqtUserBill);
	}
	
	/*分页查询信息*/
	public Pagination  selectPageWqtUserBill(WqtUserBill wqtUserBill,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<WqtUserBill> list =this.getSession().selectList("wqtuser.selectListWqtUserBill", wqtUserBill, pagination);
		pagination.setList(list);
		return pagination;
	}
}
