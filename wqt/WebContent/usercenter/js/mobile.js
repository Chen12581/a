var phone=/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/,
    nowTime='',
    pVsTimer='',
    verifyTime='';
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
    // 验证手机号
    /*点击获取旧手机验证码*/
    $(".already_yzm a").click(function(){
        if( new Date().getTime()-nowTime >= 62000){
            nowTime = new Date().getTime();
            oldphone();
        }
    }),
    //点击获取新手机验证码
    $(".verify_yzm a").click(function(){
		var new_phone=$(".new_phone").val();
		$.ajax({
			type:'post',
			url:wqturl+'/checkMobile.action',
			dataType:'json',
			data:{
				'mobileno':new_phone
			},
			success:function(data){
				if(data.result==0){
					comfirm_add(5,data.msg);
				}else if(data.result==1){
					comfirm_add(5,data.msg);
				}else if(data.result==2){
					if( new Date().getTime()-verifyTime >= 62000){
						verifyTime = new Date().getTime();
						newphone();
					}
				}
			},
			error:function(){
				console.log('error')
			}
		})
    }),
    $(".sj_yzm").keydown(function(event){
        if(event.keyCode==13){
            oldYzm();
        }
    }),
    $(".new_yzm").keydown(function(event){
        if(event.keyCode==13){
            newYzm();
        }
    })
);
//发送旧手机验证码
function oldphone(){
    $.ajax({
        type:'post',
        url:wqturl+"/smsCode.action",
        dataType:'json',
        data:{},
        success:function(data){
            if (data.msg==1){
                $(".already_yzm a").css("background","#888888");
                $(".already_yzm a").html("重新发送（<span>"+60+"</span>s）");
                var pVs = parseInt( $(".already_yzm a span").html() );
                clearInterval(pVsTimer);
                function pStime(){
                    $(".already_yzm a span").html(pVs);
                    pVs--;
                    if(pVs==-2){
                        clearInterval(pVsTimer);
                        $(".already_yzm a").html("免费获取校验码").css("background","#f3f3f3");
                    }
                };
                pStime();
                pVsTimer = setInterval(pStime,1000);
            }
        },
        error:function(readyState){
            console.log(readyState)
        }
    })
};
//发送新手机验证码
function newphone(){
    var new_phone=$(".new_phone").val();
    if(new_phone==''){
        comfirm_add(5,'请输入新手机号码')
    }else if(!phone.test(new_phone)){
        comfirm_add(5,'请输入正确的手机号码')
    }else{
        $.ajax({
            type:'post',
            url:wqturl+"/smsCode.action",
            dataType:'json',
            data:{
                'mobile':new_phone
            },
            success:function(data){
                if (data.msg==1){
                    $(".verify_yzm a").css("background","#888888");
                    $(".verify_yzm a").html("重新发送（<span>"+60+"</span>s）");
                    var pVs = parseInt( $(".verify_yzm a span").html() );
                    clearInterval(pVsTimer);
                    function pStime(){
                        $(".verify_yzm a span").html(pVs);
                        pVs--;
                        if(pVs==-2){
                            clearInterval(pVsTimer);
                            $(".verify_yzm a").html("免费获取校验码").css("background","#f3f3f3");
                        }
                    };
                    pStime();
                    pVsTimer = setInterval(pStime,1000);
                }else{
                    alert("系统错误");
                }
            },
            error:function(readyState){
                console.log(readyState)
            }
        })
    }
};
// 提交验证旧手机
function oldYzm(){
    var yzm=$(".sj_yzm").val();
    if(yzm==''){
        comfirm_add(5,'请输入验证码');
    }else{
        $("#btn_inp_yzm").removeAttr("onclick");
        var timer1=window.setTimeout(function(){
            $("#btn_inp_yzm").attr("onclick","oldYzm()");
            window.clearTimeout(timer1);
            timer1=null;
        },10000);
        $.ajax({
            type:'post',
            url:wqturl+'/confirmUserMobile.action',
            dataType:'json',
            data:{
                'smscode':yzm
            },
            success:function(data){
                if(data.result==1){
                    $(".cont_tab ul li.on").html('修改手机号');
                    $(".xg_mobile ul li").eq(1).show().siblings().hide();
                    $(".sj_yzm").val('');
                }else if(data.result==2){
                    comfirm_add(5,'验证码输入错误或已超时');
                }else if(data.result==0){
                    comfirm_add(5,'系统异常');
                }
            },
            error:function(error){
                console.log(error);
            }
        })
    }
}
// 提交验证新手机
function newYzm(){
    var yzm=$(".new_yzm").val(),
        iphone=$(".new_phone").val();
    if(yzm==''){
        comfirm_add(5,'请输入验证码');
    }else if(iphone==''){
        comfirm_add(5,'请输入新的电话号码');
    }else if(!phone.test(iphone)){
        comfirm_add(5,'请输入正确的电话号码');
    }else{
        $("#btn_yzm").removeAttr("onclick");
        var timer1=window.setTimeout(function(){
            $("#btn_yzm").attr("onclick","newYzm()");
            window.clearTimeout(timer1);
            timer1=null;
        },10000);
        $.ajax({
            type:'post',
            url:wqturl+'/updateUserMobile.action',
            dataType:'json',
            data:{
                'smscode':yzm,
                'mobile':iphone
            },
            success:function(data){
                if(data.result==1){
                    var i=iphone.substr(0, 3) + '****' + iphone.substring(7, 11);
                    $(".cont_tab ul li.on").html('完成');
                    $(".xg_mobile ul li .fin span").html('恭喜您：手机号修改成功，'+i+'可作为账号用于登录');
                    $(".xg_mobile ul li").eq(2).show().siblings().hide();
                    $(".new_yzm").val('');
                    $(".new_phone").val('');
                }else if(data.result==2){
                    comfirm_add(5,'验证码输入错误或已超时');
                }else if(data.result==0){
                    comfirm_add(5,'系统异常');
                }
            },
            error:function(error){
                console.log(error);
            }
        })
    }
};