<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>寄送地址</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/postAdd.css">
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

<!--内容区域-->
<div class="content">
    <div class="content_lf">
            <div>
                <h4>个人资料</h4>
                <ul>
                    <li><a href="/user/personalinfo">基本资料</a></li>
                    <li class="hover"><a href="/user/postaddr">寄送地址</a></li>
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
        <div class="theme_txt">
            <h3>收件地址</h3>
            <a class="addBtn" href="javascript:void(0)">新增收件地址</a>
        </div>

        <div class="adds_list">
            <ul>
                <li class="operate01">联系人名称</li>
                <li class="operate01">联系电话</li>
                <li class="operate01">联系地址</li>
                <li class="operate02">操作</li>
            </ul>
            <table>
                <tr class="default">
                    <td>牛女士</td>
                    <td>18453612365</td>
                    <td><span>江苏省南京市鼓楼区新模范马路南京工业大学</span></td>
                    <td><a href="javascript:void(0)">修改</a><a href="javascript:void(0)">删除</a></td>
                    <td><i></i><a href="javascript:void(0)">默认地址</a></td>
                </tr>
                <tr>
                    <td>牛女士</td>
                    <td>18453612365</td>
                    <td><span>江苏省南京市鼓楼区新模范马路南京工业大学</span></td>
                    <td><a href="javascript:void(0)">修改</a><a href="javascript:void(0)">删除</a></td>
                    <td><i></i><a href="javascript:void(0)">默认地址</a></td>
                </tr>
            </table>
        </div>
    </div>
</div>

<div class="addBox" style="display: none">
    <div class="add">

    </div>
</div>






<!--底部-->
<#include "/templates/footer.ftl">

<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/usercenter/js/address.js"></script>
</body>
</html>