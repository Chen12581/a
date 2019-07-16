/**
 * Created by Administrator on 2017/12/4.
 */

/******************搜索展示的数据动作*******************/
(function(){
    var aa = '';
    aa = $('.search_scroll li').size();
    console.log(aa);
    num = parseFloat(aa/3);
    var count = 0;
    setInterval(function(){
        count++;
        if(count<5){
            Top = count * (-55);
            $('.search_scroll>ul').animate({
                top: Top + "px"
            },500)
        }else{
            $('.search_scroll>ul').attr('style','top:0');
            count = 1;
            Top = count * (-55);
            $('.search_scroll>ul').animate({
                top: Top + "px"
            },500)
        }

    },2000);

})();

/**********************热门行业注册动作*********************/
(function(){
    $('.category_type').on('click','li',function(){
        $(this).addClass('aim').siblings().removeClass('aim');
        var aa = $(this).attr('name');
        aa = '.' + aa;
        $(aa).show().siblings().hide();
    })

    $('.category_show').on('click','li',function(){
        if($(this).hasClass('active')){
            $(this).removeClass('active')
        }else(
            $(this).addClass('active')
        );
    })
})();

/************************banner_scroll的动作设置***********************/
(function(){
    var aa = $('.banner_scroll li:first-child').clone();
    aa.appendTo($('.banner_scroll ul'));

    var num = $('.banner_scroll li').size();

    Width = num * (1190);
    $('.banner_scroll ul').attr('style','width: '+Width +'px');

    var count = 0;
    setInterval(function(){
        count++;
        if(count<(num-1)){
            Left = count * (-1190);
            $('.banner_scroll>ul').animate({
                left: Left + "px"
            },500)
        }else{
            $('.banner_scroll>ul').attr('style','left:0;width: '+Width +'px');
            count = 1;
            Left = count * (-1190);
            $('.banner_scroll>ul').animate({
                left: Left + "px"
            },500)
        }
    },2000);

})();

(function(){
    var aa = $('.banner_scroll01 li:first-child').clone();
    aa.appendTo($('.banner_scroll01 ul'));

    var num = $('.banner_scroll01 li').size();

    Width = num * (1190);
    $('.banner_scroll01 ul').attr('style','width: '+Width +'px');

    var count = 0;
    setInterval(function(){
        count++;
        if(count<(num-1)){
            Left = count * (-1190);
            $('.banner_scroll01>ul').animate({
                left: Left + "px"
            },500)
        }else{
            $('.banner_scroll01>ul').attr('style','left:0;width: '+Width +'px');
            count = 1;
            Left = count * (-1190);
            $('.banner_scroll01>ul').animate({
                left: Left + "px"
            },500)
        }

    },2000);

})();