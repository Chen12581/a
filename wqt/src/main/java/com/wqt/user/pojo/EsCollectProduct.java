package com.wqt.user.pojo;

/*知识产权服务产品用户收藏*/
public class EsCollectProduct {
    private String id;           //主键ID
    private String userid;       //用户ID
    private String productid;    //服务产品ID
    private String collecttime;  //收藏时间
    
    
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
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getCollecttime() {
		return collecttime;
	}
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}
     
     
}
