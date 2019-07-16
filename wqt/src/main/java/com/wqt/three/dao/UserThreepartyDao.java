package com.wqt.three.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.three.pojo.WqtUserThreeparty;

public class UserThreepartyDao  extends SessionDaoSupport{
	
	public void insertUserThreeparty(WqtUserThreeparty wqtUserThreeparty) {
		this.getSession().insert("userthree.insertUserThreeparty", wqtUserThreeparty);
	}
	
	
	public WqtUserThreeparty selectUserThreepartyOne(WqtUserThreeparty wqtUserThreeparty) {
		return (WqtUserThreeparty) this.getSession().selectOne("userthree.selectUserThreepartyList", wqtUserThreeparty);
	}
	
	
	public List<WqtUserThreeparty> selectUserThreepartyList(WqtUserThreeparty wqtUserThreeparty) {
		return  this.getSession().selectList("userthree.selectUserThreepartyList", wqtUserThreeparty);
	}
	
	public void updateUserThreeparty(WqtUserThreeparty wqtUserThreeparty) {
		this.getSession().update("userthree.updateUserThreeparty",wqtUserThreeparty);
	}
	
}
