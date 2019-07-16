package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtUserBank;

public class UserBankDao  extends SessionDaoSupport{
	public void insertUserBank(WqtUserBank wqtUserBank)
	{
		getSession().insert("wqtuser.insertUserBank",wqtUserBank);
	}
	
	public void deleteUserBank(WqtUserBank wqtUserBank)
	{
	    getSession().delete("wqtuser.deleteUserBank",wqtUserBank);
	}

	public void updateUserBank(WqtUserBank wqtUserBank)
	{
		getSession().update("wqtuser.updateUserBank",wqtUserBank);
	}
	
	public WqtUserBank selectOneUser(WqtUserBank wqtUserBank)
	{
		return (WqtUserBank)getSession().selectOne("wqtuser.selectListUserBank",wqtUserBank);
	}
	
	public List<WqtUserBank> selectListUserBank(WqtUserBank wqtUserBank)
	{
		return getSession().selectList("wqtuser.selectListUserBank",wqtUserBank);
	}
	
	
	/*分页查询信息*/
	public Pagination  selectPageUserBank(WqtUserBank wqtUserBank,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<WqtUserBank> list =this.getSession().selectList("wqtuser.selectListUserBank", wqtUserBank, pagination);
		pagination.setList(list);
		return pagination;
	}
}
