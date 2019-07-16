/**
 * Created by Administrator on 2017/11/22.
 */
$('.service_list .service').mouseenter(function(){
    $(this).children('dl').animate({
        top: '-280px'
    },250)
});
$('.service_list .service').mouseleave(function(){
    $(this).children('dl').animate({
        top: 0
    },250)
});

/*版权服务对应的动作*/
$('.service_type li').mouseenter(function(){
    var hf = '';
    hf = $(this).children('a').attr('href');
    hf = '.' + hf;
    $(this).addClass('aim').siblings().removeClass('aim');
    $(hf).show();
    $(hf).siblings('.copyright_content').hide();
});