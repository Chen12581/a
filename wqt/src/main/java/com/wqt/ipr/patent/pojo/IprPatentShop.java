package com.wqt.ipr.patent.pojo;
/**
 * 专利交易商品表
 * @author Administrator
 *
 */
public class IprPatentShop {
	private String id;//主键id
	
	private String userid;//用户id
	
	private String patentname;//专利名
	
	private String patentno;//专利号
	
	private String patenttype;//专利类型1：发明专利2：实用新型3：外观设计 
	
	private String kindid;//行业分类见表
	
	private String kindname;//行业分类名称
	
	private String applydate;//
	
	private String validitydate;//有效期
	
	private String busikind;//交易类型
	
	private String isspecial;//是否特价
	
	private String patentstate;//专利状态
	
	private String price;//出售价格
	
	private String shopcode;//商品编号
	
	private String developtime;//发布时间
	
	private String patentdesc;//专利详情
	
	private String state;//状态
	
	private String htmlpath;//专利详情页地址
	
	private String patentphoto;//专利图片地址
	
	private String collectcount;//用户收藏数
	
	private String workerid;//业务员ID
	
	private String tipsmsg;
	
	private String displayname;
	
	private String updatename;
	
	private String ownername;
	
	private String ownermobile;

	
	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getOwnermobile() {
		return ownermobile;
	}

	public void setOwnermobile(String ownermobile) {
		this.ownermobile = ownermobile;
	}

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

	public String getTipsmsg() {
		return tipsmsg;
	}

	public void setTipsmsg(String tipsmsg) {
		this.tipsmsg = tipsmsg;
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

	public String getPatentname() {
		return patentname;
	}

	public void setPatentname(String patentname) {
		this.patentname = patentname;
	}

	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}

	public String getPatentno() {
		return patentno;
	}

	public void setPatentno(String patentno) {
		this.patentno = patentno;
	}

	public String getPatenttype() {
		return patenttype;
	}

	public void setPatenttype(String patenttype) {
		this.patenttype = patenttype;
	}

	public String getKindid() {
		return kindid;
	}

	public void setKindid(String kindid) {
		this.kindid = kindid;
	}

	public String getApplydate() {
		return applydate;
	}

	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}

	public String getValiditydate() {
		return validitydate;
	}

	public void setValiditydate(String validitydate) {
		this.validitydate = validitydate;
	}

	public String getBusikind() {
		return busikind;
	}

	public void setBusikind(String busikind) {
		this.busikind = busikind;
	}

	public String getIsspecial() {
		return isspecial;
	}

	public void setIsspecial(String isspecial) {
		this.isspecial = isspecial;
	}

	public String getPatentstate() {
		return patentstate;
	}

	public void setPatentstate(String patentstate) {
		this.patentstate = patentstate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getShopcode() {
		return shopcode;
	}

	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}

	public String getDeveloptime() {
		return developtime;
	}

	public void setDeveloptime(String developtime) {
		this.developtime = developtime;
	}

	public String getPatentdesc() {
		return patentdesc;
	}

	public void setPatentdesc(String patentdesc) {
		this.patentdesc = patentdesc;
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

	public String getPatentphoto() {
		return patentphoto;
	}

	public void setPatentphoto(String patentphoto) {
		this.patentphoto = patentphoto;
	}

	public String getCollectcount() {
		return collectcount;
	}

	public void setCollectcount(String collectcount) {
		this.collectcount = collectcount;
	}

	public String getWorkerid() {
		return workerid;
	}

	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
}
