package com.wqt.common.pojo;


//区县
public class WqtArea  implements java.io.Serializable{
	    private String id;               //主键ID
	    private String provinceid;       //省份ID
	    private String cityid;           //地市名称
	    private String areaname;         //区县名称
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getProvinceid() {
			return provinceid;
		}
		public void setProvinceid(String provinceid) {
			this.provinceid = provinceid;
		}
		public String getCityid() {
			return cityid;
		}
		public void setCityid(String cityid) {
			this.cityid = cityid;
		}
		public String getAreaname() {
			return areaname;
		}
		public void setAreaname(String areaname) {
			this.areaname = areaname;
		} 
}
