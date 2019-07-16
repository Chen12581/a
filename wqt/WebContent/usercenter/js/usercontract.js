/**
 * Created by Administrator on 2018/3/4.
 */
//弹出层 num:icon图片—6成功5失败   msg：错误提示
function comfirm_add(num,msg){
    layui.use('layer',function(){
        var layer=layui.layer;
        layer.open(
            {
                type:0,
                title:false,
                icon:num,
                content:msg,
                skin:"layui-layer-lan",
                btn:false,
                closeBtn:0,
                shade:0.5,
                shadeClose:true,
                time:1500,
                anim:1
            }
        )
    })
}
var oOption,proviceId,cityId,proviceB=false,cityB=false,areaB=false,
  reg_phone=/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/,//手机号码验证
  reg_sfz=/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/,
  reg_email=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/,
    objData={
        'bankid':'0',
        'provincename':'请选择省份',
        'city':'请选择地市',
        'area':'请选择区县'
    },
    $province_1 = $('.province'),
    $province_2 = $('.city'),
    $province_3 = $('.area');
//阻止默认事件函数 兼容写法
function stopDefault(e) {
    if(e && e.preventDefault) { //非IE
        e.preventDefault();
    } else { //IE
        window.event.returnValue = true;
    }
}
(function(){
    /*********弹窗的弹出设置********/
    //新增
    $('.addBtn a').eq(0).click(function(e){
        stopDefault(e);
        $(".bargain_theme a.active").siblings().show();
        $('.pop').show();
        $("#subject").show().siblings('.add_detail').hide();
    });
    $('.addBtn a').eq(1).click(function(e){
        stopDefault(e);
        $(".bargain_theme a.active").siblings().show();
        $('.pop').show();
        $("#property").show().siblings('.add_detail').hide();
    });


    //    知产主体类型的选择
    $('.property .bargain_theme').on('click','a',function(e){
        stopDefault(e);
        $(this).addClass('active').siblings().removeClass('active');
        var num = $(this).attr('data-num');
        $('.property_box>div:nth-child('+ num +')').show().siblings().hide();
    });
    // 设置默认主体合同动作
    $('.bargain_list').on('click','a.de_btn',function(e){
        stopDefault(e);
        if(!$(this).is(".default")){
            $(".default").attr("data-def",'0');
            var lid=$(".default").siblings('a.modification').attr("data-uid");
            def(lid,0);
            $('.default').removeClass('default');
            $(this).addClass('default');
            var nid=$(this).siblings('a.modification').attr("data-uid");
            def(nid,1);
        }
    });

   //    合同主体主题更换设置
    $('.theme_tab').on('click','a',function(e){
        stopDefault(e);
        var num = $(this).index('.theme_tab a');
        num++;
        $('.information>div:nth-child('+num+')').show().siblings().hide();
        if(num=='1'){
            $('.theme_tab i').animate({
                'left':'0'
            },200)
        }else if(num=='2'){
            $('.theme_tab i').animate({
                'left':'130px'
            },200)
        }
    });

    //修改
    $('.bargain_list').on('click','a.modification',function(e){
        stopDefault(e);
        $('.pop').show();
        $('#modify_subject').show().siblings('.add_detail').hide();
        var inde=$(this).attr('data-kind');
        $(".subject .bargain_theme a[data-num="+inde+"]").addClass('active').siblings().removeClass('active');
        if(inde=='1'){
            var str01 = '',str02 = '';
            str01 += '<dt><span>*</span>企业名称：</dt>' +
                '<dd><input type="text" id="modify_qyNameA" placeholder="请输入企业名称"></dd>';
            str02 += '<dt><span>*</span>营业执照号码：</dt>' +
                '<dd><input type="text" id="modify_yynumberA" placeholder="请输入营业执照号码"></dd>';
            $('#modify_subject .name').html(str01);
            $('#modify_subject .num').html(str02);
        }else if(inde=='2'){
            var str01 = '',str02 = '';
            str01 += '<dt><span>*</span>姓名：</dt>' +
                '<dd><input type="text" id="modify_qyNameB" placeholder="请输入姓名"></dd>';
            str02 += '<dt><span>*</span>身份证号码：</dt>' +
                '<dd><input type="text" id="modify_yynumberB" placeholder="请输入身份证号码"></dd>';
            $('#modify_subject .name').html(str01);
            $('#modify_subject .num').html(str02);
        };
        var id=$(this).attr("data-uid");
        $("#modify_subject .save").attr("onclick","update("+id+")");
    });

    /************弹窗关闭的设置*********/
    $('.stop').click(function(e){
        stopDefault(e);
        $('.pop').hide();
        $(".bargain_theme a").show();//主体内容显示
    });
	$('.cancel').click(function(e){
        stopDefault(e);
        $('.pop').hide();
        $(".bargain_theme a").show();
    });

   // 新增主体类型的动作
    $('#subject .bargain_theme').on('click','a',function(e){
        stopDefault(e);
        $(this).addClass('active').siblings().removeClass('active');
        if($(this).attr('data-num')=='1'){
            var str01 = '',str02 = '';
            str01 += '<dt><span>*</span>企业名称：</dt>' +
                '<dd><input type="text" id="qyNameA" placeholder="请输入企业名称"></dd>';
            str02 += '<dt><span>*</span>营业执照号码：</dt>' +
                '<dd><input type="text" id="yynumberA" placeholder="请输入营业执照号码"></dd>';
            $('.subject .name').html(str01);
            $('.subject .num').html(str02);
        }else if($(this).attr('data-num')=='2'){
            var str01 = '',str02 = '';
            str01 += '<dt><span>*</span>姓名：</dt>' +
                '<dd><input type="text" id="qyNameB" placeholder="请输入姓名"></dd>';
            str02 += '<dt><span>*</span>身份证号码：</dt>' +
                '<dd><input type="text" id="yynumberB" placeholder="请输入身份证号码"></dd>';
            $('.subject .name').html(str01);
            $('.subject .num').html(str02);
        };
    });
    //修改主体类型的动作
    $('#modify_subject .bargain_theme').on('click','a',function(e){
        stopDefault(e);
        $(this).addClass('active').siblings().removeClass('active');
        if($(this).attr('data-num')=='1'){
            var str01 = '',str02 = '';
            str01 += '<dt><span>*</span>企业名称：</dt>' +
                '<dd><input type="text" id="modify_qyNameA" placeholder="请输入企业名称"></dd>';
            str02 += '<dt><span>*</span>营业执照号码：</dt>' +
                '<dd><input type="text" id="modify_yynumberA" placeholder="请输入营业执照号码"></dd>';
            $('.subject .name').html(str01);
            $('.subject .num').html(str02);
        }else if($(this).attr('data-num')=='2'){
            var str01 = '',str02 = '';
            str01 += '<dt><span>*</span>姓名：</dt>' +
                '<dd><input type="text" id="modify_qyNameB" placeholder="请输入姓名"></dd>';
            str02 += '<dt><span>*</span>身份证号码：</dt>' +
                '<dd><input type="text" id="modify_yynumberB" placeholder="请输入身份证号码"></dd>';
            $('.subject .name').html(str01);
            $('.subject .num').html(str02);
        };
    });


    //地区设置
    $.ajax({
        type:'post',
        url:wqturl+'/getProvince.action',
        dataType:'json',
        data:{
        },
        error:function(XmlHttpRequest,textStatus,errorThrown){
            console.log(XmlHttpRequest.status);
        },
        success:function(data){
            $province_1.html('<option value="请选择省份">请选择省份</option>');
            for(var i=0,len=data.length;i<len;i++){
                oOption = $('<option value='+data[i].provincename+' name='+data[i].id+'>'+data[i].provincename+'</option>');
                $province_1.append(oOption);
            };
        }
    });
    //监听省份框
    $province_1.on('change',function(){
        console.log(11);
        cityB=false;areaB=false;
        var index = this.selectedIndex+1;
        proviceId = $('.province option:nth-child('+index+')').attr('name');
        console.log(proviceId);
        objData.provincename = $(this).val();
        console.log(objData.provincename);
        if(objData.provincename=='请选择省份'){
            proviceB=false;
            objData.city='请选择地市';
            objData.area='请选择区县';
            $province_2.html('');
        }else{
            proviceB=true;
            console.log(proviceId);
            $.ajax({
                type:'post',
                url:wqturl+'/getCity.action?provinceid='+proviceId,
                dataType:'json',
                error:function(XmlHttpRequest,textStatus,errorThrown){
                    console.log(XmlHttpRequest.status);
                },
                success:function(data){
                    console.log(data);
                    if(data.length==0){
                        cityB=true;
                        areaB=true;
                        $province_2.html('');
                    }else{
                        $province_2.html('<option value="请选择地市">请选择地市</option>');
                        for(var i=0,len=data.length;i<len;i++){
                            oOption = $('<option name=' + data[i].id + '>' + data[i].cityname + '</option>');
                            $province_2.append(oOption);
                            console.log(cityB,areaB);
                        };
                    }
                }
            });
        }
        $province_3.html('');
    });
    //监听地市框
    $province_2.on('change',function(){
        areaB=false;
        var index = this.selectedIndex+1;
        cityId = $('.city option:nth-child('+index+')').attr('name');
        objData.city = $(this).val;
        if(objData.city=='请选择地市'){
            cityB=false;
            objData.area='请选择区县';
            $province_3.html('');
        }else{
            cityB=true;
            $.ajax({
                type:'post',
                url:wqturl+'/getArea.action?cityid='+cityId,
                dataType:'json',
                error:function(XmlHttpRequest,textStatus,errorThrown){
                    console.log(XmlHttpRequest.status);
                },
                success:function(data){
                    console.log(data);
                    if(data.length===0){
                        areaB=true;
                        $province_3.html('');
                    }else{
                        $province_3.html('<option value="请选择区县">请选择区县</option>');
                        for(var i=0,len=data.length;i<len;i++) {
                            oOption = $('<option value=' + data[i].areaname + '>' + data[i].areaname + '</option>');
                            $province_3.append(oOption);
                        }
                    }
                }
            })
        }
    });
    //监听区县框
    $province_3.on('change',function(){
        objData.area = $(this).val();
        areaB=objData.area=='请选择区县'?false:true;
        console.log(areaB);
    });


    //初始化主体列表
    $.ajax({
        "type":"post",
        "url":wqturl+"/contractlist.action",
        "dataType":"json",
        success:function(data){
            var k='';
            var c='';   //如果市为undefined就显示空
            var a='';   //如果区为undefined就显示空
            var e='';   //如果固定电话为undefined就显示空
            var f='';   //如果邮箱为undefined就显示空
            var data=data.msg.rows;
            for(var i=0,len=data.length;i<len;i++){
                k=data[i].kind==1?'公司':'个人';
                c=data[i].city===undefined?'':data[i].city;
                a=data[i].area===undefined?'':data[i].area;
                e=data[i].tel===undefined?'':data[i].tel;
                f=data[i].email===undefined?'':data[i].email;
                var str = '';
                str += '<li>'+
                            '<p><span>主体类型：</span>'+k+'</p>'+
                            '<p><span>主体名称：</span>'+data[i].name+'</p>'+
                            '<p><span>身份证号码：</span>'+data[i].certificatecode+'</p>'+
                            '<p><span>联系人：</span>'+data[i].connector+'</p>'+
                            '<p><span>联系人手机：</span>'+data[i].mobileno+'</p>'+
                            '<p><span>固定电话：</span>'+e+'</p>'+
                            '<p><span>地址：</span>'+data[i].province+c+a+data[i].explicitaddr+'</p>'+
                            '<p><span>邮箱：</span>'+f+'</p>'+
                            '<p class="btn">'+
                                '<a href="javascript:void(0)" class="modification" data-uid="'+data[i].id+'" data-kind="'+data[i].kind+'" onclick="modify('+data[i].id+','+data[i].kind+')">修改</a>'+
                                '<a href="javascript:void(0)" onclick="delAddr('+data[i].id+')">删除</a>'
                                if(data[i].isdefault=='0'){
                                   str+= '<a class="de_btn" href="javascript:void(0)" data-def="'+data[i].isdefault+'"><i></i>默认主体</a>'
                                }else if(data[i].isdefault=='1'){
                                    str+= '<a class="de_btn default" href="javascript:void(0)" data-def="'+data[i].isdefault+'"><i></i>默认主体</a>'
                                }
                            '</p>'+
                        '</li>'
                $('.bargain_list').append(str);
            }
        }
    });


    //新增主体类型
    add=function(){
        var kind=$("#subject .bargain_theme .active").attr("data-num");
        var uName = '',yynumber = '',phone = '',gdPhone='',email='',aa = '',bb = '',
            add_province='',add_city='',add_area='',cc = '',dd = '',ee = '',ff = '',gg='',hh='',ii='',jj='',pd=true;
        aa =$('#qyNameA').val();//企业名称
        bb =$('#yynumberA').val();//营业执照号码
        cc =$('#peoPhone').val();//联系电话
        dd =$('#gdPhone').val();//固定电话
        ee =$('#email').val();  //邮箱
        ff =$('#add_province').val();//省份
        gg =$('#add_city').val();//地市
        hh =$('#add_area').val();//区县
        ii=$('#detinfo').val();//详细地址
        jj=$('#peoName').val();//联系人
        kk=$('#qyNameB').val(); //姓名
        ll=$("#yynumberB").val();//身份证号码
        if(kind=='2'){
            aa=kk;
            bb=ll;
        }
        console.log(cc,ii,hh);
        uName=aa==''?false:true;
        yynumber=bb==''?false:true;
        phone=cc==''?false:true;
        gdPhone=dd==''?true:false;
        email=ee==''?true:false;
        add_province=ff==''?false:true;
        add_city=gg==''?false:true;
        add_area=hh==''?false:true;
        peoName=jj==''?false:true;
        detinfo=ii==''?false:true;
        qyNameB=kk==''?false:true;
        yynumberB=ll==''?false:true;
        console.log(ff,gg,hh);
        console.log(cc);
        console.log(ii);
        if(kind=='1'){
            if(!uName){
                comfirm_add(5,'亲，请填写您的企业名称！');
                pd=false;
            }else if(!yynumber){
                comfirm_add(5,'亲，请填写您的营业执照号码！');
                pd=false;
            }
        }else if(kind=='2'){
            if(!qyNameB){
                comfirm_add(5,'亲，请输入您的姓名！');
                pd=false;
            }else if(!yynumberB){
                comfirm_add(5,'亲，请输入您的身份证号码！');
                pd=false;
            }else if(!reg_sfz.test(ll)){
                comfirm_add(5,'亲，请输入正确的身份证号码！');
                pd=false;
            }
        }
        if(pd){
            if(!proviceB){
                comfirm_add(5,'亲，请选择您所在的省份！');
            }else if(!cityB){
                comfirm_add(5,'亲，请选择您所在的地市！');
            }else if(!areaB){
                comfirm_add(5,'亲，请选择您所在的区县！');
            }else if(!detinfo){
                comfirm_add(5,'亲，请输入您的详细地址！');
            }else if(!peoName){
                comfirm_add(5,'亲，请输入联系人姓名！');
            }else if(!phone){
                comfirm_add(5,'亲，请填写您的联系手机号码！');
            }else if(!reg_phone.test(cc)){
                comfirm_add(5,'亲，请输入正确的手机号码！');
            }else if(!(email||reg_email.test(ee))){
                comfirm_add(5,'亲，请输入正确的邮箱地址！');
            }else{
                $.ajax({
                    type: "post",
                    dataType: 'json',
                    url: wqturl + '/saveUserContract.action',
                    data: {
                        'userContract.kind': kind,    //主体类别1:公司 2表示个人
                        'userContract.name': aa,   //kind=1表示企业名称 kind=2表示个人
                        'userContract.email': ee,
                        'userContract.certificatecode': bb,  //kind=1表示营业执照号码 kind=2表示个人身份证号码
                        'userContract.tel': dd,   //固定电话
                        'userContract.connector': jj,   //联系人
                        'userContract.mobileno': cc,   //联系电话
                        'userContract.explicitaddr': ii,   //详细地址
                        'userContract.province': ff,   //省份
                        'userContract.city': gg,   //地市
                        'userContract.area': hh   //区县
                        // 'userContract. isdefault': cc   //1表示为默认
                    },
                    success: function (data) {
                        if (data.result == 1) {
                            alert("添加成功");
                            window.location.reload();
                        } else if (data.result == 2) {
                            window.location.href = wqturl + "/casLogin?service=" + data.msg;
                        }else if(data.result==0){
                            comfirm_add(5,data.msg);
                        }
                    }
                })
            }
        }
    };



    //修改地址的内容初始化
    modify=function (id,i){
        //先除掉原先点击产生的selected
        $('#modify_province').children().removeAttr("selected");
        var aa="",bb="";
        $.ajax({
            'type':'post',
            'dataType':'json',
            'url':wqturl+'/oneContractInfo.action?id='+id,
            success:function(data){
                var data=data.msg;
                $(".subject .bargain_theme a[data-num="+i+"]").addClass('active').siblings().removeClass('active');
                $(".subject .bargain_theme a[data-num="+i+"]").siblings().hide();//主体类型不可修改
                if(data.kind=='1'){
                    $('#modify_qyNameA').val(data.name);
                    $("#modify_yynumberA").val(data.certificatecode);
                }else if(data.kind=='2'){
                    $('#modify_qyNameB').val(data.name);
                    $("#modify_yynumberB").val(data.certificatecode);
                }
                $('#modify_province').val(data.province);
                if(data.city!=null){
                    var proviceId=$('#modify_province').children("option[value="+data.province+"]").attr("name");
                    $.ajax({
                        type:'post',
                        url:wqturl+'/getCity.action',
						data:{
							'provinceid':proviceId
						},
                        success:function(citydata){
                            for(var i=0,len=citydata.length;i<len;i++){
                                aa += '<option value='+citydata[i].cityname+' name=' + citydata[i].id + '>' + citydata[i].cityname + '</option>';
                            };
                            $('#modify_city').html(aa);
                            //先除掉原先点击产生的selected
                            $('#modify_city').children().removeAttr("selected");
                            $('#modify_city').children("option[value="+data.recvcity+"]").attr("selected",true).siblings().removeAttr("selected");
                            var city=($('#modify_city').children("option[value="+data.city+"]").attr("name"));
                            if(data.area!=null){
                                $.ajax({
                                    type:'post',
                                    url:wqturl+'/getArea.action?cityid='+city,
                                    success:function(areadata){
                                        for(var i=0,len=areadata.length;i<len;i++) {
                                            bb += '<option name='+areadata[i].id+' value=' + areadata[i].areaname + '>' + areadata[i].areaname + '</option>';
                                        }
                                        $('#modify_area').html(bb);
                                        $('#modify_area').children().removeAttr("selected");
                                        $('#modify_area').children("option[value="+data.area+"]").attr("selected",true).siblings().removeAttr("selected");
                                    }
                                })
                            }
                        }
                    });
                }
                $('#modify_detinfo').val(data.explicitaddr);
                $('#modify_peoName').val(data.connector);
                $('#modify_peoPhone').val(data.mobileno);
                $('#modify_gdPhone').val(data.tel);
                $('#modify_email').val(data. email);
                // $('#modify .save').attr('onclick(update('+data.id+',enevt))');
            }
        })
    };

    //修改用户主体信息
    update=function(addrId){
        var kind=$("#subject .bargain_theme .active").attr("data-num");
        var uName = '',yynumber = '',phone = '',gdPhone='',email='',aa = '',bb = '',
            add_province='',add_city='',add_area='',cc = '',dd = '',ee = '',ff = '',gg='',hh='',ii='',jj='',pd=true;
        aa =$('#modify_qyNameA').val();//企业名称
        bb =$('#modify_yynumberA').val();//营业执照号码
        cc =$('#modify_peoPhone').val();//联系电话
        dd =$('#modify_gdPhone').val();//固定电话
        ee =$('#modify_email').val();  //邮箱
        ff =$('#modify_province').val();//省份
        gg =$('#modify_city').val();//地市
        hh =$('#modify_area').val();//区县
        ii=$('#modify_detinfo').val();//详细地址
        jj=$('#modify_peoName').val();//联系人
        kk=$('#modify_qyNameB').val(); //姓名
        ll=$("#modify_yynumberB").val();//身份证号码
        if(kind=='2'){
            aa=kk;
            bb=ll;
        }
        console.log(cc,ii,hh);
        uName=aa==''?false:true;
        yynumber=bb==''?false:true;
        phone=cc==''?false:true;
        gdPhone=dd==''?true:false;
        email=ee==''?true:false;
        add_province=ff=='请选择省份'?false:true;
        add_city=gg=='请选择地市'?false:true;
        add_area=hh=='请选择区县'?false:true;
        peoName=jj==''?false:true;
        detinfo=ii==''?false:true;
        qyNameB=kk==''?false:true;
        yynumberB=ll==''?false:true;
        if(kind=='1'){
            if(!uName){
                comfirm_add(5,'亲，请填写您的企业名称！');
                pd=false;
            }else if(!yynumber){
                comfirm_add(5,'亲，请填写您的营业执照号码！');
                pd=false;
            }
        }else if(kind=='2'){
            if(!qyNameB){
                comfirm_add(5,'亲，请输入您的姓名！');
                pd=false;
            }else if(!yynumberB){
                comfirm_add(5,'亲，请输入您的身份证号码！');
                pd=false;
            }else if(!reg_sfz.test(ll)){
                comfirm_add(5,'亲，请输入正确的身份证号码！');
                pd=false;
            }
        }
        if(pd){
            if(!(proviceB||add_province)){
                comfirm_add(5,'亲，请选择您所在的省份！');
            }else if(!(cityB||add_city)){
                comfirm_add(5,'亲，请选择您所在的地市！');
            }else if(!(areaB||add_area)){
                comfirm_add(5,'亲，请选择您所在的区县！');
            }else if(!detinfo){
                comfirm_add(5,'亲，请输入您的详细地址！');
            }else if(!peoName){
                comfirm_add(5,'亲，请输入联系人姓名！');
            }else if(!phone){
                comfirm_add(5,'亲，请填写您的联系手机号码！');
            }else if(!reg_phone.test(cc)){
                comfirm_add(5,'亲，请输入正确的手机号码！');
            }else if(!(email||reg_email.test(ee))){
                comfirm_add(5,'亲，请输入正确的邮箱地址！');
            }else{
                $.ajax({
                    type: "post",
                    dataType: 'json',
                    url: wqturl + '/updateUserContract.action',
                    data: {
                        'userContract.id': addrId,
                        'userContract.kind': kind,    //主体类别1:公司 2表示个人
                        'userContract.name': aa,   //kind=1表示企业名称 kind=2表示个人
                        'userContract.email': ee,
                        'userContract.certificatecode': bb,  //kind=1表示营业执照号码 kind=2表示个人身份证号码
                        'userContract.tel': dd,   //固定电话
                        'userContract.connector': jj,   //联系人
                        'userContract.mobileno': cc,   //联系电话
                        'userContract.explicitaddr': ii,   //详细地址
                        'userContract.province': ff,   //省份
                        'userContract.city': gg,   //地市
                        'userContract.area': hh   //区县
                        // 'userContract. isdefault': cc   //1表示为默认
                    },
                    success: function (data) {
                        if (data.result == 1) {
                            alert("添加成功");
                            window.location.reload();
                        } else if (data.result == 2) {
                            window.location.href = wqturl + "/casLogin?service=" + data.msg;
                        }else if(data.result==0){
                            comfirm_add(5,data.msg);
                        }
                    }
                })
            }
        }
    };


})();

//    将地址设置为默认地址
function def(id,i){
    $.ajax({
        'type':'post',
        'dataType':'json',
        'url':wqturl+'/updateUserContract.action',
        data:{
            'userContract.id':id,
            'userContract.isdefault': i
        },
        success:function(data){
            if(i=='1'){
                $('.confirm').show();
                setTimeout(function(){
                    $('.confirm').hide();
                },500);
            }
        }
    })
}

//删除用户寄件地址
function delAddr(addrId){
    var r=confirm("亲，确认删除这个主体吗？");
    if(r==true){
        $.ajax({
            'type':'post',
            'dataType':'json',
            'url':wqturl+'/delUserContract.action?id='+addrId,
            success:function(data){
                if(data.result==1){
                    window.location.reload();
                }else if(data.result==2){
                    window.location.href = wqturl + "/casLogin?service=" + data.msg;
                }
            }
        })
    }
};