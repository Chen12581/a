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
};
$(
    $('#exit').click(function () {
        $('.query').hide();
    }),
    $('.kf_zx ul li .k1').click(function(){
        $('.query').show();
    }),
    $('#free_btn').click(function(){
        var name=$('.ui-win-search .p1 input').val(),
            phone=$('.ui-win-search .p2 input').val();
        if(phone==''){
            comfirm_add(5,'请输入电话号码');
        }else if(!reg.test(phone)){
            comfirm_add(5,'请输入正确的电话号码');
        }else{
            $.ajax({
                type:'post',
                url:wqturl+'/saveWqtNetConsult.action',
                dataType:'json',
                data:{
                    "netConsult.connector":name,
                    "netConsult.mobileno":phone
                },
                success:function(data){
                    if(data.result==1){
                        $('.query').hide();
                        comfirm_add(6,'您的信息已提交成功,客服稍后会联系您');
                        $('.ui-win-search .p1 input').val('');
                        $('.ui-win-search .p2 input').val('');
                    }
                }
            })
        }
    })
);