/**
 * Created by Administrator on 2017/12/20.
 */
(function(){
    $('.safe_line .edit').on('click','a',function(e){
        e.preventDefault();
        var aa = $(this).attr('href');
        aa = '.' + aa;
        $(aa).toggle().siblings('.user_form').hide();
    })
})();