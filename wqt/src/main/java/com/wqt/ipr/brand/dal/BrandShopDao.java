package com.wqt.ipr.brand.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.brand.pojo.IprBrandShop;

public class BrandShopDao  extends SessionDaoSupport{ 
	 /*修改交易商标*/
	 public void updateIprBrandShop(IprBrandShop iprBrandShop)
	 {
		this.getSession().update("iprbrand.updateIprBrandShop",iprBrandShop);
	 }	 
	
	 /*查询交易商标*/
    @SuppressWarnings("unchecked")
	public List<IprBrandShop> selectIprBrandShopList(IprBrandShop iprBrandShop)
    {
	     List<IprBrandShop> list = this.getSession().selectList("iprbrand.selectIprBrandShopList",iprBrandShop);
		 return list;
    }
 
    /*分页查询交易商标*/
	 public Pagination  selectIprBrandShopPage(IprBrandShop iprBrandShop,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<IprBrandShop> list =this.getSession().selectList("iprbrand.selectIprBrandShopList", iprBrandShop, pagination);
		pagination.setList(list);
		return pagination;
	 }
	 
	 /*查询单个交易商标*/
	 public IprBrandShop selectBrandShopOne(IprBrandShop brandShop) {
		 return (IprBrandShop) this.getSession().selectOne("iprbrand.selectBrandShopOne", brandShop);
	 }
	 
	 /*查询单个交易商标*/
	 public IprBrandShop selectBrandShopOnes(IprBrandShop brandShop) {
		 return (IprBrandShop) this.getSession().selectOne("iprbrand.selectBrandShopOnes", brandShop);
	 }
}
