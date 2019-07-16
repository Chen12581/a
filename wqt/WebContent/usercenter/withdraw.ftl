<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>用户提现</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/user_header.css">
    <link rel="stylesheet" href="/usercenter/css/withdraw.css">
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
<#include "/templates/user_header.ftl">
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
                <li class="hover"><a href="/user/withdraw">我要提现</a></li>
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
        <div class="content_tab">
            <ul>
                <li><a href="/user/capital">资金明细</a></li>
                <li><a href="/user/recharge">我要充值</a></li>
                <li class="on"><a href="/user/withdraw">我要提现</a></li>
                <li><a href="/user/bill">发票索取</a></li>
                <li><a href="/user/bank">绑定银行卡</a></li>
            </ul>
        </div>
        <div class="money_tab clear">
            <ul>
                <li class="on">我要提现</li>
            </ul>
            <p class="money_chat rt">
                <a href="" target="_blank">联系资金客服</a>
            </p>
        </div>
        <div class="recharge_tab">
            <ul>
                <li class="on">提现到银行卡</li>
            </ul>
            <p class="balance">
                账户余额：
                <span>¥0.00</span>
                元
            </p>
        </div>
        <div class="withdrow_cont">
            <div class="withdrow_a">
                <ul class="clear">
                    <li>
                        <div class="withdrow_lf">
                            <label>提现账户：</label>
                        </div>
                        <div class="withdrow_rt">
                            <select>
                                <option value="">请选择</option>
                                <option value="">工商银行</option>
                                <option value="">农业银行</option>
                                <option value="">交通银行</option>
                            </select>
                        </div>
                    </li>
                    <li>
                        <div class="withdrow_lf">
                            <label>提现金额：</label>
                        </div>
                        <div class="withdrow_rt">
                            <input type="text" class="withdrow_inp" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入提现金额">&nbsp&nbsp元
                        </div>
                    </li>
                    <li>
                        <div class="withdrow_lf">
                            <label>绑定手机：</label>
                        </div>
                        <div class="withdrow_rt">
                            <span class="withdrow_mobile">188****8888</span>
                            <a href="javascript:void(0)" class="jym">免费获取校验码</a>
                        </div>
                    </li>
                    <li>
                        <div class="withdrow_lf">
                            <label>输入校验码：</label>
                        </div>
                        <div class="withdrow_rt">
                            <input type="text" class="withdrow_inp" placeholder="请输入手机检验码">
                        </div>
                    </li>
                    <li>
                        <div class="withdrow_lf" style="color: green;font-size: 14px">
                            <label>提示：</label>
                        </div>
                        <div class="withdrow_rt" style="color: green;font-size: 14px">
                            如果您没有设置过支付密码，那么支付密码就是您的登录密码!
                        </div>
                    </li>
                    <li>
                        <div class="withdrow_lf">
                            <label>支付密码：</label>
                        </div>
                        <div class="withdrow_rt">
                            <input type="text" class="withdrow_inp" placeholder="请输入支付密码">
                        </div>
                    </li>
                    <li>
                        <a href="javascript:void(0)" class="sqtx">申请提现</a>
                    </li>
                    <li>
                        <p class="wxts">温馨提示：申请提现通过财务工作人员的初审和复审后，3个工作日内到账！超过3个工作日仍未到账咨询客服</p>
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
<script src="/common/commonurl.js"></script>
<script src="/js/withdraw.js"></script>
</html>