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
    <title>常见问题-帮助中心</title>
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
                        <#if problemKindData.l_DisProblemKind?exists>
                              <#list problemKindData.l_DisProblemKind as disProblemKind>
                                 <div class="help-problems-lba">
		                            <div class="help-problems-lbaa help-problems-lbaaminus">${disProblemKind.problemkindname?if_exists}</div>
		                            <div class="help-problems-lbab">
		                                <ul>
		                                    <#if problemKindData.l_WqtProblemKind?exists>
                                               <#list problemKindData.l_WqtProblemKind as wqtProblemKind>
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
                        <i class="kind">
                            网店交易
                        </i>
                    </div>
                    <#if problemKindData.l_WqtProblem?exists>
                       <#list problemKindData.l_WqtProblem as wqtProblem>
		                    <div class="help-problems-rc">
		                        <div class="help-problems-rc-pub">
		                            <div class="help-problems-rca">
		                                <div class="help-problems-rcal"><a href="/${wqtProblem.htmlpath?if_exists}" target="_blank">${wqtProblem.title?if_exists}</a></div>
		                                <div class="clear"></div>
		                            </div>
		                        </div>
		                    </div>
                       </#list>
	                </#if>
                    
                    <div class="list_bottom">
                        <div class="list_pages clear">
                            <span class="backhome fl">
                                <a href="/problem/${problemKindData.kindkey?if_exists}/1.html">首页</a>
                            </span>
                            <span class="prevpage fl">
                              <#if problemKindData.pagenum?number gt 1>
		                         <a href="/problem/${problemKindData.kindkey?if_exists}/${problemKindData.pagenum?number-1}.html" id="prevA0">上一页</a>
		                      <#else>
		                         <a href="javascript:;" id="prevA0">上一页</a>
		                      </#if>
                            </span>
                            
                            <span class="nextpage fl">
                                 <#if problemKindData.pagenum?number lt problemKindData.problempage?number>
			                         <a href="/problem/${problemKindData.kindkey?if_exists}/${problemKindData.pagenum?number+1}.html" id="nextA0">下一页</a>
			                      <#else>
			                         <a href="javascript:;" id="nextA0">下一页</a>
			                      </#if>
                            </span>
                            <span class="lastpage fl">
                                <a href="/problem/${problemKindData.kindkey?if_exists}/${problemKindData.problempage?if_exists}.html">尾页</a>
                            </span>
                            <span class="total f1">
                                共${problemKindData.problempage} 页/当前第
                                <strong>${problemKindData.pagenum}</strong>
                                页
                            </span>
                        </div>
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