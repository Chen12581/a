function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};

var shopid=getParameter('shopid');

function save(){
	var brandkind=[];
	var groupcode=[];
	var itemcode=[];
	var itemname=[];
	var rows = $("#dictDataGrid").datagrid("getSelections");    // 获取所有选中的行
	for (var i = 0; i < rows.length; i++) {
		brandkind.push(rows[i].brandkind);
		groupcode.push(rows[i].groupcode);
		itemcode.push(rows[i].itemcode);
		itemname.push(rows[i].itemname);
	}
		var brandkind=brandkind.join();
		var groupcode=groupcode.join();
		var itemcode=itemcode.join();
		var itemname=itemname.join();
		console.log(brandkind);
		console.log(groupcode);
		console.log(itemcode);
		console.log(itemname);
		window.location.href='brandshop_shop.html?brandkind='+brandkind+'&groupcode='+groupcode+'&itemcode='+itemcode+'&itemname='+itemname+"&shopid="+shopid;
			
}

$('#itemname').textbox({
	inputEvents: $.extend({},$.fn.textbox.defaults.inputEvents,{
		keyup: function(event){ 
			if(event.keyCode == 13) {
			  select();
			}
		}
	})
}); 
		
function select(){
	var itemname="";
	itemname=$('#itemname').textbox('getValue');
	var url='sysBrand_selIprBrandShopInfos.action?brandShopInfo.itemname='+itemname;
	$('#dictDataGrid').datagrid({url:url});
}		