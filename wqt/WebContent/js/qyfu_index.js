$(".logo_img>img").click(function(){

	alert(111);
	$.ajax({
        type:"POST",
        url:"192.168.1.146:8888/wqt_cas/login?service=http://www.wqt.com/wqt",
        dataType : "json",
        success:function(data, status){
        	alert(1);
           alert(data);
        },
        error:function(result){
        	alert(2);
        	  console.log(result);
        }
    });
})


//发布需求 弹框
    // 显示
    $(".search_btn>a:last-child").click(function(){
        $(".needk").css("display","block");
    });
    //隐藏
    $(".dialog-close").click(function(){
        $(".needk").css("display","none");
    });
    //选择需求
    $(".category-one-level>ul").on("click","li",function(){
        $(this).addClass("active").siblings().removeClass("active");
        var i=$(this).index();
        $(".category-three-level>ul").eq(i).show().siblings().hide();
        $(".category-three-level>ul").eq(i).siblings().find("li").removeClass("active");
        $(".supplement-item").html("");
        $(".supplement-info>textarea").css({"height":"106px","margin-top":"0"});
    })
    //选择服务
    $(".category-three-level ul li").click(function(){
        $(this).addClass("active").siblings().removeClass("active");
        $(this).find("a").html()
        if($(this).find("a").html()=="商标购买"){
            $(".supplement-item").html("");
            $(".supplement-info>textarea").css({"height":"82px","margin-top":"24px"});
            $(".supplement-item").eq(0).html("您所在的行业是<input data-attribute-index='0' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
            $(".supplement-item").eq(1).html("您的购买预算<input data-attribute-index='1' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
        }else if($(this).find("a").html()=="代理记账"){
            $(".supplement-item").html("");
            $(".supplement-info>textarea").css({"height":"82px","margin-top":"24px"});
            $(".supplement-item").eq(0).html("您的公司名称<input data-attribute-index='0' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
            $(".supplement-item").eq(1).html("公司所在城市<input data-attribute-index='1' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
        }else if($(this).find("a").html()=="公司注册"){
            $(".supplement-item").html("");
            $(".supplement-info>textarea").css({"height":"58px","margin-top":"48px"});
            $(".supplement-item").eq(0).html("请填写您心仪的公司名<input data-attribute-index='0' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
            $(".supplement-item").eq(1).html("公司所在城市<input data-attribute-index='1' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
        }else if($(this).find("a").html()=="企业名称变更"){
            $(".supplement-item").html("");
            $(".supplement-info>textarea").css({"height":"58px","margin-top":"48px"});
            $(".supplement-item").eq(0).html("您的公司名称<input data-attribute-index='0' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
            $(".supplement-item").eq(1).html("公司所在城市<input data-attribute-index='1' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
            $(".supplement-item").eq(2).html("您需要变更的内容是<input data-attribute-index='2' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
        }else if($(this).find("a").html()=="企业资质办理"){
            $(".supplement-item").html("");
            $(".supplement-info>textarea").css({"height":"58px","margin-top":"48px"});
            $(".supplement-item").eq(0).html("您需要办理的资质类型是<input data-attribute-index='0' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
            $(".supplement-item").eq(1).html("您的公司名称<input data-attribute-index='1' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
            $(".supplement-item").eq(2).html("公司所在城市<input data-attribute-index='2' type='text' class='J-supplement-input supplement-input' maxlength='50'>");
        }else{
            $(".supplement-item").html("");
            $(".supplement-info>textarea").css({"height":"106px","margin-top":"0"});
        }
    });
    //点击服务显示 地区
    $(".category-three-level>ul>li").click(
        function(){
            $(".task-pub-local-city-warp").show();
        }
    );
    //验证手机号码
    $(".task-step-modifyphone-inputwrap>input").blur(function(){
        var reg=/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;
        if(!reg.test($(this).val())){
            $(".j-phone-error").css("display","block");
            $(".validate-code>a").addClass("disabled");
        }else{
            $(".j-phone-error").css("display","none");
            $(".validate-code>a").removeClass("disabled");
        }
    });

//我要找人做  下拉框
$(".demand_box>i").hover(function(){
    $(".demand_box i ul").show();
},function(){
    $(".demand_box i ul").hide();});

$(".demand_box i ul").on("click","li",function(){
    $("#demand").val($(this).html());
    $(".demand_box i ul").hide();
});
//判断手机号码是否符合规则
var phonef=false;
    $("#phone").blur(function(){
       var reg=/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;
       if(reg.test($(this).val())){
           $(".error-d").hide();
           phonef=true;
       }else{
           $(".error-d").show();
           phonef=false;
       }
    });
//点击发布
$(".search_btn>a:first-child").click(function(){
    var consultname=$("#demand").val();
    var mobileno=$("#phone").val();
    if(phonef && consultname!=""){
        // $.ajax({
        //     type:"POST",
        //     url:"saveWqtNetConsult",
        //     data:{
        //         'wqtnetconsult.consultname':consultname,
        //         'wqtnetconsult.mobileno':mobileno
        //     },
        //     dataType:"json",
        //     success:function(){
        //         $(".prompt").stop(true).animate({
        //             zIndex:1000,
        //             opacity:1
        //         },2000,function(){
        //             $(".prompt").stop(true).animate({
        //                 zIndex:-1,
        //                 opacity:0
        //             },1000)
        //         })
        //     },
        //     error:function(){}
        // })
            $(".prompt").stop(true).animate({
                zIndex:1000,
                opacity:1
            },2000,function(){
                $(".prompt").stop(true).animate({
                    zIndex:-1,
                    opacity:0
                },1000)
            })
    }
});

//**************首页知识产权商标类型列表展示
// $.ajax({
//     type:"POST",
//     url:"brandKindList",
//     dataType:"json",
//     success:function(data){
//         aa(data[0].id);
//         var html="";
//         for(var i=0;i<data.length;i++){
//             html+=`<li><a href="javascript:void(0);">${data[i].industryname}</a></li>`
//         };
//         $(".intellectual_rt_bot_lf>ul").append(html);
//         $(".intellectual_rt_bot_lf>ul>li:first-child").addClass("active");
//     },
//     error:function(){
//         console.log("fail")
//     }
// });
//*****************首页知识产权商标列表展示（点击展示）
// $(".intellectual_rt_bot_lf>ul").on("click","li",function () {
//    if(!$(this).is(".active")){
//        $(this).addClass("active").siblings().removeClass("active");
//        var i=$(this).index();
//        $.ajax({
//            type:"POST",
//            url:"brandKindList",
//            dataType:"json",
//            success:function (data) {
//                aa(data[i].id);
//            }
//        })
//    }
// });
$(".intellectual_rt_bot_lf>ul").on("click","li",function () {
    if(!$(this).is(".active")){
        $(this).addClass("active").siblings().removeClass("active");
        var i=$(this).index();
        $(".intellectual_rt_bot_rt").eq(i).show().siblings(".intellectual_rt_bot_rt").hide();
    }
});
//**********************首页知识产权商标列表展示
// function aa(id){
//     $.ajax({
//         type:"POST",
//         url:"brandShopList",
//         data:{
//             'wqtBrandShop.brandkind':id
//         },
//         dataType:"json",
//         success:function(datalist){
//             var htmll="";
//             var htmlr="";
//             for(var i=0;i<6;i++){
//                 if(i<3){
//                     htmll+=`<li>
//                                 <a href="">
//                                     <div class="detail_box lf">
//                                         <p class="category">[${datalist.msg[i].kindname}]${datalist.msg[i].brandname}</p>
//                                         <p class="price">售价<span>￥${datalist.msg[i].price}</span></p>
//                                         <p class="brand_type"><span>${datalist.msg[i].assemble}</span></p>
//                                     </div>
//                                     <div class="img_box rt">
//                                         <img src="${datalist.msg[i].brandshopphoto}" alt="">
//                                     </div>
//                                 </a>
//                             </li>`
//                 }else{
//                     htmlr+=`<li>
//                                 <a href="">
//                                     <div class="detail_box lf">
//                                         <p class="category">[${datalist.msg[i].kindname}]${datalist.msg[i].brandname}</p>
//                                         <p class="price">售价<span>￥${datalist.msg[i].price}</span></p>
//                                         <p class="brand_type"><span>${datalist.msg[i].assemble}</span></p>
//                                     </div>
//                                     <div class="img_box rt">
//                                         <img src="${datalist.msg[i].brandshopphoto}" alt="">
//                                     </div>
//                                 </a>
//                             </li>`
//                 }
//             };
//             $(".intellectual_rt_bot_rt>ul:first-child").html(htmll);
//             $(".intellectual_rt_bot_rt>ul:last-child").html(htmlr);
//         },
//         error:function(){
//             console.log("fail");
//         }
//     })
// };

//********************首页企业交易
// $.ajax({
//     type:"POST",
//     url:"getCompanyList",
//     dataType:"json",
//     success:function(data){
//        var html="";
//        var datatm="";
//        for(var i=0;i<data.length;i++){
//                 datatm=data[i].manageyear+"-"+data[i].createtime.slice(0,4);
//                html+=`<li>
//                             <div class="img_box">
//                                 <img src="image/qyfu_index/image_03.jpg" alt="">
//                                 <span class="category">${data[i].kindname}</span>
//                             </div>
//                             <div class="detail">
//                                 <p class="title">${data[i].companyname}</p>
//                                 <p class="reg_money">注册资本：${data[i].regcapital}.00万</p>
//                                 <p class="time">成立时间：${datatm}</p>
//                                 <p class="taxes">纳税类型：${data[i].ratepaying}</p>
//                                 <p class="price">售价：<span>￥${data[i].price}</span></p>
//                                 <p class="btn_box"><a href="http://192.168.1.146:8089/es/company_deal/deal_details/dealDetails.html">立即购买</a></p>
//                             </div>
//                         </li>`
//        }
//        $(".company_deal_rt_lf>ul").html(html);
//     },
//     error:function(){
//         console.log("fail");
//     }
// });
//************************首页交易企业 推荐企业
// $.ajax({
//     type:"POST",
//     url:"getCompanyRecommendList",
//     dataType:"json",
//     success:function(data){
//         var html="";
//         for(var i=0;i<data.length;i++){
//             html+=`
//                     <li>
//                        <p class="title"><a href="http://192.168.1.146:8089/es/company_deal/deal_details/dealDetails.html">[${data[i].kindname}]${data[i].companyname}</a></p>
//                        <p class="reg_money">注册资本：${data[i].regcapital}.00万</p>
//                        <p class="price">售价：<span>￥${data[i].price}</span></p>
//                      </li>`
//         };
//         $(".company_deal_rt_rt>div>ul").html(html);
//     },
//     error:function(){
//         console.log("fail");
//     }
// });
//*******************************首页新闻列表
// $.ajax({
//     type:"POST",
//     url:"newsList",
//     dataType:"json",
//     success:function(data){
//         var htmla='';
//         var htmlb="";
//         var htmlc="";
//         var htmld="";
//         var htmle="";
//         var a=0;
//         var b=0;
//         for(var i=0;i<data.length;i++){
//             if(data[i].kindid==1){
//                 htmla+=`<li><a href="${data[i].htmlpath}">${data[i].title}</a></li>`
//             }else if(data[i].kindid==2){
//                 if(a==0){
//                     htmld+=`<div class="news_item_mid_img"></div>
//                              <div class="news_item_mid_txt">
//                                 <p class="title"><a href="${data[i].htmlpath}">${data[i].title}</a></p>
//                                 <p class="time">${data[i].createtime}</p>
//                             </div>`
//                     a++;
//                 }else{
//                      htmlb+=`<li><a href="${data[i].htmlpath}">${data[i].title}</a></li>`
//                 }
//             }else if(data[i].kindid==3){
//                 if(b==0){
//                     htmle+=`<div class="news_item_mid_img"></div>
//
//                             <div class="news_item_mid_txt">
//                                 <p class="title"><a href="${data[i].htmlpath}">${data[i].title}</a></p>
//                                 <p class="time">${data[i].createtime}</p>
//                             </div>`
//                     b++;
//                 }else{
//                      htmlc+=`<li><a href="${data[i].htmlpath}">${data[i].title}</a></li>`
//                 }
//             }
//         };
//         $(".news_item_mid").eq(1).append(htmld);
//         $(".news_item_mid").eq(2).append(htmle);
//         $(".news_item_bot>ul").eq(0).append(htmla);
//         $(".news_item_bot>ul").eq(1).append(htmlb);
//         $(".news_item_bot>ul").eq(2).append(htmlc);
//     },
//     error:function(){
//         console.log("fail");
//     }
// });
