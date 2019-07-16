
$(function(){	
	  $('#brandindustry').combobox({  
	        onSelect: function (row) {  
	            if (row != null) {  
	                $('#brandkind').combobox({  
	                    url: "sysBrand_brandKindsel?industryid=" + row.value
	                });  
	            }  
	        }  
	    });  
});

var id=getParameter('id');

function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};

$(function(){	
	$('#brandForm').form('load', 'sysBrand_selectBrandRegcodeSailOne?iprBrandRegecodesail.id='+id);
});

/**
 * 下拉列表反写
 * @returns
 */
$(document).ready(function(){
    //do something
	
})

//查询按钮
function submitForm()
{
    $('#brandForm').form('submit', {   
	    onSubmit: function(){  
	    	return $(this).form('enableValidation').form('validate');
	    },  
	    success:function(data)
	    {  
	    	var ojb = JSON.parse(data); 
	    	alert(ojb.msg);
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	        parent.layer.close(index);
	        parent.window.location.href='brandRegcodeSail_hanging.html';
	    }  
	}); 
}

//关闭窗口
function doClose()
{   
	
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='brandRegcodeSail_hanging.html';
}