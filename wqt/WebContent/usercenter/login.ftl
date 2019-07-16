<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>万企通-登录</title>
    <link rel="shortcut icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/usercenter/css/login.css">
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
<div class="header">
    <div class="top">
        <div class="center">
            <div class="top_right rt">
                <ul class="lf">
                    <li><a href="http://www.w7tong.com">万企通首页</a></li>
                    <li><a href="http://www.w7tong.com/helpcenter/aboutus.html">关于我</a></li>
                    <li><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes">关注万企通</a></li>
                    <li><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes">在线客服</a></li>
                    <li><a href="http://www.w7tong.com/user/helpcenter.html">帮助中心</a></li>
                </ul>
                <p class="hot_tel">热线：<span>400-611-8288</span></p>
            </div>
        </div>
    </div>
    <div class="header_bottom">
        <div class="center" style="position: relative;">
            <div class="logo lf">
                <a href="http://www.w7tong.com">
                    <img src="/usercenter/image/login/logo.png" alt="万企通-LOGO">
                </a>
            </div>
            <div class="wqt rt">
                <a href="http://www.w7tong.com"><i></i>万企通首页</a>
            </div>
        </div>
    </div>
</div>
<div class="banner">
    <div class="box">
        <div class="rt login_form">
            <div class="login_tit">
                <span class="on">账号密码登录</span>
                <span>验证码登录</span>
            </div>
             <div class="fonm_cont zh_lg">
                    <p class="form_phone">
                        <input type="text" placeholder="请输入手机号/邮箱/用户名" class="zh_phone">
                        <span class="error01"></span>
                    </p>
                    <p class="form_passworld">
                        <input type="password" placeholder="请输入登录密码" class="zh_passworld">
                        <span class="error02"></span>
                    </p>
                    <p class="form_yzm yyz">
                        <input type="text" placeholder="请输入验证码" class="zh_yzm">
                        <span class="error03"></span>
                        <a href="javascript:;" class="getCode">
                            <img src="/jsp/validatecode.jsp" class="verify_picture" alt="验证码" width="100%" height="100%">
                        </a>
                    </p>
                    <p class="lj">
                        <a href="/user/fpassword.html">忘记密码</a>
                        /
                        <a href="/user/register.html" style="color: red;" class='regg'>免费注册</a>
                    </p>
                    <p class="form_logn">
                        <input type="button" value="登录" id="zh_login">
                    </p>
                    <div class="other_login">
                        <p class="other_login_title">第三方直接登录</p>
                        <div class="login-list">
                            <a href="${qqloginurl?if_exists}" class="login_qq"></a>
                            <a href="https://open.weixin.qq.com/connect/qrconnect?appid=wx8f6411f0b3eec831&redirect_uri=http%3a%2f%2fwww.w7tong.com%2fwxAuthredirect&response_type=code&scope=snsapi_login" class="login_wx"></a>
                            <a href="https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=2018110161935942&scope=auth_user&redirect_uri=http%3a%2f%2fwww.w7tong.com%2fauthredirect" class="login_zfb"></a>
                        </div>
                    </div>
             </div>
             <div class="fonm_cont yzm_lg"  style="display: none">
                <p class="form_phone">
                    <input type="text" placeholder="请输入手机号" class="yz_phone">
                    <span class="error04"></span>
                </p>
                <p class="form_yzm yyz">
                    <input type="text" placeholder="请输入图形码" class="yz_txm">
                    <a href="javascript:;" class="getCode">
                        <img src="/jsp/validatecode.jsp" class="verify_picture_n" alt="验证码" width="100%" height="100%">
                    </a>
                    <span class="error05"></span>
                </p>
                <p class="form_dt yyz">
                    <input type="text" placeholder="请输入验证码" class="yz_yzm">
                    <a href="javascript:;" class="ddd">发送动态密码</a>
                    <span class="error06"></span>
                </p>
                <p class="lj">
                    <a href="/user/fpassword.html">忘记密码</a>
                    /
                    <a href="/user/register.html" style="color: red;" class='regg'>免费注册</a>
                </p>
                <p class="form_logn">
                    <input type="button" value="登录" id="yz_login">
                </p>
                <div class="other_login">
                    <p class="other_login_title">第三方直接登录</p>
                    <div class="login-list">
                        <a href="${qqloginurl?if_exists}" class="login_qq"></a>
                        <a href="https://open.weixin.qq.com/connect/qrconnect?appid=wx8f6411f0b3eec831&redirect_uri=http%3a%2f%2fwww.w7tong.com%2fwxAuthredirect&response_type=code&scope=snsapi_login" class="login_wx"></a>
                        <a href="https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=2018110161935942&scope=auth_user&redirect_uri=http%3a%2f%2fwww.w7tong.com%2fauthredirect" class="login_zfb"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <p>
        Copyright © 2018 湖南万企通全企业管理有限公司 版权所有 湘ICP备18017033号 w7tong.com
    </p>
</div>
</body>
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/jquery.md5.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/usercenter/js/login.js"></script>
</html>