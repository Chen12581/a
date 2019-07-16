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

document.write("<link href='"+ bootPATH+ "/support/ama/css/style.default.css' type='text/css' ><\/link>");

document.write("<script src='" + bootPATH+ "/support/ama/js/plugins/jquery-1.7.min.js'><\/script>");
document.write("<script src='" + bootPATH+ "/support/ama/js/plugins/jquery-ui-1.8.16.custom.min.js'><\/script>");
document.write("<script src='" + bootPATH+ "/support/ama/js/plugins/jquery.cookie.js'><\/script>");
document.write("<script src='" + bootPATH+ "/support/ama/js/plugins/jquery.uniform.min.js'><\/script>");
document.write("<script src='" + bootPATH+ "/support/ama/js/plugins/jquery.flot.min.js'><\/script>");
document.write("<script src='" + bootPATH+ "/support/ama/js/plugins/jquery.flot.resize.min.js'><\/script>");
document.write("<script src='" + bootPATH+ "/support/ama/js/plugins/jquery.slimscroll.js'><\/script>");
document.write("<script src='" + bootPATH+ "/support/ama/js/custom/general.js'><\/script>");
document.write("<script src='" + bootPATH+ "/support/ama/js/custom/dashboard.js'><\/script>");