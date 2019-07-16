var reg=/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;

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
  $(".yhk").click(function(){
      $(".bank_cont").hide();
      $(".bank_info").show();
  }),
  $("#bank_qx_btn").click(function(){
      $(".bank_cont").show();
      $(".bank_info").hide();
  })
);
//获取银行信息
$.ajax({
   type:'post',
   url:wqturl+'/getBank.action',
   dataType:'json',
   data:{},
   success:function(data){
       var opbank='<option>请选择银行</option>';
       for(var i=0;i<data.length;i++){
           opbank+='<option value='+data[i].id+'>'+data[i].bankname+'</option>'
       }
       $(".sel_bank select").html(opbank);
   },
   error:function(error){
        console.log(error);
   }
});

$.ajax({
    type:'post',
    url:wqturl+'/getProvince.action',
    dataType:'json',
    data:{},
    success:function(data){
        var province='<option>请选择省份</option>';
        for(var i=0;i<data.length;i++){
            province+='<option value='+data[i].id+'>'+data[i].provincename+'</option>'
        }
        $('#province').html(province);
    },
    error:function(){
        console.log('error');
    }
});
//监听省份框
$('#province').on('change',function(){
    var index = this.selectedIndex;
    var pid=$("#province option").eq(index).val();
        $.ajax({
            type:'post',
            url:wqturl+'/getCity.action',
            dataType:'json',
            data:{
                'provinceid':pid
            },
            error:function(XmlHttpRequest,textStatus,errorThrown){
                console.log(XmlHttpRequest.status);
            },
            success:function(data){
                var city='<option>请选择市级</option>';
                for(var i=0;i<data.length;i++){
                    city+='<option value='+data[i].id+'>'+data[i].cityname+'</option>'
                }
                $("#city").html(city);
            }
        });
});
/*点击获取手机验证码*/
var nowTime='';
$(".bank_info_b .jym").click(function(){
    var mobile=$(".bank_phone").val();
    if(mobile==''){
        comfirm_add(5,'请输入电话号码');
    }else if(!reg.test(mobile)){
        comfirm_add(5,'请输入正确的电话号码');
    }else if( new Date().getTime()-nowTime >= 62000){
        nowTime = new Date().getTime();
        phoneVerifyAjax();
    }
});
function phoneVerifyAjax() {
    var mobile=$(".bank_phone").val(),
        pVsTimer='';
        $.ajax({
            type:'post',
            url:wqturl+'/smsCode.action',
            dataType:'json',
            data:{
                'mobile':mobile
            },
            success:function(data){
                if(data.msg==1){
                    $(".bank_info_b .jym").css("background","#888888");
                    $(".bank_info_b .jym").html("重新发送（<span>"+60+"</span>s）");
                    var pVs = parseInt( $(".bank_info_b .jym span").html() );
                    clearInterval(pVsTimer);
                    function pStime(){
                        $(".bank_info_b .jym span").html(pVs);
                        pVs--;
                        if(pVs==-2){
                            clearInterval(pVsTimer);
                            $(".bank_info_b .jym").html("获取动态码").css("background","#ededed");
                        }
                    };
                    pStime();
                    pVsTimer = setInterval(pStime,1000);
                }else{
                    comfirm_add(5,'系统异常请稍后重试');
                }
            },
            error:function(){
                console.log('error');
            }
        })
};
//解绑
$(".unbind").click(function(){
	var id=$(this).parent().parent('li.bank_cont_a').attr('data-id');
	console.log(id);
	$.ajax({
		type:'post',
		url:wqturl+'/unbindUserBank.action',
		dataType:'json',
		data:{
			'userBank.id':id
		},
		success:function(data){
			if(data.result==1){
			    alert(data.msg);
			    window.location.reload();
            }else{
                comfirm_add(5,data.msg);
            }
		},
		error:function(){
			console.log('error');
		}
	})
});
//立即绑定
$('.now_bind').click(function () {
    var id=$(this).parent().parent('li.bank_cont_a').attr('data-id'),
        bankid=$(this).parent().parent('li.bank_cont_a').attr('data-bankid');
   $.ajax({
       type:'post',
       url:wqturl+'/bindUserBank.action',
       dataType:'json',
       data:{
           'userBank.bankid':bankid,
           'userBank.id':id
       },
       success:function(data){
           if(data.result==1){
               alert(data.msg);
               window.location.reload();
           }else{
               comfirm_add(5,data.msg);
           }
       },
       error:function(){
           console.log('error')
       }
   })
});
$("#bank_btn").click(function () {
   var bank=$(".sel_bank select option:checked").val(),
        prv=$('#province option:checked').val(),
       ct=$('#city option:checked').val(),
       bk_nb=$('.bank_number').val(),
       bk_nm=$('.bank_name').val(),
       bk_phe=$('.bank_phone').val(),
       jym_num=$('.jym_num').val();
   if(bank=='请选择银行'){
       comfirm_add(5,'请选择银行');
   }else if(prv=='请选择省份'){
       comfirm_add(5,'请选择省份');
   }else if(ct=='请选择市级'){
       comfirm_add(5,'请选择市级');
   }else if(bk_nb==''){
       comfirm_add(5,'请输入您的银行卡号');
   }else if(bk_nm==''){
       comfirm_add(5,'请输入账户姓名');
   }else if(bk_phe==''){
       comfirm_add(5,'请输入电话号码');
   }else if(!reg.test(bk_phe)){
       comfirm_add(5,'请输入正确的的的电话号码');
   }else if(jym_num==''){
       comfirm_add(5,'请输入您收到的校验码');
   }else{
       $.ajax({
           type:'post',
           url:wqturl+'/bindUserBank.action',
           dataType:'json',
           data:{
               'userBank.bankid':bank,
               'userBank.provinceid':prv,
               'userBank.cityid':ct,
               'userBank.mobileno':bk_phe,
               'userBank.accountname':bk_nm,
               'userBank.accountno':bk_nb,
               'userBank.smscode':jym_num
           },
           success:function(data){
                if(data.result==2){
                    comfirm_add(5,data.msg);
                }else if(data.result==3){
                    comfirm_add(5,data.msg);
                }else if(data.result==1){
                    alert('恭喜，绑定成功');
                    window.location.reload();
                }
           },
           error:function () {
               console.log('error')
           }
       })
   }
});