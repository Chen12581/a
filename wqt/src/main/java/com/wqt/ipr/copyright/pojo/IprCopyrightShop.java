package com.wqt.ipr.copyright.pojo;

/**
 * 现有版权
 *
 */
public class IprCopyrightShop {
	private String id;
	
	private String userid;//用户id
	
	private String copyrightname;//版权名称
	
	private String copyrightkind;//版权类型
	
	private String transfermethod;//转让方式
	
	private String competentmethod;//授权方式1：独家2：非独家
	
	private String competentarea;//授权地区1：中国大陆2：港澳台3：全球4：其它
	
	private String competentterm;//授权期限/表示无限
	
	private String competentrange;//授权范围(ipr_copyright_competentrange)
	
	private String transferinstruct;//转让说明
	
	private String price;//价格
	
	private String state;//状态
	
	private String pathkey;  //虚拟关键字
	
	private String htmlpath;//页面地址
	
	private String workerid;//业务员id
	
	private String developtime;//发布时间
	
	private String states;//状态
	
	private String copyrightkindname;//版权类别名称
	
	private String copyrightcode;
	
	private String kindname;
	
	private String displayname;
	
	private String updatename;
	
	
	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getUpdatename() {
		return updatename;
	}

	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}

	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}

	public String getCopyrightcode() {
		return copyrightcode;
	}

	public void setCopyrightcode(String copyrightcode) {
		this.copyrightcode = copyrightcode;
	}

	public String getCompetentmethod() {
		return competentmethod;
	}

	public void setCompetentmethod(String competentmethod) {
		this.competentmethod = competentmethod;
	}

	public String getCompetentarea() {
		return competentarea;
	}

	public void setCompetentarea(String competentarea) {
		this.competentarea = competentarea;
	}

	public String getCompetentterm() {
		return competentterm;
	}

	public void setCompetentterm(String competentterm) {
		this.competentterm = competentterm;
	}

	public String getCompetentrange() {
		return competentrange;
	}

	public void setCompetentrange(String competentrange) {
		this.competentrange = competentrange;
	}

	public String getPathkey() {
		return pathkey;
	}

	public void setPathkey(String pathkey) {
		this.pathkey = pathkey;
	}

	public String getCopyrightkindname() {
		return copyrightkindname;
	}

	public void setCopyrightkindname(String copyrightkindname) {
		this.copyrightkindname = copyrightkindname;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCopyrightname() {
		return copyrightname;
	}

	public void setCopyrightname(String copyrightname) {
		this.copyrightname = copyrightname;
	}

	public String getCopyrightkind() {
		return copyrightkind;
	}

	public void setCopyrightkind(String copyrightkind) {
		this.copyrightkind = copyrightkind;
	}

	public String getTransfermethod() {
		return transfermethod;
	}

	public void setTransfermethod(String transfermethod) {
		this.transfermethod = transfermethod;
	}

	public String getTransferinstruct() {
		return transferinstruct;
	}

	public void setTransferinstruct(String transferinstruct) {
		this.transferinstruct = transferinstruct;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHtmlpath() {
		return htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}

	public String getWorkerid() {
		return workerid;
	}

	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}

	public String getDeveloptime() {
		return developtime;
	}

	public void setDeveloptime(String developtime) {
		this.developtime = developtime;
	}
}
