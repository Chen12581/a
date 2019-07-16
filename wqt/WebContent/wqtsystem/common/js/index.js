

$(function(){
	
	// 屏蔽右击菜单
	$(document).bind("contextmenu", function(e){ return false; });
	
	$('#userItem').click(function(){
		
		if($('#userMenuDl').css('display')=='none'){
			$('#userMenuDl').css('display','block');
		}else{
			$('#userMenuDl').css('display','none');
		}
		
		
	});
	
	
	//生成右键菜单 
    $('#main_tabs').tabs({
		
		onContextMenu: function(e, title, index){
			
			//选中标签
			$('#main_tabs').tabs('select',index);
			
			if(title!='首页'){
				//显示右键菜单
				$('#mm').menu('show', {
					left: e.pageX,
					top: e.pageY
				}) ;
			}
		}
    });
	

	
	//为每个菜单绑定点击事件
    //关闭选中的标签
    $("#closeCurrent").click(function(){
		//获取选中的标签索引
		var tab = $('#main_tabs').tabs('getSelected');
		var index = $('#main_tabs').tabs('getTabIndex',tab);
		$("#main_tabs").tabs("close",index);
    });
	
   //关闭选中标签之外的标签
    $("#closeOthers").click(function(){
		
		//获取所有标签
		var tabs = $("#main_tabs").tabs("tabs");
		var length = tabs.length;
		
		//获取选中标签的索引
		var tab = $('#main_tabs').tabs('getSelected');
		var index = $('#main_tabs').tabs('getTabIndex',tab);
		
		var homeTab = $('#main_tabs').tabs('getTab','首页');
		var homeIndex = $('#main_tabs').tabs('getTabIndex',homeTab);
		
		//关闭选中标签之前的标签
		for(var i=0; i<index;i++){
			$("#main_tabs").tabs("close",0);
		}
		
		//关闭选中标签之后的标签
		for(var i=0;i<length-index-1;i++){
			$("#main_tabs").tabs("close",1);
		}
		
    });
	
   //关闭所有标签
    $("#closeAll").click(function(){
		
		var homeTab = $('#main_tabs').tabs('getTab','首页');
		var homeIndex = $('#main_tabs').tabs('getTabIndex',homeTab);
		
		var tabs = $("#main_tabs").tabs("tabs");
		var length = tabs.length;
		
		for(var i=0;i<length;i++){
			$("#main_tabs").tabs("close",0);
		}
		
    });
	
	// TOP 菜单点击事件
	$('.layui-nav-item a').click(function(){
		var appid = $(this).parent().attr('appid');
		var text = $(this).text();
		
		switch(appid){
			case '0' :
			
			    $('#main_tabs').tabs('select', '首页')
				break;
			case '1' :
				$("#westPanel").panel({
					title:text
				});
				$('#menuTree').tree({
                    method: 'get',
                    url: 'demo/data/tree_data_1.txt'
                });
				break;
			case '2' :
				$("#westPanel").panel({
					title:text
				});
				$('#menuTree').tree({
                    method: 'get',
                    url: 'demo/data/tree_data_2.txt'
                });
				break;
			case '3' :
				$("#westPanel").panel({
					title:text
				});
				$('#menuTree').tree({
                    method: 'get',
                    url: 'demo/data/tree_data_3.txt'
                });
				break;
			case '4' :
				$("#westPanel").panel({
					title:text
				});
				$('#menuTree').tree({
                    method: 'get',
                    url: 'demo/data/tree_data_4.txt'
                });
				break;
			case '5' :
				$("#westPanel").panel({
					title:text
				});
			
				$('#menuTree').tree({
                    method: 'get',
                    url: 'demo/data/tree_data_5.txt'
                });
				break;
			case '6' :
				$("#westPanel").panel({
					title:text
				});
				$('#menuTree').tree({
                    method: 'get',
                    url: 'demo/data/tree_data_6.txt'
                });
				break;
			case '7' :
				$("#westPanel").panel({
					title:text
				});
				$('#menuTree').tree({
                    method: 'get',
                    url: 'demo/data/tree_data_7.txt'
                });
				break;
			default:
				break;
		}
		
	});
	
	
	//
	$('#menuTree').tree({
		
		// 点击查询
		onClick : function(node) {
			clickMenuBar(node, node.attributes.url, node.text)
			//alert(node.id+node.text+"---"+node.attributes.url);
		}
	});
	
	
});







//点击左侧菜单栏tab页面添加
function clickMenuBar(obj, url, text) {

	//$('div.eaui-nav-inner').removeClass("eaui-nav-inner-seleted");
	
	//if (!$(obj).parent('div').attr('name')){
	//	$(obj).parent('div').addClass("eaui-nav-inner-seleted");
	//}
		
	if ($.trim(url)) {
		if ($('#main_tabs').tabs('exists', text)) {
			$('#main_tabs').tabs('select', text)
			return;
		}
		
		$('#main_tabs').tabs('add',
			{
				title : text,
				content : "<iframe name='left' id='rightMain' src="+ url + " frameborder='false' scrolling='no' style='border:none;' width='100%' height='100%'></iframe>",
				closable : true,
				iconCls : 'icon-ex-grid',
				cache : false
			});
	}
	
}
	

	
/**/
				function cleanSideBar(){
					var panels = $('#sideBar').accordion('panels');
					var indexs = new Array();
					$.each(panels, function(i, panel) {
						var index = $('#sideBar').accordion(
								'getPanelIndex', panel);
						indexs.push(index);
					});
					$.each(indexs.reverse(), function(i, num) {
						$('#sideBar').accordion('remove', num);
					});
				}
	
				/**/
				function createSideBar(url, id) {
					cleanSideBar();
					$.post(
							url,
							function(data) {
								cleanSideBar();
								$.each(
										data,
										function(i, rowData) {
										
											if (rowData.pid == "-1") {
												var content = "";
												$.each(
														data,
														function(j,tempRowData) {
															if (tempRowData.pid == rowData.id) {
																content += '<div  class="eaui-nav-inner"><a  class="eaui-nav-background  eaui-nav-text " onClick=\"clickMenuBar(this,\' '+ tempRowData.url+ ' \',\' '+ tempRowData.text+ '\')\">'+ tempRowData.text+ '</a></div>';
															}
														});
														if (!rowData.ico) {
															rowData.ico = 'ico-folder';
														}
														
														var flag = true;
														
														$(id).accordion(
															'add',
															{
																title : '<div name='+rowData.id+' class="'+rowData.ico+' ui-out-nav-inner"><a class="ui-nav-text-other eaui-nav-text"  onClick=\"clickMenuBar(this,\' '
																							+ rowData.url
																							+ ' \' ,\' '
																							+ rowData.text
																							+ '\')\">'
																							+ rowData.text
																							+ '</a></div>',
																content : content,

																selected : false
														});
														
														if (!content) {
															$('div[name='+ rowData.id+ ']').parent('div.panel-title').next('div.panel-tool').css("display","none");
														}
											}
												});
									}, "json");
				}
	
			    //
				layui.use('layer', function() {
					var $ = layui.jquery,
						layer = layui.layer;
					$('#video1').on('click', function() {
						layer.open({
							title: '网约车监管理平台',
							maxmin: true,
							type: 2,
							content: 'video.html',
							area: ['800px', '500px']
						});
					});
				});