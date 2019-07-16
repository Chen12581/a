package com.wqt.user.pojo;

/*用户建议*/
public class WqtUserSuggest {
	private String id;             //
    private String userid;         //用户ID
    private String inserttime;     //插入时间
    private String suggest;        //建议内容
    private String state;          //状态1表示用户提交2表示业务员受理3表示处理完毕
    private String workerid;       //业务员
    private String answertime;     //回复时间
    private String answer;         //回复内容
    private String workerqq;       //业务员QQ
    private String workername;     //业务员姓名
    private String workerheaderurl;//业务员头像
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
	public String getInserttime() {
		return inserttime;
	}
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
	public String getSuggest() {
		return suggest;
	}
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	public String getAnswertime() {
		return answertime;
	}
	public void setAnswertime(String answertime) {
		this.answertime = answertime;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getWorkerqq() {
		return workerqq;
	}
	public void setWorkerqq(String workerqq) {
		this.workerqq = workerqq;
	}
	public String getWorkername() {
		return workername;
	}
	public void setWorkername(String workername) {
		this.workername = workername;
	}
	public String getWorkerheaderurl() {
		return workerheaderurl;
	}
	public void setWorkerheaderurl(String workerheaderurl) {
		this.workerheaderurl = workerheaderurl;
	}   
}
