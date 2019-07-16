package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.UserCollect;
import com.wqt.user.pojo.UsercenterOrder;

public interface UserCollectService {
	/*分页查询用户收藏*/
	public Pagination  selectUserCollectPage(UserCollect userCollect,Pagination pagination);
}
