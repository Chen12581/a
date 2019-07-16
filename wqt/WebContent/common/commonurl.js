var  wqturl="http://www.w7tong.com";
var  casurl="http://www.w7tong.com/user/login.html";
// var reg1="^((http|https|tencent)?://)";
// var re=new RegExp(reg1);

window.onload = function () 
{	
	var reg1="^((http|https|tencent)?://)";
	var re=new RegExp(reg1);
	$('img').each(function(){
		if(!re.test($(this).attr('src'))){
		 	$(this).attr('src',wqturl+ $(this).attr('src'));
		}
	});
	$('a').each(
		function(){
			if(
				!(
					$(this).attr("href")=='javascript:void(0);' || 
					$(this).attr("href")=='javascript:;' || 
					$(this).attr("href")=='#'||
					re.test($(this).attr("href"))
				)
			  ){
				$(this).attr('href',wqturl+$(this).attr('href'));
			}
	});
    $("#register_entry").click(function(){
        window.location.href=wqturl+'/user/register.html?service='+encodeURIComponent(window.location.href);
    })
    $("#login_entry").attr('href',casurl+'?service='+window.location.href);
	//退出
	$("#logout").click(function(e){
		e.preventDefault();
		$.ajax({
			type:'post',
			url:wqturl+'/loginOut.action',
			dataType:'json',
			data:{},
			success:function(){
				window.location.reload();
			},
			error:function(){
				console.log('error');
			}
		})
	})

	//正在开发
	var location=window.location.href;
	var nourl="http://www.w7tong.com/develop.html?service=";
    $('.develop').attr('href',nourl+location);
};

