package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtUserPost;

public class UserPostDao  extends SessionDaoSupport{
	
	public void insertWqtUserPost(WqtUserPost wqtUserPost)
	{
		getSession().insert("wqtuser.insertWqtUserPost",wqtUserPost);
	}
	
	public void deleteWqtUserPost(String userPostid)
	{
	    getSession().delete("wqtuser.deleteWqtUserPost",userPostid);
	}

	public void updateWqtUserPost(WqtUserPost wqtUserPost)
	{
		getSession().update("wqtuser.updateWqtUserPost",wqtUserPost);
	}
	
	public WqtUserPost selectOneWqtUserPost(String userPostid)
	{
		return (WqtUserPost)getSession().selectOne("wqtuser.selectOneWqtUserPost",userPostid);
	}

	public List<WqtUserPost> selectListWqtUserPost(WqtUserPost wqtUserPost)
	{
		return getSession().selectList("wqtuser.selectListWqtUserPost",wqtUserPost);
	}
	
	/*分页查询信息*/
	public Pagination  selectPageWqtUserPost(WqtUserPost wqtUserPost,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<WqtUserPost> list =this.getSession().selectList("wqtuser.selectListWqtUserPost", wqtUserPost, pagination);
		pagination.setList(list);
		return pagination;
	}
}
