<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>修改手机号</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/mobile.css">
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
                <li><a href="/user/bank">绑定银行卡</a></li>
            </ul>
        </div>
        <div>
            <h4>安全设置</h4>
            <ul>
                <li><a href="/user/safety">实名认证</a></li>
                <li><a href="/user/password">修改密码</a></li>
                <li><a href="/user/email">绑定邮箱</a></li>
                <li  class="hover"><a href="/user/mobile">修改手机号</a></li>
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
        <div class="cont_title">
            <span class="tt">！</span>
            <span>您可以通过验证手机号进行相关安全操作</span>
        </div>
        <div class="cont_information">
            <div class="cont_tab">
                <ul>
                    <li class="on">验证手机号</li>
                    <!--<li>修改头像</li>-->
                </ul>
            </div>
            <!--修改手机号-->
            <div class="xg_mobile">
                <ul>
                    <!--验证手机号-->
                    <li>
                        <div class="xg_mobile_alr">
                            <div class="already lf">已验证手机：</div>
                            <div class="already_phone already lf" id="${wqtuser.mobileno?if_exists}">${wqtuser.mobileno?if_exists?substring(0,3)}.....${wqtuser.mobileno?if_exists?substring(8,11)}</div>
                        </div>
                        <div class="xg_mobile_alr">
                            <div class="already yzm rt already_yzm">
                                <a href="javascript:void(0);">免费获取校验码</a>
                            </div>
                        </div>
                        <div class="xg_mobile_alr" style="clear: both;margin-top: 55px">
                            <div class="already lf">手机校验码：</div>
                            <div class="already lf"><input type="text" class="inp_yzm sj_yzm"></div>
                        </div>
                        <div class="xg_mobile_alr" style="width: 300px;">
                            <input type="button" class="btn_inp_yzm" onclick="oldYzm()" value="提交" id="btn_inp_yzm">
                            <!--<input type="button" class="btn_inp_yzm qx_btn" value="取消" id="qx_btn_inp_yzm">-->
                        </div>
                    </li>
                    <!--验证新手机-->
                    <li style="display: none">
                        <div class="xg_mobile_alr">
                            <div class="already lf">输入新号码：</div>
                            <div class="already lf"><input type="text" class="inp_yzm new_phone"></div>
                        </div>
                        <div class="xg_mobile_alr">
                            <div class="already yzm rt verify_yzm">
                                <a href="javascript:void(0);">免费获取校验码</a>
                            </div>
                        </div>
                        <div class="xg_mobile_alr" style="clear: both;margin-top: 55px">
                            <div class="already lf">手机校验码：</div>
                            <div class="already lf"><input type="text" class="inp_yzm new_yzm"></div>
                        </div>
                        <div class="xg_mobile_alr" style="width: 300px;">
                            <input type="button" class="btn_inp_yzm" onclick="newYzm()" value="提交" id="btn_yzm">
                            <!--<input type="button" class="btn_inp_yzm qx_btn" value="取消" id="qx_btn_yzm">-->
                        </div>
                    </li>
                    <!--完成-->
                    <li style="display: none">
                        <p class="fin"><span>恭喜您：手机号修改成功，135****5151可作为账号用于登录</sapn></p>
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
<script src="/usercenter/js/mobile.js"></script>
</html>