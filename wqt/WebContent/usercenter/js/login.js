var reg=/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;//手机号码验证
var nowTime = 0;
var pVsTimer = null;
var lgg=false;//用于判断重复点击动态码
var url=window.location.href.split('=')[1]==undefined? '' : '?service='+window.location.href.split('=')[1];
var threeuser=window.location.href.split('=')[1]==undefined? '' : '&sourcefrom='+window.location.href.split('=')[1];
$('.login_zfb').attr('href',$('.login_zfb').attr('href')+threeuser);
$(
    $('.regg').attr('href',wqturl+'/user/register.html'+url),
    $('.login_tit').on('click','span',function(){
        var i=$(this).index();
        if(!$(this).is('.on')){
            $(this).addClass('on').siblings().removeClass('on');
            $('.login_form .fonm_cont').eq(i).show().siblings('.fonm_cont').hide();
        }
    }),
    //点击验证码切换图片
    $(   $(".verify_picture").click(function(){
            $(this).attr("src","http://www.w7tong.com/jsp/validatecode.jsp?"+((new Date()).getTime()))
        })
    ),
    $(   $(".verify_picture_n").click(function(){
            $(this).attr("src","http://www.w7tong.com/jsp/validatecode.jsp?"+((new Date()).getTime()))
        })
    ),
    //账号密码登录验证
    $('.zh_phone').blur(function () {
       if($(this).val()==''){
           $('.form_phone .error01').html('请输入账号');
       }else{
           $('.form_phone .error01').html('');
       }
    }),
    $('.zh_passworld').blur(function () {
        if($(this).val()==''){
            $('.form_passworld .error02').html('请输入密码');
        }else{
            $('.form_passworld .error02').html('');
        }
    }),
    $('.zh_yzm').blur(function () {
        if($(this).val()==''){
            $('.form_yzm .error03').html('请输入图形码');
        }else{
            $('.form_yzm .error03').html('');
        }
    }),
    //验证码登录验证
    $('.yz_phone').blur(function () {
        if($(this).val()==''){
            $('.form_phone .error04').html('请输入手机号');
        }else if(!reg.test($(this).val())){
            $('.form_phone .error04').html('请输入正确的手机号');
        }else{
            $('.form_phone .error04').html('');
        }
    }),
    $('.yz_txm').blur(function () {
        if($(this).val()==''){
            $('.form_yzm .error05').html('请输入图形码');
        }else {
            $('.form_yzm .error05').html('');
        }
    }),
    $('.yz_yzm').blur(function () {
        if($(this).val()==''){
            $('.form_dt .error06').html('请输入验证码');
        }else{
            $('.form_dt .error06').html('');
        }
    }),
    // 账号登录
    $('#zh_login').click(function(){
        var phone=$('.zh_phone').val(),
            pass=$('.zh_passworld').val()==''? '':$.md5($('.zh_passworld').val()),
            yzm=$('.zh_yzm').val(),
            service=window.location.href.split('=')[1]===undefined?'':window.location.href.split('=')[1];
        if(phone==''){
            $('.form_phone .error01').html('请输入账号');
            $('.zh_phone').focus();
        }else if(pass==''){
            $('.form_passworld .error02').html('请输入密码');
            $('.zh_passworld').focus();
        }else if(yzm==''){
            $('.form_yzm .error03').html('请输入图形码');
            $('.zh_yzm').focus();
        }else{
            $.ajax({
                type:'post',
                url:wqturl+'/userlogin.action',
                dataType:'json',
                data:{
                    'userparam':phone,
                    'password':pass,
                    'validateCode':yzm,
                    'service':service
                },
                success:function(data){
                    console.log(data);
                    if(data.result==5){
                        $('.form_yzm .error03').html('图形码错误');
                        $('.zh_yzm').focus();
                    }else if(data.result==1){
                        $('.form_phone .error01').html('此账号不存在');
                        $('.zh_phone').focus();
                    }else if(data.result==2){
                        $('.form_passworld .error02').html('密码错误');
                        $('.zh_passworld').focus();
                    }else if(data.result==3){
                        window.location.href=data.msg;
                    }
                },
                error:function(error){
                    console.log(error);
                }
            })
        }
    }),
    $('.zh_lg input').keyup(function (event) {
        if(event.keyCode==13){
            $('#zh_login').click();
        }
    }),
    //获取动态码
    $('.ddd').click(function () {
        var phone=$('.yz_phone').val(),
            txm=$('.yz_txm').val();
        if(phone==''){
            $('.form_phone .error04').html('请输入手机号');
            $('.yz_phone').focus();
        }else if(!reg.test(phone)){
            $('.form_phone .error04').html('请输入正确的手机号');
            $('.yz_phone').focus();
        }else if(txm==''){
            $('.form_yzm .error05').html('请输入图形码');
            $('.yz_txm').focus();
        }else if(lgg){

        }else{
            $.ajax({
                type:'post',
                url:wqturl+'/loginSmsCode.action',
                dataType:'json',
                data:{
                    'mobile':phone,
                    'validateCode':txm
                },
                success:function (data) {
                    if(data.result==0){
                        $('.form_yzm .error05').html('图形码输入错误');
                        $('.yz_txm').focus();
                    }else if(data.result==1){
                        lgg=true;
                        if( new Date().getTime()-nowTime >= 62000){
                            nowTime = new Date().getTime();
                            $(".form_dt a.ddd").css("background","#919195");
                            $(".form_dt a.ddd").html("重新发送（<span>"+60+"</span>s）");
                            var pVs = parseInt( $(".form_dt a.ddd span").html() );
                            clearInterval(pVsTimer);
                            function pStime(){
                                $(".form_dt a.ddd span").html(pVs);
                                pVs--;
                                if(pVs<0){
                                    clearInterval(pVsTimer);
                                    lgg=false;
                                    $('.verify_picture_n').attr("src","http://www.w7tong.com/jsp/validatecode.jsp?"+((new Date()).getTime()));//刷新图形码
                                    $(".form_dt a.ddd").html("获取动态码").css("background","linear-gradient(to right,#fb414e,#ff7b66 )");
                                }
                            };
                            pStime();
                            pVsTimer = setInterval(pStime,1000);
                        }
                    }else{
                        alert('系统异常');
                    }
                },
                error:function(error){
                    console.log(error)
                }
            })
        }
    }),
    //验证码登录
    $('#yz_login').click(function () {
        var phone=$('.yz_phone').val(),
            txm=$('.yz_txm').val(),
            yzm=$('.yz_yzm').val(),
            service=window.location.href.split('=')[1]===undefined?'':window.location.href.split('=')[1];
        if(phone==''){
            $('.form_phone .error04').html('请输入手机号');
            $('.yz_phone').focus();
        }else if(!reg.test(phone)){
            $('.form_phone .error04').html('请输入正确的手机号');
            $('.yz_phone').focus();
        }else if(txm==''){
            $('.form_yzm .error05').html('请输入图形码');
            $('.yz_txm').focus();
        }else if(yzm==''){
            $('.form_dt .error06').html('请输入验证码');
            $('.yz_yzm').focus();
        }else{
            $.ajax({
                type:'post',
                url:wqturl+'/mobilelogin.action',
                dataType:'json',
                data:{
                    'mobile':phone,
                    'validateCode':txm,
                    'smscode':yzm,
                    'service':service
                },
                success:function(data){
                    if(data.result==5){
                        $('.form_yzm .error05').html('图形码不正确');
                        $('.yz_txm').focus();
                    }else if(data.result==3){
                        window.location.href=data.msg;
                    }else if(data.result==1){
						$('.form_dt .error06').html(data.msg);
                        $('.yz_yzm').focus();
					}
                },
                error:function(error){
                    console.log(error);
                }
            })
        }
    }),
    $('.yzm_lg input').keyup(function (event) {
        if(event.keyCode==13){
            $('#yz_login').click();
        }
    })
);