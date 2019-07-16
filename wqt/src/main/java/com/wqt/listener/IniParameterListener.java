package com.wqt.listener;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hessian.HessionFactory;
import com.outurl.pojo.OutUrl;
import com.talkweb.twdpe.core.cache.CacheManager;
import com.wqt.common.pojo.WqtArea;
import com.wqt.common.pojo.WqtBank;
import com.wqt.common.pojo.WqtCity;
import com.wqt.common.pojo.WqtProvince;
import com.wqt.common.service.WqtBankService;
import com.wqt.common.service.WqtCommonSevice;
import com.wqt.common.util.CommonUtil;
import com.wqt.common.util.PropertiesUtil;
import com.worker.pojo.Worker;
import com.wqt.worker.service.WorkerService;

/*读取公共配置文件*/
public class IniParameterListener implements ServletContextListener {
	
	

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		 PropertiesUtil.rs = new Properties();
		 try{
			    String path = (getClass().getClassLoader().getResource("").toURI()).getPath();
			    FileInputStream fis = new FileInputStream(path + "/config/rs.properties");
				PropertiesUtil.rs.load(fis);
			}catch (Exception e) {
				e.printStackTrace();
			}
		 
		 
		    ServletContext sc = event.getServletContext();
		    WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		    
		    CacheManager _cache = CacheManager.getInstance();
	        WorkerService workerService = 
		        (WorkerService)ac.getBean("workerService");
	        Worker wqtWorker=new Worker();
	        wqtWorker.setState("1");
	        wqtWorker.setIsshow("1");
	        List<Worker> l_worker=workerService.selWqtWorkerList(wqtWorker);
	        String workercacheKey = CommonUtil.WORKERS_CACHE+".key";
	        if (_cache.getObject(CommonUtil.WORKERS_CACHE, workercacheKey)!= null)  //缓存中无数据
			{
	        	_cache.removeObject(CommonUtil.WORKERS_CACHE, workercacheKey);
			}
	        _cache.setObject(CommonUtil.WORKERS_CACHE, workercacheKey, l_worker);
	        
	        
	         WqtCommonSevice wqtCommonSevice=(WqtCommonSevice)ac.getBean("wqtCommonSevice");
	         List<WqtProvince> l_WqtProvince=wqtCommonSevice.selectWqtProvinceList(new WqtProvince());
		     String provincecacheKey = CommonUtil.PROVINCE_CACHE+".key";
		     if (_cache.getObject(CommonUtil.PROVINCE_CACHE, provincecacheKey)!= null)  //缓存中无数据
			 {
		     	 _cache.removeObject(CommonUtil.PROVINCE_CACHE, provincecacheKey);
			 }
		     _cache.setObject(CommonUtil.PROVINCE_CACHE, provincecacheKey, l_WqtProvince);
		     
		     
		     List<WqtCity> l_WqtCity=wqtCommonSevice.selectWqtCityList(new WqtCity());
		     String citycacheKey = CommonUtil.CITY_CACHE+".key";
		     if (_cache.getObject(CommonUtil.CITY_CACHE, citycacheKey)!= null)  //缓存中无数据
			 {
		     	 _cache.removeObject(CommonUtil.CITY_CACHE, citycacheKey);
			 }
		     _cache.setObject(CommonUtil.CITY_CACHE, citycacheKey, l_WqtCity);
		     
		     
		     List<WqtArea> l_WqtArea=wqtCommonSevice.selectWqtAreaList(new WqtArea());
		     String areacacheKey = CommonUtil.AREA_CACHE+".key";
		     if (_cache.getObject(CommonUtil.AREA_CACHE, areacacheKey)!= null)  //缓存中无数据
			 {
		     	 _cache.removeObject(CommonUtil.AREA_CACHE, areacacheKey);
			 }
		     _cache.setObject(CommonUtil.AREA_CACHE, areacacheKey, l_WqtArea);
		     
       
	        WqtBankService wqtBankService = 
			        (WqtBankService)ac.getBean("wqtBankService");
	        List<WqtBank> l_WqtBank=wqtBankService.selectListWqtBank();
	        String bankcacheKey = CommonUtil.BANKS_CACHE+".key";
	        if (_cache.getObject(CommonUtil.BANKS_CACHE, bankcacheKey)!= null)  //缓存中无数据
			{
	        	_cache.removeObject(CommonUtil.BANKS_CACHE, bankcacheKey);
			}
	        _cache.setObject(CommonUtil.BANKS_CACHE, bankcacheKey, l_WqtBank);
	        
	        OutUrl outUrl=new OutUrl();
	        outUrl.setPlateformcode("wqt");
	        List<OutUrl> l_outUrl=HessionFactory.outurlHession().selectCasesList(outUrl);
	        String outurlcacheKey = CommonUtil.OUTURL_CACHE+".key";
	        if (_cache.getObject(CommonUtil.OUTURL_CACHE, outurlcacheKey)!= null)  //缓存中无数据
			{
	        	_cache.removeObject(CommonUtil.OUTURL_CACHE, outurlcacheKey);
			}
	        _cache.setObject(CommonUtil.OUTURL_CACHE, outurlcacheKey, l_outUrl);
	}

}
