package com.wqt.ipr.brand.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.wqt.common.util.CommonUtil;
import com.wqt.ipr.brand.dal.BrandShopDao;
import com.wqt.ipr.brand.pojo.IprBrandShop;

import com.wqt.ipr.brand.service.BrandShopService;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class BrandShopServiceImpl implements BrandShopService {
	
	@Autowired
	private  BrandShopDao brandShopDao;
	
	
	@Override
	public void updateIprBrandShop(IprBrandShop iprBrandShop) {
		brandShopDao.updateIprBrandShop(iprBrandShop);
	}

	

	@Override
	public List<IprBrandShop> selectIprBrandShopList(IprBrandShop IprBrandShop) {
		return brandShopDao.selectIprBrandShopList(IprBrandShop);
	}

	@Override
	public Pagination selectIprBrandShopPage(IprBrandShop IprBrandShop,
			Pagination pagination) {
		return brandShopDao.selectIprBrandShopPage(IprBrandShop, pagination);
	}

	

	@Override
	public IprBrandShop selectBrandShopOne(IprBrandShop brandShop) {
		// TODO Auto-generated method stub
		return brandShopDao.selectBrandShopOne(brandShop);
	}
}
