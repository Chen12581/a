<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>付款中心</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/user_header.css">
    <link rel="stylesheet" href="/usercenter/payment/css/payment.css">
    <link rel="stylesheet" href="/templates/css/footer.css">
</head>
<body>
<!--头部-->
<#include "/templates/pay_header.ftl">
<!--banner-->
<div class="center banner">
    <div class="banner_logo">
        <a href='http://www.w7tong.com' target='_blank'>
            <img src='/templates/image/header/logo.png' alt='万企通平台' width='225' height='64'>
        </a>
    </div>
    <div class="banner_cont">
        <i class="on">1.确认商品信息</i>
        <i>2.确认订单</i>
        <i>3.立即付款</i>
        <i>4.自助或联系客服交易</i>
        <i>5.交易成功</i>
    </div>
</div>
<div class="center">
<!--商品总金额-->
<#assign shoptotalmoney=0>
<!--订单服务费-->
<#assign orderservicemoney=0>
<!--订单优惠金额-->
<#assign orderfavourablemoney=0>

<!--订单实际支付金额-->
<#assign buytrueordermoney=0>

<!--订单过户费-->
<#assign ordertransferfee=0>
<!--订单商品价格-->
<#assign shopprice=0>
<!--订单商品数量-->
<#assign shoppnum=1>
<#if orderPaymentList.l_OrderPayment?exists>
<#list orderPaymentList.l_OrderPayment as payment>
<#if payment.brandOrderShop?exists>
<#assign iprBrandOrderShop=payment.brandOrderShop>
<#assign shoptotalmoney=shoptotalmoney+iprBrandOrderShop.ordermoney?number>
<#assign buytrueordermoney=buytrueordermoney+iprBrandOrderShop.buytrueordermoney?number>
<#assign orderservicemoney=orderservicemoney+iprBrandOrderShop.commisionbuy?number>
<#assign orderfavourablemoney=orderfavourablemoney+iprBrandOrderShop.favourablemoney?number>
<#assign ordertransferfee=ordertransferfee+iprBrandOrderShop.transferfee?number>
<#assign shoppnum=shoppnum+1>
    <!--商标订单-->
<div class="brand_order">
    <div class="order_number">
        <span>订单号:${iprBrandOrderShop.ordercode?if_exists}</span>
    </div>
    <div class="order_det clearfix">
        <div class="pay_info">
            <div class="img">
                <a href="http://ipr.w7tong.com/${iprBrandOrderShop.htmlpath?if_exists}" target="_blank">
                    <img src="${iprBrandOrderShop.brandicon?if_exists}" width="100" height="100" alt="">
                </a>
            </div>
            <div class="info">
                <div class="info_tit">
                    <span class="info_tit01">商标</span>
                    <a href="http://ipr.w7tong.com/${iprBrandOrderShop.htmlpath?if_exists}" target="_blank" class="info_tit02">${iprBrandOrderShop.brandname?if_exists}</a>
                </div>
                <div class="info_ul">
                    <ul class="txt lf">
                        <li>商标注册时间：${iprBrandOrderShop.startvalidity?if_exists} </li>
                        <li>商标分类：${iprBrandOrderShop.brandkind?substring(0,2)}类-${iprBrandOrderShop.brandkindname?if_exists}</li>
                        <li>商品编号：${iprBrandOrderShop.brandcode?if_exists}</li>
                        <li>有效期限：${iprBrandOrderShop.startvalidity?if_exists}至${iprBrandOrderShop.endvalidity?if_exists}</li>
                    </ul>
                    <div class="detail lf">
                        <ul>
                            <li>
                                <span>数量：</span>
                                <b class="number">1</b>
                            </li>
                            <li>
                                <span>单   价：</span>
                                <b class="number">￥${iprBrandOrderShop.ordermoney?if_exists}</b>
                            </li>
                            <li>
                                <span>服务费：</span>
                                <b class="number">￥${iprBrandOrderShop.commisionbuy?if_exists}</b>
                            </li>
                            <li>
                                <span>过户费：</span>
                                <b class="number">￥${iprBrandOrderShop.transferfee?if_exists}</b>
                            </li>
                            <li>
                                <span>优   惠：</span>
                                <b class="number">￥${iprBrandOrderShop.favourablemoney?if_exists}</b>
                            </li>
                        </ul>
                    </div>
                    <div class="price lf">
                        <div>
                            ￥
                            <span class="all_money">${iprBrandOrderShop.buytrueordermoney?if_exists}</span>
                        </div>
                        <div class="paid">已付：￥${iprBrandOrderShop.paymoney?if_exists}</div>
                    </div>
                </div>
            </div>
            <div class="pay_service rt">
                <dl>
                    <dt>
                        <img src="/${wqtworker.headurl?if_exists}" width="80" height="80" alt="">
                    </dt>
                    <dd class="txt01">${wqtworker.workername?if_exists}</dd>
                    <dd class="txt02">您的订单专属客服</dd>
                    <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
                </dl>
            </div>
        </div>
    </div>
    <div style="width:1200px;height: 20px;background: #FAFAFA"></div>
    <div class="pay_type">
        <div class="pay_center">
            <div class="kind">支付类型</div>
            <div class="zifu com_zf">
                <ul>
                  <#if iprBrandOrderShop.state=='2'>
                      <li class="on">支付余款</li>
                   <#else>
                      <li class="on">支付全款</li>
                      <li>支付定金</li>
                   </#if>
                </ul>
                <span></span>
            </div>
        </div>
    </div>
</div>
 </#if>
 
 <#if payment.patentOrderShop?exists>
 <#assign iprPatentOrderShop=payment.patentOrderShop>
 <#assign shoptotalmoney=shoptotalmoney+iprPatentOrderShop.ordermoney?number>
 <#assign buytrueordermoney=buytrueordermoney+iprPatentOrderShop.buytrueordermoney?number>
 <#assign orderservicemoney=orderservicemoney+iprPatentOrderShop.commisionbuy?number>
 <#assign orderfavourablemoney=orderfavourablemoney+iprPatentOrderShop.favourablemoney?number>
 <#assign ordertransferfee=ordertransferfee+iprPatentOrderShop.transferfee?number>
 <#assign shoppnum=shoppnum+1>
    <!--专利订单-->
    <div class="brand_order">
        <div class="order_number">
            <span>订单号:${iprPatentOrderShop.ordercode?if_exists}</span>
        </div>
        <div class="order_det clearfix">
            <div class="pay_info">
                <div class="img">
                    <a href="http://ipr.w7tong.com/${iprPatentOrderShop.htmlpath?if_exists}" target="_blank">
                        <img src="${iprPatentOrderShop.patenticon?if_exists}" width="100" height="100" alt="">
                    </a>
                </div>
                <div class="info">
                    <div class="info_tit">
                        <span class="info_tit01">专利</span>
                        <a href="http://ipr.w7tong.com/${iprPatentOrderShop.htmlpath?if_exists}" target="_blank" class="info_tit02">${iprPatentOrderShop.patenticon?if_exists}</a>
                    </div>
                    <div class="info_ul">
                        <ul class="txt lf">
                            <li class="half">注册时间：${iprPatentOrderShop.applydate?if_exists} </li>
                            <li class="half">专利状态：
                                 <#if iprPatentOrderShop.patentstate=='1'>
								           已授权未下证
								 <#elseif iprPatentOrderShop.patentstate=='2'>
								            已下证
								  </#if>
                            </li>
                            <li class="half">专利分类：
                                 <#if iprPatentOrderShop.patenttype=='1'>
								              发明专利
								  <#elseif iprPatentOrderShop.patenttype=='2'>
								           实用新型专利
								  <#elseif iprPatentOrderShop.patenttype=='3'>
								              外观设计专利
								  </#if>
                            </li>
                            <li class="half">专利行业：${iprPatentOrderShop.kindname?if_exists}</li>
                            <li>专利号：${iprPatentOrderShop.patentno?if_exists}</li>
                            <li>商品编号：${iprPatentOrderShop.shopcode?if_exists}</li>
                            <li>有效期限：${iprPatentOrderShop.applydate?if_exists}至 ${iprPatentOrderShop.validitydate?if_exists}</li>
                        </ul>
                        <div class="detail lf">
                            <ul>
                                <li>
                                    <span>数量：</span>
                                    <b class="number">1</b>
                                </li>
                                <li>
                                    <span>单   价：</span>
                                    <b class="number">￥${iprPatentOrderShop.ordermoney?if_exists}</b>
                                </li>
                                <li>
                                    <span>服务费：</span>
                                    <b class="number">￥${iprPatentOrderShop.commisionbuy?if_exists}</b>
                                </li>
                                <li>
                                    <span>过户费：</span>
                                    <b class="number">￥${iprPatentOrderShop.transferfee?if_exists}</b>
                                </li>
                                <li>
                                    <span>优   惠：</span>
                                    <b class="number">￥${iprPatentOrderShop.favourablemoney?if_exists}</b>
                                </li>
                            </ul>
                        </div>
                        <div class="price lf">
                            <div>
                                ￥
                                <span class="all_money">${iprPatentOrderShop.buytrueordermoney?if_exists}</span>
                            </div>
                            <div class="paid">已付：￥${iprPatentOrderShop.paymoney?if_exists}</div>
                        </div>
                    </div>
                </div>
                <div class="pay_service rt">
                    <dl>
	                    <dt>
	                        <img src="/${wqtworker.headurl?if_exists}" width="80" height="80" alt="">
	                    </dt>
	                    <dd class="txt01">${wqtworker.workername?if_exists}</dd>
	                    <dd class="txt02">您的订单专属客服</dd>
	                    <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
	                </dl>
                </div>
            </div>
        </div>
        <div style="width:1200px;height: 20px;background: #FAFAFA"></div>
        <div class="pay_type">
            <div class="pay_center">
                <div class="kind">支付类型</div>
                <div class="zifu com_zf">
                    <ul>
                       <#if iprPatentOrderShop.state=='2'>
                           <li class="on">支付余款</li>
                       <#else>
                          <li class="on">支付全款</li>
                          <li>支付定金</li>
                       </#if>
                    </ul>
                    <span></span>
                </div>
            </div>
        </div>
    </div>
</#if>

<#if payment.copyrightOrderShop?exists>
<#assign iprCopyrightOrderShop=payment.copyrightOrderShop>
<#assign shoptotalmoney=shoptotalmoney+iprCopyrightOrderShop.ordermoney?number>
 <#assign buytrueordermoney=buytrueordermoney+iprCopyrightOrderShop.buytrueordermoney?number>
 <#assign orderservicemoney=orderservicemoney+iprCopyrightOrderShop.commisionbuy?number>
 <#assign orderfavourablemoney=orderfavourablemoney+iprCopyrightOrderShop.favourablemoney?number>
 <#assign ordertransferfee=ordertransferfee+iprCopyrightOrderShop.transferfee?number>
 <#assign shoppnum=shoppnum+1>
    <!--版权订单-->
    <div class="brand_order">
        <div class="order_number">
             <span>订单号:${iprCopyrightOrderShop.ordercode?if_exists}</span>
        </div>
        <div class="order_det clearfix">
            <div class="pay_info">
                <div class="img">
                    <a href="http://ipr.w7tong.com/${iprCopyrightOrderShop.htmlpath?if_exists}" target="_blank">
                        <img src="${iprCopyrightOrderShop.copyrighticon?if_exists}" width="100" height="100" alt="">
                    </a>
                </div>
                <div class="info">
                    <div class="info_tit">
                        <span class="info_tit01">版权</span>
                        <a href="http://ipr.w7tong.com/${iprCopyrightOrderShop.htmlpath?if_exists}" target="_blank" class="info_tit02">${iprCopyrightOrderShop.copyrightname?if_exists}</a>
                    </div>
                    <div class="info_ul">
                        <ul class="txt lf">
                            <li>版权分类：${iprCopyrightOrderShop.copyrightkindname?if_exists}</li>
                            <li>商品编号：${iprCopyrightOrderShop.copyrightcode?if_exists}</li>
                            <li>授权方式：
                              <#if iprCopyrightOrderShop.competentmethod?exists>
                                 <#if iprCopyrightOrderShop.competentmethod=='1'>
								            独家
								  <#elseif iprPatentOrderShop.competentmethod=='2'>
								          非独家
								  </#if>
						     <#else>
						        /
						     </#if>
                            </li>
                        </ul>
                        <div class="detail lf">
                            <ul>
                                <li>
                                    <span>数量：</span>
                                    <b class="number">1</b>
                                </li>
                                <li>
                                    <span>单   价：</span>
                                    <b class="number">￥${iprCopyrightOrderShop.ordermoney?if_exists}</b>
                                </li>
                                <li>
                                    <span>服务费：</span>
                                    <b class="number">￥${iprCopyrightOrderShop.commisionbuy?if_exists}</b>
                                </li>
                                <li>
                                    <span>过户费：</span>
                                    <b class="number">￥${iprCopyrightOrderShop.transferfee?if_exists}</b>
                                </li>
                                <li>
                                    <span>优   惠：</span>
                                    <b class="number">￥${iprCopyrightOrderShop.favourablemoney?if_exists}</b>
                                </li>
                            </ul>
                        </div>
                        <div class="price lf">
                            <div>
                                ￥
                                <span class="all_money">${iprCopyrightOrderShop.buytrueordermoney?if_exists}</span>
                            </div>
                            <div class="paid">已付：￥${iprCopyrightOrderShop.paymoney?if_exists}</div>
                        </div>
                    </div>
                </div>
                <div class="pay_service rt">
                     <dl>
	                    <dt>
	                        <img src="/${wqtworker.headurl?if_exists}" width="80" height="80" alt="">
	                    </dt>
	                    <dd class="txt01">${wqtworker.workername?if_exists}</dd>
	                    <dd class="txt02">您的订单专属客服</dd>
	                    <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
	                </dl>
                </div>
            </div>
        </div>
        <div style="width:1200px;height: 20px;background: #FAFAFA"></div>
        <div class="pay_type">
            <div class="pay_center">
                <div class="kind">支付类型</div>
                <div class="zifu com_zf">
                    <ul>
                      <#if iprCopyrightOrderShop.state=='2'>
                          <li class="on">支付余款</li>
                       <#else>
                          <li class="on">支付全款</li>
                          <li>支付定金</li>
                        
                       </#if>
                    </ul>
                    <span></span>
                </div>
            </div>
        </div>
    </div>
</#if>
<#if payment.brandOrderProduct?exists>
<#assign iprBrandOrderProduct=payment.brandOrderProduct>
<#assign shoptotalmoney=shoptotalmoney+iprBrandOrderProduct.orderallmoney?number>
<#assign buytrueordermoney=buytrueordermoney+iprBrandOrderProduct.ordermoney?number>
 <#assign orderfavourablemoney=orderfavourablemoney+iprBrandOrderProduct.favourablemoney?number>
<#assign shoppnum=shoppnum+iprBrandOrderProduct.productnum?number>
    <!--商标服务订单-->
    <div class="brand_order">
        <div class="order_number">
            <span>订单号: ${iprBrandOrderProduct.ordercode?if_exists}</span>
        </div>
        <div class="order_det clearfix">
            <div class="pay_info">
                <div class="img">
                    <a href="http://ipr.w7tong.com/${iprBrandOrderProduct.htmlpath?if_exists}" target="_blank">
                        <img src="http://ipr.w7tong.com/${iprBrandOrderProduct.brandicon?if_exists}" width="100" height="100" alt="">
                    </a>
                </div>
                <div class="info">
                    <div class="od_title">
                      ${iprBrandOrderProduct.brandproductname?if_exists}
                    </div>
                    <div class="info_ul">
                        <ul class="txt lf">
                            <li>商品套餐：${iprBrandOrderProduct.brandproductname?if_exists}</li>
                            <!--<li>最长时长：12个月</li>-->
                            <li class="jj">代理简介：${iprBrandOrderProduct.brandproductdesc?if_exists}</li>
                        </ul>
                        <div class="detail lf">
                            <ul>
                                <li>
                                    <span>数量：</span>
                                    <b class="number">${iprBrandOrderProduct.productnum?if_exists}</b>
                                </li>
                                <li>
                                    <span>单   价：</span>
                                    <b class="number">￥${iprBrandOrderProduct.productprice?if_exists}</b>
                                </li>
                                <li>
                                    <span>服务费：</span>
                                    <b class="number">￥0.00</b>
                                </li>
                                <li>
                                    <span>优   惠：</span>
                                    <b class="number">￥${iprBrandOrderProduct.favourablemoney?if_exists}</b>
                                </li>
                            </ul>
                        </div>
                        <div class="price lf">
                            <div>
                                ￥
                                <span class="all_money">${iprBrandOrderProduct.ordermoney?if_exists}</span>
                            </div>
                            <div class="paid">已付：￥${iprBrandOrderProduct.paymoney?if_exists}</div>
                        </div>
                    </div>
                </div>
                <div class="pay_service rt">
                    <dl>
	                    <dt>
	                        <img src="/${wqtworker.headurl?if_exists}" width="80" height="80" alt="">
	                    </dt>
	                    <dd class="txt01">${wqtworker.workername?if_exists}</dd>
	                    <dd class="txt02">您的订单专属客服</dd>
	                    <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
	                </dl>
                </div>
            </div>
        </div>
        <div style="width:1200px;height: 20px;background: #FAFAFA"></div>
        <div class="pay_type">
            <div class="pay_center">
                <div class="kind">支付类型</div>
                <div class="zifu com_zf">
                    <ul>
                       <#if iprBrandOrderProduct.state=='2'>
                          <li class="on">支付余款</li>
                       <#else>
                          <li class="on">支付全款</li>
                          <li>支付定金</li>
                        
                       </#if>
                    </ul>
                    <span></span>
                </div>
            </div>
        </div>
    </div>
</#if>


<#if payment.patentOrderProduct?exists>
<#assign iprPatentOrderProduct=payment.patentOrderProduct>
<#assign shoptotalmoney=shoptotalmoney+iprPatentOrderProduct.orderallmoney?number>
 <#assign buytrueordermoney=shoptotalmoney+iprPatentOrderProduct.ordermoney?number>
<#assign orderfavourablemoney=shoptotalmoney+iprPatentOrderProduct.favourablemoney?number>
<#assign shoppnum=shoptotalmoney+iprPatentOrderProduct.productnum?number>
    <!--专利服务订单-->
    <div class="brand_order">
        <div class="order_number">
          <span>订单号: ${iprPatentOrderProduct.ordercode?if_exists}</span>
        </div>
        <div class="order_det clearfix">
            <div class="pay_info">
                <div class="img">
                    <a href="http://ipr.w7tong.com/${iprPatentOrderProduct.htmlpath?if_exists}" target="_blank">
                        <img src="http://ipr.w7tong.com/${iprPatentOrderProduct.patenticon?if_exists}" width="100" height="100" alt="">
                    </a>
                </div>
                <div class="info">
                    <div class="od_title">
                        专利案件代理
                    </div>
                    <div class="info_ul">
                        <ul class="txt lf">
                            <li>商品套餐：${iprPatentOrderProduct.patentproductname?if_exists} </li>
                            <!--<li>最长时长：12个月</li>-->
                            <li class="jj">代理简介：${iprPatentOrderProduct.patentproductdesc?if_exists} </li>
                        </ul>
                        <div class="detail lf">
                            <ul>
                                <li>
                                    <span>数量：</span>
                                    <b class="number">${iprPatentOrderProduct.productnum?if_exists}</b>
                                </li>
                                <li>
                                    <span>单   价：</span>
                                    <b class="number">￥${iprPatentOrderProduct.productprice?if_exists}</b>
                                </li>
                                <li>
                                    <span>服务费：</span>
                                    <b class="number">￥0.00</b>
                                </li>
                                <li>
                                    <span>优   惠：</span>
                                    <b class="number">￥${iprPatentOrderProduct.favourablemoney?if_exists}</b>
                                </li>
                            </ul>
                        </div>
                        <div class="price lf">
                            <div>
                                ￥
                                <span class="all_money">${iprPatentOrderProduct.ordermoney?if_exists}</span>
                            </div>
                            <div class="paid">已付：￥${iprPatentOrderProduct.paymoney?if_exists}</div>
                        </div>
                    </div>
                </div>
                <div class="pay_service rt">
                     <dl>
	                    <dt>
	                        <img src="/${wqtworker.headurl?if_exists}" width="80" height="80" alt="">
	                    </dt>
	                    <dd class="txt01">${wqtworker.workername?if_exists}</dd>
	                    <dd class="txt02">您的订单专属客服</dd>
	                    <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
	                </dl>
                </div>
            </div>
        </div>
        <div style="width:1200px;height: 20px;background: #FAFAFA"></div>
        <div class="pay_type">
            <div class="pay_center">
                <div class="kind">支付类型</div>
                <div class="zifu com_zf">
                    <ul>
                       <#if iprPatentOrderProduct.state=='2'>
                         <li class="on">支付余款</li>
                       <#else>
                           <li class="on">支付全款</li>
                          <li>支付定金</li>
                         
                       </#if>
                      
                    </ul>
                    <span></span>
                </div>
            </div>
        </div>
    </div>
</#if>

<#if payment.copyrightOrderProduct?exists>
<#assign iprCopyrightOrderProduct=payment.copyrightOrderProduct>
<#assign shoptotalmoney=shoptotalmoney+iprCopyrightOrderProduct.orderallmoney?number>
 <#assign buytrueordermoney=buytrueordermoney+iprCopyrightOrderProduct.ordermoney?number>
<#assign orderfavourablemoney=orderfavourablemoney+iprCopyrightOrderProduct.favourablemoney?number>
<#assign shoppnum=shoppnum+iprCopyrightOrderProduct.productnum?number>
    <!--版权服务订单-->
    <div class="brand_order">
        <div class="order_number">
            <span>订单号: ${iprCopyrightOrderProduct.ordercode?if_exists}</span>
        </div>
        <div class="order_det clearfix">
            <div class="pay_info">
                <div class="img">
                    <a href="http://ipr.w7tong.com/${iprCopyrightOrderProduct.htmlpath?if_exists}" target="_blank">
                        <img src="http://ipr.w7tong.com/${iprCopyrightOrderProduct.copyrighticon?if_exists}" width="100" height="100" alt="">
                    </a>
                </div>
                <div class="info">
                    <div class="od_title">
                        版权案件代理
                    </div>
                    <div class="info_ul">
                        <ul class="txt lf">
                            <li>商品套餐：${iprCopyrightOrderProduct.htmlpath?if_exists} </li>
                            <!--<li>最长时长：12个月</li>-->
                            <li class="jj">代理简介：${iprCopyrightOrderProduct.copyrightproductdesc?if_exists}</li>
                        </ul>
                        <div class="detail lf">
                            <ul>
                                <li>
                                    <span>数量：</span>
                                    <b class="number">${iprCopyrightOrderProduct.productnum?if_exists}</b>
                                </li>
                                <li>
                                    <span>单   价：</span>
                                    <b class="number">￥${iprCopyrightOrderProduct.productprice?if_exists}</b>
                                </li>
                                <li>
                                    <span>服务费：</span>
                                    <b class="number">￥0.00</b>
                                </li>
                                <li>
                                    <span>优   惠：</span>
                                    <b class="number">￥${iprCopyrightOrderProduct.favourablemoney?if_exists}</b>
                                </li>
                            </ul>
                        </div>
                        <div class="price lf">
                            <div>
                                ￥
                                <span class="all_money">${iprCopyrightOrderProduct.ordermoney?if_exists}</span>
                            </div>
                            <div class="paid">已付：￥${iprCopyrightOrderProduct.paymoney?if_exists}</div>
                        </div>
                    </div>
                </div>
                <div class="pay_service rt">
                     <dl>
	                    <dt>
	                        <img src="/${wqtworker.headurl?if_exists}" width="80" height="80" alt="">
	                    </dt>
	                    <dd class="txt01">${wqtworker.workername?if_exists}</dd>
	                    <dd class="txt02">您的订单专属客服</dd>
	                    <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
	                </dl>
                </div>
            </div>
        </div>
        <div style="width:1200px;height: 20px;background: #FAFAFA"></div>
        <div class="pay_type">
            <div class="pay_center">
                <div class="kind">支付类型</div>
                <div class="zifu com_zf">
                    <ul>
                       <#if iprCopyrightOrderProduct.state=='2'>
                           <li class="on">支付余款</li>
                       <#else>
                           <li class="on">支付全款</li>
                           <li>支付定金</li>
                       </#if>
                    </ul>
                    <span></span>
                </div>
            </div>
        </div>
    </div>
</#if>
 
<#if payment.esOrderTrade?exists>
<#assign esOrderTrade=payment.esOrderTrade>
<#assign shoptotalmoney=shoptotalmoney+esOrderTrade.ordermoney?number>
<#assign buytrueordermoney=buytrueordermoney+esOrderTrade.buytrueordermoney?number>
<#assign orderfavourablemoney=orderfavourablemoney+esOrderTrade.favourablemoney?number>
<#assign orderservicemoney=orderservicemoney+esOrderTrade.commisionbuy?number>
<#assign shoppnum=shoppnum+1>
    <!--企业交易-->
    <div class="brand_order">
        <div class="order_number">
             <span>订单号: ${esOrderTrade.ordercode?if_exists}</span>
        </div>
        <div class="order_det clearfix">
            <div class="pay_info">
                <div class="img">
                    <a href="http://es.w7tong.com/${esOrderTrade.htmlpath?if_exists}" target="_blank">
                        <img src="${esOrderTrade.companyshopicon?if_exists}" width="100" height="100" alt="">
                    </a>
                </div>
                <div class="info">
                    <div class="info_tit">
                        <span class="info_tit01">公司名称</span>
                        <a href="http://es.w7tong.com/${esOrderTrade.htmlpath?if_exists}" target="_blank" class="info_tit02">${esOrderTrade.companyshopname?if_exists}</a>
                    </div>
                    <div class="info_ul">
                        <ul class="txt lf">
                            <li class="half">企业行业：${esOrderTrade.companyindustryname?if_exists} </li>
                            <li class="half">企业类型：
                              <#if esOrderTrade.companytype?exists>
                                  <#if  esOrderTrade.companytype?string=='1'>
					                                                                 有限责任公司
					              <#elseif  esOrderTrade.companytype?string=='2'>
					                                                              个人独资公司
					              <#elseif  esOrderTrade.companytype?string=='3'>
					                                                             集团公司
					              <#elseif  esOrderTrade.companytype?string=='4'>
					                                                        港澳台公司
					              </#if>
					           <#else>
							       /
							  </#if>
                            </li>
                            <li class="half">经营时间：
                            <#if esOrderTrade.holddate?exists>
	                              <#if  esOrderTrade.holddate?string=='1'>
					                  1年以下
					              <#elseif  esOrderTrade.holddate?string=='2'>
					                  1-2年
					              <#elseif  esOrderTrade.holddate?string=='3'>
					                 2-3年
					              <#elseif  esOrderTrade.holddate?string=='4'>
					                   3年以上
					              </#if>
					         <#else>
							       /
				            </#if>
                            </li>
                            <li class="half">纳税类型：
	                            <#if esOrderTrade.dutytype?exists>
                                      <#if  esOrderTrade.dutytype?string=='1'>
							                                                  小规模纳税人
						              <#elseif  esOrderTrade.dutytype?string=='2'>
						                                                               一般纳税人
						              <#elseif  esOrderTrade.dutytype?string=='3'>
						                                                          出口纳税人
						              <#elseif  esOrderTrade.dutytype?string=='4'>
						                                                          未核税
						              </#if>
							    <#else>
							       /
							    </#if>
                            </li>
                            <li>注册资本：
                              <#if esOrderTrade.regcapital?exists>
	                              <#if  esOrderTrade.regcapital?string=='1'>
					                   50万以下
					              <#elseif  esOrderTrade.regcapital?string=='2'>
					                   50-100万
					              <#elseif  esOrderTrade.regcapital?string=='3'>
					                   100-500万
					              <#elseif  esOrderTrade.regcapital?string=='4'>
					                   500-1000万
					              <#elseif  esOrderTrade.regcapital?string=='5'>
					                   1000万以上
					              </#if>
				                <#else>
							       /
							    </#if>
                            </li>
                            <li>商品编号：${esOrderTrade.shopcode?if_exists}</li>
                        </ul>
                        <div class="detail lf">
                            <ul>
                                <li>
                                    <span>数量：</span>
                                    <b class="number">1</b>
                                </li>
                                <li>
                                    <span>单   价：</span>
                                    <b class="number">￥${esOrderTrade.ordermoney?if_exists}</b>
                                </li>
                                <li>
                                    <span>服务费：</span>
                                    <b class="number">￥${esOrderTrade.commisionbuy?if_exists}</b>
                                </li>
                                <li>
                                    <span>过户费：</span>
                                    <b class="number">￥0.00</b>
                                </li>
                                <li>
                                    <span>优   惠：</span>
                                    <b class="number">￥${esOrderTrade.favourablemoney?if_exists}</b>
                                </li>
                            </ul>
                        </div>
                        <div class="price lf">
                            <div>
                                ￥
                                <span class="all_money">${esOrderTrade.buytrueordermoney?if_exists}</span>
                            </div>
                            <div class="paid">已付：￥${esOrderTrade.paymoney?if_exists}</div>
                        </div>
                    </div>
                </div>
                <div class="pay_service rt">
                    <dl>
	                    <dt>
	                        <img src="/${wqtworker.headurl?if_exists}" width="80" height="80" alt="">
	                    </dt>
	                    <dd class="txt01">${wqtworker.workername?if_exists}</dd>
	                    <dd class="txt02">您的订单专属客服</dd>
	                    <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
	                </dl>
                </div>
            </div>
        </div>
        <div style="width:1200px;height: 20px;background: #FAFAFA"></div>
        <div class="pay_type">
            <div class="pay_center">
                <div class="kind">支付类型</div>
                <div class="zifu com_zf">
                    <ul>
                       <#if esOrderTrade.state=='2'>
                           <li class="on">支付余款</li>
                       <#else>
                           <li class="on">支付全款</li>
                           <li>支付定金</li>
                       </#if>
                    </ul>
                    <span></span>
                </div>
            </div>
        </div>
    </div>
</#if>

<#if payment.esOrderService?exists>
<#assign esOrderService=payment.esOrderService>
<#assign shoptotalmoney=shoptotalmoney+esOrderService.orderallmoney?number>
<#assign buytrueordermoney=buytrueordermoney+esOrderService.ordermoney?number>
<#assign orderfavourablemoney=orderfavourablemoney+esOrderService.favourablemoney?number>
<#assign shoppnum=shoppnum+1>
    <!--企业服务-->
    <div class="brand_order">
        <div class="order_number">
            <span>订单号: ${esOrderService.ordercode?if_exists}</span>
        </div>
        <div class="order_det clearfix">
            <div class="pay_info">
                <div class="img">
                    <a href="http://es.w7tong.com/${esOrderService.htmlpath?if_exists}" target="_blank">
                        <img src="http://es.w7tong.com/${esOrderService.producticon?if_exists}" width="100" height="100" alt="">
                    </a>
                </div>
                <div class="info">
                    <div class="info_tit">
                        <span class="info_tit01">服务名称</span>
                        <a href="http://es.w7tong.com/${esOrderService.htmlpath?if_exists}" target="_blank" class="info_tit02">${esOrderService.productname?if_exists}</a>
                    </div>
                    <div class="info_ul">
                        <ul class="txt lf">
                            <li>套餐：${esOrderService.productname?if_exists}</li>
                            <li class="half">${esOrderService.productdesc?if_exists}</li>
                        </ul>
                        <div class="detail lf">
                            <ul>
                                <li>
                                    <span>数量：</span>
                                    <b class="number">1</b>
                                </li>
                                <li>
                                    <span>单   价：</span>
                                    <b class="number">￥${esOrderService.productprice?if_exists}</b>
                                </li>
                                <li>
                                    <span>服务费：</span>
                                    <b class="number">￥0.00</b>
                                </li>
                                <li>
                                    <span>过户费：</span>
                                    <b class="number">￥0.00</b>
                                </li>
                                <li>
                                    <span>优   惠：</span>
                                    <b class="number">￥${esOrderService.favourablemoney?if_exists}</b>
                                </li>
                            </ul>
                        </div>
                        <div class="price lf">
                            <div>
                                ￥
                                <span class="all_money">${esOrderService.ordermoney?if_exists}</span>
                            </div>
                            <div class="paid">已付：￥${esOrderService.paymoney?if_exists}</div>
                        </div>
                    </div>
                </div>
                <div class="pay_service rt">
                    <dl>
	                    <dt>
	                        <img src="/${wqtworker.headurl?if_exists}" width="80" height="80" alt="">
	                    </dt>
	                    <dd class="txt01">${wqtworker.workername?if_exists}</dd>
	                    <dd class="txt02">您的订单专属客服</dd>
	                    <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
	                </dl>
                </div>
            </div>
        </div>
        <div style="width:1200px;height: 20px;background: #FAFAFA"></div>
        <div class="pay_type">
            <div class="pay_center">
                <div class="kind">支付类型</div>
                <div class="zifu com_zf">
                    <ul>
                        <#if esOrderService.state=='2'>
                          <li class="on">支付余款</li>
                       <#else>
                          <li class="on">支付全款</li>
                          <li>支付定金</li>
                        
                       </#if>
                    </ul>
                    <span></span>
                </div>
            </div>
        </div>
    </div>
 </#if>
 
 
<#if payment.eShopOrder?exists>
<#assign eShopOrder=payment.eShopOrder>
<#assign shoptotalmoney=shoptotalmoney+eShopOrder.ordermoney?replace(',','')?number>
<#assign buytrueordermoney=buytrueordermoney+eShopOrder.buytrueordermoney?replace(',','')?number>
<#assign orderfavourablemoney=orderfavourablemoney+eShopOrder.favourablemoney?replace(',','')?number>
<#assign orderservicemoney=orderservicemoney+eShopOrder.commisionbuy?replace(',','')?number>
<#assign shoppnum=shoppnum+1> 
 <!--网店转让-->
    <div class="brand_order">
        <div class="order_number">
            <span>订单:${eShopOrder.ordercode?if_exists}</span>
        </div>
        <div class="order_det clearfix">
            <div class="pay_info">
                <div class="img">
                    <a href="http://wd.w7tong.com/${eShopOrder.htmlpath?if_exists}" target="_blank">
                       <#if eShopOrder.plateformcode?string=='tm'>
                          <img src="/catTypeIcon/tmpai_${eShopOrder.maincategoryid?if_exists}.jpg" width="100" height="100" alt="">
                       <#elseif eShopOrder.plateformcode?string=='tb'>
                          <img src="/catTypeIcon/tbpai_${eShopOrder.maincategoryid?if_exists}.jpg" width="100" height="100" alt="">
                       <#elseif eShopOrder.plateformcode?string=='jd'>
                          <img src="/catTypeIcon/jdpai_${eShopOrder.maincategoryid?if_exists}.png" width="100" height="100" alt="">
                       </#if>
                    </a>
                </div>
                <div class="info">
                    <div class="info_tit">
                        <span class="info_tit01">网店标题</span>
                        <a href="http://wd.w7tong.com/${eShopOrder.htmlpath?if_exists}" target="_blank" class="info_tit02">${eShopOrder.shoptitle?if_exists}</a>
                    </div>
                    <div class="info_ul">
                        <ul class="txt lf">
                           <#if eShopOrder.plateformcode?string=='tm'>
	                            <li>网店类型：天猫商城 </li>
	                            <li>商城类型：${eShopOrder.malltypename?if_exists}</li>
                                <li>主营类目：${eShopOrder.maincategoryname?if_exists}</li>
                                <li>商标类型：${eShopOrder.brandcategoryname?if_exists}</li>
                                <li>商品编号：${eShopOrder.shopcode?if_exists}</li>
	                       <#elseif eShopOrder.plateformcode?string=='tb'>
	                            <li>网店类型：淘宝店铺 </li>
	                            <li>主营类目：${eShopOrder.maincategoryname?if_exists}</li>
								<li>信用等级：${eShopOrder.creditname?if_exists}</li>
								<li>商品编号：${eShopOrder.shopcode?if_exists}</li>
	                       <#elseif eShopOrder.plateformcode?string=='jd'>
	                            <li>网店类型：京东商城 </li>
	                            <li>商城类型：${eShopOrder.malltypename?if_exists}</li>
                                <li>主营类目：${eShopOrder.maincategoryname?if_exists}</li>
                                <li>商标类型：${eShopOrder.obrandcategoryname?if_exists}</li>
                                <li>商品编号：${eShopOrder.shopcode?if_exists}</li>
	                       </#if>
                       
                           
                        </ul>
                        <div class="detail lf">
                            <ul>
                                <li>
                                    <span>数量：</span>
                                    <b class="number">1</b>
                                </li>
                                <li>
                                    <span>单   价：</span>
                                    <b class="number">￥${eShopOrder.ordermoney?if_exists}</b>
                                </li>
                                <li>
                                    <span>服务费：</span>
                                    <b class="number">￥${eShopOrder.commisionbuy?if_exists}</b>
                                </li>
                                <li>
                                    <span>消保金：</span>
                                    <b class="number">￥${eShopOrder.depositmoney?if_exists}
                                      <#if eShopOrder.deposittype==1>
										    (需退还)
										</#if>
                                    </b>
                                </li>
								<li>
                                    <span>技术年费：</span>
                                    <b class="number">￥${eShopOrder.techfee?if_exists}
                                         <#if eShopOrder.techfeereturn==2>
										    (需退还
										    <#if eShopOrder.techfeeratio?if_exists=='0.5'>
										     50%
										    </#if>)
									 	</#if>
                                    </b>
                                </li>
                                <li>
                                    <span>优   惠：</span>
                                    <b class="number">￥
                                         <#if eShopOrder.favourablemoney?exists>
                                            ${eShopOrder.favourablemoney?if_exists}
                                         <#else>
										  	0.00
										 </#if>
                                    </b>
                                </li>
                            </ul>
                        </div>
                        <div class="price lf">
                            <div>
                                                                                                              ￥
                                <span class="all_money">${eShopOrder.buytrueordermoney?if_exists}</span>
                            </div>
                            <div class="paid">已付：￥
                                 <#if eShopOrder.paymoney?exists>
                                    ${eShopOrder.paymoney?if_exists}
                                 <#else>
								  	0.00
								 </#if>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="pay_service rt">
                    <dl>
	                    <dt>
	                        <img src="${wqtworker.headurl?if_exists}" width="80" height="80" alt="">
	                    </dt>
	                    <dd class="txt01">${wqtworker.workername?if_exists}</dd>
	                    <dd class="txt02">您的订单专属客服</dd>
	                    <dd class="btn"><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank">联系客服</a></dd>
	                </dl>
                </div>
            </div>
        </div>
        <div style="width:1200px;height: 20px;background: #FAFAFA"></div>
        <div class="pay_type">
            <div class="pay_center">
                <div class="kind">支付类型</div>
                <div class="zifu com_zf">
                    <ul>
                        <li class="on">支付全款</li>
                        <li>支付定金</li>
                    </ul>
                    <span></span>
                </div>
            </div>
        </div>
    </div>
   </#if>
</#list>
</#if>
	<!--支付方式-->
	<#if orderPaymentList.wqtUserBasic?exists>
	<#assign wqtUserBasic=orderPaymentList.wqtUserBasic>
	</#if>
	<div class="pay_type center pay_kind" >
		<div class="pay_center">
			<div class="kind">支付方式</div>
			<div class="zifu alane_zf">
				<ul>
					<li class="on">账户余额支付</li>
					<li>网银在线支付</li>
				</ul>
				<span>当前您的帐户(${wqtUserBasic.username?if_exists})余额：<b class="rem_price">￥${wqtUserBasic.money?if_exists}</b></span>
			</div>
			<!--账户余额支付时显示-->
			<#if orderPaymentList.esOrderService?exists>
				<div class="top_up">
					<p>当前余额不满足您目前的订单金额，请先<a href="" target="_blank">充值</a>或选择其他支付方式</p>
				</div>
			 </#if>
			<!--网银在线支付时显示-->
			<div class="pay_balance clearfix" data-id="0"  style="display: none">
				<div class="balance_img lf"><img src="/usercenter/payment/image/payment/wput.png" width="14" height="14"></div>
				<p class="lf">您账户尚有余额，将优先扣除账户余额，剩余款项由网银进行支付</p>
			</div>
			<p class="ts">提示：购买商品，卖家无理由退款不退服务费</p>
		</div>
	</div>

	<!--最后结算-->
	<div class="center settlement">
		<ul>
			<li>
				<b id="number">${shoppnum}</b>
				件商品，总商品金额：
				<span>￥<b id="money">${shoptotalmoney}</b></span>
			</li>
			<li>
				服务费：
				<span>￥<b id="service">${orderservicemoney}</b></span>
			</li>
			<li>
				优惠：
				<span>￥<b id="count">${orderfavourablemoney}</b></span>
			</li>
			<li>
				过户费：
				<span>￥<b id="other_money">${ordertransferfee}</b></span>
			</li>
			<li>
				应支付金额：
				<span>￥<b id="all_paid_money">${buytrueordermoney}</b></span>
			</li>
			<li>
				本次支付金额：
				<span>￥<b id="price">${buytrueordermoney}</b></span>
			</li>
		</ul>
		<div class="now_pay"><a href="">立即付款</a></div>
	</div>
</div>
<!--头部-->
<#include "/templates/footer.ftl">
</body>
<script src="https://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/usercenter/payment/js/payment.js"></script>
</html>