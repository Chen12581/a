

$(function() {
	if (window != top) {
		top.location.href = 'login.jsp';
	}
	;

	$('#loginForm').form({
		url : 'portal_loginin.action'
	});
	var userid = $("#USERID");
	var password = $("#PASSWORD");
	var valicode = $("#validateCode");
	$("#PASSWORDTIP").textbox('textbox').bind({
		'keypress' : loginByKey,
		'focus' : function (){
			$("#qiaoPwdTip")[0].style.display="none";
			$("#qiaoPwd")[0].style.display = ""; 
			$("#PASSWORD").textbox('textbox')[0].focus(); 
		}
	});
	userid.textbox('textbox').bind({
		'keypress' : loginByKey,
		'focus' : focusText(userid),
		'blur' : blurText(userid)
	});
	password.textbox('textbox').bind({
		'keypress' : loginByKey,
		'focus' : focusText(password),
		'blur' : blurText(password)
	});
	valicode.textbox('textbox').bind({
		'keypress' : loginByKey,
		'focus' : focusText(valicode),
		'blur' : blurText(valicode)
	});

});
var textVal = "";
var textVal2 = ""

function focusText(id) {

	return function() {
		textVal = id.textbox("getValue");
		if ((textVal == "用户名" || textVal == "密码" || textVal == "验证码")) {
			id.textbox("setValue", "");
		}
		if (id.is("#PASSWORD")) {
			id.textbox("textbox").attr("type", "password");
		}

	}
}

function blurText(id) {

	return function() {
		if (!id.textbox("getValue")) {
			if (id.is("#USERID")) {
				id.textbox("setValue", "用户名");
			}

			else if (id.is("#PASSWORD")) {
				//id.textbox("textbox").attr("type", "text");
				//$("#PASSWORD").textbox("setValue", "密码");
				$("#qiaoPwd")[0].style.display = "none";
				$("#qiaoPwdTip")[0].style.display = ""; 
			}

			else if (id.is("#validateCode"))
				id.textbox("setValue", "验证码");
			else
				id.textbox("setValue", textVal);
		}

	}
}

// 获取浏览器URL中参数，此处用于判断是否需要验证码。
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

function changeValidateImg() {
	$("#imgcode").attr("src", "validatecode.jsp?" + (new Date()).getTime());
}

function login() {
	var isAutoTest = getQueryString("isAutoTest");
	var url = 'portal_loginin.action';
	if (isAutoTest) {
		url = 'portal_login.action';

	}
	if ($('#loginForm').form("validate")) {
		$.post(url, {
			USERID : $("#USERID").textbox("getText"),
			PASSWORD : $("#PASSWORD").textbox("getText"),
			validateCode : $("#validateCode").textbox("getText")
		}, function(result) {
			var result = eval('(' + result + ')'); // change the JSON string to
													// javascript object
			$("#pwd_error").hide();
			$("#validate_error").hide();
			$("#code_error").hide();
			if (result.msg == "0") { // 用户验证成功
				location.href = "index.jsp";
			} else if (result.msg == "1") {// 存在多个帐号
				location.href = "userSelect.html";
			} else if (result.msg == "-1") { // 用户名不存在
				$("#pwd_error").show();
			} else if (result.msg == "-2") { // 密码错误
				$("#pwd_error").show();
			} else if (result.msg == "-5") { // 异常
				$("#code_error").show();
			} else if (result.msg == "-4") { // 验证码错误
				$("#validate_error").show();
			} else if (result.msg == "-3") {
				$("#accountforbidden_error").show();
			}
		}, "text");
	}

}

function reset() {
	$('#loginForm').form("reset");
}

function loginByKey(event) {
	var keycode = event.keyCode;
	if (keycode == 13) {
		login();
	}
}