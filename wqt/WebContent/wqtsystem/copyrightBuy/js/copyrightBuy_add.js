

//$('#brandassemble').combobox({
//    onChange: function() {
//        var value = $('#brandassemble').combobox('getValues');
//    }
//});

//查询按钮
function submitForm()
{
	var buycontent=$('#buycontent').textbox('getValue');
	if(buycontent==null || buycontent=="")
	{
		alert("请输入求购关键字");
		return;
	}
    $('#copyrightBuyForm').form('submit', {   
	   onSubmit: function(){  
	    	return $(this).form('enableValidation').form('validate');
	    },  
	    success:function(data)
	    {  
	    	alert(data);
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	        parent.layer.close(index);
	        parent.window.location.href='copyrightBuy_list.html';
	    }  
	}); 
}


//关闭窗口
function doClose()
{   
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='copyrightBuy_list.html';
}



