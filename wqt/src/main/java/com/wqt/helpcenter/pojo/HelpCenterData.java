package com.wqt.helpcenter.pojo;

import java.util.List;

import com.problem.pojo.Problem;
import com.problem.pojo.ProblemKind;
import com.worker.pojo.Worker;

/*用户中心数据对象*/
public class HelpCenterData {
    private List<ProblemKind> l_WqtProblemKind;
    private List<Problem> l_WqtProblem;
    
    private Worker iprworker;   //知识产权客服
    private Worker esworker;     //企业服务客服
    private Worker serviceworker;   //售后客服
    private Worker partnerworker;   //合作客服
    private Worker scheduleworker;   //审核客服
   
    
	public Worker getIprworker() {
		return iprworker;
	}
	public void setIprworker(Worker iprworker) {
		this.iprworker = iprworker;
	}
	public Worker getEsworker() {
		return esworker;
	}
	public void setEsworker(Worker esworker) {
		this.esworker = esworker;
	}
	
	public Worker getServiceworker() {
		return serviceworker;
	}
	public void setServiceworker(Worker serviceworker) {
		this.serviceworker = serviceworker;
	}
	public Worker getPartnerworker() {
		return partnerworker;
	}
	public void setPartnerworker(Worker partnerworker) {
		this.partnerworker = partnerworker;
	}
	public Worker getScheduleworker() {
		return scheduleworker;
	}
	public void setScheduleworker(Worker scheduleworker) {
		this.scheduleworker = scheduleworker;
	}
	public List<ProblemKind> getL_WqtProblemKind() {
		return l_WqtProblemKind;
	}
	public void setL_WqtProblemKind(List<ProblemKind> l_WqtProblemKind) {
		this.l_WqtProblemKind = l_WqtProblemKind;
	}
	public List<Problem> getL_WqtProblem() {
		return l_WqtProblem;
	}
	public void setL_WqtProblem(List<Problem> l_WqtProblem) {
		this.l_WqtProblem = l_WqtProblem;
	}
      
      
}
