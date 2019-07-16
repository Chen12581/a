package com.wqt.news.service;

import java.util.List;

import com.news.pojo.NewsKind;

public interface NewsKindService {
	
	public List<NewsKind> selectWqtNewsKindList(NewsKind newsKind);
}
