package com.wqt.index.pojo;

import java.util.List;

import com.news.pojo.News;
import com.problem.pojo.Problem;
import com.worker.pojo.Worker;
import com.wqt.cases.pojo.WqtCases;
import com.wqt.es.trade.pojo.EsTradeCompanyShop;
import com.wqt.ipr.brand.pojo.IprBrandShop;
import com.wqt.ipr.copyright.pojo.IprCopyrightShop;
import com.wqt.ipr.patent.pojo.IprPatentShop;


/*首页数据体*/
public class IndexData {
	//商标
    private List<IprBrandShop> l_brandShop;    
    //版权
    private List<IprCopyrightShop> l_copyrightShop;
    //专利
    private List<IprPatentShop> l_patentShop;
    //企业
    private List<EsTradeCompanyShop> l_tradeShop;
    //业务员
    private List<Worker> l_Worker;
    
    //知识产权业务员
    private List<Worker> l_iprWorker;
    
    //企业服务业务员
    private List<Worker> l_esWorker;

    //新闻
    private List<News> l_News;
    
    //专业问答
    private List<Problem> l_WqtProblem;
    
    //成功案例
    private List<WqtCases> l_WqtCases;
    

    
	public List<Worker> getL_iprWorker() {
		return l_iprWorker;
	}

	public void setL_iprWorker(List<Worker> l_iprWorker) {
		this.l_iprWorker = l_iprWorker;
	}

	public List<Worker> getL_esWorker() {
		return l_esWorker;
	}

	public void setL_esWorker(List<Worker> l_esWorker) {
		this.l_esWorker = l_esWorker;
	}

	public List<Problem> getL_WqtProblem() {
		return l_WqtProblem;
	}

	public void setL_WqtProblem(List<Problem> l_WqtProblem) {
		this.l_WqtProblem = l_WqtProblem;
	}

	public List<WqtCases> getL_WqtCases() {
		return l_WqtCases;
	}

	public void setL_WqtCases(List<WqtCases> l_WqtCases) {
		this.l_WqtCases = l_WqtCases;
	}

	public List<Worker> getL_Worker() {
		return l_Worker;
	}

	public void setL_Worker(List<Worker> l_Worker) {
		this.l_Worker = l_Worker;
	}

	public List<IprBrandShop> getL_brandShop() {
		return l_brandShop;
	}

	public void setL_brandShop(List<IprBrandShop> l_brandShop) {
		this.l_brandShop = l_brandShop;
	}

	public List<IprCopyrightShop> getL_copyrightShop() {
		return l_copyrightShop;
	}

	public void setL_copyrightShop(List<IprCopyrightShop> l_copyrightShop) {
		this.l_copyrightShop = l_copyrightShop;
	}

	public List<IprPatentShop> getL_patentShop() {
		return l_patentShop;
	}

	public void setL_patentShop(List<IprPatentShop> l_patentShop) {
		this.l_patentShop = l_patentShop;
	}

	public List<EsTradeCompanyShop> getL_tradeShop() {
		return l_tradeShop;
	}

	public void setL_tradeShop(List<EsTradeCompanyShop> l_tradeShop) {
		this.l_tradeShop = l_tradeShop;
	}

	public List<News> getL_News() {
		return l_News;
	}

	public void setL_News(List<News> l_News) {
		this.l_News = l_News;
	}

	
}
