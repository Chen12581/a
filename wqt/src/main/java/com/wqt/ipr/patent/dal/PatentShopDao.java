package com.wqt.ipr.patent.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.copyright.pojo.IprCopyrightShop;
import com.wqt.ipr.patent.pojo.IprPatentShop;

public class PatentShopDao extends SessionDaoSupport{
	
	/*查询专利列表*/
	@SuppressWarnings("unchecked")
	public List<IprPatentShop> selectPatentShopList(IprPatentShop iprPatentShop) {
		return this.getSession().selectList("iprpatent.selectPatentShopList", iprPatentShop);
	}
	
	public Pagination  selectPatentShopPage(IprPatentShop iprPatentShop,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<IprPatentShop> list =this.getSession().selectList("iprpatent.selectPatentShopList", iprPatentShop, pagination);
		pagination.setList(list);
		return pagination;
	 }
	
	/*修改专利信息*/
	public void updatePatentShop(IprPatentShop iprPatentShop) {
		this.getSession().update("iprpatent.updatePatentShop",iprPatentShop);
	}

	/*查询单个专利*/
	public IprPatentShop selectPatentShopOne(IprPatentShop iprPatentShop) {
		return (IprPatentShop) this.getSession().selectOne("iprpatent.selectPatentShopOne", iprPatentShop);
	}
}
