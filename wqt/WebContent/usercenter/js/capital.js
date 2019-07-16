$(
  $(".money_tab ul").on('click','li',function(){
      if(!$(this).is(".on")){
          var i=$(this).index();
          $(this).addClass("on").siblings().removeClass("on");
          $(".all_cont").eq(i).addClass("on").siblings(".all_cont").removeClass("on");
      }
  })
);