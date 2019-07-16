<%@ page language="java" import="java.util.Map"
	import="com.talkweb.twdpe.web.session.main.Session"
	import="com.talkweb.twdpe.web.session.util.SessionFactory"
	pageEncoding="UTF-8"%>
<%
	String displayName = "匿名";
	String userid = "-1";
	Session ses = SessionFactory.getInstance(request, response);
	Map user = (Map) ses.getAttribute("USERSESSION");
	if (user != null) {

		displayName = user.get("name") + "";
		System.out.println(user.get("id"));
		userid = user.get("id").toString();
	} else {
		response.sendRedirect("login.html");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link rel="shortcut icon" href="themes/default/images/favicon.ico" />
<title>湖南万企通全企业管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<script type="text/javascript" src="fastdev/fastDev-import.js"></script>
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css"></link>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css"></link>
<script type="text/javascript" src="../easyui/js/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../common/js/zIndexTopWindow.js"></script>
<script type="text/javascript" src="../common/js/easyui-lang-zh_CN.js"></script>
<style type="text/css">
body {
	min-width: 1280px;
	min-height: 500px;
}

.panel-fit {
	overflow: auto;
}

/*左侧导航条样式  */
.eaui-nav-inner-seleted {
	background: #CBDAF0;
}

.eaui-nav-inner {
	margin: 0px;
	overflow: hidden;
	line-height: 22px;
	white-space: nowrap;
}

.ui-out-nav-inner {
	margin: 0px;
	overflow: hidden;
	line-height: 22px;
	white-space: nowrap;
}

.ui-nav-text-other {
	font-weight: normal;
	padding-left: 25px;
	color: #075488;
}

.eaui-nav-text {
	font-size: 13px;
	margin: 0px;
	padding-bottom: 2px;
	cursor: pointer;
	display: block;
	outline: none;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}

.eaui-nav-background {
	padding-left: 35px;
	border: none;
	background: url(../fastdev/themes/default/images/nav/arrow-nav.gif)
		no-repeat 20px center;
}
/*左侧导航条样式结束  */
.eaui-layout-footer {
	overflow: hidden;
	width: 100%;
	height: 32px;
	line-height: 32px;
	text-align: center;
	font-family: microsoft yahei;
	font-size: 13px;
	background: #E0ECFF;
}

.collapse_button {
	background:
		url(../component/fastdev/themes/default/images/layout/layout-arrow.gif)
		0 0 no-repeat;
	width: 5px;
	height: 35px;
	display: block;
	position: absolute;
	top: 50%;
	cursor: pointer;
}

.layout-expand-west {
	display: none !important;
}

.ui-layout-welcome {
	position: absolute;
	right: 5px;
	top: -2px;
	padding: 0;
	margin: 0;
	background: #70D3FE;
	width: auto;
	height: 20px;
	line-height: 20px;
	padding: 0 5px;
	font-size: 12px;
	color: #333;
	border-radius: 0 0 3px 3px;
}

.ui-layout-nav2 {
	position: relative;
	top: 104px;
	text-align: right;
	float: right;
	right: 10px;
}
</style>
<script type="text/javascript">
var collapse_flag=1;
var hasJianZhi = <%=ses.getAttribute("hasJianzhi")%>;

function userManual(){
    var url =  "userManual.html";
    var ihtml = '<iframe id="userManual" name="userManual" style="width:100%;height:100%;border:0px;margin:0px;" scrolling="no" src="'+ url + '"></iframe>';
window.top.$("#zWindow").html("<div id='userManual' class='easyui-dialog'  style='overflow:hidden'></div>");
		window.top.$("#userManual").html(ihtml);
		window.top.$("#userManual").dialog({
			title : '操作手册',
			width : 300,
			height : 240,
			collapsible : true,
			minimizable : false,
			maximizable : false,
			resizable : true,
			modal : true,
			cache : false,

			buttons : [ {
				text : '关闭',
				iconCls : 'icon-close',
				handler : function(e, win) {
					window.top.$("#userManual").dialog("close");
					window.top.$("#userManual").remove();
				}
			} ]
		});
}




function passwordmotify(){
	var url =  "newsystem/campususer/passwordModify.html?usercode=<%=displayName%>&userid=<%=userid%>";
		var ihtml = '<iframe id="myframePasswordModify" name="myframePasswordModify" style="width:100%;height:100%;border:0px;margin:0px;" scrolling="no" src="'
				+ url + '"></iframe>';
		window.top
				.$("#zWindow")
				.html(
						"<div id='myPasswordModify' class='easyui-dialog'  style='overflow:hidden'></div>");
		window.top.$("#myPasswordModify").html(ihtml);
		window.top.$("#myPasswordModify").dialog({
			title : '修改密码',
			width : 300,
			height : 240,
			collapsible : true,
			minimizable : false,
			maximizable : false,
			resizable : true,
			modal : true,
			cache : false,

			buttons : [ {
				text : '保存',
				iconCls : 'icon-save',
				handler : function(e) {
					window.top.frames["myframePasswordModify"].doSave();
				}
			}, {
				text : '重置',
				iconCls : 'icon-reset',
				handler : function(e, win, cwin) {
					window.top.frames["myframePasswordModify"].doReset();
				}
			}, {
				text : '关闭',
				iconCls : 'icon-close',
				handler : function(e, win) {
					window.top.$("#myPasswordModify").dialog("close");
					window.top.$("#myPasswordModify").remove();
				}
			} ]
		});
	}
	function logout() {
		$.messager.confirm('信息提示', '是否退出系统？', function(result) {
			if (result) {
				location.href = "portal_loginout.action";
			}
		});
	}
	function selectUser() {
		if (hasJianZhi) {
			$.messager.confirm('信息提示', '是否切换身份？', function(result) {
				if (result) {
					zWindowForDataGrid('myUserSelect', 'userSelect.html',
							'切换身份', 518, 332, null, null);
				}
			});
		} else {
			$.messager.alert('信息提示', '该用户没有兼职，不能切换身份', 'warning');
		}
	}
	//点击左侧菜单栏tab页面添加
	function clickMenuBar(obj, url, text) {
		$('div.eaui-nav-inner').removeClass("eaui-nav-inner-seleted");
		if (!$(obj).parent('div').attr('name'))
			$(obj).parent('div').addClass("eaui-nav-inner-seleted");
		if ($.trim(url)) {
			if ($('#main_tabs').tabs('exists', text)) {
				$('#main_tabs').tabs('select', text)
				return;
			}
			$('#main_tabs')
					.tabs(
							'add',
							{
								title : text,
								content : "<iframe name='left' id='rightMain' src="
										+ url
										+ " frameborder='false' scrolling='auto' style='border:none;' width='100%' height='100%'></iframe>",
								closable : true,
								iconCls : 'icon-fast-grid',
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
		$
				.post(
						url,
						function(data) {
							cleanSideBar();
							$.each(
											data,
											function(i, rowData) {
												if (rowData.pid == "-1") {
													var content = "";
													$
															.each(
																	data,
																	function(j,
																			tempRowData) {
																		if (tempRowData.pid == rowData.id) {
																			content += '<div  class="eaui-nav-inner"><a  class="eaui-nav-background  eaui-nav-text " onClick=\"clickMenuBar(this,\' '
																					+ tempRowData.url
																					+ ' \',\' '
																					+ tempRowData.text
																					+ '\')\">'
																					+ tempRowData.text
																					+ '</a></div>';
																		}
																	});
													if (!rowData.ico) {
														rowData.ico = 'ico-folder';
													}
													var flag = true;
													$(id)
															.accordion(
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
														$(
																'div[name='
																		+ rowData.id
																		+ ']')
																.parent(
																		'div.panel-title')
																.next(
																		'div.panel-tool')
																.css("display",
																		"none");
													}
												}
											});
						}, "json");
	}
	
	/**/
	function loadMenu(event) {
		event = event || window.event;
		var target = event.target || event.srcElement;
		var targetEl = $(target);
		while (targetEl[0].tagName != 'LI') {
			if (targetEl[0].tagName == 'UL') {
				return;
			}
			targetEl = targetEl.parent();
		}
		if (currentEl) {
			if (currentEl == targetEl)
				return;
			currentEl.removeClass('ui-layout-nav2-active');
		}
		targetEl.addClass('ui-layout-nav2-active');
		currentEl = targetEl;
		var action = 'resource_showMenu.action?parentCode='
				+ targetEl.attr('resourceCode') + '&appid='
				+ targetEl.attr('appid');
		
		createSideBar(action, '#sideBar');
	}

	$(function() {
		$(".collapse_button").click(function() {
			if (collapse_flag == 1) {
				$("#man_layout").layout('collapse', 'west');
				collapse_flag = 0;
			} else {
				$("#man_layout").layout('expand', 'west');
				collapse_flag = 1;
			}
		});
		$
				.ajax({
					url : 'resource_showTopMenu.action',
					type : 'get',
					async : true, //默认为true 异步   
					success : function(data) {
						if (data.length > 0) {
							var htmlList = [];
							for (var i = 0; i < data.length; i++) {
								var menu = data[i];
								htmlList
										.push('<li appid="' + menu.appId + '" resourceCode="' +menu.resourceCode  + '">');
								htmlList
										.push('<div class="ui-layout-nav2-left"></div>');
								htmlList
										.push('<a href="javascript:void(0);" class="ui-layout-nav2-inner"><span>'
												+ menu.resourceName
												+ '</span></a>');
								htmlList
										.push('<div class="ui-layout-nav2-right"></div>');
							}
							var menu = htmlList.join('');
							$("#menuPanel").html(menu);
							currentEl = $('#menuPanel > li:first');
							currentEl.addClass('ui-layout-nav2-frist');
							currentEl.addClass('ui-layout-nav2-active');
							createSideBar("resource_showMenu.action", '#sideBar');
							$(window.parent.document).find("#rightMain").attr("src","charts.html"); //在左边的SideBar加载之后再加载首页，以防重叠
						}
					}
				});

	});
	var dictDialog;
	function closeDialog() {
		if (dictDialog) {
			dictDialog.close();
			dictDialog = null;
		}
	}
</script>
</head>
<body>
	<div id="man_layout" class="easyui-layout" fit="true">
		<div data-options="region:'north'" style="height: 130px;overflow: hidden; ">
			<div
				style="width: 100%; height: 100%;background: url('images/middle.gif');">			
				<div
					style="width: 100%; height: 100%;">
					<div style="width: 100%; height: 100%;  overflow: hidden;">
					<img width='100%' height="100%" src="images/top_index.png"  />
					<div class="ui-layout-nav2" style="position: absolute;z-index: 999" >
							<div class="ui-layout-nav2-contain">
								<ul id="menuPanel" onclick="loadMenu(event)"
									class="ui-layout-nav2-tab">
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="ui-layout-welcome">
				<img src="fastdev/themes/default/images/ico/user.gif" /> <span>欢迎您：</span>
				<span class="ui-text-decoration ui-yellow"><%=displayName%></span> 
				 <img src="fastdev/themes/default/images/ico/reset.gif" /> <span><a
					style="color: black;" href="javascript:void(0);" onclick="passwordmotify()">修改密码</a></span> <img
					src="fastdev/themes/default/images/ico/exit.gif" /> <span><a
					style="color: black;" href="javascript:void(0);" onclick="logout()">退出系统</a></span>
					
				<img src="fastdev/themes/default/images/ico/reset.gif" />
				<span>
                           
                                
                                
                                </span>
			</div>

		</div>
		<!-- <div data-options="region:'south'" class="eaui-layout-footer">
			Copyright©www.talkweb.com.cn</div> -->
			
		<div id="main_west" data-options="region:'west',collapsedSize:0"
			style="width: 255px;">
			<div id="sideBar" class="easyui-accordion" style="width: 100%"
				data-options=" border:false"></div>
		</div>
		
		<div data-options="region:'center'">
			<div class="easyui-layout" fit="true">
				<div data-options="region:'west'"
					style="width: 5px; min-width: 1px; border-width: 0px; border-right: solid 1px #95B8E7; background-color: #E0ECFF;">
					<div class="collapse_button"></div>
				</div>
				<div data-options="region:'center'" style="border: none">
					<div id="main_tabs" class="easyui-tabs" fit=true border=false>
						<div title="首页" style="overflow:hidden" data-options="iconCls:'icon-fast-home'" >
						  <iframe name='charts' id='rightMain' frameborder='false' scrolling='auto' style='border:none;' width='100%' height='100%'></iframe>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="zWindow" style="overflow: hidden"></div>
	</div>
</body>
</html>
