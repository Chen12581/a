$(function () {  
    var htmlhref=window.location.href;
    htmlhref=htmlhref.replace(/^http:\/\/[^/]+/, "");
    // console.log(htmlhref);
    var addr=htmlhref.substr(htmlhref.lastIndexOf('/', htmlhref.lastIndexOf('/') - 1) + 1);
    // console.log(addr);
    var index=addr.lastIndexOf("\/");
    var index1=addr.lastIndexOf("\.");
    // console.log(index);
    // console.log(index1);
    var str=decodeURI(addr.substring(0,index));
    var str1=parseInt(decodeURI(addr.substring(index+1,index1)));
    console.log(str1);
    
    if(str=='brand'){
        $('.help-problems-lba').eq(0).find('a').eq(0).addClass('on');
        $('.help-problems-lba').eq(0).children(".help-problems-lbab").css('display','block');
        $(".kind").html('商标');
    }
    if(str=='copyright'){
        $('.help-problems-lba').eq(0).find('a').eq(1).addClass('on');
        $('.help-problems-lba').eq(0).children(".help-problems-lbab").css('display','block');
        $(".kind").html('版权');
    }
    if(str=='patent'){
        $('.help-problems-lba').eq(0).find('a').eq(2).addClass('on');
        $('.help-problems-lba').eq(0).children(".help-problems-lbab").css('display','block');
        $(".kind").html('专利');
    }
    if(str=='service'){
        $('.help-problems-lba').eq(1).find('a').eq(0).addClass('on');
        $('.help-problems-lba').eq(1).children(".help-problems-lbab").css('display','block');
        $(".kind").html('企业服务');
    }
    if(str=='trade'){
        $('.help-problems-lba').eq(1).find('a').eq(1).addClass('on');
        $('.help-problems-lba').eq(1).children(".help-problems-lbab").css('display','block');
        $(".kind").html('企业交易');
    }
    if(str=='eshop'){
        $('.help-problems-lba').eq(2).find('a').addClass('on');
        $('.help-problems-lba').eq(2).children(".help-problems-lbab").css('display','block');
        $(".kind").html('网店转让');
    }
    if(str=='zc'){
        $('.help-problems-lba').eq(3).find('a').addClass('on');
        $('.help-problems-lba').eq(3).children(".help-problems-lbab").css('display','block');
        $(".kind").html('商标转让');
    }
    if(str=='cs'){
        $('.help-problems-lba').eq(4).find('a').addClass('on');
        $('.help-problems-lba').eq(4).children(".help-problems-lbab").css('display','block');
        $(".kind").html('财税服务');
    }
    if(str=='user'){
        $('.help-problems-lba').eq(5).find('a').addClass('on');
        $('.help-problems-lba').eq(5).children(".help-problems-lbab").css('display','block');
        $(".kind").html('用户帮助');
    }
    if(str=='sec'){
        $('.help-problems-lba').eq(6).find('a').addClass('on');
        $('.help-problems-lba').eq(6).children(".help-problems-lbab").css('display','block');
        $(".kind").html('安全保障');
    }
    $('.help-problems-lbaa').click(function () {
        if(!$(this).find('.help-problems-lbab-select').is('.on')){
            var height=$(this).siblings('.help-problems-lbab').height();
            $(this).siblings('.help-problems-lbab').css({'height':'0','display':'block'});
            console.log(height);
            $(this).parent().siblings().children('.help-problems-lbab').css('display','none');
            $(this).siblings('.help-problems-lbab').animate({height:height+'px'},"slow");
        }
    })
    // if(str=='problem'){
    //     if(str1>=16&&str1<=58){
    //         $('.help-problems-lba').eq(0).find('a').eq(0).addClass('on');
    //     }
    //     if(str1>=59&&str1<=63){
    //         $('.help-problems-lba').eq(0).find('a').eq(1).addClass('on');
    //     }
    //     if(str1>=64&&str1<=71){
    //         $('.help-problems-lba').eq(0).find('a').eq(2).addClass('on');
    //     }
    //     if(str1>=72&&str1<=84){
    //         $('.help-problems-lba').eq(1).find('a').eq(0).addClass('on');
    //     }
    //     if(str1>=85&&str1<=98){
    //         $('.help-problems-lba').eq(1).find('a').eq(1).addClass('on');
    //     }
    //     if(str1>=99&&str1<=103){
    //         $('.help-problems-lba').eq(3).find('a').addClass('on');
    //     }
    //     if(str1>=104&&str1<=111){
    //         $('.help-problems-lba').eq(2).find('a').addClass('on');
    //     }
    // }
    $('.help-problems-rcbc-t>div').click(function () {  
        $(".help-problems-rcbc").hide();
        if($(this).index()==0){
            $('.help-problems-rcbe').show().prev().hide();
        }else{
            $('.help-problems-rcbd').show().next().hide();
        }
    })
})