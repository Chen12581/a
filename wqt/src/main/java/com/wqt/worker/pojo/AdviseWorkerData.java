package com.wqt.worker.pojo;

import java.util.List;

import com.worker.pojo.Worker;


public class AdviseWorkerData {
	   
	private List<Worker> list_adviseWorker;  //业务员列表页
	private String pagenum;          //当前页数
	private String workercount="0";    //总记录
	private String workerpage="0";     //总页数
	private String workerkind;
	
	
	public List<Worker> getList_adviseWorker() {
		return list_adviseWorker;
	}
	public void setList_adviseWorker(List<Worker> list_adviseWorker) {
		this.list_adviseWorker = list_adviseWorker;
	}
	public String getWorkerkind() {
		return workerkind;
	}
	public void setWorkerkind(String workerkind) {
		this.workerkind = workerkind;
	}
	
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getWorkercount() {
		return workercount;
	}
	public void setWorkercount(String workercount) {
		this.workercount = workercount;
	}
	public String getWorkerpage() {
		return workerpage;
	}
	public void setWorkerpage(String workerpage) {
		this.workerpage = workerpage;
	}
	   
	   
}
