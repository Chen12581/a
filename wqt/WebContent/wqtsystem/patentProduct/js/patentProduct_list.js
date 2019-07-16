$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var productname="";
	var kindid="";
	var state="";
	productname=$('#productname').textbox('getValue');
	kindid=$('#kindid').combobox('getValue');
	state=$('#state').combobox('getValue');
	var url='sysPatent_selectIprPatentProductList.action';
	
	url+='?iprPatentProduct.productname='+productname
	     +'&iprPatentProduct.kindid='+kindid
	     +'&iprPatentProduct.state='+state;
    
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
		text='编辑';
	}
	else if(row.state==2)
	{
		text='在售';
	}
	else if(row.state==3)
	{
		text='预定';
	}
	else if(row.state==4)
	{
		text='售完';
	}
    return text;
}

//操作列表
function formatOper(val,row,index){
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectProduct('+row.id+')">完善服务</a>';
    return text;
}  

//店铺下架

function doAdd()
{
	layer.open({
	    type : 2,
	    title : '新增专利服务',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '700px', '275px' ],
	    content : 'patentProduct_add.html'
	});
}


//完善版权信息
//brandid 商标ID
function  perfectProduct(patentid)
{
	layer.open({
		    type : 2,
		    title : '服务完善',
		    shadeClose : true,
		    shade : 0.8,
		    area : [ '700px', '275px' ],
		    content : 'patentProduct_update.html?id='+patentid // iframe的url
		});
}



