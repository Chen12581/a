package com.collect.dal;



import java.util.List;

import com.collect.pojo.Collect;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;

public class CollectDao  extends SessionDaoSupport {
	
	 /*保存用户收藏*/
	 public void insertCollect(Collect collect)
	 {
		this.getSession().insert("wqtcollect.insertCollect",collect);
	 }
	
	 /*删除用户收藏*/
	 public void delCollect(Collect collect)
	 {
		this.getSession().delete("wqtcollect.delCollect",collect);
	 }
	
	 /*查询用户收藏*/
     public List<Collect> selectCollectList(Collect collect)
     {
	     List<Collect> list = this.getSession().selectList("wqtcollect.selectCollectList",collect);
		 return list;
     }
      
     public Pagination selectCollectPage(Collect collect,Pagination pagination) {
 		List<Collect> list=getSession().selectList("wqtcollect.selectCollectList", collect, pagination);
 		pagination.setList(list);
 		return pagination;
 	}
}
