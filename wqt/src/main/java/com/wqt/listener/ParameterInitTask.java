package com.wqt.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

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
import com.worker.pojo.Worker;
import com.wqt.worker.service.WorkerService;

public class ParameterInitTask extends TimerTask{
	
	private WorkerService workerService;
	
	private WqtBankService wqtBankService;
	
	private WqtCommonSevice wqtCommonSevice;
	
	

	public WqtCommonSevice getWqtCommonSevice() {
		return wqtCommonSevice;
	}

	public void setWqtCommonSevice(WqtCommonSevice wqtCommonSevice) {
		this.wqtCommonSevice = wqtCommonSevice;
	}

	public WqtBankService getWqtBankService() {
		return wqtBankService;
	}

	public void setWqtBankService(WqtBankService wqtBankService) {
		this.wqtBankService = wqtBankService;
	}

	public WorkerService getWorkerService() {
		return workerService;
	}

	public void setWorkerService(WorkerService workerService) {
		this.workerService = workerService;
	}
    

	@Override
	public void run() {
		while(true)
		{
			   SimpleDateFormat df = new SimpleDateFormat("HH");//设置日期格式
			   String now=df.format(new Date());// new Date()为获取当前系统时间
			   if("00".equals(now))
			   {
				    CacheManager _cache = CacheManager.getInstance();
				    System.out.println("参数初始化定时任务开始");
				    
			        
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

			        try {
						Thread.sleep(60*60*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        System.out.println("参数初始化定时任务结束");
			   }
			   else
			   {
				   try {
						Thread.sleep(60*60*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   }
		}
		
	}
	
	
	public static void  main(String[] args)
	{
		 SimpleDateFormat df = new SimpleDateFormat("HH");//设置日期格式
		  String now=df.format(new Date());// new Date()为获取当前系统时间
		  System.out.println("参数初始化定时任务结束"+now);
	}
}
