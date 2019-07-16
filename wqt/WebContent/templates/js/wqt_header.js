(function($){
    $.fn.hoverDelay = function(options){
        var defaults = {
            hoverDuring: 200,
            outDuring: 200,
            hoverEvent: function(){
                $.noop();
            },
            outEvent: function(){
                $.noop();
            }
        };
        var sets = $.extend(defaults,options || {});
        var hoverTimer, outTimer;
        return $(this).each(function(){
            var $this = $(this);
            $this.hover(function(){
                clearTimeout(outTimer);
                hoverTimer = setTimeout(function () {
                    sets.hoverEvent.apply($this);
                }, sets.hoverDuring);
            }, function(){
                clearTimeout(hoverTimer);
                outTimer = setTimeout(function () {
                    sets.outEvent.apply($this);
                }, sets.outDuring);
            });
        });
    }
})(jQuery);
    
$(".qyfw").hoverDelay({
    hoverEvent: function () {
        $(this).find(".qyfw_drop").slideDown("slow");
    },
    outEvent: function () {
        $(this).find(".qyfw_drop").slideUp(0);
    }
});
$(".zscq").hoverDelay({
    hoverEvent: function () {
        $(this).find(".zscq_drop").slideDown("slow");
    },
    outEvent: function () {
        $(this).find(".zscq_drop").slideUp(0);
    }
});
$(".wdfw").hoverDelay({
    hoverEvent: function () {
        $(this).find(".wdfw_drop").slideDown("slow");
    },
    outEvent: function () {
        $(this).find(".wdfw_drop").slideUp(0);
    }
});
$(".hlfw").hoverDelay({
    hoverEvent: function () {
        $(this).find(".hlfw_drop").slideDown("slow");
    },
    outEvent: function () {
        $(this).find(".hlfw_drop").slideUp(0);
    }
});
//登录
var str=$("#login").attr('href'); 
$("#login").attr('href',str+window.location.href);
var str=$("#register").attr('href');
$("#register").attr('href',str+window.location.href);
//退出
$("#logout").click(function () {
    $.ajax({
        type:"post",
        url:wqturl+"/loginOut.action",
        dataType:"json",
        success:function (data) {  
            if(!data){
               window.location=window.location.href;
            }
        },
        error:function(){
            console.log("代码错误");
        }
    })
})