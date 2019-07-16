<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
    <title>用户中心</title>
    <link rel="stylesheet" href="/wqt/usercenter/css/userCenter.css">
    <script src="/wqt/js/jquery-1.11.1.min.js"></script>
</head>
<body>
<!-----------------------------------头部--------------------->
<div class="header">
    <div class="header_top">
        <div>
            <div class="header_left">
                <ul>
                    <li class="home"><a href="">首页</a></li>
                    <li><a href="">商标查询</a></li>
                    <li><a href="">版权登记</a></li>
                    <li><a href="">专利申请</a></li>
                    <li><a href="">免费找标</a></li>
                    <li><a href="">商标分类表</a></li>
                    <li>|</li>
                    <li><a href="">知讯</a></li>
                    <li><a href="">资讯区</a></li>
                    <li class="tools">
                        <a href="">常用工具</a>
                        <div style="display: none">
                            <a href="">
                                <img src="../image/schedule.png" alt="">
                                <p>商标进度查询</p>
                            </a>
                            <a href="">
                                <img src="../image/query.png" alt="">
                                <p>专利查询</p>
                            </a>
                            <a href="">
                                <img src="../image/calculate.png" alt="">
                                <p>专利年费计算</p>
                            </a>
                        </div>
                    </li>
                </ul>
            </div>

            <div class="header_right">
                <ul>
                    <li class="user"><a href="">登录</a><a href="">/注册</a></li>
                    <li><a href="">帮助中心</a></li>
                    <li><a href="">联系客服</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="header_bottom">
        <div class="header_logo">
            <a href="">
                <img src="../image/header_logo.png" alt="">
            </a>
        </div>
        <div class="header_nav">
            <a href="">首页${data.result}</a>
            <a href="">商标服务</a>
            <a href="">版权服务</a>
            <a href="">专利服务</a>
            <a href="">交易市场</a>
            <a href="">电商维权</a>
            <a href="">资讯区</a>
        </div>
    </div>
</div>

<!----------------------------------内容区域------------------>
<div class="content">
    <div class="content_lf">
        <div>
            <h4>个人资料</h4>
            <ul>
                <li class="hover"><a href="">基本资料</a></li>
            </ul>
        </div>
        <div>
            <h4>资金管理</h4>
            <ul>
                <li><a href="">资金明细</a></li>
                <li><a href="usercenter/invoice.html">索取发票</a></li>
            </ul>
        </div>
        <div>
            <h4>其他管理</h4>
            <ul>
                <li><a href="usercenter/record.html">交易记录</a></li>
                <li><a href="usercenter/security.html">安全设置</a></li>
                <li><a href="">我要求购</a></li>
                <li><a href="usercenter/question.html">我要提问</a></li>
                <li><a href="usercenter/answer.html">我的提问</a></li>
                <li><a href="">我要建议</a></li>
                <li><a href="">我的建议</a></li>
                <li><a href="">我的邮寄地址</a></li>
            </ul>
        </div>
    </div>


    <div class="content_rt">
        <div class="uName">
            <span>昵&nbsp;&nbsp;&nbsp;&nbsp;称：</span>
            <input type="text" placeholder="${data.user['nickname']}" value="${data.user['nickname']}">
        </div>
        <div class="phone">
            <span>手&nbsp;机&nbsp;号：</span>
            <p>${data.user['mobileno']}</p>
            <a href="">修改号码</a>
        </div>
        <div class="tName">
            <span>真实姓名：</span>
            <input type="text" placeholder="${data.user['username'] }" value="${data.user['username'] }">
        </div>
        <div class="six">
            <span>性&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
            <ul>
                <li>
                    <input type="radio" id="1" name="six" ${data.user['sex'] == 1 ? "checked":''}>
                    <label for="1">男</label>
                </li>
                <li>
                    <input type="radio" id="2" name="six" ${data.user['sex'] == 2 ? "checked":''}>
                    <label for="2">女</label>
                </li>
            </ul>
        </div>
        <div class="date_input">
            <span>出生日期：${data.user['birthday'] }</span>
            <input type="date" value="${data.user['birthday'] }" pattern="yyy/mm/dd">
        </div>
        <!-------------
        <div class="cName">
            <span>公司名称：</span>
            <input type="text" placeholder="-">
        </div>
        --------------->
        <div class="Email">
            <span>常用邮箱：</span>
            <input type="email" placeholder="${data.user['email'] }" value="${data.user['email'] }">
        </div>
        <!-- <div class="QQ">
            <span>QQ&nbsp;号&nbsp;码：</span>
            <input type="number" placeholder="-">
        </div> -->
        <!--------------
        <div class="address">
            <span>联系地址：</span>
            <div class="address_detail">
                <span>
                    <input id="province_1" type="text" placeholder="请选择省份" disabled="disabled">
                    <i></i>
                    <ul class="province_1">
                        <li>山西省</li>
                        <li>陕西省</li>
                        <li>云南省</li>
                        <li>福建省</li>
                        <li>浙江省</li>
                        <li>江苏省</li>
                        <li>湖南省</li>
                        <li>湖北省</li>
                        <li>广东省</li>
                    </ul>
                </span>
                <span>
                    <input id="province_2" type="text" placeholder="请选择城市" disabled="disabled">
                    <i></i>
                    <ul class="province_2">
                        <li>太原市</li>
                        <li>大同市</li>
                        <li>阳泉市</li>
                        <li>晋中市</li>
                        <li>临汾市</li>
                        <li>忻州市</li>
                        <li>长治市</li>
                    </ul>
                </span>
                <span>
                    <input type="text" placeholder="请选择区域" disabled="disabled">
                    <i></i>
                    <ul>
                        <li>小店区</li>
                        <li>榆次区</li>
                    </ul>
                </span>
            </div>
        </div>
        <div class="QQ">
            <span>详细地址：</span>
            <input type="text" placeholder="请填入详细的地址信息">
        </div>
        <div class="postcode">
            <span>邮&nbsp;&nbsp;&nbsp;&nbsp;编：</span>
            <input type="number" placeholder="-">
        </div>
        ------------->
        <div class="submit">
            <a onclick="editor()" href="javascript:void(0)" id="btn">保&nbsp;&nbsp;存</a>
        </div>
    </div>
</div>






<!-----------------------------------底部--------------------->
<div class="footer">
    <div class="footer_box">
        <div class="footer_top">
            <ul>
                <li>400-023-0033</li>
                <li>400-023-0033</li>
                <li>400-023-0033</li>
            </ul>
            <p>
                <span>周一至周五：9:00 - 20:00</span>
                <span>周六至周日：9:00 - 18:00</span>
            </p>
        </div>
        <div class="footer_bottom">
            <div class="footer_left">
                <ul class="footer_theme">
                    <li>
                        <p>知识产权保护</p>
                        <ul class="theme_detail">
                            <li><a href="">商标注册</a></li>
                            <li><a href="">版权登记</a></li>
                            <li><a href="">专利申请</a></li>
                            <li><a href="">商标交易</a></li>
                            <li><a href="">商标驳回复审</a></li>
                        </ul>
                    </li>

                    <li>
                        <p>免费工具</p>
                        <ul class="theme_detail">
                            <li><a href="">商标分类表</a></li>
                            <li><a href="">商标免费查询</a></li>
                            <li><a href="">商标进度查询</a></li>
                            <li><a href="">专利年费计算</a></li>
                            <li><a href="">免费找标</a></li>
                        </ul>
                    </li>

                    <li>
                        <p>资讯内容</p>
                        <ul class="theme_detail">
                            <li><a href="">知讯</a></li>
                            <li><a href="">资讯区</a></li>
                            <li><a href="">专题汇总</a></li>
                        </ul>
                    </li>

                    <li>
                        <p>商务合作</p>
                        <ul class="theme_detail">
                            <li><a href="">电话：023-88392970</a></li>
                            <li><a href="">邮箱：wangtingting@zbj.com</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="blogroll">
                    <ul>
                        <li><a href="">万企通</a></li>
                        <li><a href="">万企通</a></li>
                        <li><a href="">万企通</a></li>
                        <li><a href="">万企通</a></li>
                        <li><a href="">万企通</a></li>
                        <li><a href="">万企通</a></li>
                        <li><a href="">万企通</a></li>
                        <li><a href="">万企通</a></li>
                        <li><a href="">万企通</a></li>
                    </ul>
                </div>
                <div class="copyright">
                    <p>Copyright 2005-2017重庆猪八戒网络有限公司版权所有 渝ICP备10202274号-7 渝B2-20080005</p>
                </div>
            </div>
            <div class="footer_right">
                <div class="footer_right_top">
                    <div>
                        <img src="../image/erweima01.jpg" alt="">
                        <p>下单方便快捷资讯抢先了解</p>
                    </div>
                    <div>
                        <img src="../image/erweima02.jpg" alt="">
                        <p>商标查询工具流程全程监控</p>
                    </div>
                </div>
                <div class="footer_right_bottom">
                    <ul>
                        <li><a href=""></a></li>
                        <li><a href=""></a></li>
                        <li><a href=""></a></li>
                        <li><a href=""></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="/wqt/usercenter/js/userCenter.js"></script>
</body>
</html>