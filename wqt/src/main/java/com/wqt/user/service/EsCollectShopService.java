package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.EsCollectShop;

public interface EsCollectShopService {

     /*分页查询用户收藏*/
     public Pagination  selectEsCollectShopPage(EsCollectShop esCollectShop,Pagination pagination);
     
     /*删除用户收藏*/
	 public void delEsCollectShop(EsCollectShop esCollectShop);
}
