
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
(function(){
    $(".content_lf>div>ul").on("click","li",function(){
        if(!$(this).is(".hover")){
            $(".content_lf div ul li").removeClass(".hover");
            $(this).addClass(".hover");
        }
    })
})();
//显示付款总额 优惠及选择商品数量
$(document).ready(function () {
    var i=0;
    // $('.indent_state').on('click','li',function(e){
    //     e.preventDefault();
    //     i=$(this).index();
    //     $(this).addClass('active').siblings().removeClass('active');
    //     $(".ttab").eq(i).addClass("on").siblings(".ttab").removeClass("on");
    // });
    $(".order_checked").click(function(){
        var price=0,
            yh=0,
            a=0,//被选择的数量
            b=$("#all_order .order_checked:not(:disabled)").length,//全部订单里订单数量
            c=$("#obligation .order_checked:not(:disabled)").length,//待付款订单里订单数量
            d=$("#booking .order_checked:not(:disabled)").length;//已预订订单里订单数量
        if(i=='0'){
            //判断是否全选
            if($("#all_order .order_checked:checked").length==b){
                $("#all_order .all_checked .all").prop("checked",true);
            }else if($("#all_order .order_checked:checked").length<b){
                $("#all_order .all_checked .all").prop("checked",false);
            }
            //计算勾选总价
            $("#all_order .order_checked:checked").each(function () {
                    a++;
                    price+=parseInt($(this).attr('data-pri'));
                    yh+=parseInt($(this).attr('data-favourabl'));
            });
            $(".all_pay .gg span").html(price+'.00');
            $(".all_pay .thank span").html(yh+'.00');
            $(".all_pay .select_order span").html(a);
        }else if(i=='1'){
            //判断是否全选
            if($("#obligation .order_checked:checked").length==c){
                $("#obligation .all_checked .all").prop("checked",true);
            }else if($("#obligation .order_checked:checked").length<c){
                $("#obligation .all_checked .all").prop("checked",false);
            }
            //计算勾选总价
            $("#obligation .order_checked:checked").each(function () {
                a++;
                price+=parseInt($(this).attr('data-pri'));
                yh+=parseInt($(this).attr('data-favourabl'));
            });
            $(".obligation_pay .gg span").html(price+'.00');
            $(".obligation_pay .thank span").html(yh+'.00');
            $(".obligation_pay .select_order span").html(a);
        }else if(i=='2'){
            //判断是否全选
            if($("#booking .order_checked:checked").length==d){
                $("#booking .all_checked .all").prop("checked",true);
            }else if($("#booking .order_checked:checked").length<d){
                $("#booking .all_checked .all").prop("checked",false);
            }
            //计算勾选总价
            $("#booking .order_checked:checked").each(function () {
                a++;
                price+=parseInt($(this).attr('data-pri'));
                yh+=parseInt($(this).attr('data-favourabl'));
            });
            $(".booking_pay .gg span").html(price+'.00');
            $(".booking_pay .thank span").html(yh+'.00');
            $(".booking_pay .select_order span").html(a);
        }
    });
    //全选按钮
    $(".all").click(function () {
        var price=0,
            yh=0,
            a=0;
        if($(this).is(':checked')){
            if(i=='0'){
                $("#all_order .order_checked:not(:disabled)").prop("checked",true);
                // $("#all_order .order_checked:checked").each(function () {
                //     a++;
                //     price+=parseInt($(this).attr('data-pri'));
                //     yh+=parseInt($(this).attr('data-favourabl'));
                // });
                // $(".all_pay .gg span").html(price+'.00');
                // $(".all_pay .thank span").html(yh+'.00');
                // $(".all_pay .select_order span").html(a);
            }else if(i=='1'){
                $("#obligation .order_checked:not(:disabled)").prop("checked",true);
            }else if(i=='2'){
                $("#booking .order_checked:not(:disabled)").prop("checked",true);
            }
        }else{
            if(i=='0'){
                $("#all_order .order_checked:not(:disabled)").prop("checked",false);
            }else if(i=='1'){
                $("#obligation .order_checked:not(:disabled)").prop("checked",false);
            }else if(i=='2'){
                $("#booking .order_checked:not(:disabled)").prop("checked",false);
            }
        }
        $(".order_checked").eq(0).trigger('click');
    });
    //去付款
    $(".py_btn a").click(function () {
        var order=[],
            order_num='',
            all_num='';
        if(i=='0'){
            if($("#all_order .order_checked:checked").length=='0'){
                comfirm_add(5,'请选择商品订单');
            }else{
                $("#all_order .order_checked:checked").each(function () {
                    order_num=$(this).parent().children().last().html().split("：")[1];
                    order.push(order_num);
                });
                all_num=order.join();
                $(this).attr("href",wqturl+"/order/pay/"+all_num+"/type/5");
            }
        }else if(i=='1'){
            if($("#obligation .order_checked:checked").length=='0'){
                comfirm_add(5,'请选择商品订单');
            }else{
                $("#obligation .order_checked:checked").each(function () {
                    order_num=$(this).parent().children().last().html().split("：")[1];
                    order.push(order_num);
                });
            }
            all_num=order.join();
            $(this).attr("href",wqturl+"/order/pay/"+all_num+"/type/5");
        }else if(i=='2'){
            if($("#booking .order_checked:checked").length=='0'){
                comfirm_add(5,'请选择商品订单');
            }else{
                $("#booking .order_checked:checked").each(function () {
                    order_num=$(this).parent().children().last().html().split("：")[1];
                    order.push(order_num);
                });
                all_num=order.join();
                $(this).attr("href",wqturl+"/order/pay/"+all_num+"/type/5");
            }
        }
    })
});







































