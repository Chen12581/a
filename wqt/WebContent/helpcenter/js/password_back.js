
$(function () {  
    //点击验证码切换图片
    $("#verify_picture").click(function(){
        $(this).attr("src","http://www.w7tong.com/jsp/validatecode.jsp?"+((new Date()).getTime()))
    })
})

//验证
var mobileReg=/^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
var isexist=0;
var ismathCode=0;
var issuccess=0;
$("#phone").blur(function () {  
    if($(this).val()==""||$(this).val()==undefined){
        $(".cover,.hint1").show();
        $(".hint1").children().html("请输入手机号码！");
        setTimeout(function () {  
            $(".cover,.hint1").hide();
        },3000)
        isexist=0;

    }else if(!mobileReg.test($(this).val())){
        $(".cover,.hint1").show();
        $(".hint1").children().html("输入的手机号码格式不正确！");
        setTimeout(function () {  
            $(".cover,.hint1").hide();
        },3000)
        isexist=1;
    }else{
        var mobile=$(this).val();
        $.ajax({
            type:"POST",
            url:wqturl+"/checkMobile.action",
            dataType:"json",
            data:{
                'mobileno':mobile
            },
            success:function (data) {  
                if(data.result==1){
                    isexist=6;
                    //console.log(data.msg+"c1");
                }else if(data.result==2){
                    isexist=2;
                    $(".cover,.hint1").show();
                    $(".hint1").children().html(mobile+"不是注册账号");
                    setTimeout(function () {  
                        $(".cover,.hint1").hide();
                    },3000)
                }else if(data.result==3){
                    isexist=3;
                    $(".cover,.hint1").show();
                    $(".hint1").children().html(data.msg);
                    setTimeout(function () {  
                        $(".cover,.hint1").hide();
                    },3000)
                }
            }
        })
    }
})
$("#mathCode").blur(function () {  
    if($(this).val()==""||$(this).val()==undefined){
        ismathCode=0;
    }else{
        ismathCode=1;
    }
})
//获取验证码
function getCode() {  
   if(!$("#verifyCode").prop("disabled") ) {
        console.log(isexist,ismathCode); 
        if((isexist==6||isexist==5)&&ismathCode==1){
            var mobile=$("#phone").val();
            var validateCode=$("#mathCode").val();
            console.log(mobile,validateCode);
            $.ajax({
                type:'POST',
                url:wqturl+'/commonSmsCode.action',
                data:{
                    'mobile':mobile,
                    'validateCode':validateCode
                },
                success:function (data) {  
                    if(data.result==0){
                        $(".cover,.hint1").show();
                        $(".hint1").children().html(data.msg);
                        setTimeout(function () {  
                            $(".cover,.hint1").hide();
                        },3000)
                    }else if(data.result==1){
                        issuccess=1;
                        $(".cover,.hint1").show();
                        $(".hint1").children().html(data.msg);
                        setTimeout(function () {  
                            $(".cover,.hint1").hide();
                        },3000)
                        //alert(data.msg + "1");
                        var secs=60;
                        var o=$("#verifyCode");
                        function count(o) {  
                            if(secs==0){
                                o.attr("disabled",false);
                                o.html("获取验证码");
                                secs=60;
                                o.attr("onclick","getCode()")
                            }else{
                                o.attr("disabled",true);
                                o.removeAttr("onclick");
                                isexist=5;
                                o.html("重新发送("+secs+"秒)");  
                                secs--;
                                setTimeout(function () {  
                                    count(o);
                                },1000)
                            }
                        }
                        count(o);
                    }else if(data.result==2){
                        console.log(data);
                        $(".cover,.hint1").show();
                        $(".hint1").children().html(data.msg);
                        setTimeout(function () {  
                            $(".cover,.hint1").hide();
                        },3000)
                    }
                }
            })
        }else if(ismathCode==0){
            $(".cover,.hint1").show();
            $(".hint1").children().html("请输入验证码！");
            setTimeout(function () {  
                $(".cover,.hint1").hide();
            },3000)
        }else if(isexist==0){
            $(".cover,.hint1").show();
            $(".hint1").children().html("请输入手机号码");
            setTimeout(function () {  
                $(".cover,.hint1").hide();
            },3000)
        }else if(isexist==1){
            $(".cover,.hint1").show();
            $(".hint1").children().html("手机号码格式不正确");
            setTimeout(function () {  
                $(".cover,.hint1").hide();
            },3000)
        }else if(isexist==2){
            $(".cover,.hint1").show();
            $(".hint1").children().html(mobile+"不是注册账号");
            setTimeout(function () {  
                $(".cover,.hint1").hide();
            },3000)
        }
   }
}
//身份验证下一步
$("#firstSubmit").click(function(){
    var smscode = $("#phoneCode").val();
    var mobile=$("#phone").val();
    //console.log(mobile+'--'+smscode);
    console.log(isexist);
    if(!(smscode==""||smscode==undefined)){
        if(isexist==5&&ismathCode==1&&issuccess==1){
            $.ajax({
                type:"POST",
                url:wqturl+"/findPasswordnext.action",
                data:{
                    'mobile':mobile,
                    'smscode':smscode
                },
                success:function (data) {  
                    //console.log(data);
                    if(data.result==1){
                        $(".get_procedure>ul>li").eq(1).addClass("on").siblings().removeClass("on");
                        $(".newPass").show().prev().hide();
                    }else if(data.result==0){
                        $(".cover,.hint1").show();
                        $(".hint1").children().html(data.msg);
                        setTimeout(function () {  
                            $(".cover,.hint1").hide();
                        },3000)
                    }else if(data.result==2){
                        $(".cover,.hint1").show();
                        $(".hint1").children().html(data.msg);
                        setTimeout(function () {  
                            $(".cover,.hint1").hide();
                        },3000)
                    }
                }
            })
        }else if(isexist==0){
            $(".cover,.hint1").show();
            $(".hint1").children().html("请输入手机号码");
            setTimeout(function () {  
                $(".cover,.hint1").hide();
            },3000)    
        }else if(isexist==1){
            $(".cover,.hint1").show();
            $(".hint1").children().html("手机号码格式不正确");
            setTimeout(function () {  
                $(".cover,.hint1").hide();
            },3000)
        }else if(isexist==2){
            $(".cover,.hint1").show();
            $(".hint1").children().html(mobile+"不是注册账号");
            setTimeout(function () {  
                $(".cover,.hint1").hide();
            },3000)
        }else if(ismathCode==0){
            $(".cover,.hint1").show();
            $(".hint1").children().html("请输入验证码");
            setTimeout(function () {  
                $(".cover,.hint1").hide();
            },3000)
        }
    }else{
        $(".cover,.hint1").show();
        $(".hint1").children().html("请填写手机验证码");
        setTimeout(function () {  
            $(".cover,.hint1").hide();
        },3000)
    }
    
})

//重置密码
var pass1=false;
var pass2=false;
var myReg =  /^[\w]{6,12}$/;
$("#pass").blur(function () {  
    if($(this).val()==""||$(this).val()==undefined){
        $(this).next().html("请填写新密码！");
    }else if($(this).val().length<6){
        $(this).next().html("密码长度必须大于6个字符");
    }else if(!myReg.test($(this).val())){
        $(this).next().html("密码只支持大小写字母数字下划线！");
    }else{
        $(this).next().html("");
        pass1=true;
    }
})
$("#qpass").blur(function () {  
    if($(this).val()==""||$(this).val()==undefined){
        $(this).next().html("请再次确认密码！");
    }else if(!($("#pass").val()==""||$("#pass").val()==undefined)){
        if($("#pass").val()==$(this).val()){
            $(".newPass .error").html("");
            pass2=true
        }else{
            $(this).next().html("两次密码不一致!");
        }
    }
})
$("#secondSubmit").click(function () {  
    if(!pass1){
        $(".cover,.hint1").show();
        $(".hint1").children().html("请填写新密码！");
        setTimeout(function () {  
            $(".cover,.hint1").hide();
        },3000)
    }else if(!($("#qpass").val()==""||$("#qpass").val()==undefined)){
        if(!pass2){
            $(".cover,.hint1").show();
            $(".hint1").children().html("两次密码不一致！");
            setTimeout(function () {  
                $(".cover,.hint1").hide();
            },3000)
        }else{
            var mobile=$("#phone").val();
            console.log(mobile);
            var password=$("#qpass").val();
            $.ajax({
                type:"POST",
                url:wqturl+"/updatePassword.action",
                data:{
                    'mobile':mobile,
                    'password':password
                },
                success:function(data){
                    if(data.result==0){
                        $(".cover,.hint1").show();
                        $(".hint1").children().html(data.msg);
                        setTimeout(function () {  
                            $(".cover,.hint1").hide();
                        },3000)
                    }else if(data.result==1){
                        $(".get_procedure>ul>li").eq(2).addClass("on").siblings().removeClass("on");
                        $(".reset_success").show().prev().hide();
                        var s=3;
                        function countDown() {  
                            if(s==0){
                                window.location.href='http://www.w7tong.com/user/helpcenter.html';
                                s=3;
                            }else{
                                $(".reset_success .secs").html(s);
                                s--;
                                setTimeout(function () {  
                                    countDown();
                                },1000)
                            }
                        }
                        countDown();
                    }else if(data.result==2){
                        $(".cover,.hint1").show();
                        $(".hint1").children().html(data.msg);
                        setTimeout(function () {  
                            $(".cover,.hint1").hide();
                        },3000)
                    }
                }
            })
        }
    }else{
        $(".cover,.hint1").show();
        $(".hint1").children().html("请再次确认密码！");
        setTimeout(function () {  
            $(".cover,.hint1").hide();
        },3000)
    }
})

