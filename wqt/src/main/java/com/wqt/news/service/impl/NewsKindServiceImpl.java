package com.wqt.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.news.pojo.NewsKind;
import com.wqt.news.dal.NewsKindDao;
import com.wqt.news.service.NewsKindService;

public class NewsKindServiceImpl implements NewsKindService{

	@Autowired
	private NewsKindDao newsKindDao;
	
	
	@Override
	public List<NewsKind> selectWqtNewsKindList(NewsKind newsKind) {
		return newsKindDao.selectWqtNewsKindList(newsKind);
	}

}
