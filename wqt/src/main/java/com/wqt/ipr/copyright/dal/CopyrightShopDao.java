package com.wqt.ipr.copyright.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.ipr.brand.pojo.IprBrandShop;
import com.wqt.ipr.copyright.pojo.IprCopyrightShop;

public class CopyrightShopDao extends SessionDaoSupport{
	
	public void updateCopyrightShop(IprCopyrightShop iprCopyrightShop) {
		this.getSession().update("iprCopyright.updateCopyrightShop", iprCopyrightShop);
	}
	
	@SuppressWarnings("unchecked")
	public List<IprCopyrightShop> selectCopyrightShopList(IprCopyrightShop iprCopyrightShop) {
		return this.getSession().selectList("iprCopyright.selectCopyrightShopList", iprCopyrightShop);
	}
	
	public Pagination  selectCopyrightShopPage(IprCopyrightShop iprCopyrightShop,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<IprCopyrightShop> list =this.getSession().selectList("iprCopyright.selectCopyrightShopList", iprCopyrightShop, pagination);
		pagination.setList(list);
		return pagination;
	 }
	
	/**
	 * 查询单个版权
	 * @param iprCopyrightShop
	 * @return
	 */
	public IprCopyrightShop selectCopyrightShopOne(IprCopyrightShop iprCopyrightShop) {
		return (IprCopyrightShop) this.getSession().selectOne("iprCopyright.selectCopyrightShopOne", iprCopyrightShop);
	}
	
}
