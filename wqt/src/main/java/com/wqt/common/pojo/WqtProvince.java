package com.wqt.common.pojo;

public class WqtProvince  implements java.io.Serializable{
	    private String id;               //主键ID
	    private String provincename;     //省份名称
	    private String provincecode;     //省份编码
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getProvincename() {
			return provincename;
		}
		public void setProvincename(String provincename) {
			this.provincename = provincename;
		}
		public String getProvincecode() {
			return provincecode;
		}
		public void setProvincecode(String provincecode) {
			this.provincecode = provincecode;
		}
}
