package com.wqt.index.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.hessian.HessionFactory;
import com.news.pojo.News;
import com.problem.pojo.Problem;
import com.talkweb.twdpe.core.cache.CacheManager;
import com.talkweb.twdpe.core.log.Logger;
import com.talkweb.twdpe.core.log.LoggerFactory;
import com.talkweb.twdpe.dal.jdbc.info.Pagination;
import com.talkweb.twdpe.web.session.main.Session;
import com.talkweb.twdpe.web.session.util.SessionFactory;
import com.talkweb.twdpe.webcomponent.common.action.BusinessAction;
import com.worker.pojo.Worker;
import com.wqt.cases.pojo.WqtCases;
import com.wqt.cases.service.WqtCasesService;
import com.wqt.common.util.CommonUtil;
import com.wqt.es.trade.pojo.EsTradeCompanyShop;
import com.wqt.es.trade.service.EsTradeCompanyShopService;
import com.wqt.index.pojo.IndexData;
import com.wqt.ipr.brand.pojo.IprBrandShop;
import com.wqt.ipr.brand.service.BrandShopService;
import com.wqt.ipr.copyright.pojo.IprCopyrightShop;
import com.wqt.ipr.copyright.service.CopyrightShopService;
import com.wqt.ipr.patent.pojo.IprPatentShop;
import com.wqt.ipr.patent.service.PatentShopService;
import com.wqt.news.service.NewsService;

public class WqtAction  extends BusinessAction{
	    private static final Logger logger = LoggerFactory.getLogger(WqtAction.class);
	   
	  
	    
	    @Autowired
	    private BrandShopService brandShopService;
	    
	    @Autowired
	    private CopyrightShopService copyrightShopService;
	    
	    @Autowired
	    private PatentShopService patentShopService;
	    
	    @Autowired
	    private EsTradeCompanyShopService esTradeCompanyShopService;
	   
	    @Autowired
	    private NewsService newsService;
	    
	    @Autowired
	    private WqtCasesService wqtCasesService;
	    
	   /* @Autowired
	    private WqtProblemService wqtProblemService;*/
	    
	    private IndexData indexData;
	      

		public IndexData getIndexData() {
			return indexData;
		}

		public void setIndexData(IndexData indexData) {
			this.indexData = indexData;
		}
	    
	
		
		/*网站地图*/
		public String siteMap()
		{
			 HttpServletRequest  request = ServletActionContext.getRequest();
			 HttpServletResponse response = ServletActionContext.getResponse();
		    
		     return SUCCESS;
		}

		/*首页*/
	    public String index()
		{
	    	 HttpServletRequest  request = ServletActionContext.getRequest();
			 HttpServletResponse response = ServletActionContext.getResponse();
			 Session session = SessionFactory.getInstance(request, response);
			 Object sessionUser = session.getAttribute("LOGINSESSIOIN");
			 
			 long time1=System.currentTimeMillis();
			 
			 if(indexData==null)
			 {
				 indexData=new IndexData();
			 }
			 
			
			CacheManager _workercache = CacheManager.getInstance();
		    String  workercacheKey = CommonUtil.WORKERS_CACHE+".key";
		    List<Worker> l_WqtWorker = (List<Worker>)_workercache.getObject(CommonUtil.WORKERS_CACHE, workercacheKey);
		    List<Worker> l_Worker=CommonUtil.createRandomList(l_WqtWorker,6);
		    if(l_Worker!=null)
		    {
		    	indexData.setL_Worker(l_Worker);
		    }
		     
		    List<Worker> l_iprWorker=CommonUtil.findListFromList(l_WqtWorker,"workerkind","ipr");
		    if(l_iprWorker!=null)
		    {
		    	indexData.setL_iprWorker(l_iprWorker);
		    }
		    
		    List<Worker> l_esWorker=CommonUtil.findListFromList(l_WqtWorker,"workerkind","es");
		    if(l_esWorker!=null)
		    {
		    	indexData.setL_esWorker(l_esWorker);
		    }
		    long time2=System.currentTimeMillis()-time1;
		    logger.error("万企通首页耗时2-----"+time2); 
			 /*商标类*/
			 Pagination bpagination=new Pagination(1,6);
			 IprBrandShop iprBrandShop=new IprBrandShop();
			 iprBrandShop.setState("2");
			 Pagination page=brandShopService.selectIprBrandShopPage(iprBrandShop, bpagination);
			 if(page.getList()!=null && page.getList().size()>0)
			 {
				 indexData.setL_brandShop(page.getList());
			 }
			 
			 Pagination cpagination=new Pagination(1,6);
			 IprCopyrightShop iprCopyrightShop=new IprCopyrightShop();
			 iprCopyrightShop.setState("2");
			 Pagination cpage=copyrightShopService.selectCopyrightShopPage(iprCopyrightShop, cpagination);
			 if(cpage.getList()!=null && cpage.getList().size()>0)
			 {
				 indexData.setL_copyrightShop(cpage.getList());
			 }
			 
			 Pagination ppagination=new Pagination(1,6);
			 IprPatentShop iprPatentShop=new IprPatentShop();
			 iprPatentShop.setState("2");
			 Pagination ppage=patentShopService.selectPatentShopPage(iprPatentShop, ppagination);
			 if(ppage.getList()!=null && ppage.getList().size()>0)
			 {
				 indexData.setL_patentShop(ppage.getList());
			 }
			 
			 Pagination epagination=new Pagination(1,6);
			 EsTradeCompanyShop esTradeCompanyShop=new EsTradeCompanyShop();
			 esTradeCompanyShop.setState("2");
			 Pagination tpage=esTradeCompanyShopService.selectEsTradeCompanyShopPage(esTradeCompanyShop, epagination);
			 if(tpage.getList()!=null && tpage.getList().size()>0)
			 {
				 indexData.setL_tradeShop(tpage.getList());
			 }
             
			 long time3=System.currentTimeMillis()-time1;
			 logger.error("万企通首页耗时3-----"+time3); 
			    
			 /*新闻类*/
			 Pagination newpagination=new Pagination(1,9);
			 News wqtNews=new News();
			 wqtNews.setState("2");
			 wqtNews.setPlateformcode("wqt");
			 Pagination npage=newsService.selectWqtNewsPage(wqtNews, newpagination);
			 if(npage.getList()!=null && npage.getList().size()>0)
			 {
				 indexData.setL_News(npage.getList());
			 }
			 
			 Pagination casepagination=new Pagination(1,9);
			 WqtCases wqtCases=new WqtCases();
			 wqtCases.setState("2");
			 Pagination casepage=wqtCasesService.selectWqtCasesPage(wqtCases, casepagination);
			 if(casepage.getList()!=null && casepage.getList().size()>0)
			 {
				 indexData.setL_WqtCases(casepage.getList());
			 }
			 
			 long time4=System.currentTimeMillis()-time1;
			 logger.error("万企通首页耗时4-----"+time4); 
			    
			 Pagination problempagination=new Pagination(1,6);
			 Pagination probpage=HessionFactory.problemHession().selectProblemPage(new Problem(), problempagination);
			// Pagination probpage=wqtProblemService.selectWqtProblemPage(new Problem(), problempagination);
			 if(probpage.getList()!=null && probpage.getList().size()>0)
			 {
				 indexData.setL_WqtProblem(probpage.getList());
			 }
			 
			 long time5=System.currentTimeMillis()-time1;
			 logger.error("万企通首页耗时5-----"+time5); 
			    
			 return SUCCESS;
		}
}
