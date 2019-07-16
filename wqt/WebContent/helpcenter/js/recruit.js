$(()=>{
    $(".enterprise-recruitment-i-d-a").click(function () {  
        var i=$(this).index();
        $(".view-xq").eq(i).show();
    })
    $(".view-xq-bg-del").click(function () {  
        $(this).parent().parent().hide();
        $(this).next().show().next().hide();
    })
    $(".view-xq-bg-c>a").click(function () {  
        $(this).parent().parent().hide().next().show();
    })
})