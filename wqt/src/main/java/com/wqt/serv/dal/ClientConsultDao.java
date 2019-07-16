package com.wqt.serv.dal;

import java.util.List;

import com.consult.pojo.ClientConsult;
import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;

public class ClientConsultDao extends SessionDaoSupport{
	 /*保存网站咨询*/
	 public void insertClientConsult(ClientConsult clientConsult)
	 {
		this.getSession().insert("wqtservice.insertWqtNetConsult",clientConsult);
	 }
	 
	 /*修改网站咨询*/
	 public void updateClientConsult(ClientConsult clientConsult)
	 {
		this.getSession().update("wqtservice.updateWqtNetConsult",clientConsult);
	 }
	
	 /*删除网站咨询*/
	 public void delClientConsult(ClientConsult clientConsult)
	 {
		this.getSession().delete("wqtservice.delWqtNetConsult",clientConsult);
	 }
	
	 /*查询网站咨询*/
   public List<ClientConsult> selectClientConsultList(ClientConsult clientConsult)
   {
	     List<ClientConsult> list = this.getSession().selectList("wqtservice.selectWqtNetConsultList",clientConsult);
		 return list;
   }
   
   /*分页查询信息*/
	public Pagination  selectClientConsultPage(ClientConsult clientConsult,Pagination pagination){
		@SuppressWarnings("unchecked")
		List<ClientConsult> list =this.getSession().selectList("wqtservice.selectWqtNetConsultList", clientConsult, pagination);
		pagination.setList(list);
		return pagination;
	}
}
