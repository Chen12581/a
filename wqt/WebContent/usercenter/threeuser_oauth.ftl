<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>第三方登录-万企通企业一站式服务平台欢迎您</title>
    <link rel="shortcut icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/usercenter/css/oauth_index.css">
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
                    <img src="/templates/image/header/logo.png" alt="万企通-LOGO">
                </a>
            </div>
            <div class="wqt rt">
                <a href="http://www.w7tong.com"><i></i>万企通首页</a>
            </div>
        </div>
    </div>
</div>
<div class="banner">
    当前位置：<a href="http://www.w7tong.com">首页</a>
    >
    <a href="javascript:;">登录</a>
    >
    <a href="javscript:;">第三方登录</a>
</div>
<div class="center nent">
    <h2 class="center_tit">关联账号</h2>
    <div class="inp">
        <p class="p1">
            <label>手机号码</label>
            <input type="text" class="phone" placeholder="请输入手机号码">
            <span style='color:red;' class='error01'></span>
        </p>
        <p class="p1 p2">
            <label>图形码</label>
            <input type="text" class="txm" placeholder="请输入图形码">
            <a href="javascript:;" class="getCode">
                <img src="/jsp/validatecode.jsp" class="verify_picture_n" alt="验证码" width="100%" height="100%">
            </a>
            <span style='color:red;' class='error02'></span>
        </p>
        <p class="p1 p2">
            <label>验证码</label>
            <input type="text" class="yzm" placeholder="请输入验证码">
            <a href="javascript:;" class="yyy">获取验证码</a>
            <span style='color:red;' class='error03'></span>
        </p>
        <button class="p3">提交</button>
    </div>
</div>
<div class="footer">
    <p>
        Copyright © 2018 湖南万企通全企业管理有限公司 版权所有 湘ICP备18017033号 w7tong.com
    </p>
</div>
</body>
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/usercenter/js/oauth_index.js"></script>
</html>