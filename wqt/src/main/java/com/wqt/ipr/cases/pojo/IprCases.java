package com.wqt.ipr.cases.pojo;

/*知识产权案例*/
public class IprCases {
	private String id;			//主键
	private String kind;		//服务类别 1：商标 2：版权 3：专利 9：其他
	private String state;		//状态 0表示编辑 1表示发布2表示上线
	private String periodsnum;	//期数
	private String title;		//标题
	private String createtime;	//创建时间
	private String beforetext;	//采访前言
	private String resulttext;	//结束语
	private String casedesc;	//案例描述
	private String orderkind;	//交易类型 买家或者卖家
	private String price;		//价格
	private String kindname;	//商标的就是商标类别，版权的是就是作品类别，专利的就是行业类别
	private String casecontent;	//采访内容
	private String caseimg;		//图标地址
	private String pathkey;		//虚拟关键字
	private String htmlpath;	//详情页地址
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPeriodsnum() {
		return periodsnum;
	}
	public void setPeriodsnum(String periodsnum) {
		this.periodsnum = periodsnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getBeforetext() {
		return beforetext;
	}
	public void setBeforetext(String beforetext) {
		this.beforetext = beforetext;
	}
	public String getResulttext() {
		return resulttext;
	}
	public void setResulttext(String resulttext) {
		this.resulttext = resulttext;
	}
	public String getCasedesc() {
		return casedesc;
	}
	public void setCasedesc(String casedesc) {
		this.casedesc = casedesc;
	}
	public String getOrderkind() {
		return orderkind;
	}
	public void setOrderkind(String orderkind) {
		this.orderkind = orderkind;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getKindname() {
		return kindname;
	}
	public void setKindname(String kindname) {
		this.kindname = kindname;
	}
	public String getCasecontent() {
		return casecontent;
	}
	public void setCasecontent(String casecontent) {
		this.casecontent = casecontent;
	}
	public String getCaseimg() {
		return caseimg;
	}
	public void setCaseimg(String caseimg) {
		this.caseimg = caseimg;
	}
	public String getPathkey() {
		return pathkey;
	}
	public void setPathkey(String pathkey) {
		this.pathkey = pathkey;
	}
	public String getHtmlpath() {
		return htmlpath;
	}
	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}
	
}
