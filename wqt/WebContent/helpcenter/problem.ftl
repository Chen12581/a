<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=0.25">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/helpcenter/css/common_problem.css">
    <link rel="stylesheet" href="/templates/css/footer.css">
    <title>常见问题-${problemData.wqtProblem.title?if_exists}</title>
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
    <!--头部-->
    <#include "/templates/wqt_header.ftl">
    <!-- 搜索区域-->
    <div class="problems-ser-bg">
        <#--  <div class="ser-box">
            <div class="problems-ser-a">万企通帮助中心</div>
            <div class="problems-ser-b">帮助您解决问题</div>
            <div class="problems-ser-c">
                <div class="help-ser-cl">
                    <input type="text" placeholder="请输入关键字" style="color:#999">
                </div>
                <div class="help-ser-cr">综合搜索</div>
            </div>
            <div class="help-ser-d">
                <span>搜索热词：</span>
                <a href="http://www.w7tong.com/problem/user/1.html">服务费说明</a>
                <a href="http://www.w7tong.com/problem/111.html">密码找回</a>
                <a href="">客服验证</a>
                <a href="http://www.w7tong.com/problem/sec/1.html">法律保障</a>
            </div>
        </div>  -->
    </div>
    <!--内容区域-->
    <div class="help-content">
        <div class="box">
            <div class="help-problems">
                <div class="help-problems-l">
                    <div class="help-problems-la">
                        <div class="help-problems-laa">COMMON PROBLEM</div>
                        <div class="help-problems-lab">常见问题</div>
                        <div class="help-problems-lac">为您解决烦忧，万企通势在必行!</div>
                    </div>
                    <div class="help-problems-lb">
                         <#if problemData.l_DisProblemKind?exists>
                              <#list problemData.l_DisProblemKind as disProblemKind>
                                 <div class="help-problems-lba">
		                            <div class="help-problems-lbaa help-problems-lbaaminus">${disProblemKind.problemkindname?if_exists}</div>
		                            <div class="help-problems-lbab">
		                                <ul>
		                                    <#if problemData.l_WqtProblemKind?exists>
                                               <#list problemData.l_WqtProblemKind as wqtProblemKind>
                                                  <#if disProblemKind.problemkind==wqtProblemKind.problemkind>
					                                    <li>
					                                        <a href="/problem/${wqtProblemKind.sonproblemkind?if_exists}/1.html" class="help-problems-lbab-select">${wqtProblemKind.sonproblemkindname?if_exists}</a>
					                                    </li>
				                                   </#if>
					                            </#list>
			                                </#if>
		                                </ul>
		                            </div>
		                        </div>
                             </#list>
	                     </#if>                           
                    </div>
                </div>
                <!--中心内容-->
                <div class="help-problems-r">
                    <div class="help-problems-ra">
                        当前位置：
                        <a href="http://www.w7tong.com/user/helpcenter.html">帮助中心</a>
                        <span>></span>
                        <a href="http://www.w7tong.com/problem/brand/1.html">常见问题</a>
                        <span>></span>
                        <#if problemData.wqtProblem.sonproblemkind=='brand'> 
                             <a href="http://www.w7tong.com/problem/brand/1.html">商标</a>
                        <#elseif problemData.wqtProblem.sonproblemkind=='copyright'> 
                             <a href="http://www.w7tong.com/problem/copyright/1.html">版权</a>
                        <#elseif problemData.wqtProblem.sonproblemkind=='patent'> 
                             <a href="http://www.w7tong.com/problem/patent/1.html">专利</a>
                        <#elseif problemData.wqtProblem.sonproblemkind=='service'> 
                             <a href="http://www.w7tong.com/problem/service/1.html">企业服务</a>      
                        <#elseif problemData.wqtProblem.sonproblemkind=='trade'> 
                             <a href="http://www.w7tong.com/problem/trade/1.html">企业交易</a>
                        <#elseif problemData.wqtProblem.sonproblemkind=='eshop'>
                             <a href="http://www.w7tong.com/problem/trade/1.html">网店转让</a>
                        <#elseif problemData.wqtProblem.sonproblemkind=='zc'>
                             <a href="http://www.w7tong.com/problem/trade/1.html">商标转让</a>
                         <#elseif problemData.wqtProblem.sonproblemkind=='cs'>
                             <a href="http://www.w7tong.com/problem/trade/1.html">财税服务</a>
                        <#elseif problemData.wqtProblem.sonproblemkind=='user'> 
                               <a href="http://www.w7tong.com/problem/user/1.html">用户帮助</a>
                        <#elseif problemData.wqtProblem.sonproblemkind=='sec'> 
                               <a href="http://www.w7tong.com/problem/sec/1.html">安全保障</a>
                        </#if>     
                        <span>></span>
                        <i class="kind">
                        <a href="/${problemData.wqtProblem.htmlpath?if_exists}">${problemData.wqtProblem.title?if_exists}</a>
                        </i>
                    </div>
                    <div class="help-problems-rc">
                        <div class="help-problems-rc-pub">
                            <div class="help-problems-rca">
                                <div class="help-problems-rcal"> ${problemData.wqtProblem.title?if_exists}</div>
                                <#--  <div class="help-problems-rcar help-problems-rcarminus"></div>  -->
                                <div class="clear"></div>
                            </div>
                            <div class="help-problems-rcb">
                                <div class="help-problems-rcba">
                                    <p>
                                        ${problemData.wqtProblem.content?if_exists}
                                    </p>
                                </div>
                            </div>
                            <div class="help-problems-rcbb" style="display: block;">以上内容是否解决了您的问题呢？</div>
                        </div>
                        <div class="help-problems-rcbc" style="display: block;">
                            <div class="help-problems-rcbc-t">
                                <div class="help-problems-rcbcl">已解决</div>
                                <div class="help-problems-rcbcr">未解决</div>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="help-problems-rcbd" style="display:none">未解决<a href="tencent://message/?uin=2881791878&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></div>
                        <div class="help-problems-rcbe" style="display:none">已解决</div>
                    </div>
                    <!--  上下篇  -->
                    <div class="ff">
                        <ul class="clearfix">
                            <li class="lf">
                               <#if problemData.prewqtProblem?exists>
                                    <a href="/${problemData.prewqtProblem.htmlpath?if_exists}" class="one-txt-cut"><i class="i1"></i>上一篇：<span>${problemData.prewqtProblem.title?if_exists}</span></a>
                               </#if> 
                            </li>
                            <li class="rt">
                                <#if problemData.nextwqtProblem?exists>
                                    <a href="/${problemData.nextwqtProblem.htmlpath?if_exists}"  class="one-txt-cut" style="padding-right:10px;"><i class="i2"></i>下一篇：<span>${problemData.nextwqtProblem.title?if_exists}</span></a>
                                </#if> 
                            </li>
                        </ul>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
    <!--  底部  -->
    <#include "/templates/footer.ftl">
    <script>
        (function(){
            var src = (document.location.protocol == "http:") ? "http://js.passport.qihucdn.com/11.0.1.js?970c5c40fa31e0fa08b4ef38eeeb1cfc":"https://jspassport.ssl.qhimg.com/11.0.1.js?970c5c40fa31e0fa08b4ef38eeeb1cfc";
            document.write('<script src="' + src + '" id="sozz"><\/script>');
        })();
    </script>
    <script src="https://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
    <script src="/templates/js/wqt_header.js"></script>
    <script src="/helpcenter/js/problem.js"></script>
    <script src="/common/commonurl.js"></script>
</body>
</html>