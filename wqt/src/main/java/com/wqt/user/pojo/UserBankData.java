package com.wqt.user.pojo;

import java.util.List;

/*用户绑定银行卡页数据对象*/
public class UserBankData {
    private List<WqtUserBank> l_WqtUserBank;
    private String pagenum;          //当前页数
    private String bankcount="0";    //总记录
  	private String bankpage="0";     //总页数
  	  
  	
	public List<WqtUserBank> getL_WqtUserBank() {
		return l_WqtUserBank;
	}
	public void setL_WqtUserBank(List<WqtUserBank> l_WqtUserBank) {
		this.l_WqtUserBank = l_WqtUserBank;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	public String getBankcount() {
		return bankcount;
	}
	public void setBankcount(String bankcount) {
		this.bankcount = bankcount;
	}
	public String getBankpage() {
		return bankpage;
	}
	public void setBankpage(String bankpage) {
		this.bankpage = bankpage;
	}
  	  
  	  
}
