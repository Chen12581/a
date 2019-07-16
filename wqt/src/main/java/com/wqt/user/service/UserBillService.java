package com.wqt.user.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtUserBill;

public interface UserBillService {
	public void insertWqtUserBill(WqtUserBill wqtUserBill);
	
	public void deleteWqtUserBill(String userContractid);

	public void updateWqtUserBill(WqtUserBill wqtUserBill);
	
	public WqtUserBill selectOneWqtUserBill(String userContractid);

	public List<WqtUserBill> selectListWqtUserBill(WqtUserBill wqtUserBill);
	
	/*分页查询信息*/
	public Pagination  selectPageWqtUserBill(WqtUserBill wqtUserBill,Pagination pagination);
}
