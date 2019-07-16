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
    var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    var localhostPaht=curWwwPath.substring(0,pos);
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
};

var bootPATH = _GetRootPath();//bootPATH;

document.write("<link rel='stylesheet' href='"+ bootPATH+ "/support/layui/plugins/layui/css/layui.css' type='text/css' ><\/link>");
document.write("<link rel='stylesheet' href='"+ bootPATH+ "/support/layui/css/global.css' type='text/css' ><\/link>");

document.write("<script type='text/javascript' src='" + bootPATH+ "/support/layui/plugins/layui/layui.js'><\/script>");
document.write("<script type='text/javascript' src='" + bootPATH+ "/support/layui/js/index.js'><\/script>");