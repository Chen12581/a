package com.wqt.news.dal;

import java.util.List;

import com.news.pojo.News;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;

public class NewsDao extends SessionDaoSupport{
	
	@SuppressWarnings("unchecked")
	public List<News> selectWqtNewsListFour(News news){
		return this.getSession().selectList("news.selectWqtNewsList",news);
	}
	
	public News selectWqtNewsOne(News news) {
		return (News) this.getSession().selectOne("news.selectWqtNewsOne", news);
	}
	
	public Pagination  selectWqtNewsPage(News news,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<News> list =this.getSession().selectList("news.selectWqtNewsList", news, pagination);
		pagination.setList(list);
		return pagination;
	}
	
	/*查询前一条新闻*/
	public News selectPreWqtNews(News news) {
		return (News) this.getSession().selectOne("news.selectPreWqtNews", news);
	}
	
	/*查询后一条News*/
	public News selectNextWqtNews(News news) {
		return (News) this.getSession().selectOne("news.selectNextWqtNews", news);
	}
}
