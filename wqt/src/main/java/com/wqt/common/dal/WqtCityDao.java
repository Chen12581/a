package com.wqt.common.dal;

import java.util.List;
import com.wqt.common.pojo.WqtCity;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.wqt.common.pojo.WqtCity;

public class WqtCityDao extends SessionDaoSupport{
	 /*保存地市*/
	 public void insertWqtCity(WqtCity wqtCity)
	 {
		this.getSession().insert("wqtcommon.insertWqtCity",wqtCity);
	 }
	 
	 /*修改地市*/
	 public void updateWqtCity(WqtCity wqtCity)
	 {
		this.getSession().update("wqtcommon.updateWqtCity",wqtCity);
	 }
	
	 /*删除地市*/
	 public void delWqtCity(WqtCity wqtCity)
	 {
		this.getSession().delete("wqtcommon.delWqtCity",wqtCity);
	 }
	
	 /*查询地市*/
    public List<WqtCity> selectWqtCityList(WqtCity wqtCity)
    {
	     List<WqtCity> list = this.getSession().selectList("wqtcommon.selectWqtCityList",wqtCity);
		 return list;
    }
}
