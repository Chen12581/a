$(document).ready(function() {
    wrap.init();
})

var wrap = {
    init: function() {
        this.banner();
        this.mbList();
    },
    banner: function() {
        var count = 1;
        setInterval(function() {
            $(".banner a img").each(function(i) {
                if (i != count) {
                    $(this).hide();
                    $(this).animate({
                        opacity: '1',
                    }, 'slow');
                } else {
                    $(this).show();
                    $(this).animate({
                        opacity: '0.7',
                    }, 'slow');
                }
            })
            $(".banner div i").each(function(i) {
                if (i != count) {
                    $(this).css("opacity", "0.5");
                } else {
                    $(this).css("opacity", "1");
                }
            })
            count == 2 ? count = 0 : count++;
        }, 2000);
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
    }
}