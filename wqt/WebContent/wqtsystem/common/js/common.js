  /**
 * get parameter from request
 * @param {name} parameter name
 * @return {String} parameter from url
 * */
function GetQueryString(name) {
	   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
	   var r = window.location.search.substr(1).match(reg);
	   if (r!=null) return decodeURI(r[2]); return null;
}

/**
 * 
 */
(function(){
	

}());

//===============================================
// Map 对象
//    var map = new Map();     
//    map.put('key1','value1');   
//    map.put('key2','value2');  	
//    map.remove("key2");     
//    map.get("key1");     
// 
//    map.each(function(key,value,index){         
//    });  
//===============================================
Array.prototype.remove = function(s) {     
    for (var i = 0; i < this.length; i++) {     
        if (s == this[i])     
            this.splice(i, 1);     
    }     
};    

function Map() {     

    /** 存放键的数组(遍历用到) */    
    this.keys = new Array();    
	
    /** 存放数据 */    
    this.data = new Object();     
         
    /**   
     * 放入一个键值对   
     * @param {String} key   
     * @param {Object} value   
     */    
    this.put = function(key, value) {     
        if(this.data[key] == null){     
            this.keys.push(key);     
        }     
        this.data[key] = value;     
    };     
         
    /**   
     * 获取某键对应的值   
     * @param {String} key   
     * @return {Object} value   
     */    
    this.get = function(key) {     
        return this.data[key];     
    };     
         
    /**   
     * 删除一个键值对   
     * @param {String} key   
     */    
    this.remove = function(key) {     
        this.keys.remove(key);     
        this.data[key] = null;     
    };     
         
    /**   
     * 遍历Map,执行处理函数   
     *    
     * @param {Function} 回调函数 function(key,value,index){..}   
     */    
    this.each = function(fn){     
        if(typeof fn != 'function'){     
            return;     
        }     
        var len = this.keys.length;     
        for(var i=0;i<len;i++){     
            var k = this.keys[i];     
            fn(k,this.data[k],i);     
        }     
    };     
         
    /**   
     * 获取键值数组
     * @return 键值对象{key,value}的数组   
     */    
    this.entrys = function() {     
        var len = this.keys.length;     
        var entrys = new Array(len);     
        for (var i = 0; i < len; i++) {     
            entrys[i] = {     
                key : this.keys[i],     
                value : this.data[i]     
            };     
        }     
        return entrys;     
    };     
         
    /**   
     * 判断Map是否为空   
     */    
    this.isEmpty = function() {     
        return this.keys.length == 0;     
    };     
         
    /**   
     * 获取键值对数量   
     */    
    this.size = function(){     
        return this.keys.length;     
    };     
         
    /**   
     * 重写toString    
     */    
    this.toString = function(){     
        var s = "{";     
        for(var i=0;i<this.keys.length;i++,s+=','){     
            var k = this.keys[i];     
            s += k+"="+this.data[k];     
        }     
        s+="}";     
        return s;     
    };     
};    

//===============================================
// StringBuffer 对象
//===============================================
function StringBuffer() {
	this.__strings__ = [];
};

StringBuffer.prototype.append = function(str) {
	this.__strings__.push(str);
};

StringBuffer.prototype.appendLine = function(str) {
	this.__strings__.push(str+"\n");
};

StringBuffer.prototype.toString = function() {
	return this.__strings__.join('');
};



//===============================================
// DgUtil 工具类对象
//===============================================
var DgUtil = {
		
	_$parent: null,
	
	/**
	 * 桌面弹出新窗口
	 */
	openDeskWin: function( configs ){
		
		try{
			var iframeHtml = new StringBuffer();
			iframeHtml.append('<iframe id="if_' + configs.id + '" name="if_' + configs.id+ '"');
			iframeHtml.append('style="width:100%; height:100%; border:0px; margin:0px; padding:0px;"');
			iframeHtml.append('scrolling="auto"');
			iframeHtml.append('src="'+ configs.url + '"');
			iframeHtml.append('></iframe>');
			
			var $dialog = window.top.$(iframeHtml.toString()).appendTo( $('.dg-desk', window.top.document) );
			
			/**/
			$dialog.dialog({
				id             : configs.id,
				title          : configs.title,
				width          : configs.width,
				height         : configs.height,
				iconCls        : configs.iconCls,
				zIndex         : 9999,
				left           : 10,
				top            : 10,
				loadingMessage : '加载数据中, 请等待...',
				minimizable    : configs.minimizable ,
				maximizable    : configs.maximizable,
				closable       : configs.closable,
				modal          : false,
				inline         : true,
				onClose        : function() {
					DgUtil.winDivRemove(configs.id);
				}
				
			});
			
		}
		catch(e){
			alert("异常信息："+e.message);
		}
	},
	
	//
	openDeskCenterWin: function( configs ){
		
		try{
			var iframeHtml = new StringBuffer();
			iframeHtml.append('<iframe id="if_' + configs.id + '" name="if_' + configs.id+ '"');
			iframeHtml.append('style="width:100%; height:100%; border:0px; margin:0px; padding:0px;"');
			iframeHtml.append('scrolling="auto"');
			iframeHtml.append('src="'+ configs.url + '"');
			iframeHtml.append('></iframe>');

			var $dialog = window.top.$(iframeHtml.toString()).appendTo( $('.dg-desk', window.top.document) );
			
			/**/
			$dialog.dialog({
				id             : configs.id,
				title          : configs.title,
				width          : configs.width,
				height         : configs.height,
				iconCls        : configs.iconCls,
				zIndex         : 9999,
				loadingMessage : '加载数据中, 请等待...',
				minimizable    : configs.minimizable ,
				maximizable    : configs.maximizable,
				closable       : configs.closable,
				modal          : configs.modal,
				inline         : true,
				onClose        : function() {
					DgUtil.winDivRemove(configs.id);
					//DgUtil.closeDialog(configs.id);
				}
				
			});
			
		}
		catch(e){
			alert("异常信息："+e.message);
		}
	},
	
	// 
	openWin: function( id, title, url, w, h ) {
		var deskwidth = window.top.$(".dg-desk").css('width'); //dg-desk层的宽度
		var deskHeight = window.top.$(".dg-desk").css('height'); //dg-desk层的高度（目前dg-desk层覆盖整个浏览器可见区域）
		var taskbarHeightString = window.top.$(".dg-taskbar").css('height'); //dg-taskbar层的高度（该层为首页开始菜单高度）
		var taskbarHeightNumber = taskbarHeightString.replace("px","");
		var windowWidth = deskwidth.replace("px","");
		var windowHeight = deskHeight.replace("px","");
		if(w == null || w == "") w = "600"
		if(h == null || h == "") h = "500"
		var left = (windowWidth - w)/2;
		var top = (windowHeight - taskbarHeightNumber - h) /2;
		
		try{
			var iframeHtml = new StringBuffer();
			iframeHtml.append('<div id="wi_' +id+ '" class="panel window" style="display: block; width: '+w+'px; left: '+left+'px; top: '+top+'px; z-index: 90002;">');
			iframeHtml.append('  <div class="panel-header panel-header-noborder window-header" style="width:'+w+'px;">');
			iframeHtml.append('	   <div class="panel-title panel-with-icon">' +title+ '</div>');
			iframeHtml.append('	   <div class="panel-icon icon-ex-information"></div>');
			iframeHtml.append('	   <div class="panel-tool"><a href="javascript:void(0)" class="panel-tool-close"></a></div>');
			iframeHtml.append('  </div>');
			iframeHtml.append('  <iframe id="if_' +id+ '" name="if_' +id+ '" style="margin: 0px; padding: 0px; width: '+w+'px; height: '+h+'px;" scrolling="auto" src="' +url+ '" title="" class="panel-body panel-body-noborder window-body"></iframe>');
			iframeHtml.append('</div>');
			
			iframeHtml.append('<div id="ws_' +id+ '" class="window-shadow" style="display: block; left: '+left+'px; top: '+top+'px; z-index: 90001; width: '+w+'px; height:'+h+'px;"></div>');
			iframeHtml.append('<div id="wm_' +id+ '" class="window-mask" style="display: block; z-index: 90000; position: fixed;"></div>');
			
			var $dialog = window.top.$(iframeHtml.toString()).appendTo( DgUtil.$top('body') );
			
			$("#wi_"+id+" .panel-tool-close", window.top.document.body).click(function(){
				DgUtil.closeDialog(id);
			});
		}
		catch(e){
			alert("异常信息："+e.message);
		}
	},
	
	
	
	
	
	/**
	 * 创建有关闭时回调函数的窗口
	 * 
	 * */
	openWin: function( id, parentIframeName,title, url, w, h ,func) {
		
		//alert(window.document.location.href);
		
		//alert(parentIframeName);
		
		// 计算窗口位置
		var deskHeight  = $(window.top).height();  //window.top.$(".layui-layout").css('width'); //dg-desk层的宽度
		var deskwidth = $(window.top).width();  //window.top.$(".layui-layout").css('height'); //dg-desk层的高度（目前dg-desk层覆盖整个浏览器可见区域）
		
		//alert(deskwidth+"-"+deskHeight);
		//var taskbarHeightString = "0px"; //window.top.$(".dg-taskbar").css('height'); //dg-taskbar层的高度（该层为首页开始菜单高度）
		//var taskbarHeightNumber = taskbarHeightString.replace("px","");
		//var windowWidth = deskwidth.replace("px","");
		//var windowHeight = deskHeight.replace("px","");
		
		if(w == null || w == "") w = 600
		if(h == null || h == "") h = 500
		var left = (deskwidth - w)/2;
		var top = (deskHeight - h) /2;
		
		//alert(deskwidth+"-"+w+"-"+left);
		
		if (url.indexOf("?") > 0) {
			url = url + "&parentIframeName=" + parentIframeName;
		} 
		else {
			url = url + "?parentIframeName=" + parentIframeName;
		}
		
		// 创建窗口层
		try {
			
			var iframeHtml = new StringBuffer();
			iframeHtml.append('<div id="wi_' +id+ '" class="panel window" style="display: block; width: '+w+'px; left: '+left+'px; top: '+top+'px; z-index: 90002;">');
			iframeHtml.append('  <div class="panel-header panel-header-noborder window-header" style="width:'+w+'px;">');
			iframeHtml.append('	   <div class="panel-title panel-with-icon">' +title+ '</div>');
			iframeHtml.append('	   <div class="panel-icon icon-ex-information"></div>');
			iframeHtml.append('	   <div class="panel-tool"><a href="javascript:void(0)" class="panel-tool-close"></a></div>');
			iframeHtml.append('  </div>');
			iframeHtml.append('  <iframe id="if_' +id+ '" name="if_' +id+ '" style="border: 0px none; margin: 0px; padding: 0px; width: '+w+'px; height: '+h+'px;" scrolling="auto" src="' +url+ '" title="" class="panel-body panel-body-noborder window-body"></iframe>');
			iframeHtml.append('</div>');
			
			iframeHtml.append('<div id="ws_' +id+ '" class="window-shadow" style="display: block; left: '+left+'px; top: '+top+'px; z-index: 90001; width: '+w+'px; height:'+h+'px;"></div>');
			iframeHtml.append('<div id="wm_' +id+ '" class="window-mask" style="display: block; z-index: 90000; position: fixed;"></div>');
			
			var $dialog = window.top.$(iframeHtml.toString()).appendTo( DgUtil.$top('body') );
			
			$("#wi_"+id+" .panel-tool-close", window.top.document.body).click(function(){
				if(typeof func == 'function'){
					func(parentIframeName);				
				}
				DgUtil.closeDialog(id);
			});
		}
		catch(e){
			alert("异常信息："+e.message);
		}
	},
	
	
	
	openTopWindow : function (url, title, width, height) {   
		title = title == undefined ? ' ' : title;   
		width = width == undefined ? 800 : width;   
		height = height == undefined ? 300 : height;   
		if (url != undefined) {     
		var content = '<iframe name="eui-open-page" scrolling="no" frameborder="0" src="' + url + '" style="width:100%;height:100%;"></iframe>';     
		parent.$('#openWindow').window(
		{       
		title: title,       
		width: width,       
		height: height,       
		content: content,       
		modal: true,       
		animate: true,  
collapsible:false,		
maximizable:false,		
		minimizable: false    });   
		} 
	
	} ,

	
	
	/**
	 * 桌面弹出新窗口
	 */
	openWin2 : function( id, title, url, w, h ) {
		
		try{
			
			var iframeHtml = new StringBuffer();
			iframeHtml.append('<iframe id="if_' + id + '" name="if_' + id + '"');
			iframeHtml.append('style="width:100%; height:100%; border:0px; margin:0px; padding:5px;"');
			iframeHtml.append('scrolling="auto"');
			iframeHtml.append('src="'+ url + '"');
			iframeHtml.append('></iframe>');
			
			var $dialog = window.top.$(iframeHtml.toString()).appendTo( DgUtil.$top('.dg-desk') );
			
			/*$('.dg-desk', window.top.document).css('background-color','red');
			
			*/
			$dialog.dialog({
				id      : id,
				title   : title,
				width   : w,
				height  : h,
				iconCls : "icon-ex-information",
				modal   : true,
				loadingMessage : '加载数据中, 请等待...',
				onClose : function() {
					//DgUtil.$top('#'+id).dialog('destroy');
				}
			});
			
			 
			// DgUtil.$top('#'+id).dialog('close');
			
			
		}
		catch(e){
			alert("异常信息："+e.message);
		}
	},
	
	
	/**
	 * 桌面弹出新窗口
	 */
	closeWin: function(selector){
		//window.parent.doRefresh();
		//window.top._dialog.dialog("destroy"); 
		$(selector, window.top.document).dialog('destroy');
	},
	
	closeDialog: function(id){
		//$("#wi_"+id +".panel.window", window.top.document.body).remove();
		//$("#ws_"+id +".window-shadow", window.top.document.body).remove();
		//$("#wm_"+id +".window-mask", window.top.document.body).remove();
		//alert($("#ws_"+id , window.top.document.body).length);
		$("#ws_"+id , window.top.document.body).remove();
		$("#wm_"+id , window.top.document.body).remove();
		$("#wi_"+id , window.top.document.body).remove();
	},
	winDivRemove : function(id){ //关闭窗口并移除页面DIV层
		try {
			if (/msie/.test(navigator.userAgent.toLowerCase())) {
				CollectGarbage();
			}
		} catch (e) {
		}
		var parentDiv = window.top.$("#"+id).parent();
		window.top.$(".window-shadow").remove();
		if(window.top.$(".window-mask")){
			window.top.$(".window-mask").remove();
		}
		parentDiv.remove();
	},
	/**
	 * 桌面弹出新窗口
	 */
	// 获取top窗口jquery对象
	$top: function(selector){
		return $(selector, window.top.document);
	},
	
	/**
	 * 桌面弹出新窗口
	 */
	//$parent: function(selector){
		
	//	return $(selector, DgUtil._$parent);
	//},
	
	//
	$parent : function() {
		var parentIframeName = GetQueryString("parentIframeName");
		var obj = window.top.frames[parentIframeName];
		return obj;
	},
	
	/**
	 * 获取URL参数
	 */
	getParameter : function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	},
	
	/**
	 *
	 */
	uuid :function() {
		var s = [];
		var hexDigits = "0123456789abcdef";
		for (var i = 0; i < 36; i++) {
			s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
		}
		s[14] = "4";
		s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); 
		s[8] = s[13] = s[18] = s[23] = "-";
		var uuid = s.join("");
		return uuid;
	},
	
	/**
	 *
	 */
	isNotEmpty:  function(val){
        return !this.isEmpty(val);
    },
	
	/**
	 *
	 */
    isEmpty: function(val){
        if ((val==null || typeof(val)=="undefined") || (typeof(val)=="string"&&val==""&&val!="undefined")){
           return true;
        }
		else{
            return false;
        }
    },
    
    getCurrentRow: function(e, datagrid){
    	var index = $(e).closest('tr.datagrid-row').attr('datagrid-row-index');
    	var rowData = $('#'+datagrid).datagrid('getData').rows[index];
    	return rowData;
    },
};

