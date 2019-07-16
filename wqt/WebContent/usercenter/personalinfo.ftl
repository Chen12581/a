<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>个人资料</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
	<link rel="stylesheet" href="/layui/css/layui.css">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/personalinfo.css">
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
                <li class="hover"><a href="/user/personalinfo">基本资料</a></li>
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
        <div class="cont_title">
            <span class="tt">！</span>
            <span>完善资料有助于万企通进一步了解您，给您更为合适的推荐</span>
        </div>
        <div class="cont_information">
            <div class="cont_tab">
                <ul>
                    <li class="on">基本信息</li>
                    <!--<li>修改头像</li>-->
                </ul>
            </div>
            <!--基本信息-->
            <div class="basic_information inf">
                <div class="information_mm">
                    <div class="information_mm_al lf">用户名：</div>
                    <div class="information_mm_ar lf">
                       <#if wqtuser.username?exists>
	                       ${wqtuser.username}
	                    <#else>
	                                                                                    未填写
	                    </#if>
	                </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_al lf">昵称：</div>
                    <div class="information_mm_ar lf">
                        <#if wqtuser.nickname?exists>
	                       ${wqtuser.nickname}
	                    <#else>
	                                                                                    未填写
	                    </#if>
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_al lf">性别：</div>
                    <div class="information_mm_ar lf">
                       <#if wqtuser.sex?exists>
	                       <#if wqtuser.sex?string=='1'>
	                                                                                         男
	                       <#else>
	                                                                                   女 
	                       </#if>
	                    <#else>
	                                                                                    未设置
	                    </#if>
                   </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_al lf">出生日期：</div>
                    <div class="information_mm_ar lf">
                        <#if wqtuser.birthday?exists>
	                       ${wqtuser.birthday?date}
	                    <#else>
	                                                                                   未设置
	                    </#if>
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_al lf">手机号：</div>
                    <div class="information_mm_ar lf">
                        <span class="mobile_pho">${wqtuser.mobileno?if_exists?substring(0,3)}.....${wqtuser.mobileno?if_exists?substring(8,11)}</span>
                        <a href="/user/mobile" class="alder">修改</a>
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_al lf">邮箱：</div>
                    <div class="information_mm_ar lf">
                    <#if wqtuser.email?exists>
                       ${wqtuser.email?if_exists}
                    <#else>
                                                                                    未填写
                    </#if>
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_al lf">QQ：</div>
                    <div class="information_mm_ar lf">
                       <#if wqtuser.qq?exists>
                          ${wqtuser.qq}
	                    <#else>
	                                                                                    未填写
	                    </#if>
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_al lf">微信号：</div>
                    <div class="information_mm_ar lf">
                       <#if wqtuser.weixin?exists>
                          ${wqtuser.weixin}
	                    <#else>
	                                                                                    未填写
	                    </#if>
                    </div>
                </div>
                <div class="information_mm">
                    <input type="button" class="bj" value="编辑">
                </div>
            </div>
            <!--编辑信息-->
            <div class="bj_information inf" style="display: none;">
                <div class="information_mm">
                    <div class="information_mm_bl lf">用户名：</div>
                    <div class="information_mm_br lf">
                        <input type="text" class="information_mm_br_input" id="username" placeholder="请输入用户名（6-16位字符），可用于登录" value="${wqtuser.username?if_exists}">
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_bl lf">昵称：</div>
                    <div class="information_mm_br lf">
                        <input type="text" class="information_mm_br_input nc_name" placeholder="请输入真实姓名" value="${wqtuser.nickname?if_exists}">
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_bl lf">性别：</div>
                    <div class="information_mm_br lf">
                        <#if wqtuser.sex?exists>
	                       <#if wqtuser.sex?string=='1'>
	                            <input type="radio" id="man" value="1" checked name="gender" class="man">
		                        <label for="man">男</label>
		                        <input type="radio" id="woman" value="2" name="gender" >
		                        <label for="woman">女</label>
	                       <#else>
	                            <input type="radio" id="man" value="1" name="gender">
		                        <label for="man">男</label>
		                        <input type="radio" id="woman" checked value="2" name="gender"  class="woman">
		                        <label for="woman">女</label>
	                       </#if>
	                    <#else>
	                            <input type="radio" id="man" value="1" name="gender" class="man">
		                        <label for="man">男</label>
		                        <input type="radio" id="woman" value="2" name="gender" >
		                        <label for="woman">女</label>
	                    </#if>
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_bl lf">出生日期：</div>
                    <div class="information_mm_br lf">
                        <input type="text" class="information_mm_br_input" placeholder="请选择"  readonly="readonly" value="${wqtuser.birthday?if_exists}" name="inp_date">
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_bl lf">手机号：</div>
                    <div class="information_mm_br lf">
                        <span class="mobile_pho">${wqtuser.mobileno?if_exists?substring(0,3)}.....${wqtuser.mobileno?if_exists?substring(8,11)}</span>
                        <a href="/user/mobile" class="alder">修改</a>
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_bl lf">邮箱：</div>
                    <div class="information_mm_br lf">
                        <input type="text" class="information_mm_br_input inp_email" placeholder="邮箱认证轻松找回密码" value="${wqtuser.email?if_exists}">
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_bl lf">QQ：</div>
                    <div class="information_mm_br lf">
                        <input type="text" class="information_mm_br_input inp_qq" placeholder="请输入您的QQ号" value="${wqtuser.qq?if_exists}" onkeyup="value=value.replace(/[^\d]/g,'')">
                    </div>
                </div>
                <div class="information_mm">
                    <div class="information_mm_bl lf">微信号：</div>
                    <div class="information_mm_br lf">
                        <input type="text" class="information_mm_br_input wechat" placeholder="请输入您的微信号" value="${wqtuser.weixin?if_exists}">
                    </div>
                </div>
                <!--<div class="information_mm">-->
                    <!--<div class="information_mm_bl lf">验证码：</div>-->
                    <!--<div class="information_mm_brr lf">-->
                        <!--<input type="text" class="information_mm_br_input1" placeholder="请输入验证码" value="">-->
                    <!--</div>-->
                    <!--<div class="information_mm_bc">-->
                        <!--<img src="/jsp/validatecode.jsp" id="verify_picture" alt="验证码">-->
                    <!--</div>-->
                <!--</div>-->
                <div class="information_mm">
                    <input type="button" class="bc" id="bc_info" value="保存">
                    <input type="button" class="qx" id="qx_info" value="取消">
                </div>
            </div>
            <!--修改手机号-->
            <div class="xg_mobile" style="display: none;">
                <ul>
                    <!--验证手机号-->
                    <li>
                        <div class="xg_mobile_alr">
                            <div class="already lf">已验证手机：</div>
                            <div class="already_phone already lf">${wqtuser.mobileno?if_exists?substring(0,3)}.....${wqtuser.mobileno?if_exists?substring(8,11)}</div>
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
                            <input type="button" class="btn_inp_yzm qx_btn" value="取消" id="qx_btn_inp_yzm">
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
                            <input type="button" class="btn_inp_yzm qx_btn" value="取消" id="qx_btn_yzm">
                         </div>
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
<script src="/usercenter/js/personalinfo.js"></script>
</html>