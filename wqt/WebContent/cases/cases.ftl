<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=0.25">
    <title>售后采访</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/cases/css/cases.css">
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
    <!--头部-->
         <#include "/templates/wqt_header.ftl">
    <!--售后采访-->
    <div class="section_banner">
        <div class="container">
            <p>
                真实还原--用心灵做桥梁,让
                <span>万企通</span>
                做板砖
            </p>
            <div class="section_bannerbd">
                <div class="section_bannerbd_title">${wqtCases.periodsnum?if_exists}${wqtCases.title?if_exists}</div>
                <div class="share">
                    <div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare">
                        <a href="#" class="bds_qzone" title="分享到QQ空间"></a>
                        <a href="#" class="bds_tsina" title="分享到新浪微博"></a>
                        <a href="#" class="bds_tqq" title="分享到腾讯微博"></a>
                        <a href="#" class="bds_renren" title="分享到人人网"></a>
                        <a href="#" class="bds_t163" title="分享到网易微博"></a>
                        <span class="bds_more">更多</span>
                    </div>
                    <script type="text/javascript" id="bdshare_js" data="type=tools" src="http://bdimg.share.baidu.com/static/js/bds_s_v2.js?cdnversion=425815"></script>
                </div>
            </div>
        </div>
    </div>
    <!--主角风采-->
    <div class="section section01">
        <div class="container clear">
            <div class="section01_left lf">
                <dl class="section01_left_top">
                    <dt class="tit">
                        <img src="/image/interview_detail/section01_tit01.png" width="124" height="28" alt="">
                    </dt>
                    <dd class="bd">${wqtCases.beforetext?if_exists}</dd>
                </dl>
                <dl>
                    <dt class="tit">
                        <img src="${wqtCases.caseimg?if_exists}" width="183" height="29" alt="">
                    </dt>
                    <dd>${wqtCases.casedesc?if_exists}胡先生：有勇有谋 敢闯敢拼 才华横溢</dd>
                    <dd>平台关系：${wqtCases.orderkind?if_exists}买家</dd>
                    <dd>成交价格：${wqtCases.price?if_exists}50000.00</dd>
                    <dd>商标大类：${wqtCases.kindname?if_exists}第三十五类</dd>
                </dl>
            </div>
            <div class="section01_slide rt">
                <img src="" style="height:480px;" alt="">
            </div>
            <div class="section_center_tit">
                <img src="/cases/image/interview_detail/section01_tit03.png" width="156" height="110" alt="">
            </div>
        </div>
    </div>
    <!--采访现场-->
    <div class="section section02">
        <div class="tit"></div>
        <div class="container clear">
            <div class="section02_left lf">
               
                   ${wqtCases.casecontent?if_exists}
               
            </div>
            <div class="section02_right rt">
                <ul>
                   <#if wqtCases.l_WqtCases?exists>
						<#list wqtCases.l_WqtCases as rwqtCases>
							<li>
								<p class="pic lf">
									<img src="${rwqtCases.caseimg?if_exists}" alt="万企通企业服务网_售后采访_${rwqtCases.periodsnum?if_exists}主角头像" width="106" height="106" alt="">
								</p>
								<p class="title">${rwqtCases.periodsnum?if_exists}</p>
								<p class="txt">${rwqtCases.title?if_exists}</p>
								<p class="btn">
									<a href="/${rwqtCases.htmlpath?if_exists}">查看详情</a>
								</p>
							</li>
						</#list>
				   </#if>
                </ul>
            </div>
        </div>
    </div>
    <!--结语-->
    <div class="section section03">
        <div class="container">
            <div class="tit">
                <img src="/cases/image/interview_detail/section03_tit01.png" alt="" width="118" height="51">
            </div>
            <div class="section03_cont">
                <p>${wqtCases.resulttext?if_exists}</p>
                <p class="writer">编辑：万企通</p>
            </div>
        </div>
    </div>
    <!--底部-->
    <#include "/templates/footer.ftl">
</body>
<script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
</html>