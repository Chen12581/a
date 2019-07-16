package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.base.right.pojo.App;
import com.talkweb.twdpe.base.right.pojo.AppList;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.user.pojo.UserBasic;

public class UserBasicDao extends SessionDaoSupport{
	
	public void insertUserBasic(UserBasic wqtUserBasic)
	{
		getSession().insert("wqtuser.insertUserBasic",wqtUserBasic);
	}
	
	public void deleteUserBasic(String userid)
	{
	    getSession().delete("wqtuser.deleteUserBasic",userid);
	}

	public void updateUserBasic(UserBasic wqtUserBasic)
	{
		getSession().update("wqtuser.updateUserBasic",wqtUserBasic);
	}
	
	public UserBasic selectUserById(String userid)
	{
		return (UserBasic)getSession().selectOne("wqtuser.selectUserById",userid);
	}
    
	public UserBasic selectUserByUsername(String username)
	{
		return (UserBasic)getSession().selectOne("wqtuser.selectUserByUsername",username);
	}
	
	public UserBasic selectUserByMobileNo(String mobileno)
	{
		return (UserBasic)getSession().selectOne("wqtuser.selectUserByMobileNo",mobileno);
	}
	
	public List<UserBasic> selectListUserBasic(UserBasic wqtUserBasic)
	{
		return getSession().selectList("wqtuser.selectListUserBasic",wqtUserBasic);
	}
	
	public List<UserBasic> userLogin(UserBasic wqtUserBasic)
	{
		return getSession().selectList("wqtuser.userLogin",wqtUserBasic);
	}
	
	public UserBasic userLogin(String userparam)
	{
		return (UserBasic)getSession().selectOne("wqtuser.userLogin",userparam);
	}
	
	/*分页查询信息*/
	public Pagination  selectPageUserBasic(UserBasic wqtUserBasic,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<UserBasic> list =this.getSession().selectList("wqtuser.selectListUserBasic", wqtUserBasic, pagination);
		pagination.setList(list);
		return pagination;
	}
}
