package com.wqt.user.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtCapitalAccount;

public interface CapitalAccountService {
	
	public void insertCapitalAccount(WqtCapitalAccount wqtCapitalAccount);
	
	public void updateCapitalAccount(WqtCapitalAccount wqtCapitalAccount);
	
	public void deleteCapitalAccount(String capitalaccountid);
	
	public WqtCapitalAccount selectCapitalAccountById(String capitalaccountid);
	
	public WqtCapitalAccount selectOneCapitalAccount(WqtCapitalAccount wqtCapitalAccount);
	
	public List<WqtCapitalAccount> selectCapitalAccountList(WqtCapitalAccount wqtCapitalAccount);

	/*分页查询信息*/
	public Pagination  selectCapitalAccountPage(WqtCapitalAccount wqtCapitalAccount,Pagination pagination);
}
