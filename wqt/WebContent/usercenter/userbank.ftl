<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>绑定银行卡</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/bank.css">
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
                <li><a href="/user/bill">索取发票</a></li>
                <li class="hover"><a href="/user/bank">绑定银行卡</a></li>
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
                <li><a href="/user/bill">发票索取</a></li>
                <li class="on"><a href="/user/bank">绑定银行卡</a></li>
            </ul>
        </div>
        <div class="money_tab clear">
            <ul>
                <li class="on">绑定银行卡</li>
            </ul>
            <p class="money_chat rt">
                <a href="" target="_blank">联系资金客服</a>
            </p>
        </div>
        <div class="bank_cont">
            <ul>
                <li class="bank_cont_title">
                    <span>开户银行</span>
                    <span>开户姓名</span>
                    <span>银行账号</span>
                    <span>操作</span>
                </li>
                <#if userBankData.l_WqtUserBank?exists>
	                <#list userBankData.l_WqtUserBank as wqtUserBank>
		                <li class="bank_cont_a" data-id=${wqtUserBank.id?if_exists} data-bankid=${wqtUserBank.bankid?if_exists}>
		                    <span> ${wqtUserBank.bankname?if_exists}</span>
		                    <span>${wqtUserBank.accountname?if_exists?substring(0,2)}**</span>
		                    <span>${wqtUserBank.accountno?if_exists}</span>
		                    <span>
		                       <#if wqtUserBank.state?string=='2'>
			                         <a href="javascript:;" class='unbind'>解除绑定</a></span>
			                    <#else>
			                         <a href="javascript:;" class='now_bind'>立即绑定</a></span>
			                    </#if>
		                </li>
		            </#list>
		        </#if>
            </ul>
            <p class="bank_bd">
                <a href="javascript:;" class="yhk">绑定银行卡</a>
            </p>
            <!--没数据显示-->
            <div class="ttab_data ">
                <div class="data_null">
                    <p>您现在还没有绑定银行卡哦</p>
                    <a href="javascript:;" class="yhk">立即绑定</a>
                </div>
            </div>
        </div>
        <div class="bank_info" style="display: none;">
            <div class="bank_info_cont">
                <ul class="clear">
                    <li>
                        <div class="bank_info_a lf">开户银行：</div>
                        <div class="bank_info_b sel_bank lf">
                            <select>

                            </select>
                        </div>
                    </li>
                    <li>
                        <div class="bank_info_a lf">开户地区：</div>
                        <div class="bank_info_b lf">
                            <select id="province" class="bank_city">

                            </select>
                            <select id="city" class="bank_city" style="margin-left: 15px">
                                <option value="">请选择市级</option>
                            </select>
                        </div>
                    </li>
                    <li>
                        <div class="bank_info_a lf">银行卡号：</div>
                        <div class="bank_info_b lf">
                            <input type="text" placeholder="请正确填写银行卡号" class='bank_number' onkeyup="value=value.replace(/[^\d]/g,'')">
                        </div>
                    </li>
                    <li>
                        <div class="bank_info_a lf">开户人姓名：</div>
                        <div class="bank_info_b lf">
                            <input type="text" placeholder="请正确填写开户人姓名" class='bank_name'>
                        </div>
                    </li>
                    <li>
                        <div class="bank_info_a lf">绑定手机：</div>
                        <div class="bank_info_b lf">
                            <input type="text" placeholder="请填写绑定银行卡号的手机号" class='bank_phone' onkeyup="value=value.replace(/[^\d]/g,'')">
                            <a href="javascript:;" class="jym">免费获取校验码</a>
                        </div>
                    </li>
                    <li>
                        <div class="bank_info_a lf">输入校验码：</div>
                        <div class="bank_info_b lf">
                            <input type="text" placeholder="请输入检验码" class='jym_num'>
                        </div>
                    </li>
                </ul>
            </div>
            <p class="bank_info_btn">
                <a href="javascript:;" class="bank_btn" id="bank_btn">立即绑定</a>
                <a href="javascript:;" class="bank_btn qx_btn" id="bank_qx_btn">取消</a>
                <span>（务必将信息填写完整，否则会影响提现操作！）</span>
            </p>
            <p class="pp">
                温馨提示：银行卡的开户名，必须与实名认证的名字一致，如绑定后更改会导致不能成功提现！
            </p>
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
<script src="/usercenter/js/bank.js"></script>
</html>