/**
 * Created by Administrator on 2018/1/2.
 */
/*************************banner的动作设置*****************************/
(function(){
    var num = $('.scroll_box ul li').size();

    var count = 1;

    var timer = setInterval(scroll,2000);

    function scroll(){
        if(count < num){
            $('.scroll_box ul li:nth-child('+count+')').hide();
            count++;
            $('.scroll_box ul li:nth-child('+count+')').fadeIn();
        }else{
            $('.scroll_box ul li:last-child').hide();
            count = 1;
            $('.scroll_box ul li:nth-child('+count+')').fadeIn();
        };
        $('.scroll_box ol li:nth-child('+ count +')').addClass('hover').siblings().removeClass('hover');
    }
    $('.scroll_box').mouseenter(function(){
        clearInterval(timer);
        timer = null;
    });
    $('.scroll_box').mouseleave(function(){
        timer = setInterval(scroll,2000);
    });

    $('.scroll_box ol li').mouseenter(function(){
        $(this).addClass('hover').siblings().removeClass('hover');
        var aa = $('.scroll_box ol li').index($(this));
        count = aa + 1;
        $('.scroll_box ul li:nth-child('+count+')').siblings().hide();
        // count++;
        $('.scroll_box ul li:nth-child('+count+')').fadeIn();
    })

})();

/************************************/
(function(){
    $('.theme_list').on('click','a',function(){
        var aa = $(this).parents();
        aa.addClass('active').siblings().removeClass('active');
        var count = $('.theme_list li').index(aa);
        count++;
        $('.content_box>div:nth-child('+count+')').show().siblings().hide();
    });
})();