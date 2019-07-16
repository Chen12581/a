package com.wqt.user.dao;



import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.EsCollectShop;

public class EsCollectShopDao   extends SessionDaoSupport{

     /*分页查询用户收藏*/
     public Pagination  selectEsCollectShopPage(EsCollectShop esCollectShop,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<EsCollectShop> list =this.getSession().selectList("escollect.selectEsCollectShopList", esCollectShop, pagination);
		pagination.setList(list);
		return pagination;
	 }
     
     /*删除用户收藏*/
	 public void delEsCollectShop(EsCollectShop esCollectShop)
	 {
		this.getSession().delete("escollect.delEsCollectShop",esCollectShop);
	 }
	 
}
