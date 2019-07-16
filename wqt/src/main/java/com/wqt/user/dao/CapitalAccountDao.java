package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtCapitalAccount;

/*资金明细*/
public class CapitalAccountDao  extends SessionDaoSupport{
	
	public void insertCapitalAccount(WqtCapitalAccount wqtCapitalAccount)
	{
		getSession().insert("wqtuser.insertCapitalAccount",wqtCapitalAccount);
	}
	
	public void updateCapitalAccount(WqtCapitalAccount wqtCapitalAccount)
	{
		getSession().update("wqtuser.updateCapitalAccount",wqtCapitalAccount);
	}
	
	public void deleteCapitalAccount(String capitalaccountid)
	{
	    getSession().delete("wqtuser.deleteCapitalAccount",capitalaccountid);
	}
	
	public WqtCapitalAccount selectOneCapitalAccount(WqtCapitalAccount wqtCapitalAccount)
	{
		return (WqtCapitalAccount)getSession().selectOne("wqtuser.selectCapitalAccountList",wqtCapitalAccount);
	}
	
	public WqtCapitalAccount selectCapitalAccountById(String capitalaccountid)
	{
		return (WqtCapitalAccount)getSession().selectOne("wqtuser.selectCapitalAccountById",capitalaccountid);
	}
	
	public List<WqtCapitalAccount> selectCapitalAccountList(WqtCapitalAccount wqtCapitalAccount)
	{
		return getSession().selectList("wqtuser.selectCapitalAccountList",wqtCapitalAccount);
	}
	
	
	/*分页查询信息*/
	public Pagination  selectCapitalAccountPage(WqtCapitalAccount wqtCapitalAccount,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<WqtCapitalAccount> list =this.getSession().selectList("wqtuser.selectCapitalAccountList", wqtCapitalAccount, pagination);
		pagination.setList(list);
		return pagination;
	}
}
