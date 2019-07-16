/**
 * Created by Administrator on 2018/10/17
 */

$(function () {  

    for(var i=0;i<6;i++){
        var tit=$('.problems>ul>li').eq(i).children(":first").html();
        if(tit=='知识产权'){
            $('.problems>ul>li').eq(i).children(":last").children().attr('href','/problem/patent/1.html');
        }
        if(tit=='企业服务'){
            $('.problems>ul>li').eq(i).children(":last").children().attr('href','/problem/service/1.html');
        }
        if(tit=='用户帮助'){
            $('.problems>ul>li').eq(i).children(":last").children().attr('href','/problem/user/1.html');
        }
        if(tit=='安全保障'){
            $('.problems>ul>li').eq(i).children(":last").children().attr('href','/problem/sec/1.html');
        }
        if(tit=='网店转让'){
            $('.problems>ul>li').eq(i).children(":last").children().attr('href','/problem/eshop/1.html');
        }
        if(tit=='财税服务'){
            $('.problems>ul>li').eq(i).children(":last").children().attr('href','/problem/cs/1.html');
        }
    }
    

    //客服验证
    $('.proving').click(function () {  
        $('.serValidate').show();
    })
    $('.serValidate .close').click(function () {  
        $('.serValidate').hide();
    })
    $('.validatebtn').click(function () {  
        var num=$("#validateNo").val();
        checkServicer(num)
    })
    $('#validateNo').keydown(function(e){
        var num=$("#validateNo").val();
        if(e.keyCode=="13"){
            checkServicer(num)
        }
    })
    function checkServicer(a) {  
        //console.log(a);
        if(a!=""&&a!=undefined){
            $.ajax({
                type:"post",
                url:wqturl+"/configClient.action?service="+a,
                dataType:"json",
                success:function (data) {  
                    //console.log(data);
                    if(data.result){
                        $('.result').addClass('yes');
                        $('.result .p1').html('可放心交易');
                        $('.result .p3>span').html(a);
                        $('.result .p3>em').html('为真客服！可放心与之交易！');
                    }else{
                        $('.result').removeClass('yes');
                        $('.result .p1').html('不可与之交易');
                        $('.result .p3>span').html(a);
                        $('.result .p3>em').html('为假客服！不可与之交易！');
                    }
                },
                error:function (xhr,state,errorThrown){  
                    requesFail(xhr);
                    console.log(xhr,state,errorThrown);
                }
            })
        }else{
            return false;
        } 
    }
})