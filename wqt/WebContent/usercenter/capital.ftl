<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>资金明细</title>
	<link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/capital.css">
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
                <li class="hover"><a href="/user/capital">资金明细</a></li>
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
        <div class="content_tab">
            <ul>
                <li class="on"><a href="/user/capital">资金明细</a></li>
                <li><a href="/user/recharge">我要充值</a></li>
                <li><a href="/user/withdraw">我要提现</a></li>
                <li><a href="/user/bill">发票索取</a></li>
                <li><a href="/user/bank">绑定银行卡</a></li>
            </ul>
        </div>
        <div class="money_tab clear">
            <ul>
                <li class="on">全部明细</li>
                <li>支出明细</li>
                <li>充值明细</li>
                <li>提现明细</li>
                <!--<li>冻结明细</li>-->
            </ul>
            <p class="money_chat rt">
                <a href="" target="_blank">联系资金客服</a>
            </p>
        </div>
        <#assign allnum=0>
        <#assign state1num=0>
        <#assign state2num=0>
        <#assign state3num=0>
        <#assign state4num=0>
        <!--全部明细-->
        <div class="all_cont on">
            <ul>
                <li class="all_cont_title">
                    <span>日期</span>
                    <span>流水号</span>
                    <span>收/支</span>
                    <span>状态</span>
                    <span>详细说明</span>
                </li>
                <#if capitalAccountList.l_WqtCapitalAccount?exists>
                    <#assign allnum=1>
	                <#list capitalAccountList.l_WqtCapitalAccount as wqtCapitalAccount>
		                <li class="all_cont_net">
		                    <span>${wqtCapitalAccount.accounttime?if_exists} </span>
		                    <span>${wqtCapitalAccount.streamno?if_exists} </span>
		                    <span class="cont_money">
		                       <#if wqtCapitalAccount.kind?string=='1' || wqtCapitalAccount.kind?string=='4' || wqtCapitalAccount.kind?string=='5'> 
		                           +${wqtCapitalAccount.money?if_exists}
		                       <#else>
		                           -${wqtCapitalAccount.money?if_exists}
		                       </#if>
		                    </span>
		                    <span class="state">
		                        <#if wqtCapitalAccount.state?string=='1'>
		                          确认中
		                        <#elseif  wqtCapitalAccount.state?string=='2'>
		                       已完成                 
		                        <#else>
		                          确认中
		                        </#if>
		                    </span>
		                    <span>
		                     <#if wqtCapitalAccount.resultcode?exists>
		                       <#if wqtCapitalAccount.resultcode?string=='1'>
		                            <#if wqtCapitalAccount.kind?string=='1'> 
		                                                                                                                充值成功
		                            <#elseif  wqtCapitalAccount.kind?string=='2'> 
		                                 提现成功
		                            <#elseif  wqtCapitalAccount.kind?string=='3'>
		                              付款成功
		                            <#elseif  wqtCapitalAccount.kind?string=='4'>
		                              收款成功
		                            <#elseif  wqtCapitalAccount.kind?string=='5'>
		                              退款成功
		                            <#elseif  wqtCapitalAccount.kind?string=='6'>
		                              退款成功
		                            <#else>
		                              未知成功
		                             </#if>  
		                        <#elseif  wqtCapitalAccount.resultcode?string=='2'>
		                            <#if wqtCapitalAccount.kind?string=='1'> 
		                                                                                                                充值失败  
		                            <#elseif  wqtCapitalAccount.kind?string=='2'> 
		                                 提现失败  
		                            <#elseif  wqtCapitalAccount.kind?string=='3'>
		                              付款失败  
		                            <#elseif  wqtCapitalAccount.kind?string=='4'>
		                              收款失败  
		                            <#elseif  wqtCapitalAccount.kind?string=='5'>
		                              退款失败  
		                            <#elseif  wqtCapitalAccount.kind?string=='6'>
		                              退款失败  
		                            <#else>
		                              未知失败  
		                             </#if> 
		                        <#else>
		                           失败
		                        </#if>
		                      </#if>
                            </span>
		                </li>
                    </#list>
                </#if>
            </ul>
            <#if allnum lt 1>
	            <!--没数据显示-->
	            <div class="data_null">
	                <p>您现在还没有该明细可以查看哦</p>
	                <a href="/" target="_blank">去首页看看</a>
	            </div>
            </#if>
            <#if allnum gt 0>
	            <!--分页-->
	            <div class="company_list_result_pages">
	                <span class="backhome">
	                    <a href="/user/capital/1" id="firstPage0">首页</a>
	                </span>
	                <span class="prevpage">
	                  <#if capitalAccountList.pagenum?number gt 1>
                         <a href="/user/capital/${capitalAccountList.pagenum?number-1}" id="prevA0">上一页</a>
                      <#else>
                         <a href="javascript:;" id="prevA0">上一页</a>
                      </#if>
	                </span>
	                <span class="nextpage">
	                     <#if capitalAccountList.pagenum?number lt capitalAccountList.accountpage?number>
	                         <a href="/user/capital/${capitalAccountList.pagenum?number+1}" id="nextA0">下一页</a>
	                      <#else>
	                         <a href="javascript:;" id="nextA0">下一页</a>
	                      </#if>
	                </span>
	                <span class="lastpage">
	                    <a href="/user/capital/${capitalAccountList.accountpage}" id="nextPage0">尾页</a>
	                </span>
	                <span class="total">
	                        共<span id="allPage20">${capitalAccountList.accountpage}</span>页/当前为第
	                        <strong id="nowPage20">${capitalAccountList.pagenum}</strong>
	                        页
	                </span>
	            </div>
             </#if>
        </div>
        <!--支出明细-->
        <div class="all_cont">
            <ul>
                <li class="all_cont_title">
                    <span>日期</span>
                    <span>流水号</span>
                    <span>收/支</span>
                    <span>状态</span>
                    <span>详细说明</span>
                </li>
                 <#if capitalAccountList.l_WqtCapitalAccount?exists>
                    <#assign state1num=1>
	                <#list capitalAccountList.l_WqtCapitalAccount as wqtCapitalAccount>
	                  <#if  wqtCapitalAccount.kind?string=='3' || wqtCapitalAccount.kind?string=='6'>
		                <li class="all_cont_net">
		                    <span>${wqtCapitalAccount.accounttime?if_exists} </span>
		                    <span>${wqtCapitalAccount.streamno?if_exists} </span>
		                    <span class="cont_money">
		                       <#if wqtCapitalAccount.kind?string=='1' || wqtCapitalAccount.kind?string=='4' || wqtCapitalAccount.kind?string=='5'> 
		                           +${wqtCapitalAccount.money?if_exists}
		                       <#else>
		                           -${wqtCapitalAccount.money?if_exists}
		                       </#if>
		                    </span>
		                    <span class="state">
		                        <#if wqtCapitalAccount.state?string=='1'>
		                          确认中
		                        <#elseif  wqtCapitalAccount.state?string=='2'>
		                       已完成                 
		                        <#else>
		                          确认中
		                        </#if>
		                    </span>
		                    <span>
		                      <#if wqtCapitalAccount.resultcode?exists>
		                        <#if wqtCapitalAccount.resultcode?string=='1'>
		                            <#if wqtCapitalAccount.kind?string=='1'> 
		                                                                                                                充值成功
		                            <#elseif  wqtCapitalAccount.kind?string=='2'> 
		                                 提现成功
		                            <#elseif  wqtCapitalAccount.kind?string=='3'>
		                              付款成功
		                            <#elseif  wqtCapitalAccount.kind?string=='4'>
		                              收款成功
		                            <#elseif  wqtCapitalAccount.kind?string=='5'>
		                              退款成功
		                            <#elseif  wqtCapitalAccount.kind?string=='6'>
		                              退款成功
		                            <#else>
		                              未知成功
		                             </#if>                                                                                
		                        <#elseif  wqtCapitalAccount.resultcode?string=='2'>
		                           <#if wqtCapitalAccount.kind?string=='1'> 
		                                                                                                                充值失败  
		                            <#elseif  wqtCapitalAccount.kind?string=='2'> 
		                                 提现失败  
		                            <#elseif  wqtCapitalAccount.kind?string=='3'>
		                              付款失败  
		                            <#elseif  wqtCapitalAccount.kind?string=='4'>
		                              收款失败  
		                            <#elseif  wqtCapitalAccount.kind?string=='5'>
		                              退款失败  
		                            <#elseif  wqtCapitalAccount.kind?string=='6'>
		                              退款失败  
		                            <#else>
		                              未知失败  
		                             </#if> 
		                        <#else>
		                          未知 失败
		                        </#if>
		                      </#if>
                            </span>
		                </li>
		              </#if>
                    </#list>
                </#if>
            </ul>
            <#if state1num lt 1>
	            <!--没数据显示-->
	            <div class="data_null">
	                <p>您现在还没有该明细可以查看哦</p>
	                <a href="/" target="_blank">去首页看看</a>
	            </div>
            </#if>
           <#if state1num gt 0>
	            <!--分页-->
	            <div class="company_list_result_pages">
	                <span class="backhome">
	                    <a href="/user/capital/1" id="firstPage0">首页</a>
	                </span>
	                <span class="prevpage">
	                  <#if capitalAccountList.pagenum?number gt 1>
                         <a href="/user/capital/${capitalAccountList.pagenum?number-1}" id="prevA0">上一页</a>
                      <#else>
                         <a href="javascript:;" id="prevA0">上一页</a>
                      </#if>
	                </span>
	                <span class="nextpage">
	                     <#if capitalAccountList.pagenum?number lt capitalAccountList.accountpage?number>
	                         <a href="/user/capital/${capitalAccountList.pagenum?number+1}" id="nextA0">下一页</a>
	                      <#else>
	                         <a href="javascript:;" id="nextA0">下一页</a>
	                      </#if>
	                </span>
	                <span class="lastpage">
	                    <a href="/user/capital/${capitalAccountList.accountpage}" id="nextPage0">尾页</a>
	                </span>
	                <span class="total">
	                        共<span id="allPage20">${capitalAccountList.accountpage}</span>页/当前为第
	                        <strong id="nowPage20">${capitalAccountList.pagenum}</strong>
	                        页
	                </span>
	            </div>
             </#if>
        </div>
        <!--充值明细-->
        <div class="all_cont">
            <ul>
                <li class="all_cont_title">
                    <span>日期</span>
                    <span>流水号</span>
                    <span>收/支</span>
                    <span>状态</span>
                    <span>详细说明</span>
                </li>
                <#if capitalAccountList.l_WqtCapitalAccount?exists>
                    <#assign state2num=2>
	                <#list capitalAccountList.l_WqtCapitalAccount as wqtCapitalAccount>
	                  <#if wqtCapitalAccount.kind?string=='1'>
		                <li class="all_cont_net">
		                    <span>${wqtCapitalAccount.accounttime?if_exists} </span>
		                    <span>${wqtCapitalAccount.streamno?if_exists} </span>
		                    <span class="cont_money">
		                           +${wqtCapitalAccount.money?if_exists}
		                    </span>
		                    <span class="state">
		                        <#if wqtCapitalAccount.state?string=='1'>
		                          确认中
		                        <#elseif  wqtCapitalAccount.state?string=='2'>
		                       已完成                 
		                        <#else>
		                          确认中
		                        </#if>
		                    </span>
		                    <span>
		                       <#if wqtCapitalAccount.resultcode?string=='1'>
		                         成功
		                        <#elseif  wqtCapitalAccount.resultcode?string=='2'>
		                      失败              
		                        <#else>
		                           失败
		                        </#if>
                            </span>
		                </li>
		               </#if>
                    </#list>
                </#if>
            </ul>
            <#if state2num lt 1>
	            <!--没数据显示-->
	            <div class="data_null">
	                <p>您现在还没有该明细可以查看哦</p>
	                <a href="/" target="_blank">去首页看看</a>
	            </div>
            </#if>
            <#if state2num gt 0>
	            <!--分页-->
	            <div class="company_list_result_pages">
	                <span class="backhome">
	                    <a href="/user/capital/1" id="firstPage0">首页</a>
	                </span>
	                <span class="prevpage">
	                  <#if capitalAccountList.pagenum?number gt 1>
                         <a href="/user/capital/${capitalAccountList.pagenum?number-1}" id="prevA0">上一页</a>
                      <#else>
                         <a href="javascript:;" id="prevA0">上一页</a>
                      </#if>
	                </span>
	                <span class="nextpage">
	                     <#if capitalAccountList.pagenum?number lt capitalAccountList.accountpage?number>
	                         <a href="/user/capital/${capitalAccountList.pagenum?number+1}" id="nextA0">下一页</a>
	                      <#else>
	                         <a href="javascript:;" id="nextA0">下一页</a>
	                      </#if>
	                </span>
	                <span class="lastpage">
	                    <a href="/user/capital/${capitalAccountList.accountpage}" id="nextPage0">尾页</a>
	                </span>
	                <span class="total">
	                        共<span id="allPage20">${capitalAccountList.accountpage}</span>页/当前为第
	                        <strong id="nowPage20">${capitalAccountList.pagenum}</strong>
	                        页
	                </span>
	            </div>
             </#if>
        </div>
        <!--提现明细-->
        <div class="all_cont">
            <ul>
                <li class="all_cont_title">
                     <span>日期</span>
                    <span>流水号</span>
                    <span>收/支</span>
                    <span>状态</span>
                    <span>详细说明</span>
                </li>
                <#if capitalAccountList.l_WqtCapitalAccount?exists>
                    <#assign state3num=1>
	                <#list capitalAccountList.l_WqtCapitalAccount as wqtCapitalAccount>
	                  <#if wqtCapitalAccount.kind?string=='2'>
		                <li class="all_cont_net">
		                    <span>${wqtCapitalAccount.accounttime?if_exists} </span>
		                    <span>${wqtCapitalAccount.streamno?if_exists} </span>
		                    <span class="cont_money">
		                           -${wqtCapitalAccount.money?if_exists}
		                    </span>
		                    <span class="state">
		                        <#if wqtCapitalAccount.state?string=='1'>
		                          确认中
		                        <#elseif  wqtCapitalAccount.state?string=='2'>
		                       已完成                 
		                        <#else>
		                          确认中
		                        </#if>
		                    </span>
		                    <span>
		                       <#if wqtCapitalAccount.resultcode?string=='1'>
		                         成功
		                        <#elseif  wqtCapitalAccount.resultcode?string=='2'>
		                      失败              
		                        <#else>
		                           失败
		                        </#if>
                            </span>
		                </li>
		               </#if>
                    </#list>
                </#if>
            </ul>
            <#if state3num lt 1>
	            <!--没数据显示-->
	            <div class="data_null">
	                <p>您现在还没有该明细可以查看哦</p>
	                <a href="/" target="_blank">去首页看看</a>
	            </div>
            </#if>
            <#if state3num gt 0>
	            <!--分页-->
	            <div class="company_list_result_pages">
	                <span class="backhome">
	                    <a href="/user/capital/1" id="firstPage0">首页</a>
	                </span>
	                <span class="prevpage">
	                  <#if capitalAccountList.pagenum?number gt 1>
                         <a href="/user/capital/${capitalAccountList.pagenum?number-1}" id="prevA0">上一页</a>
                      <#else>
                         <a href="javascript:;" id="prevA0">上一页</a>
                      </#if>
	                </span>
	                <span class="nextpage">
	                     <#if capitalAccountList.pagenum?number lt capitalAccountList.accountpage?number>
	                         <a href="/user/capital/${capitalAccountList.pagenum?number+1}" id="nextA0">下一页</a>
	                      <#else>
	                         <a href="javascript:;" id="nextA0">下一页</a>
	                      </#if>
	                </span>
	                <span class="lastpage">
	                    <a href="/user/capital/${capitalAccountList.accountpage}" id="nextPage0">尾页</a>
	                </span>
	                <span class="total">
	                        共<span id="allPage20">${capitalAccountList.accountpage}</span>页/当前为第
	                        <strong id="nowPage20">${capitalAccountList.pagenum}</strong>
	                         页
	                </span>
	            </div>
             </#if>
        </div>
	</div>
</div>
<!--底部-->
<#include "/templates/footer.ftl">
</body>
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/usercenter/js/capital.js"></script>
</html>