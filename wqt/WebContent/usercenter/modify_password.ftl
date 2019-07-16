<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/password_back.css">
    <link rel="stylesheet" href="/templates/css/footer.css">
    <title>修改登录密码-万企通</title>
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
<!--header-->
<#include "/templates/wqt_header.ftl">
<div class='content'>
	<div class='content_lf'>
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
				<li class='hover'><a href="/user/password">修改密码</a></li>
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
    <div class="password">
        <div class="pas_box">
            <div class="position" style="border-bottom: 1px solid #eeeeee;">
                <p>修改登录密码</p>
            </div>
            <div class="contentt">
                <div class="get_procedure">
                    <ul class="clear">
                        <li class="on"><i>1</i>身份验证</li>
                        <li><i>2</i>修改密码</li>
                        <li><i>3</i>修改完成</li>
                    </ul>
                </div>
                <div class="procedure_detail">
                    <div class="identity pp" >
                        <form>
                            <div class="form_mobile" style="margin: 25px 0;">
                                <div class="yzmobile" id="${wqtuser.mobileno?if_exists}"><span class="form_tit">已验证手机：</span>${wqtuser.mobileno?if_exists?substring(0,3)}.....${wqtuser.mobileno?if_exists?substring(8,11)}</div>
                            </div>
                            <div class="perror"></div>
                            <input style="display:none;">
                            <div class="form_code form_item">
                                <label for="phoneCode">验证码</label>
                                <div class="input-control">
                                    <input id="phoneCode" type="text" placeholder="请输入验证码" maxlength="6" oninput="value=value.replace(/[^\d]/g,'')">
                                    <i class="input-control--clear"></i>
                                </div>
                                <button id="verifyCode" type='button' class="fr">获取验证码</button>
                            </div>
                            <input type="button" class="btn_sub fl" value="提交" id="aphone">
                        </form>
                    </div>
                    <div class="newPass pp" style="display: none">
                        <form id="newpassword">
                            <div class="newpass_txt"><i class="newpass_txt_icon"></i>验证已通过，您可以设置新的密码！</div>
                            <ul>
                                <li>
                                    <label for="npassword" class="npassword_label">新密码：</label>
                                    <input type="password" class="inp inp01" placeholder="请输入新密码" name="pass" id="pass">
                                    <div class="error error01"></div>
                                </li>
                                <li>
                                    <label for="qpassword" class="npassword_label">确认密码：</label>
                                    <input type="password" class="inp inp01" placeholder="请再此输入密码" name="qpass" id="qpass">
                                    <div class="error error02"></div>
                                </li>
                                <li>
                                    <input type="button" class="btn_sub fl" value="确定" id="setpassword" onclick='update()'>
                                </li>
                            </ul>
                        </form>
                    </div>
                    <div class="reset_success pp" style="display: none">
                        <div class="success_box clear">
                            <div class="img"><img src="/usercenter/image/ok.png" alt="重置成功"></div>
                            <div class="success_title">恭喜！您的账号密码已经修改成功，页面将在<span class="secs" style="margin: 6px ">3</span>秒后跳向登录页面</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--header-->
<#include "/templates/footer.ftl">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/layui/layui.js"></script>
<script src="/usercenter/js/password_back.js"></script>
</body>
</html>