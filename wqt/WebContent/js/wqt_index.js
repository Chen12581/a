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

$(function () {
    //侧边栏
    $(window).scroll(function(){
		var top = $(window).scrollTop();
		if(top > 100){
			$('.rt_fixed').show();
		}else{
			$('.rt_fixed').hide();
		}
	}),
	$('#r_top').click(function () {
		$("html,body").animate({scrollTop:0},'slow');
    })
    
    //banner切换
    $(".tab_title>ul>li").click(function () {  
        var index=$(this).index();
        $(this).addClass("on").siblings().removeClass("on");
        $(".tab_content").children().eq(index).css({display:'block'}).siblings().css({display:'none'});
    })
    //客服切换
    $(".adviser_box ul li").click(function () {  
        var $this=$(this);
        var i=$this.index();
        $this.addClass("on").siblings().removeClass("on");
        $(".photo_box").eq(i).show().siblings(".photo_box").hide();
    })
    //企业服务切换
    $(".bes_title>li").click(function () {  
        var i=$(this).index();
        console.log(i);
        $(this).addClass("on"+(i+1));
        if(i==0){
            $(this).next().removeClass("on2").next().removeClass("on3");
        }else if(i==1){
            $(this).next().removeClass("on3");
            $(this).prev().removeClass("on1");
        }else{
            $(this).prev().removeClass("on2").prev().removeClass("on1");
        }
        $(".bes_type .bes_types").eq(i).css({display:'block'}).siblings().css({display:'none'});
    })
    // 知识产权切换
    $(".list_y1 .attorn_list>li").hover(function () {  
        $(this).addClass("on").siblings().removeClass("on");
        var i=$(this).index();
        $(".list_right .right_lists").eq(i).css({display:'block'}).siblings().css({display:'none'});
    })
    //登录
    var str=$("#login").attr('href'); 
    $("#login").attr('href',str+window.location.href);
    var str=$("#register").attr('href');
    $("#register").attr('href',str+window.location.href);
    //退出
    $("#logout").click(function () {  
        console.log(1);
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
    
    // $("#phoneNumber").blur(function () {
        
    //     if($(this).val()==""||$(this).val()==undefined){
    //         $(".cover").show();
    //         $(".hint1").show().children().html("手机号不能为空！");
    //         setTimeout(function(){
    //             $(".hint1,.cover").hide();
    //         },3000)
    //     }else if(!mobileReg.test($(this).val())){
    //         $(".cover").show();
    //         $(".hint1").show().children().html("手机号码格式不正确！");
    //         setTimeout(function(){
    //             $(".hint1,.cover").hide();
    //         },3000)
    //     }
    // })
    // $("#name").blur(function () {
        
    //     if($(this).val()==""||$(this).val()==undefined){
    //         $(".cover").show();
    //         $(".hint1").show().children().html("姓名不能为空！");
    //         setTimeout(function(){
    //             $(".hint1,.cover").hide();
    //         },3000)
    //     }
    // })
    //发布
    var mobileReg=/^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/; 
    $(".issue").click(function () {  
        var mobileno=$("#phoneNumber").val();
        var consultcontent=$("#remark").val();
        var cityname='11';
        var plateform='wqt';
        var connector=$("#name").val();
        var kind=5;
        if(connector==""||connector==undefined){
            $(".hint1,.cover").show();
            $(".hint1").children().html("姓名不能为空！");
            setTimeout(function () {  
                $(".hint1,.cover").hide();
            },3000)
        }else if(mobileno==""||mobileno==undefined){
            $(".hint1,.cover").show();
            $(".hint1").children().html("手机号码不能为空！");
            setTimeout(function () {  
                $(".hint1,.cover").hide();
            },3000)
        }else if(!mobileReg.test(mobileno)){
            $(".hint1,.cover").show();
            $(".hint1").children().html("手机号码格式不正确！");
            setTimeout(function () {  
                $(".hint1,.cover").hide();
            },3000)
        }else if(consultcontent==""||consultcontent==undefined){
            $(".hint1,.cover").show();
            $(".hint1").children().html("请输入您想咨询的问题！");
            setTimeout(function () {  
                $(".hint1,.cover").hide();
            },3000)
        }else{
            $.ajax({
                type:"post",
                url:wqturl+"/saveWqtNetConsult.action",
                dataType:"json",
                data:{
                    "netConsult.plateform":plateform,
                    "netConsult.kind":kind,
                    "netConsult.cityname":cityname,
                    "netConsult.consultcontent":consultcontent,
                    "netConsult.connector":connector,
                    "netConsult.mobileno":mobileno   
                },
                success:function(data){
                    if(data.result==1){
                        $(".hint1").show().children().html("您的信息已提交成功,客服稍后会联系您");
                        setTimeout(function(){
                            $(".hint1,.cover").hide();
                        },3000);
                        $("#phoneNumber,#name,#remark").val('');
                    }  
                }
            })
        }
    })

    //新闻切换
    $(".news_genre").click(function () {  
        var $this=$(this);
        var i=$this.index();
        $this.addClass('on').siblings().removeClass('on');
        $(".news_content").eq(i).show().siblings(".news_content").hide();
    })
})
