__CreateJSPath = function(js) {
	
	var scripts = document.getElementsByTagName("script");
	var path = "";
	for (var i = 0, l = scripts.length; i < l; i++) {
		var src = scripts[i].src;
		if (src.indexOf(js) != -1) {
			var ss = src.split(js);
			path = ss[0];
			break;
		}
	}
	
	var href = location.href;
	href = href.split("#")[0];
	href = href.split("?")[0];
	var ss = href.split("/");
	ss.length = ss.length - 1;
	href = ss.join("/");
	if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1 && path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
		path = href + "/" + path;
	}
	return path;
};

function _GetRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
};

//var bootPATH = __CreateJSPath("easyUI-Import.js");
var easyuiPath = _GetRootPath();//bootPATH;
document.write("<link href='"+ easyuiPath+ "/maosys/support/easyui/themes/default/easyui.css' rel='stylesheet' type='text/css' ><\/link>");
document.write("<link href='"+ easyuiPath+ "/maosys/support/easyui/themes/icon.css' rel='stylesheet' type='text/css' ><\/link>");
document.write("<link href='"+ easyuiPath+ "/maosys/common/css/icon-extend.css' rel='stylesheet' type='text/css' ><\/link>");
document.write("<link href='"+ easyuiPath+ "/maosys/common/css/form-table.css' rel='stylesheet' type='text/css' ><\/link>");
//document.write("<link href='"+ easyuiPath+ "../../common/css/easyuiExtend.css' rel='stylesheet' type='text/css' ><\/link>");

document.write("<script src='" + easyuiPath+ "/maosys/support/easyui/jquery.min.js'><\/script>");
document.write("<script src='" + easyuiPath+ "/maosys/support/easyui/jquery.easyui.min.js'><\/script>");
document.write("<script src='" + easyuiPath+ "/maosys/support/easyui/locale/easyui-lang-zh_CN.js'><\/script>");
document.write("<script src='" + easyuiPath+ "/maosys/common/js/jquery.validate.extend.js'><\/script>");

document.write("<script src='" + easyuiPath+ "/maosys/common/js/common.js'><\/script>");

//document.write("<script src='" + easyuiPath+ "/common/js/pageLoader.js'><\/script>");
//document.write("<script src='" + easyuiPath+ "easyui-extend.js'><\/script>");
//document.write("<script src='" + easyuiPath+ "../../common/js/easyUI-common.js'><\/script>");
//document.write("<script src='" + easyuiPath+ "../../common/js/easyuiExtend.js'><\/script>");
