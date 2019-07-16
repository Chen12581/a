package com.wqt.user.dao;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.user.pojo.IprCollectShop;

public class IprCollectShopDao   extends SessionDaoSupport{

     /*分页查询用户收藏*/
     public Pagination  selectIprCollectShopPage(IprCollectShop iprCollectShop,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<IprCollectShop> list =this.getSession().selectList("iprcollect.selectIprCollectShopList", iprCollectShop, pagination);
		pagination.setList(list);
		return pagination;
	 }
     
     /*删除用户收藏*/
	 public void delIprCollectShop(IprCollectShop iprCollectShop)
	 {
		this.getSession().delete("iprcollect.delIprCollectShop",iprCollectShop);
	 }
	 
}
