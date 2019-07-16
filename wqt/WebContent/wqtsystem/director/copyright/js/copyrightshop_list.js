$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var copyrightname="";
	var copyrightcode="";
	var transfermethod="";
	var copyrightkind="";
	var displayname="";
	var state="";
	copyrightname=$('#copyrightname').textbox('getValue');
	displayname=$('#displayname').textbox('getValue');
	copyrightcode=$('#copyrightcode').textbox('getValue');
	copyrightkind=$('#copyrightkind').combobox('getValue');
	transfermethod=$('#transfermethod').combobox('getValue');
	state=$('#state').combobox('getValue');
	var url='sysCopyright_selectCopyrightShopList.action';
	
	url+='?iprCopyrightShop.copyrightname='+copyrightname
		 +'&iprCopyrightShop.displayname='+displayname
		 +'&iprCopyrightShop.copyrightcode='+copyrightcode
		 +'&iprCopyrightShop.copyrightkind='+copyrightkind
	     +'&iprCopyrightShop.transfermethod='+transfermethod
	     +'&iprCopyrightShop.state='+state;
//	     +'&iprCopyrightShop.states='+"1,2,3,4,5,6";
    
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
		url:"sysCopyright_deleteCopyrightShopState.action",
		data:{
			'iprCopyrightShop.id':id,
			'iprCopyrightShop.state':state,
		},
		type:"get",
		dataType:"json",
		success:function(data){
			alert(data.msg)
			window.location.reload();
		}
	})	
}

//样式化店铺标题
function formatvalidity(val,row,index){ 
	var text="";
	 text=row.startvalidity+row.endvalidity;
    return text;
}  

function formatname(val,row,index){
	 return '<a href="http://ipr.w7tong.com/'+row.htmlpath+'" target="_blank"  title="'+row.copyrightname+'" style="margin-left:5px;">'+row.copyrightname+'</a>'; 
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
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectCopyright('+row.id+')">完善版权</a>';
	text=text+'<a href="javascript:void(0);" style="margin-left:5px;" onclick="submitshop('+row.id+')">版权上线</a>'
	text=text+'<a href="javascript:void(0);" style="margin-left:5px;" onclick="cancelshop('+row.id+')">版权下线</a>'
    return text;
}  

//店铺下架
function  cancelshop(id){
	var m=confirm("您确定要将此版权停售")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysCopyright_updateCopyrightShopState.action",	
			dataType:"json",
			data:{
				'iprCopyrightShop.id':id,
				'iprCopyrightShop.state':6
			},
			success:function(data){
				alert(data.msg);
				doSubmitForm();					
			}
		})		
	}
}
function  submitshop(id){
	var m=confirm("您确定要将此版权上线")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysCopyright_updateCopyrightShopState.action",	
			dataType:"json",
			data:{
				'iprCopyrightShop.id':id,
				'iprCopyrightShop.state':2
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
	    title : '新增版权',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '670px', '600px' ],
	    content : 'copyrightshop_add.html'
	});
}


//完善版权信息
//brandid 商标ID
function  perfectCopyright(copyrightid)
{
	layer.open({
		    type : 2,
		    title : '版权完善',
		    shadeClose : true,
		    shade : 0.8,
		    area : [ '700px', '700px' ],
		    content : 'copyrightshop_update.html?id='+copyrightid // iframe的url
		});
}



