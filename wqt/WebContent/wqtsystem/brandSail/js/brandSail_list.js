$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var brandKind="";
	var state="";
	brandKind=$('#brandKind').combobox('getText');
	state=$('#state').combobox('getValue');
	var url='sysBrandSale_selectBrandSailList.action';
	
	url+='?iprBrandSail.brandkind='+brandKind
	     +'&iprBrandSail.state='+state;
    
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




function formatassemble(val,row,index){
	var text='';
		if(row.brandassemble==1)
		{
			text='编辑';
		}else if(row.brandassemble==2)
		{
			text='在售';
		}else if(row.state==3)
		{
			text='预定';
		}
		else if(row.state==4)
		{
			text='售完';
		}
		return text;
//	}
	
}

function formatregyears(val,row,index){
	if(!(row.regyears==undefined)){
		var text="";
		text=row.regyears.substring(0,10);  
	    return text;
	}
}

function formatarea(val,row,index){
	var text='';
	if(row.area==1)
	{
		text='国内';
	}
	else if(row.area==2)
	{
		text='海外';
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


//完善信息
function  perfectProduct(patentid)
{
	$.ajax({
			type:"post",
			url:"sysBrandSale_updateBrandSale.action",	
			dataType:"json",
			data:{
				'iprBrandSail.state':2,
				'iprBrandSail.id':patentid
			},
			success:function(data){
				alert(data.msg);
			}
	})
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    parent.layer.close(index);
    parent.window.location.href='brandSail_list.html';
}


