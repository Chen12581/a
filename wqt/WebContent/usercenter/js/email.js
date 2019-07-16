var email=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
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
$(
    $('.b_email').click(function () {
        var e=$('.eml input').val();
        console.log(e);
        if(e==''){
            comfirm_add(5,'请输入邮箱地址')
        }else if(!email.test(e)){
            comfirm_add(5,'请输入正确的邮箱地址')
        }else{
            $.ajax({
                type:'post',
                url:wqturl+'/bandEmail.action',
                dataType:'json',
                data:{
                    'email':e
                },
                success:function(data){
                    console.log(data)
                },
                error:function () {
                    console.log('error')
                }
            })
        }
    }),
    $(document).keydown(function (event) {
        if(event.keyCode==13){
            $('.b_email').click();
        }
    })
);