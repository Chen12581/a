
/* 获取url的search */
function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};

var	brandkind=getParameter('brandkind');
var groupcode=getParameter('groupcode');
var itemcode=getParameter('itemcode');
var itemname=getParameter('itemname');
var shopid=getParameter('shopid');
$(document).ready(function(){
	var url='sysBrand_selIprBrandShopGroup.action?shopid='+shopid;
	$('#dictDataGrid').datagrid({url:url});
	
})
		$("#brandkind").attr("name",brandkind);
		$("#groupcode").attr("name",groupcode);
		$("#itemcode").attr("name",itemcode);
		$("#shopid").attr("name",shopid);
		
		
			
	
		function save(){
			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		     parent.layer.close(index);
 		     parent.window.location.href='brandshop_add.html?brandid='+shopid;
		}
	
	
		function add(){
				window.location.href='brandshop_brandkind.html?shopid='+shopid;
			
		}
			$.ajax({
				url:"sysBrand_saveBrandShopInfo.action",
				type:"get",
				data:{
					'brandkind':brandkind,
					'groupcode':groupcode,
					'itemcode':itemcode,
					'shopid':shopid,
				},
				dataType:"json",
				success:function(data){
					
				}
			})
			
	function formatOper(val,row,index){
		var text='';
		    text='<a href="javascript:void(0);" id="view6" name="view6" style="margin-left:5px;" onclick="delInfos('+row.id+')">删除</a>';
	    return text;
			} 	
	
	function formatOper1(val,row,index){
		var text='';
		    text='<a href="javascript:void(0);" id="view6" name="view6" style="margin-left:5px;" onclick="delInfos1('+row.id+')">删除</a>';
	    return text;
			} 
	
	function delInfos(id){
		var m=confirm("您确定删除此信息？")
		if(m==true){
			$.ajax({
				type:"get",
				url:"sysBrand_deleteBrandShopItem.action",	
				dataType:"json",
				data:{
					'brandShopItem.id':id
				},
				success:function(data){
					$('#dictDataGrid1').datagrid('reload');  
				}
			})		
		}
	}		
	
	function delInfos1(id){
		var m=confirm("您确定删除此信息？")
		if(m==true){
			$.ajax({
				type:"get",
				url:"sysBrand_deleteBrandShopGroup.action",	
				dataType:"json",
				data:{
					'brandShopGroup.id':id
				},
				success:function(data){
					$('#dictDataGrid').datagrid('reload');    
				}
			})	
			
		}
	}
			
	
	