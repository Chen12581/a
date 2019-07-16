package com.wqt.news.dal;

import java.util.List;

import com.news.pojo.NewsKind;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;

public class NewsKindDao extends SessionDaoSupport {
	
	public List<NewsKind> selectWqtNewsKindList(NewsKind newsKind){
		return this.getSession().selectList("news.selectWqtNewsKindList",newsKind);
	}
}
