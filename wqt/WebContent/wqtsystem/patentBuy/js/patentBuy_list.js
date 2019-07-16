$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var buycontent="";
	var kindid="";
	var patenttype="";
	var busikind="";
	var patentstate="";
	var state="";
	buycontent=$('#buycontent').textbox('getValue');
	kindid=$('#kindid').combobox('getValue');
	patenttype=$('#patenttype').combobox('getValue');
	busikind=$('#busikind').combobox('getValue');
	patentstate=$('#patentstate').combobox('getValue');
	state=$('#state').combobox('getValue');
	var url='sysPatentBuy_selectPatentBuyPage.action';
	
	url+='?iprPatentBuy.buycontent='+buycontent
	     +'&iprPatentBuy.kindid='+kindid
	     +'&iprPatentBuy.patenttype='+patenttype
	     +'&iprPatentBuy.busikind='+busikind
	     +'&iprPatentBuy.patentstate='+patentstate
	     +'&iprPatentBuy.state='+state;
    
    $("#dictDataGrid").datagrid({
    	url : url
    });
}

function doDeletes()
{
	 alert('不要急，暂时不用');
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
function formatkind(val,row,index){
	var text='';
	if(row.busikind==1)
	{
		text='出售商品';
	}
	else if(row.busikind==2)
	{
		text='授权商品';
	}
    return text;
}
function formatpstate(val,row,index){
	var text='';
	if(row.patentstate==1)
	{
		text='授权未下证';
	}
	else if(row.patentstate==2)
	{
		text='已下证';
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


//操作列表
function formatOper(val,row,index){
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectProduct('+row.id+')">完善信息</a>';
    return text;
}  

//店铺下架

function doAdd()
{
	layer.open({
	    type : 2,
	    title : '新增专利求购',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '580px', '400px' ],
	    content : 'patentBuy_add.html'
	});
}


//完善版权信息
//brandid 商标ID
function  perfectProduct(patentid)
{
	layer.open({
		    type : 2,
		    title : '求购完善',
		    shadeClose : true,
		    shade : 0.8,
		    area : [ '580px', '350px' ],
		    content : 'patentBuy_update.html?id='+patentid // iframe的url
		});
}



