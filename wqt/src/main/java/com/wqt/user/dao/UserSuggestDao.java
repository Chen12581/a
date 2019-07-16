package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtUserSuggest;

public class UserSuggestDao extends SessionDaoSupport{
	
	public void insertUserSuggest(WqtUserSuggest wqtUserSuggest)
	{
		getSession().insert("wqtuser.insertUserSuggest",wqtUserSuggest);
	}
	
	public void updateUserSuggest(WqtUserSuggest wqtUserSuggest)
	{
		getSession().update("wqtuser.updateUserSuggest",wqtUserSuggest);
	}
	
	public void deleteUserSuggest(String suggestid)
	{
	    getSession().delete("wqtuser.deleteUserSuggest",suggestid);
	}
	
	public WqtUserSuggest selectUserSuggestById(String suggestid)
	{
		return (WqtUserSuggest)getSession().selectOne("wqtuser.selectUserSuggestById",suggestid);
	}
	
	/*分页查询信息*/
	public Pagination  selectPageUserSuggest(WqtUserSuggest wqtUserSuggest,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<WqtUserSuggest> list =this.getSession().selectList("wqtuser.selectUserSuggestList", wqtUserSuggest, pagination);
		pagination.setList(list);
		return pagination;
	}
}
