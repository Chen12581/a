package com.wqt.common.pojo;


//地市
public class WqtCity  implements java.io.Serializable{
	    private String id;               //主键ID
	    private String provinceid;       //省份ID
	    private String cityname;         //地市名称
	    
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
		public String getCityname() {
			return cityname;
		}
		public void setCityname(String cityname) {
			this.cityname = cityname;
		}
	    
	    
}
