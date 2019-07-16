package com.wqt.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.wqt.common.pojo.WqtArea;
import com.wqt.common.pojo.WqtCity;
import com.wqt.common.pojo.WqtProvince;
import com.wqt.common.dal.WqtAreaDao;
import com.wqt.common.dal.WqtCityDao;
import com.wqt.common.dal.WqtProvinceDao;
import com.wqt.common.pojo.WqtArea;
import com.wqt.common.pojo.WqtCity;
import com.wqt.common.pojo.WqtProvince;
import com.wqt.common.service.WqtCommonSevice;


public class WqtCommonSeviceImpl implements WqtCommonSevice {
	  

   @Autowired
   WqtAreaDao wqtAreaDao;
   
   @Autowired
   WqtCityDao wqtCityDao;
   
   @Autowired
   WqtProvinceDao wqtProvinceDao;

	@Override
	public void insertWqtArea(WqtArea wqtArea) {
		wqtAreaDao.insertWqtArea(wqtArea);
	}

	@Override
	public void updateWqtArea(WqtArea wqtArea) {
		wqtAreaDao.updateWqtArea(wqtArea);
	}

	@Override
	public void delWqtArea(WqtArea wqtArea) {
		wqtAreaDao.delWqtArea(wqtArea);
	}

	@Override
	public List<WqtArea> selectWqtAreaList(WqtArea wqtArea) {
		return wqtAreaDao.selectWqtAreaList(wqtArea);
	}

	@Override
	public void insertWqtCity(WqtCity wqtCity) {
		wqtCityDao.insertWqtCity(wqtCity);
	}

	@Override
	public void updateWqtCity(WqtCity wqtCity) {
		wqtCityDao.updateWqtCity(wqtCity);
	}

	@Override
	public void delWqtCity(WqtCity wqtCity) {
		wqtCityDao.delWqtCity(wqtCity);
	}

	@Override
	public List<WqtCity> selectWqtCityList(WqtCity wqtCity) {
		return wqtCityDao.selectWqtCityList(wqtCity);
	}

	@Override
	public void insertWqtProvince(WqtProvince wqtProvince) {
		wqtProvinceDao.insertWqtProvince(wqtProvince);
	}

	@Override
	public void updateWqtProvince(WqtProvince wqtProvince) {
		wqtProvinceDao.updateWqtProvince(wqtProvince);
	}

	@Override
	public void delWqtProvince(WqtProvince wqtProvince) {
		wqtProvinceDao.delWqtProvince(wqtProvince);
	}

	@Override
	public List<WqtProvince> selectWqtProvinceList(WqtProvince wqtProvince) {
		return wqtProvinceDao.selectWqtProvinceList(wqtProvince);
	}
}
