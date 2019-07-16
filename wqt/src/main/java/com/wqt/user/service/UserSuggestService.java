package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtUserSuggest;

public interface UserSuggestService {
	
	public void insertUserSuggest(WqtUserSuggest wqtUserSuggest);
	
	/*分页查询信息*/
	public Pagination  selectPageUserSuggest(WqtUserSuggest wqtUserSuggest,Pagination pagination);
	
	public void updateUserSuggest(WqtUserSuggest wqtUserSuggest);
	
	public void deleteUserSuggest(String suggestid);
	
	public WqtUserSuggest selectUserSuggestById(String suggestid);
}
