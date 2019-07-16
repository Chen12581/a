package com.wqt.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.news.pojo.News;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.news.dal.NewsDao;
import com.wqt.news.service.NewsService;

public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;
	
	@Override
	public News selectWqtNewsOne(News news) {
		return newsDao.selectWqtNewsOne(news);
	}

	@Override
	public List<News> selectWqtNewsListFour(News news) {
		return newsDao.selectWqtNewsListFour(news);
	}

	@Override
	public Pagination selectWqtNewsPage(News news, Pagination pagination) {
		return newsDao.selectWqtNewsPage(news, pagination);
	}

	@Override
	public News selectPreWqtNews(News news) {
		return newsDao.selectPreWqtNews(news);
	}

	@Override
	public News selectNextWqtNews(News news) {
		return newsDao.selectNextWqtNews(news);
	}

}
