
/* 获取url的search */
	function getParameter(sProp) {
	    var re = new RegExp(sProp + "=([^\&]*)", "i");
	    var a = re.exec(document.location.search);
	    if (a == null)
	        return null;
	    return a[1];
	};

	var workerid=getParameter('brandkind');
	var shopid=getParameter('shopid');
	$(document).ready(function(){
		var url='sysBrand_brandGroupsel.action?brandkind='+workerid;
		$('#dictDataGrid').datagrid({url:url});
		
	})
	




function formatOper(val,col,index){
			var text='';
			return text='<a href="javascript:void(0);" id="view1" name="view1" style="margin-left:5px;" onclick="addNews('+index+')">选择</a>';
		}
			
		function addNews(index){
// 			alert(workerid.substring(0,2));
// 			alert(index+1)
			var x=workerid.substring(0,2);
			var y=index+1;
			if(y<10){
				y='0'+y;
			}
			var z=x+y;
			window.location.href='brandshop_branditem.html?brandkind='+workerid+'&groupcode='+z+"&shopid="+shopid;
		}
				
		var brandkind=workerid;
		var d='';
		d=brandkind.substring(0,1);
		if(d>0){
			brandkind=brandkind.substring(0,2);
		}else{
			brandkind=brandkind.substring(1,2);
		}
			
			$.ajax({
				type:"GET",
				url:"sysBrand_selBrandKind.action",
				type:"json",
				success:function(data){
					var data=data.result;
					var id=data[brandkind-1].kindcode;
						id=id.substring(0,2);
					var dd="";
						dd='<span>【'+id+' '+data[brandkind-1].kindname+'】</span>';
					$("#toolbar").append(dd);
				}
			})		
		