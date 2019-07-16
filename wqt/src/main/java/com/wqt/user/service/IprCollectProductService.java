package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.IprCollectProduct;

public interface IprCollectProductService {

     /*分页查询用户收藏*/
     public Pagination  selectIprCollectProductPage(IprCollectProduct iprCollectProduct,Pagination pagination);
     
     /*删除用户收藏*/
 	 public void delIprCollectProduct(IprCollectProduct iprCollectProduct);
}
