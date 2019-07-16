package com.wqt.news.dal;

import java.util.List;

import com.news.pojo.News;
import com.news.pojo.NewsLabel;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;

public class NewsNewsLabelDao  extends SessionDaoSupport{
	/*查询新闻的标签*/
	public List<NewsLabel> selectWqtNewsNewsLabelList(String  newsid) {
		List<NewsLabel> list =this.getSession().selectList("news.selectWqtNewsNewsLabelList", newsid);
		return list;
	}
}
