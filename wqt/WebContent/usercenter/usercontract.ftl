<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <title>合同主体</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/usercenter/css/bargain.css">
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

<!----------------------------------内容区域------------------>
<div class="content">
    <div class="content_lf">
                    <div>
                        <h4>个人资料</h4>
                        <ul>
                            <li><a href="/user/personalinfo">基本资料</a></li>
                            <li><a href="/user/postaddr">寄送地址</a></li>
                            <li class="hover"><a href="/user/contract">主体管理</a></li>
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
        <h4 style="margin-left:-20px;margin-top: -20px;">主体信息</h4>
        <div class="theme_tab">
            <a href="javascript:void(0)">合同/受让主体</a>
            <a href="javascript:void(0)" style="display:none;">知产注册主体</a>
            <i></i>
        </div>
        <div class="information">
            <div class="bargain">
                <div class="addBtn">
                    <a href="javascript:;">新增主体</a>
                </div>
                <ul class="bargain_list">
                    <li>
                        <p><span>主体类型：</span>个人</p>
                        <p><span>主体名称：</span>牛婷婷</p>
                        <p><span>身份证号码：</span>15641214364511442</p>
                        <p><span>联系人：</span>牛婷婷</p>
                        <p><span>联系人手机：</span>18888888888</p>
                        <p><span>固定电话：</span>1234567</p>
                        <p><span>地址：</span>湖南省长沙市岳麓区麓山南路</p>
                        <p><span>邮箱：</span>12345678@qq.com</p>
                        <p class="btn">
                            <a href="javascript:void(0)">修改</a>
                            <a href="javascript:void(0)">删除</a>
                            <a href="javascript:void(0)"><i></i>默认主体</a>
                        </p>
                    </li>

                </ul>
            </div>

            <div class="equities" style="display: none">
                <div class="addBtn">
                    <a href="javascript:;">新增主体</a>
                </div>
                <div class="infor_detail">
                    <table>
                        <tr>
                            <th width="20%">主题类型</th>
                            <th width="20%">主题名称</th>
                            <th width="20%">证件类型</th>
                            <th width="20%">证件号码</th>
                            <th width="20%">操作</th>
                        </tr>
                        <tr>
                            <td>公司</td>
                            <td>123</td>
                            <td>营业执照</td>
                            <td>11111111111111111111</td>
                            <td>
                                <a href="javascript:void(0)">修改</a>
                                <a href="javascript:void(0)" onclick="delAddr(addrId)">删除</a>
                                <div class="select">
                                    <i></i>
                                    默认主体
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="pop">
    <div class="pop_bg"></div>

    <div class="add_detail subject" id="subject">
        <p class="pop_title">新增合同/受让主体<a class="stop" href="javascript:void(0)">×</a></p>
        <div>
            <dl>
                <dt>主体类型：</dt>
                <dd class="bargain_theme">
                    <a href="javascript:void(0)" class="active" data-num="1">公司（个体工商户）</a>
                    <a href="javascript:void(0)" data-num="2">个体</a>
                </dd>
            </dl>
        </div>
        <div>
            <dl class="name">
                <dt><span>*</span>企业名称：</dt>
                <dd><input type="text" id="qyNameA" placeholder="请输入企业名称"></dd>
            </dl>

            <dl class="num">
                <dt><span>*</span>营业执照号码：</dt>
                <dd><input type="text" id="yynumberA" placeholder="请输入营业执照号码"></dd>
            </dl>

            <dl>
                <dt><span>*</span>联系地址：</dt>
                <dd>
                    <p>
                        <select name="" id="add_province" class="province">
                        </select>

                        <select name="" id="add_city" class="city">
                        </select>
                        <select name="" id="add_area" class="area"></select>
                    </p>
                    <p>
                        <input type="text" id="detinfo" placeholder="请填写街道名称，门牌号码等信息">
                    </p>
                </dd>
            </dl>

            <dl>
                <dt><span>*</span>联系人：</dt>
                <dd><input type="text" id="peoName" placeholder="请输入联系人姓名"></dd>
            </dl>

            <dl>
                <dt><span>*</span>联系人手机：</dt>
                <dd><input type="text" id="peoPhone" placeholder="请输入联系人电话（手机）"></dd>
            </dl>

            <dl>
                <dt>固定电话：</dt>
                <dd><input type="text" id="gdPhone" placeholder="请输入固定电话"></dd>
            </dl>

            <dl>
                <dt>邮箱：</dt>
                <dd><input type="text" id="email" placeholder="请输入邮箱地址"></dd>
            </dl>

            <div class="btn_box">
                <a href="javascript:void(0)" class="save" onclick="add()">保存并确认</a>
                <a href="javascript:void(0)" class="cancel">取消</a>
            </div>
        </div>
    </div>
    <div class="add_detail subject" id="modify_subject">
        <p class="pop_title">新增合同/受让主体<a class="stop" href="javascript:void(0)">×</a></p>
        <div>
            <dl>
                <dt>主体类型：</dt>
                <dd class="bargain_theme">
                    <a href="javascript:void(0)" class="active" data-num="1">公司（个体工商户）</a>
                    <a href="javascript:void(0)" data-num="2">个体</a>
                </dd>
            </dl>
        </div>
        <div>
            <dl class="name">
                <!--<dt><span>*</span>企业名称：</dt>-->
                <!--<dd><input type="text" id="qyNameA" placeholder="请输入企业名称"></dd>-->
            </dl>

            <dl class="num">
                <!--<dt><span>*</span>营业执照号码：</dt>-->
                <!--<dd><input type="text" id="yynumberA" placeholder="请输入营业执照号码"></dd>-->
            </dl>

            <dl>
                <dt><span>*</span>联系地址：</dt>
                <dd>
                    <p>
                        <select name="" id="modify_province" class="province">
                        </select>

                        <select name="" id="modify_city" class="city">
                        </select>
                        <select name="" id="modify_area" class="area"></select>
                    </p>
                    <p>
                        <input type="text" id="modify_detinfo" placeholder="请填写街道名称，门牌号码等信息">
                    </p>
                </dd>
            </dl>

            <dl>
                <dt><span>*</span>联系人：</dt>
                <dd><input type="text" id="modify_peoName" placeholder="请输入联系人姓名"></dd>
            </dl>

            <dl>
                <dt><span>*</span>联系人手机：</dt>
                <dd><input type="text" id="modify_peoPhone" placeholder="请输入联系人电话（手机）"></dd>
            </dl>

            <dl>
                <dt>固定电话：</dt>
                <dd><input type="text" id="modify_gdPhone" placeholder="请输入固定电话"></dd>
            </dl>

            <dl>
                <dt>邮箱：</dt>
                <dd><input type="text" id="modify_email" placeholder="请输入邮箱地址"></dd>
            </dl>

            <div class="btn_box">
                <a href="javascript:void(0)" class="save">保存并确认</a>
                <a href="javascript:void(0)" class="cancel">取消</a>
            </div>
        </div>
    </div>

    <div class="add_detail property" id="property">
        <p class="pop_title">新增知产注册主体<a class="stop" href="javascript:void(0)">×</a></p>
        <div>
            <dl>
                <dt>主体类型：</dt>
                <dd class="bargain_theme">
                    <a href="javascript:void(0)" class="active" data-num="1">公司（个体工商户）</a>
                    <a href="javascript:void(0)" data-num="2">个体</a>
                </dd>
            </dl>
        </div>
        <div class="property_box">
            <div>
                <dl class="name">
                    <dt><span>*</span>企业名称：</dt>
                    <dd><input type="text" class="qyNameB" placeholder="请输入企业名称"></dd>
                </dl>

                <dl class="num">
                    <dt><span>*</span>营业执照号码：</dt>
                    <dd><input type="text" class="yynumberB" placeholder="请输入营业执照号码"></dd>
                </dl>

                <dl>
                    <dt><span>*</span>营业执照扫描件：</dt>
                    <dd>
                        <p><a href="">上传扫描件</a><small>注：文件大小不要超过500K</small></p>
                        <div class="img" id="license_img01">
                            <img src="../image/buy02.jpg" alt="">
                        </div>
                        <div>
                            温馨提示：<br>
                            1、请在营业执照复印件正面空白处盖章后，扫描并上传。<br>
                            2、仅支持国家2015年2月28日起全面启用的新版营业执照，旧版执照不在适用。<br>
                            <a href="javascript:void(0)">营业执照示例</a>
                        </div>
                    </dd>
                </dl>

                <dl>
                    <dt><span>*</span>联系地址：</dt>
                    <dd>
                        <p>
                            <select name="" class="province">
                                <option value="">请选择省份</option>
                                <option value="">湖南省</option>
                            </select>

                            <select name="" class="city">
                                <option value   ="">请选择地市</option>
                            </select>

                            <select name="" class="area"></select>
                        </p>
                        <p>
                            <input type="text" placeholder="请填写街道名称，门牌号码等信息">
                        </p>
                    </dd>
                </dl>
            </div>

            <div style="display: none">
                <dl class="name">
                    <dt><span>*</span>个人姓名：</dt>
                    <dd><input type="text" placeholder="请输入姓名"></dd>
                </dl>

                <dl class="num">
                    <dt><span>*</span>身份证号码：</dt>
                    <dd><input type="text" placeholder="请输入证件号码"></dd>
                </dl>

                <dl>
                    <dt><span>*</span>身份证扫描件：</dt>
                    <dd>
                        <p><a href="">上传扫描件</a><small>注：文件大小不要超过500K</small></p>
                        <div id="person_img" class="img"></div>
                        <div>
                            温馨提示：<br>
                            1、请在身份证复印件（含身份证正、反面）空白处签字后，扫描并上传。<br>
                            2、请上传清晰可辩的身份证复印件图片。<br>
                            <a href="javascript:void(0)">营业执照示例</a>
                        </div>
                    </dd>
                </dl>

                <dl class="num">
                    <dt><span>*</span>身份证号码：</dt>
                    <dd><input type="text" placeholder="请输入证件号码"></dd>
                </dl>

                <dl>
                    <dt><span>*</span>营业执照扫描件：</dt>
                    <dd>
                        <p><a href="">上传扫描件</a><small>注：文件大小不要超过500K</small></p>
                        <div class="img" id="license_img"></div>
                        <div>
                            温馨提示：<br>
                            1、请在营业执照复印件正面空白处盖章后，扫描并上传。<br>
                            2、仅支持国家2015年2月28日起全面启用的新版营业执照，旧版执照不在适用。<br>
                            <a href="javascript:void(0)">营业执照示例</a>
                        </div>
                    </dd>
                </dl>

                <dl>
                    <dt><span>*</span>联系地址：</dt>
                    <dd>
                        <p>
                            <select name="" class="province">
                                <option value="">请选择省份</option>
                                <option value="">湖南省</option>
                            </select>

                            <select name="" class="city">
                                <option value   ="">请选择地市</option>
                            </select>
                        </p>
                        <p>
                            <input type="text" placeholder="请填写街道名称，门牌号码等信息">
                        </p>
                    </dd>
                </dl>
            </div>
        </div>
        <div class="btn_box">
            <a href="" class="save">保存并确认</a>
            <a href="" class="cancel">取消</a>
        </div>
    </div>
    <div class="add_detail property" id="modify_property">
        <p class="pop_title">新增知产注册主体<a class="stop" href="javascript:void(0)">×</a></p>
        <div>
            <dl>
                <dt>主体类型：</dt>
                <dd class="bargain_theme">
                    <a href="javascript:void(0)" class="active" data-num="1">公司（个体工商户）</a>
                    <a href="javascript:void(0)" data-num="2">个体</a>
                </dd>
            </dl>
        </div>
        <div class="property_box">
            <div>
                <dl class="name">
                    <dt><span>*</span>企业名称：</dt>
                    <dd><input type="text" class="qyNameB" placeholder="请输入企业名称"></dd>
                </dl>

                <dl class="num">
                    <dt><span>*</span>营业执照号码：</dt>
                    <dd><input type="text" class="yynumberB" placeholder="请输入营业执照号码"></dd>
                </dl>

                <dl>
                    <dt><span>*</span>营业执照扫描件：</dt>
                    <dd>
                        <p><a href="">上传扫描件</a><small>注：文件大小不要超过500K</small></p>
                        <div class="img" id="license_img01">
                            <img src="../image/buy02.jpg" alt="">
                        </div>
                        <div>
                            温馨提示：<br>
                            1、请在营业执照复印件正面空白处盖章后，扫描并上传。<br>
                            2、仅支持国家2015年2月28日起全面启用的新版营业执照，旧版执照不在适用。<br>
                            <a href="javascript:void(0)">营业执照示例</a>
                        </div>
                    </dd>
                </dl>

                <dl>
                    <dt><span>*</span>联系地址：</dt>
                    <dd>
                        <p>
                            <select name="" class="province">
                                <option value="">请选择省份</option>
                                <option value="">湖南省</option>
                            </select>

                            <select name="" class="city">
                                <option value   ="">请选择地市</option>
                            </select>

                            <select name="" class="area"></select>
                        </p>
                        <p>
                            <input type="text" placeholder="请填写街道名称，门牌号码等信息">
                        </p>
                    </dd>
                </dl>
            </div>

            <div style="display: none">
                <dl class="name">
                    <dt><span>*</span>个人姓名：</dt>
                    <dd><input type="text" placeholder="请输入姓名"></dd>
                </dl>

                <dl class="num">
                    <dt><span>*</span>身份证号码：</dt>
                    <dd><input type="text" placeholder="请输入证件号码"></dd>
                </dl>

                <dl>
                    <dt><span>*</span>身份证扫描件：</dt>
                    <dd>
                        <p><a href="">上传扫描件</a><small>注：文件大小不要超过500K</small></p>
                        <div id="person_img" class="img"></div>
                        <div>
                            温馨提示：<br>
                            1、请在身份证复印件（含身份证正、反面）空白处签字后，扫描并上传。<br>
                            2、请上传清晰可辩的身份证复印件图片。<br>
                            <a href="javascript:void(0)">营业执照示例</a>
                        </div>
                    </dd>
                </dl>

                <dl class="num">
                    <dt><span>*</span>身份证号码：</dt>
                    <dd><input type="text" placeholder="请输入证件号码"></dd>
                </dl>

                <dl>
                    <dt><span>*</span>营业执照扫描件：</dt>
                    <dd>
                        <p><a href="">上传扫描件</a><small>注：文件大小不要超过500K</small></p>
                        <div class="img" id="license_img"></div>
                        <div>
                            温馨提示：<br>
                            1、请在营业执照复印件正面空白处盖章后，扫描并上传。<br>
                            2、仅支持国家2015年2月28日起全面启用的新版营业执照，旧版执照不在适用。<br>
                            <a href="javascript:void(0)">营业执照示例</a>
                        </div>
                    </dd>
                </dl>

                <dl>
                    <dt><span>*</span>联系地址：</dt>
                    <dd>
                        <p>
                            <select name="" class="province">
                                <option value="">请选择省份</option>
                                <option value="">湖南省</option>
                            </select>

                            <select name="" class="city">
                                <option value   ="">请选择地市</option>
                            </select>
                        </p>
                        <p>
                            <input type="text" placeholder="请填写街道名称，门牌号码等信息">
                        </p>
                    </dd>
                </dl>
            </div>
        </div>
        <div class="btn_box">
            <a href="" class="save">保存并确认</a>
            <a href="" class="cancel">取消</a>
        </div>
    </div>
</div>

<div class="confirm">
    <p><span>!</span>设置默认主体成功</p>
</div>






<!--底部-->
<#include "/templates/footer.ftl">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/layui/layui.js"></script>
<script src="/usercenter/js/usercontract.js"></script>
</body>
</html>