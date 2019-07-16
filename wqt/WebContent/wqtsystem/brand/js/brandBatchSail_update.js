
/**
 * 下拉列表反写
 * @returns
 */
var id=getParameter('id');

function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};

$(function(){	
	$('#brandForm').form('load', 'sysBrand_selectBrandBatchsailOne?id='+id);
});


$(document).ready(function(){
    //do something
	 var options_state = document.getElementById('state').children;
	 for(var i=0;i<options_state.length;i++){
		 if(options_state[i].value=="${iprBrandBatchsail.state}"){
			 options_state[i].selected=true;
		 }
	 }
})
//查询按钮
function submitForm()
{
//	var brandname=$('#brandname').textbox('getValue');
//	//商标名称
//	if(brandname==null || brandname=="")
//	{
//		alert("请输入商标名称");
//		return;
//	}
	
    $('#brandForm').form('submit', {   
	    onSubmit: function(){  
	    	return $(this).form('enableValidation').form('validate');
	    },  
	    success:function(data)
	    {  
	    	var obj = JSON.parse(data);
	    	alert(obj.msg);
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	        parent.layer.close(index);
	        parent.window.location.href='brandBatchSail_hanging.html';
	    }  
	}); 
}

laydate.render({
    elem: 'input[name="iprBrandBatchsail.developtime"]' //指定开始日期元素
});


//关闭窗口
function doClose()
{   
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='brandBatchSail_hanging.html';
}