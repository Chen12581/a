/* 获取url的search */
function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};

var newsid=getParameter('newsid');
$(function(){	
	$('#id').val(newsid);	
});


//查询按钮
function doSubmitForm()
{
	//orderworkerid=$('#orderworkerid').val();
	var jobtime=$('#jobtime').datetimebox('getValue');
	if(jobtime==null || jobtime=="")
	{
		alert("请设置发布时间");
		return;
	}
	$('#state').val("3");	
	$('#developtime').val(jobtime);	
	$("#linetimebtn").linkbutton("disable");

    $('#linetimeForm').form('submit', {   
	    onSubmit: function(){  
	    	return $(this).form('enableValidation').form('validate');
	    },  
	    success:function(data)
	    {  
	       // var result = eval('('+data+')');
	    	alert("设置定时上线成功");
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	        parent.layer.close(index);
	        parent.window.location.href='news_list.html';
	    }  
	}); 
}

//关闭窗口
function doClose()
{   
	
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='loanorder.html';
}