package com.wqt.common.dal;

import java.util.List;
import com.wqt.common.pojo.WqtProvince;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.wqt.common.pojo.WqtProvince;

public class WqtProvinceDao extends SessionDaoSupport{
	 /*保存省份*/
	 public void insertWqtProvince(WqtProvince wqtProvince)
	 {
		this.getSession().insert("wqtcommon.insertWqtProvince",wqtProvince);
	 }
	 
	 /*修改省份*/
	 public void updateWqtProvince(WqtProvince wqtProvince)
	 {
		this.getSession().update("wqtcommon.updateWqtProvince",wqtProvince);
	 }
	
	 /*删除省份*/
	 public void delWqtProvince(WqtProvince wqtProvince)
	 {
		this.getSession().delete("wqtcommon.delWqtProvince",wqtProvince);
	 }
	
	 /*查询省份*/
    public List<WqtProvince> selectWqtProvinceList(WqtProvince wqtProvince)
    {
	     List<WqtProvince> list = this.getSession().selectList("wqtcommon.selectWqtProvinceList",wqtProvince);
		 return list;
    }
}
