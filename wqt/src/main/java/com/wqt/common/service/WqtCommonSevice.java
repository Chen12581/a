package com.wqt.common.service;

import java.util.List;

import com.wqt.common.pojo.WqtArea;
import com.wqt.common.pojo.WqtCity;
import com.wqt.common.pojo.WqtProvince;

/*小型业务数据处理接口*/
public interface WqtCommonSevice {

     /*保存区县*/
	 public void insertWqtArea(WqtArea wqtArea);
	 
	 /*修改区县*/
	 public void updateWqtArea(WqtArea wqtArea);
	
	 /*删除区县*/
	 public void delWqtArea(WqtArea wqtArea);
	
	 /*查询区县*/
     public List<WqtArea> selectWqtAreaList(WqtArea wqtArea);
     
     /*保存地市*/
	 public void insertWqtCity(WqtCity wqtCity);
	 
	 /*修改地市*/
	 public void updateWqtCity(WqtCity wqtCity);
	
	 /*删除地市*/
	 public void delWqtCity(WqtCity wqtCity);
	
	 /*查询地市*/
     public List<WqtCity> selectWqtCityList(WqtCity wqtCity);
     
     /*保存省份*/
	 public void insertWqtProvince(WqtProvince wqtProvince);
	 
	 /*修改省份*/
	 public void updateWqtProvince(WqtProvince wqtProvince);
	
	 /*删除省份*/
	 public void delWqtProvince(WqtProvince wqtProvince);
	
	 /*查询省份*/
     public List<WqtProvince> selectWqtProvinceList(WqtProvince wqtProvince);
 
}
