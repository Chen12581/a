package com.wqt.user.service;

import java.util.List;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.WqtUserContract;

public interface UserContractService {
	public void insertWqtUserContract(WqtUserContract wqtUserContract);
	
	public void deleteWqtUserContract(String userContractid);

	public void updateWqtUserContract(WqtUserContract wqtUserContract);
	
	public WqtUserContract selectOneWqtUserContract(String userContractid);

	public List<WqtUserContract> selectListWqtUserContract(WqtUserContract wqtUserContract);
	
	/*分页查询信息*/
	public Pagination  selectPageWqtUserContract(WqtUserContract wqtUserContract,Pagination pagination);
}
