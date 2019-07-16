var currentAreaId;
var op = null;

function onBeforeCompile() {
	var height = fastDev(window).height();
	fastDev('#areatree').attr('height',(height-35)+'px');
	fastDev('#centerPanel').css('width', (fastDev(window).width() - 220) + 'px');
}

function onAfterCompile() {
	showResourceModes('area');
}

function onNodeClick(event, id, value) {
	currentAreaId = id;
	var parentId = this.getParentid(id);
	var parentText = this.getValByid(parentId);
	fastDev.getInstance("area.upArea").getGlobal().box.prop("value", parentText || "中国");
	op = 'view';
	setReadOnly(true);
	refreshForm(id);
}

// 刷新上级地区树
function refreshUpAreaTree() {
	var upAreaTree = fastDev.getInstance('area.upArea');
	upAreaTree.setOptions({
		items : fastDev.getInstance("areatree").getItems()
	});
	upAreaTree.initRefresh();
}

function refreshForm(id) {
	fastDev.getInstance('areaform').dataRefresh({
		url : 'area_init.action?id='+id
	});
}

/**
 * 设置只读
 * @param readOnly
 */
function setReadOnly(readOnly) {
	fastDev.getInstance('area.area').setReadonly(readOnly);
	fastDev.getInstance('area.upArea').setReadonly(readOnly);
	fastDev.getInstance('area.areaName').setReadonly(readOnly);
	fastDev.getInstance('area.fullName').setReadonly(readOnly);
	fastDev.getInstance('area.nodeLvl').setReadonly(readOnly);
	fastDev.getInstance('area.orderby').setReadonly(readOnly);
	fastDev('#buttonBar')[readOnly?'hide':'show']();
}

/**
 * 修改区域信息
 */
function doModifyArea() {
	if(!currentAreaId || currentAreaId == -1) {
		fastDev.alert('请选择需要修改的区域节点', '信息提示', 'warning');
	} else {
		refreshUpAreaTree();
		refreshForm(currentAreaId);
		op = 'modify';
		setReadOnly(false);
		fastDev.getInstance('area.area').setReadonly(true);
	}
}

/**
 * 删除区域信息
 */
function doDeleteArea() {
	if(!currentAreaId || currentAreaId == -1) {
		fastDev.alert('请选择需要删除的区域节点', '信息提示', 'warning');
	} else {
		fastDev.confirm('是否删除所选记录？', '信息提示', function(result) {
			if(result) {
				setReadOnly(true);
				op = 'delete';
				var proxy = fastDev.create('Proxy', {
					action : 'area_delArea.action'
				});
				proxy.save({id:currentAreaId}, function(result){
					fastDev.alert(result.msg, '信息提示', result.status, function(){
						if(result.status == 'ok') {
							var areaTree = fastDev.getInstance('areatree');
							if(areaTree.getNodeByid(currentAreaId)) {
								areaTree.delNode(currentAreaId);
								fastDev.getInstance('area.upArea').initRefresh();
							}
							fastDev.getInstance('areaform').cleanData();
							currentAreaId = null;
						}
					});
				});
			}
		});
	}
}

function doAddArea() {
	op = 'add';
	fastDev.getInstance('areaform').cleanData();
	if (currentAreaId && currentAreaId!= "-1") {
		refreshUpAreaTree();
		fastDev.getInstance('areaform').setValue({
			'area.upArea' : currentAreaId
		});
	}
	setReadOnly(false);
}

/**
 * 保存区域信息
 */
function doSave() {
	fastDev.getInstance('areaform').setOptions({
		action:op=='modify'?"update_addArea.action":'area_addArea.action'
	});
	fastDev.getInstance('areaform').submit();
}

function onSubmitSuccess(result) {
	fastDev.alert(result.msg, '信息提示', result.status, function(){
		if(result.status == 'ok') {
			var items = fastDev.getInstance('areaform').getItems();
			var areaTree = fastDev.getInstance('areatree');
			if(op == 'add') {
				if(areaTree.getNodeByid(items['area.upArea'] || '-1')) {
					op = 'modify';
					areaTree.addNode({
						id : items['area.area'],
						val : items['area.areaName'],
						pid : items['area.upArea'] || '-1'
					});
					areaTree.setValue(items['area.area']);
				}
			} else {
				if(areaTree.getNodeByid(items['area.area'])) {
					areaTree.editNode({
						id : items['area.area'],
						val : items['area.areaName'],
						pid : items['area.upArea'] || '-1'
					});
				}
			}
			setReadOnly(true);
		}
	});
}

/**
 * 重置表单
 */
function doReset() {
	fastDev.getInstance('areaform').resetData();
}
