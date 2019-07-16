package com.wqt.user.pojo;

import java.util.List;

/*我的建议列表页对象*/
public class SugguestList {
	private List<WqtUserSuggest> l_userSuggest;
	private String pagenum;          //当前页数
	private String suggestcount="0";    //总记录
	private String suggestpage="0";     //总页数
	
	
	public List<WqtUserSuggest> getL_userSuggest() {
		return l_userSuggest;
	}
	public void setL_userSuggest(List<WqtUserSuggest> l_userSuggest) {
		this.l_userSuggest = l_userSuggest;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getSuggestcount() {
		return suggestcount;
	}
	public void setSuggestcount(String suggestcount) {
		this.suggestcount = suggestcount;
	}
	public String getSuggestpage() {
		return suggestpage;
	}
	public void setSuggestpage(String suggestpage) {
		this.suggestpage = suggestpage;
	}
}
