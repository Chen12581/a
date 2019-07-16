package com.wqt.three.service;

import java.util.List;

import com.wqt.three.pojo.WqtUserThreeparty;

public interface UserThreepartyService {
	public void insertUserThreeparty(WqtUserThreeparty wqtUserThreeparty);
	
	public WqtUserThreeparty selectUserThreepartyOne(WqtUserThreeparty wqtUserThreeparty);
	
	public List<WqtUserThreeparty> selectUserThreepartyList(WqtUserThreeparty wqtUserThreeparty);
	
	public void updateUserThreeparty(WqtUserThreeparty wqtUserThreeparty);
}
