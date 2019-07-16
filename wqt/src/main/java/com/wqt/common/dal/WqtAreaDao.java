package com.wqt.common.dal;

import java.util.List;
import com.wqt.common.pojo.WqtArea;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.wqt.common.pojo.WqtArea;

public class WqtAreaDao extends SessionDaoSupport{
	 /*保存区县*/
	 public void insertWqtArea(WqtArea wqtArea)
	 {
		this.getSession().insert("wqtcommon.insertWqtArea",wqtArea);
	 }
	 
	 /*修改区县*/
	 public void updateWqtArea(WqtArea wqtArea)
	 {
		this.getSession().update("wqtcommon.updateWqtArea",wqtArea);
	 }
	
	 /*删除区县*/
	 public void delWqtArea(WqtArea wqtArea)
	 {
		this.getSession().delete("wqtcommon.delWqtArea",wqtArea);
	 }
	
	 /*查询区县*/
     public List<WqtArea> selectWqtAreaList(WqtArea wqtArea)
     {
	     List<WqtArea> list = this.getSession().selectList("wqtcommon.selectWqtAreaList",wqtArea);
		 return list;
     }
}
