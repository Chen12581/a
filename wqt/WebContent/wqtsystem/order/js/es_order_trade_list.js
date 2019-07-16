$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var ordercode="";
	var state="";
	ordercode=$('#ordercode').textbox('getValue');
	state=$('#state').combobox('getValue');
	
	var url='sysEstrade_selectEsOrderTradePage.action';
	
	url+='?esOrderTrade.ordercode='+ordercode
	     +'&esOrderTrade.state='+state
    
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
		url:"sysEstrade_deleteCompany.action",
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
			url:"sysEstrade_updateEsTradeCompanyShopToCode.action",	
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



