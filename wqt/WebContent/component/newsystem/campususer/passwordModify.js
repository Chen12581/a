var request = fastDev.Browser.getRequest();
var oldPassword,newPassword,newRePassword;
function onAfterConstruct(){
	var o = fastDev("#uname");
	o.addText(request['usercode']);
}

function onSubmitSuccess(result) {
	fastDev.alert(result.msg, '信息提示', result.status, function(){
		if(result.status == 'ok') {
			parent.closeDialog();
		}
	});
}

function doSave() {
	fastDev("#pwd_error").hide();
	fastDev("#same_error").hide();
	var uid = request['userid'];
	
	if(uid!="-1"){
		oldPassword = fastDev.getInstance('oldPassword').getValue();
		newPassword = fastDev.getInstance('newPassword').getValue();
		newRePassword = fastDev.getInstance('newRePassword').getValue();
		if(oldPassword==newPassword&&oldPassword==newRePassword){
			//密码修改重复
			fastDev("#same_error").show();
		}
		//判断重复输入的密码是否相同
		else if(newPassword == newRePassword){
			//提交表单
			doSumbit();
		}else{
			//两次密码输入不一致
			fastDev("#pwd_error").show();
		}
	}else{
		fastDev.alert("用户尚未登录，不能修改密码！", '信息提示', "error");
	}
}

function doSumbit(){
	var pwdform = fastDev.getInstance('pwdModifyForm');
	pwdform.setOptions({
		action : 'user_modifyPassWord.action?userid=' + request['userid'] 
	+ '&oldPassword = ' + oldPassword + '&newPassword = ' + newPassword
	});
	pwdform.submit();
}

function doReset() {
	fastDev("#pwd_error").hide();
	fastDev("#same_error").hide();
	fastDev.getInstance('pwdModifyForm').resetData();
}