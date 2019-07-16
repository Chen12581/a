package com.wqt.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.news.pojo.NewsLabel;
import com.wqt.news.dal.NewsNewsLabelDao;
import com.wqt.news.service.NewsNewsLabelService;

public class NewsNewsLabelServiceImpl implements NewsNewsLabelService {
    
	@Autowired
	private NewsNewsLabelDao newsNewsLabelDao;
	
	@Override
	public List<NewsLabel> selectWqtNewsNewsLabelList(String newsid) {
		return newsNewsLabelDao.selectWqtNewsNewsLabelList(newsid);
	}

}
