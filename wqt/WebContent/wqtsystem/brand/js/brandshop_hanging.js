$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var brandname="";
	var state="";
	var regcode="";
	var brandcode="";
	var brandkind="";
	brandname=$('#brandname').textbox('getValue');
	brandcode=$('#brandcode').textbox('getValue');
	regcode=$('#regcode').textbox('getValue');
	state=$('#state').combobox('getValue');
	brandkind=$('#brandKind').combobox('getValue');
	if(brandkind!=0){
		if(brandkind<10){
			brandkind="0"+brandkind+"00";
		}else{
			brandkind=brandkind+"00";
		}
	}
	var url='sysBrand_sysBrandShopList.action';
	
	url+='?brandShop.orderdefault=1&brandShop.brandname='+brandname
	     +'&brandShop.brandcode='+brandcode
	     +'&brandShop.state='+state
	     +'&brandShop.regcode='+regcode
	     +'&brandShop.brandkind='+brandkind;
    
    $("#dictDataGrid").datagrid({
    	url : url
    });
}
function doClearForm(){
	window.location.reload()
}

function doDeletes()
{
	var m=confirm("您确定删除此信息？")
	if(m==true){
		var ids=[];
		var states=[];
		var rows = $("#dictDataGrid").datagrid("getSelections");    // 获取所有选中的行
		for (var i = 0; i < rows.length; i++) {
			   ids.push(rows[i].id);
			   states.push(rows[i].state);
			}
			var id=ids.join();
			var state=states.join();
		$.ajax({
			url:"sysBrand_deleteIprBrandShopState.action",
			data:{
				'brandShop.id':id,
				'brandShop.state':state,
			},
			type:"get",
			dataType:"json",
			success:function(data){
				alert(data.msg)
				window.location.reload();
			}
		})	
	}
}

function formatvalidity(val,row,index){
	if(!(row.startvalidity==undefined || row.endvalidity==undefined)){
		var text="";
		var a=row.startvalidity.substring(0,10);     
		var b=row.endvalidity.substring(0,10);
		text=a+'至'+b;
	    return text;
	}
}  

function formatkind(val,row,index){
	var text=row.brandkind;
	if(text!=undefined){
		text=text.substring(0,2);
	}
    return text;
}

function formatarea(val,row,index){
	var text='';
	if(row.area==1)
	{
		text='大陆';
	}
	else if(row.area==2)
	{
		text='港澳台';
	}
    return text;
}

function formattype(val,row,index){
	var text='';
	if(row.rbrand==1)
	{
		text='R标';
	}
	else if(row.rbrand==2)
	{
		text='TM标';
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
	else if(row.state==5)
	{
		text='下架';
	}
	else if(row.state==6)
	{
		text='停售';
	}
    return text;
}  

//操作列表
function formatOper(val,row,index){
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectBrand('+row.id+')">完善商标</a>';
	text=text+'<a href="javascript:void(0);" style="margin-left:5px;" onclick="submitshop('+row.id+','+row.templateid+')">商标上线</a>'
	text=text+'<a href="javascript:void(0);" style="margin-left:5px;" onclick="cancelshop('+row.id+','+row.templateid+')">商标下线</a>'
    return text;
}  

//店铺下架
function  cancelshop(shopid,templateid)
{
//	layer.open({
//			    type : 2,
//			    title : '店铺停售',
//			    shadeClose : true,
//			    shade : 0.8,
//			    area : [ '400px', '350px' ],
//			    content : 'stopshop_dialog.html?shopid=' + shopid+'&templateid='+templateid // iframe的url
//     });
	
	var m=confirm("您确定要将此商标停售")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysBrand_updateBrandShop.action",	
			dataType:"json",
			data:{
				'brandShop.id':shopid,
				'brandShop.state':6
			},
			success:function(data){
				alert(data.msg);
				doSubmitForm();					
			}
		})		
	}
}

//店铺上线
function  submitshop(shopid,templateid)
{
	
	var m=confirm("您确定要将此商标上线")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysBrand_updateIprBrandShopState.action",	
			dataType:"json",
			data:{
				'brandShop.id':shopid,
				'brandShop.state':2
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
	    title : '新增商标',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '900px', '670px' ],
	    content : 'brandshop_add.html'
	});
}


//完善商标信息
//brandid 商标ID
function  perfectBrand(brandid)
{
	layer.open({
		    type : 2,
		    title : '商标完善',
		    shadeClose : true,
		    shade : 0.8,
		    area : [ '900px', '670px' ],
		    content : 'brandshop_update.html?brandid='+brandid // iframe的url
		});
}

function doAdds(){
	 layer.open({
	    type : 2,
	    title : '批量新增商标',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '950px', '450px' ],
	    content : 'brandshop_adds.html',
	});
}

function doOnline(){
	var m=confirm("您确定要将此商标上线")
	if(m==true){
		var ids=[];
		var rows = $("#dictDataGrid").datagrid("getSelections");    // 获取所有选中的行
		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].id);
			}
			var id=ids.join();
			$.ajax({
				type:"post",
				url:"sysBrand_updateIprBrandShopState.action",	
				dataType:"json",
				data:{
					'brandShop.id':id,
					'brandShop.state':2
				},
				success:function(data){
					alert(data.msg);
					doSubmitForm();					
				}
			})
	}
}


