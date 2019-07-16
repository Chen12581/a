package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UserCollect;

public class UserCollectDao   extends SessionDaoSupport{
	
	/*分页查询用户收藏*/
	 public Pagination  selectUserCollectPage(UserCollect userCollect,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<UserCollect> list =this.getSession().selectList("wqtuser.selectUserCollectList", userCollect, pagination);
		pagination.setList(list);
		return pagination;
	 }
}
