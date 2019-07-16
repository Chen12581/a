
fastDev(function() {
	if(window != top) {
		top.location.href = 'login.jsp';
	}
});

//获取浏览器URL中参数，此处用于判断是否需要验证码。
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
    }

function changeValidateImg(){
	fastDev("#imgcode").attr("src","validatecode.jsp?"+(new Date()).getTime());
}

function login() {
	var isAutoTest = getQueryString("isAutoTest");
	if(isAutoTest) 
		fastDev.getInstance('loginForm').setOptions({'action':'portal_login.action'});
	fastDev.getInstance('loginForm').submit();
}

function reset() {
	fastDev.getInstance('loginForm').resetData();
}

function onSubmitSuccess(result) {
	fastDev("#pwd_error").hide();
	fastDev("#validate_error").hide();
	fastDev("#code_error").hide();
	if(result.msg=="0"){ //用户验证成功
		location.href = "index.jsp";
	} else if(result.msg=="1"){//存在多个帐号
		location.href = "userSelect.html";
	}
	else if(result.msg=="-1"){ //用户名不存在
		fastDev("#pwd_error").show();
	}
	else if(result.msg=="-2"){ //密码错误
		fastDev("#pwd_error").show();
	}
	else if(result.msg=="-5"){ //异常
		fastDev("#code_error").show();
	}
	/*else if(result.msg=="-4"){ //验证码错误
		fastDev("#validate_error").show();			
	}*/else if(result.msg=="-3"){
		fastDev("#accountforbidden_error").show();
	}
}

function loginByKey(event) {
	var keycode = event.keyCode;
	if(keycode == 13) {
		login();
	}
}