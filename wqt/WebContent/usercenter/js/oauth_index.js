var reg=/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/,//手机号码验证
    phove_v=false,//判断手机号是否被注册
    pVsTimer=null,
    lgg=false,//用于判断重复点击动态码
    nowTime=0;
$(
    $('.phone').blur(function(){
        var vv=$(this).val();
        if(vv==''){
             $('.error01').html('请输入手机号码');
             $(this).focus();
        }else if(!reg.test(vv)){
            $('.error01').html('请输入正确的手机号码');
            $(this).focus();
        }else{
            $.ajax({
                type:'post',
                url:wqturl+'/checkMobile.action',
                dataType:'json',
                data:{
                    'mobileno':vv
                },
                success:function(data){
                    if(data.result=='1'){
                        $('.error01').html('');
                        phove_v=true;
                    }else if(data.result=='2'){
                        $('.error01').html('手机号未注册');
                        $('.phone').focus();
                        phove_v=false;
                    }
                },
                error:function(error){
                    console.log(error);
                }
            })
        }
    }),
    $(".verify_picture_n").click(function(){
        $(this).attr("src","http://www.w7tong.com/jsp/validatecode.jsp?"+((new Date()).getTime()))
    }),
    $('.yyy').click(function(){
        var phone=$('.phone').val(),
            txm=$('.txm').val();
        if(phone==''){
            $('.error01').html('请输入手机号码');
            $('.phone').focus();
        }else if(!reg.test(phone)){
            $('.error01').html('请输入正确的手机号码');
            $('.phone').focus();
        }else if(!phove_v){
            $('.error01').html('手机号未注册');
            $('.phone').focus();
        }else if(txm==''){
            $('.error02').html('请输入图形码');
            $('.txm').focus();
        }else if(lgg){

        }else{
            $.ajax({
                type:'post',
                url:wqturl+'/commonSmsCode.action',
                dataType:'json',
                data:{
                    'mobile':phone,
                    'validateCode':txm
                },
                success:function(data){
                    if(data.result==0){
                        $('.error02').html('图形码输入错误');
                        $('.txm').focus();
                    }else if(data.result==1){
                        lgg=true;
                        if( new Date().getTime()-nowTime >= 62000){
                            nowTime = new Date().getTime();
                            $('.error02').html('');
                            $(".yyy").css("background","#919195");
                            $(".yyy").html("重新发送（<span>"+60+"</span>s）");
                            var pVs = parseInt( $(".yyy span").html() );
                            clearInterval(pVsTimer);
                            function pStime(){
                                $(".yyy span").html(pVs);
                                pVs--;
                                if(pVs<0){
                                    clearInterval(pVsTimer);
                                    lgg=false;
                                    $('.verify_picture_n').attr("src","http://www.w7tong.com/jsp/validatecode.jsp?"+((new Date()).getTime()));//刷新图形码
                                    $(".yyy").html("获取动态码").css("background","#f8f8f8");
                                }
                            };
                            pStime();
                            pVsTimer = setInterval(pStime,1000);
                        }
                    }else{
                        alert('系统异常');
                    }
                }
            })
        }
    }),
    $('.inp button.p3').click(function(){
        var phone=$('.phone').val(),
            txm=$('.txm').val(),
            yzm=$('.yzm').val(),
            url = window.location.href.split("?")[1],
            url_arr = url.split("&"),
            openId='',
            nickName='',
            sourcefrom='',
            platetype='';
        if(phone==''){
            $('.error01').html('请输入手机号码');
            $('.phone').focus();
        }else if(!reg.test(phone)){
            $('.error01').html('请输入正确的手机号码');
            $('.phone').focus();
        }else if(!phove_v){
            $('.error01').html('手机号未注册');
            $('.phone').focus();
        }else if(txm==''){
            $('.error02').html('请输入图形码');
            $('.txm').focus();
        }else if(yzm==''){
            $('.error03').html('请输入验证码');
            $('.yzm').focus();
        }else{
            for(var i=0;i<url_arr.length;i++){
                var aa=url_arr[i].split('=')[0];
                if(aa=='openId'){
                    openId=url_arr[i].split('=')[1];
                }else if(aa=='nickName'){
                    nickName=url_arr[i].split('=')[1];
                }else if(aa=='sourcefrom'){
                    sourcefrom=url_arr[i].split('=')[1];
                }else if(aa=='platetype'){
                    platetype=url_arr[i].split('=')[1];
                }
            };
            $.ajax({
                type:'post',
                url:wqturl+'/relateW7tongUser.action',
                dataType:'json',
                data:{
                    'mobile':phone,
                    'openId':openId,
                    'nickName':nickName,
                    'sourcefrom':sourcefrom,
                    'platetype':platetype,
                    'validateCode':txm,
                    'smsCode':yzm
                },
                success:function(data){
                    if(data.result==1){
                        alert('关联成功！');
                        window.location.href=data.msg;
                    }else if(data.result==2){
                        $('.error03').html('手机验证码不正确');
                        $('.yzm').focus();
                    }else if(data.result==3){
                        $('.error02').html('图形码不正确');
                        $('.txm').focus();
                    }else if(data.result==4){
                        $('.error01').html(data.msg);
                        $('.phone').focus();
                    }
                },
                error:function(error){
                     console.log(error)
                }
            })
        }
    })
);