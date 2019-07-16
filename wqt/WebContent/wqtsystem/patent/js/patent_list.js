$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var patentname="";
	var kindid="";
	var patentno="";
	var shopcode="";
	var state="";
	patentname=$('#patentname').textbox('getValue');
	kindid=$('#kindid').combobox('getValue');
	shopcode=$('#shopcode').textbox('getValue');
	patentno=$('#patentno').textbox('getValue');
	state=$('#state').combobox('getValue');
	var url='sysPatent_selectPatentShopList.action';
	
	url+='?iprPatentShop.patentname='+patentname
		 +'&iprPatentShop.kindid='+kindid
		 +'&iprPatentShop.patentno='+patentno
		 +'&iprPatentShop.shopcode='+shopcode
	     +'&iprPatentShop.state='+state
    
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
		url:"sysPatent_delectPatentShop.action",
		data:{
			'iprPatentShop.id':id,
			'iprPatentShop.state':state,
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
		text=a+'至'+b;
	    return text;
	}
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
function formatiss(val,row,index){
	var text='';
	if(row.isspecial==1)
	{
		text='特价商品';
	}
	else if(row.isspecial==2)
	{
		text='非特价商品';
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
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectPatent('+row.id+')">完善专利</a>';
	text=text+'<a href="javascript:void(0);" style="margin-left:5px;" onclick="submitshop('+row.id+')">专利上线</a>'
	text=text+'<a href="javascript:void(0);" style="margin-left:5px;" onclick="cancelshop('+row.id+')">专利下线</a>'
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
	
	var m=confirm("您确定要将此专利停售")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysPatent_updatePatentShopToCode.action",	
			dataType:"json",
			data:{
				'iprPatentShop.id':shopid,
				'iprPatentShop.state':6
			},
			success:function(data){
				alert(data.msg);
				doSubmitForm();					
			}
		})		
	}
}

function  submitshop(shopid){
	var m=confirm("您确定要将此专利上线")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysPatent_updatePatentShopToCode.action",	
			dataType:"json",
			data:{
				'iprPatentShop.id':shopid,
				'iprPatentShop.state':2
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
	    title : '新增专利',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '600px', '500px' ],
	    content : 'patent_add.html'
	});
}

function doAdds(){
	 layer.open({
	    type : 2,
	    title : '批量新增专利',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '950px', '450px' ],
	    content : 'patent_adds.html',
	});
}


//完善版权信息
//brandid 商标ID
function  perfectPatent(patentid)
{
	layer.open({
		    type : 2,
		    title : '专利完善',
		    shadeClose : true,
		    shade : 0.8,
		    area : [ '600px', '500px' ],
		    content : 'patent_update.html?id='+patentid // iframe的url
		});
}



