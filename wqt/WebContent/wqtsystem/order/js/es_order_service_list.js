$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var ordercode="";
	var servicekind="";
	var companytype="";
	var state="";
	ordercode=$('#ordercode').textbox('getValue');
	servicekind=$('#servicekind').combobox('getValue');
	companytype=$('#companytype').combobox('getValue');
	state=$('#state').combobox('getValue');
	
	var url='sysEsorder_selectEsOrderServicePage.action';
	
	url+='?esOrderServices.ordercode='+ordercode
	     +'&esOrderServices.servicekind='+servicekind
	     +'&esOrderServices.companytype='+companytype;
	     +'&esOrderServices.state='+state
    
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
		url:"sysEstrade_deleteCompany",
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

function formatservicekind(val,row,index){
	var text='';
	if(row.servicekind==1)
	{
		text='商贸贸易类';
	}
	else if(row.servicekind==2)
	{
		text='科技类';
	}
	else if(row.servicekind==3)
	{
		text='文化传媒类';
	}
	else if(row.servicekind==4)
	{
		text='咨询管理类';
	}
	else if(row.servicekind==5)
	{
		text='经济金融类';
	}
	else if(row.servicekind==6)
	{
		text='餐饮服务类';
	}
	else if(row.servicekind==7)
	{
		text='其他';
	}
    return text;
}
function formatcompanytype(val,row,index){
	var text='';
	if(row.companytype==1)
	{
		text='有限责任公司';
	}
	else if(row.companytype==2)
	{
		text='股份有限公司';
	}
	else if(row.companytype==3)
	{
		text='个人独资公司';
	}
	else if(row.companytype==4)
	{
		text='分公司';
	}
    return text;
}
function formatstate(val,row,index){
	var text='';
	if(row.state==1)
	{
		text='提交待付款';
	}
	else if(row.state==2)
	{
		text='已付定金';
	}
	else if(row.state==3)
	{
		text='已付全款，办理中';
	}
	else if(row.state==4)
	{
		text='办理完成';
	}
	else if(row.state==5)
	{
		text='订单取消';
	}
	else if(row.state==6)
	{
		text='订单退款';
	}
	else if(row.state==7)
	{
		text='订单失效';
	}
    return text;
}
//操作列表
function formatOper(val,row,index){
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectCompany('+row.id+')">完善信息</a>';
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
			url:"sysEstrade_updateEsTradeCompanyShopToCode",	
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

//function doAdd()
//{
//	layer.open({
//	    type : 2,
//	    title : '新增公司',
//	    shadeClose : true,
//	    shade : 0.8,
//	    area : [ '700px', '720px' ],
//	    content : 'tradeCompany_add.html'
//	});
//}


//完善公司信息
//function  perfectCompany(Companyid)
//{
//	layer.open({
//		    type : 2,
//		    title : '公司完善',
//		    shadeClose : true,
//		    shade : 0.8,
//		    area : [ '700px', '700px' ],
//		    content : 'tradeCompany_update.html?id='+Companyid // iframe的url
//		});
//}

function doClearForm(){
	window.location.reload();
}



