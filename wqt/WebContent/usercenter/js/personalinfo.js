var email=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/,
    phone=/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/,
    yhm=/^[\!\"\#\$\%\&\'\(\)\*\+\,\-\.\/\:\;\<\=\>\?\@\[\\\]\^\`\{\|\}\~\w]{6,16}$/,//用户名格式6-16
    nameA=true,//判断用户名格式
    nowTime='',
    pVsTimer='',
    verifyTime='',
    uname=$("#username").val(),//判断用户是否修改了用户名
    nameB=true;//判断用户名是否已注册
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
$(
    $(".bj").click(function(){
        $(".inf").eq(0).hide();
        $(".inf").eq(1).show();
    }),
    $(".qx").click(function(){
        $(".inf").eq(1).hide();
        $(".inf").eq(0).show();
    }),
    // 日期控件
    layui.use('laydate',function(){
        var laydate=layui.laydate;
        laydate.render({
            elem: 'input[name="inp_date"]'
        });
    }),
    $("#bc_info").click(function () {
        var nc_name=$(".nc_name").val(),
            gender=$("input[name='gender']:checked").val(),
            date=$("input[name='inp_date']").val(),
            inp_email=$(".inp_email").val(),
            qq=$(".inp_qq").val(),
            nname=$("#username").val(),
            wechat=$(".wechat").val();
        if(nameB==false || nameA==false){
            comfirm_add(5,'用户名输入有误或者已被注册')
        }else if( inp_email !== '' ){
            if(!email.test(inp_email)){
                comfirm_add(5,'请注意邮箱格式')
            }else{
                $.ajax({
                    type:'post',
                    url:wqturl+'/editUser.action',
                    dataType:'json',
                    data:{
                        'wqtuser.username':nname,
                        'wqtuser.email':inp_email,
                        'wqtuser.sex':gender,
                        'wqtuser.nickname':nc_name,
                        'wqtuser.qq':qq,
                        'wqtuser.weixin':wechat,
                        'wqtuser.birthday':date
                    },
                    success:function(data){
                        if(data.result==1){
                            alert(data.msg);
                            window.location.reload();
                        }else if(data.result==2){
                            comfirm_add(5,data.msg);
                        }else if(data.result==0){
                            comfirm_add(5,data.msg);
                        }

                    },
                    error:function(){
                        console.log('error');
                    }
                })
            }
        }else{
            $.ajax({
                type:'post',
                url:wqturl+'/editUser.action',
                dataType:'json',
                data:{
                    'wqtuser.username':nname,
                    'wqtuser.email':inp_email,
                    'wqtuser.sex':gender,
                    'wqtuser.nickname':nc_name,
                    'wqtuser.qq':qq,
                    'wqtuser.weixin':wechat,
                    'wqtuser.birthday':date
                },
                success:function(data){
                    if(data.result==1){
                        alert(data.msg);
                        window.location.reload();
                    }else if(data.result==2){
                        comfirm_add(5,data.msg);
                    }else if(data.result==0){
                        comfirm_add(5,data.msg);
                    }
                },
                error:function(a){
                    console.log(a);
                }
            })
        }
    }),
    //验证用户名是否可用
    $("#username").blur(function(){
        var username=$("#username").val();
        if(!yhm.test(username)){
            nameA=false;
            comfirm_add(5,'用户名格式错误，请输入（6-16字符）');
        }else{
            nameA=true;
        }
        if(uname==username){
            nameB=true;
        }else if(nameB==true && nameA==true){
            $.ajax({
                type:'post',
                url:wqturl+'/checkUsername.action',
                dataType:'json',
                data:{
                    'username':username
                },
                success:function(data){
                    if(data.result==1){
                        nameB=false;
                        comfirm_add(5,data.msg);
                    }else if(data.result==2){
                        nameB=true;
                        comfirm_add(6,data.msg);
                    }
                },
                error:function(){
                    nameB=false;
                    console.log(error);
                }
            })
        }
    })
);
    // //修改手机号
    // $(".alder").click(function(){
    //     $(".inf").hide();
    //     $(".xg_mobile").show();
    //     $(".cont_tab .on").html("验证手机号");
    // }),
    // $(".qx_btn").click(function(){
    //     $(".cont_tab .on").html("基本资料");
    //     $(".sj_yzm").val("");
    //     $(".inf").eq(0).show();
    //     $(".inf").eq(1).hide();
    //     $(".xg_mobile").hide();
    //     $(".xg_mobile ul li").eq(0).show().siblings().hide();
    // }),
    // 验证手机号
    /*点击获取旧手机验证码*/
    // $(".already_yzm a").click(function(){
    //     if( new Date().getTime()-nowTime >= 62000){
    //         nowTime = new Date().getTime();
    //         oldphone();
    //     }
    // }),
    // //点击获取新手机验证码
    // $(".verify_yzm a").click(function(){
    //     if( new Date().getTime()-verifyTime >= 62000){
    //         verifyTime = new Date().getTime();
    //         newphone();
    //     }
    // }),
    // $(".sj_yzm").keydown(function(event){
    //     if(event.keyCode==13){
    //         oldYzm();
    //     }
    // }),
    // $(".sj_yzm").keydown(function(event){
    //     if(event.keyCode==13){
    //         oldYzm();
    //     }
    // }),
    // $(".new_yzm").keydown(function(event){
    //     if(event.keyCode==13){
    //         newYzm();
    //     }
    // })
//发送旧手机验证码
// function oldphone(){
//     $.ajax({
//         type:'post',
//         url:wqturl+"/smsCode",
//         dataType:'json',
//         data:{},
//         success:function(data){
//             if (data.msg==1){
//                 $(".already_yzm a").css("background","#888888");
//                 $(".already_yzm a").html("重新发送（<span>"+60+"</span>s）");
//                 var pVs = parseInt( $(".already_yzm a span").html() );
//                 clearInterval(pVsTimer);
//                 function pStime(){
//                     $(".already_yzm a span").html(pVs);
//                     pVs--;
//                     if(pVs==-2){
//                         clearInterval(pVsTimer);
//                         $(".already_yzm a").html("免费获取校验码").css("background","#f3f3f3");
//                     }
//                 };
//                 pStime();
//                 pVsTimer = setInterval(pStime,1000);
//             }
//         },
//         error:function(readyState){
//             console.log(readyState)
//         }
//     })
// };
// //发送新手机验证码
// function newphone(){
//     var new_phone=$(".new_phone").val();
//     if(new_phone==''){
//         comfirm_add(5,'请输入新手机号码')
//     }else if(!phone.test(new_phone)){
//         comfirm_add(5,'请输入正确的手机号码')
//     }else{
//         $.ajax({
//             type:'post',
//             url:wqturl+"/smsCode",
//             dataType:'json',
//             data:{
//                 'mobile':new_phone
//             },
//             success:function(data){
//                 if (data.msg==1){
//                     $(".verify_yzm a").css("background","#888888");
//                     $(".verify_yzm a").html("重新发送（<span>"+60+"</span>s）");
//                     var pVs = parseInt( $(".verify_yzm a span").html() );
//                     clearInterval(pVsTimer);
//                     function pStime(){
//                         $(".verify_yzm a span").html(pVs);
//                         pVs--;
//                         if(pVs==-2){
//                             clearInterval(pVsTimer);
//                             $(".verify_yzm a").html("免费获取校验码").css("background","#f3f3f3");
//                         }
//                     };
//                     pStime();
//                     pVsTimer = setInterval(pStime,1000);
//                 }else{
//                     alert("系统错误");
//                 }
//             },
//             error:function(readyState){
//                 console.log(readyState)
//             }
//         })
//     }
// };
// // 提交验证旧手机
// function oldYzm(){
//     $("#btn_inp_yzm").removeAttr("onclick");
//     var timer1=window.setTimeout(function(){
//         $("#btn_inp_yzm").attr("onclick","oldYzm()");
//         window.clearTimeout(timer1);
//         timer1=null;
//     },10000);
//     var yzm=$(".sj_yzm").val();
//     $.ajax({
//         type:'post',
//         url:wqturl+'/confirmUserMobile',
//         dataType:'json',
//         data:{
//             'smscode':yzm
//         },
//         success:function(data){
//             if(data.result==1){
//                 $(".cont_tab ul li.on").html('修改手机号');
//                 $(".xg_mobile ul li").eq(1).show().siblings().hide();
//                 $(".sj_yzm").val('');
//             }else if(data.result==2){
//                 comfirm_add(5,'验证码输入错误或已超时');
//             }else if(data.result==0){
//                 comfirm_add(5,'系统异常');
//             }
//         },
//         error:function(error){
//             console.log(error);
//         }
//     })
// }
// // 提交验证新手机
// function newYzm(){
//     $("#btn_yzm").removeAttr("onclick");
//     var timer1=window.setTimeout(function(){
//         $("#btn_yzm").attr("onclick","newYzm()");
//         window.clearTimeout(timer1);
//         timer1=null;
//     },10000);
//     var yzm=$(".new_yzm").val(),
//         new_phone=$(".new_phone").val();
//     $.ajax({
//         type:'post',
//         url:wqturl+'/updateUserMobile',
//         dataType:'json',
//         data:{
//             'smscode':yzm,
//             'mobile':new_phone
//         },
//         success:function(data){
//             if(data.result==1){
//                 alert('恭喜，修改成功');
//                 window.location.reload();
//                 $(".new_yzm").val('');
//                 $(".new_phone").val('');
//             }else if(data.result==2){
//                 comfirm_add(5,'验证码输入错误或已超时');
//             }else if(data.result==0){
//                 comfirm_add(5,'系统异常');
//             }
//         },
//         error:function(error){
//             console.log(error);
//         }
//     })
// }