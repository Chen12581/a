package com.wqt.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wqt.common.service.WqtBankService;
import com.wqt.common.service.WqtCommonSevice;
import com.wqt.worker.service.WorkerService;



public class ParameterInitManager implements ServletContextListener {
	
	 private ApplicationContext app;
		
	 /**  
	  * 无延迟  
	  */  
	 public static final long NO_DELAY = 0;   
	 /**  
	  * 定时器  
	  */  
	 private Timer timer;   

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		 timer.cancel(); // 定时器销毁   
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		  //定义定时器   
	      timer = new Timer("参数定时初始化",true);
		  //启动任,每10分钟执行一次.
	      ParameterInitTask  parameterInitTask= new ParameterInitTask();
		  app = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()); //获取spring上下文！
		 
		  WorkerService workerService=(WorkerService)app.getBean("workerService"); 
		  WqtCommonSevice wqtCommonSevice=(WqtCommonSevice)app.getBean("wqtCommonSevice");
		  WqtBankService wqtBankService=(WqtBankService)app.getBean("wqtBankService");
		  
		  parameterInitTask.setWorkerService(workerService);
		  parameterInitTask.setWqtBankService(wqtBankService);
		  parameterInitTask.setWqtBankService(wqtBankService);
		  timer.schedule(parameterInitTask,NO_DELAY, 60*60*1000);  
	}

}
