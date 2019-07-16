$(
  $(".recharge_tab ul").on('click','li',function(){
      var i=$(this).index();
      if(!$(this).is('.on')){
          $(this).addClass("on").siblings().removeClass("on");
          $(".recharge_cont_ul>li").eq(i).show().siblings().hide();
      }
  }),
  $(".recharge_bank_ul").on('click','li',function(){
      if(!$(this).is(".on")){
        $(this).addClass("on").siblings().removeClass("on");
      }
  })
);