$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var username="";
	var workerkind="";
	var workername="";
	var workercode="";
	var state="";
	username=$('#username').textbox('getValue');
	workerkind=$('#workerkind').combobox('getValue');
	workername=$('#workername').textbox('getValue');
	workercode=$('#workercode').textbox('getValue');
	state=$('#state').combobox('getValue');
	var url='sysWorker_selWqtWorkerListPage.action';
	
	url+='?wqtWorker.username='+username
	     +'&wqtWorker.workerkind='+workerkind
	     +'&wqtWorker.workername='+workername
	     +'&wqtWorker.workercode='+workercode
	     +'&wqtWorker.state='+state;
    
    $("#dictDataGrid").datagrid({
    	url : url
    });
}

function doDeletes()
{
	 alert('不要急，暂时不用');
}

function formatisshow(val,row,index){
	var text='';
	if(row.isshow==1)
	{
		text='展示';
	}
	else if(row.isshow==2)
	{
		text='不展示';
	}
    return text;
} 


function formatstate(val,row,index){
	var text='';
	if(row.state==1)
	{
		text='在职';
	}
	else if(row.state==2)
	{
		text='离职';
	}
	else if(row.state==2)
	{
		text='请假';
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
	layer.open({
	    type : 2,
	    title : '新增客服',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '600px', '550px' ],
	    content : 'wqtWorker_add.html'
	});
}


//修改
//完善版权信息
function perfectProduct(newsid)
{
	layer.open({
	    type : 2,
	    title : '客服完善',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '600px', '550px' ],
	    content : 'wqtWorker_update.html?newsid='+newsid
	});
}





