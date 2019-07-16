var nowTime='',
    pVsTimer='',
    aa=3,//倒计时
    pass=/^[\!\"\#\$\%\&\'\(\)\*\+\,\-\.\/\:\;\<\=\>\?\@\[\\\]\^\`\{\|\}\~\w]{6,16}$/;/*6到16位的密码*/
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
};
function  yzm(){
    var phone=$('.yzmobile').attr('id');
    $.ajax({
        type:'post',
        url:wqturl+'/smsCode.action',
        dataType:'json',
        data:{
            'mobile':phone
        },
        success:function (data) {
            if (data.msg==1){
                $("#verifyCode").css({"background":"#f8f8f8","color":"#575757"});
                $("#verifyCode").html("重新发送（<span>"+60+"</span>s）");
                var pVs = parseInt( $("#verifyCode span").html() );
                clearInterval(pVsTimer);
                function pStime(){
                    $("#verifyCode span").html(pVs);
                    pVs--;
                    if(pVs==-2){
                        clearInterval(pVsTimer);
                        $("#verifyCode").html("获取验证码").css({"background":"#f67404","color":"#fff"});
                    }
                };
                pStime();
                pVsTimer = setInterval(pStime,1000);
            }
        },
        error:function(error){
            console.log(error);
        }
    })
}
$(
    $("#verifyCode").click(function(){
        if( new Date().getTime()-nowTime >= 62000){
            nowTime = new Date().getTime();
            yzm();
        }
    }),
    $('#pass').mouseleave(function () {
        var v=$(this).val();
        if(v==''){
            $('.error01').html('请输入新密码');
        }else if(!pass.test(v)){
            $('.error01').html('请输入6-16位密码');
        }else{
            $('.error01').html('')
        }
    })
);
function set(){
    if(aa<0 || aa==0){
        aa=3;
        $.ajax({
			type:'post',
			url:wqturl+'/loginOut.action',
			dataType:'json',
			data:{},
			success:function(){
				window.location.href=wqturl+'/user/login.html?service='+window.location.href;
			},
			error:function(){
				console.log('error');
			}
		})
    }else{
        $('.success_title .secs').html(aa);
        aa--;
        setTimeout(function () {
            set();
        },1000);
    }
}

function update(){
    var v=$('#pass').val(),
        m=$('#qpass').val(),
        p=$('.yzmobile').attr('id');
    if(!pass.test(v)){
        $('.error01').html('请输入6-16位密码');
    }else if(v!=m){
        $('.error02').html('两次密码输入不一致');
    }else{
        $.ajax({
            type:'post',
            url:wqturl+'/updatePassword.action',
            dataType:'json',
            data:{
                'mobile':p,
                'password':v
            },
            success:function(data){
                if(data.result=='0'){
                    comfirm_add(5,data.msg)
                }else if(data.result=='2'){
                    comfirm_add(5,data.msg)
                }else if(data.result=='1'){
                    $('.get_procedure ul li').eq(2).addClass('on').siblings().removeClass('on');
                    $('.procedure_detail .pp').eq(2).show().siblings().hide();
                    set();
                }
            },
            error:function(data){
                console.log(data);
            }
        })
    }

};
$('#aphone').click(function () {
    var val=$('#phoneCode').val(),
        phone=$('.yzmobile').attr('id');
    if(val==''){
        comfirm_add(5,'请输入验证码')
    }else{
        $.ajax({
            type:'post',
            url:wqturl+'/findPasswordnext.action',
            dataType:'json',
            data:{
                'mobile':phone,
                'smscode':val
            },
            success:function (data) {
                if(data.result=='1'){
                    $('.get_procedure ul li').eq(1).addClass('on').siblings().removeClass('on');
                    $('.procedure_detail .pp').eq(1).show().siblings().hide();
                    $('.phoneCode').val('');
                }else if(data.result=='2'){
                    comfirm_add(5,data.msg)
                }
            },
            error:function () {
                console.log('error')
            }
        })
    }
});
$("#qpass").keydown(function(event){
    if(event.keyCode==13){
        update();
    }
});
$('#phoneCode').keydown(function (event) {
    if(event.keyCode==13){
        $('#aphone').click();
    }
});