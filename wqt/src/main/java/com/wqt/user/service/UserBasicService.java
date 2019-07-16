package com.wqt.user.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.user.pojo.UserBasic;

public interface UserBasicService {
	
	public void insertUserBasic(UserBasic wqtUserBasic);
	
	public void deleteUserBasic(String userid);

	public void updateUserBasic(UserBasic wqtUserBasic);
	
	public UserBasic selectUserById(String userid);
	
	public UserBasic selectUserByUsername(String username);
	
	public UserBasic selectUserByMobileNo(String mobileno);

	public List<UserBasic> selectListUserBasic(UserBasic wqtUserBasic);
	
	/*根据参数分页查询网店列表信息*/
	public Pagination  selectPageUserBasic(UserBasic tWqtUserBasic,Pagination pagination);
	
	
	public UserBasic userLogin(String userparam);
}
