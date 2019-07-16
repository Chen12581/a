$(function(){	

});


//提交信息
function doSubmitForm()
{
	//新闻标题
	var outtitle=$("#outtitle").val();
	if(outtitle==null || outtitle=='')
	{
		alert("请输入友情链接标题");
		return;
	}
	
	//新闻来源
	var outurl=$("#outurl").val();
	if(outurl==null || outurl=='')
	{
		alert("请输入友情链接地址");
		return;
	}
	
	 var url="sysnews_saveNewsOutUrl.action";
	 $('#outurl_addform').form('submit', 
	{  
        url:url,  
        onSubmit: function(){  
         if($("#outurl_addform").form("validate"))  
             return true  
         else  
              return false;  
         },  
        //注意ajax的url的后台action方法必须有返回值return "json"，而不是return null,否则下面的回调函数不起作用，sucess方法失效  
        success:function(data){  
            //此处data={"Success":true}实际为字符串，而不是json对象，需要用如下代码处理  
        	alert(data);  
        	window.history.back();  //返回上一页
        
        }
	}); 
	 
}

//关闭窗口
function doClose()
{   
	window.history.back();  //返回上一页
}