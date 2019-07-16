talkweb.Bus.ready({
	items : [
	{
		classPath:"Components.Form",
		options:{
			id:"modifyPasswordform",
			container:"modifyPasswordform",
			saveInstance:true,
			haveSubmitBtn: false, //是否有提交按钮
            haveResetBtn: false, //是否有重置按钮
            resetToBlank: false,
            dataSource : "user_initModifyPassWordForm.action",
			action : "user_modifyPassWord.action",
            submitCallback: function(result){
                alert(result.msg);
            	talkweb.ControlBus.getInstance("modifyPasswordform").resetClick();
            },
            errorFile: "../jsconfig/errorConfig.json",
            items : [
            {
            	classPath:"BaseControl.Label",
            	width:"100%",
            	options:{
            		id:"accountName",
            		name:"accountName",
            		notes:"账号："
            	}
            },{
            	classPath:"BaseControl.Password",
            	width:"100%",
            	options:{
            		id:"oldPassword",
            		name:"oldPassword",
            		width:"200px",
            		notes:"旧密码：",
            		validateItems: {
                        requires: true
                    }
            	}
            },{
            	classPath:"BaseControl.Password",
            	width:"100%",
            	options:{
            		id:"newPassword",
            		name:"newPassword",
            		width:"200px",
            		notes:"新密码：",
            		validateItems: {
                        requires: true
                    }
            	}
            },{
            	classPath:"BaseControl.Password",
            	width:"100%",
            	options:{
            		id:"repeatPassword",
            		name:"repeatPassword",
            		width:"200px",
            		notes:"确认新密码：",
            		validateItems: {
                        requires: true
                    }
            	}
            }
            ]
		}
	},{
		classPath:"BaseControl.Button",
		options:{
			container:"buttons",
			value:"保存",
			className:"btn_save",
			click:tijiao
		}
	},{
		classPath:"BaseControl.Button",
		options:{
			value:"重置",
			className:"btn_reset",
			container:"buttons",
			click:function(){
				talkweb.ControlBus.getInstance("modifyPasswordform").resetClick();
			}
		}
	}
	]
});

function tijiao(){
	var formobj = talkweb.ControlBus.getInstance("modifyPasswordform");
	formobj.submit();
}