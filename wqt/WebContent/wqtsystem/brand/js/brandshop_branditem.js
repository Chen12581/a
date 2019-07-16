	
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
	var shopid=getParameter('shopid');
	$(document).ready(function(){
		//alert(groupcode);
		var url='sysBrand_brandItemsel.action?groupcode='+groupcode;
		$('#dictDataGrid').datagrid({url:url});
		
	})
	
		function doDeletes(){
			$('#dictDataGrid').datagrid('clearSelections');
		}
		
		function save(){
			var ids=[];
			var names=[];
			var rows = $("#dictDataGrid").datagrid("getSelections");    // 获取所有选中的行
			for (var i = 0; i < rows.length; i++) {
	 		   ids.push(rows[i].itemcode);
	 		   names.push(rows[i].itemname);
	 		}
				var itemcode=ids.join();
				var itemname=names.join();
				window.location.href='brandshop_shop.html?brandkind='+brandkind+'&groupcode='+groupcode+'&itemcode='+itemcode+'&itemname='+itemname+"&shopid="+shopid;
			
		}
		function rtop(){
			window.location.href='brandshop_brandgroup.html?brandkind='+brandkind;
		}
		
		var d='';
			d=groupcode.substring(2,4);
			if(d<10){
				d=d.substring(1,2);
			}
	$.ajax({
		type:"GET",
		url:"sysBrand_brandGroupsel.action?brandkind="+brandkind,
		type:"json",
		success:function(data){
			var data=data.msg;
			var dd="";
				dd='<span>【'+data[d-1].groupcode+" "+data[d-1].groupname+'】</span>';
			$("#toolbar").append(dd);
		}
	})