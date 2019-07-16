<div class="header">
        <div class="top">
            <div class="top_box clear">
                 <#if wqtuser?exists>
                 <div class="top_left">
                    <p class="welcome">${wqtuser.username?if_exists},欢迎来到万企通企业服务平台！</p>
                    <p class="entry">
                        <a href="/user/center" class="login_entry" target="_blank">个人中心</a>
                        <a href="javascript:;" id="logout" class="register_entry">退出</a>
                    </p>
                </div>
                <#else>
                <div class="top_left">
                    <p class="welcome">欢迎来到万企通企业服务平台！</p>
                    <p class="entry">
                        <a href="http://www.w7tong.com/user/login.html?service=" id="login">请登录</a>
                        <a href="http://www.w7tong.com/user/register.html?service=" id="register" class="register_entry">免费注册</a>
                    </p>
                </div>
                </#if>
                <div class="top_right">
                    <ul class="top_menu">
                        <li><a href="http://www.w7tong.com" target="_blank">万企通首页</a></li>
                        <li><a href="http://www.w7tong.com/helpcenter/about.html" target="_blank">关于我</a></li>
                        <li><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target="_blank" >在线客服</a></li>
                        <li><a href="http://www.w7tong.com/user/helpcenter.html" target="_blank">帮助中心</a></li>
                    </ul>
                    <div class="hot_tel">热线：<span>400-611-8288</span></div>
                </div>
            </div>
        </div>
        <div class="bottom">
            <div class="bottom_box clear">
                <div class="logo"><a href="" target="_blank"><img src="/templates/image/header/logo.png" alt=""></a></div>
                <div class="nav">
                    <ul>
                        <li class="on"><a href="http://www.w7tong.com"  target="_blank">首页</a></li>
                        <li><a href="http://ipr.w7tong.com/iprtrade"  target="_blank">交易市场</a></li>
                        <li><a href="http://ipr.w7tong.com/shop/brandshop.html"  target="_blank">商标转让</a></li>
                        <li><a href="http://wd.w7tong.com/tmall.html" class="">天猫转让</a></li>
                        <li class="centerl"><a href="http://es.w7tong.com/trade/company---------------------1.html"  target="_blank">企业转让</a></li>
                        <li class="qyfw">
                            <a href="http://es.w7tong.com" target="_blank">企业服务</a>
                            <div class="qyfw_drop">
                                <p><a href="http://es.w7tong.com/csfw/dljz1.html" target="_blank">财税服务</a></p>
                                <p><a href="http://es.w7tong.com/gsfw/gsbg1.html" target="_blank">工商服务</a></p>
                            </div>
                        </li>
                        <li class="zscq">
                            <a href="http://ipr.w7tong.com" target="_blank">知识产权</a>
                            <div class="zscq_drop">
                                <p><a href="http://ipr.w7tong.com/brand/ptzc.html" target="_blank">商标注册</a></p>
                                <p><a href="http://ipr.w7tong.com/patent/fmsq.html"target="_blank">专利申请</a></p>
                                <p><a href="http://ipr.w7tong.com/copyright/bqjj.html" target="_blank">版权登记</a></p>
                                <p><a href="http://ipr.w7tong.com/" target="_blank">商标设计</a></p>
                            </div>
                        </li>
                        <li class="wdfw">
                            <a href="http://wd.w7tong.com/" target="_blank">网店服务</a>
                            <div class="wdfw_drop">
                                <p><a href="http://wd.w7tong.com/agent.html" target="_blank">商城代入驻</a></p>
                                <p><a href="http://wd.w7tong.com/tmall.html" target="_blank">天猫转让</a></p>
                                <p><a href="http://wd.w7tong.com/sell.html" target="_blank">天猫出售</a></p>
                                <p><a href="http://wd.w7tong.com/tmall.html" target="_blank">购买天猫</a></p>
                            </div>
                        </li>
                        <li class="hlfw">
                            <a href="" class="develop">互联服务</a>
                            <div class="hlfw_drop">
                                <p><a href="" class="develop">网站建设</a></p>
                                <p><a href="" class="develop">定制APP</a></p>
                                <p><a href="" class="develop">微信开发</a></p>
                                <p><a href="" class="develop">小程序开发</a></p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>