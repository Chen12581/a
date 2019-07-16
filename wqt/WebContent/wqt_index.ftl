<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>万企通，知识产权与企业服务一站式服务平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="baidu-site-verification" content="QIdo8zh0Ea" />
    <meta name="keywords" content="知识产权交易，商标转让，商标注册，专利申请，版权登记，工商财税，网站开发，网站建设，营销推广，微信小程序开发，金融服务，网店转让">
    <meta name="Description" content="万企通一站式企业服务平台，为企业提供知识产权交易，商标转让，商标注册，专利申请，版权登记，代理记账，注册公司，网店转让，网站开发建设，营销推广，金融服务，微信小程序开发服务，专业提供知识产权与企业服务资源共享平台，布局企业生态全周期服务的一站式网站。">
    <meta name="360-site-verification" content="5e75c7b6551393a2b4471153af6195c8" />
	<meta name="baidu-site-verification" content="ss5gqOxgdr" />
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/css/animate.min.css">
    <link rel="stylesheet" href="/css/wqt_index.css">
    <link rel="stylesheet" href="/templates/css/footer.css">
    <script>
    //百度推送
    	(function(){
        		var bp = document.createElement('script');
        		var curProtocol = window.location.protocol.split(':')[0];
        		if (curProtocol === 'https') {
            		bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
        		}else {
            		bp.src = 'http://push.zhanzhang.baidu.com/push.js';
        		}
        		var s = document.getElementsByTagName("script")[0];
        		s.parentNode.insertBefore(bp, s);
    	})();
    //百度统计
                    var _hmt = _hmt || [];
                    (function() {
                      var hm = document.createElement("script");
                      hm.src = "https://hm.baidu.com/hm.js?e97b0d63dc2f6999abf0ec6dc77b6596";
                      var s = document.getElementsByTagName("script")[0];
                      s.parentNode.insertBefore(hm, s);
                    })();
    </script>
</head>
<body>
    <div class="header">
        <div class="top">
            <div class="top_box clear">
                 <#if wqtuser?exists>
                 <div class="top_left">
                    <p class="welcome">${wqtuser.username?if_exists},欢迎来到万企通平台！</p>
                    <p class="entry">
                        <a href="/user/center" class="login_entry" target="_blank" style="color:#336699">个人中心</a>
                        <a href="javascript:;" id="logout" class="register_entry">退出</a>
                    </p>
                </div>
                <#else>
                <div class="top_left">
                    <p class="welcome">欢迎来到万企通知识产权服务平台！</p>
                    <p class="entry">
                        <a href="http://www.w7tong.com/user/login.html?service=" id="login">登录</a>
                        <a href="http://www.w7tong.com/user/register.html?service=" id="register" class="register_entry">免费注册</a>
                    </p>
                </div>
                </#if>
                <div class="top_right">
                    <ul class="top_menu">
                        <li><a href="http://www.w7tong.com/helpcenter/about.html" target="_blank">关于我</a></li>
                        <li><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">在线客服</a></li>
                        <li><a href="http://www.w7tong.com/user/helpcenter.html" target="_blank">帮助中心</a></li>
                    </ul>
                    <div class="hot_tel">热线：<span>400-611-8288</span></div>
                </div>
            </div>
        </div>
        <div class="bottom">
            <div class="bottom_box clear">
                <div class="logo"><a href="" target="_blank"><img src="/templates/image/header/logo.png" alt=""></a></div>
                <div class="nav">
                    <ul>
                        <li class="on"><a href="http://www.w7tong.com/">首页</a></li>
                        <li><a href="http://ipr.w7tong.com/iprtrade"  target="_blank">交易市场</a></li>
                        <li><a href="http://ipr.w7tong.com/shop/brandshop.html"  target="_blank">商标转让</a></li>
                        <li><a href="http://wd.w7tong.com"  target="_blank">天猫转让</a></li>
                        <li class="center"><a href="http://es.w7tong.com/trade/company---------------------1.html"  target="_blank">企业转让</a></li>
                        <li class="qyfw">
                            <a href="http://es.w7tong.com" target="_blank">企业服务</a>
                            <div class="qyfw_drop">
                                <p><a href="http://es.w7tong.com/csfw/dljz1.html" target="_blank">财税服务</a></p>
                                <p><a href="http://es.w7tong.com/gsfw/gsbg1.html" target="_blank">工商服务</a></p>
                            </div>
                        </li>
                        <li class="zscq">
                            <a href="http://ipr.w7tong.com" target="_blank">知识产权</a>
                            <div class="zscq_drop">
                                <p><a href="http://ipr.w7tong.com/brand/ptzc.html" target="_blank">商标注册</a></p>
                                <p><a href="http://ipr.w7tong.com/patent/fmsq.html" target="_blank">专利申请</a></p>
                                <p><a href="http://ipr.w7tong.com/copyright/bqjj.html" target="_blank">版权登记</a></p>
                                <p><a href="http://ipr.w7tong.com/" target="_blank">商标设计</a></p>
                            </div>
                        </li>
                        <li class="wdfw">
                            <a href="http://wd.w7tong.com" target="_blank">网店服务</a>
                            <div class="wdfw_drop">
                                <p><a href="http://wd.w7tong.com/enter.html" target="_blank">商城代入驻</a></p>
                                <p><a href="http://wd.w7tong.com/tmall.html" target="_blank">天猫转让</a></p>
                                <p><a href="http://wd.w7tong.com/sell.html" target="_blank">天猫出售</a></p>
                                <p><a href="http://wd.w7tong.com/tmall.html" target="_blank">购买天猫</a></p>
                            </div>
                        </li>
                        <li class="hlfw">
                            <a href="" class="develop">互联服务</a>
                            <div class="hlfw_drop">
                                <p><a href="" class="develop">网站建设</a></p>
                                <p><a href="" class="develop">定制APP</a></p>
                                <p><a href="" class="develop">微信开发</a></p>
                                <p><a href="" class="develop">小程序开发</a></p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="banner">
           <div class="caption w-wqt">
               <p class="cap-tit">万企通，您的专业合作伙伴</p>
               <div class="notice">
                   <div class="notice_content">公告：万企通新版首页、企业服务分站上线公告</div>
               </div>
           </div> 
           <div class="tab_box w-wqt">
               <div class="tab_title">
                   <ul class="clear">
                       <li class="on">
                           <a href="javascript:;">热门服务<span>助力您的企业高速成长</span></a>
                        </li>
                       <li>
                           <a href="javascript:;">交易市场<span>汇聚优质资源，交易安心</span></a>
                        </li>
                       <li>
                           <a href="javascript:;">咨询顾问<span>资深客服，专业可信赖</span></a>
                        </li>
                   </ul>
               </div>
               <div class="tab_content">
                   <div class="box_lists">
                       <div class="select_box clear">
                           <label class="lab" for="keywords1"></label>
                           <input type="text" id="keywords1" placeholder="请输入搜索关键字信息进行搜索如：天猫旗舰店&nbsp;  商标注册&nbsp;  包装设计&nbsp;  网站建设&nbsp;  企业店铺&nbsp;  淘宝/天猫代入驻">
                           <div class="box_btn"><a class="select btn_hot" href="javascript:;"></a></div>
                       </div>
                       <div class="tab_module clear">
                           <div class="zscq_box">
                               <h2 class="box_tit">知识产权</h2>
                               <ul class="lists_box clear">
                                   <li class="li1">
                                        <a class="lists_tit" href="http://ipr.w7tong.com/brand/ptzc.html" target="_blank">商标注册</a>
                                        <p class="lit_tit"><a href="http://ipr.w7tong.com/brand/ptzc.html" target="_blank">普通</a>/
                                        <a href="http://ipr.w7tong.com/brand/jjzc.html" target="_blank">加急</a>/<a href="http://ipr.w7tong.com/brand/wyzc.html" target="_blank">无忧</a></p>
                                   </li>
                                   <li class="li2">
                                        <a class="lists_tit" href="http://ipr.w7tong.com/patent/fmsq.html" target="_blank">专利申请</a>
                                        <p class="lit_tit"><a href="http://ipr.w7tong.com/patent/fmsq.html" target="_blank">全面</a>/
                                        <a href="http://ipr.w7tong.com/patent/fmsq.html" target="_blank">专业</a>/
                                        <a href="http://ipr.w7tong.com/patent/fmsq.html" target="_blank">评估</a></p>
                                   </li>
                                   <li class="li3">
                                        <a class="lists_tit" href="http://ipr.w7tong.com/shop/brandshop.html" target="_blank">商标转让</a>
                                        <p class="lit_tit"><a href="http://ipr.w7tong.com/ipr/shop/brandshop-25----------1.html" target="_blank">服装鞋帽</a>/
                                        <a href="http://ipr.w7tong.com/ipr/shop/brandshop-03----------1.html" target="_blank">日化</a></p>
                                   </li>
                                   <li class="li4">
                                        <a class="lists_tit" href="http://ipr.w7tong.com/copyright/bqjj.html" target="_blank">版权登记</a>
                                        <p class="lit_tit"><a href="http://ipr.w7tong.com/copyright/rjzzq.html" target="_blank">软件</a>/
                                        <a href="http://ipr.w7tong.com/copyright/mszp.html" target="_blank">美术</a>/
                                        <a href="http://ipr.w7tong.com/copyright/wzzp.html" target="_blank">文字</a></p>
                                   </li>
                                   <li class="li5">
                                        <a class="lists_tit" href="" target="_blank" >商标设计</a>
                                        <p class="lit_tit"><a href="" target="_blank">提供3款设计方案</a></p>
                                   </li>
                                   <li class="li6">
                                        <a class="lists_tit" href="http://ipr.w7tong.com/patentmark/patent.html" target="_blank">专利转让</a>
                                        <p class="lit_tit"><a href="http://ipr.w7tong.com/patentmark/patent--1---------1.html" target="_blank">发明</a>/
                                        <a href="http://ipr.w7tong.com/ipr/patentmark/patent--2---------1.html" target="_blank">实用</a>/
                                        <a href="http://ipr.w7tong.com/ipr/patentmark/patent--3---------1.html" target="_blank">外观</a></p>
                                   </li>
                               </ul>
                           </div>
                           <div class="qyfw_box">
                                <h2 class="box_tit">企业服务</h2>
                                <ul class="lists_box clear">
                                    <li class="li7">
                                         <a class="lists_tit" href="http://es.w7tong.com/csfw/dljz1.html" target="_blank">财税服务</a>
                                         <p class="lit_tit"><a href="http://es.w7tong.com/csfw/dljz2.html" target="_blank">一般</a>/
                                         <a href="http://es.w7tong.com/csfw/dljz1.html" target="_blank">纳税人</a></p>
                                    </li>
                                    <li class="li8">
                                         <a class="lists_tit" href="http://es.w7tong.com/gsfw/gszc1.html" target="_blank">工商服务</a>
                                         <p class="lit_tit"><a href="http://es.w7tong.com/gsfw/gszc1.html" target="_blank">注册</a>/
                                         <a href="http://es.w7tong.com/gsfw/gsbg1.html" target="_blank">变更</a>/
                                         <a href="http://es.w7tong.com/gsfw/gszx.html" target="_blank">注销</a></p>
                                    </li>
                                    <li class="li9">
                                         <a class="lists_tit" href="http://es.w7tong.com/csfw/dljz1.html" target="_blank">代理记账</a>
                                         <p class="lit_tit"><a href="http://es.w7tong.com/csfw/dljz1.html" target="_blank">申报</a>/
                                         <a href="http://es.w7tong.com/csfw/dljz5.html" target="_blank">旧账梳理</a></p>
                                    </li>
                                    <li class="li10">
                                         <a class="lists_tit" href="http://es.w7tong.com/gsfw/gszc1.html" target="_blank">公司注册</a>
                                         <p class="lit_tit"><a href="http://es.w7tong.com/gsfw/gszc1.html" target="_blank">合伙企业</a>/<a href="http://es.w7tong.com/gsfw/gszc1.html" target="_blank">分公司</a></p>
                                    </li>
                                </ul>
                           </div>
                           <div class="wdfw_box">
                               <h2 class="box_tit">网店服务</h2>
                               <ul class="lists_box clear">
                                   <li class="li11">
                                        <a class="lists_tit" href="http://wd.w7tong.com/" target="_blank">购买网店</a>
                                        <p class="lit_tit"><a href="http://wd.w7tong.com/tmall.html" target="_blank">天猫</a>/
                                        <a href="http://wd.w7tong.com/jd.html" target="_blank"target="_blank">京东</a>/
                                        <a href="http://wd.w7tong.com/taobao.html" target="_blank">淘宝</a></p>
                                   </li>
                                   <li class="li12">
                                        <a class="lists_tit" href="http://wd.w7tong.com/sell.html" target="_blank">出售网店</a>
                                        <p class="lit_tit"><a href="http://wd.w7tong.com/sell.html" target="_blank">天猫</a>/
                                        <a href="http://wd.w7tong.com/sell.html" target="_blank">京东</a>/
                                        <a href="http://wd.w7tong.com/sell.html" target="_blank">淘宝</a></p>
                                   </li>
                                   <li class="li13">
                                        <a class="lists_tit" href="http://wd.w7tong.com/enter.html" target="_blank">商城代入驻</a>
                                        <p class="lit_tit"><a href="http://wd.w7tong.com/enter.html" target="_blank">天猫</a>/
                                        <a href="http://wd.w7tong.com/enter.html" target="_blank">京东</a>/
                                        <a href="http://wd.w7tong.com/enter.html" target="_blank">淘宝</a></p>
                                   </li>
                                   <li class="li14">
                                        <a class="lists_tit" href="http://wd.w7tong.com/assess.html" target="_blank">网店估价</a>
                                        <p class="lit_tit"><a href="http://wd.w7tong.com/assess.html" target="_blank">便捷</a>/
                                        <a href="http://wd.w7tong.com/assess.html" target="_blank">权威</a>/
                                        <a href="http://wd.w7tong.com/assess.html" target="_blank">保障</a></p>
                                   </li>
                               </ul>
                           </div>
                           <div class="hlfw_box">
                                <h2 class="box_tit last_box_tit">互联服务</h2>
                                <ul class="lists_box clear">
                                    <li class="li15">
                                         <a class="lists_tit develop" href="" >网站交易</a>
                                         <p class="lit_tit"><a href="" class="develop">微商城</a>/
                                         <a href="" class="develop">微官网</a></p>
                                    </li>
                                    <li class="li16">
                                         <a class="lists_tit develop" href="" >网站建设</a>
                                         <p class="lit_tit"><a href="" class="develop">响应式</a>/
                                         <a href="" class="develop">电商</a>/
                                         <a href="" class="develop">门户</a></p>
                                    </li>
                                    <li class="li17">
                                         <a class="lists_tit develop" href="">小程序开发</a>
                                         <p class="lit_tit"><a href="" class="develop">定制</a>/
                                         <a href="" class="develop">设计选代</a></p>
                                    </li>
                                    <li class="li18">
                                         <a class="lists_tit develop" href="">定制APP</a>
                                         <p class="lit_tit"><a href="" class="develop">Ios</a>/
                                         <a href="" class="develop">Android</a></p>
                                    </li>
                                </ul>
                           </div>
                       </div>
                   </div>
                   <div class="box_lists" style="display:none">
                        <div class="select_box clear">
                            <label class="lab" for="keywords2"></label>
                            <input type="text" id="keywords2" placeholder="请输入搜索关键字信息进行搜索如：天猫旗舰店&nbsp;  商标注册&nbsp;  包装设计&nbsp;  网站建设&nbsp;  企业店铺&nbsp;  淘宝/天猫代入驻">
                            <div class="box_btn"><a class="select btn_trade" href="javascript:;" ></a></div>
                        </div>
                        <div class="tab_module trade clear">
                            <div class="zscq_box">
                                <h2 class="box_tit">知识产权</h2>
                                <ul class="lists_box clear">
                                    <li class="li1">
                                         <a class="lists_tit" href="http://ipr.w7tong.com/copyrightmark/copyright.html" target="_blank">版权交易</a>
                                         <p class="lit_tit"><a href="http://ipr.w7tong.com/copyrightmark/copyright-5----------1.html" target="_blank">软著</a>/
                                         <a href="http://ipr.w7tong.com/ipr/copyrightmark/copyright-4----------1.html" target="_blank">美术</a>/<a href="http://ipr.w7tong.com/copyrightmark/copyright-1----------1.html" target="_blank">文字</a></p>
                                    </li>
                                    <li class="li2">
                                         <a class="lists_tit" href="" target="_blank">特价商标</a>
                                         <p class="lit_tit"><a href="" target="_blank">爆款来袭购优惠</a></p>
                                    </li>
                                    <li class="li3">
                                         <a class="lists_tit" href="http://ipr.w7tong.com/shop/brandshop.html" target="_blank">商标转让</a>
                                         <p class="lit_tit"><a href="http://ipr.w7tong.com/shop/brandshop-25----------1.html" target="_blank">服装鞋帽</a>/
                                         <a href="http://ipr.w7tong.com/shop/brandshop-03----------1.html" target="_blank">日化</a></p>
                                    </li>
                                    <li class="li4">
                                         <a class="lists_tit" href="http://ipr.w7tong.com/patentmark/patent--3---------1.html" target="_blank">外观专利</a>
                                         <p class="lit_tit"><a href="http://ipr.w7tong.com/patentmark/patent-3-1---------1.html" target="_blank">家具用品</a>/<a href="http://ipr.w7tong.com/patentmark/patent-20-1---------1.html" target="_blank">机械</a></p>
                                    </li>
                                    <li class="li5">
                                         <a class="lists_tit" href="http://ipr.w7tong.com/patentmark/patent--1---------1.html" target="_blank">发明专利</a>
                                         <p class="lit_tit"><a href="http://ipr.w7tong.com/patentmark/patent-8-1---------1.html" target="_blank">新能源</a>/<a href="http://ipr.w7tong.com/patentmark/patent-22-1---------1.html" target="_blank">安全防护</a></p>
                                    </li>
                                    <li class="li6">
                                         <a class="lists_tit" href="http://ipr.w7tong.com/patentmark/patent.html" target="_blank">专利转让</a>
                                         <p class="lit_tit"><a href="http://ipr.w7tong.com/patentmark/patent--1---------1.html" target="_blank">发明</a>/
                                         <a href="http://ipr.w7tong.com/ipr/patentmark/patent--2---------1.html" target="_blank">实用</a>/
                                         <a href="http://ipr.w7tong.com/ipr/patentmark/patent--3---------1.html" target="_blank">外观</a></p>
                                    </li>
                                </ul>
                            </div>
                            <div class="gszr_box">
                                 <h2 class="box_tit">公司转让</h2>
                                 <ul class="lists_box clear">
                                     <li class="li7">
                                          <a class="lists_tit" href="http://es.w7tong.com/trade/company.html" target="_blank">公司转让</a>
                                          <p class="lit_tit"><a href="http://es.w7tong.com/trade/company---1------------------1.html" target="_blank">贸易类</a>/
                                          <a href="http://es.w7tong.com/trade/company---2---------------1---1.html" target="_blank">工程类</a></p>
                                     </li>
                                     <li class="li8">
                                          <a class="lists_tit" href="http://es.w7tong.com/trade/company.html" target="_blank">特价公司</a>
                                          <p class="lit_tit"><a href="http://es.w7tong.com/trade/company---6------------------1.html" target="_blank">管理类</a>/<a href="http://es.w7tong.com/trade/company---7---------------1---1.html" target="_blank">产品类</a></p>
                                     </li>
                                     <li class="li9">
                                          <a class="lists_tit" href="http://es.w7tong.com/trade/company----------------106-----1.html" target="_blank">资质转让</a>
                                          <p class="lit_tit"><a href="http://es.w7tong.com/trade/company----------------106-----1.html" target="_blank">买资质</a>/<a href="http://es.w7tong.com/trade/company----------------106-----1.html" target="_blank">卖资质</a></p>
                                     </li>
                                     <li class="li10">
                                          <a class="lists_tit" href="http://es.w7tong.com/trade/company.html" target="_blank">限公司注册</a>
                                          <p class="lit_tit"><a href="http://es.w7tong.com/trade/company---14---------------1---1.html"  target="_blank">房产类</a>/<a href="http://es.w7tong.com/trade/company---15---------------1---1.html" target="_blank">金融类</a></p>
                                     </li>
                                 </ul>
                            </div>
                            <div class="wdzr_box">
                                <h2 class="box_tit">网店转让</h2>
                                <ul class="lists_box clear">
                                    <li class="li11">
                                         <a class="lists_tit" href="http://wd.w7tong.com/tmall.html" target="_blank">天猫转让</a>
                                         <p class="lit_tit"><a href="http://wd.w7tong.com/tmall/tm--1----------------1.html" target="_blank">旗舰店</a>/<a href="http://wd.w7tong.com/tmall/tm--2----------------1.html" target="_blank">专营店</a></p>
                                    </li>
                                    <li class="li12">
                                         <a class="lists_tit" href="http://wd.w7tong.com/jd.html">京东转让</a>
                                         <p class="lit_tit"><a href="http://wd.w7tong.com/jd/jd--4---------------1.html" target="_blank">优创店</a>/<a href="http://wd.w7tong.com/jd/jd--5---------------1.html" target="_blank">全球购</a></p>
                                    </li>
                                    <li class="li13">
                                         <a class="lists_tit" href="http://wd.w7tong.com/enter.html" target="_blank">商城代入驻</a>
                                         <p class="lit_tit"><a href="http://wd.w7tong.com/enter.html" target="_blank">天猫</a>/
                                         <a href="http://wd.w7tong.com/enter.html" target="_blank">京东</a>/
                                         <a href="http://wd.w7tong.com/enter.html" target="_blank">淘宝</a></p>
                                    </li>
                                    <li class="li14">
                                         <a class="lists_tit" href="http://wd.w7tong.com/taobao.html" target="_blank">淘宝网店</a>
                                         <p class="lit_tit"><a href="http://wd.w7tong.com/taobao/tb---1---------------1.html" target="_blank">钻级</a>/
                                         <a href="http://wd.w7tong.com/taobao/tb---6---------------1.html" target="_blank">皇冠</a>/
                                         <a href="http://wd.w7tong.com/taobao/tb---11---------------1.html" target="_blank">金冠</a></p>
                                    </li>
                                </ul>
                            </div>
                            <div class="hlfw_box">
                                 <h2 class="box_tit last_box_tit">互联服务</h2>
                                 <ul class="lists_box clear">
                                     <li class="li15">
                                          <a class="lists_tit develop" href="">网站交易</a>
                                          <p class="lit_tit"><a href="" class="develop">门户</a>/<a href="" class="develop">企业官网</a></p>
                                     </li>
                                     <li class="li16">
                                          <a class="lists_tit develop" href="">网站定制</a>
                                          <p class="lit_tit"><a href="" class="develop">企业</a>/
                                          <a href="" class="develop">商城</a>/
                                          <a href="" class="develop">门户</a></p>
                                     </li>
                                     <li class="li17">
                                          <a class="lists_tit develop" href="" target="_blank">APP交易</a>
                                          <p class="lit_tit"><a href="" class="develop">购物</a>/<a href="" class="develop">点餐</a>/<a href="" class="develop">社交</a></p>
                                     </li>
                                     <li class="li18">
                                          <a class="lists_tit develop" href="">APP定制</a>
                                          <p class="lit_tit"><a href="" class="develop">购物</a>/<a href="" class="develop">影音</a>/<a href="" class="develop">办公</a></p>
                                     </li>
                                 </ul>
                            </div>
                        </div>
                   </div>
                   <div class="box_lists clear" style="display:none">
                       <div class="adviser_box">
                           <ul class="fw_types clear">
                               <li class="on">企业服务</li>
                               <li>知识产权</li>
                               <li>网店服务</li>
                               <li>互联服务</li>
                           </ul>
                           <div class="photo_box clear">
                              <#if indexData.l_esWorker?exists>
                                 <#list indexData.l_esWorker as esWorker>
		                               <div class="photo_lists">
		                                   <div class="img"><img src="${esWorker.headurl?if_exists}" alt=""></div>
		                                   <div class="summary">
		                                       <h2 class="kname">${esWorker.workername?if_exists}</h2>
		                                       <p class="rank">金牌顾问</p>
		                                       <p class="skilled">擅长：企业交易&nbsp;工商服务</p>
		                                       <a class="consult_btn" href="tencent://message/?uin=${esWorker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">在线咨询</a>
		                                   </div>
		                               </div>
		                          </#list>
                              </#if>  
                           </div>
                           <div class="photo_box clear" style="display:none">
                              <#if indexData.l_iprWorker?exists>
                                 <#list indexData.l_iprWorker as iprWorker>
		                               <div class="photo_lists">
		                                   <div class="img"><img src="${iprWorker.headurl?if_exists}" alt=""></div>
		                                   <div class="summary">
		                                       <h2 class="kname">${iprWorker.workername?if_exists}</h2>
		                                       <p class="rank">金牌顾问</p>
		                                       <p class="skilled">擅长：知产交易&nbsp;商标注册</p>
		                                       <a class="consult_btn" href="tencent://message/?uin=${iprWorker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">在线咨询</a>
		                                   </div>
		                               </div>
		                          </#list>
                              </#if>  
                           </div>
                           <div class="photo_box clear" style="display:none">
                              <#--  <#if indexData.l_Worker?exists>
                                 <#list indexData.l_Worker as wqtWorker>
		                               <div class="photo_lists">
		                                   <div class="img"><img src="${wqtWorker.headurl?if_exists}" alt=""></div>
		                                   <div class="summary">
		                                       <h2 class="kname">${wqtWorker.workername?if_exists}</h2>
		                                       <p class="rank">金牌顾问</p>
		                                       <p class="skilled">擅长：企业交易&nbsp;电商入驻</p>
		                                       <a class="consult_btn" href="tencent://message/?uin=${wqtWorker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">在线咨询</a>
		                                   </div>
		                               </div>
		                          </#list>
                              </#if>    -->
                              <img src="/image/wqt_index/kf.png" style="width:679px;height:380px;">
                           </div>
                           <div class="photo_box clear" style="display:none">
                              <#--  <#if indexData.l_Worker?exists>
                                 <#list indexData.l_Worker as wqtWorker>
		                               <div class="photo_lists">
		                                   <div class="img"><img src="${wqtWorker.headurl?if_exists}" alt=""></div>
		                                   <div class="summary">
		                                       <h2 class="kname">${wqtWorker.workername?if_exists}</h2>
		                                       <p class="rank">金牌顾问</p>
		                                       <p class="skilled">擅长：企业交易&nbsp;电商入驻</p>
		                                       <a class="consult_btn" href="tencent://message/?uin=${wqtWorker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">在线咨询</a>
		                                   </div>
		                               </div>
		                          </#list>
                              </#if>    -->
                              <img src="/image/wqt_index/kf.png" style="width:679px;height:380px;">
                           </div>
                       </div>
                       <div class="form_box">
                           <h2>提交您的需求我们直接联系您！</h2>
                           <input type="text" id="name" class="username" placeholder="姓名">
                           <input type="tel" id="phoneNumber" class="phone" maxlength="11" placeholder="电话">
                           <textarea name="remark" id="remark" class="titleremark" rows="5" cols="30" placeholder="请输入您的需求或想咨询的问题"></textarea>
                           <a class="issue" href="javascript:;" >立即发布</a>
                           <div class="hot_need">
                               <h4>热门需求</h4>
                               <ul class="need_lists clear">
                                   <li><a href="http://es.w7tong.com/gsfw/gszc1.html" target="_blank">公司注册</a></li>
                                   <li><a href="http://ipr.w7tong.com/shop/brandshop.html" target="_blank">商标购买</a></li>
                                   <li><a href="http://ipr.w7tong.com/copyrightseek.html" target="_blank">版权登记</a></li>
                                   <li><a href="http://ipr.w7tong.com/patentmark/patent.html" target="_blank">专利转让</a></li>
                                   <li><a href="http://ipr.w7tong.com/brandseek.html" target="_blank">商标注册</a></li>
                                   <li><a href="http://wd.w7tong.com/">网店交易</a></li>
                                   <li><a href="" class="develop">微信开发</a></li>
                                   <li><a href="" class="develop">网站建设</a></li>
                                   <li><a href="http://es.w7tong.com/gsfw/dljz1.html" target="_blank">代理记账</a></li>
                               </ul>
                           </div>
                       </div>
                   </div>
               </div>
           </div>
        </div>
        <!-- 市场交易 -->
        <div class="market w-wqt">
            <div class="title pad-wqt1">
                <h2 class="zh-tit">交易市场</h2>
                <p class="en-tit">TRADING MARKET</p>
            </div>
            <div class="market_box">
                <div class="market_list list_y1 clear">
                    <div class="list_left">
                        <div class="type_tit">
                            <h2 class="big_tit">知识产权</h2>
                            <p class="icon"></p>
                            <p class="small_tit">商标转让就上万企通</p>
                        </div>
                        <ul class="attorn_list">
                            <li class="on"><a href="http://ipr.w7tong.com/shop/brandshop.html" target="_blank">商标转让<i class="jiantou-r"></i></a></li>
                            <li><a href="http://ipr.w7tong.com/patentmark/patent.html" target="_blank">专利转让<i class="jiantou-r"></i></a></li>
                            <li><a href="http://ipr.w7tong.com/copyrightmark/copyright.html" target="_blank">版权转让<i class="jiantou-r"></i></a></li>
                        </ul>
                        <div class="blank"></div>
                        <a class="more" href="http://ipr.w7tong.com/shop/brandshop.html" target="_blank">查看更多<i class="jiantou-r"></i></a>
                    </div>
                    <div class="list_right">
                        <div class="right_lists clear">
                          <#if indexData.l_brandShop?exists>
                                 <#list indexData.l_brandShop as brandShop>
				                        <a href="http://ipr.w7tong.com/${brandShop.htmlpath?if_exists}" class="zhuanli list_lists" target="_blank">
                                            <div class="img"><img src="${brandShop.brandshopphoto?if_exists}" alt=""></div>
				                            <h2 class="name_title" title="${brandShop.brandname?if_exists}">${brandShop.brandname?if_exists}</h2>
				                            <p class="genre"  title="第${brandShop.brandkind?if_exists?substring(0,2)}类-${brandShop.kindname?if_exists}">类<i class="icon-width"></i>别：第${brandShop.brandkind?if_exists?substring(0,2)}类-${brandShop.kindname?if_exists}</p>
				                            <p class="suit" title="${brandShop.itemnames?if_exists}">适用项目：
				                               <#if brandShop.itemnames?exists>
				                                  <#if brandShop.itemnames?length gt 15>
				                                      ${brandShop.itemnames?substring(0,12)}....
				                                  <#else>
				                                      ${brandShop.itemnames?if_exists}
				                                  </#if> 
				                                </#if> 
				                                 
				                            </p>
				                            <p class="sell_price">售<i class="icon-width"></i>价：<span>&yen;${brandShop.price?if_exists}元</span></p>
				                        </a>
                                </#list>
                           </#if> 
                        </div>
                        <div class="right_lists clear" style="display:none">
                           <#if indexData.l_patentShop?exists>
                             <#list indexData.l_patentShop as patentShop>
	                            <a href="http://ipr.w7tong.com/${patentShop.htmlpath?if_exists}" class="list_lists" target="_blank">
	                                <h2 class="name_title" title="${patentShop.patentname?if_exists}">${patentShop.patentname?if_exists}</h2>
	                                <p class="genre">行<i class="icon-width"></i>业：${patentShop.kindname?if_exists}</p>
	                                <p class="suit">专利类型：
	                                    <#if patentShop.patenttype?exists>
	                                          <#if patentShop.patenttype?string=='1'>
	                                         发明专利
	                                          <#elseif patentShop.patenttype?string=='2'>
	                                           实用新型
	                                          <#elseif patentShop.patenttype?string=='3'>
	                                           外观设计
	                                          <#else>
	                                            发明专利
	                                          </#if> 
	                                    </#if> 
	                                </p>
	                                <p class="sell_price">售<i class="icon-width"></i>价：
										<span>&yen;
										<#if patentShop.price?exists>
											  <#if patentShop.price?number==0>
												面议
											  <#else>
												${patentShop.price?if_exists}元
											  </#if>
										</#if>
										</span>
									</p>
	                            </a>
		                      </#list>
                           </#if> 
                        </div>
                        <div class="right_lists clear" style="display:none">
                           <#if indexData.l_copyrightShop?exists>
                                 <#list indexData.l_copyrightShop as copyrightShop>
		                             <a href="http://ipr.w7tong.com/${copyrightShop.htmlpath?if_exists}" class="list_lists" target="_blank">
		                                <h2 class="name_title" title="${copyrightShop.copyrightname?if_exists}">${copyrightShop.copyrightname?if_exists}</h2>
		                                <p class="genre">类<i class="icon-width"></i>别：第${copyrightShop.copyrightkind?if_exists}类-${copyrightShop.copyrightkindname?if_exists}</p>
		                                <p class="suit"></p>
		                                <p class="sell_price">售<i class="icon-width"></i>价：<span>&yen;${copyrightShop.price?if_exists}元</span></p>
		                             </a>
                                 </#list>
                           </#if> 
                        </div>
                       
                    </div>
                </div>
                
                <div class="market_list list_y2 clear" style="margin-top:40px;">
                    <div class="list_left">
                        <div class="type_tit">
                            <h2 class="big_tit">公司转让</h2>
                            <p class="icon"></p>
                            <p class="small_tit">明码标价，拒绝差价</p>
                        </div>
                        <ul class="attorn_list">
                            <li class="on"><a href="http://es.w7tong.com/trade/company.html" target="_blank">公司转让<i class="jiantou-r"></i></a></li>
                          
                        </ul>
                        <div class="blank-l"></div>
                        <a class="more" href="http://es.w7tong.com/trade/company---------------------1.html" target="_blank">查看更多<i class="jiantou-r"></i></a>
                    </div>
                    <div class="list_right">
                      <#if indexData.l_tradeShop?exists>
                           <#list indexData.l_tradeShop as tradeShop>
		                        <a href="http://es.w7tong.com/${tradeShop.htmlpath?if_exists}" class="list_lists" target="_blank">
		                            <h2 class="name_title" title="${tradeShop.companyname?if_exists}">${tradeShop.companyname?if_exists}</h2>
		                            <p class="genre">企业行业：${tradeShop.industryname?if_exists}</p>
		                            <p class="suit">纳税类型：
		                                <#if tradeShop.dutytype?exists>
	                                          <#if tradeShop.dutytype?string=='1'>
	                                        小规模纳税人
	                                          <#elseif tradeShop.dutytype?string=='2'>
	                                           一般纳税人
	                                          <#elseif tradeShop.dutytype?string=='3'>
	                                           出口纳税人
	                                          <#else>
	                                            未核税
	                                          </#if> 
	                                    </#if> 
		                          </p>
		                            <p class="sell_price">售<i class="icon-width"></i>价：<span>&yen;${tradeShop.price?if_exists}元</span></p>
		                        </a>
                          </#list>
                     </#if> 
                    </div>
                </div>
                
            </div>
        </div>
        <!-- 热门服务 -->
        <div class="hot">
            <div class="hot_service w-wqt">
                <div class="title pad-wqt1">
                    <h2 class="zh-tit">热门服务</h2>
                    <p class="en-tit">HOT SERVICE</p>
                </div>
                <div class="hot_list clear">
                    <div class="hot_lists lists_1">
                        <div class="lists_tit">
                            <h2 class="zh-tit">知识产权<i class="icon_jiantou"></i></h2>
                            <p class="icon"></p>
                            <p class="en-tit">intellectual property right</p>
                        </div>
                        <div style="box-shadow: 0px 1px 8px 0px rgba(178, 178, 178, 0.75);">
                            <div class="service_type">
                                <a href="http://ipr.w7tong.com/brand/ptzc.html" class="big_tit" target="_blank">商标普通注册</a>
                                <p class="small_tit">开启你的品牌之路</p>
                                <p class="icon"></p>
                                <a href="http://ipr.w7tong.com/brand/ptzc.html" class="lookdel" target="_blank">查看详情 <i class="trigon-r"></i></a>
                            </div>
                            <div class="type_list clear">
                                <div class="type_lists">
                                    <a href="http://ipr.w7tong.com/brand/ptzc.html" class="lists_tit" target="_blank">商标注册</a>
                                    <p class="lit_tit"><a href="http://ipr.w7tong.com/brand/gjzc.html" target="_blank">国际商标</a>/<a href="http://ipr.w7tong.com/brand/bg.html" target="_blank">商标变更</a></p>
                                </div>
                                <div class="type_lists">
                                    <a href="http://ipr.w7tong.com/patent/fmsq.html" class="lists_tit" target="_blank">专利申请</a>
                                    <p class="lit_tit"><a href="http://ipr.w7tong.com/patentmark/patent.html" target="_blank">专利购买</a>/<a href="http://ipr.w7tong.com/patent/gjsq.html" target="_blank">国际专利</a></p>
                                </div>
                                <div class="type_lists">
                                    <a href="http://ipr.w7tong.com/copyright/wzzp.html" class="lists_tit" target="_blank">文字作品登记</a>
                                    <p class="lit_tit"><a href="http://ipr.w7tong.com/copyright/yyzp.html" target="_blank">音乐作品登记</a>/<a href="http://ipr.w7tong.com/copyright/rjzzq.html" target="_blank">软著登记</a></p>
                                </div> 
                                <div class="type_lists">
                                    <a href="http://ipr.w7tong.com/shop/brandshop.html" class="lists_tit" target="_blank">商标购买</a>
                                    <p class="lit_tit"><a href="http://ipr.w7tong.com/shop/brandshop.html" target="_blank">特价商标</a>/<a href="http://ipr.w7tong.com/shop/brandshop.html" target="_blank">免费查询</a></p>
                                </div>   
                            </div>
                        </div>
                    </div>
                    <div class="hot_lists lists_2">
                        <div class="lists_tit">
                            <h2 class="zh-tit">企业服务<i class="icon_jiantou"></i></h2>
                            <p class="icon"></p>
                            <p class="en-tit">Enterprise service</p>
                        </div>
                        <div style="box-shadow: 0px 1px 8px 0px rgba(178, 178, 178, 0.75);">
                            <div class="service_type">
                                <a href="http://es.w7tong.com/gsfw/gszc1.html" class="big_tit" target="_blank">免费公司核名</a>
                                <p class="small_tit">专业人工核名，查询更精准</p>
                                <p class="icon"></p>
                                <a href="http://es.w7tong.com/gsfw/gszc1.html" class="lookdel" target="_blank">查看详情 <i class="trigon-r"></i></a>
                            </div>
                            <div class="type_list clear">
                                <div class="type_lists">
                                    <a href="http://es.w7tong.com/gsfw/gszc1.html" class="lists_tit" target="_blank">公司注册</a>
                                    <p class="lit_tit"><a href="http://es.w7tong.com/gsfw/gsbg1.html" target="_blank">公司名称变更</a>/<a href="http://es.w7tong.com/gsfw/gszx.html" target="_blank">公司注销</a></p>
                                </div>
                                <div class="type_lists">
                                    <a href="http://es.w7tong.com/csfw/dljz1.html" class="lists_tit" target="_blank">代理记账</a>
                                    <p class="lit_tit"><a href="http://es.w7tong.com/csfw/dljz3.html" target="_blank">小规模纳税人</a>/<a href="http://es.w7tong.com/csfw/dljz4.html" target="_blank">一般纳税人</a></p>
                                </div>
                                <div class="type_lists">
                                    <a href="" class="lists_tit develop">资质办理</a>
                                    <p class="lit_tit"><a href="" class="develop">ICP资质</a>/<a href="" class="develop">餐饮资质</a></p>
                                </div> 
                                <div class="type_lists">
                                    <a href="" target="_blank" class="lists_tit develop">法律服务</a>
                                    <p class="lit_tit"><a href="" class="develop">免费合同</a>/<a href="" class="develop">社保办理</a></p>
                                </div>   
                            </div>
                        </div>
                    </div>
                    <div class="hot_lists lists_3">
                        <div class="lists_tit">
                            <h2 class="zh-tit">网店服务<i class="icon_jiantou"></i></h2>
                            <p class="icon"></p>
                            <p class="en-tit">Online shop service</p>
                        </div>
                        <div style="box-shadow: 0px 1px 8px 0px rgba(178, 178, 178, 0.75);">
                            <div class="service_type">
                                <a href="http://wd.w7tong.com/enter.html" class="big_tit" target="_blank">商城代入驻</a>
                                <p class="small_tit">助力您的电商梦</p>
                                <p class="icon"></p>
                                <a href="http://wd.w7tong.com/enter.html" class="lookdel" target="_blank">查看详情 <i class="trigon-r"></i></a>
                            </div>
                            <div class="type_list clear">
                                <div class="type_lists">
                                    <a href="http://wd.w7tong.com/enter.html" class="lists_tit" target="_blank">天猫入驻</a>
                                    <p class="lit_tit"><a href="http://wd.w7tong.com/enter.html" target="_blank">服饰鞋包</a>/<a href="http://wd.w7tong.com/enter.html" target="_blank">家居用品</a></p>
                                </div>
                                <div class="type_lists">
                                    <a href="http://wd.w7tong.com/enter.html" class="lists_tit" target="_blank">京东入驻</a>
                                    <p class="lit_tit"><a href="http://wd.w7tong.com/enter.html" target="_blank">家装家饰</a>/<a href="http://wd.w7tong.com/enter.html" target="_blank">美容护理</a></p>
                                </div>
                                <div class="type_lists">
                                    <a href="http://wd.w7tong.com/enter.html" class="lists_tit" target="_blank">淘宝入驻</a>
                                    <p class="lit_tit"><a href="http://wd.w7tong.com/enter.html" target="_blank">母婴用品</a>/<a href="http://wd.w7tong.com/enter.html" target="_blank">3C数码</a></p>
                                </div> 
                                <div class="type_lists">
                                    <a href="http://wd.w7tong.com/enter.html" class="lists_tit" target="_blank">其他平台</a>
                                    <p class="lit_tit"><a href="http://wd.w7tong.com/enter.html" target="_blank">运动户外</a>/<a href="http://wd.w7tong.com/enter.html" target="_blank">食品保健</a></p>
                                </div>   
                            </div>
                        </div>
                    </div>
                    <div class="hot_lists lists_4">
                        <div class="lists_tit">
                            <h2 class="zh-tit">互联服务<i class="icon_jiantou"></i></h2>
                            <p class="icon"></p>
                            <p class="en-tit">Internet Service</p>
                        </div>
                        <div style="box-shadow: 0px 1px 8px 0px rgba(178, 178, 178, 0.75);">
                            <div class="service_type">
                                <a href=""class="big_tit develop">网站定制</a>
                                <p class="small_tit">定制您的专属网站</p>
                                <p class="icon"></p>
                                <a href="" class="lookdel develop">查看详情 <i class="trigon-r"></i></a>
                            </div>
                            <div class="type_list clear">
                                <div class="type_lists">
                                    <a href="" class="lists_tit develop">UI设计</a>
                                    <p class="lit_tit"><a href="" class="develop">网站</a>/<a href="" class="develop">移动端</a></p>
                                </div>
                                <div class="type_lists">
                                    <a href="" class="lists_tit develop">APP开发</a>
                                    <p class="lit_tit"><a href="" class="develop">ios</a>/<a href="" class="develop">Android</a></p>
                                </div>
                                <div class="type_lists">
                                    <a href="" class="lists_tit develop">小程序开发</a>
                                    <p class="lit_tit"><a href="" class="develop">商城</a>/<a href="" class="develop">餐饮</a>/<a href="" class="develop">门店</a></p>
                                </div> 
                                <div class="type_lists">
                                    <a href=""  class="lists_tit develop">微信开发</a>
                                    <p class="lit_tit"><a href="" class="develop">微官网</a>/<a href="" class="develop">微团购</a></p>
                                </div>   
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 企业服务 -->
        <div class="bes w-wqt">
            <div class="title pad-wqt3">
                <h2 class="zh-tit">企业服务</h2>
                <p class="en-tit">ENTERPRISE SERVICE</p>
            </div>
            <div class="bes_box">
                <ul class="bes_title clear">
                    <li class="on1">创业筹备期</li>
                    <li class="center">持续发展期</li>
                    <li>成熟稳定期</li>
                </ul>
                <div class="bes_type">
                    <div class="bes_types clear" >
                        <div class="bes_list">
                            <div class="bes_list_tit">
                                <h2 class="big_tit">工商代理</h2>
                                <p class="small_tit">专业代办，让你少花钱少跑路</p>
                            </div>
                            <div class="bes_lists">
                                <a class="bes_lists_a" href="http://es.w7tong.com/gsfw/gszc1.html" target="_blank">公司核名<span>（轻松一点，3秒获取查询结果）</span></a>
                                <a class="bes_lists_a" href="http://es.w7tong.com/gsfw/gszc1.html" target="_blank">公司注册<span>（一手代办，全程加急）</span></a>
                                <a class="bes_lists_a" href="http://es.w7tong.com/gsfw/gszc1.html" target="_blank">办理营业执照<span>（专业审批渠道，快速出证）</span></a>
                            </div>
                        </div>
                        <div class="bes_list center">
                            <div class="bes_list_tit">
                                <h2 class="big_tit">商标服务</h2>
                                <p class="small_tit">全网低价，足不出户</p>
                            </div>
                            <div class="bes_lists">
                                <a class="bes_lists_a" href="http://ipr.w7tong.com/brand/ptzc.html" target="_blank">商标注册<span>（专业办理，99%高通过率）</span></a>
                                <a class="bes_lists_a" href="http://ipr.w7tong.com/brand/jjzc.html" target="_blank">加急处理<span>（全程加速，24小时内官方回执）</span></a>
                                <a class="bes_lists_a" href="http://ipr.w7tong.com/shop/brandshop.html" target="_blank">商标转让<span>（海量闲置商标，全程公证）</span></a>
                            </div>
                        </div>
                        <div class="bes_list">
                            <div class="bes_list_tit">
                                <h2 class="big_tit">互联服务</h2>
                                <p class="small_tit">原创定制，提高品牌竞争力</p>
                            </div>
                            <div class="bes_lists">
                                <a class="bes_lists_a develop" href="" >企业网站<span>（专业设计，提供网站推广服务）</span></a>
                                <a class="bes_lists_a develop" href="" >电商网站<span>（深度开发定制，助力产品销售）</span></a>
                                <a class="bes_lists_a develop" href="" >H5开发<span>（热门效果设计，火爆朋友圈）</span></a>
                            </div>
                        </div>
                    </div>
                    <div class="bes_types clear" style="display: none">
                        <div class="bes_list">
                            <div class="bes_list_tit">
                                <h2 class="big_tit">财税代理</h2>
                                <p class="small_tit">资深团队，服务一步到位</p>
                            </div>
                            <div class="bes_lists">
                                <a class="bes_lists_a" href="http://es.w7tong.com/csfw/dljz3.html" target="_blank">小规模代理记账<span>（一站式服务，专业高效）</span></a>
                                <a class="bes_lists_a" href="http://es.w7tong.com/csfw/dljz4.html" target="_blank">一般纳税人代理记账<span>（正规审批团队）</span></a>
                                <a class="bes_lists_a" href="http://es.w7tong.com/csfw/dljz5.html" target="_blank">旧账清理<span>（专业代办，规避税务风险）</span></a>
                            </div>
                        </div>
                        <div class="bes_list center">
                            <div class="bes_list_tit">
                                <h2 class="big_tit">互联运营</h2>
                                <p class="small_tit">内容定制，借势营销引爆流量</p>
                            </div>
                            <div class="bes_lists">
                                <a class="bes_lists_a develop" href="" >微信开发<span>（打通线上分销闭环）</span></a>
                                <a class="bes_lists_a develop" href="" >小程序开发<span>（免费获取大流量）</span></a> 
                            </div>
                        </div>
                        <div class="bes_list">
                            <div class="bes_list_tit">
                                <h2 class="big_tit">电商服务</h2>
                                <p class="small_tit">电商新模式，小投资大回报</p>
                            </div>
                            <div class="bes_lists">
                                <a class="bes_lists_a" href="http://wd.w7tong.com/" target="_blank">网店转让<span>（全网优质店铺，免费陪同过户）</span></a>
                                <a class="bes_lists_a develop" href="" >电商网站<span>（高申请通过率，不成功不收费）</span></a>
                            </div>
                        </div>
                    </div>
                    <div class="bes_types clear" style="display: none">
                        <div class="bes_list">
                            <div class="bes_list_tit">
                                <h2 class="big_tit">业务服务</h2>
                                <p class="small_tit">24小时极速办理，专业托管</p>
                            </div>
                            <div class="bes_lists">
                                <a class="bes_lists_a" href="http://es.w7tong.com/gsfw/gszc1.html" target="_blank">注册分公司<span>（办理周期短，成功率高）</span></a>
                                <a class="bes_lists_a" href="http://es.w7tong.com/gsfw/gsbg4.html" target="_blank">股东股权变更<span>（及时变更，规避更多风险）</span></a>
                                <a class="bes_lists_a" href="http://es.w7tong.com/csfw/dljz5.html" target="_blank">年度报表<span>（资深会计团队严瑾审计）</span></a>
                            </div>
                        </div>
                        <div class="bes_list center">
                            <div class="bes_list_tit">
                                <h2 class="big_tit">知识产权</h2>
                                <p class="small_tit">快捷申请，一对一极速响应</p>
                            </div>
                            <div class="bes_lists">
                                <a class="bes_lists_a" href="http://ipr.w7tong.com/brand/gjzc.html" target="_blank">国际商标注册<span>（30万海外商标，快速办理）</span></a>
                                <a class="bes_lists_a" href="http://ipr.w7tong.com/patent/gjsq.html" target="_blank">国际专利申请<span>（专业通道申请，全程掌控）</span></a>
                                <a class="bes_lists_a" href="http://ipr.w7tong.com/patent/wxxg.html" target="_blank">专利无效宣告<span>（全网低价，价格透明）</span></a>
                            </div>
                        </div>
                        <div class="bes_list">
                            <div class="bes_list_tit">
                                <h2 class="big_tit">互联服务</h2>
                                <p class="small_tit">专业团队放心代办</p>
                            </div>
                            <div class="bes_lists">
                                <a class="bes_lists_a develop" href="">小程序开发<span>（免费获取大流量）</span></a>
                                <a class="bes_lists_a develop" href="">网站定制<span>（专业原创）</span></a>
                                <a class="bes_lists_a develop" href="">APP开发<span>（免费回去大流量 ）</span></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 新闻 -->
        <div class="trendnews">
            <div class="title pad-wqt1">
                <h2 class="zh-tit">头条资讯</h2>
                <p class="en-tit">HEADLINE INFORMATION</p>
            </div>
            <div class="news_titles">
                <span class="news_genre on">行业资讯</span>
                <span class="news_genre">经典案例</span>
                <span class="news_genre">专业问答</span>
            </div>
            <!--  行业知讯  -->
            <div class="news_content clear">
                <a class="more" href="http://www.w7tong.com/news/news.html" target="_blank">查看更多&nbsp;></a>
                <#if indexData.l_News?exists  && indexData.l_News?size gt 0>
                     <#if indexData.l_News[0]?exists>
		                <div class="news_item">
		                    <div class="news_img"><img src="${indexData.l_News[0].newicon?if_exists}" alt=""></div>
		                    <p class="news_title">
		                            <#if indexData.l_News[0].title?length gt 25> 
		                               ${indexData.l_News[0].title?substring(0,20)}......
		                            <#else>
		                               ${indexData.l_News[0].title?if_exists}
		                            </#if>      
                            </p>
		                    <p class="kongbai"></p>
		                    <p class="cue">
		                        <#if indexData.l_News[0].hits?length gt 40> 
	                               ${indexData.l_News[0].hits?substring(0,35)}......
	                            <#else>
	                               ${indexData.l_News[0].hits?if_exists}
	                            </#if> 
                            </p>
		                    <p class="check_detail">
                                <a href="/${indexData.l_News[0].htmlpath?if_exists}" target="_blank">查看详情&nbsp;></a>
                            </p>
		                </div>
		              </#if>
		        </#if>
		        <#if indexData.l_News?exists  && indexData.l_News?size gt 1>
                     <#if indexData.l_News[1]?exists>
			                <div class="news_item" style="margin:0 20px;">
			                    <div class="news_img"><img src="${indexData.l_News[1].newicon?if_exists}" alt=""></div>
			                    <p class="news_title">
			                        <#if indexData.l_News[1].title?length gt 25> 
		                               ${indexData.l_News[1].title?substring(0,20)}......
		                            <#else>
		                               ${indexData.l_News[1].title?if_exists}
		                            </#if> 
                                </p>
			                    <p class="kongbai"></p>
			                    <p class="cue">
			                     <#if indexData.l_News[1].hits?exists> 
			                        <#if indexData.l_News[1].hits?length gt 40> 
		                               ${indexData.l_News[1].hits?substring(0,35)}......
		                            <#else>
		                               ${indexData.l_News[1].hits?if_exists}
		                            </#if>
		                        </#if>
			                    </p>
			                    <p class="check_detail"><a href="/${indexData.l_News[1].htmlpath?if_exists}" target="_blank">查看详情&nbsp;></a></p>
			                </div>
			           </#if>
		        </#if>
                <div class="news_list">
                    <#--  <div class="titles"><span class="text">万企通资讯</span><a class="wqtmore" href="http://www.w7tong/news/news.html" target="_blank">更多</a></div>  -->
                    <ul>
                        <#if indexData.l_News?exists && indexData.l_News?size gt 2>
                           <#list 2..indexData.l_News?size?number-1 as newindex>
		                        <li><a href="/${indexData.l_News[newindex].htmlpath?if_exists}" target="_blank" title="${indexData.l_News[newindex].title?if_exists}">
		                               <#if indexData.l_News[newindex].title?length gt 25> 
			                               ${indexData.l_News[newindex].title?substring(0,20)}......
			                            <#else>
			                               ${indexData.l_News[newindex].title?if_exists}
			                            </#if> 
                                        <span>${indexData.l_News[newindex].developtime?string('yyyy-MM-dd')}
                                        </span>
                                    </a>
                                </li>
		                   
		                   </#list>
                       </#if>
                    </ul>
                </div>
            </div>
            <!--  经典案例  -->
            <div class="news_content clear" style="display:none">
                <a class="more" href="/cases/caseslist.html" target="_blank">查看更多&nbsp;></a>
                <div class="news_item">
                   <#if indexData.l_WqtCases?exists  && indexData.l_WqtCases?size gt 0>
                      <#if indexData.l_WqtCases[0]?exists>
		                    <div class="news_img"><img src="${indexData.l_WqtCases[0].caseimg?if_exists}" alt=""></div>
		                    <p class="news_title">
		                            <#if indexData.l_WqtCases[0].title?if_exists?length gt 25> 
		                               ${indexData.l_WqtCases[0].title?if_exists?substring(0,20)}......
		                            <#else>
		                               ${indexData.l_WqtCases[0].title?if_exists}
		                            </#if>         
		                    </p>
		                    <p class="kongbai"></p>
		                    <p class="cue">
		                        <#if indexData.l_WqtCases[0].beforetext?if_exists?length gt 40> 
	                               ${indexData.l_WqtCases[0].beforetext?if_exists?substring(0,35)}......
	                            <#else>
	                               ${indexData.l_WqtCases[0].beforetext?if_exists}
	                            </#if> 
		                    </p>
		                    <p class="check_detail">
		                        <a href="/${indexData.l_WqtCases[0].htmlpath?if_exists}" target="_blank">查看详情&nbsp;></a>
		                    </p>
	                  </#if>
	               </#if>
                </div>
                <div class="news_item" style="margin:0 20px;">
                  <#if indexData.l_WqtCases?exists  && indexData.l_WqtCases?size gt 1>
                     <#if indexData.l_WqtCases[1]?exists>
		                    <div class="news_img"><img src="${indexData.l_WqtCases[1].caseimg?if_exists}" alt=""></div>
		                    <p class="news_title">
		                        <#if indexData.l_WqtCases[1].title?length gt 25> 
		                            ${indexData.l_WqtCases[1].title?substring(0,20)}......
		                        <#else>
		                            ${indexData.l_WqtCases[1].title}
		                        </#if>  
		                    </p>
		                    <p class="kongbai"></p>
		                    <p class="cue">
		                        <#if indexData.l_WqtCases[1].beforetext?exists> 
			                        <#if indexData.l_WqtCases[1].beforetext?length gt 40> 
			                            ${indexData.l_WqtCases[1].beforetext?substring(0,35)}......
			                        <#else>
			                            ${indexData.l_WqtCases[1].beforetext?if_exists}
			                        </#if>
		                        </#if> 
		                    </p>
		                    <p class="check_detail"><a href="/${indexData.l_WqtCases[1].htmlpath?if_exists}" target="_blank">查看详情&nbsp;></a></p>
		             </#if>
	               </#if>
                </div>
                <div class="news_list">
                    <ul>
                       <#if indexData.l_WqtCases?exists && indexData.l_WqtCases?size gt 2>
                           <#list 2..indexData.l_WqtCases?size?number-1 as caseindex>
		                        <li><a href="/${indexData.l_WqtCases[caseindex].htmlpath?if_exists}" target="_blank" title="${indexData.l_WqtCases[caseindex].title?if_exists}">
		                                <#if indexData.l_WqtCases[caseindex].title?length gt 25> 
				                            ${indexData.l_WqtCases[caseindex].title?substring(0,20)}......
				                        <#else>
				                            ${indexData.l_WqtCases[caseindex].title?if_exists}
				                        </#if>  
		                                <span>
		                                   ${indexData.l_WqtCases[caseindex].createtime?date("yyyy-MM-dd")}
		                                </span>
		                            </a>
		                        </li>
		                   </#list>
                       </#if>
                    </ul>
                </div>
            </div>
            <!--  专业问答  -->
            <div class="news_content clear" style="display:none">
                <a class="more" href="/user/helpcenter.html" target="_blank">查看更多&nbsp;></a>
                <ul class="clear">
                   <#if indexData.l_WqtProblem?exists>
                       <#list indexData.l_WqtProblem as wqtProblem>
                             <li>
		                        <p class="p1">
		                            <i></i>
		                            <span>
		                                <#if wqtProblem.title?length gt 25> 
			                               ${wqtProblem.title?substring(0,20)}......
			                            <#else>
			                               ${wqtProblem.title?if_exists}
			                            </#if> 
		                            </span>
		                        </p>
		                        <p class="p2">
		                            <i></i>
		                            <span> ${wqtProblem.simpledesc?if_exists}</span>
		                        </p>
		                        <a href="/${wqtProblem.htmlpath?if_exists}" class="p3" target="_blank">[查看详情]</a>
		                    </li>
	                   </#list>
                    </#if> 
                </ul>
            </div>
        </div>
    </div>
     
    <div class="cover"></div>
    <!-- 提示 -->
    <div class="hint1 animated zoomIn">
        <div class="hint_cpntent">提示</div>
    </div>
     <!--右边固定资讯-->
    <div class="rt_fixed">
        <ul>
            <li>
                <div class="chat rt_fixed_cont">
                    <ul>
                    <#if  wqt_serviceworker?exists && wqt_serviceworker?size gt 3>
                        <#list 0..2 as WqtWorkerBean >
                        <li>
                            <div class="qq_chat">
                                <div class="chat_img lf">
                                    <img src="${wqt_serviceworker[WqtWorkerBean].headurl?if_exists}" alt="" width="80" height="80">
                                </div>
                                <#if  wqt_serviceworker[WqtWorkerBean].workerkind=='ipr'>
                                    <p class="p1">知产顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='es'>
                                    <p class="p1">企业顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='service'>
                                    <p class="p1">售后顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='partner'>
                                    <p class="p1">合作顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='schedule'>
                                    <p class="p1">进度顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='eshop'>
                                    <p class="p1">网店顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='cs'>
                                    <p class="p1">财税顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                </#if>
                                <p class="p2">电话：${wqt_serviceworker[WqtWorkerBean].mobile?if_exists}</p>
                                <a class="chat_pp" href='tencent://message/?uin=${wqt_serviceworker[WqtWorkerBean].qq?if_exists}&Site=&menu=yes' target='_blank'>立即联系</a>
                            </div>
                        </li>
                        </#list>
                    </#if>
                    </ul>
                    <i></i>
                </div>
            </li>
            <li>
                <div class="rt_fixed_cont erweima">
                    <ul>
                    <#if wqt_serviceworker?exists && wqt_serviceworker?size gt 3>
                        <#list 0..2 as WqtWorkerBean >
                        <li>
                            <div class="erweima_chat">
                                <#if  wqt_serviceworker[WqtWorkerBean].workerkind=='ipr'>
                                    <p class="p1">知产顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='es'>
                                    <p class="p1">企业顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='service'>
                                    <p class="p1">售后顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='partner'>
                                    <p class="p1">合作顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='schedule'>
                                    <p class="p1">进度顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='eshop'>
                                    <p class="p1">网店顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                <#elseif wqt_serviceworker[WqtWorkerBean].workerkind=='cs'>
                                    <p class="p1">财税顾问-${wqt_serviceworker[WqtWorkerBean].workername?if_exists}</p>
                                </#if>
                                <div class="erweima_img">
                                    <img src="${wqt_serviceworker[WqtWorkerBean].weixin?if_exists}" alt="" width="100" height="100">
                                </div>
                            </div>
                        </li>
                        </#list>
                    </#if>
                    </ul>
                    <i></i>
                </div>
            </li>
            <li>
                <a href="" target="_blank" title="在线客服"></a>
            </li>
            <li>
                <div class="rt_fixed_cont rt_hot_p">
                    <div class="rt_hot_pp">
                        <p class="p1">全国服务热线</p>
                        <p class="p2">400-611-8288</p>
                    </div>
                    <i></i>
                </div>
            </li>
            <li id='r_top'>
                <a href="javascript:;"></a>
            </li>
        </ul>
    </div>
    <!--底部-->
    <#include "/templates/footer.ftl">
   
    <script>
    (function(){
        var src = (document.location.protocol == "http:") ? "http://js.passport.qihucdn.com/11.0.1.js?970c5c40fa31e0fa08b4ef38eeeb1cfc":"https://jspassport.ssl.qhimg.com/11.0.1.js?970c5c40fa31e0fa08b4ef38eeeb1cfc";
        document.write('<script src="' + src + '" id="sozz"><\/script>');
    })();
    
    </script>
    </body>
    <script src="https://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
    <script src="/common/commonurl.js"></script>
   
    <script src="/js/wqt_index.js"></script>
</html>