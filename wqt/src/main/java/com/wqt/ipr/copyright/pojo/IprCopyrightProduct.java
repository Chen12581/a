package com.wqt.ipr.copyright.pojo;

/**
 * 版权产品
 *
 */
public class IprCopyrightProduct {
	private String id;            //主键
    private String kindid;       //产品分类�
    private String productname;  //版权产品名称
    private String productdesc;  //版权产品描述
    private String price;        //产品价格
    private String rebateprice;  //优惠价格
    private String simplename;	//虚拟关键字
    private String state;		//状态
    private String htmlpath;	//虚拟静态地址
    private String succount;	//成交次数
    private String sharecount;	//分享次数
    private String collectcount;//收藏次数
    private String brandicon;	//图标
    private String bookmark;	//标签
    private String kindname;
    
    
	
	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKindid() {
		return kindid;
	}

	public void setKindid(String kindid) {
		this.kindid = kindid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRebateprice() {
		return rebateprice;
	}

	public void setRebateprice(String rebateprice) {
		this.rebateprice = rebateprice;
	}

	public String getSimplename() {
		return simplename;
	}

	public void setSimplename(String simplename) {
		this.simplename = simplename;
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

	public String getSuccount() {
		return succount;
	}

	public void setSuccount(String succount) {
		this.succount = succount;
	}

	public String getSharecount() {
		return sharecount;
	}

	public void setSharecount(String sharecount) {
		this.sharecount = sharecount;
	}

	public String getCollectcount() {
		return collectcount;
	}

	public void setCollectcount(String collectcount) {
		this.collectcount = collectcount;
	}

	public String getBrandicon() {
		return brandicon;
	}

	public void setBrandicon(String brandicon) {
		this.brandicon = brandicon;
	}

	public String getBookmark() {
		return bookmark;
	}

	public void setBookmark(String bookmark) {
		this.bookmark = bookmark;
	}
	
}
