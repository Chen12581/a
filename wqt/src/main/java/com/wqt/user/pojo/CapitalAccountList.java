package com.wqt.user.pojo;

import java.util.List;

/*用户资金明细列表页对象*/
public class CapitalAccountList {
	private List<WqtCapitalAccount> l_WqtCapitalAccount;
	private String pagenum;          //当前页数
	private String accountcount="0";    //总记录
	private String accountpage="0";     //总页数
	public List<WqtCapitalAccount> getL_WqtCapitalAccount() {
		return l_WqtCapitalAccount;
	}
	public void setL_WqtCapitalAccount(List<WqtCapitalAccount> l_WqtCapitalAccount) {
		this.l_WqtCapitalAccount = l_WqtCapitalAccount;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getAccountcount() {
		return accountcount;
	}
	public void setAccountcount(String accountcount) {
		this.accountcount = accountcount;
	}
	public String getAccountpage() {
		return accountpage;
	}
	public void setAccountpage(String accountpage) {
		this.accountpage = accountpage;
	}
	
    
}
