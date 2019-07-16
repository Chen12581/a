$(document).ready(function(){
   
})

//查询按钮
function doSubmitForm()
{
	var userid="";
	var applyname="";
	var applyaddr="";
	var connect="";
	var developtime="";
	var state="";
	var workerid="";
	userid=$('#userid').textbox('getValue');
	applyname=$('#applyname').textbox('getValue');
	applyaddr=$('#applyaddr').textbox('getValue');
	connect=$('#connect').textbox('getValue');
	developtime=$('#developtime').textbox('getValue');
	state=$('#state').combobox('getValue');
	workerid=$('#workerid').textbox('getValue');
	var url='sysBrand_selectBrandApplysail';
	
	url+='?iprBrandApplysail.userid='+userid
	     +'&iprBrandApplysail.applyname='+applyname
	     +'&iprBrandApplysail.applyaddr='+applyaddr
	     +'&iprBrandApplysail.connect='+connect
	     +'&iprBrandApplysail.developtime='+developtime
	     +'&iprBrandApplysail.state='+state
	     +'&iprBrandApplysail.states='+"1,2,3"
	     +'&iprBrandApplysail.workerid='+workerid;
    
    $("#dictDataGrid").datagrid({
    	url : url
    });
}

function doDeletes()
{
	 alert('不要急，暂时不用');
}

//样式化店铺标题
function formatvalidity(val,row,index){ 
	var text="";
	 text=row.startvalidity+row.endvalidity;
    return text;
}  

laydate.render({
    elem: '#developtime' //指定开始日期元素
});

function formatstate(val,row,index){
	var text='';
	if(row.state==1)
	{
		text='用户提交信息';
	}
	else if(row.state==2)
	{
		text='业务员已受理';
	}
	else if(row.state==3)
	{
		text='处理完成';
	}
	else if(row.state=='')
	{
		text='';
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
	var text='<a href="javascript:void(0);" id="view" name="view" style="margin-left:5px;" onclick="perfectBrand('+row.id+')">完善商标</a>';
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
	
	var m=confirm("您确定要将此商标停售？")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysBrand_updateBrandApplysail",	
			dataType:"json",
			data:{
				'iprBrandApplysail.id':shopid,
				'iprBrandApplysail.state':4
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
	    title : '新增申请人商标',
	    shadeClose : true,
	    shade : 0.8,
	    area : [ '600px', '300px' ],
	    content : 'brandApplySail_add.jsp'
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
		    area : [ '700px', '700px' ],
		    content : 'brandApplySail_update.html?id='+brandid // iframe的url
		});
}



