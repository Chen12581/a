package com.wqt.user.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtUserPost;

public interface UserPostService {
	public void insertWqtUserPost(WqtUserPost wqtUserPost);
	
	public void deleteWqtUserPost(String userPostid);

	public void updateWqtUserPost(WqtUserPost wqtUserPost);
	
	public WqtUserPost selectOneWqtUserPost(String userPostid);

	public List<WqtUserPost> selectListWqtUserPost(WqtUserPost wqtUserPost);
	
	/*分页查询信息*/
	public Pagination  selectPageWqtUserPost(WqtUserPost wqtUserPost,Pagination pagination);
}
