
//$(function(){	
//	  $('#brandindustry').combobox({  
//	        onSelect: function (row) {  
//	            if (row != null) {  
//	                $('#brandkind').combobox({  
//	                    url: "sysBrand_brandKindsel?industryid=" + row.value
//	                });  
//	            }  
//	        }  
//	    });  
//});


var id=getParameter('id');

function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};



$(function(){	
	$('#brandBuyForm').form('load', 'sysBrandBuy_selectBrandBuyOne?iprBrandBuy.action.id='+id);
	$("#brandBuyForm").form({ 
		 onLoadSuccess: function () { 
			 
			 var curWwwPath = window.document.location.href;
	            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	            var pathName = window.document.location.pathname;
	            var pos = curWwwPath.indexOf(pathName);
	            //获取主机地址，如： http://localhost:8083
	            var localhostPaht = curWwwPath.substring(0, pos);
	            //获取带"/"的项目名，如：/uimcardprj
	            var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
			   $("#viewimg").attr('src',localhostPaht+"/"+$('#patentphoto').val()); 
			// document.getElementById("filepath").innerHTML=$('#newicon').val();
		 } 
	});
});


//保存按钮
function submitForm()
{
      	    $('#brandBuyForm').form('submit', {   
      		    onSubmit: function(){  
      		    	return $(this).form('enableValidation').form('validate');
      		    },  
      		    success:function(data)
      		    {  
      		    	var obj = JSON.parse(data);
      		    	alert(obj.msg);
      		    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
      		        parent.layer.close(index);
      		        parent.window.location.href='brandBuy_list.html';
      		    }  
      		});
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
//        			$("#_easyui_textbox_input11").next().remove();
        			var json = data.msg;
        			var data = [];
        			for(var i=0;i<json.length;i++){
	        			var value = json[i].groupcode;
	        			var text = json[i].groupname;
	        			data.push({"text":value+text,"value":value});
        			}
        			$("#brandgroup").combobox("loadData",data);
        			var group=$("#brandgroup").combobox("getValues")
        				for (var j = 0; j < group.length; j++) {
        					for(var i=0;i<json.length;i++){
								if($.trim(group[j])==json[i].groupcode){
									console.log($('#_easyui_combobox_i5_'+i));
									$('#_easyui_combobox_i5_'+i).addClass("combobox-item-selected");
								}
						}
        			}
        		}
        	})
        }
    });
})


//关闭窗口
function doClose()
{   
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='patent_list.html';
}