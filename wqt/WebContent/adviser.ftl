<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=0.25">
    <meta name="format-detection" content="telephone=no">
    <title>专业知识产权顾问</title>
    <link rel="shortcut icon " type="images/x-icon" href="/wqt/image/logo.ico">
    <link rel="stylesheet" href="/wqt/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/wqt/css/adviser.css">
    <link rel="stylesheet" href="/wqt/templates/css/footer.css">
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
    <div class="all">
        <div class="banner center">
            当前位置：
            <a href="http://www.w7tong.com" target="_blank">万企通首页</a>
            >
            <a href="http://ipr.w7tong.com" target="_blank">万企通知识产权</a>
            >
            <a href="http://ipr.w7tong.com/brandseek.html" target="_blank">商标服务</a>
            >
            <a href="http://ipr.w7tong.com/brand/ptzc.html" target="_blank">商标普通注册</a>
            >
            <a href="http://www.w7tong.com/user/adviser.html">顾问列表页</a>
        </div>
        <div class="center kf_cont">
            <div class="kf_tab">
                <ul>
                    <!--点击跳转li标签加on-->
                    <li><a href="/user/adviser/ipr/1.html">知识产权顾问</a></li>
                    <li><a href="/user/adviser/es/1.html">企业服务顾问</a></li>
                    <li><a href="/user/adviser/service/1.html">售后顾问</a></li>
                    <li><a href="/user/adviser/partner/1.html">商务合作顾问</a></li>
                    <li><a href="/user/adviser/schedule/1.html">业务进度</a></li>
                </ul>
                <div class="kf_search">
                    <input type="text" placeholder="请输入顾问姓名">
                    <a href="javascript:;"></a>
                </div>
            </div>
            <div class="kf_list">
                <ul class="clear">
                   <#if adviseWorkerData.list_adviseWorker?exists>
	                 <#list adviseWorkerData.list_adviseWorker as worker>
                    <li>
                        <div class="kf_img">
                            <img src="${worker.headurl?if_exists}" alt="" width="120" height="120">
                        </div>
                        <div class="kf_det">
                            <p class="p1">${worker.workername?if_exists}</p>
                            <p class="p2">
                                <#if worker.workerkind=='ipr'>
                                    <span>商标交易</span>
                                    <span>专利检索</span>
                                    <span>版权登记</span> 
                               <#elseif worker.workerkind=='es'>
                                    <span>企业服务</span>
                                    <span>企业交易</span>
                               <#elseif worker.workerkind=='service'>
                                    <span>售后服务</span>
                              <#elseif worker.workerkind=='partner'>
                                    <span>商务合作</span>
                              <#elseif worker.workerkind=='schedule'>
                                    <span>审核进度咨询</span>
                               </#if>
                            </p>
                            <p class="p3">
                                <#if worker.workerkind=='ipr'>
                                     <img src="/image/adviser/ipr.png">
                                <#elseif worker.workerkind=='es'>
                                     <img src="/image/adviser/es.png">
                                <#elseif worker.workerkind=='service'>
                                     <img src="/image/adviser/shhw.png">
                               <#elseif worker.workerkind=='partner'>
                                     <img src="/image/adviser/swhz.png">
                               <#elseif worker.workerkind=='schedule'>
                                     <img src="/image/adviser/ywjd.png">
                               </#if>
                            </p>
                        </div>
                        <div class="kf_pf">
                            <p class="p1">10.0分</p>
                            <p class="p2"></p>
                        </div>
                        <div class="kf_zx">
                            <ul>
                                <li><a href="javascript:;" class="k1">联系客服</a></li>
                                <li><a href="tencent://message/?uin=${worker.qq?if_exists}&Site=&menu=yes" class="k2">在线资讯</a></li>
                            </ul>
                        </div>
                    </li>
                       </#list>
		         </#if>
                </ul>
            </div>
            <!--分页-->
            <div class="company_list_result_pages">
                    <span class="backhome">
                         <#if adviseWorkerData.workerkind?exists>
                             <a href="/user/adviser/${adviseWorkerData.workerkind?if_exists}/1.html" id="firstPage0">首页</a>
                         <#else>
                             <a href="/user/adviser/1.html" id="nextPage0">首页</a>
                         </#if>
                    </span>
                <span class="prevpage">
                      <#if adviseWorkerData.pagenum?number gt 1>
                           <#if adviseWorkerData.workerkind?exists>
                               <a href="/user/adviser/${adviseWorkerData.workerkind?if_exists}/${adviseWorkerData.pagenum-1}.html" id="prevA0">上一页</a>
                           <#else>
                               <a href="/user/adviser/${adviseWorkerData.pagenum-1}.html" id="prevA0">上一页</a>
                           </#if>
                      <#else>
                         <a href="javascript:;" id="prevA0">上一页</a>
                      </#if>
                </span>
                <span class="nextpage">
                      <#if adviseWorkerData.pagenum?number lt adviseWorkerData.workerpage?number>
                            <#if adviseWorkerData.workerkind?exists>
                                 <a href="/user/adviser/${adviseWorkerData.workerkind?if_exists}/${adviseWorkerData.pagenum+1}.html" id="nextA0">下一页</a>
                            <#else>
                                 <a href="/user/adviser/${adviseWorkerData.pagenum+1}.html" id="nextA0">下一页</a>
                            </#if>
                      <#else>
                         <a href="javascript:;" id="nextA0">下一页</a>
                      </#if>
                </span>
                <span class="lastpage">
                      <#if adviseWorkerData.workerkind?exists>
                           <a href="/user/adviser/${adviseWorkerData.workerkind?if_exists}/${adviseWorkerData.workerpage}.html" id="nextPage0">尾页</a>
                      <#else>
                           <a href="/user/adviser/${adviseWorkerData.workerpage}.html" id="nextPage0">尾页</a>
                      </#if>
                </span>
                <span class="total">
                        共<span id="allPage20">${adviseWorkerData.workerpage}</span>页/当前为第
                        <strong id="nowPage20">${adviseWorkerData.pagenum}</strong>
                        页
                </span>
            </div>
        </div>
    </div>

    <!--弹框-->
    <div class="query"  style="display: none">
        <div class="copy-bg"></div>
        <div class="ui-win-search">
            <p class="p1"><input type="text" placeholder="请输入您的姓名"></p>
            <p class="p2"><input type="text" placeholder="请输入您的电话号码"></p>
            <a href='javascript:;' id="free_btn">免费咨询</a>
            <h2>十分钟内专业顾问将联系您</h2>
            <i id="exit"></i>
        </div>
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
<script src="/wqt/js/jquery-1.11.1.min.js"></script>
<script src="/wqt/templates/js/wqt_header.js"></script>
<script src="/wqt/common/commonurl.js"></script>
<script src="/wqt/layui/layui.js"></script>
<script src="/wqt/usercenter/js/adviser.js"></script>
</html>