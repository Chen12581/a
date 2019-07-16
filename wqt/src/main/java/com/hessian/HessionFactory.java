package com.hessian;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.caucho.hessian.client.HessianProxyFactory;
import com.consult.pojo.ClientConsult;
import com.hessian.service.ClientConsultService;
import com.hessian.service.CollectService;
import com.hessian.service.NewsCommentService;
import com.hessian.service.NoticeService;
import com.hessian.service.OutUrlService;
import com.hessian.service.ProblemService;
import com.hessian.service.SmsService;
import com.hessian.service.WorkerService;
import com.wqt.common.util.PropertiesUtil;




public class HessionFactory {
	private static Logger log = LoggerFactory.getLogger(HessionFactory.class);
	private static HessianProxyFactory hessionfactory;
	private static ClientConsultService clientConsultService;
	private static CollectService collectService;
	private static SmsService smsService;
	private static NewsCommentService newsCommentService;
	private static WorkerService workerService;
	private static ProblemService problemService;
	private static NoticeService noticeService;
	private static OutUrlService outUrlService;
	
	public HessionFactory() {
		// TODO Auto-generated constructor stub
	}
    
	
	public static OutUrlService outurlHession(){
		String URL =PropertiesUtil.rs.getProperty("hessianurl")+"/remoting/outurl";
		hessionfactory =  new HessianProxyFactory();
		if(outUrlService == null){
			try {
				outUrlService= (OutUrlService)hessionfactory.create(OutUrlService.class, URL);
			} catch (MalformedURLException e) {
				log.error("create -> 创建outurlHession错误", e);
			}
		}
		return outUrlService;
	}
	
	
	public static NoticeService noticeHession(){
		String URL =PropertiesUtil.rs.getProperty("hessianurl")+"/remoting/notice";
		hessionfactory =  new HessianProxyFactory();
		if(noticeService == null){
			try {
				noticeService= (NoticeService)hessionfactory.create(NoticeService.class, URL);
			} catch (MalformedURLException e) {
				log.error("create -> 创建noticeHession错误", e);
			}
		}
		return noticeService;
	}
	
	
	public static ProblemService problemHession(){
		String URL =PropertiesUtil.rs.getProperty("hessianurl")+"/remoting/problem";
		hessionfactory =  new HessianProxyFactory();
		if(problemService == null){
			try {
				problemService= (ProblemService)hessionfactory.create(ProblemService.class, URL);
			} catch (MalformedURLException e) {
				log.error("create -> 创建problemHession错误", e);
			}
		}
		return problemService;
	}
	
	public static NewsCommentService newsCommentHession(){
		String URL =PropertiesUtil.rs.getProperty("hessianurl")+"/remoting/newsComment";
		hessionfactory =  new HessianProxyFactory();
		if(newsCommentService == null){
			try {
				newsCommentService= (NewsCommentService)hessionfactory.create(NewsCommentService.class, URL);
			} catch (MalformedURLException e) {
				log.error("create -> 创建newsCommentHession错误", e);
			}
		}
		return newsCommentService;
	}
	
	
	public static ClientConsultService netConsultHession(){
		String URL =PropertiesUtil.rs.getProperty("hessianurl")+"/remoting/clientConsult";
		hessionfactory =  new HessianProxyFactory();
		if(clientConsultService == null){
			try {
				clientConsultService= (ClientConsultService)hessionfactory.create(ClientConsultService.class, URL);
			} catch (MalformedURLException e) {
				log.error("create -> 创建ClientConsultHession错误", e);
			}
		}
		return clientConsultService;
	}
	
	
	public static CollectService collectHession(){
		String URL =PropertiesUtil.rs.getProperty("hessianurl")+"/remoting/collect";
		hessionfactory =  new HessianProxyFactory();
		if(collectService == null){
			try {
				collectService= (CollectService)hessionfactory.create(CollectService.class, URL);
			} catch (MalformedURLException e) {
				log.error("create -> 创建CollectHession错误", e);
			}
		}
		return collectService;
	}
	
	public static SmsService smsHession(){
		String URL =PropertiesUtil.rs.getProperty("hessianurl")+"/remoting/sms";
		hessionfactory =  new HessianProxyFactory();
		if(smsService == null){
			try {
				smsService= (SmsService)hessionfactory.create(SmsService.class, URL);
			} catch (MalformedURLException e) {
				log.error("create -> 创建SmsHession错误", e);
			}
		}
		return smsService;
	}
	
	
	public static WorkerService workerHession(){
		String URL =PropertiesUtil.rs.getProperty("hessianurl")+"/remoting/worker";
		hessionfactory =  new HessianProxyFactory();
		if(workerService == null){
			try {
				workerService= (WorkerService)hessionfactory.create(WorkerService.class, URL);
			} catch (MalformedURLException e) {
				log.error("create -> 创建workerHession错误", e);
			}
		}
		return workerService;
	}
	
	
	
	public static void main(String[] args)
	{
		//System.out.println("dddddddd");
		ClientConsult clientConsult=new ClientConsult();
		HessionFactory.netConsultHession().saveClientConsult(clientConsult);
	}
}
