package com.wqt.cases.pojo;

import java.util.List;
import com.wqt.cases.pojo.WqtCases;


/*案例列表页对象*/
public class WqtCasesList {

    private List<WqtCases> l_WqtCases;  //
    private String pagenum;          //当前页数
    private String casescount;          //总记录
    private String casepage;           //总页数
    
	
	
	
	public List<WqtCases> getL_WqtCases() {
		return l_WqtCases;
	}
	public void setL_WqtCases(List<WqtCases> l_WqtCases) {
		this.l_WqtCases = l_WqtCases;
	}
	public String getCasescount() {
		return casescount;
	}
	public void setCasescount(String casescount) {
		this.casescount = casescount;
	}
	public String getCasepage() {
		return casepage;
	}
	public void setCasepage(String casepage) {
		this.casepage = casepage;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	 
}
