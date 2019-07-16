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
	var url='sysCopyBuy_selectCopyrightBuyList.action';
	
	url+='?iprCopyrightBuy.buycontent='+buycontent
	     +'&iprCopyrightBuy.copyrightkind='+copyrightkind
	     +'&iprCopyrightBuy.transfermethod='+transfermethod
	     +'&iprCopyrightBuy.competentmethod='+competentmethod
	     +'&iprCopyrightBuy.competentarea='+competentarea
	     +'&iprCopyrightBuy.competentrange='+competentrange
	     +'&iprCopyrightBuy.state='+state;
    
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



function formatregyears(val,row,index){
	if(!(row.regyears==undefined)){
		var text="";
		text=row.regyears.substring(0,10);  
	    return text;
	}
}

function formattmethod(val,row,index){
	var text='';
	if(row.transfermethod==1)
	{
		text='转让';
	}
	else if(row.transfermethod==2)
	{
		text='授权';
	}
	else if(row.transfermethod==3)
	{
		text='分账';
	}
    return text;
}
function formatcmethod(val,row,index){
	var text='';
	if(row.competentmethod==1)
	{
		text='独家';
	}
	else if(row.competentmethod==2)
	{
		text='非独家';
	}
    return text;
}
function formatarea(val,row,index){
	var text='';
	if(row.competentarea==1)
	{
		text='中国大陆';
	}
	else if(row.competentarea==2)
	{
		text='港澳台';
	}
	else if(row.competentarea==3)
	{
		text='全球';
	}
	else if(row.competentarea==4)
	{
		text='其他';
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
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectProduct('+row.id+')">完善求购信息</a>';
    return text;
}  

//店铺下架

function doAdd()
{
	layer.open({
	    type : 2,
	    title : '新增版权求购',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '580px', '400px' ],
	    content : 'copyrightBuy_add.html'
	});
}


//完善版权信息
//brandid 商标ID
function  perfectProduct(patentid)
{
	layer.open({
		    type : 2,
		    title : '版权求购完善',
		    shadeClose : true,
		    shade : 0.8,
		    area : [ '580px', '350px' ],
		    content : 'copyrightBuy_update.html?id='+patentid // iframe的url
		});
}



