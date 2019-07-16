package com.wqt.common.dal;

import java.util.List;

import com.talkweb.twdpe.dal.batis.spring.SessionDaoSupport;
import com.wqt.common.pojo.WqtBank;

/*万企通基础银行数据*/
public class WqtBankDao   extends SessionDaoSupport{
	
	public List<WqtBank> selectListWqtBank()
	{
		return getSession().selectList("wqtcommon.selectListWqtBank");
	}
}
