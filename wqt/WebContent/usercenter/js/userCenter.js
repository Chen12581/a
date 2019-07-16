/**
 * Created by Administrator on 2017/12/17.
 */
/************************联系地址动作效果的设置**********************/
(function(){
    $('.address_detail span').on('click','i',function(){
        $(this).siblings('ul').show();
        $(this).parent('span').attr('style','border-radius: 10px 10px 0 0 ');
        $(this).children('i').attr('style','border-radius: 0 10px 0 0;');
        $(this).attr('style','border-radius:0 10px 0 0;border-color: #009934');
    });

    /****************
    $('.address_detail span i').mouseenter(function(){
        $(this).children('ul').show();
        $(this).children('i').attr('style','border-radius: 0 10px 0 0;');
        $(this).attr('style','border-radius:10px 10px 0 0;border-color: #009934');
    });
     ******************/

    $('.address_detail span').mouseleave(function(){
        $(this).children('ul').hide();
        $(this).children('i').attr('style','border-radius:0 10px 10px 0');
        $(this).attr('style','border-radius:10px');
    });

    $('.address_detail span ul li').click(function(){
        var aa = $(this).html();
        $(this).parents().siblings('input').attr('value',aa);
        $(this).parents().siblings('i').attr('style','border-radius:0 10px 10px 0');
        $(this).parents('ul').hide();
    });
})();


(function(){

    var $province_1 = $('.province_1'), //获取省份下拉
        $province_2 = $('.province_2');//获取市下拉
})();


function editor(){
	var nickname = $ ('.uName input').val();
	var username = $('.tName input').val();
    var sex = $('.six input:checked').attr('id');
    var birthday = $('.date_input input').val();
    var email = $('.Email input').val();
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if(email=='undefined'||email==''){
        alert('亲，请您填写您的常用邮箱')
    }else if(filter.test(email)){
        if(username=='undefined'||username==''){
            alert('亲，请填写您的真实姓名')
        }else if(sex=='undefined'||sex==''){
            alert('亲，请选择您的性别')
        }else if(birthday=='undefined'||birthday==''){
            alert('亲，请填写您的出生日期')
        }else{
            $.ajax({
                type:"post",
                url:"editUser.action",
                dataType:"json",
                data:{
                	'wqtuserbasic.nickname':nickname,
                	'wqtuserbasic.sex':sex,
                    'wqtuserbasic.username':username,
                    'wqtuserbasic.email':email,
                    'wqtuserbasic.birthday':birthday
                },
                success:function(data){
                    alert(data)
                }
            })
        }
    }else{
        alert('亲，请您填写正确的邮箱信息')
    };

}



































