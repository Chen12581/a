package com.wqt.eshop.pojo;

import java.util.List;

import com.problem.pojo.Problem;
import com.worker.pojo.Worker;

/*店铺信息类*/
public class EShopShop {
             private String  id;                     //主键ID
             private String  shopcode;               //店铺编号
             private String  shoptitle;              //店铺标题
             private int  userid;                 //店铺用户ID
             private String  plateformcode;           //平台类型编码
             private String  plateformname;           //所属平台名
             private String  plateformmermber;        //平台会员名
             private String  aliwang;                //阿里的旺旺名(淘宝，天猫使用)
             private String  shopurl;                //店铺地址
             private String  shopiconurl;            //店铺图标链接地址
             private String  shoptime;               //淘宝店铺：创店时间 ,天猫店铺：进驻时间,其他店铺：进驻时间
             private String  createtime;             //发布店铺时间
             private String  areacode;               //店铺所在区域
			 private String  areaname;               //店铺所在区域
             private int  proviceid;                 //店铺所在省份
             private String  provicename;            //店铺所在省份
             private int  cityid;                    //店铺所在地市
             private int  state;                  //店铺状态 1:已提交，待审核  2:在售  3:预定 4:交接5:已售6:审核不通过7:已分配服务顾问   8:审核通过
             private String  states;                 //店铺状态 1:已提交，待审核  2:在售  3:预定 4:交接5:已售6:审核不通过7:已分配服务顾问   8:审核通过
             private String  statename;              //店铺状态
			 private int      price;                  //出售价格
             private int  deposittype;            //消保金类型  1:真实消保(需要退还) 2:真实消保(不需要退还)3:信用消保
             private int  depositmoney;           //消保金金额
             private int  techfee;                //技术年费
             private int  returntechfee;          //是否退换技术年费(1表示不退还 2表示退还)
             private double  techfeeratio;           //技术年费退还比率
             private String  commisionmoney;         //服务费  以卖家为标准
             private String  currentcreditnum;       //卖家当前信用数\
             private int  creditid;           //卖家信用等级ID
             private String  creditname;         //卖家信用等级内容
             private String  shopaptitude;           //店铺资质(淘宝，天猫,楚楚街) 消费者服务保障(蘑菇街)
             private int  malltypeid;             //商城类型id
             private String  malltypename="/";       //商城类型名
             private String  shopidentification;     //店铺认证状态1:个人身份证认证 2:企业名义认证
             private int  brandcategoryid;        //商标类型ID
             private String  brandcategoryname="/";  //商标类型名
             private String  scorecommon;            //一般扣分(淘宝，天猫用)
             private String  scoregrave;             //严重扣分(淘宝，天猫用)
             private String  scorefake;              //售假扣分(淘宝，天猫用)
             private String  scoremultipule;
             private String  scoreshop;
             private String  scoreservice;
             private String  scoretime;
             private int  evaluategood;           //好评数(淘宝，天猫用)
             private int  evaluatecommon;         //中评数(淘宝，天猫用)
             private int  evaluatebad;            //差评数(淘宝，天猫用)
             private String  shopdesc;               //店铺描述
             private String  shopmark;               //店铺标签
             private String  goodsspeed;             //卖家发货的速度(淘宝，天猫用)
             private int  speedlevel;             //发货的速度水平 0 低1持平 2高(淘宝，天猫用)
             private String  cowrydesc;              //宝贝与描述相符(淘宝，天猫用)
             private int  desclevel;              //宝贝与描述水平 0 低1持平 2高(淘宝，天猫用)
             private String  serviceattitude;        //卖家的服务态度(淘宝，天猫用)
             private int  servicelevel;           //服务态度水平 0 低1持平 2高(淘宝，天猫用)
             private int  isloan;                 //是否有贷款  1：表示有贷款      2：表示没有贷款
             private String  renewdate;              //续费截止日期(除淘宝外，其他平台用)
             private String  goodevaluate;           //好评率(淘宝用)
             private String  dummyper;               //虚拟占比(淘宝用)
             private String  mainper;                //主营占比(淘宝用)
             private int  collectcount;           //收藏人气(淘宝用)
             private String  templateid;             //使用的模板ID
             private String  pathkey;                //虚拟文件名
             private String  htmlpath;               //生成的HTML文件路径
             private String  brandkind;              //商标分类(天猫,京东用)
             private String  brandkindname="/";      //商标分类(天猫,京东用)
             private String  openkind;               //开通类目(天猫,京东用)
             private int  islocalreg;             //是否本人注册1是2否
             private int  issuportgoods;          //是否提供货源1提2否
             private int  isdelivery;             //是否带货1带2否
             private int  ismargin;               //是否有月利润1有2否
             private int  isteam;                 //是否带团队转让1带2否
             private int  istrade;                //是否当面交易 1当面交易2否
             private String  sailname;               //卖家姓名
             private String  sailmobile;             //卖家手机
             private String  sailqq;                 //卖家qq
             private String  sailtel;                //卖家固定电话
             private String  iscompanytb;            //是否是企业店铺（淘宝使用，公司注册就是企业店铺） 0表示非企业店铺，1表示企业店铺
             private String  shopSailcategorys;      //店铺关联的类目;
             private String  workerheadurl;          //工作人员头像地址
             private String  workerid;               //挂店服务顾问ID
             private String  workername;             //工作人员用户名
             private String  workerqq;               //工作人员qq
             private String  workertel; 
             private String  workercode;             //工作人员工号
             private String  workereva;              //工作人员评分
             private int  payduty;                //纳税人资质 天猫用(1:一般纳税人2小规模纳税人)
             private int  brandtransfer;          //商标过户（天猫用 1表示只能授权2表示可以过户）
             private String  developtime;            //店铺发布时间(店铺上线交易的时间)
             private String  developday;             //店铺发布时间(店铺上线交易的时间)
             private String  maincategoryid;         //店铺主营类目ID
             private String  maincategoryname;       //店铺主营类目名 
             private String  issuportbusi;           //是否传授运营经验(1表示不提供 2表示提供)
             private String  dispute;                //债务纠纷(1表示无 2表示有)
             private String  issuportcard;           //可提供证件(1表示不可以提供 2表示可以提供)
             private String  regcapital;             //注册资金(天猫和淘宝企业店铺用)
             private String  companyname;            //公司名字(天猫和淘宝企业店铺用)
             private int  isnew;                  //是否新店(1表示新店 2表示非新店)
             private int  lowprice;               //最低出售价
             private int  highprice;              //最高出售价
             private int  isbusiindex;            //是否完成营业额指标(1:没有完成 2 表示完成)
             private String  iconsurl;               //主营类目图标地址
             private String  kindurl;                 //类目图标地址
         	 private String  techfeestatus;           //技术年费状态
        	 private String  depositstatus;           //消保金状态
        	 private int  hotrecom;                   //热门店铺推荐  1表示推荐 2表示否
        	 private int iscollect;                   //是否收藏；
        	 private List<Worker>  l_worker;          //业务员
        	 private List<EShopShop>  hot_EShopShop;  //热门推荐店铺
        	 private List<Problem>  hot_Problem;      //热门问题
             /*查询时用*/    
        	 private double startscoremultipule;     //综合评分(京东用)
        	 private double endscoremultipule;       //综合评分(京东用)
             private int  startprice;             //查询店铺起始价格
             private int  endprice;               //查询店铺最高价格
             private String  sailcreditcode;         //卖家信用等级编码
             private String  startdummyper;          //查询起始虚拟占比(淘宝用)
             private String  enddummyper;            //查询最高虚拟占比(淘宝用)
             private String  dynamicscore;           //查询动态评分(淘宝用)
             private String  deductscore;            //查询扣分(淘宝用 有扣分)
             private String  nodeductscore;          //查询扣分(淘宝用 无扣分)
             private int  jddeductscore;            //查询扣分(京东用 有扣分)
             private int  jdnodeductscore;          //查询扣分(京东用 无扣分)
             private int  startcreditid;          //起始卖家信用等级ID
             private int  endcreditid;            //结束卖家信用等级ID
             private String  lowgoodevaluate;        //好评率低于90的查询
             private String  ordergoodevaluate;      //好评率查询排序
             private String  upgoodevaluate;         //好评率查询升序
             private String  downgoodevaluate;       //好评率查询降序
             private String  ordersailcreditid;      //卖家等级查询排序
             private String  upsailcreditid;         //卖家等级查询升序
             private String  downsailcreditid;       //卖家等级查询降序
             private String  orderprice;             //价格查询排序
             private String  upprice;                //价格查询升序
             private String  downprice;              //价格查询降序
             private String  orderdefault;           //默认查询排序
             private String  uporderdeveloptime;      //发布时间排序
             private String  downorderdeveloptime;    //发布时间排序
             private String  ordercollectcount;      //收藏人气查询排序
             private String  upcollectcount;         //收藏人气查询升序
             private String  downcollectcount;       //收藏人气查询降序
             private String  keyword;                //搜索关键字
             private String  ordershoptime;          //搜索的最新上架排序
   
             private String  detailtitle;            //详情页的TITLE
             private String  detailkeyword;          //详情页的KEYWORD
              
             private String  companytype;                //公司类型
             private String  companystate;                //公司经营状态
             private String  companytime;                //公司成立时间
             private String  partnernum;                //股东人数
             private String  brandbelong;                //商标归属
             private String  brandbelongkind;                //商标归属类型
             private String  brandsmallkind;                //商标注册小类
             
             
			public int getIscollect() {
				return iscollect;
			}
			public void setIscollect(int iscollect) {
				this.iscollect = iscollect;
			}
			public List<Problem> getHot_Problem() {
				return hot_Problem;
			}
			public void setHot_Problem(List<Problem> hot_Problem) {
				this.hot_Problem = hot_Problem;
			}
			public List<Worker> getL_worker() {
				return l_worker;
			}
			public void setL_worker(List<Worker> l_worker) {
				this.l_worker = l_worker;
			}
			public List<EShopShop> getHot_EShopShop() {
				return hot_EShopShop;
			}
			public void setHot_EShopShop(List<EShopShop> hot_EShopShop) {
				this.hot_EShopShop = hot_EShopShop;
			}
			public int getJddeductscore() {
				return jddeductscore;
			}
			public void setJddeductscore(int jddeductscore) {
				this.jddeductscore = jddeductscore;
			}
			public int getJdnodeductscore() {
				return jdnodeductscore;
			}
			public void setJdnodeductscore(int jdnodeductscore) {
				this.jdnodeductscore = jdnodeductscore;
			}
			public double getStartscoremultipule() {
				return startscoremultipule;
			}
			public void setStartscoremultipule(double startscoremultipule) {
				this.startscoremultipule = startscoremultipule;
			}
			public double getEndscoremultipule() {
				return endscoremultipule;
			}
			public void setEndscoremultipule(double endscoremultipule) {
				this.endscoremultipule = endscoremultipule;
			}
			
			public int getHotrecom() {
				return hotrecom;
			}
			public void setHotrecom(int hotrecom) {
				this.hotrecom = hotrecom;
			}
			public String getUporderdeveloptime() {
				return uporderdeveloptime;
			}
			public void setUporderdeveloptime(String uporderdeveloptime) {
				this.uporderdeveloptime = uporderdeveloptime;
			}
			public String getDownorderdeveloptime() {
				return downorderdeveloptime;
			}
			public void setDownorderdeveloptime(String downorderdeveloptime) {
				this.downorderdeveloptime = downorderdeveloptime;
			}
			public String getNodeductscore() {
				return nodeductscore;
			}
			public void setNodeductscore(String nodeductscore) {
				this.nodeductscore = nodeductscore;
			}
			public String getScoremultipule() {
				return scoremultipule;
			}
			public void setScoremultipule(String scoremultipule) {
				this.scoremultipule = scoremultipule;
			}
			public String getScoreshop() {
				return scoreshop;
			}
			public void setScoreshop(String scoreshop) {
				this.scoreshop = scoreshop;
			}
			public String getScoreservice() {
				return scoreservice;
			}
			public void setScoreservice(String scoreservice) {
				this.scoreservice = scoreservice;
			}
			public String getScoretime() {
				return scoretime;
			}
			public void setScoretime(String scoretime) {
				this.scoretime = scoretime;
			}
			public String getDevelopday() {
				return developday;
			}
			public void setDevelopday(String developday) {
				this.developday = developday;
			}
			public String getCompanytype() {
				return companytype;
			}
			public void setCompanytype(String companytype) {
				this.companytype = companytype;
			}
			public String getCompanystate() {
				return companystate;
			}
			public void setCompanystate(String companystate) {
				this.companystate = companystate;
			}
			public String getCompanytime() {
				return companytime;
			}
			public void setCompanytime(String companytime) {
				this.companytime = companytime;
			}
			public String getPartnernum() {
				return partnernum;
			}
			public void setPartnernum(String partnernum) {
				this.partnernum = partnernum;
			}
			public String getBrandbelong() {
				return brandbelong;
			}
			public void setBrandbelong(String brandbelong) {
				this.brandbelong = brandbelong;
			}
			public String getBrandbelongkind() {
				return brandbelongkind;
			}
			public void setBrandbelongkind(String brandbelongkind) {
				this.brandbelongkind = brandbelongkind;
			}
			public String getBrandsmallkind() {
				return brandsmallkind;
			}
			public void setBrandsmallkind(String brandsmallkind) {
				this.brandsmallkind = brandsmallkind;
			}
			public String getPathkey() {
				return pathkey;
			}
			public void setPathkey(String pathkey) {
				this.pathkey = pathkey;
			}
			public String getDetailtitle() {
				return detailtitle;
			}
			public void setDetailtitle(String detailtitle) {
				this.detailtitle = detailtitle;
			}
			public String getDetailkeyword() {
				return detailkeyword;
			}
			public void setDetailkeyword(String detailkeyword) {
				this.detailkeyword = detailkeyword;
			}
			public int getState() {
				return state;
			}
			public void setState(int state) {
				this.state = state;
			}
			public String getStates() {
				return states;
			}
			public void setStates(String states) {
				this.states = states;
			}
			public String getStatename() {
				return statename;
			}
			public void setStatename(String statename) {
				this.statename = statename;
			}
			
			public String getBrandkindname() {
				return brandkindname;
			}
			public void setBrandkindname(String brandkindname) {
				this.brandkindname = brandkindname;
			}
			public String getTechfeestatus() {
				return techfeestatus;
			}
			public void setTechfeestatus(String techfeestatus) {
				this.techfeestatus = techfeestatus;
			}
			public String getDepositstatus() {
				return depositstatus;
			}
			public void setDepositstatus(String depositstatus) {
				this.depositstatus = depositstatus;
			}
           
            public String getWorkercode() {
				return workercode;
			}
			public void setWorkercode(String workercode) {
				this.workercode = workercode;
			}
            
             public String getKindurl() {
				return kindurl;
			}
			public void setKindurl(String kindurl) {
				this.kindurl = kindurl;
			}
            public String getCommisionmoney() {
				return commisionmoney;
			}
			public void setCommisionmoney(String commisionmoney) {
				this.commisionmoney = commisionmoney;
			}
		
             
             public String getIconsurl() {
				return iconsurl;
			}
			public void setIconsurl(String iconsurl) {
				this.iconsurl = iconsurl;
			}
			public String getWorkereva() {
				return workereva;
			}
			public void setWorkereva(String workereva) {
				this.workereva = workereva;
			}
			public String getAreaname() {
 				return areaname;
 			}
 			public void setAreaname(String areaname) {
 				this.areaname = areaname;
 			}
 			public String getProvicename() {
 				return provicename;
 			}
 			public void setProvicename(String provicename) {
 				this.provicename = provicename;
 			}
			
			public String getIssuportbusi() {
				return issuportbusi;
			}
			public void setIssuportbusi(String issuportbusi) {
				this.issuportbusi = issuportbusi;
			}
			public String getDispute() {
				return dispute;
			}
			public void setDispute(String dispute) {
				this.dispute = dispute;
			}
			public String getIssuportcard() {
				return issuportcard;
			}
			public void setIssuportcard(String issuportcard) {
				this.issuportcard = issuportcard;
			}
			public String getRegcapital() {
				return regcapital;
			}
			public void setRegcapital(String regcapital) {
				this.regcapital = regcapital;
			}
			public String getCompanyname() {
				return companyname;
			}
			public void setCompanyname(String companyname) {
				this.companyname = companyname;
			}
			
			public int getIsnew() {
				return isnew;
			}
			public void setIsnew(int isnew) {
				this.isnew = isnew;
			}
			public int getIsbusiindex() {
				return isbusiindex;
			}
			public void setIsbusiindex(int isbusiindex) {
				this.isbusiindex = isbusiindex;
			}
			public int getReturntechfee() {
				return returntechfee;
			}
			public void setReturntechfee(int returntechfee) {
				this.returntechfee = returntechfee;
			}
			public int getLowprice() {
				return lowprice;
			}
			public void setLowprice(int lowprice) {
				this.lowprice = lowprice;
			}
			public int getHighprice() {
				return highprice;
			}
			public void setHighprice(int highprice) {
				this.highprice = highprice;
			}
			public String getMaincategoryid() {
				return maincategoryid;
			}
			public void setMaincategoryid(String maincategoryid) {
				this.maincategoryid = maincategoryid;
			}
			public String getMaincategoryname() {
				return maincategoryname;
			}
			public void setMaincategoryname(String maincategoryname) {
				this.maincategoryname = maincategoryname;
			}
			
			public String getWorkertel() {
				return workertel;
			}
			public void setWorkertel(String workertel) {
				this.workertel = workertel;
			}
			public String getDeveloptime() {
				return developtime;
			}
			public void setDeveloptime(String developtime) {
				this.developtime = developtime;
			}
			public String getOrdershoptime() {
				return ordershoptime;
			}
			public void setOrdershoptime(String ordershoptime) {
				this.ordershoptime = ordershoptime;
			}
			public String getKeyword() {
				return keyword;
			}
			public void setKeyword(String keyword) {
				this.keyword = keyword;
			}
			public String getOrdercollectcount() {
				return ordercollectcount;
			}
			public void setOrdercollectcount(String ordercollectcount) {
				this.ordercollectcount = ordercollectcount;
			}
			public String getUpcollectcount() {
				return upcollectcount;
			}
			public void setUpcollectcount(String upcollectcount) {
				this.upcollectcount = upcollectcount;
			}
			public String getDowncollectcount() {
				return downcollectcount;
			}
			public void setDowncollectcount(String downcollectcount) {
				this.downcollectcount = downcollectcount;
			}
			
			public String getUpgoodevaluate() {
				return upgoodevaluate;
			}
			public void setUpgoodevaluate(String upgoodevaluate) {
				this.upgoodevaluate = upgoodevaluate;
			}
			public String getDowngoodevaluate() {
				return downgoodevaluate;
			}
			public void setDowngoodevaluate(String downgoodevaluate) {
				this.downgoodevaluate = downgoodevaluate;
			}
			public String getUpsailcreditid() {
				return upsailcreditid;
			}
			public void setUpsailcreditid(String upsailcreditid) {
				this.upsailcreditid = upsailcreditid;
			}
			public String getDownsailcreditid() {
				return downsailcreditid;
			}
			public void setDownsailcreditid(String downsailcreditid) {
				this.downsailcreditid = downsailcreditid;
			}
			public String getUpprice() {
				return upprice;
			}
			public void setUpprice(String upprice) {
				this.upprice = upprice;
			}
			public String getDownprice() {
				return downprice;
			}
			public void setDownprice(String downprice) {
				this.downprice = downprice;
			}
			public String getOrdergoodevaluate() {
				return ordergoodevaluate;
			}
			public void setOrdergoodevaluate(String ordergoodevaluate) {
				this.ordergoodevaluate = ordergoodevaluate;
			}
			public String getOrdersailcreditid() {
				return ordersailcreditid;
			}
			public void setOrdersailcreditid(String ordersailcreditid) {
				this.ordersailcreditid = ordersailcreditid;
			}
			public String getOrderprice() {
				return orderprice;
			}
			public void setOrderprice(String orderprice) {
				this.orderprice = orderprice;
			}
			public String getOrderdefault() {
				return orderdefault;
			}
			public void setOrderdefault(String orderdefault) {
				this.orderdefault = orderdefault;
			}
			public String getLowgoodevaluate() {
				return lowgoodevaluate;
			}
			public void setLowgoodevaluate(String lowgoodevaluate) {
				this.lowgoodevaluate = lowgoodevaluate;
			}
			public String getWorkerqq() {
				return workerqq;
			}
			public void setWorkerqq(String workerqq) {
				this.workerqq = workerqq;
			}
			public int getStartcreditid() {
				return startcreditid;
			}
			public void setStartcreditid(int startcreditid) {
				this.startcreditid = startcreditid;
			}
			public int getEndcreditid() {
				return endcreditid;
			}
			public void setEndcreditid(int endcreditid) {
				this.endcreditid = endcreditid;
			}
			public int getIstrade() {
				return istrade;
			}
			public String getDeductscore() {
				return deductscore;
			}
			public void setDeductscore(String deductscore) {
				this.deductscore = deductscore;
			}
			public String getDynamicscore() {
				return dynamicscore;
			}
			public void setDynamicscore(String dynamicscore) {
				this.dynamicscore = dynamicscore;
			}
			
			public String getStartdummyper() {
				return startdummyper;
			}
			public void setStartdummyper(String startdummyper) {
				this.startdummyper = startdummyper;
			}
			public String getEnddummyper() {
				return enddummyper;
			}
			public void setEnddummyper(String enddummyper) {
				this.enddummyper = enddummyper;
			}
			public String getSailcreditcode() {
				return sailcreditcode;
			}
			public void setSailcreditcode(String sailcreditcode) {
				this.sailcreditcode = sailcreditcode;
			}
			
			public int getStartprice() {
				return startprice;
			}
			public void setStartprice(int startprice) {
				this.startprice = startprice;
			}
			public int getEndprice() {
				return endprice;
			}
			public void setEndprice(int endprice) {
				this.endprice = endprice;
			}
			public void setPrice(int price) {
				this.price = price;
			}
			public String getShopiconurl() {
				return shopiconurl;
			}
			public void setShopiconurl(String shopiconurl) {
				this.shopiconurl = shopiconurl;
			}
			public String getWorkerid() {
				return workerid;
			}
			public void setWorkerid(String workerid) {
				this.workerid = workerid;
			}
			public String getWorkername() {
				return workername;
			}
			public void setWorkername(String workername) {
				this.workername = workername;
			}
			
			
			public String getWorkerheadurl() {
				return workerheadurl;
			}
			public void setWorkerheadurl(String workerheadurl) {
				this.workerheadurl = workerheadurl;
			}
			public String getShopSailcategorys() {
				return shopSailcategorys;
			}
			public void setShopSailcategorys(String shopSailcategorys) {
				this.shopSailcategorys = shopSailcategorys;
			}
			public String getCurrentcreditnum() {
				return currentcreditnum;
			}
			public void setCurrentcreditnum(String currentcreditnum) {
				this.currentcreditnum = currentcreditnum;
			}
			
			public String getIscompanytb() {
				return iscompanytb;
			}
			public void setIscompanytb(String iscompanytb) {
				this.iscompanytb = iscompanytb;
			}
			public int getSpeedlevel() {
				return speedlevel;
			}
			public void setSpeedlevel(int speedlevel) {
				this.speedlevel = speedlevel;
			}
			public int getDesclevel() {
				return desclevel;
			}
			public void setDesclevel(int desclevel) {
				this.desclevel = desclevel;
			}
			public int getServicelevel() {
				return servicelevel;
			}
			public void setServicelevel(int servicelevel) {
				this.servicelevel = servicelevel;
			}
			public int getPrice() {
				return price;
			}
			public void setUserid(int userid) {
				this.userid = userid;
			}
			public void setDeposittype(int deposittype) {
				this.deposittype = deposittype;
			}
			public void setMalltypeid(int malltypeid) {
				this.malltypeid = malltypeid;
			}
			public void setBrandcategoryid(int brandcategoryid) {
				this.brandcategoryid = brandcategoryid;
			}
			public void setIsloan(int isloan) {
				this.isloan = isloan;
			}
			public void setCollectcount(int collectcount) {
				this.collectcount = collectcount;
			}
			public String getPlateformcode() {
				return plateformcode;
			}
			public void setPlateformcode(String plateformcode) {
				this.plateformcode = plateformcode;
			}
			
			public String getAliwang() {
				return aliwang;
			}
			public void setAliwang(String aliwang) {
				this.aliwang = aliwang;
			}
			
			public String getSailname() {
				return sailname;
			}
			public void setSailname(String sailname) {
				this.sailname = sailname;
			}
			public String getSailmobile() {
				return sailmobile;
			}
			public void setSailmobile(String sailmobile) {
				this.sailmobile = sailmobile;
			}
			public String getSailqq() {
				return sailqq;
			}
			public void setSailqq(String sailqq) {
				this.sailqq = sailqq;
			}
			public String getSailtel() {
				return sailtel;
			}
			public void setSailtel(String sailtel) {
				this.sailtel = sailtel;
			}
			
			public String getShoptime() {
				return shoptime;
			}
			public void setShoptime(String shoptime) {
				this.shoptime = shoptime;
			}
			
			public String getTemplateid() {
				return templateid;
			}
			public void setTemplateid(String templateid) {
				this.templateid = templateid;
			}
			
			
			public String getCreditname() {
				return creditname;
			}
			public void setCreditname(String creditname) {
				this.creditname = creditname;
			}
			public String getShopaptitude() {
				return shopaptitude;
			}
			public void setShopaptitude(String shopaptitude) {
				this.shopaptitude = shopaptitude;
			}
			
			public String getMalltypename() {
				return malltypename;
			}
			public void setMalltypename(String malltypename) {
				this.malltypename = malltypename;
			}
			public String getShopidentification() {
				return shopidentification;
			}
			public void setShopidentification(String shopidentification) {
				this.shopidentification = shopidentification;
			}
			
			
			public String getBrandcategoryname() {
				return brandcategoryname;
			}
			public void setBrandcategoryname(String brandcategoryname) {
				this.brandcategoryname = brandcategoryname;
			}
			
			public String getScorecommon() {
				return scorecommon;
			}
			public void setScorecommon(String scorecommon) {
				this.scorecommon = scorecommon;
			}
			public String getScoregrave() {
				return scoregrave;
			}
			public void setScoregrave(String scoregrave) {
				this.scoregrave = scoregrave;
			}
			public String getScorefake() {
				return scorefake;
			}
			public void setScorefake(String scorefake) {
				this.scorefake = scorefake;
			}
			
			public String getShopdesc() {
				return shopdesc;
			}
			public void setShopdesc(String shopdesc) {
				this.shopdesc = shopdesc;
			}
			public String getShopmark() {
				return shopmark;
			}
			public void setShopmark(String shopmark) {
				this.shopmark = shopmark;
			}
			public String getGoodsspeed() {
				return goodsspeed;
			}
			public void setGoodsspeed(String goodsspeed) {
				this.goodsspeed = goodsspeed;
			}
			public String getCowrydesc() {
				return cowrydesc;
			}
			public void setCowrydesc(String cowrydesc) {
				this.cowrydesc = cowrydesc;
			}
			public String getServiceattitude() {
				return serviceattitude;
			}
			public void setServiceattitude(String serviceattitude) {
				this.serviceattitude = serviceattitude;
			}
			
			public String getRenewdate() {
				return renewdate;
			}
			public void setRenewdate(String renewdate) {
				this.renewdate = renewdate;
			}
			public String getGoodevaluate() {
				return goodevaluate;
			}
			public void setGoodevaluate(String goodevaluate) {
				this.goodevaluate = goodevaluate;
			}
			public String getDummyper() {
				return dummyper;
			}
			public void setDummyper(String dummyper) {
				this.dummyper = dummyper;
			}
			public String getMainper() {
				return mainper;
			}
			public void setMainper(String mainper) {
				this.mainper = mainper;
			}
			
			public String getHtmlpath() {
				return htmlpath;
			}
			public void setHtmlpath(String htmlpath) {
				this.htmlpath = htmlpath;
			}
			public String getBrandkind() {
				return brandkind;
			}
			public void setBrandkind(String brandkind) {
				this.brandkind = brandkind;
			}
			public String getOpenkind() {
				return openkind;
			}
			public void setOpenkind(String openkind) {
				this.openkind = openkind;
			}
			public String getId() {
				return id;
			 }
			 public void setId(String id) {
				this.id = id;
			 }
			 public String getShopcode() {
				return shopcode;
			 }
			 public void setShopcode(String shopcode) {
				this.shopcode = shopcode;
			 }
			 public String getShoptitle() {
				return shoptitle;
			 }
			 public void setShoptitle(String shoptitle) {
				this.shoptitle = shoptitle;
			 }
			 public String getPlateformname() {
				return plateformname;
			 }
			 public void setPlateformname(String plateformname) {
				this.plateformname = plateformname;
			 }
			 public String getPlateformmermber() {
				return plateformmermber;
			 }
			 public void setPlateformmermber(String plateformmermber) {
				this.plateformmermber = plateformmermber;
			 }
			 public String getShopurl() {
				return shopurl;
			 }
			 public void setShopurl(String shopurl) {
				this.shopurl = shopurl;
			 }
			 public String getCreatetime() {
				return createtime;
			 }
			 public void setCreatetime(String createtime) {
				this.createtime = createtime;
			 }
			 
			 public String getAreacode() {
				return areacode;
			 }
			 public void setAreacode(String areacode) {
				this.areacode = areacode;
			 }
			 
			 public int getProviceid() {
				return proviceid;
			}
			public void setProviceid(int proviceid) {
				this.proviceid = proviceid;
			}
			public int getCityid() {
				return cityid;
			}
			public void setCityid(int cityid) {
				this.cityid = cityid;
			}
			public int getCreditid() {
				return creditid;
			}
			public void setCreditid(int creditid) {
				this.creditid = creditid;
			}
			public int getEvaluategood() {
				return evaluategood;
			}
			public void setEvaluategood(int evaluategood) {
				this.evaluategood = evaluategood;
			}
			public int getEvaluatecommon() {
				return evaluatecommon;
			}
			public void setEvaluatecommon(int evaluatecommon) {
				this.evaluatecommon = evaluatecommon;
			}
			public int getEvaluatebad() {
				return evaluatebad;
			}
			public void setEvaluatebad(int evaluatebad) {
				this.evaluatebad = evaluatebad;
			}
			public int getIslocalreg() {
				return islocalreg;
			}
			public void setIslocalreg(int islocalreg) {
				this.islocalreg = islocalreg;
			}
			public int getIssuportgoods() {
				return issuportgoods;
			}
			public void setIssuportgoods(int issuportgoods) {
				this.issuportgoods = issuportgoods;
			}
			public int getIsdelivery() {
				return isdelivery;
			}
			public void setIsdelivery(int isdelivery) {
				this.isdelivery = isdelivery;
			}
			public int getIsmargin() {
				return ismargin;
			}
			public void setIsmargin(int ismargin) {
				this.ismargin = ismargin;
			}
			public int getIsteam() {
				return isteam;
			}
			public void setIsteam(int isteam) {
				this.isteam = isteam;
			}
			public int getPayduty() {
				return payduty;
			}
			public void setPayduty(int payduty) {
				this.payduty = payduty;
			}
			public int getBrandtransfer() {
				return brandtransfer;
			}
			public void setBrandtransfer(int brandtransfer) {
				this.brandtransfer = brandtransfer;
			}
			public int getUserid() {
				return userid;
			}
			public int getDeposittype() {
				return deposittype;
			}
			public int getMalltypeid() {
				return malltypeid;
			}
			public int getBrandcategoryid() {
				return brandcategoryid;
			}
			public int getIsloan() {
				return isloan;
			}
			public int getCollectcount() {
				return collectcount;
			}
			public void setIstrade(int istrade) {
				this.istrade = istrade;
			}
			public int getDepositmoney() {
				return depositmoney;
			}
			public void setDepositmoney(int depositmoney) {
				this.depositmoney = depositmoney;
			}
			public int getTechfee() {
				return techfee;
			}
			public void setTechfee(int techfee) {
				this.techfee = techfee;
			}
			public double getTechfeeratio() {
				return techfeeratio;
			}
			public void setTechfeeratio(double techfeeratio) {
				this.techfeeratio = techfeeratio;
			}    
}
