package com.wqt.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wqt.common.dal.WqtBankDao;
import com.wqt.common.pojo.WqtBank;
import com.wqt.common.service.WqtBankService;


public class WqtBankServiceImpl implements WqtBankService {
   
	@Autowired
	private WqtBankDao wqtBankDao;
	
	@Override
	public List<WqtBank> selectListWqtBank() {
		return wqtBankDao.selectListWqtBank();
	}

}
