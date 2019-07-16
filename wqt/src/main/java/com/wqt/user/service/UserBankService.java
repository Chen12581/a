package com.wqt.user.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtUserBank;

public interface UserBankService {
	public void insertUserBank(WqtUserBank wqtUserBank);
	
	public void deleteUserBank(WqtUserBank wqtUserBank);

	public void updateUserBank(WqtUserBank wqtUserBank);
	
	public WqtUserBank selectOneUser(WqtUserBank wqtUserBank);
	
	public List<WqtUserBank> selectListUserBank(WqtUserBank wqtUserBank);
	
	
	/*分页查询信息*/
	public Pagination  selectPageUserBank(WqtUserBank wqtUserBank,Pagination pagination);
}
