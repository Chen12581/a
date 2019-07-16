<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>用户充值</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/recharge.css">
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
                <li class="hover"><a href="/user/recharge">我要充值</a></li>
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
        <div class="content_tab">
            <ul>
                <li><a href="/user/capital">资金明细</a></li>
                <li class="on"><a href="/user/recharge">我要充值</a></li>
                <li><a href="/user/withdraw">我要提现</a></li>
                <li><a href="/user/bill">发票索取</a></li>
                <li><a href="/user/bank">绑定银行卡</a></li>
            </ul>
        </div>
        <div class="money_tab clear">
            <ul>
                <li class="on">我要充值</li>
            </ul>
            <p class="money_chat rt">
                <a href="" target="_blank">联系资金客服</a>
            </p>
        </div>
        <div class="recharge_tab">
            <ul>
                <li class="on">网银充值</li>
                <li>微信充值</li>
            </ul>
        </div>
        <div class="recharge_cont">
            <ul class="recharge_cont_ul">
                <li>
                    <div class="wy_recharge">
                        <p class="recharge_ts">
                            请选择合适您的银行充值
                            <span class="red">温馨提示：请不要多次重复提交相同金额充值</span>
                        </p>
                        <div class="recharge_bank clear">
                            <ul class="recharge_bank_ul">
                                <li class="on">
                                    <img src="/usercenter/image/bank_logo1.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo2.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo3.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo4.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo5.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo6.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo7.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo8.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo9.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo10.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo11.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo12.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo13.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo14.jpg" alt="">
                                </li>
                                <li>
                                    <img src="/usercenter/image/bank_logo15.jpg" alt="">
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="operation">
                        <ul>
                            <li>
                                <p class="p1">
                                    您正在为账户：
                                    <span>dingxiaosong</span>
                                    进行充值
                                </p>
                            </li>
                            <li>
                                <p class="p2">
                                    <input type="text" placeholder="请填写您充值的金额" onkeyup="value=value.replace(/[^\d]/g,'')">
                                </p>
                            </li>
                            <li>
                                <p class="p3">
                                    <a href="">下一步</a>
                                </p>
                            </li>
                            <li>
                                <p class="p4">
                                    <span>温馨提示：</span>
                                    如在充值上遇到问题，可联系上方财务客服，客服会指导您充值！
                                </p>
                            </li>
                        </ul>
                    </div>
                </li>
                <li style="display: none">
                    <div class="wechat_recharge">
                        <p class="skf">
                            收款方：湖南通亮信息科技有限公司
                        </p>
                        <div class="operation" style="border: none;padding: 100px 0;">
                            <ul>
                                <li>
                                    <p class="p1">
                                        您正在为账户：
                                        <span>dingxiaosong</span>
                                        进行充值
                                    </p>
                                </li>
                                <li style="margin-top: 30px">
                                    <p class="p2">
                                        <input type="text" placeholder="请填写您充值的金额" onkeyup="value=value.replace(/[^\d]/g,'')">
                                    </p>
                                </li>
                                <li style="margin-top: 30px">
                                    <p class="p3">
                                        <a href="">下一步</a>
                                    </p>
                                </li>
                                <li style="margin-top: 30px">
                                    <p class="p4">
                                        <span>温馨提示：</span>
                                        如在充值上遇到问题，可联系上方财务客服，客服会指导您充值！
                                    </p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </li>
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
<script src="/usercenter/js/recharge.js"></script>
</html>