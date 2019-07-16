/**
 * Created by Administrator on 2018/1/2.
 */

//横向轮播
// a:为原点 li b:为移动元素的内容 c：为整个移动的元素
function leftMov(a,b,c){
    var i=1;
    var timer=null;
    c.prepend(b.eq(b.length-1).clone(true));
    c.append(b.eq(0).clone(true));
    a.first().addClass('hover');
    c.css({left:-(b.width())});
    //定时器自动播放
    function lm(){
        i++;
        if (i==b.length+1) {
            c.stop(true).animate({left:-i*b.width()},1000,function(){
                c.css({left:-(b.width())});
            });
            i=1;
        }else{
            c.stop(true).animate({left:-i*b.width()},1000);
        };
        var n=i;
        n--;
        a.eq(n).addClass('hover').siblings().removeClass('hover');
    };
    timer=setInterval(lm,4000);
    b.hover(
        function(){
            clearInterval(timer);
            timer=null;
        },
        function() {
            timer=setInterval(lm,4000);
        }
    );
    // 鼠标划入原点
    a.hover(
        function(){
            clearInterval(timer);
            timer=null;
            i=$(this).index();
            c.stop(true).animate({left:-(i+1)*b.width()},1000);
            a.eq(i).addClass('hover').siblings().removeClass('hover');
        },
        function() {
            timer=setInterval(lm,4000);
        }
    );
};
leftMov($('.scroll_box ol li'),$('.scroll_box ul li'),$('.scroll_box ul'));


// 评论
var ppid='';
$(
    $(".xx_fh").click(function(){
        $(".pl_bg").show();
        ppid=$(this).attr("data_id");
    }),

    $(".fb").click(function () {
        var news_id=$(".hf_tj").attr("data_id"),
            child_text=$("#child_text").val().replace(/^\s*|\s*$/g,"");
        if(hk_pt===false){
            alert('请先完成滑块拼图！')
        }else if(child_text==''){
            alert('说点什么吧...')
        }else{
            $.ajax({
                type:'post',
                url:'commitNewsComment',
                dataType:'json',
                data:{
                    'wqtNewsComment.newsid':news_id,
                    'wqtNewsComment.newscomment':child_text,
                    'wqtNewsComment.pid':ppid
                },
                success:function(data){
                    alert('评论成功！');
                    $("#child_text").val("");
                    window.location.reload();
                },
                error:function (error) {
                    console.log(error)
                }
            })
        }
    })
);
$(".hf_tj").click(function(){
    var news_id=$(".hf_tj").attr("data_id"),
        text =$("#hf_textarea").val().replace(/^\s*|\s*$/g,"");
    console.log(news_id,text);
    if(hk_pt===false){
        alert('请先完成滑块拼图');
    }else if(text==''){
        alert("说点什么吧!")
    }else{
        $.ajax({
            type:'post',
            url:'commitNewsComment',
            dataType:'json',
            data:{
                'wqtNewsComment.newsid':news_id,
                'wqtNewsComment.newscomment':text
            },
            success:function(data){
                alert('评论成功！');
                $("#hf_textarea").val("");
                window.location.reload();
            },
            error:function (error) {
                console.log(error)
            }
        })
    }
});


$(".text_pl .qx").click(function(){
    $(".pl_bg").hide();
});

