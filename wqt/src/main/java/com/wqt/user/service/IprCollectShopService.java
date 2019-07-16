package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.IprCollectShop;

public interface IprCollectShopService {

     /*分页查询用户收藏*/
     public Pagination  selectIprCollectShopPage(IprCollectShop iprCollectShop,Pagination pagination);
     
     /*删除用户收藏*/
	 public void delIprCollectShop(IprCollectShop iprCollectShop);
}
