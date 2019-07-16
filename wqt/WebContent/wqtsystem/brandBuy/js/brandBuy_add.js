

//$('#brandassemble').combobox({
//    onChange: function() {
//        var value = $('#brandassemble').combobox('getValues');
//    }
//});

//查询按钮
function submitForm()
{
//	var brandassemble=$('#brandassemble').combobox('getValues');
	
    $('#brandBuyForm').form('submit', {   
	   onSubmit: function(){  
	    	return $(this).form('enableValidation').form('validate');
	    },  
	    success:function(data)
	    {  
	    	alert(data);
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	        parent.layer.close(index);
	        parent.window.location.href='brandBuy_list.html';
	    }  
	}); 
}


//关闭窗口
function doClose()
{   
//	console.log($("#brandgroup").combobox("getValues"));
//	alert($("#brandgroup").combobox("getValues"));
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='brandBuy_list.html';
}



$(function(){
	$.ajax({
		url:'sysBrandBuy_selectBrandShopKindList.action',
		type:'get',
		dataType:'json',
		success:function(data){
			var json = data.msg;
			var data = [{"text":'请选择',"value":''}];
			for(var i=0;i<json.length;i++){
				var value = json[i].id;
				var text = json[i].kindname;
				data.push({"text":value+text,"value":value});
			}
			$("#brandkind").combobox("loadData",data);
		}
	})
	$('#brandkind').combobox({
        onChange: function () {
        	var brandkind=$('#brandkind').textbox('getValue');
        	if(brandkind<10){
        		brandkind="0"+brandkind+"00";
        	}else{
        		brandkind=brandkind+"00";
        	}
        	$.ajax({
        		url:'sysBrandBuy_selectBrandShopGroupList.action',
        		type:'get',
        		data:{
        			'iprBrandGroup.brandkind':brandkind
        		},
        		dataType:'json',
        		success:function(data){
        			$("#_easyui_textbox_input11").next().remove();
        			var json = data.msg;
        			var data = [];
        			for(var i=0;i<json.length;i++){
	        			var value = json[i].groupcode;
	        			var text = json[i].groupname;
	        			data.push({"text":value+text,"value":value});
        			}
        			$("#brandgroup").combobox("loadData",data);
        		}
        	})
        }
    });
})
