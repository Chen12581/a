

//查询按钮
function submitForm()
{
	var productname=$('#productname').textbox('getValue');
	var productdesc=$('#productdesc').textbox('getValue');
	if(productname==null || productname==""){
		alert("请输入产品名称");
		return;
	}
	if(productdesc==null || productdesc==""){
		alert("请输入产品描述");
		return;
	}
    $('#productForm').form('submit', {   
	   onSubmit: function(){  
	    	return $(this).form('enableValidation').form('validate');
	    },  
	    success:function(data)
	    {  
	    	alert(data);
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	        parent.layer.close(index);
	        parent.window.location.href='brandProduct_list.html';
	    }  
	}); 
}

//关闭窗口
function doClose()
{   
	
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='brandProduct_list.html';
}


