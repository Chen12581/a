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
$(".btn").click(function() {
    if ($(".textarea").val() == '') {
        alert("亲，请输入您对万企通的建议！");
    } else if($('.phone').val()==''){
        comfirm_add(5,'请输入手机号')
    }else if(!reg.test($('.phone').val())){
        comfirm_add(5,'请输入正确的手机号')
    }else{
        var val=$(".textarea").val();
        $.ajax({
            type:'post',
            url:wqturl+'/saveUserSuggest.action',
            dataType:'json',
            data:{
                'userSuggest.suggest':val
            },
            success:function(data){
                if(data.result=='1'){
                    alert("亲，感谢您的建议,如果采纳了您的建议，我们将联系您！");
                    $('.textarea').val('');
                    $('.name').val('');
                    $('.phone').val('');
                }else if(data.result=='2'){
                    window.location.href = casurl + "?service=" + data.msg;
                }
            },
            error:function () {
                console.log('fail');
            }
        })
    }
});
