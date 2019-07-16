/**
 * Created by Administrator on 2017/12/19.
 */
/************************联系地址动作效果的设置**********************/
(function(){
    $('.ticket_info i').click(function(){
        $(this).siblings('ul').toggle();
    });
    $('.ticket_info ul').on('click','li',function(){
        var aa = $(this).html();
        $(this).addClass('active').siblings().removeClass('active');
        $(this).parent('ul').hide();
        $(this).parent().siblings('input').val(aa);
    });
})();









































