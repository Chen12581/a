package com.wqt.user.service;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.EsCollectProduct;

public interface EsCollectProductService {

     /*分页查询用户收藏*/
     public Pagination  selectEsCollectProductPage(EsCollectProduct esCollectProduct,Pagination pagination);
     
     /*删除用户收藏*/
 	 public void delEsCollectProduct(EsCollectProduct esCollectProduct);
}
