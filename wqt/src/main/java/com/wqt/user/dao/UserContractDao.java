package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtUserContract;

public class UserContractDao extends SessionDaoSupport{
	
	public void insertWqtUserContract(WqtUserContract wqtUserContract)
	{
		getSession().insert("wqtuser.insertWqtUserContract",wqtUserContract);
	}
	
	public void deleteWqtUserContract(String userContractid)
	{
	    getSession().delete("wqtuser.deleteWqtUserContract",userContractid);
	}

	public void updateWqtUserContract(WqtUserContract wqtUserContract)
	{
		getSession().update("wqtuser.updateWqtUserContract",wqtUserContract);
	}
	
	public WqtUserContract selectOneWqtUserContract(String userContractid)
	{
		return (WqtUserContract)getSession().selectOne("wqtuser.selectOneWqtUserContract",userContractid);
	}

	public List<WqtUserContract> selectListWqtUserContract(WqtUserContract wqtUserContract)
	{
		return getSession().selectList("wqtuser.selectListWqtUserContract",wqtUserContract);
	}
	
	/*分页查询信息*/
	public Pagination  selectPageWqtUserContract(WqtUserContract wqtUserContract,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<WqtUserContract> list =this.getSession().selectList("wqtuser.selectListWqtUserContract", wqtUserContract, pagination);
		pagination.setList(list);
		return pagination;
	}
}
