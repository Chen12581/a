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
            //循环轮播图
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
    },
    addLink: function(blogName) {
        var body_element = document.body;
        var selection;
        selection = window.getSelection() ? window.getSelection() : document.selection.createRange().text;
        if (window.clipboardData) { // Internet Explorer
            var pagelink = "\r\n\r\n 原文出自" + blogName + " 转载请保留原文链接: " + document.location.href + "";
            var copyText = selection + pagelink;
            window.clipboardData.setData("Text", copyText);
            return false;
        } else {
            var pagelink = " 原文出自" + blogName + " 转载请保留原文链接: " + document.location.href + "";
            var copyText = selection + pagelink;
            var newDiv = document.createElement('div');
            newDiv.style.position = 'absolute';
            newDiv.style.left = '-99999px';
            body_element.appendChild(newDiv);
            newDiv.innerHTML = copyText;
            selection.selectAllChildren(newDiv);
            window.setTimeout(function() {
                body_element.removeChild(newDiv);
            }, 0);
        }
    }
}
document.oncopy = function() {
    if ($('body')) {
        wrap.addLink('花园竹木官网');
    }
}