package com.wqt.ipr.brand.pojo;

import java.util.List;

/**
 * 商标交易商品表
 * @author Administrator
 *
 */
public class IprBrandShop {
	private String id;//主键id
	
	private String userid;//用户ID
	
	private String username;//用户ID
	
	private String brandname;//商标名称
	
	private String brandlength; //商标名称长度
	
	private String brandcode;//商标编号
	
	
	private String developtime;//发布时间
	
	private String mobileno;
	
	private String email;
	
	private String brandindustry;//商标行业
	
	private String industryname;//商标行业
	
	private String brandkind;//商标类别
	
	private String kindname;//商标类别名称
	
	private String regcode;//注册号
	
	private String area;//所属区域
	
	private String rbrand;//是否已注册为R标1：表示已经注册为R标2：表示未注册为R标
	
	private String assemble;//组合类型
	
	private String state;//商标出售状态
	
	private String states;//商标出售状态
	
	private String startvalidity;//有效期开始时间
	
	private String endvalidity;//有效期结束时间
	
	private String price;//价格
	
	private String minprice;//价格
	
	private String bottomprice;
	
	private String maxprice;//价格
	
	private String similargroup;//类似群组
	
	private String suititem;//适用项目
	
	private String buymethod;//购买方式
	
	private String htmlpath;//详情页地址
	
	private String mobilehtml;//详情页地址
	
	private String workerid;//负责的业务员ID
	
	private String displayname;
	
	private String updatename;
	
	private String connect;
	
	private String brandshopphoto;  //商标的图标地址
    
	private String brandkindname;
	
	private String initialnoticeissue;	//初审公告期号
	
	private String initialnoticedate;	//初审公告日期
	
	private String regnoticeissue;	//注册公告期号
	
	private String regnoticedate;	//注册公告日期
	
	private String tipsmsg;       //检测时返回信息提示
	
	private String groupcode;
	
	private String groupname;
	
	private String itemcode;
	
	private String itemname;
	
	private String itemnames;
	
	private String brandowner;
	
	private String isspecial;  //是否特价
	
	
	private String ownermobile;

	
	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}


	public String getOwnermobile() {
		return ownermobile;
	}

	public void setOwnermobile(String ownermobile) {
		this.ownermobile = ownermobile;
	}

	public String getItemnames() {
		return itemnames;
	}

	public void setItemnames(String itemnames) {
		this.itemnames = itemnames;
	}

	public String getIsspecial() {
		return isspecial;
	}

	public void setIsspecial(String isspecial) {
		this.isspecial = isspecial;
	}

	public String getBrandowner() {
		return brandowner;
	}

	public void setBrandowner(String brandowner) {
		this.brandowner = brandowner;
	}

	public String getGroupcode() {
		return groupcode;
	}

	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode;
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

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getTipsmsg() {
		return tipsmsg;
	}

	public void setTipsmsg(String tipsmsg) {
		this.tipsmsg = tipsmsg;
	}

	public String getInitialnoticeissue() {
		return initialnoticeissue;
	}

	public void setInitialnoticeissue(String initialnoticeissue) {
		this.initialnoticeissue = initialnoticeissue;
	}

	public String getInitialnoticedate() {
		return initialnoticedate;
	}

	public void setInitialnoticedate(String initialnoticedate) {
		this.initialnoticedate = initialnoticedate;
	}

	public String getRegnoticeissue() {
		return regnoticeissue;
	}

	public void setRegnoticeissue(String regnoticeissue) {
		this.regnoticeissue = regnoticeissue;
	}

	public String getRegnoticedate() {
		return regnoticedate;
	}

	public void setRegnoticedate(String regnoticedate) {
		this.regnoticedate = regnoticedate;
	}

	public String getBrandkindname() {
		return brandkindname;
	}

	public void setBrandkindname(String brandkindname) {
		this.brandkindname = brandkindname;
	}

	public String getMobilehtml() {
		return mobilehtml;
	}

	public void setMobilehtml(String mobilehtml) {
		this.mobilehtml = mobilehtml;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getBrandshopphoto() {
		return brandshopphoto;
	}

	public void setBrandshopphoto(String brandshopphoto) {
		this.brandshopphoto = brandshopphoto;
	}

	public String getConnect() {
		return connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIndustryname() {
		return industryname;
	}

	public void setIndustryname(String industryname) {
		this.industryname = industryname;
	}

	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}

	public String getMinprice() {
		return minprice;
	}

	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}

	public String getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(String maxprice) {
		this.maxprice = maxprice;
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

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getBrandcode() {
		return brandcode;
	}

	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}

	public String getDeveloptime() {
		return developtime;
	}

	public void setDeveloptime(String developtime) {
		this.developtime = developtime;
	}

	public String getBrandindustry() {
		return brandindustry;
	}

	public void setBrandindustry(String brandindustry) {
		this.brandindustry = brandindustry;
	}

	public String getBrandkind() {
		return brandkind;
	}

	public void setBrandkind(String brandkind) {
		this.brandkind = brandkind;
	}

	public String getRegcode() {
		return regcode;
	}

	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRbrand() {
		return rbrand;
	}

	public void setRbrand(String rbrand) {
		this.rbrand = rbrand;
	}

	public String getAssemble() {
		return assemble;
	}

	public void setAssemble(String assemble) {
		this.assemble = assemble;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStartvalidity() {
		return startvalidity;
	}

	public void setStartvalidity(String startvalidity) {
		this.startvalidity = startvalidity;
	}

	public String getEndvalidity() {
		return endvalidity;
	}

	public void setEndvalidity(String endvalidity) {
		this.endvalidity = endvalidity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSimilargroup() {
		return similargroup;
	}

	public void setSimilargroup(String similargroup) {
		this.similargroup = similargroup;
	}

	public String getSuititem() {
		return suititem;
	}

	public void setSuititem(String suititem) {
		this.suititem = suititem;
	}

	public String getBuymethod() {
		return buymethod;
	}

	public void setBuymethod(String buymethod) {
		this.buymethod = buymethod;
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
	
	public String getBrandlength() {
		return brandlength;
	}

	public void setBrandlength(String brandlength) {
		this.brandlength = brandlength;
	}

	public String getBottomprice() {
		return bottomprice;
	}

	public void setBottomprice(String bottomprice) {
		this.bottomprice = bottomprice;
	}
}
