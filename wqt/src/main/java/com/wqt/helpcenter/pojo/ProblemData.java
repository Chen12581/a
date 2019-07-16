package com.wqt.helpcenter.pojo;

import java.util.List;

import com.problem.pojo.Problem;
import com.problem.pojo.ProblemKind;

/*问题详情页对象*/
public class ProblemData {
	    private List<ProblemKind> l_DisProblemKind;   //问题大类
	    private List<ProblemKind> l_WqtProblemKind;   //问题所有类别
	    private Problem  wqtProblem;
	    private Problem  prewqtProblem;     //上一个问题
	    private Problem  nextwqtProblem;    //下一个问题
	    
		public List<ProblemKind> getL_DisProblemKind() {
			return l_DisProblemKind;
		}
		public void setL_DisProblemKind(List<ProblemKind> l_DisProblemKind) {
			this.l_DisProblemKind = l_DisProblemKind;
		}
		public List<ProblemKind> getL_WqtProblemKind() {
			return l_WqtProblemKind;
		}
		public void setL_WqtProblemKind(List<ProblemKind> l_WqtProblemKind) {
			this.l_WqtProblemKind = l_WqtProblemKind;
		}
		public Problem getWqtProblem() {
			return wqtProblem;
		}
		public void setWqtProblem(Problem wqtProblem) {
			this.wqtProblem = wqtProblem;
		}
		public Problem getPrewqtProblem() {
			return prewqtProblem;
		}
		public void setPrewqtProblem(Problem prewqtProblem) {
			this.prewqtProblem = prewqtProblem;
		}
		public Problem getNextwqtProblem() {
			return nextwqtProblem;
		}
		public void setNextwqtProblem(Problem nextwqtProblem) {
			this.nextwqtProblem = nextwqtProblem;
		}
		
		
}
