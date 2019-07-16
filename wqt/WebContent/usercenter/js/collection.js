$(
    $('.delate').click(function () {
        var id=$(this).children('a').attr('data-id'),
            kind=$(this).children('a').attr('data-kind');
        console.log(id,kind);
        $.ajax({
            type:'post',
            url:wqturl+'/delcollect.action',
            dataType:'json',
            data:{
                'collectid':id,
                'collectkind':kind
            },
            success:function(){
                window.location.reload();
            },
            error:function(){
                console.log('error');
            }
        })
    })
);