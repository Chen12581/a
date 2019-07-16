

//$('#brandassemble').combobox({
//    onChange: function() {
//        var value = $('#brandassemble').combobox('getValues');
//    }
//});

//查询按钮
function submitForm()
{
	var title=$("#title").val();
	if(title==null || title=='')
	{
		alert("请输入标题");
		return;
	}
	
	var ue =  UE.getEditor('newsEditor');
	var text = ue.getContentTxt();
	$('#simpledesc').val(text.substring(0,140));
	console.log($('#simpledesc').val());

	var url="sysProblem_insertWqtProblem.action";
	$('#wqtProblemForm').form('submit', 
	{  
        url:url,  
        onSubmit: function(){  
         if($("#wqtProblemForm").form("validate"))  
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


$(function(){
	$('#problemkind').combobox({
        onChange: function () {
        	var problemkind=$('#problemkind').textbox('getValue');
        	$.ajax({
        		url:'sysProblem_selectWqtsonproblemkind.action',
        		type:'get',
        		data:{
        			'wqtProblemKind.problemkind':problemkind
        		},
        		dataType:'json',
        		success:function(data){
        			var json = data.result;
        			var data = [];
        			for(var i=0;i<json.length;i++){
        			var value = json[i].sonproblemkind;
        			var text = json[i].sonproblemkindname;
        			data.push({"text":text,"value":value});
        			}
        			$("#sonproblemkind").combobox("loadData",data);
        		}
        	})
        }
    });
	
})


//关闭窗口
function doClose()
{   
//	console.log($("#brandgroup").combobox("getValues"));
//	alert($("#brandgroup").combobox("getValues"));
	window.history.back();  //返回上一页
}




