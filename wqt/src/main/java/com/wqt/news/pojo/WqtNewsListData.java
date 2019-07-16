package com.wqt.news.pojo;

import java.util.List;

import com.news.pojo.News;
import com.notice.pojo.Notice;
import com.wqt.cases.pojo.WqtCases;
import com.wqt.ipr.brand.pojo.IprBrandShop;

/*万企通新闻列表页数据*/
public class WqtNewsListData {
	private String kindid;    //当前新闻类别
    private List<News> l_News;   //热门资讯
    private List<Notice> l_Notice;    //网站公告
    private int labelid;           //标签ID；
    private List<WqtCases> l_cases;     //成功案列
    private List<IprBrandShop> l_IprBrandShop;     //商标
    private int newspage;   //新闻总页数
    private int noticepage;     //公告总页数
    private int casepage;   //案例总页数
    private int pagenum;    //当前页
    private List<News> l_hotNews;   //热门资讯
    
    
	public List<News> getL_hotNews() {
		return l_hotNews;
	}
	public void setL_hotNews(List<News> l_hotNews) {
		this.l_hotNews = l_hotNews;
	}
	public int getLabelid() {
		return labelid;
	}
	public void setLabelid(int labelid) {
		this.labelid = labelid;
	}
	public List<IprBrandShop> getL_IprBrandShop() {
		return l_IprBrandShop;
	}
	public void setL_IprBrandShop(List<IprBrandShop> l_IprBrandShop) {
		this.l_IprBrandShop = l_IprBrandShop;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	
	public String getKindid() {
		return kindid;
	}
	public void setKindid(String kindid) {
		this.kindid = kindid;
	}
	public int getNewspage() {
		return newspage;
	}
	public void setNewspage(int newspage) {
		this.newspage = newspage;
	}
	public int getNoticepage() {
		return noticepage;
	}
	public void setNoticepage(int noticepage) {
		this.noticepage = noticepage;
	}
	public int getCasepage() {
		return casepage;
	}
	public void setCasepage(int casepage) {
		this.casepage = casepage;
	}
	public List<News> getL_News() {
		return l_News;
	}
	public void setL_News(List<News> l_News) {
		this.l_News = l_News;
	}
	public List<Notice> getL_Notice() {
		return l_Notice;
	}
	public void setL_Notice(List<Notice> l_Notice) {
		this.l_Notice = l_Notice;
	}
	public List<WqtCases> getL_cases() {
		return l_cases;
	}
	public void setL_cases(List<WqtCases> l_cases) {
		this.l_cases = l_cases;
	}     
}
