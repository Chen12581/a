$(
  //支付类型
    $(".com_zf ul").on('click','li',function () {
        if(!$(this).is(".on")){
            var i=$(this).index();
            if(i=='0'){
                $(this).parent().next().html('');
            }else{
                $(this).parent().next().html('当前选择支付定金，定金金额为出售价格20%');
            }
            $(this).addClass("on").siblings().removeClass("on");
        }
    }),
    //支付方式
    $(".alane_zf ul").on('click','li',function () {
        if(!$(this).is(".on")){
            var i=$(this).index();
            if(i=='0'){
                $(".pay_balance").css('display','none');
                $(".top_up").css('display','block');
            }else{
                $(".pay_balance").css('display','block');
                $(".top_up").css('display','none');
            }
            $(this).addClass("on").siblings().removeClass("on");
        }
    }),
    //优先使用账户余额
    $(".pay_balance").click(function () {
        var id=$(this).attr("data-id");
        if(id==='0'){
            $(this).attr("data-id",'1');
            $(this).children().children('img').attr('src',wqturl+'/usercenter/payment/image/payment/yput.png')
        }else{
            $(this).attr("data-id",'0');
            $(this).children().children('img').attr('src',wqturl+'/usercenter/payment/image/payment/wput.png')
        }
    })
);