$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var patenttype="";
	var state="";
	patenttype=$('#patenttype').combobox('getValue');
	state=$('#state').combobox('getValue');
	var url='sysPatent_selectPatentSailList.action';
	
	url+='?iprPatentSail.patenttype='+patenttype
	     +'&iprPatentSail.state='+state;
    
    $("#dictDataGrid").datagrid({
    	url : url
    });
}

function doDeletes()
{
	 alert('不要急，暂时不用');
}

function formatvalidity(val,row,index){
	if(!(row.applydate==undefined || row.validitydate==undefined)){
		var text="";
		var a=row.applydate.substring(0,10);     
		var b=row.validitydate.substring(0,10);
		text=a+'-'+b;
	    return text;
	}
} 


function formatstate(val,row,index){
	var text='';
	if(row.state==1)
	{
		text='待处理';
	}
	else if(row.state==2)
	{
		text='已处理';
	}
    return text;
}


function formattype(val,row,index){
	var text='';
	if(row.patenttype==1)
	{
		text='发明专利';
	}
	else if(row.patenttype==2)
	{
		text='实用新型';
	}
	else if(row.patenttype==3)
	{
		text='外观设计 ';
	}
    return text;
}

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
//操作列表
function formatOper(val,row,index){
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectProduct('+row.id+')">修改为已处理</a>';
    return text;
}  

//店铺下架

function  perfectProduct(patentid)
{
	$.ajax({
			type:"post",
			url:"sysPatent_updatePatentSail.action",	
			dataType:"json",
			data:{
				'iprPatentSail.state':2,
				'iprPatentSail.id':patentid
			},
			success:function(data){
				alert(data.msg);
			}
	})
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    parent.layer.close(index);
    parent.window.location.href='patentSail_list.html';
}



