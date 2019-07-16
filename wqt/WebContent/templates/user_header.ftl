<div class="header">
        <div class="top">
            <div class="center">
                <#if wqtuser?exists>
				<div class="top_left lf">
					<p class="welcome">${wqtuser.username?if_exists}，欢迎来到万企通企业服务平台！</p>
					<div class="member_entry">
						<a href="http://www.w7tong.com/user/center" class="login_entry">个人中心</a>
						<a href="javascript:;" class="register_entry" id="logout">退出</a>
					</div>
				</div>
				<#else>
				<div class="top_left lf">
					<p class="welcome">欢迎来到万企通企业服务平台！</p>
					<div class="member_entry">
						<a href="javascript:;" class="login_entry" id="login_entry">登录</a>
						<a href="javascript:;" class="register_entry">免费注册</a>
					</div>
				</div>
				</#if>
                <div class="top_right rt">
                    <ul class="lf">
                        <li><a href="http://www.w7tong.com">万企通首页</a></li>
                        <li><a href="http://www.w7tong.com/helpcenter/about.html">关于我</a></li>
                        <li><a href="tencent://message/?uin=${wqtworker.qq?if_exists}&amp;Site=&amp;menu=yes" target='_blank'>在线客服</a></li>
                        <li><a href="http://www.w7tong.com/user/helpcenter.html">帮助中心</a></li>
                    </ul>
                    <p class="hot_tel">热线：<span>400-611-8288</span></p>
                </div>
            </div>
        </div>
        <div class="wrap_bottom">
            <div class="center">
				<div class="lf logo">
					<a href='http://www.w7tong.com'>
						<img src="/templates/image/header/logo.png" alt="万企通商标转让平台" width="225" height="64">
					</a>
				</div>
                <ul class="rt">
                    <li>
                      <#if ipruser?exists>
                         <a href="http://www.w7tong.com">首页</a>
                      <#else>
                          <a href="http://www.w7tong.com">首页</a>
                      </#if>
                    </li>
                    <li>
                        <a href="http://ipr.w7tong.com/brandseek.html">商标服务</a>
                    </li>
                    <li>
                        <a href="http://ipr.w7tong.com/copyrightseek.html">版权服务</a>
                    </li>
                    <li>
                        <a href="http://ipr.w7tong.com/patentseek.html">专利服务</a>
                    </li>
                    <li>
                        <a href="http://ipr.w7tong.com/news/news.html">资讯</a>
                    </li>
                    <li>
                        <a href="http://ipr.w7tong.com/iprtrade" target="_blank">知识产权交易
                            <i></i>
                        </a>
                        <div class="head_pull">
                            <div class="pull_sort">
                                <a href="http://ipr.w7tong.com/shop/brandshop.html" target="_blank">商标转让</a>
                            </div>
                            <div class="pull_sort">
                                <a href="http://ipr.w7tong.com/patentmark/patent.html" target="_blank">专利转让</a>
                            </div>
                            <div class="pull_sort">
                                <a href="http://ipr.w7tong.com/copyrightmark/copyright.html" target="_blank">版权交易</a>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>