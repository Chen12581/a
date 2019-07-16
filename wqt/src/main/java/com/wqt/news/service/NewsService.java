package com.wqt.news.service;

import java.util.List;

import com.news.pojo.News;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;

public interface NewsService {
	
	public List<News> selectWqtNewsListFour(News news);
	
	public News selectWqtNewsOne(News news);
	
	public Pagination  selectWqtNewsPage(News news,Pagination pagination);
	
	/*查询前一条新闻*/
	public News selectPreWqtNews(News news);
	
	/*查询后一条新闻*/
	public News selectNextWqtNews(News news);
	
}


