var request = fastDev.Browser.getRequest();//获取请求对象
var userid = request['userid'];
var staffId = request['staffid'];
function initTemplate(data){
	var source = document.getElementById('tpl').innerHTML;
	template = fastDev.create("Template", {
		htmlList : source,
		params : data
	});
	var dom = template.createStaticHtml();
	fastDev("body").append(dom);
	fastDev.Core.ControlBus.compile();
}


fastDev(function(){
	fastDev.create("Proxy", {
		url : "user_getUserInfo.action",
		urlParam : {
			userid : userid
		}
	}).load(initTemplate);
});

function onDatagridBeforeReady() {
	this.setOptions({
		initSource : 'user_getPartUser.action?staffId=' + staffId
	});
}