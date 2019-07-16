$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var title="";
	var problemkind="";
	var sonproblemkind="";
	title=$('#title').textbox('getValue');
	sonproblemkind=$('#sonproblemkind').combobox('getValue');
	problemkind=$('#problemkind').combobox('getValue');
	var url='sysProblem_selectWqtProblemPage.action';
	
	url+='?wqtProblem.title='+title
	     +'&wqtProblem.problemkind='+problemkind
	     +'&wqtProblem.sonproblemkind='+sonproblemkind;
    
    $("#dictDataGrid").datagrid({
    	url : url
    });
}

function doDeletes()
{
	 alert('不要急，暂时不用');
}

function formatkind(val,row,index){
	var text='';
	if(row.kind==1)
	{
		text='服务类';
	}
	else if(row.kind==2)
	{
		text='交易类';
	}
    return text;
} 


function formatstate(val,row,index){
	var text='';
	if(row.state==1)
	{
		text='编辑';
	}
	else if(row.state==2)
	{
		text='发布';
	}
    return text;
}

function formatproblemkind(val,row,index){
	var text='';
	if(row.problemkind=="ipr")
	{
		text='知识产权';
	}
	else if(row.problemkind=="es")
	{
		text='企业服务';
	}
	else if(row.sonproblemkind=="user")
	{
		text='用户帮助';
	}
	else if(row.sonproblemkind=="es")
	{
		text='安全保障';
	}
    return text;
}

function formatsonproblemkind(val,row,index){
	var text='';
	if(row.sonproblemkind=="brand")
	{
		text='商标';
	}
	else if(row.sonproblemkind=="copyright")
	{
		text='版权';
	}
	else if(row.sonproblemkind=="patent")
	{
		text='专利';
	}
	else if(row.sonproblemkind=="service")
	{
		text='服务';
	}
	else if(row.sonproblemkind=="trade")
	{
		text='交易';
	}
	else if(row.sonproblemkind=="user")
	{
		text='用户帮助';
	}
	else if(row.sonproblemkind=="sec")
	{
		text='安全保障';
	}
    return text;
}



//操作列表
function formatOper(val,row,index){
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectProduct('+row.id+')">完善信息</a>';
    return text;
}  

//新增
function  doAdd()
{
	window.location.href='wqtProblem_add.html';
}


//修改
function perfectProduct(newsid)
{
	window.location.href='wqtProblem_update.html?newsid='+newsid;
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





