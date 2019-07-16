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
</div>