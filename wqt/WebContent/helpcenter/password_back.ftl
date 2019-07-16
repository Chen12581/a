<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=0.25">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/css/animate.min.css">
    <link rel="stylesheet" href="/helpcenter/css/password_back.css">
    <title>找回密码_万企通</title>
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
<body style="background: #f6f6f6;">

    <div class="password">
        <div class="pas_box">
            <div class="position">
                <a href="http://www.w7tong.com">首页</a>&gt;<span>找回密码</span>
            </div>
            <div class="content">
                <div class="get_procedure">
                    <ul class="clear">
                        <li class="on"><i>1</i>身份验证</li>
                        <li><i>2</i>重置密码</li>
                        <li><i>3</i>重置完成</li>
                    </ul>
                </div>
                <div class="procedure_detail">
                    <div class="identity" >
                        <form>
                            <div class="form_mobile form_item">
                                <label for="phone">手机号码</label>
                                <div class="input-control">
                                    <input id="phone" type="text" placeholder="请输入手机号码" maxlength="11">
                                    <i class="input-control-clear"></i>
                                </div>
                            </div>
                            <div class="perror"></div>
                            <div class="form_idencode form_item">
                                <label for="mathCode">验证码</label>
                                <div class="input-control">
                                    <input id="mathCode" type="text" placeholder="请输入验证码" maxlength="6" >
                                    <i class="input-control--clear"></i>
                                </div>
                                <a href="javascript:;" class="getCode">
                                    <img src="/jsp/validatecode.jsp" alt="验证码" id="verify_picture" width="100%" height="100%">
                                </a>
                            </div>
                            <div class="form_code form_item">
                                <label for="phoneCode">手机验证码</label>
                                <div class="input-control">
                                    <input id="phoneCode" type="text" placeholder="请输入验证码" maxlength="6" >
                                    <i class="input-control--clear"></i>
                                </div>
                                <button type="button" id="verifyCode" class="btn fr" onclick="getCode()">获取验证码</button>
                            </div>
                            <button type="button" id="firstSubmit" class="form_submit">下一步</button>
                        </form>
                    </div>
                    <div class="newPass" style="display: none">
                        <form id="newpassword">
                            <div class="newpass_txt"><i class="newpass_txt_icon"></i>验证已通过，您可以设置新的密码！</div>
                            <ul>
                                <li>
                                    <label for="npassword" class="npassword_label">新密码：</label>
                                    <input type="password" class="inp inp01" placeholder="6-12个字符" maxlength="12" name="pass" id="pass">
                                    <div class="error"></div>
                                </li>
                                <li>
                                    <label for="qpassword" class="npassword_label">确认密码：</label>
                                    <input type="password" class="inp inp01" placeholder="请再次输入密码" maxlength="12" name="qpass" id="qpass">
                                    <div class="error"></div>
                                </li>
                                <li>
                                    <button type="button" id="secondSubmit" class="form_submit">下一步</button>
                                </li>
                            </ul>
                        </form>
                    </button>
                    <div class="reset_success" style="display: none">
                        <div class="success_box clear">
                            <div class="img"><img src="/helpcenter/images/timg.jpg" alt="重置成功"></div>
                            <div class="success_title">恭喜！您的账号密码已经重置成功，页面将在<span class="secs" style="margin: 6px ">1</span>秒后跳向帮助中心</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--  弹窗  -->
    <div class="cover"></div>
    <!-- 提示 -->
    <div class="hint1 animated zoomIn">
        <div class="hint_cpntent">提示</div>
    </div>
    <script src="https://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
    <script src="/common/commonurl.js"></script>
    <script src="/helpcenter/js/password_back.js"></script>
</body>
</html>