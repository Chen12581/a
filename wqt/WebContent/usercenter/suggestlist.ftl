<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>建议列表</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/suggestlist.css">
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

<!--内容区域-->
<div class="content">
    <div class="content_lf">
                <div>
                    <h4>个人资料</h4>
                    <ul>
                        <li><a href="/user/personalinfo">基本资料</a></li>
                        <li><a href="/user/postaddr">寄送地址</a></li>
                        <li><a href="/user/contract">主体管理</a></li>
                    </ul>
                </div>
                <div>
                    <h4>我是买家</h4>
                    <ul>
                        <li class=""><a href="/order/buyer/list">我的知识产权</a></li>
                        <li class=""><a href="/order/es/buyer/list">我的企业</a></li>
                        <li class=""><a href="/order/wd/buyer/list">我的网店</a></li>
                        <li class=""><a href="/user/collection">我的收藏</a></li>
                    </ul>
                </div>
                <div>
                    <h4>我是卖家</h4>
                    <ul>
                        <li class=""><a href="/shop/seller/list">我出售的知识产权</a></li>
                        <li class=""><a href="/shop/es/seller/list">我出售的企业服务</a></li>
                        <li class=""><a href="/shop/wd/seller/list">我出售的网店</a></li>
                    </ul>
                </div>
                <div>
                    <h4>资金管理</h4>
                    <ul>
                        <li><a href="/user/recharge">我要充值</a></li>
                        <li><a href="/user/withdraw">我要提现</a></li>
                        <li><a href="/user/capital">资金明细</a></li>
                        <li><a href="/user/bill">索取发票</a></li>
                        <li><a href="/user/bank">绑定银行卡</a></li>
                    </ul>
                </div>
                <div>
					<h4>安全设置</h4>
					<ul>
						<li><a href="/user/safety">实名认证</a></li>
						<li><a href="/user/password">修改密码</a></li>
						<li><a href="/user/email">绑定邮箱</a></li>
						<li><a href="/user/mobile">修改手机号</a></li>
					</ul>
				</div>
				<div>
					<h4>其他管理</h4>
					<ul>
						<li><a href="/user/suggest">我要建议</a></li>
						<li class='hover'><a href="/user/suggestlist">我的建议</a></li>
					</ul>
				</div>
            </div>


    <div class="content_rt">
        <h4 class="theme">我的建议</h4>

        <div class="information">
            <table>
                <tr>
                   <th width="35%">建议内容</th>
                    <th width="35%">回复情况</th>
                    <th width="15%">建议时间</th>
                    <th width="15%" colspan="2">操作</th>
                </tr>
                <#if sugguestList.l_userSuggest?exists>
	                <#list sugguestList.l_userSuggest as userSuggest>
		                <tr>
		                    <td class="content">${userSuggest.suggest?if_exists}</td>
		                    <td class="hf">${userSuggest.answer?if_exists}</td>
		                    <td class="time">${userSuggest.inserttime?if_exists?datetime('yyyy-MM-ddhh:mm:ss')}</td>
		                    <td><a class="out" href="javascript:void(0)" style="color: #969696;" onclick="delate(${userSuggest.id?if_exists})">删除</a></td>
		                </tr>
		            </#list>
		         </#if>
            </table>
            <div class="company_list_result_pages">
                <span class="backhome">
                    <a href="/user/suggestlist/1" id="firstPage">第一页</a></span>
                <span class="prevpage">
                     <#if sugguestList.pagenum?number gt 1>
                         <a href="/user/suggestlist/${sugguestList.pagenum-1}" id="prevA0">上一页</a>
                      <#else>
                         <a href="javascript:;" id="prevA0">上一页</a>
                      </#if>
                </span>
                <span class="nextpage">
                    <#if sugguestList.pagenum?number lt sugguestList.suggestpage?number>
                         <a href="/user/suggestlist/${sugguestList.pagenum+1}" id="nextA0">下一页</a>
                      <#else>
                         <a href="javascript:;" id="nextA0">下一页</a>
                      </#if>
                </span>
                <span class="lastpage">
                    <a href="/user/suggestlist/${sugguestList.suggestpage}" id="nextPage0">尾页</a>
                </span>
                <span class="total">
                    共<span id="allPage2">${sugguestList.suggestpage}</span>页/当前为第
                    <strong id="nowPage2">${sugguestList.pagenum}</strong>
                    页
                </span>
            </div>
        </div>

    </div>
</div>


<!--底部-->
<#include "/templates/footer.ftl">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/usercenter/js/suggestlist.js"></script>
</body>
</html>