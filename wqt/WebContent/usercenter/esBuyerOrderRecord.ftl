<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>企业服务-订单列表</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/record.css">
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
                    <li class="hover"><a href="/order/es/buyer/list">我的企业</a></li>
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
                    <li><a href="/user/suggestlist">我的建议</a></li>
                </ul>
            </div>
    </div>


    <div class="content_rt">
        <h4 class="theme">我的订单</h4>
        <input style="display:none;" class="order_checked">
        <ul class="indent_state">
          <#if esBuyerOrderList.orderstate=='0'>
            <li class="active">
                <a href="/order/es/buyer/list">全部订单</a>
                <i></i>
            </li>
          <#else>
            <li >
                <a href="/order/es/buyer/list">全部订单</a>
                <i></i>
            </li>
          </#if>
          
          <#if esBuyerOrderList.orderstate=='1'>
            <li class="active">
                <a href="/order/es/buyer/1/list/1">待付款订单</a>
                <i></i>
            </li>
         <#else>
            <li>
                <a href="/order/es/buyer/1/list/1">待付款订单</a>
                <i></i>
            </li>
         </#if>   
         <#if esBuyerOrderList.orderstate=='2'>
            <li class="active">
                <a href="/order/es/buyer/2/list/1">已预订的订单</a>
                <i></i>
            </li>
         <#else>
           <li>
                <a href="/order/es/buyer/2/list/1">已预订的订单</a>
                <i></i>
            </li>
         </#if>     
            
         <#if esBuyerOrderList.orderstate=='3'>
            <li class="active">
                <a href="/order/es/buyer/3/list/1">交接中的订单</a>
                <i></i>
            </li>
         <#else>
           <li>
                <a href="/order/es/buyer/3/list/1">交接中的订单</a>
                <i></i>
            </li>
         </#if>
         <#if esBuyerOrderList.orderstate=='4'>
            <li class="active">
                <a href="/order/es/buyer/4/list/1">已完成的订单</a>
                <i></i>
            </li>
         <#else>
            <li>
                <a href="/order/es/buyer/4/list/1">已完成的订单</a>
                <i></i>
            </li>
          </#if>
        </ul>
        <!--<div class="search_box">
            <input type="text" placeholder="请输入您要查找的订单号">
            <a href="javascript:;">搜索</a>
        </div>-->
        <div class="order_tab">
            <ul>
                <li>订单详情</li>
                <li>数量</li>
                <li>价格</li>
                <li>订单状态</li>
                <li>订单操作</li>
                <li>客服信息</li>
            </ul>
        </div>
       
        <#assign allnum=0>
        <!--全部订单-->
        <div class="ttab on" id="all_order">
            <!--有数据加on 否则给class="ttab_data"加on-->
            <div class="ttab_data on">
               <#if esBuyerOrderList.l_EsOrder?exists>
                  <#assign allnum=1>
                   <#list esBuyerOrderList.l_EsOrder as esOrder>
                   <#if esOrder.orderkindkey=='qyjy'>
                <!--企业转让-->
                <div class="brand_order">
                    <div class="order_number">
						<#if esOrder.orderstate=='3' || esOrder.orderstate=='4'>
                        <input type="checkbox" class="order_checked" name="comp_order" disabled="disabled">
						<#else>
						<input type="checkbox" class="order_checked" name="comp_order" data-pri='${esOrder.orderallmoney?if_exists}' data-favourabl='${esOrder.favourablemoney?if_exists}' >
						</#if>
                        <span class="order_time">${esOrder.ordertime?if_exists}</span>
                        <span>订单号：${esOrder.ordercode?if_exists}</span>
                    </div>
                    <div class="order_det clearfix">
                        <div class="pay_info">
                            <div class="img">
                                <a href="/${esOrder.htmlpath?if_exists}" target="_blank">
                                    <img src="${esOrder.ordershopicon?if_exists}" width="100" height="100" alt="">
                                </a>
                            </div>
                            <div class="info">
                                <div class="info_ul clear">
                                    <ul class="txt lf">
                                        <li>
                                            <div class="info_tit">
                                                <span class="info_tit01">公司名称</span>
                                                <a href="/${esOrder.htmlpath?if_exists}" target="_blank" class="info_tit02">${esOrder.ordershopname?if_exists}</a>
                                            </div>
                                        </li>
                                        <li>企业行业：${esOrder.ordercompanyinduty?if_exists}</li>
                                        <li>企业类型：${esOrder.ordercompanytype?if_exists}</li>
                                        <li>经营时间：
                                              <#if  esOrder.orderholddate?string=='1'>
								                  1年以下
								              <#elseif  esOrder.orderholddate?string=='2'>
								                  1-2年
								              <#elseif  esOrder.orderholddate?string=='3'>
								                 2-3年
								              <#elseif  esOrder.orderholddate?string=='4'>
								                   3年以上
								              </#if>
                                        </li>
                                        <li>注册资本：
                                               <#if  esOrder.orderregcapital?string=='1'>
								                   50万以下
								              <#elseif  esOrder.orderregcapital?string=='2'>
								                   50-100万
								              <#elseif  esOrder.orderregcapital?string=='3'>
								                   100-500万
								              <#elseif  esOrder.orderregcapital?string=='4'>
								                   500-1000万
								              <#elseif  esOrder.orderregcapital?string=='5'>
								                   1000万以上
								              </#if>
                                        </li>
                                        <li>商品编号：${esOrder.ordershopcode?if_exists}</li>
                                    </ul>
                                    <div class="numm lf">
                                        <span>1</span>
                                    </div>
                                    <div class="detail lf">
                                        <ul>
                                            <li>
                                                <span>总计应付：</span>
                                                <b class="number">￥${esOrder.orderallmoney?if_exists}</b>
                                            </li>
                                            <li>
                                                <span>单   价：</span>
                                                <b class="pr_number">￥${esOrder.shopprice?if_exists}</b>
                                            </li>
                                            <li>
                                                <span>已   付：</span>
                                                <b class="number">￥
                                                    <#if esOrder.paymoney?exists>
                                                        ${esOrder.paymoney?if_exists}
                                                    <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                            <li>
                                                <span>服务费：</span>
                                                <b class="number">￥
                                                    <#if esOrder.orderservicemoney?exists>
                                                        ${esOrder.orderservicemoney?if_exists}
                                                    <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                            <li>
                                                <span>优   惠：</span>
                                                <b class="number">￥
                                                     <#if esOrder.favourablemoney?exists>
                                                        ${esOrder.favourablemoney?if_exists}
                                                     <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="ddzt lf">
                                        <#if esOrder.orderstate=='1'>
	                                        <span>未付款</span>
	                                     <#elseif esOrder.orderstate=='2'> 
	                                        <span>已付定金</span>
	                                     <#elseif esOrder.orderstate=='3'> 
	                                        <span>已付款</span>
	                                     <#elseif esOrder.orderstate=='4'> 
	                                        <span>交易完成</span>
	                                     <#elseif esOrder.orderstate=='5'> 
	                                        <span>订单取消</span>
	                                     <#else>
										  	<span>交易完成</span>
										 </#if>
                                </div>
                                <div class="order_shop lf">
                                    <ul>
                                         <#if esOrder.orderstate=='1'>
	                                        <li>
	                                            <a href="/order/pay/${esOrder.ordercode?if_exists}/type/4">去付款</a>
	                                        </li>
	                                        <li>
	                                            <a href="/order/buyer/es/cancel/${esOrder.ordercode?if_exists}/type/4">取消订单</a>
	                                        </li>
	                                     <#elseif esOrder.orderstate=='2'> 
	                                        <li>
	                                            <a href="/order/pay/${esOrder.ordercode?if_exists}/type/4">支付余款</a>
	                                        </li>
	                                        <li>
	                                            <a href="/order/buyer/es/cancel/${esOrder.ordercode?if_exists}/type/4">取消订单</a>
	                                        </li>
	                                     <#elseif esOrder.orderstate=='3'> 
	                                        <li>
	                                            <a href="">订单详情</a>
	                                        </li>
	                                     <#elseif esOrder.orderstate=='4'> 
	                                        <li>
	                                            <a href="">订单详情</a>
	                                        </li>
	                                     <#elseif esOrder.orderstate=='5'> 
                                            <li>
                                                                                                                                                                    订单已取消
                                            </li>
                                            <li>
                                            </li>
	                                     <#else>
                                            <li>
                                                <a href="">订单详情</a>
                                            </li>
                                            <li>
                                            </li>
										 </#if>
                                    </ul>
                                </div>
                        </div>
                    </div>
                    <div class="pay_service rt">
                        <dl>
                            <dt>
                                <img src="${wqtworker.headurl?if_exists}" style="width:100%" alt="">
                            </dt>
                            <dd class="txt01">${wqtworker.workername?if_exists}</dd>
                            <dd class="txt02">您的订单专属客服</dd>
                            <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
                        </dl>
                     </div>
                </div>
                    </div>
                </div>
                </#if>
                <!--企业服务-->
                <!--公司变更-->
                <#if esOrder.orderkindkey=='gsbg'>
                <div class="brand_order">
                    <div class="order_number">
                        <#if esOrder.orderstate=='3' || esOrder.orderstate=='4'>
                        <input type="checkbox" class="order_checked" name="comp_order" disabled="disabled">
						<#else>
						<input type="checkbox" class="order_checked" name="comp_order" data-pri='${esOrder.orderallmoney?if_exists}' data-favourabl='${esOrder.favourablemoney?if_exists}' >
						</#if>
                        <span class="order_time">${esOrder.ordertime?if_exists}</span>
                        <span>订单号：${esOrder.ordercode?if_exists}</span>
                    </div>
                    <div class="order_det clearfix">
                        <div class="pay_info">
                            <div class="img">
                                <a href="http://es.w7tong.com/${esOrder.htmlpath?if_exists}" target="_blank">
                                    <img src="${esOrder.ordershopicon?if_exists}" width="100" height="100" alt="">
                                </a>
                            </div>
                            <div class="info">
                                <div class="info_ul clear">
                                    <ul class="txt lf">
                                        <li>
                                            <div class="info_tit">
                                                <span class="info_tit01">企业变更</span>
                                                <a href="http://es.w7tong.com/${esOrder.htmlpath?if_exists}" target="_blank" class="info_tit02">公司变更服务</a>
                                            </div>
                                        </li>
                                        <li>服务类型：${esOrder.ordershopname?if_exists}</li>
                                        <li>公司类型：${esOrder.ordercompanytype?if_exists}</li>
                                        <li>注册省份：${esOrder.orderprovincename?if_exists}</li>
                                        <li>注册市区：${esOrder.ordercityname?if_exists}</li>
                                    </ul>
                                    <div class="numm lf">
                                        <span>1</span>
                                    </div>
                                    <div class="detail lf">
                                       <ul>
                                            <li>
                                                <span>总计应付：</span>
                                                <b class="number">￥${esOrder.orderallmoney?if_exists}</b>
                                            </li>
                                            <li>
                                                <span>单   价：</span>
                                                <b class="pr_number">￥${esOrder.shopprice?if_exists}</b>
                                            </li>
                                            <li>
                                                <span>已   付：</span>
                                                <b class="number">￥
                                                    <#if esOrder.paymoney?exists>
                                                        ${esOrder.paymoney?if_exists}
                                                    <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                            <li>
                                                <span>服务费：</span>
                                                <b class="number">￥
                                                    <#if esOrder.orderservicemoney?exists>
                                                        ${esOrder.orderservicemoney?if_exists}
                                                    <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                            <li>
                                                <span>优   惠：</span>
                                                <b class="number">￥
                                                     <#if esOrder.favourablemoney?exists>
                                                        ${esOrder.favourablemoney?if_exists}
                                                     <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="ddzt lf">
                                         <#if esOrder.orderstate=='1'>
	                                        <span>未付款</span>
	                                     <#elseif esOrder.orderstate=='2'> 
	                                        <span>已付定金</span>
	                                     <#elseif esOrder.orderstate=='3'> 
	                                        <span>已付款</span>
	                                     <#elseif esOrder.orderstate=='4'> 
	                                        <span>交易完成</span>
	                                     <#elseif esOrder.orderstate=='5'> 
	                                        <span>订单取消</span>
	                                     <#else>
										  	<span>交易完成</span>
										 </#if>
                                    </div>
                                    <div class="order_shop lf">
                                        <ul>
                                             <#if esOrder.orderstate=='1'>
		                                        <li>
	                                                <a href="/order/pay/${esOrder.ordercode?if_exists}/type/3">去付款</a>
	                                            </li>
	                                            <li>
	                                                <a href="/order/buyer/es/cancel/${esOrder.ordercode?if_exists}/type/3">取消订单</a>
	                                            </li>
		                                     <#elseif esOrder.orderstate=='2'> 
		                                         <li>
	                                                <a href="/order/pay/${esOrder.ordercode?if_exists}/type/3">去付款</a>
	                                            </li>
	                                            <li>
	                                                <a href="/order/buyer/es/cancel/${esOrder.ordercode?if_exists}/type/3">取消订单</a>
	                                            </li>
		                                     <#elseif esOrder.orderstate=='3'> 
		                                         <li>
		                                            <a href="">订单详情</a>
		                                         </li>
		                                     <#elseif esOrder.orderstate=='4'> 
		                                        <li>
		                                            <a href="">订单详情</a>
		                                        </li>
		                                     <#elseif esOrder.orderstate=='5'> 
	                                            <li>
	                                                                                                                                                                    订单已取消
	                                            </li>
	                                            <li>
	                                            </li>
		                                     <#else>
	                                            <li>
	                                                <a href="">订单详情</a>
	                                            </li>
	                                            <li>
	                                            </li>
											 </#if>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="pay_service rt">
		                         <dl>
		                            <dt>
		                                <img src="${wqtworker.headurl?if_exists}" style="width:100%" alt="">
		                            </dt>
		                            <dd class="txt01">${wqtworker.workername?if_exists}</dd>
		                            <dd class="txt02">您的订单专属客服</dd>
		                            <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
		                        </dl>
		                     </div>
                        </div>
                    </div>
                </div>
                </#if>
                <!--公司注册-->
                <#if esOrder.orderkindkey=='gszc'>
                <div class="brand_order">
                    <div class="order_number">
                       <#if esOrder.orderstate=='3' || esOrder.orderstate=='4'>
                        <input type="checkbox" class="order_checked" name="comp_order" disabled="disabled">
						<#else>
						<input type="checkbox" class="order_checked" name="comp_order" data-pri='${esOrder.orderallmoney?if_exists}' data-favourabl='${esOrder.favourablemoney?if_exists}' >
						</#if>
                        <span>订单号：${esOrder.ordercode?if_exists}</span>
                    </div>
                    <div class="order_det clearfix">
                        <div class="pay_info">
                           <div class="img">
                                <a href="http://es.w7tong.com/${esOrder.htmlpath?if_exists}" target="_blank">
                                    <img src="${esOrder.ordershopicon?if_exists}" width="100" height="100" alt="">
                                </a>
                            </div>
                            <div class="info">
                                <div class="info_ul clear">
                                    <ul class="txt lf">
                                        <li>
                                            <div class="info_tit">
                                                <span class="info_tit01">企业注册</span>
                                                <a href="http://es.w7tong.com/${esOrder.htmlpath?if_exists}" target="_blank" class="info_tit02">公司注册</a>
                                            </div>
                                        </li>
                                        <li>套餐类型：${esOrder.ordershopname?if_exists}</li>
                                        <li>企业类型：${esOrder.ordercompanytype?if_exists}</li>
                                        <li>企业行业：${esOrder.ordercompanyinduty?if_exists}</li>
                                        <li>注册省份：${esOrder.orderprovincename?if_exists}</li>
                                        <li>注册市区：${esOrder.ordercityname?if_exists}</li>
                                    </ul>
                                    <div class="numm lf">
                                        <span>1</span>
                                    </div>
                                    <div class="detail lf">
                                      <ul>
                                            <li>
                                                <span>总计应付：</span>
                                                <b class="number">￥${esOrder.orderallmoney?if_exists}</b>
                                            </li>
                                            <li>
                                                <span>单   价：</span>
                                                <b class="pr_number">￥${esOrder.shopprice?if_exists}</b>
                                            </li>
                                            <li>
                                                <span>已   付：</span>
                                                <b class="number">￥
                                                    <#if esOrder.paymoney?exists>
                                                        ${esOrder.paymoney?if_exists}
                                                    <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                            <li>
                                                <span>服务费：</span>
                                                <b class="number">￥
                                                    <#if esOrder.orderservicemoney?exists>
                                                        ${esOrder.orderservicemoney?if_exists}
                                                    <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                            <li>
                                                <span>优   惠：</span>
                                                <b class="number">￥
                                                     <#if esOrder.favourablemoney?exists>
                                                        ${esOrder.favourablemoney?if_exists}
                                                     <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="ddzt lf">
                                        <#if esOrder.orderstate=='1'>
	                                        <span>未付款</span>
	                                     <#elseif esOrder.orderstate=='2'> 
	                                        <span>已付定金</span>
	                                     <#elseif esOrder.orderstate=='3'> 
	                                        <span>已付款</span>
	                                     <#elseif esOrder.orderstate=='4'> 
	                                        <span>交易完成</span>
	                                     <#elseif esOrder.orderstate=='5'> 
	                                        <span>订单取消</span>
	                                     <#else>
										  	<span>交易完成</span>
										 </#if>
                                    </div>
                                    <div class="order_shop lf">
                                        <ul>
                                            <#if esOrder.orderstate=='1'>
		                                        <li>
	                                                <a href="/order/pay/${esOrder.ordercode?if_exists}/type/3">去付款</a>
	                                            </li>
	                                            <li>
	                                                <a href="/order/buyer/es/cancel/${esOrder.ordercode?if_exists}/type/3">取消订单</a>
	                                            </li>
		                                     <#elseif esOrder.orderstate=='2'> 
		                                         <li>
	                                                <a href="/order/pay/${esOrder.ordercode?if_exists}/type/3">去付款</a>
	                                            </li>
	                                            <li>
	                                                <a href="/order/buyer/es/cancel/${esOrder.ordercode?if_exists}/type/3">取消订单</a>
	                                            </li>
		                                     <#elseif esOrder.orderstate=='3'> 
		                                         <li>
		                                            <a href="">订单详情</a>
		                                         </li>
		                                     <#elseif esOrder.orderstate=='4'> 
		                                        <li>
		                                            <a href="">订单详情</a>
		                                        </li>
		                                     <#elseif esOrder.orderstate=='5'> 
	                                            <li>
	                                                                                                                                                                    订单已取消
	                                            </li>
	                                            <li>
	                                            </li>
		                                     <#else>
	                                            <li>
	                                                <a href="">订单详情</a>
	                                            </li>
	                                            <li>
	                                            </li>
											 </#if>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="pay_service rt">
		                         <dl>
		                            <dt>
		                                <img src="${wqtworker.headurl?if_exists}" style="width:100%" alt="">
		                            </dt>
		                            <dd class="txt01">${wqtworker.workername?if_exists}</dd>
		                            <dd class="txt02">您的订单专属客服</dd>
		                            <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
		                        </dl>
		                     </div>
                        </div>
                    </div>
                </div>
                </#if>
                <#if esOrder.orderkindkey=='dljz'>
                <!--代记账-->
                <div class="brand_order">
                    <div class="order_number">
                        <#if esOrder.orderstate=='3' || esOrder.orderstate=='4'>
                        <input type="checkbox" class="order_checked" name="comp_order" disabled="disabled">
						<#else>
						<input type="checkbox" class="order_checked" name="comp_order" data-pri='${esOrder.orderallmoney?if_exists}' data-favourabl='${esOrder.favourablemoney?if_exists}' >
						</#if>
                        <span class="order_time">${esOrder.ordertime?if_exists}</span>
                        <span>订单号：${esOrder.ordercode?if_exists}</span>
                    </div>
                    <div class="order_det clearfix">
                        <div class="pay_info">
                           <div class="img">
                                <a href="http://es.w7tong.com/${esOrder.htmlpath?if_exists}" target="_blank">
                                    <img src="${esOrder.ordershopicon?if_exists}" width="100" height="100" alt="">
                                </a>
                            </div>
                            <div class="info">
                                <div class="info_ul clear">
                                    <ul class="txt lf">
                                        <li>
                                            <div class="info_tit">
                                                <span class="info_tit01">企业代记账</span>
                                                <a href="http://es.w7tong.com/${esOrder.htmlpath?if_exists}" target="_blank" class="info_tit02">代记账套餐</a>
                                            </div>
                                        </li>
                                        <li>套餐类型：${esOrder.ordershopname?if_exists}</li>
                                        <li>${esOrder.ordershopdesc?if_exists}</li>
                                        <!--<li class="half">记账、建账</li>
                                        <li>国、地税纳税申报</li>
                                        <li>编制财务报表、登记税务报表</li>
                                        <li>协助甲方接受税务机关检查工作</li>
                                        <li>接受甲方日常财务、税务咨询</li>-->
                                    </ul>
                                    <div class="numm lf">
                                        <span>1</span>
                                    </div>
                                    <div class="detail lf">
                                        <ul>
                                            <li>
                                                <span>总计应付：</span>
                                                <b class="number">￥${esOrder.orderallmoney?if_exists}</b>
                                            </li>
                                            <li>
                                                <span>单   价：</span>
                                                <b class="pr_number">￥${esOrder.shopprice?if_exists}</b>
                                            </li>
                                            <li>
                                                <span>已   付：</span>
                                                <b class="number">￥
                                                    <#if esOrder.paymoney?exists>
                                                        ${esOrder.paymoney?if_exists}
                                                    <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                            <li>
                                                <span>服务费：</span>
                                                <b class="number">￥
                                                    <#if esOrder.orderservicemoney?exists>
                                                        ${esOrder.orderservicemoney?if_exists}
                                                    <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                            <li>
                                                <span>优   惠：</span>
                                                <b class="number">￥
                                                     <#if esOrder.favourablemoney?exists>
                                                        ${esOrder.favourablemoney?if_exists}
                                                     <#else>
													  	0.00
													 </#if>
                                                </b>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="ddzt lf">
                                         <#if esOrder.orderstate=='1'>
	                                        <span>未付款</span>
	                                     <#elseif esOrder.orderstate=='2'> 
	                                        <span>已付定金</span>
	                                     <#elseif esOrder.orderstate=='3'> 
	                                        <span>已付款</span>
	                                     <#elseif esOrder.orderstate=='4'> 
	                                        <span>交易完成</span>
	                                     <#elseif esOrder.orderstate=='5'> 
	                                        <span>订单取消</span>
	                                     <#else>
										  	<span>交易完成</span>
										 </#if>
                                    </div>
                                    <div class="order_shop lf">
                                        <ul>
                                            <#if esOrder.orderstate=='1'>
		                                        <li>
	                                                <a href="/order/pay/${esOrder.ordercode?if_exists}/type/3">去付款</a>
	                                            </li>
	                                            <li>
	                                                <a href="/order/buyer/es/cancel/${esOrder.ordercode?if_exists}/type/3">取消订单</a>
	                                            </li>
		                                     <#elseif esOrder.orderstate=='2'> 
		                                         <li>
	                                                <a href="/order/pay/${esOrder.ordercode?if_exists}/type/3">去付款</a>
	                                            </li>
	                                            <li>
	                                                <a href="/order/buyer/es/cancel/${esOrder.ordercode?if_exists}/type/3">取消订单</a>
	                                            </li>
		                                     <#elseif esOrder.orderstate=='3'> 
		                                         <li>
		                                            <a href="">订单详情</a>
		                                         </li>
		                                     <#elseif esOrder.orderstate=='4'> 
		                                        <li>
		                                            <a href="">订单详情</a>
		                                        </li>
		                                     <#elseif esOrder.orderstate=='5'> 
	                                            <li>
	                                                                                                                                                                    订单已取消
	                                            </li>
	                                            <li>
	                                            </li>
		                                     <#else>
	                                            <li>
	                                                <a href="">订单详情</a>
	                                            </li>
	                                            <li>
	                                            </li>
											 </#if>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                             <div class="pay_service rt">
		                        <dl>
		                            <dt>
		                                <img src="${wqtworker.headurl?if_exists}" style="width:100%" alt="">
		                            </dt>
		                            <dd class="txt01">${wqtworker.workername?if_exists}</dd>
		                            <dd class="txt02">您的订单专属客服</dd>
		                            <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
		                        </dl>
		                     </div>
                        </div>
                    </div>
                 </div>
                 </#if>
	          </#list>
              </#if>
	          <#if allnum lt 1>
                <div class="ttab_data ">
                    <div class="data_null">
                        <p>您现在还没有订单可以查看哦</p>
                        <a href="/" target="_blank">去首页看看</a>
                    </div>
                </div>
              </#if>
              
              <#if allnum gte 1>
	                <!--分页-->
	                <div class="company_list_result_pages">
	                    <span class="backhome">
	                        <a href="/order/es/buyer/${esBuyerOrderList.orderstate}/list/1" id="firstPage0">首页</a>
	                    </span>
	                    <span class="prevpage">
	                      <#if esBuyerOrderList.pagenum?number gt 1>
	                         <a href="/order/es/buyer/${esBuyerOrderList.orderstate}/list/${esBuyerOrderList.pagenum-1}" id="prevA0">上一页</a>
	                      <#else>
	                         <a href="javascript:;" id="prevA0">上一页</a>
	                      </#if>
	                    </span>
	                    <!--<span class="pagesN">
	                        <a href="javascript:;">1</a>
	                        <a href="javascript:;" class="active">2</a>
	                        <a href="javascript:;">3</a>
	                    </span>-->
	                    <span class="nextpage">
	                      <#if esBuyerOrderList.pagenum?number lt esBuyerOrderList.orderpage?number>
	                         <a href="/order/es/buyer/${esBuyerOrderList.orderstate}/list/${esBuyerOrderList.pagenum+1}" id="nextA0">下一页</a>
	                      <#else>
	                         <a href="javascript:;" id="nextA0">下一页</a>
	                      </#if>
	                    </span>
	                    <span class="lastpage">
	                        <a href="/order/es/buyer/${esBuyerOrderList.orderstate}/list/${esBuyerOrderList.orderpage}" id="nextPage0">尾页</a>
	                    </span>
	                    <span class="total">
	                                                                     共<span id="allPage20">${esBuyerOrderList.orderpage}</span>页/当前为第
	                        <strong id="nowPage20">${esBuyerOrderList.pagenum}</strong>
	                                                                    页
	                    </span>
	                 </div>
              </#if>
                <!--付款-->
                <div class="pay clear all_pay">
        <div class="all_checked lf" style="display:none;">
            <input type="checkbox" class="all">
            <span>全选</span>
        </div>
        <div class="delate lf" style="display:none;">
            <a href="javascript:;">删除选中项</a>
        </div>
        <div class="py_btn rt">
            <a href="javascript:;">去付款</a>
        </div>
        <div class="gg rt">
            共计：<i>¥</i><span>0.00</span>
        </div>
        <div class="thank rt">
            优惠：<i>¥</i><span>0.00</span>
        </div>
        <div class="select_order rt" style="display:none;">
            已选择<span>0</span>件商品
        </div>
    </div>
            </div>
        </div>
        </div>
    </div>
</div>
<!--底部-->
<#include "/templates/footer.ftl">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/layui/layui.js"></script>
<script src="/usercenter/js/cmprecord.js"></script>
</body>
</html>