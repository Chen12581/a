$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var buycontent="";
	var copyrightkind="";
	var transfermethod="";
	var competentmethod="";
	var competentarea="";
	var competentrange="";
	var state="";
	buycontent=$('#buycontent').textbox('getValue');
	copyrightkind=$('#copyrightkind').combobox('getValue');
	transfermethod=$('#transfermethod').combobox('getValue');
	competentmethod=$('#competentmethod').combobox('getValue');
	competentarea=$('#competentarea').combobox('getValue');
	competentrange=$('#competentrange').combobox('getValue');
	state=$('#state').combobox('getValue');
	var url='sysBrandBuy_selectBrandBuyList.action';
	
	url+='?iprBrandBuy.buycontent='+buycontent
	     +'&iprBrandBuy.copyrightkind='+copyrightkind
	     +'&iprBrandBuy.transfermethod='+transfermethod
	     +'&iprBrandBuy.competentmethod='+competentmethod
	     +'&iprBrandBuy.competentarea='+competentarea
	     +'&iprBrandBuy.competentrange='+competentrange
	     +'&iprBrandBuy.state='+state;
    
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
		text='未处理';
	}
	else if(row.state==2)
	{
		text='已处理';
	}
    return text;
}




function formatassemble(val,row,index){
	var text='';
//	var arr=[];
//	console.log("a"+val);
//	console.log(index);
//	console.log(row);
//	if(row.brandassemble.indexOf(",")){
//		arr=val.split(",");
//		for(var i=0;i<arr.length;i++){
//			console.log("b"+arr[i]);
//			
//		}
//	}else{
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
	                url: "sysBrand_brandKindsel.action?industryid=" + row.value
	            });  
	        }  
	    }  
	});
	
});
//操作列表
function formatOper(val,row,index){
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectProduct('+row.id+')">完善求购信息</a>';
    return text;
}  

//店铺下架

function doAdd()
{
	layer.open({
	    type : 2,
	    title : '新增商标求购',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '700px', '650px' ],
	    content : 'brandBuy_add.html'
	});
}


//完善版权信息
//brandid 商标ID
function  perfectProduct(patentid)
{
	layer.open({
		    type : 2,
		    title : '商标求购完善',
		    shadeClose : true,
		    shade : 0.8,
		    area : [ '700px', '350px' ],
		    content : 'brandBuy_update.html?id='+patentid // iframe的url
		});
}



