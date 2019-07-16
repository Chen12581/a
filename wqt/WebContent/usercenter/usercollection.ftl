<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>我的收藏</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/collection.css">
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
                <li class="hover"><a href="/user/collection">我的收藏</a></li>
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
                <li><a href="/user/suggestlist">我的建议</a></li>
            </ul>
        </div>
    </div>
    <div class="content_rt">
        <div class="content_rt_top">
            <div class="content_tit lf">
                <p class="ctit">
                    我的收藏
                </p>
            </div>
            <div class="content_tab rt">
            <ul>
                <li>
                    <a href="javascript:;">商标 <span>[&nbsp;<i>0</i>&nbsp;]</span></a>
                </li>
                <li>
                    <a href="javascript:;">专利 <span>[&nbsp;<i>0</i>&nbsp;]</span></a>
                </li>
                <li>
                    <a href="javascript:;">版权 <span>[&nbsp;<i>0</i>&nbsp;]</span></a>
                </li>
                <li>
                    <a href="javascript:;">网店 <span>[&nbsp;<i>0</i>&nbsp;]</span></a>
                </li>
                <li>
                    <a href="javascript:;">网站 <span>[&nbsp;<i>0</i>&nbsp;]</span></a>
                </li>
                <li>
                    <a href="javascript:;">互联 <span>[&nbsp;<i>0</i>&nbsp;]</span></a>
                </li>
                <li>
                    <a href="javascript:;">企业 <span>[&nbsp;<i>0</i>&nbsp;]</span></a>
                </li>
            </ul>
        </div>
        </div>
        <div class="content_rt_bot">
            <ul>
                <#if userCollectData.l_UserCollect?exists>
	                 <#list userCollectData.l_UserCollect as userCollect>
	                     <#if userCollect.collectkind=='1'>
	                         <li>
			                    <div class="cont_img lf">
			                        <a href="http://ipr.w7tong.com/${userCollect.htmlpath?if_exists}" target="_blank"><img src="${userCollect.iconpath?if_exists}" alt="" width="80" height="80"></a>
			                    </div>
			                    <div class="cont_c lf">
			                        <p class="p1"><a href="http://ipr.w7tong.com/${userCollect.htmlpath?if_exists}" target="_blank">${userCollect.collectname?if_exists}</a></p>
			                        <p class="p2 price">价&emsp;&emsp;格： <span>¥${userCollect.price?if_exists}</span></p>
			                        <p class="shuoming p2">说明：${userCollect.productdesc?if_exists}</span></p>
			                    </div>
			                    <div class="delate">
			                        <a href="javascript:void(0);" data-id='${userCollect.collectid?if_exists}' data-kind='${userCollect.collectkind?if_exists}'></a>
			                    </div>
			                    <div class="cont_buy rt">
			                        <a href="http://ipr.w7tong.com/${userCollect.htmlpath?if_exists}" class="buy">立即购买</a>
			                        <a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" class="chat">立即咨询</a>
			                    </div>
			                </li>
	                     </#if>
	                     
	                     <#if userCollect.collectkind=='2'>
	                           <li>
				                    <div class="cont_img lf">
				                        <a href="http://ipr.w7tong.com/${userCollect.htmlpath?if_exists}" target="_blank"><img src="${userCollect.iconpath?if_exists}" alt="" width="80" height="80"></a>
				                    </div>
				                    <div class="cont_c lf">
				                        <p class="p1"><a href="http://ipr.w7tong.com/${userCollect.htmlpath?if_exists}" target="_blank">${userCollect.collectname?if_exists}</a></p>
				                        <p class="p2 price">价&emsp;&emsp;格： <span>¥${userCollect.price?if_exists}</span></p>
				                        <p class="p2">商品编号：${userCollect.shopcode?if_exists}</p>
				                    </div>
				                    <div class="delate">
				                        <a href="javascript:void(0);" data-id='${userCollect.collectid?if_exists}' data-kind='${userCollect.collectkind?if_exists}'></a>
				                    </div>
				                    <div class="cont_buy rt">
				                        <a href="http://ipr.w7tong.com/${userCollect.htmlpath?if_exists}" class="buy">立即购买</a>
				                        <a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" class="chat">立即咨询</a>
				                    </div>
				                </li>
	                     </#if>
	                     
	                     <#if userCollect.collectkind=='3'>
	                          <li>
			                    <div class="cont_img lf">
			                        <a href="http://es.w7tong.com/${userCollect.htmlpath?if_exists}" target="_blank"><img src="${userCollect.iconpath?if_exists}" alt="" width="80" height="80"></a>
			                    </div>
			                    <div class="cont_c lf">
			                       <p class="p1"><a href="http://es.w7tong.com/${userCollect.htmlpath?if_exists}" target="_blank">${userCollect.collectname?if_exists}</a></p>
			                        <p class="comp_bg p2">${userCollect.productdesc?if_exists}</p>
			                        <p class="p2 price">价&emsp;&emsp;格： <span>¥见产品详情</span></p>
			                    </div>
			                    <div class="delate">
			                        <a href="javascript:void(0);" data-id='${userCollect.collectid?if_exists}' data-kind='${userCollect.collectkind?if_exists}'></a>
			                    </div>
			                    <div class="cont_buy rt">
			                        <a href="http://es.w7tong.com/${userCollect.htmlpath?if_exists}" class="buy">立即购买</a>
			                        <a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" class="chat">立即咨询</a>
			                    </div>
			                </li>
	                     </#if>
	                     
	                     <#if userCollect.collectkind=='4'>
	                         <li>
			                    <div class="cont_img lf">
			                        <a href="http://es.w7tong.com/${userCollect.htmlpath?if_exists}" target="_blank"><img src="${userCollect.iconpath?if_exists}" alt="" width="80" height="80"></a>
			                    </div>
			                    <div class="cont_c lf">
			                        <p class="p1"><a href="http://es.w7tong.com/${userCollect.htmlpath?if_exists}" target="_blank">${userCollect.collectname?if_exists}</a></p>
			                        <p class="p2 price">价&emsp;&emsp;格： <span>¥${userCollect.price?if_exists}</span></p>
			                         <p class="p2">商品编号：${userCollect.shopcode?if_exists}</p>
			                    </div>
			                    <div class="delate">
			                        <a href="javascript:void(0);" data-id='${userCollect.collectid?if_exists}' data-kind='${userCollect.collectkind?if_exists}'></a>
			                    </div>
			                    <div class="cont_buy rt">
			                        <a href="http://es.w7tong.com/${userCollect.htmlpath?if_exists}" class="buy">立即购买</a>
				                    <a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" class="chat">立即咨询</a>
			                    </div>
			                </li>
	                     </#if>
						 
						 <#if userCollect.collectkind=='5'>
	                        <li>
				                    <div class="cont_img lf">
				                        <a href="http://wd.w7tong.com/${userCollect.htmlpath?if_exists}" target="_blank"><img src="${userCollect.iconpath?if_exists}" alt="" width="80" height="80"></a>
				                    </div>
				                    <div class="cont_c lf">
				                        <p class="p1"><a href="http://wd.w7tong.com/${userCollect.htmlpath?if_exists}" target="_blank">${userCollect.collectname?if_exists}</a></p>
				                        <p class="p2 price">价&emsp;&emsp;格： <span>¥${userCollect.price?if_exists}</span></p>
										<p class="p2">消保金额： <span>¥${userCollect.price?if_exists}</span></p>
				                        <p class="p2">商品编号：${userCollect.shopcode?if_exists}</p>
				                    </div>
				                    <div class="delate">
				                        <a href="javascript:void(0);" data-id='${userCollect.collectid?if_exists}' data-kind='${userCollect.collectkind?if_exists}'></a>
				                    </div>
				                    <div class="cont_buy rt">
				                        <a href="http://wd.w7tong.com/${userCollect.htmlpath?if_exists}" class="buy">立即购买</a>
				                        <a href="tencent://message/?uin=${wdworker.qq?if_exists}&amp;Site=&amp;menu=yes" class="chat">立即咨询</a>
				                    </div>
				                </li>
	                     </#if>
	                 </#list>
		        </#if>
		        <div class="company_list_result_pages">
                    <span class="backhome">
                       <a href="/user/collection/1" id="firstPage">第一页</a></span>
                    <span class="prevpage">
                         <#if userCollectData.pagenum?number gt 1>
                             <a href="/user/collection/${userCollectData.pagenum-1}" id="prevA0">上一页</a>
                         <#else>
                              <a href="javascript:;" id="prevA0">上一页</a>
                         </#if>
                    </span>
                    <span class="nextpage">
                         <#if userCollectData.pagenum?number lt userCollectData.collectpage?number>
                             <a href="/user/collection/${userCollectData.pagenum+1}" id="nextA0">下一页</a>
                          <#else>
                               <a href="javascript:;" id="nextA0">下一页</a>
                           </#if>
                    </span>
                    <span class="lastpage">
                        <a href="/user/collection/${userCollectData.collectpage}" id="nextPage0">尾页</a>
                    </span>
                    <span class="total">
                        共<span id="allPage2">${userCollectData.collectpage}</span>页/当前为第
                        <strong id="nowPage2">${userCollectData.pagenum}</strong>
                        页
                    </span>
                </div>
            </ul>
        </div>
    </div>
</div>
<!--底部-->
<#include "/templates/footer.ftl">
</body>
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/usercenter/js/collection.js"></script>
</html>