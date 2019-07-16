<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=0.25">
    <title>用户中心</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/usercenter_index.css">
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
<!--底部-->
<#include "/templates/wqt_header.ftl">
    <!--内容中心-->
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
                    <li><a href="/user/suggestlist">我的建议</a></li>
                </ul>
            </div>
        </div>
        <div class="content_rt">
            <div class="usercenter_top">
                <div class="top_cont clear">
                    <div class="user_pic lf">
                        <a href="/user/personalinfo">
                            <img src="/usercenter/image/user.png" width="80" height="80">
                        </a>
                    </div>
                    <div class="welcome_s lf">
                        <p class="p1">欢迎你，  ${userCenterData.userbasic.username?if_exists}！</p>
                        <p class="p2 pp">
                            <i></i>
                            <span>${userCenterData.userbasic.mobileno?if_exists?substring(0,3)}.....${userCenterData.userbasic.mobileno?if_exists?substring(8,11)}</span>
                        </p>
                        <p class="p3 pp">
                            <i></i>
                            <a href="/user/personalinfo">完善资料</a>
                        </p>
                    </div>
                    <div class="account lf">
                        <p>账户余额</p>
                        <p class="p1">¥ 
                            <#if userCenterData.userbasic.money?exists>
                                ${userCenterData.userbasic.money?if_exists}
                            <#else>
							  	0.00
							 </#if>
                        </p>
                        <p>
                            <a href="/user/capital">（查看详情）</a>
                        </p>
                    </div>
                    <div class="top_up lf">
                        <a href="/user/recharge">充值</a>
                        <a href="/user/withdraw" class="top_up_but">提现</a>
                    </div>
                    <div class="freeze lf">
                        <p>冻结资金</p>
                        <p class="p1">¥
                            <#if userCenterData.userbasic.freemoney?exists>
                                ${userCenterData.userbasic.freemoney?if_exists}
                            <#else>
							  	0.00
							 </#if>
                        </p>
                        <p><a href="/user/capital">（查看详情）</a></p>
                    </div>
                    <div class="deposit lf">
                        <p></p>
                        <p class="p1"></p>
                    </div>
                </div>
            </div>
            <div class="content_top">
                <ul>
                    <li class="l1">
                        <a href="/order/buyer/list">待付款订单<i></i></a>
                    </li>
                    <li class="l2">
                        <a href="/user/security">安全设置<i></i></a>
                    </li>
                    <li class="l3">
                        <a href="/user/capital">资金明细<i></i></a>
                    </li>
                    <li class="l4">
                        <a href="/user/suggest">用户建议<i></i></a>
                    </li>
                </ul>
            </div>
            <!--订单-->
            <div class="order">
                <div class="order_title">
                    <p>我的订单</p>
                    <ul class="rt">
                        <li>待付款 <span>[0]</span></li>
                        <li>已预订<span>[0]</span></li>
                        <li>交接中<span>[0]</span></li>
                        <li>已完成<span>[0]</span></li>
                    </ul>
                </div>
                <!--有数据   最多显示两个数据-->
                <div class="order_data">
                    <ul>
                      <#if userCenterData.l_UsercenterOrder?exists>
		                <#list userCenterData.l_UsercenterOrder as usercenterOrder>
		                  <#if usercenterOrder.orderkind=='4'>
		                        <!--商标交易-->
		                        <li>
		                            <div class="order_data_title">
		                                <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
		                                <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
		                                <a href="javascript:;" class="delate">
		                                    <img src="/usercenter/image/delate.png" alt="">
		                                </a>
		                            </div>
		                            <div class="order_data_cont clear">
		                                <div class="o_img lf">
		                                    <a href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
		                                        <img src="${usercenterOrder.ordershopicon?if_exists}" alt="" width="80" height="80">
		                                    </a>
		                                </div>
		                                <div class="data_top">
		                                    <span class="dd">商标</span>
		                                    <a class="top_title" href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">${usercenterOrder.ordershopname?if_exists}</a>
		                                </div>
		                                <div class="cont_a lf">
		                                    <ul>
		                                        <li>
		                                            <p class="cont_a_a">商标分类：</p>
		                                            <p class="cont_a_b">${usercenterOrder.ordershopkind?substring(0,2)}类-${usercenterOrder.ordershopkindname?if_exists}</p>
		                                        </li>
		                                         <li>
		                                            <p class="cont_a_a">注册号：</p>
		                                            <p class="cont_a_b">${usercenterOrder.ordershopregcode?if_exists}</p>
		                                        </li>
		                                        <li>
		                                            <p class="cont_a_a">商品编号：</p>
		                                            <p class="cont_a_b">${usercenterOrder.ordershopcode?if_exists}</p>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <div class="money_a lf">
		                                    <ul>
		                                        <li>
		                                            <span class="money_a_a">已付款：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.paymoney?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
		                                            <span class="money_a_b">1</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">过户费：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.transferfee?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">服务费：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.orderservicemoney?if_exists}</span>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <div class="unit_price lf">
		                                    ¥${usercenterOrder.orderallmoney?if_exists}
		                                </div>
		                                <div class="state lf">
		                                    <#if usercenterOrder.orderstate=='1'>
		                                        <span>未付款</span>
		                                     <#elseif usercenterOrder.orderstate=='2'> 
		                                        <span>已付定金</span>
		                                     <#elseif usercenterOrder.orderstate=='3'> 
		                                        <span>已付款</span>
		                                     <#elseif usercenterOrder.orderstate=='4'> 
		                                        <span>交易完成</span>
		                                     <#elseif usercenterOrder.orderstate=='5'> 
		                                        <span>订单取消</span>
		                                     <#else>
											  	<span>交易完成</span>
											 </#if>
		                                </div>
		                                <div class="operation lf">
		                                   <#if usercenterOrder.orderstate=='1'>
			                                    <ul>
			                                        <li>
			                                            <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/2">去付款</a>
			                                        </li>
			                                        <li>
			                                            <a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/2">取消订单</a>
			                                        </li>
			                                    </ul>
			                                 <#elseif usercenterOrder.orderstate=='2'> 
			                                     <ul>
			                                        <li>
			                                            <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/2">付余款</a>
			                                        </li>
			                                        <li>
			                                            <a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/2">取消订单</a>
			                                        </li>
			                                    </ul>
			                                 <#elseif usercenterOrder.orderstate=='3'> 
			                                    <ul>
			                                        <li>
			                                            <a href="">订单详情</a>
			                                        </li>
			                                        <li>
			                                           
			                                        </li>
			                                    </ul>
			                                 <#elseif usercenterOrder.orderstate=='4'> 
			                                    <ul>
			                                       <li>
			                                            <a href="">订单详情</a>
			                                        </li>
			                                        <li>
			                                           
			                                        </li>
			                                    </ul>
			                                 <#elseif usercenterOrder.orderstate=='5'> 
			                                    <ul>
			                                       <li>
			                                        </li>
			                                        <li>
			                                        </li>
			                                    </ul>
			                                 <#else>
											  	 <ul>
			                                       <li>
			                                            <a href="">订单详情</a>
			                                        </li>
			                                        <li>
			                                        </li>
			                                    </ul>
											 </#if>
		                                </div>
		                            </div>
		                        </li>								
		                 </#if>
		                 <#if usercenterOrder.orderkind=='6'>
		                        <!--专利交易-->
		                        <li>
		                             <div class="order_data_title">
		                                <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
		                                <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
		                                <a href="javascript:;" class="delate">
		                                    <img src="/usercenter/image/delate.png" alt="">
		                                </a>
		                            </div>
		                            <div class="order_data_cont clear">
		                                <div class="o_img lf">
		                                    <a href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
		                                        <img src="${usercenterOrder.ordershopicon?if_exists}" alt="" width="80" height="80">
		                                    </a>
		                                </div>
		                                <div class="data_top">
		                                    <span class="dd">专利</span>
		                                    <a class="top_title" href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">${usercenterOrder.ordershopname?if_exists}</a>
		                                </div>
		                                <div class="cont_a lf">
		                                    <ul>
		                                        <li>
		                                            <p class="cont_a_a"> 专利分类：</p>
		                                            <p class="cont_a_b">${usercenterOrder.ordershopkindname?if_exists}</p>
		                                        </li>
		                                        <li>
		                                            <p class="cont_a_a">专利号：</p>
		                                            <p class="cont_a_b">${usercenterOrder.ordershopregcode?if_exists}</p>
		                                        </li>
		                                       <li>
		                                            <p class="cont_a_a">商品编号：</p>
		                                            <p class="cont_a_b">${usercenterOrder.ordershopcode?if_exists}</p>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <div class="money_a lf">
		                                    <ul>
		                                        <li>
		                                            <span class="money_a_a">已付款：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.paymoney?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
		                                            <span class="money_a_b">1</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">过户费：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.transferfee?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">服务费：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.orderservicemoney?if_exists}</span>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <div class="unit_price lf">
		                                    ¥${usercenterOrder.orderallmoney?if_exists}
		                                </div>
		                                <div class="state lf">
		                                    <#if usercenterOrder.orderstate=='1'>
		                                        <span>未付款</span>
		                                     <#elseif usercenterOrder.orderstate=='2'> 
		                                        <span>已付定金</span>
		                                     <#elseif usercenterOrder.orderstate=='3'> 
		                                        <span>已付款</span>
		                                     <#elseif usercenterOrder.orderstate=='4'> 
		                                        <span>交易完成</span>
		                                     <#elseif usercenterOrder.orderstate=='5'> 
		                                        <span>订单取消</span>
		                                     <#else>
											  	<span>交易完成</span>
											 </#if>   
		                                </div>
		                                <div class="operation lf">
		                                   <#if usercenterOrder.orderstate=='1'>
		                                        <ul>
		                                            <li>
		                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/2">去付款</a>
		                                            </li>
		                                            <li>
		                                                <a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/2">取消订单</a>
		                                            </li>
		                                        </ul>
		                                     <#elseif usercenterOrder.orderstate=='2'> 
		                                         <ul>
		                                            <li>
		                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/2">付余款</a>
		                                            </li>
		                                            <li>
		                                                <a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/2">取消订单</a>
		                                            </li>
		                                        </ul>
		                                     <#elseif usercenterOrder.orderstate=='3'> 
		                                        <ul>
		                                            <li>
		                                                <a href="">订单详情</a>
		                                            </li>
		                                            <li>
		                                               
		                                            </li>
		                                        </ul>
		                                     <#elseif usercenterOrder.orderstate=='4'> 
		                                        <ul>
		                                           <li>
		                                                <a href="">订单详情</a>
		                                            </li>
		                                            <li>
		                                               
		                                            </li>
		                                        </ul>
		                                     <#elseif usercenterOrder.orderstate=='5'> 
		                                        <ul>
		                                           <li>
		                                            </li>
		                                            <li>
		                                            </li>
		                                        </ul>
		                                     <#else>
											  	 <ul>
		                                           <li>
		                                                <a href="">订单详情</a>
		                                            </li>
		                                            <li>
		                                            </li>
		                                        </ul>
											 </#if>
		                                </div>
		                            </div>
		                        </li>
		                </#if>
		                <#if usercenterOrder.orderkind=='5'>
		                        <!--版权交易-->
		                        <li>
		                            <div class="order_data_title">
		                                <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
		                                <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
		                                <a href="javascript:;" class="delate">
		                                    <img src="/usercenter/image/delate.png" alt="">
		                                </a>
		                            </div>
		                            <div class="order_data_cont clear">
		                                <div class="o_img lf">
		                                    <a href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
		                                        <img src="${usercenterOrder.ordershopicon?if_exists}" alt="" width="80" height="80">
		                                    </a>
		                                </div>
		                                <div class="data_top">
		                                    <span class="dd">版权</span>
		                                    <a class="top_title" href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">${usercenterOrder.ordershopname?if_exists}</a>
		                                </div>
		                                <div class="cont_a lf">
		                                    <ul>
		                                         <li>
		                                            <p class="cont_a_a">商品编号：</p>
		                                            <p class="cont_a_b">${usercenterOrder.ordershopcode?if_exists}</p>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <div class="money_a lf">
		                                    <ul>
		                                       <li>
		                                            <span class="money_a_a">已付款：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.paymoney?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
		                                            <span class="money_a_b">1</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">过户费：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.transferfee?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">服务费：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.orderservicemoney?if_exists}</span>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <div class="unit_price lf">
		                                     ¥${usercenterOrder.orderallmoney?if_exists}
		                                </div>
		                                <div class="state lf">
		                                    <#if usercenterOrder.orderstate=='1'>
		                                        <span>未付款</span>
		                                     <#elseif usercenterOrder.orderstate=='2'> 
		                                        <span>已付定金</span>
		                                     <#elseif usercenterOrder.orderstate=='3'> 
		                                        <span>已付款</span>
		                                     <#elseif usercenterOrder.orderstate=='4'> 
		                                        <span>交易完成</span>
		                                     <#elseif usercenterOrder.orderstate=='5'> 
		                                        <span>订单取消</span>
		                                     <#else>
											  	<span>交易完成</span>
											 </#if>
		                                </div>
		                                <div class="operation lf">
		                                      <#if usercenterOrder.orderstate=='1'>
												<ul>
													<li>
														<a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/2">去付款</a>
													</li>
													<li>
														<a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/2">取消订单</a>
													</li>
												</ul>
												<#elseif usercenterOrder.orderstate=='2'>
												<ul>
													<li>
														<a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/2">付余款</a>
													</li>
													<li>
														<a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/2">取消订单</a>
													</li>
												</ul>
												<#elseif usercenterOrder.orderstate=='3'>
												<ul>
													<li>
														<a href="">订单详情</a>
													</li>
													<li>

													</li>
												</ul>
												<#elseif usercenterOrder.orderstate=='4'>
												<ul>
													<li>
														<a href="">订单详情</a>
													</li>
													<li>

													</li>
												</ul>
												<#elseif usercenterOrder.orderstate=='5'>
												<ul>
													<li>
													</li>
													<li>
													</li>
												</ul>
												<#else>
												<ul>
													<li>
														<a href="">订单详情</a>
													</li>
													<li>
													</li>
												</ul>
										     </#if>
		                                </div>
		                            </div>
		                        </li>
		                </#if>
		                <#if usercenterOrder.orderkind=='2'>
		                        <!--版权服务-->
		                        <li>
		                             <div class="order_data_title">
		                                <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
		                                <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
		                                <a href="javascript:;" class="delate">
		                                    <img src="/usercenter/image/delate.png" alt="">
		                                </a>
		                            </div>
		                            <div class="order_data_cont clear">
		                                <div class="o_img lf">
		                                    <a href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
		                                        <img src="${usercenterOrder.ordershopicon?if_exists}" alt="" width="80" height="80">
		                                    </a>
		                                </div>
		                                <div class="data_top">
		                                     <span class="dd">版权登记</span>
		                                     <a class="top_title" href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">${usercenterOrder.ordershopname?if_exists}</a>
		                                </div>
		                                <div class="cont_a lf">
		                                    <ul>
		                                        <li class="one">
		                                           <p>说明：普通担保35-40个工作日，成功率高可加急，版权顾问全程专业服务</p>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <div class="money_a lf">
		                                    <ul>
		                                         <li>
		                                            <span class="money_a_a">已付款：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.paymoney?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
		                                            <span class="money_a_b">1</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">过户费：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.transferfee?if_exists}</span>
		                                        </li>
		                                        <li>
		                                            <span class="money_a_a">服务费：</span>
		                                            <span class="money_a_b">¥${usercenterOrder.orderservicemoney?if_exists}</span>
		                                        </li>
		                                    </ul>
		                                </div>
		                                <div class="unit_price lf">
		                                    ¥${usercenterOrder.orderallmoney?if_exists}.00
		                                </div>
		                                <div class="state lf">
		                                    <#if usercenterOrder.orderstate=='1'>
		                                        <span>未付款</span>
		                                     <#elseif usercenterOrder.orderstate=='2'> 
		                                        <span>已付定金</span>
		                                     <#elseif usercenterOrder.orderstate=='3'> 
		                                        <span>已付款</span>
		                                     <#elseif usercenterOrder.orderstate=='4'> 
		                                        <span>交易完成</span>
		                                     <#elseif usercenterOrder.orderstate=='5'> 
		                                        <span>订单取消</span>
		                                     <#else>
											  	<span>交易完成</span>
											 </#if>
		                                </div>
		                                <div class="operation lf">
		                                    <#if usercenterOrder.orderstate=='1'>
		                                        <ul>
		                                            <li>
		                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/1">去付款</a>
		                                            </li>
		                                            <li>
		                                                <a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/1">取消订单</a>
		                                            </li>
		                                        </ul>
		                                     <#elseif usercenterOrder.orderstate=='2'> 
		                                         <ul>
		                                            <li>
		                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/1">付余款</a>
		                                            </li>
		                                            <li>
		                                                <a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/1">取消订单</a>
		                                            </li>
		                                        </ul>
		                                     <#elseif usercenterOrder.orderstate=='3'> 
		                                        <ul>
		                                            <li>
		                                                <a href="">订单详情</a>
		                                            </li>
		                                            <li>
		                                               
		                                            </li>
		                                        </ul>
		                                     <#elseif usercenterOrder.orderstate=='4'> 
		                                        <ul>
		                                           <li>
		                                                <a href="">订单详情</a>
		                                            </li>
		                                            <li>
		                                               
		                                            </li>
		                                        </ul>
		                                     <#elseif usercenterOrder.orderstate=='5'> 
		                                        <ul>
		                                           <li>
		                                            </li>
		                                            <li>
		                                            </li>
		                                        </ul>
		                                     <#else>
											  	 <ul>
		                                           <li>
		                                                <a href="">订单详情</a>
		                                            </li>
		                                            <li>
		                                            </li>
		                                        </ul>
											 </#if>
		                                 </div>
		                            </div>
		                        </li>
		                 </#if>
		                <#if usercenterOrder.orderkind=='3'>
                        <!--专利服务-->
                        <li>
                            <div class="order_data_title">
                                <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
                                <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
                                <a href="javascript:;" class="delate">
                                    <img src="/usercenter/image/delate.png" alt="">
                                </a>
                            </div>
                            <div class="order_data_cont clear">
                                <div class="o_img lf">
                                    <a href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
                                        <img src="${usercenterOrder.ordershopicon?if_exists}" alt="" width="80" height="80">
                                    </a>
                                </div>
                                <div class="data_top">
                                    <span class="dd">专利申请</span>
                                    <a class="top_title" href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">${usercenterOrder.ordershopname?if_exists}</a>
                                </div>
                                <div class="cont_a lf">
                                    <ul>
                                        <li>
                                            <p class="cont_a_a">最长时长：</p>
                                            <p class="cont_a_b">24个月左右</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">商品套餐：</p>
                                            <p class="cont_a_b">${usercenterOrder.ordershopname?if_exists}</p>
                                        </li>
                                        <li class="one">
                                            <p>案件代理简介：保护您的发明创造，资深专家团队把关，让您申请专利不再担忧</p>
                                        </li>
                                    </ul>
                                </div>
                                <div class="money_a lf">
                                    <ul>
                                         <li>
                                            <span class="money_a_a">已付款：</span>
                                            <span class="money_a_b">¥${usercenterOrder.paymoney?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
                                            <span class="money_a_b">1</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
                                            <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">过户费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.transferfee?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">服务费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.orderservicemoney?if_exists}</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="unit_price lf">
                                    ¥${usercenterOrder.orderallmoney?if_exists}
                                </div>
                                <div class="state lf">
                                     <#if usercenterOrder.orderstate=='1'>
                                        <span>未付款</span>
                                     <#elseif usercenterOrder.orderstate=='2'> 
                                        <span>已付定金</span>
                                     <#elseif usercenterOrder.orderstate=='3'> 
                                        <span>已付款</span>
                                     <#elseif usercenterOrder.orderstate=='4'> 
                                        <span>交易完成</span>
                                     <#elseif usercenterOrder.orderstate=='5'> 
                                        <span>订单取消</span>
                                     <#else>
									  	<span>交易完成</span>
									 </#if>
                                </div>
                                <div class="operation lf">
                                    <ul>
                                         <#if usercenterOrder.orderstate=='1'>
                                        <ul>
                                            <li>
                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/1">去付款</a>
                                            </li>
                                            <li>
                                                <a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/1">取消订单</a>
                                            </li>
                                        </ul>
                                     <#elseif usercenterOrder.orderstate=='2'> 
                                         <ul>
                                            <li>
                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/1">付余款</a>
                                            </li>
                                            <li>
                                                <a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/1">取消订单</a>
                                            </li>
                                        </ul>
                                     <#elseif usercenterOrder.orderstate=='3'> 
                                        <ul>
                                            <li>
                                                <a href="">订单详情</a>
                                            </li>
                                            <li>
                                               
                                            </li>
                                        </ul>
                                     <#elseif usercenterOrder.orderstate=='4'> 
                                        <ul>
                                           <li>
                                                <a href="">订单详情</a>
                                            </li>
                                            <li>
                                               
                                            </li>
                                        </ul>
                                     <#elseif usercenterOrder.orderstate=='5'> 
                                        <ul>
                                           <li>
                                            </li>
                                            <li>
                                            </li>
                                        </ul>
                                     <#else>
									  	 <ul>
                                           <li>
                                                <a href="">订单详情</a>
                                            </li>
                                            <li>
                                            </li>
                                        </ul>
									 </#if>
                                    </ul>
                                </div>
                            </div>
                        </li>
                       </#if>
		               <#if usercenterOrder.orderkind=='1'>
                        <!--商标服务-->
                        <li>
                             <div class="order_data_title">
                                <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
                                <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
                                <a href="javascript:;" class="delate">
                                    <img src="/usercenter/image/delate.png" alt="">
                                </a>
                            </div>
                            <div class="order_data_cont clear">
                                <div class="o_img lf">
                                    <a href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
                                        <img src="${usercenterOrder.ordershopicon?if_exists}" alt="" width="80" height="80">
                                    </a>
                                </div>
                                <div class="data_top">
                                    <span class="dd">商标注册</span>
                                    <a class="top_title" href="http://ipr.w7tong.com/${usercenterOrder.htmlpath?if_exists}">${usercenterOrder.ordershopname?if_exists}</a>
                                </div>
                                <div class="cont_a lf">
                                    <ul>
                                        <li>
                                            <p class="cont_a_a">最长时长：</p>
                                            <p class="cont_a_b">24个月左右</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">商品套餐：</p>
                                            <p class="cont_a_b">${usercenterOrder.ordershopname?if_exists}</p>
                                        </li>
                                        <li class="one">
                                            <p>案件代理简介：保护您的发明创造，资深专家团队把关，让您申请专利不再担忧</p>
                                        </li>
                                    </ul>
                                </div>
                                <div class="money_a lf">
                                    <ul>
                                        <li>
                                            <span class="money_a_a">已付款：</span>
                                            <span class="money_a_b">¥${usercenterOrder.paymoney?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
                                            <span class="money_a_b">1</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
                                            <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">过户费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.transferfee?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">服务费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.orderservicemoney?if_exists}</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="unit_price lf">
                                    ¥${usercenterOrder.orderallmoney?if_exists}
                                </div>
                                <div class="state lf">
                                    <#if usercenterOrder.orderstate=='1'>
                                        <span>未付款</span>
                                     <#elseif usercenterOrder.orderstate=='2'> 
                                        <span>已付定金</span>
                                     <#elseif usercenterOrder.orderstate=='3'> 
                                        <span>已付款</span>
                                     <#elseif usercenterOrder.orderstate=='4'> 
                                        <span>交易完成</span>
                                     <#elseif usercenterOrder.orderstate=='5'> 
                                        <span>订单取消</span>
                                     <#else>
									  	<span>交易完成</span>
									 </#if>
                                </div>
                                <div class="operation lf">
                                    <#if usercenterOrder.orderstate=='1'>
	                                    <ul>
	                                        <li>
	                                            <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/1">去付款</a>
	                                        </li>
	                                        <li>
	                                            <a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/1">取消订单</a>
	                                        </li>
	                                    </ul>
	                                 <#elseif usercenterOrder.orderstate=='2'> 
	                                     <ul>
	                                        <li>
	                                            <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/1">付余款</a>
	                                        </li>
	                                        <li>
	                                            <a href="/order/buyer/cancel/${usercenterOrder.ordercode?if_exists}/type/1">取消订单</a>
	                                        </li>
	                                    </ul>
	                                 <#elseif usercenterOrder.orderstate=='3'> 
	                                    <ul>
	                                        <li>
	                                            <a href="">订单详情</a>
	                                        </li>
	                                        <li>
	                                           
	                                        </li>
	                                    </ul>
	                                 <#elseif usercenterOrder.orderstate=='4'> 
	                                    <ul>
	                                       <li>
	                                            <a href="">订单详情</a>
	                                        </li>
	                                        <li>
	                                           
	                                        </li>
	                                    </ul>
	                                 <#elseif usercenterOrder.orderstate=='5'> 
	                                    <ul>
	                                       <li>
	                                        </li>
	                                        <li>
	                                        </li>
	                                    </ul>
	                                 <#else>
									  	 <ul>
	                                       <li>
	                                            <a href="">订单详情</a>
	                                        </li>
	                                        <li>
	                                        </li>
	                                    </ul>
									 </#if>
                                </div>
                            </div>
                        </li>
                       </#if>
		               <#if usercenterOrder.orderkind=='qyjy'>
                        <!--公司交易-->
                        <li>
                            <div class="order_data_title">
                                <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
                                <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
                                <a href="javascript:;" class="delate">
                                    <img src="/usercenter/image/delate.png" alt="">
                                </a>
                            </div>
                            <div class="order_data_cont clear">
                                <div class="o_img lf">
                                    <a href="http://es.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
                                        <img src="${usercenterOrder.ordershopicon?if_exists}" alt="" width="80" height="80">
                                    </a>
                                </div>
                                <div class="data_top">
                                    <span class="dd">企业交易</span>
                                     <a class="top_title" href="http://es.w7tong.com/${usercenterOrder.htmlpath?if_exists}">${usercenterOrder.ordershopname?if_exists}</a>
                                </div>
                                <div class="cont_a lf">
                                    <ul>
                                        <li>
                                            <p class="cont_a_a">企业行业：</p>
                                            <p class="cont_a_b">产品类</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">企业类型：</p>
                                            <p class="cont_a_b">有限责任公司</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">经营时间：</p>
                                            <p class="cont_a_b">4年</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">纳税类型：</p>
                                            <p class="cont_a_b">小规模</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">商品编号：</p>
                                            <p class="cont_a_b">165165165165165165165</p>
                                        </li>
                                    </ul>
                                </div>
                                <div class="money_a lf">
                                    <ul>
                                        <li>
                                            <span class="money_a_a">已付款：</span>
                                            <span class="money_a_b">¥${usercenterOrder.paymoney?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
                                            <span class="money_a_b">1</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
                                            <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">过户费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.transferfee?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">服务费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.orderservicemoney?if_exists}</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="unit_price lf">
                                     ¥${usercenterOrder.orderallmoney?if_exists}
                                </div>
                                <div class="state lf">
                                  <#if usercenterOrder.orderstate=='1'>
                                        <span>未付款</span>
                                     <#elseif usercenterOrder.orderstate=='2'> 
                                        <span>已付定金</span>
                                     <#elseif usercenterOrder.orderstate=='3'> 
                                        <span>已付款</span>
                                     <#elseif usercenterOrder.orderstate=='4'> 
                                        <span>交易完成</span>
                                     <#elseif usercenterOrder.orderstate=='5'> 
                                        <span>订单取消</span>
                                     <#else>
									  	<span>交易完成</span>
									 </#if>
                                </div>
                                <div class="operation lf">
                                   <ul>
                                       <#if usercenterOrder.orderstate=='1'>
	                                        <li>
	                                            <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/4">去付款</a>
	                                        </li>
	                                        <li>
	                                            <a href="/order/buyer/es/cancel/${usercenterOrder.ordercode?if_exists}/type/4">取消订单</a>
	                                        </li>
	                                     <#elseif usercenterOrder.orderstate=='2'> 
	                                        <li>
	                                            <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/4">支付余款</a>
	                                        </li>
	                                        <li>
	                                            <a href="/order/buyer/es/cancel/${usercenterOrder.ordercode?if_exists}/type/4">取消订单</a>
	                                        </li>
	                                     <#elseif usercenterOrder.orderstate=='3'> 
	                                        <li>
	                                            <a href="">订单详情</a>
	                                        </li>
	                                     <#elseif usercenterOrder.orderstate=='4'> 
	                                        <li>
	                                            <a href="">订单详情</a>
	                                        </li>
	                                     <#else>
										 </#if>
								    </ul>
                                </div>
                            </div>
                        </li>
                        </#if>
		                <#if usercenterOrder.orderkind=='dljz'>
                        <!--企业服务代记账-->
                        <li>
                             <div class="order_data_title">
                                <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
                                <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
                                <a href="javascript:;" class="delate">
                                    <img src="/usercenter/image/delate.png" alt="">
                                </a>
                            </div>
                            <div class="order_data_cont clear">
                                <div class="o_img lf">
                                    <a href="http://es.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
                                        <img src="${usercenterOrder.ordershopicon?if_exists}" alt="" width="80" height="80">
                                    </a>
                                </div>
                                <div class="data_top">
                                    <span class="dd">企业代记账</span>
                                    <a class="top_title" href="http://es.w7tong.com/${usercenterOrder.htmlpath?if_exists}">代记账套餐</a>
                                </div>
                                <div class="cont_a lf">
                                    <ul>
                                        <li>
                                            <p class="cont_a_a">纳税类型：</p>
                                            <p class="cont_a_b">小规模纳税人套餐/半年</p>
                                        </li>
                                        <li class="one">
                                            <p>国、地税报道；记账、建账；</p>
                                        </li>
                                        <li class="two">
                                            <p>编制财务报表、登记税务报表；国、地税纳税申报</p>
                                        </li>
                                        <li class="one">
                                            <p>协助甲方接受税务机关检查工作</p>
                                        </li>
                                        <li class="one">
                                            <p>接受甲方日常财务、税务咨询；</p>
                                        </li>
                                    </ul>
                                </div>
                                <div class="money_a lf">
                                    <ul>
                                        <li>
                                            <span class="money_a_a">已付款：</span>
                                            <span class="money_a_b">¥${usercenterOrder.paymoney?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
                                            <span class="money_a_b">1</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
                                            <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">过户费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.transferfee?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">服务费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.orderservicemoney?if_exists}</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="unit_price lf">
                                      ¥${usercenterOrder.orderallmoney?if_exists}
                                </div>
                                <div class="state lf">
                                     <#if usercenterOrder.orderstate=='1'>
                                        <span>未付款</span>
                                     <#elseif usercenterOrder.orderstate=='2'> 
                                        <span>已付定金</span>
                                     <#elseif usercenterOrder.orderstate=='3'> 
                                        <span>已付款</span>
                                     <#elseif usercenterOrder.orderstate=='4'> 
                                        <span>交易完成</span>
                                     <#elseif usercenterOrder.orderstate=='5'> 
                                        <span>订单取消</span>
                                     <#else>
									  	<span>交易完成</span>
									 </#if>
                                </div>
                                <div class="operation lf">
                                    <ul>
                                         <#if usercenterOrder.orderstate=='1'>
	                                        <li>
                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/3">去付款</a>
                                            </li>
                                            <li>
                                                <a href="/order/buyer/es/cancel/${usercenterOrder.ordercode?if_exists}/type/3">取消订单</a>
                                            </li>
	                                     <#elseif usercenterOrder.orderstate=='2'> 
	                                         <li>
                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/3">去付款</a>
                                            </li>
                                            <li>
                                                <a href="/order/buyer/es/cancel/${usercenterOrder.ordercode?if_exists}/type/3">取消订单</a>
                                            </li>
	                                     <#elseif usercenterOrder.orderstate=='3'> 
	                                         <li>
	                                            <a href="">订单详情</a>
	                                         </li>
	                                     <#elseif usercenterOrder.orderstate=='4'> 
	                                        <li>
	                                            <a href="">订单详情</a>
	                                        </li>
	                                     <#else>
										 </#if>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        </#if>
		                <#if usercenterOrder.orderkind=='gsbg'>
                        <!--企业变更-->
                        <li>
                             <div class="order_data_title">
                                <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
                                <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
                                <a href="javascript:;" class="delate">
                                    <img src="/usercenter/image/delate.png" alt="">
                                </a>
                            </div>
                            <div class="order_data_cont clear">
                                <div class="o_img lf">
                                    <a href="http://es.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
                                        <img src="${usercenterOrder.ordershopicon?if_exists}" alt="" width="80" height="80">
                                    </a>
                                </div>
                                <div class="data_top">
                                    <span class="dd">企业变更</span>
                                    <a class="top_title" href="http://es.w7tong.com/${usercenterOrder.htmlpath?if_exists}">公司变更服务</a>
                                </div>
                                <div class="cont_a lf">
                                    <ul>
                                        <li>
                                            <p class="cont_a_a">服务类型：</p>
                                            <p class="cont_a_b">法人股东股权变更/公司名称变更</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">公司类型：</p>
                                            <p class="cont_a_b">有限责任公司</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">注册省份：</p>
                                            <p class="cont_a_b">北京</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">注册市区：</p>
                                            <p class="cont_a_b">北京</p>
                                        </li>
                                    </ul>
                                </div>
                                <div class="money_a lf">
                                    <ul>
                                        <li>
                                            <span class="money_a_a">已付款：</span>
                                            <span class="money_a_b">¥${usercenterOrder.paymoney?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
                                            <span class="money_a_b">1</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
                                            <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">过户费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.transferfee?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">服务费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.orderservicemoney?if_exists}</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="unit_price lf">
                                     ¥${usercenterOrder.orderallmoney?if_exists}
                                </div>
                                <div class="state lf">
                                   <#if usercenterOrder.orderstate=='1'>
                                        <span>未付款</span>
                                     <#elseif usercenterOrder.orderstate=='2'> 
                                        <span>已付定金</span>
                                     <#elseif usercenterOrder.orderstate=='3'> 
                                        <span>已付款</span>
                                     <#elseif usercenterOrder.orderstate=='4'> 
                                        <span>交易完成</span>
                                     <#elseif usercenterOrder.orderstate=='5'> 
                                        <span>订单取消</span>
                                     <#else>
									  	<span>交易完成</span>
									 </#if>
                                </div>
                                <div class="operation lf">
                                    <ul>
                                        <#if usercenterOrder.orderstate=='1'>
	                                        <li>
                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/3">去付款</a>
                                            </li>
                                            <li>
                                                <a href="/order/buyer/es/cancel/${usercenterOrder.ordercode?if_exists}/type/3">取消订单</a>
                                            </li>
	                                     <#elseif usercenterOrder.orderstate=='2'> 
	                                         <li>
                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/3">去付款</a>
                                            </li>
                                            <li>
                                                <a href="/order/buyer/es/cancel/${usercenterOrder.ordercode?if_exists}/type/3">取消订单</a>
                                            </li>
	                                     <#elseif usercenterOrder.orderstate=='3'> 
	                                         <li>
	                                            <a href="">订单详情</a>
	                                         </li>
	                                     <#elseif usercenterOrder.orderstate=='4'> 
	                                        <li>
	                                            <a href="">订单详情</a>
	                                        </li>
	                                     <#else>
										 </#if>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        </#if>
		                <#if usercenterOrder.orderkind=='gszc'>
                        <!--企业注册-->
                        <li>
                            <div class="order_data_title">
                                <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
                                <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
                                <a href="javascript:;" class="delate">
                                    <img src="/usercenter/image/delate.png" alt="">
                                </a>
                            </div>
                            <div class="order_data_cont clear">
                                <div class="o_img lf">
                                    <a href="http://es.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
                                        <img src="${usercenterOrder.ordershopicon?if_exists}" alt="" width="80" height="80">
                                    </a>
                                </div>
                                <div class="data_top">
                                    <span class="dd">企业注册</span>
                                    <a class="top_title" href="http://es.w7tong.com/${usercenterOrder.htmlpath?if_exists}">公司注册</a>
                                </div>
                                <div class="cont_a lf">
                                    <ul>
                                        <li>
                                            <p class="cont_a_a">套餐类型：</p>
                                            <p class="cont_a_b">套餐1</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">公司类型：</p>
                                            <p class="cont_a_b">有限责任公司</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">企业行业：</p>
                                            <p class="cont_a_b">商贸贸易类</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">注册省份：</p>
                                            <p class="cont_a_b">北京</p>
                                        </li>
                                        <li>
                                            <p class="cont_a_a">注册市区：</p>
                                            <p class="cont_a_b">北京</p>
                                        </li>
                                    </ul>
                                </div>
                                <div class="money_a lf">
                                    <ul>
                                         <li>
                                            <span class="money_a_a">已付款：</span>
                                            <span class="money_a_b">¥${usercenterOrder.paymoney?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
                                            <span class="money_a_b">1</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
                                            <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">过户费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.transferfee?if_exists}</span>
                                        </li>
                                        <li>
                                            <span class="money_a_a">服务费：</span>
                                            <span class="money_a_b">¥${usercenterOrder.orderservicemoney?if_exists}</span>
                                        </li>
                                    </ul>
                                </div>
                                <div class="unit_price lf">
                                     ¥${usercenterOrder.orderallmoney?if_exists}
                                </div>
                                <div class="state lf">
                                    <#if usercenterOrder.orderstate=='1'>
                                        <span>未付款</span>
                                     <#elseif usercenterOrder.orderstate=='2'> 
                                        <span>已付定金</span>
                                     <#elseif usercenterOrder.orderstate=='3'> 
                                        <span>已付款</span>
                                     <#elseif usercenterOrder.orderstate=='4'> 
                                        <span>交易完成</span>
                                     <#elseif usercenterOrder.orderstate=='5'> 
                                        <span>订单取消</span>
                                     <#else>
									  	<span>交易完成</span>
									 </#if>
                                </div>
                                <div class="operation lf">
                                    <ul>
                                        <#if usercenterOrder.orderstate=='1'>
	                                        <li>
                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/3">去付款</a>
                                            </li>
                                            <li>
                                                <a href="/order/buyer/es/cancel/${usercenterOrder.ordercode?if_exists}/type/3">取消订单</a>
                                            </li>
	                                     <#elseif usercenterOrder.orderstate=='2'> 
	                                         <li>
                                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/3">去付款</a>
                                            </li>
                                            <li>
                                                <a href="/order/buyer/es/cancel/${usercenterOrder.ordercode?if_exists}/type/3">取消订单</a>
                                            </li>
	                                     <#elseif usercenterOrder.orderstate=='3'> 
	                                         <li>
	                                            <a href="">订单详情</a>
	                                         </li>
	                                     <#elseif usercenterOrder.orderstate=='4'> 
	                                        <li>
	                                            <a href="">订单详情</a>
	                                        </li>
	                                     <#else>
										 </#if>
                                    </ul>
                                </div>
                            </div>
                        </li>
                       </#if>
                       <#if usercenterOrder.orderkind=='wd'>
                            <li>
				                <div class="order_data_title">
				                    <span class="order_time">${usercenterOrder.ordertime?if_exists}</span>
				                    <span class="order_number">订单号：${usercenterOrder.ordercode?if_exists}</span>
				                    <a href="javascript:;" class="delate">
				                        <img src="/usercenter/image/delate.png" alt="">
				                    </a>
				                </div>
				                <div class="order_data_cont clear">
				                    <div class="o_img lf">
										<a href="http://wd.w7tong.com/${usercenterOrder.htmlpath?if_exists}">
										    <#if usercenterOrder.worderplateformcode?string=='tm'>
					                          <img src="/catTypeIcon/tmpai_${usercenterOrder.wordermaincategoryid?if_exists}.jpg" width="80" height="80" alt="">
					                        <#elseif usercenterOrder.worderplateformcode?string=='tb'>
					                          <img src="/catTypeIcon/tbpai_${usercenterOrder.wordermaincategoryid?if_exists}.jpg" width="80" height="80" alt="">
					                        <#elseif usercenterOrder.worderplateformcode?string=='jd'>
					                          <img src="/catTypeIcon/jdpai_${usercenterOrder.wordermaincategoryid?if_exists}.png" width="80" height="80" alt="">
					                        </#if>
				                        </a>
				                    </div>
				                    <div class="data_top">
				                        <span class="dd">网店交易</span>
				                        <a class="top_title" href="http://wd.w7tong.com/${usercenterOrder.htmlpath?if_exists}">${usercenterOrder.ordershopname?if_exists}</a>
				                    </div>
				                    <div class="cont_a lf">
				                        <ul>
				                          <#if usercenterOrder.worderplateformcode?string=='tm'>
				                            <li>
				                                <p class="cont_a_a">网店类型：</p>
				                                <p class="cont_a_b">天猫商城</p>
				                            </li>
				                            <li>
				                                <p class="cont_a_a">商城类型</p>
				                                <p class="cont_a_b">${usercenterOrder.wordermalltypename?if_exists}</p>
				                            </li>
				                            <li>
				                                <p class="cont_a_a">主营类目：</p>
				                                <p class="cont_a_b">${usercenterOrder.wordermaincategoryname?if_exists}</p>
				                            </li>
											<li>
				                                <p class="cont_a_a">商标类型：</p>
				                                <p class="cont_a_b">${usercenterOrder.worderbrandcategoryname?if_exists}</p>
				                            </li>
											<li>
				                                <p class="cont_a_a">商品编号：</p>
				                                <p class="cont_a_b">${usercenterOrder.ordershopcode?if_exists}</p>
				                            </li>
				                         <#elseif usercenterOrder.worderplateformcode?string=='tb'>
				                            <li>
				                                <p class="cont_a_a">网店类型：</p>
				                                <p class="cont_a_b">淘宝店铺</p>
				                            </li>
				                            <li>
				                                <p class="cont_a_a">主营类目：</p>
				                                <p class="cont_a_b">${usercenterOrder.wordermaincategoryname?if_exists}</p>
				                            </li>
											<li>
				                                <p class="cont_a_a">信用等级：</p>
				                                <p class="cont_a_b">${usercenterOrder.wordercredit?if_exists}</p>
				                            </li>
											<li>
				                                <p class="cont_a_a">商品编号：</p>
				                                <p class="cont_a_b">${usercenterOrder.ordershopcode?if_exists}</p>
				                            </li>
				                         <#elseif usercenterOrder.worderplateformcode?string=='jd'>
				                            <li>
				                                <p class="cont_a_a">网店类型：</p>
				                                <p class="cont_a_b"京东商城</p>
				                            </li>
				                            <li>
				                                <p class="cont_a_a">商城类型</p>
				                                <p class="cont_a_b">${usercenterOrder.wordermalltypename?if_exists}</p>
				                            </li>
				                            <li>
				                                <p class="cont_a_a">主营类目：</p>
				                                <p class="cont_a_b">${usercenterOrder.wordermaincategoryname?if_exists}</p>
				                            </li>
											<li>
				                                <p class="cont_a_a">商标类型：</p>
				                                <p class="cont_a_b">${usercenterOrder.worderbrandcategoryname?if_exists}</p>
				                            </li>
											<li>
				                                <p class="cont_a_a">商品编号：</p>
				                                <p class="cont_a_b">${usercenterOrder.ordershopcode?if_exists}</p>
				                            </li>
				                         </#if>
				                        </ul>
				                    </div>
				                    <div class="money_a lf">
				                        <ul>
				                           <#if usercenterOrder.worderplateformcode?string=='tm' || usercenterOrder.worderplateformcode?string=='tb'>
				                               <li>
				                                    <span class="money_a_a">消保金：</span>
				                                    <span class="money_a_b">￥${usercenterOrder.worderdepositmoney?if_exists}
				                                    <#if usercenterOrder.worderdeposittype?exists>
				                                        <#if usercenterOrder.worderdeposittype=='1'>
														    (需退还)
														</#if>
												    </#if>
				                                    </span>
				                                </li>
												<li>
				                                   <span class="money_a_a">技术年费：</span>
				                                   <span class="money_a_b">￥${usercenterOrder.wordertechfee?if_exists}
				                                     <#if usercenterOrder.worderreturntechfee?exists>
				                                         <#if usercenterOrder.worderreturntechfee=='2'>
														    (需退还
														    <#if usercenterOrder.wordertechfeeratio?if_exists=='0.5'>
														     50%
														    </#if>)
													 	</#if>
													</#if>
				                                   </span>
				                                </li>
				                            </#if>
				                            <li>
				                                <span class="money_a_a">已付款：</span>
				                                <span class="money_a_b">¥
				                                    <#if usercenterOrder.paymoney?exists>
                                                        ${usercenterOrder.paymoney?if_exists}
                                                     <#else>
													  	0.00
													 </#if>
				                                </span>
				                            </li>
				                            <li>
				                                <span class="money_a_a">数&nbsp&nbsp&nbsp量：</span>
				                                <span class="money_a_b">1</span>
				                            </li>
				                            <li>
				                                <span class="money_a_a">单&nbsp&nbsp&nbsp价：</span>
				                                <span class="money_a_b">¥${usercenterOrder.shopprice?if_exists}</span>
				                            </li>
				                            <li>
				                                <span class="money_a_a">服务费：</span>
				                                <span class="money_a_b">¥
				                                   <#if usercenterOrder.orderservicemoney?exists>
                                                        ${usercenterOrder.orderservicemoney?if_exists}
                                                     <#else>
													  	0.00
													 </#if>
				                                </span>
				                            </li>
				                        </ul>
				                    </div>
				                    <div class="unit_price lf">
				                        ¥${usercenterOrder.orderallmoney?if_exists}
				                    </div>
				                    <div class="state lf">
				                        <#if usercenterOrder.orderstate=='1'>
				                            <span>未付款</span>
				                        <#elseif usercenterOrder.orderstate=='2'> 
				                            <span>已付定金</span>
				                        <#elseif usercenterOrder.orderstate=='3'> 
				                            <span>已付款</span>
				                        <#elseif usercenterOrder.orderstate=='4'> 
				                            <span>交易完成</span>
				                        <#elseif usercenterOrder.orderstate=='5'> 
				                            <span>订单已取消</span>
				                        <#else>
											<span>交易完成</span>
										</#if>
				                    </div>
				                    <div class="operation lf">
				                        <#if usercenterOrder.orderstate=='1'>
					                        <ul>
					                            <li>
					                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/6">去付款</a>
					                            </li>
					                            <li>
					                                <a href="/order/buyer/wd/cancel/${usercenterOrder.ordercode?if_exists}/type/6">取消订单</a>
					                            </li>
					                        </ul>
					                    <#elseif usercenterOrder.orderstate=='2'> 
					                        <ul>
					                            <li>
					                                <a href="/order/pay/${usercenterOrder.ordercode?if_exists}/type/6">付余款</a>
					                            </li>
					                            <li>
					                                <a href="/order/buyer/wd/cancel/${usercenterOrder.ordercode?if_exists}/type/2">取消订单</a>
					                            </li>
					                        </ul>
					                    <#elseif usercenterOrder.orderstate=='3'> 
					                        <ul>
					                            <li>
					                                <a href="">订单详情</a>
					                            </li>
					                            <li>
					                                           
					                            </li>
					                        </ul>
					                    <#elseif usercenterOrder.orderstate=='4'> 
					                        <ul>
					                            <li>
					                                <a href="">订单详情</a>
					                            </li>
					                            <li>
					                                           
					                            </li>
					                        </ul>
					                    <#elseif usercenterOrder.orderstate=='5'> 
					                        <ul>
					                            <li>
					                                                                                                              订单已取消
					                            </li>
					                            <li>
					                            </li>
					                        </ul>
					                    <#else>
											<ul>
					                            <li>
					                                <a href="">订单详情</a>
					                            </li>
					                            <li>
					                            </li>
					                        </ul>
										</#if>
				                    </div>
				                </div>
				            </li>
                       </#if>
                      </#list>
                     </#if>
                </ul>
            </div>
                <!--无数据-->
                <div class="no_data" style="display: none;">
                    <div class="no_data_cont">
                        您还没有订单，去逛逛吧~
                    </div>
                </div>
            </div>
            <!--热门推荐-->
            <div class="order">
                <div class="order_title">
                    <p>热门推荐</p>
                </div>
                <div class="hot_tj">
                    <ul>
                        <li>
                            <a href="http://ipr.w7tong.com/shop/brandshop.html">
                                <p class="p1"><img src="/usercenter/image/brand.png" alt=""></p>
                                <p class="p2">商标转让</p>
                            </a>
                        </li>
                        <li>
                            <a href="http://ipr.w7tong.com/patentmark/patent.html">
                                <p class="p1"><img src="/usercenter/image/patent.png" alt=""></p>
                                <p class="p2">专利转让</p>
                            </a>
                        </li>
                        <li>
                            <a href="http://ipr.w7tong.com/copyrightmark/copyright.html">
                                <p class="p1"><img src="/usercenter/image/copyright.png" alt=""></p>
                                <p class="p2">版权转让</p>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;" class='develop'>
                                <p class="p1"><img src="/usercenter/image/tm.png" alt=""></p>
                                <p class="p2">天猫转让</p>
                            </a>
                        </li>
                        <li>
                            <a href="http://es.w7tong.com/trade/company---------------------1.html">
                                <p class="p1"><img src="/usercenter/image/component.png" alt=""></p>
                                <p class="p2">公司转让</p>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;" class='develop'>
                                <p class="p1"><img src="/usercenter/image/web.png" alt=""></p>
                                <p class="p2">网站交易</p>
                            </a>
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
<script src="/usercenter/js/usercenter_index.js"></script>
</html>