package com.wqt.helpcenter.pojo;

import java.util.List;

import com.problem.pojo.Problem;
import com.problem.pojo.ProblemKind;

/*问题类别页对象*/
public class ProblemKindData {
	    private List<ProblemKind> l_DisProblemKind;   //问题大类
	    private List<ProblemKind> l_WqtProblemKind;   //问题所有类别
	    private List<Problem> l_WqtProblem;           //常见问题
	    private String kindkey;      //类别
	    private String searchkey;    //搜索关键词
	    private String pagenum;          //当前页数
	    private String problemcount="0";    //总记录
	  	private String problempage="0";     //总页数
	  	
	  	
		public String getSearchkey() {
			return searchkey;
		}
		public void setSearchkey(String searchkey) {
			this.searchkey = searchkey;
		}
		public String getKindkey() {
			return kindkey;
		}
		public void setKindkey(String kindkey) {
			this.kindkey = kindkey;
		}
		public List<ProblemKind> getL_WqtProblemKind() {
			return l_WqtProblemKind;
		}
		public void setL_WqtProblemKind(List<ProblemKind> l_WqtProblemKind) {
			this.l_WqtProblemKind = l_WqtProblemKind;
		}
		public List<Problem> getL_WqtProblem() {
			return l_WqtProblem;
		}
		public void setL_WqtProblem(List<Problem> l_WqtProblem) {
			this.l_WqtProblem = l_WqtProblem;
		}
		public List<ProblemKind> getL_DisProblemKind() {
			return l_DisProblemKind;
		}
		public void setL_DisProblemKind(List<ProblemKind> l_DisProblemKind) {
			this.l_DisProblemKind = l_DisProblemKind;
		}
		public String getPagenum() {
			return pagenum;
		}
		public void setPagenum(String pagenum) {
			this.pagenum = pagenum;
		}
		public String getProblemcount() {
			return problemcount;
		}
		public void setProblemcount(String problemcount) {
			this.problemcount = problemcount;
		}
		public String getProblempage() {
			return problempage;
		}
		public void setProblempage(String problempage) {
			this.problempage = problempage;
		}
	    
}
