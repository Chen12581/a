package com.wqt.user.pojo;

import java.util.List;

/*用户收藏页面数据对象*/
public class UserCollectData {
	private List<UserCollect> l_UserCollect;
    private String pagenum;          //当前页数
    private String collectcount="0";    //总记录
  	private String collectpage="0";     //总页数
  	
	public List<UserCollect> getL_UserCollect() {
		return l_UserCollect;
	}
	public void setL_UserCollect(List<UserCollect> l_UserCollect) {
		this.l_UserCollect = l_UserCollect;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getCollectcount() {
		return collectcount;
	}
	public void setCollectcount(String collectcount) {
		this.collectcount = collectcount;
	}
	public String getCollectpage() {
		return collectpage;
	}
	public void setCollectpage(String collectpage) {
		this.collectpage = collectpage;
	}
}
