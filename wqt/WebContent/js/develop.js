(function(){
    var aa=3;
    function set() {
        if(aa<0 || aa===0){
            aa=3;
            window.location.href=decodeURIComponent(window.location.href.split('=')[1]);
        }else{
            $('.center span#develop').html(aa);
            aa--;
            setTimeout(function () {
                set();
            },1000);
        }
    };
    set();
}
)();