
function doSubmitForm()
{
	var outtitle="";
	outtitle=$('#outtitle').textbox('getValue');
	var url='sysnew_selTSysOutUrlPage.action';
	
	url+='?tsysouturl.outtitle='+outtitle;
    $("#dictDataGrid").datagrid({
    	url : url
    });
}

function delOuturl(outurlid)
{
	var m=confirm("您确定删除此友情链接？")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysnews_delNewsOutUrl.action",	
			dataType:"json",
			data:{
				'wqtNewsOutUrl.id':outurlid
			},
			success:function(data){
				alert(data.msg);
				window.location.href='outurl_list.html';
			}
		})		
	}
}

//操作列表
function formatOper(val,row,index){
	var text='';
	    text=
	         '<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="delOuturl('+row.id+')">删除</a>';
    return text;
}  


//新增新闻
function  addOuturl()
{
	window.location.href='outurl_add.html';
}





