$(function () {
    $(".content .content_lf div h4").each(function () {
        var _this = $(this).attr("data-item");
        if (_this == "true") {
            $(this).next().show();
            $(this).find("i").attr("class", "active");
        }
        $(this).on("click", function () {
            $(this).next().toggle();
            if ($(this).next().is(":hidden")) {
                $(this).attr("data-item", "false");
                $(this).find("i").attr("class", "item");
            } else {
                $(this).attr("data-item", "true");
                $(this).find("i").attr("class", "active");
            }
        })
    })
})



// /**
//  * Created by Administrator on 2017/12/18.
//  */
//阻止默认事件函数 兼容写法
function stopDefault(e) {
    if (e && e.preventDefault) { //非IE
        e.preventDefault();
    } else { //IE
        window.event.returnValue = true;
    }
}
//弹出层 num:icon图片—6成功5失败   msg：错误提示
function comfirm_add(num, msg) {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.open(
            {
                type: 0,
                title: false,
                icon: num,
                content: msg,
                skin: "layui-layer-lan",
                btn: false,
                closeBtn: 0,
                shade: 0.5,
                shadeClose: true,
                time: 1500,
                anim: 1
            }
        )
    })
}
var oDiv, oOption, proviceId, cityId, nowTime = 0, proviceB = false, cityB = false, areaB = false,
    objData = {
        'bankid': '0',
        'provincename': '请选择省份',
        'city': '请选择地市',
        'area': '请选择区县'
    },
    reg = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/,
    $province_1 = $('.province'),
    $province_2 = $('.city'),
    $province_3 = $('.area');

// /*******************默认选项的地址*********************/
$('.information').on("click", ".select", function (e) {
    if (!$(this).is(".active")) {
        stopDefault(e);
        //改变原来默认地址
        $(".active").children("a").attr("data-isdef", 0);
        var lid = $(".active").children("a").attr("data-uid");
        def(lid, 0);
        //增加刚点击的为默认地址

        $('.active').removeClass('active');
        $(this).addClass('active');
        $(this).children("a").attr("data-isdef", 1);
        var nid = $(this).children("a").attr("data-uid");
        def(nid, 1);
        $('.confirm').show();
        setTimeout(function () {
            $('.confirm').hide();
        }, 1000)
    }
});
// /*********弹窗的弹出设置********/
$('.addBtn a').click(function (e) {
    e.preventDefault();
    $('.pop').show();
    $('#add').show().siblings('.add_detail').hide();
});
$('.information').on("click", ".modification", function (e) {
    e.preventDefault();
    //d动态绑定修改保存的事件
    var did = $(this).parent().next(".select").children("a").attr("data-uid");
    $(".btnBox>.save").eq(1).attr("onclick", 'update(' + did + ')');
    $('.pop').show();
    $('#modify').show().siblings('.add_detail').hide();
});
/************弹窗关闭的设置*********/
$('.stop').click(function (e) {
    e.preventDefault();
    $('.pop').hide();
});

//地区设置
$.ajax({
    type: 'post',
    url: wqturl + '/getProvince.action',
    dataType: 'json',
    data: {
    },
    error: function (XmlHttpRequest, textStatus, errorThrown) {
        console.log(XmlHttpRequest.status);
    },
    success: function (data) {
        $province_1.html('<option value="请选择省份">请选择省份</option>');
        for (var i = 0, len = data.length; i < len; i++) {
            oOption = $('<option value=' + data[i].provincename + ' name=' + data[i].id + '>' + data[i].provincename + '</option>');
            $province_1.append(oOption);
        };
    }
});
//监听省份框
$province_1.on('change', function () {
    cityB = false; areaB = false;
    var index = this.selectedIndex + 1;
    proviceId = $('.province option:nth-child(' + index + ')').attr('name');
    console.log(proviceId);
    objData.provincename = $(this).val();
    console.log(objData.provincename);
    if (objData.provincename == '请选择省份') {
        proviceB = false;
        objData.city = '请选择地市';
        objData.area = '请选择区县';
        $province_2.html('');
    } else {
        proviceB = true;
        $.ajax({
            type: 'post',
            url: wqturl + '/getCity.action?provinceid=' + proviceId,
            dataType: 'json',
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                console.log(XmlHttpRequest.status);
            },
            success: function (data) {
                if (data.length == 0) {
                    cityB = true;
                    areaB = true;
                    $province_2.html('');
                } else {
                    $province_2.html('<option value="请选择地市">请选择地市</option>');
                    for (var i = 0, len = data.length; i < len; i++) {
                        oOption = $('<option name=' + data[i].id + '>' + data[i].cityname + '</option>');
                        $province_2.append(oOption);
                    };
                }
            }
        });
    }
    $province_3.html('');
});
//监听地市框
$province_2.on('change', function () {
    areaB = false;
    var index = this.selectedIndex + 1;
    cityId = $('.city option:nth-child(' + index + ')').attr('name');
    objData.city = $(this).val();
    if (objData.city == '请选择地市') {
        cityB = false;
        objData.area = '请选择区县';
        $province_3.html('');
    } else {
        cityB = true;
        $.ajax({
            type: 'post',
            url: wqturl + '/getArea.action?cityid=' + cityId,
            dataType: 'json',
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                console.log(XmlHttpRequest.status);
            },
            success: function (data) {
                console.log(data);
                if (data.length === 0) {
                    areaB = true;
                    $province_3.html('');
                } else {
                    $province_3.html('<option value="请选择区县">请选择区县</option>');
                    for (var i = 0, len = data.length; i < len; i++) {
                        oOption = $('<option value=' + data[i].areaname + '>' + data[i].areaname + '</option>');
                        $province_3.append(oOption);
                    }
                }
            }
        })
    }
});
//监听区县框
$province_3.on('change', function () {
    objData.area = $(this).val();
    areaB = objData.area == '请选择区县' ? false : true;
    console.log(areaB);
});

// /*****************
//
// $.ajax({
//     'type':'post',
//     'dataType':'json',
//     'url':'getProvince',
//     'data':'',
//     success:function(data){
//         for(var i=0;i<data.length;i++){
//             var oOption = '';
//             oOption += '<option value="'+data[i].id+'">'+data[i].provincename+'</option>';
//             $province_1.append(oOption);
//         }
//     }
// });
//
// $('#add_province').on('change','option',function(){
//     var myselect = $('#add_province');
//     var index=myselect.selectedIndex;
//     var id = myselect.options[index].attr('value');
//     console.log(id);
//     $.ajax({
//         'type':'post',
//         'dataType':'json',
//         'url':'getCity',
//         'data':{
//             'Wqtcity.provinceid':id
//         },
//         success:function(data){
//             for(var i=0;i<data.length;i++){
//                 var oOption = '';
//                 oOption += '<option name="'+data[i].id+'">'+data[i].cityname+'</option>';
//                 $province_2.append(oOption);
//             }
//         }
//     })
// })
//
// $province_2.on('click','option',function(){
//     var id = $(this).attr('name');
//     $.ajax({
//         'type':'post',
//         'dataType':'json',
//         'url':'getArea',
//         'data':{
//             'Wqtarea.cityid':id
//         },
//         success:function(data){
//             for(var i=0;i<data.length;i++){
//                 var oOption = '';
//                 oOption += '<option name="'+data[i].id+'">'+data[i].cityname+'</option>';
//                 $province_3.append(oOption);
//             }
//         }
//     })
// })
//  *************************/

// /*************新增收件地址************/
function add() {
    var uName = '', address = '', phone = '', aa = '', bb = '', cc = '', dd = '', ee = '', ff = '';
    aa += $('#add_uName').val();
    bb += $('#add_address').val();
    cc += $('#add_tel').val();
    dd += $('#add_province').val();
    ee += $('#add_city').val();
    ff += $('#add_area').val();
    console.log(dd, ee, ff);
    uName = aa == '' ? false : true;
    address = bb == '' ? false : true;
    phone = cc == '' ? false : true;
    province = dd == '' ? false : true;
    city = ee == '' ? false : true;
    area = ff == '' ? false : true;
    if (!uName) {
        comfirm_add(5, '亲，请填写您的联系姓名！');
    } else if (!address) {
        comfirm_add(5, '亲，请填写您的详细地址！');
    } else if (!reg.test(cc)) {
        comfirm_add(5, '亲，请输入正确的手机号码！');
    } else if (!phone) {
        comfirm_add(5, '亲，请填写您的联系电话！');
    } else if (!proviceB) {
        comfirm_add(5, '亲，请选择您所在的省份！');
    } else if (!cityB) {
        comfirm_add(5, '亲，请选择您所在的地市！');
    } else if (!areaB) {
        comfirm_add(5, '亲，请选择您所在的区县！');
    } else {
        $.ajax({
            type: "post",
            dataType: 'json',
            url: wqturl + '/saveUserPost.action',
            data: {
                'wqtUserPost.recvname': aa,
                'wqtUserPost.recvprovice': dd,   //收件省
                'wqtUserPost.recvcity': ee,   //收件市
                'wqtUserPost.recvarea': ff,   //收件区县
                'wqtUserPost.recvaddr': bb,   //收件详细地址
                'wqtUserPost.connecttel': cc   //联系电话
            },
            success: function (data) {
                if (data.result == 1) {
                    alert("添加成功");
                    window.location.reload();
                } else if (data.result == 2) {
                    window.location.href = wqturl + "/casLogin?service=" + data.msg;
                }
            }
        })
    }
};

//初始化地址列表
// $.ajax({
//     "type":"post",
//     "url":wqturl+"postlist",
//     "dataType":"json",
//     "data":"",
//     success:function(data){
//         console.log(data);
//         var data=data.msg.rows;
//         var len=data.length<=10?data.length : 10;
//         for(var i=0;i<len;i++){
//             console.log(data[i].id);
//             var str = '';
//             str += '<tr><td>'+ data[i].recvname +'</td>' +
//                 '<td>'+ data[i].connecttel +'</td>' +
//                 '<td>'+ data[i].recvaddr +'</td>' +
//                 '<td><a class="modification" style="color: #258E3D" onclick="modify('+ data[i].id+')" href="javascript:void(0);">修改</a><a class="cancel" onclick="delAddr('+ data[i].id +','+data[i].isdefault+',event)" style="color: red" href="javascript:void(0);">删除</a></td>';
//             if(data[i].isdefault == '1'){
//                 str += '<td class="select active"><i></i><a href="javascript:void(0);" data-isdef='+data[i].isdefault+' data-uid='+data[i].id+'>默认地址</a></td></tr>'
//             }else{
//                 str += '<td class="select"><i></i><a href="javascript:void(0);" data-isdef='+data[i].isdefault+' data-uid='+data[i].id+'>默认地址</a></td></tr>'
//             };
//             $('.information table').append(str);
//         }
//     }
// });

//修改用户寄件地址
function update(addrId) {
    var uName = '', address = '', phone = '', aa = '', bb = '', cc = '', dd = '', ee = '', ff = '';
    aa += $('#modify_uName').val();
    bb += $('#modify_address').val();
    cc += $('#modify_tel').val();
    dd += $('#modify_province').val();
    ee += $('#modify_city').val();
    ff += $('#modify_area').val();

    uName = aa == '' ? false : true;
    address = bb == '' ? false : true;
    phone = cc == '' ? false : true;
    province = dd == '请选择省份' ? false : true;
    city = ee == '请选择地市' ? false : true;
    area = ff == '请选择区县' ? false : true;
    if (!uName) {
        comfirm_add(5, '亲，请填写您的联系姓名！');
    } else if (!address) {
        comfirm_add(5, '亲，请填写您的联系地址！');
    } else if (!phone) {
        comfirm_add(5, '亲，请填写您的联系电话！');
    } else if (!reg.test(cc)) {
        comfirm_add(5, '亲，请输入正确的手机号码！');
    } else if (!(province || proviceB)) {
        comfirm_add(5, '亲，请选择您所在的省份！');
    } else if (!(city || cityB)) {
        comfirm_add(5, '亲，请选择您所在的地市！');
    } else if (!(area || areaB)) {
        comfirm_add(5, '亲，请选择您所在的区县！');
    } else {
        $.ajax({
            type: "post",
            dataType: 'json',
            url: wqturl + '/updateUserPost.action',
            data: {
                'wqtUserPost.recvname': aa,
                'wqtUserPost.recvprovice': dd,   //收件省
                'wqtUserPost.recvcity': ee,   //收件市
                'wqtUserPost.recvarea': ff,   //收件区县
                'wqtUserPost.recvaddr': bb,   //收件详细地址
                'wqtUserPost.connecttel': cc,  //联系电话
                'wqtUserPost.id': addrId   //地址id
            },
            success: function (data) {
                if (data.result == 1) {
                    alert("修改成功");
                    window.location.reload();
                } else if (data.result == 2) {
                    window.location.href = wqturl + "/casLogin?service=" + data.msg;
                }
            },
            error: function () {
                console.log("error");
            }
        })
    }
};

//删除用户寄件地址
function delAddr(addrId, event) {
    stopDefault(event);
    var r = confirm("亲，确认删除这个地址吗？");
    if (r == true) {
        $.ajax({
            'type': 'post',
            'dataType': 'json',
            'url': wqturl + '/delUserPost.action?id=' + addrId,
            success: function (data) {
                if (data.result == 1) {
                    window.location.reload();
                } else if (data.result == 2) {
                    window.location.href = wqturl + "/casLogin?service=" + data.msg;
                }
            }
        })
    }
};

//修改地址的内容初始化
function modify(id) {
    //先除掉原先点击产生的selected
    $('#modify_province').children().removeAttr("selected");
    var aa = "", bb = "";
    $.ajax({
        'type': 'post',
        'dataType': 'json',
        'url': wqturl + '/onePostInfo.action?id=' + id,
        success: function (data) {
            var data = data.msg;
            $('#modify_uName').val(data.recvname);
            $('#modify_province').val(data.recvprovice);
            if (data.recvcity != null) {
                var proviceId = $('#modify_province').children("option[value=" + data.recvprovice + "]").attr("name");
                $.ajax({
                    type: 'post',
                    url: wqturl + '/getCity.action?provinceid=' + proviceId,
                    success: function (citydata) {
                        for (var i = 0, len = citydata.length; i < len; i++) {
                            aa += '<option value=' + citydata[i].cityname + ' name=' + citydata[i].id + '>' + citydata[i].cityname + '</option>';
                        };
                        $('#modify_city').html(aa);
                        //先除掉原先点击产生的selected
                        $('#modify_city').children().removeAttr("selected");
                        $('#modify_city').children("option[value=" + data.recvcity + "]").attr("selected", "selected").siblings().removeAttr("selected");
                        var city = ($('#modify_city').children("option[value=" + data.recvcity + "]").attr("name"));
                        if (data.recvarea != null) {
                            $.ajax({
                                type: 'post',
                                url: wqturl + '/getArea.action?cityid=' + city,
                                success: function (areadata) {
                                    for (var i = 0, len = areadata.length; i < len; i++) {
                                        bb += '<option name=' + areadata[i].id + ' value=' + areadata[i].areaname + '>' + areadata[i].areaname + '</option>';
                                    }
                                    $('#modify_area').html(bb);
                                    $('#modify_area').children().removeAttr("selected");
                                    $('#modify_area').children("option[value=" + data.recvarea + "]").attr("selected", true).siblings().removeAttr("selected");
                                }
                            })
                        }
                    }
                });
            }
            $('#modify_address').val(data.recvaddr);
            $('#modify_tel').val(data.connecttel);
            // $('#modify .save').attr('onclick(update('+data.id+',enevt))');
        }
    })
};


//    将地址设置为默认地址
function def(id, i) {
    $.ajax({
        'type': 'post',
        'dataType': 'json',
        'url': wqturl + '/updateUserPost.action',
        data: {
            'wqtUserPost.id': id,
            'wqtUserPost.isdefault': i
        },
        success: function (data) {
            console.log(data);
        }
    })
}

$(function () {
    /* 定义变量 */
    var sUrl = wqturl + '/postlist.action',
        oData = {},
        oStr = '';
    /* fn */
    ajaxFn(sUrl, oData);
    function ajaxFn(url, Data) {
        pagesize = parseInt(Data.pagesize || '10');
        currpage = parseInt(Data.currpage || '1');
        $.ajax({
            type: 'post',
            url: url,
            dataType: 'json',
            data: {
                'pagination.size': 10,
                'pagination.currPage': currpage
            },
            error: function (XmlHttpRequest, textStatus, errorThrown) {
                console.log(XmlHttpRequest.status);
            },
            success: function (data) {
                var c = ''; //判断市是否为null
                var a = ''; //判断区是否为null
                var total = parseInt(data.msg.total);
                var pages = parseInt(data.msg.pages);
                var ddata = data.msg.rows;
                var str_a = ''; //用于创建分页a标签
                var str = '<tr>' +
                    '<th width="20%">联系人名称</th>' +
                    '<th width="20%">联系电话</th>' +
                    '<th width="20%">联系地址</th>' +
                    '<th width="40%" colspan="2">操作</th>' +
                    ' </tr>';
                for (var i = 0; i < ddata.length; i++) {
                    c = ddata[i].recvcity === 'null' ? '' : ddata[i].recvcity;
                    a = ddata[i].recvarea === 'null' ? '' : ddata[i].recvarea;
                    str += '<tr><td>' + ddata[i].recvname + '</td>' +
                        '<td>' + ddata[i].connecttel + '</td>' +
                        '<td>' + ddata[i].recvprovice + c + a + ddata[i].recvaddr + '</td>' +
                        '<td><a class="modification" style="color: #258E3D" onclick="modify(' + ddata[i].id + ')" href="javascript:void(0);">修改</a><a class="cancel" onclick="delAddr(' + ddata[i].id + ',event)" style="color: red" href="javascript:void(0);">删除</a></td>';
                    if (ddata[i].isdefault == '1') {
                        str += '<td class="select active"><i></i><a href="javascript:void(0);" data-isdef=' + ddata[i].isdefault + ' data-uid=' + ddata[i].id + '>默认地址</a></td></tr>'
                    } else {
                        str += '<td class="select"><i></i><a href="javascript:void(0);" data-isdef=' + ddata[i].isdefault + ' data-uid=' + ddata[i].id + '>默认地址</a></td></tr>'
                    };
                }
                $('.information table').html(str);
                if (pages > 1) {
                    $('div.company_list_result_pages').show();
                    $('.pagesN').html('');
                    $('#allPage2').html(pages);
                    if (pages < 8) {
                        for (var i = 0; i < pages; i++) {
                            str_a = '';
                            str_a += '<a href="javascript:void(0)">' + (i + 1) + '</a>';
                            var newA = $(str_a);
                            $('.pagesN').append(newA);
                        }
                    } else {
                        if (currpage < 5) {
                            for (var i = 0; i < 8; i++) {
                                str_a = '';
                                str_a += '<a href="javascript:void(0)">' + (i + 1) + '</a>';
                                var newA = $(str_a);
                                $('.pagesN').append(newA);
                            }
                        } else if (currpage >= 5 && currpage < parseInt(pages) - 3) {
                            for (var i = 0; i < 8; i++) {
                                str_a = '';
                                str_a += '<a href="javascript:void(0)">' + (i + currpage - 3) + '</a>';
                                var newA = $(str_a);
                                $('.pagesN').append(newA);
                            }
                        } else {
                            for (var i = 0; i < 8; i++) {
                                str_a = '';
                                str_a += '<a href="javascript:void(0)">' + (i + parseInt(pages) - 7) + '</a>';
                                var newA = $(str_a);
                                $pagesN.append(newA);
                            }
                        }
                    };
                } else {
                    $('div.company_list_result_pages').hide();
                };
                $("#firstPage").off("click");
                $("span.pagesN a").off("click");
                $("#nextPage").off("click");
                $("#prevA").off("click");
                $("#nextA").off("click");
                $("#btn").off("click");
                $("#pages").off("keydown");
                pageJsFn(url);
            }
        })
    }
    /* 页标js */
    function pageJsFn(url) {
        var $allPageV = parseInt($('#allPage2').html()),    //总页数
            $pagesNA = $("span.pagesN a"),                 //页码标签
            $nowPage2V = parseInt($("#nowPage2").html());//当前页
        /* 当前页高亮显示 */
        if ($allPageV <= 8) {
            $pagesNA.eq($nowPage2V - 1).addClass("active").siblings().removeClass("active");
        } else {
            if ($nowPage2V < 5) {
                $pagesNA.eq($nowPage2V - 1).addClass("active").siblings().removeClass("active");
            } else if ($nowPage2V >= 5 && $nowPage2V < $allPageV - 3) {
                $pagesNA.eq(3).addClass("active").siblings().removeClass("active");
            } else {
                $pagesNA.eq(7 - $allPageV + $nowPage2V).addClass("active").siblings().removeClass("active");
            }
        };
        /* 点击跳到第一页 */
        $("#firstPage").on('click', function (e) {
            stopDefault(e);
            $nowPage2V = 1;
            $('#nowPage2').html($nowPage2V);
            oData.currpage = parseInt($nowPage2V);
            ajaxFn(url, oData);
        });
        /* 点击页标a标签 */
        $pagesNA.each(function () {
            $(this).on('click', function (e) {
                stopDefault(e);
                $nowPage2V = $(this).html();
                $('#nowPage2').html($nowPage2V);
                oData.currpage = parseInt($nowPage2V);
                ajaxFn(url, oData);
            });
        });
        /* 点击跳到尾页 */
        $("#nextPage").on('click', function (e) {
            stopDefault(e);
            $nowPage2V = $allPageV;
            $('#nowPage2').html($nowPage2V);
            oData.currpage = parseInt($nowPage2V);
            ajaxFn(url, oData);
        });
        /* 点击上一页、点击下一页 */
        $("#prevA").click(prevFn);
        $('#nextA').click(nextFn);
        /* input输值跳转 */
        $('#pages').on('keydown', function (e) {
            var e = e || event;
            if (!((e.keyCode >= 48 && e.keyCode <= 57) || (e.keyCode >= 96 && e.keyCode <= 105) || (e.keyCode == 9) || (e.keyCode == 8) || (e.keyCode == 116) || (e.keyCode == 13))) stopDefault(e);//阻止默认事件，去掉move的时候选中文本;
            if (e.keyCode == 13) inputFn();
        });
        $('#btn').click(inputFn);
        /* 上一页fn */
        function prevFn(e) {
            stopDefault(e);
            if ($nowPage2V > 1) {
                $nowPage2V--;
                $('#nowPage2').html($nowPage2V);
                oData.currpage = $nowPage2V;
                ajaxFn(url, oData);
            };
        };
        /* 下一页fn */
        function nextFn(e) {
            stopDefault(e);
            if ($nowPage2V < $allPageV) {
                $nowPage2V++;
                $('#nowPage2').html($nowPage2V);
                oData.currpage = $nowPage2V;
                ajaxFn(url, oData);
            };
        };
        /* input跳转fn */
        function inputFn() {
            if (parseInt($("#pages").val()) < 2) {
                $nowPage2V = 1;
                $('#nowPage2').html($nowPage2V);
            } else if (parseInt($("#pages").val()) > $allPageV - 1) {
                $nowPage2V = $allPageV;
                $('#nowPage2').html($nowPage2V);
            } else {
                $nowPage2V = parseInt($("#pages").val());
                $('#nowPage2').html(parseInt($("#pages").val()));
            };
            $("#pages").val('');
            oData.currpage = parseInt($nowPage2V);
            ajaxFn(url, oData);
        };
    };
});

// 标题伸缩 个人资料，我是买家等
$(".content .content_lf div h4").each(function () {
    $(this).next().hide();
    $(this).on("click", function () {
        $(this).next().toggle();
        if ($(this).is(":hidden")) {
            $(this).find("i").attr("class", "active");
        } else {
            $(this).find("i").attr("class", "item");
        }
    })
})


















