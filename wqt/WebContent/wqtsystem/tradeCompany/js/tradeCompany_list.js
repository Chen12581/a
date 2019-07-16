$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var companytruename="";
	var state="";
	var companyindustry="";
	var regcapital="";
	companytruename=$('#companytruename').textbox('getValue');
	regcapital=$('#regcapital').textbox('getValue');
	state=$('#state').combobox('getValue');
	companyindustry=$('#companyindustry').combobox('getValue');
	
	var url='sysEscompany_selectEsTradeCompanyShopList.action';
	
	url+='?esTradeCompanyShop.companytruename='+companytruename
	     +'&esTradeCompanyShop.regcapital='+regcapital
	     +'&brandShop.state='+state
	     +'&esTradeCompanyShop.companyindustry='+companyindustry;
    
    $("#dictDataGrid").datagrid({
    	url : url
    });
	
}

function doDeletes()
{
	var ids=[];
	var names=[];
	var rows = $("#dictDataGrid").datagrid("getSelections");    // 获取所有选中的行
	for (var i = 0; i < rows.length; i++) {
		   ids.push(rows[i].id);
		   names.push(rows[i].state);
		}
		var id=ids.join();
		var state=names.join();
	$.ajax({
		url:"sysEscompany_deleteCompany.action",
		data:{
			'esTradeCompanyShop.id':id,
			'esTradeCompanyShop.state':state,
		},
		type:"get",
		dataType:"json",
		success:function(data){
			alert(data.msg)
			window.location.reload();
		}
	})
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

function formatWhether(val,row,index){
	var text='';
	if(row.bankaccount==1)
	{
		text='是';
	}
	else if(row.bankaccount==2)
	{
		text='否';
	}
    return text;
}
function formatWhether1(val,row,index){
	var text='';
	if(row.applybill==1)
	{
		text='是';
	}
	else if(row.applybill==2)
	{
		text='否';
	}
    return text;
}
function formatWhether2(val,row,index){
	var text='';
	if(row.netbank==1)
	{
		text='是';
	}
	else if(row.netbank==2)
	{
		text='否';
	}
    return text;
}
function formatHaveNo(val,row,index){
	var text='';
	if(row.debtissue==1)
	{
		text='无';
	}
	else if(row.debtissue==2)
	{
		text='有';
	}
	return text;
}
function formatHaveNo1(val,row,index){
	var text='';
	if(row.rightsissue==1)
	{
		text='无';
	}
	else if(row.rightsissue==2)
	{
		text='有';
	}
	return text;
}
function formatHaveNo2(val,row,index){
	var text='';
	if(row.businessissue==1)
	{
		text='无';
	}
	else if(row.businessissue==2)
	{
		text='有';
	}
	return text;
}
function formatHaveNo3(val,row,index){
	var text='';
	if(row.lawissue==1)
	{
		text='无';
	}
	else if(row.lawissue==2)
	{
		text='有';
	}
	return text;
}
function formatHaveNo4(val,row,index){
	var text='';
	if(row.dutyissue==1)
	{
		text='无';
	}
	else if(row.dutyissue==2)
	{
		text='有';
	}
	return text;
}
function formatHaveNo5(val,row,index){
	var text='';
	if(row.loanissue==1)
	{
		text='无';
	}
	else if(row.loanissue==2)
	{
		text='有';
	}
	return text;
}
function formatholddate(val,row,index){
	var text='';
	if(row.holddate==1)
	{
		text='1年以下';
	}
	else if(row.holddate==2)
	{
		text='1-2年';
	}
	else if(row.holddate==3)
	{
		text='2-3年';
	}
	else if(row.holddate==4)
	{
		text='3年以上';
	}
    return text;
}
function formatdutytype(val,row,index){
	var text='';
	if(row.dutytype==1)
	{
		text='小规模纳税人';
	}
	else if(row.dutytype==2)
	{
		text='一般纳税人';
	}
	else if(row.dutytype==3)
	{
		text='出口纳税人';
	}
	else if(row.dutytype==4)
	{
		text='未核税';
	}
    return text;
}
function formatregcapital(val,row,index){
	var text='';
	if(row.regcapital==1)
	{
		text='50万以下';
	}
	else if(row.regcapital==2)
	{
		text='50万-100万';
	}
	else if(row.regcapital==3)
	{
		text='100万-500万';
	}
	else if(row.regcapital==4)
	{
		text='500万-1000万';
	}
	else if(row.regcapital==5)
	{
		text='1000万以上';
	}
    return text;
}
function formattype(val,row,index){
	var text='';
	if(row.companytype==1)
	{
		text='有限责任公司';
	}
	else if(row.companytype==2)
	{
		text='个人独资公司';
	}
	else if(row.companytype==3)
	{
		text='集团公司';
	}
	else if(row.companytype==4)
	{
		text='港澳台公司';
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
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectCompany('+row.id+')">完善公司</a>';
	text=text+'<a href="javascript:void(0);" style="margin-left:5px;" onclick="submitshop('+row.id+')">公司上线</a>'
	text=text+'<a href="javascript:void(0);" style="margin-left:5px;" onclick="cancelshop('+row.id+')">公司下线</a>'
    return text;
}  

//店铺下架
function  cancelshop(shopid)
{
//	layer.open({
//			    type : 2,
//			    title : '店铺停售',
//			    shadeClose : true,
//			    shade : 0.8,
//			    area : [ '400px', '350px' ],
//			    content : 'stopshop_dialog.html?shopid=' + shopid+'&templateid='+templateid // iframe的url
//     });
	
	var m=confirm("您确定要将此公司停售")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysPatent_updateEsTradeCompanyShopToCode",	
			dataType:"json",
			data:{
				'esTradeCompanyShop.id':shopid,
				'esTradeCompanyShop.state':6
			},
			success:function(data){
				alert(data.msg);
				doSubmitForm();					
			}
		})		
	}
}

function  submitshop(shopid){
	var m=confirm("您确定要将此公司上线")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysEscompany_updateEsTradeCompanyShopToCode.action",	
			dataType:"json",
			data:{
				'esTradeCompanyShop.id':shopid,
				'esTradeCompanyShop.state':2
			},
			success:function(data){
				alert(data.msg);
				doSubmitForm();					
			}
		})		
	}
}

function doAdd()
{
	layer.open({
	    type : 2,
	    title : '新增公司',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '700px', '720px' ],
	    content : 'tradeCompany_add.html'
	});
}


//完善公司信息
function  perfectCompany(Companyid)
{
	layer.open({
		    type : 2,
		    title : '公司完善',
		    shadeClose : true,
		    shade : 0.8,
		    area : [ '700px', '700px' ],
		    content : 'tradeCompany_update.html?id='+Companyid // iframe的url
		});
}

function doClearForm(){
	window.location.reload();
}



