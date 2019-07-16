package com.sms.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.sms.pojo.Sms;

public class SmsDao extends SessionDaoSupport {
	 /*保存发送的短信*/
	 public void insertSms(Sms sms)
	 {
		this.getSession().insert("wqtsms.insertWqtSms",sms);
	 }
	
	 /*删除短信*/
	 public void delSms(Sms sms)
	 {
		this.getSession().delete("wqtsms.delWqtSms",sms);
	 }
	
	 /*查询发送的短信*/
    public List<Sms> selectSmsList(Sms sms)
    {
	     List<Sms> list = this.getSession().selectList("wqtsms.selectWqtSmsList",sms);
		 return list;
    }
}
