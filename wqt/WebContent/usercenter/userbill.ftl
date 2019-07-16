<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>发票索取</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/bill.css">
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
                <li><a href="/user/capital">资金明细</a></li>
                <li class="hover"><a href="/user/bill">索取发票</a></li>
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
                <li><a href="/user/capital">资金明细</a></li>
                <li><a href="/user/recharge">我要充值</a></li>
                <li><a href="/user/withdraw">我要提现</a></li>
                <li class="on"><a href="/user/bill">发票索取</a></li>
                <li><a href="/user/bank">绑定银行卡</a></li>
            </ul>
        </div>
        <div class="money_tab clear">
            <ul>
                <li class="on">索取发票</li>
            </ul>
            <p class="money_chat rt">
                <a href="" target="_blank">联系资金客服</a>
            </p>
        </div>
        <div class="bill_tab">
            <ul>
                  <li class="bill_title_a">
                    <span><!--全选 <input type="checkbox" id="all_checkbox" class="all_checkbox">--></span>
                    <span>商品名称</span>
                    <span>订单编号（元）</span>
                    <span>订单金额（元）</span>
                    <span>服务类型</span>
                  </li>
		          <#if userBillData.l_UsercenterOrder?exists>
	                <#list userBillData.l_UsercenterOrder as usercenterOrder>
		                <li class="bill_title_b">
		                    <span><input type="radio" name="radioname" class="checkbox" data-id='${usercenterOrder.orderid?if_exists}' data-mon='${usercenterOrder.orderallmoney?if_exists}'></span>
		                    <span>${usercenterOrder.ordershopname?if_exists}</span>
		                    <span>${usercenterOrder.ordercode?if_exists}</span>
		                    <span>${usercenterOrder.orderallmoney?if_exists}</span>
		                    <span>
		                           <#if usercenterOrder.orderkind=='1'>
		                                                                                                                      商标服务
		                           <#elseif usercenterOrder.orderkind=='2'>
		                                                                                                                     版权服务
		                           <#elseif usercenterOrder.orderkind=='3'>
		                                                                                                                      专利服务
		                           <#elseif usercenterOrder.orderkind=='4'>
		                                                                                                                      商标交易
		                           <#elseif usercenterOrder.orderkind=='5'>
		                                                                                                                      版权交易
		                           <#elseif usercenterOrder.orderkind=='6'>
		                                                                                                                      专利交易
		                           <#elseif usercenterOrder.orderkind=='qyjy'>
		                                                                                                                       企业交易
		                           <#else>
		                                                                                                                      企业服务
		                           </#if>                                                                                           
		                    </span>
		                </li>
                  </#list>
		        </#if>
                <li>
                    <a href="javascript:;" id="need_p">发票索取</a>
                </li>
            </ul>
            <!--分页-->
            <div class="company_list_result_pages">
                <span class="backhome">
                    <a href="/user/bill/1" id="firstPage0">首页</a>
                 </span>
                <span class="prevpage">
                    <#if userBillData.pagenum?number gt 1>
                        <a href="/user/bill/${userBillData.pagenum-1}" id="prevA0">上一页</a>
                    <#else>
                         <a href="javascript:;" id="prevA0">上一页</a>
                    </#if>
                </span>
               
                <span class="nextpage">
                   <#if userBillData.pagenum?number lt userBillData.orderpage?number>
                       <a href="/user/bill/${userBillData.pagenum+1}" id="nextA0">下一页</a>
                   <#else>
                        <a href="" id="nextA0">下一页</a>
                    </#if>
                </span>
                <span class="lastpage">
                        <a href="/user/bill/${userBillData.orderpage}" id="nextPage0">尾页</a>
                    </span>
                <span class="total">
                        共<span id="allPage20">${userBillData.orderpage}</span>页/当前为第
                        <strong id="nowPage20">${userBillData.pagenum}</strong>
                        页
                </span>
            </div>
            <!--没数据显示-->
           <#if userBillData.l_UsercenterOrder?exists>
           <#else>
	            <div class="ttab_data ">
	                <div class="data_null">
	                    <p>您现在还没有发票可开哦</p>
	                    <a href="/">去首页看看</a>
	                </div>
	            </div>
          </#if>
        </div>
        <div class="bill_cont" style="display: none;">
            <div class="bill_cont_a">
                <ul class="clear">
                    <li>
                        <div class="bill_a">开票类型：</div>
                        <div class="bill_b">
                            <select id='bill_kind'>
                                <option>请选择开票类型</option>
                                <option value="1">公司</option>
                                <option value="2">个人</option>
                            </select>
                        </div>
                    </li>
                    <li>
                        <div class="bill_a">发票开头：</div>
                        <div class="bill_b">
                            <input type="text" id='bill_bagin'>
                        </div>
                    </li>
                    <li>
                        <div class="bill_a">收件人地址：</div>
                        <div class="bill_b">
                            <select id='province'>
                                <option value="">请选择省份</option>
                            </select>
                            <select id='city'>
                                <option value="">请选择市区</option>
                            </select>
                        </div>
                    </li>
                    <li>
                        <input type="text" class="detail_address" placeholder="请输入详细地址">
                    </li>
                    <li>
                        <div class="bill_a">收件人姓名：</div>
                        <div class="bill_b">
                            <input type="text" placeholder="请输入收件人姓名" id='s_name'>
                        </div>
                    </li>
                    <li>
                        <div class="bill_a">收件人电话：</div>
                        <div class="bill_b">
                            <input type="text" placeholder="请输入收件人电话" id='s_phone'>
                        </div>
                    </li>
                    <li>
                        <p class="kp">
                            <a href="javascript:;" class="kp_btn now_kp_btn">立即开票</a>
                            <a href="javascript:;" class="kp_btn qx_kp_btn">取消</a>
                            <span class="wxts">(温馨提醒:发票开票金额为平台服务费金额！)</span>
                        </p>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--底部-->
<#include "/templates/footer.ftl">
</body>
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/layui/layui.js"></script>
<script src="/usercenter/js/bill.js"></script>
</html>