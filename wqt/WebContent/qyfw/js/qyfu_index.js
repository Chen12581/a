/**
 * Created by Administrator on 2018/4/2.
 */

(function(){
    $('.demand_box').on('click','i',function(){
        $(this).siblings('ul').show();
    });

    $('.demand_box ul').on('click','li',function(){
        var aa = $(this).html();
        $('#demand').val(aa);
        $(this).parent().hide();
    })
})();












