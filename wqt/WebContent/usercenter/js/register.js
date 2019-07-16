/**
 * Created by Administrator on 2017/11/29.
 */

var service="";
$(function () {
    service=getParameter('service');
});
function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};

var newsid=getParameter('newsid');

// (function(){
//     $('.service_select').on('click','span',function(){
//         $(this).addClass('aim').siblings().removeClass('aim');
//     });
//
//     $('.pwd label').on('click','a',function(e){
//         e.preventDefault();
//         $(this).parent().parent().hide().siblings().show();
//     })
// })();

//点击验证码切换图片
$(   $(".verify_picture_n").click(function(){
        $(this).attr("src","http://www.w7tong.com/jsp/validatecode.jsp?"+((new Date()).getTime()))
    })
);

/**********************************引用的js******************************/

/*register*/
$(document).ready(function(){
    var passV = "";
    var phoneV = "";
    var phoneVerifyV = "";
    // var passB = false ;
    var passFB = false ;
    var phoneB = false ;
    var phoneVerifyB = false ;
    var nowTime = 0;
    var pVsTimer = null;
    var btn_1=true;//只动态码错误才停止60s
    /*账号申请匹配规则*/
    var reg = {
        'user':/^[a-zA-Z][0-9A-Za-z]{5,17}$/,//字母开头的6-18位账号
        'pass':/^[\!\"\#\$\%\&\'\(\)\*\+\,\-\.\/\:\;\<\=\>\?\@\[\\\]\^\`\{\|\}\~\w]{6,16}$/,/*6到16位的密码*/
        'phone':/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/,
        'phoneVerify':/^\d{4}$/,
        'pass1':/[a-zA-Z]+/gi,
        'pass2':/[0-9]+/gi,
        'pass3':/[\!\"\#\$\%\&\'\(\)\*\+\,\-\.\/\:\;\<\=\>\?\@\[\\\]\^\`\{\|\}\~]+/gi
    };
    var uu=window.location.href.split('=')[1]==undefined? '':'?service='+window.location.href.split('=')[1];
    $('.logg').attr('href',wqturl+'/user/login.html'+uu);



    // /**************密码的验证************/
    // $("input.Pwd").blur(passFn);

    /*pass匹配*/
    // function passFn(){
    //     passV = $(this).val();
    //     if(passV==null||passV=="")
    //     {
    //         $("dl.pI").hide();
    //         $("#sloginPass").html("请输入密码");
    //         $("#ishow2 span").addClass("icoNo").show();
    //         passB = false;
    //     }else{
    //         if ( reg[this.name+''].test(passV) )
    //         {
    //             if( (passV.match(reg.pass1)==null&&passV.match(reg.pass2)==null)||(passV.match(reg.pass2)==null&&passV.match(reg.pass3)==null)||(passV.match(reg.pass1)==null&&passV.match(reg.pass3)==null)){
    //                 $("#sloginPass").html("密码简单，有被盗的风险");
    //                 $("#ishow2 span").removeClass("icoNo").show();
    //                 $("dl.pI").show();
    //                 $("dl.pI span.pIntensionS3").addClass("active");
    //                 $("dl.pI span.pIntensionS2").removeClass("active");
    //                 $("dl.pI span.pIntensionS1").removeClass("active");
    //             }else if(passV.match(reg.pass1)==null||passV.match(reg.pass2)==null||passV.match(reg.pass3)==null){
    //                 $("#sloginPass").html("密码强");
    //                 $("#ishow2 span").removeClass("icoNo").show();
    //                 $("dl.pI").show();
    //                 $("dl.pI span.pIntensionS3").addClass("active");
    //                 $("dl.pI span.pIntensionS2").addClass("active");
    //                 $("dl.pI span.pIntensionS1").removeClass("active");
    //             }else if( !(passV.match(reg.pass1)==null&&passV.match(reg.pass2)==null&&passV.match(reg.pass3)==null) ){
    //                 $("#sloginPass").html("密码很强");
    //                 $("#ishow2 span").removeClass("icoNo").show();
    //                 $("dl.pI").show();
    //                 $("dl.pI span.pIntensionS3").addClass("active");
    //                 $("dl.pI span.pIntensionS2").addClass("active");
    //                 $("dl.pI span.pIntensionS1").addClass("active");
    //             }
    //             passB = true;
    //         }else{
    //             $("dl.pI").hide();
    //             $("#sloginPass").html("请输入6-16位密码");
    //             $("#ishow2 span").addClass("icoNo").show();
    //             passB = false;
    //         }
    //     }
    // };



    /*phone匹配*/
    $("#phone").blur(function(){
        phoneV = $(this).val();
        if(phoneV==null||phoneV=="")
        {
            $(".error04").html("请输入您的手机号码");
            phoneB = false;
        }else{
            if ( reg.phone.test(phoneV) )
            {
                $(".error04").html("");
                phoneB = true;
            }else{
                $(".error04").html("请正确填写手机号码");
                phoneB = false;
            }
        }
    });


    /*phoneVerify匹配*/
    $(".form_dt input").blur(function(){
        phoneVerifyV = $(this).val();//获取动态码
        (phoneVerifyV==null||phoneVerifyV=='')?phoneVerifyB=false:phoneVerifyB=true;
    });

    /*点击获取手机验证码*/
    $(".form_dt a.ddd").click(function(){
        phoneVerifyAjax();
    });


    /*phoneAjax*/
    // function mobileAjax(){
    //     $.ajax({
    //         type:"POST",
    //         url:wqturl+"/checkMobile",
    //         dataType:'json',
    //         data:{
    //             'mobileno':phoneV
    //         },
    //         success:function(data, status){
    //              console.log(data);
    //             if(data.result=='1'){
    //                 $(".error_reminder").css("visibility","visible");
    //                 $(".error_reminder div").html("对不起，号码已注册");
    //                 phoneB = false;
    //             }else if (data.result=='2'){
    //                 $(".error_reminder").css("visibility","hidden");
    //                 // $(".error_reminder div").html("号码可以使用");
    //                 phoneB = true;
    //                 console.log('result');
    //                 phoneVerifyAjax()
    //             }
    //         },
    //         error:function(result){
    //             console.log(result.responseText);
    //             console.log(result);
    //             console.log(status);
    //         }
    //     });
    // };


    /*phoneVerifyAjax*/
    function phoneVerifyAjax(){
        var picyzm=$(".yz_txm").val();//图形码
        if(phoneV==null||phoneV=="")
        {
            $(".error04 ").html("请输入您的手机号码");
            $("#phone").focus();
            phoneB = false;
        }else if(picyzm==''){
            $(".error05").html("请输入图形码");
            $(".yz_txm").focus();
        }else{
            if ( reg.phone.test(phoneV) && btn_1)
            {
                $(".error00").html("");
                phoneB = true;
                $.ajax({
                    type:"POST",
                    url:wqturl+"/regSmsCode.action",
                    dataType:"json",
                    data:{
                        'mobile':phoneV,
                        'validateCode':picyzm
                    },
                    success:function(data, status){
                        if(data.result==0){
                            $('.error05').html('图形码错误');
                            $('.yz_txm').focus();
                            phoneVerifyB=false;
                            btn_1=true;
                        }else if (data.result==1){
                            if( new Date().getTime()-nowTime >= 62000&&phoneB){
                                nowTime = new Date().getTime();
                                btn_1=false;
                                $(".error00").html("");
                                $(".form_dt a").css("background","#808080");
                                $(".form_dt a").html("重新发送（<span>"+60+"</span>s）");
                                var pVs = parseInt( $(".form_dt a span").html() );
                                clearInterval(pVsTimer);
                                function pStime(){
                                    $(".form_dt a span").html(pVs);
                                    pVs--;
                                    if(pVs==-1){
                                        clearInterval(pVsTimer);
                                        phoneVerifyB=false;
                                        btn_1=true;
                                        $('.verify_picture_n').attr("src","http://www.w7tong.com/jsp/validatecode.jsp?"+((new Date()).getTime()));//刷新图形码
                                        $(".form_dt a").html("获取动态码").css("background","linear-gradient(to right,#fb414e,#ff7b66 )");
                                    }
                                };
                                pStime();
                                pVsTimer = setInterval(pStime,1000);
                                phoneVerifyB=true;
                            }
                        }else if(data.result==2){
                            btn_1=true;
                            $('.verify_picture_n').attr("src","http://www.w7tong.com/jsp/validatecode.jsp?"+((new Date()).getTime()));//刷新图形码
                            $('.error04').html(data.msg);
                            $('#phone').focus();
                        };
                    }
                });
            }else if(!reg.phone.test(phoneV)){
                $(".error04").html("请正确填写手机号码");
                $("#phone").focus();
                phoneB = false;
            }
        }
    };
    // $(".eye").click(function () {
    //     if($(this).attr('data-eye')==0){
    //         $(this).attr('data-eye','1');
    //         $(this).children().attr('src',wqturl+'/usercenter/image/show.png');
    //         $(this).prev().attr('type','text');
    //     }else{
    //         $(this).attr('data-eye','0');
    //         $(this).children().attr('src',wqturl+'/usercenter/image/pwd_eye.png');
    //         $(this).prev().attr('type','password');
    //     }
    // });

    /*立即注册按钮点击*/
    function register(){
        /*相关的正则验证通过后才能点击注册*/
        passV=$(".yz_passworld").val();
        phoneV=$('#phone').val();
        if(phoneV=='' || phoneV==null){
            $('.error04').html('请输入您的手机号码');
            $('#phone').focus();
        }else if(!reg.phone.test(phoneV)){
            $('.error04').html('请正确填写手机号码');
            $('#phone').focus();
        }else if(passV==''){
            $('.error07').html('密码不能为空');
            $('.yz_passworld').focus();
        }else if(!reg.pass.test(passV)){
            $('.error07').html('请输入6到16位的密码');
            $('.yz_passworld').focus();
        }else if(phoneB && phoneVerifyB){
            $('.error00').html("");
            // btn_1 = !btn_1;
            $.ajax({
                type:"post",
                url:wqturl+"/userRegister.action",
                data:{
                    'wqtuser.password':passV,
                    'wqtuser.mobileno':phoneV,
                    'wqtuser.smscode':phoneVerifyV
                },
                error:function(XmlHttpRequest,textStatus,errorThrown){
                    console.log(XmlHttpRequest.status);
                },
                success:function(data,status){
                    if(data.result==0)
                    {
                        alert(data.msg);
                    }
                    else if(data.result==1)
                    {
                        var a=decodeURIComponent(window.location.href.split('=')[1]);
                        alert("恭喜您，注册成功！");
                        window.location.href=a;
                    }
                    else if(data.result==2)
                    {
                        alert(data.msg)
                    };
                }
            });
        }else{
            alert("请完整填写注册信息");
        }
    };

    $("#register_btn").click(register);
    $(document).keyup(function(event){
        if(event.keyCode==13){
            register();
        }
    });

});
