$(document).ready(function() {
    wrap.init();

})

var wrap = {
    init: function() {
        this.mbList();
        this.banner();
    },
    mbList: function() {
        $(".headerRightImg").on("click", function() {
            $(".headerRightImg img").each(function(i) {
                if (i == 0 && $(this).is(":hidden")) {
                    $(".mbList").animate({
                        left: '150%'
                    })
                } else if (i == 1 && $(this).is(":hidden")) {
                    $(".mbList").animate({
                        left: '0'
                    })
                }
                $(this).toggle();
            })
        })
    },
    banner: function() {
        var swiper = new Swiper('.swiper-container', {
            //循坏轮播图
            loop: true,
            //是否自动播放默认false   autoplay:true
            autoplay: {
                //触摸后是否停止自动滑动，默认true
                disableOnInteraction: false,
            },
            //分页器
            pagination: {
                el: '.swiper-pagination',
            },
        });
    }
}