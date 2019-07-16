
function reload(){
	var patentno=$("#patentno").val();
	var re = /^[0-9]*$/;
	if(patentno==null || patentno==""){
		alert("请输入专利号")
	}
	if(!re.test(patentno)){
		alert("请输入数字")
	}else{
		$.ajax({
			url:"sysPatent_selectPatentno.action",
			data:{
				"iprPatentShop.patentno":patentno,
			},
			type:"get",
			dataType:"json",
			success:function(data){
				if(data==null){
					alert("信息过期，请重新登录");
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
				     parent.layer.close(index);
				     parent.window.location.href='patent_list.html';
				}else{
					if(data.msg==1){
						$("#tipsmsg").css("color",'red');
					}else{
						$("#tipsmsg").css("color",'green');
					}
				}
				$('#patentForm').form('load', data);
			}
		})
	}
}

//查询按钮
function submitForm()
{
	var patentno=$("#patentno").val();
	var patentname=$('#patentname').textbox('getValue');
	var kindid=$('#kindid').textbox('getValue');
	var price=$('#price').textbox('getValue');
	var bottomprice=$('#bottomprice').textbox('getValue');
	//商标名称
	if(patentno==null || patentno=="")
	{
		alert("请输入专利号");
		return;
	}
	if(patentname==null || patentname=="")
	{
		alert("请输入专利名称");
		return;
	}
	if(kindid==null || kindid=="")
	{
		alert("请输入行业分类");
		return;
	}
	if(patenttype==null || patenttype=="")
	{
		alert("请输入专利类型");
		return;
	}
	var re = /^[0-9]*$/;	//0-9位数字
	if(!re.test(price)){
		console.log(price);
		alert("请输入正确的价格");
		$('#_easyui_textbox_input3').css('color','red');
		return
	}else{
		$('#_easyui_textbox_input3').css('color','black');
	}
	if(!re.test(bottomprice)){
		console.log(bottomprice);
		alert("请输入正确的价格");
		$('#_easyui_textbox_input4').css('color','red');
		return
	}else{
		$('#_easyui_textbox_input4').css('color','black');
	}
    $('#patentForm').form('submit', {   
	   onSubmit: function(){  
	    	return $(this).form('enableValidation').form('validate');
	    },  
	    success:function(data)
	    {  
	    	alert(data);
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	        parent.layer.close(index);
	        parent.window.location.href='patent_list.html';
	    }  
	}); 
}

//关闭窗口
function doClose()
{   
	
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='patent_list.html';
}

$.extend($.fn.validatebox.defaults.rules, {  
    // filebox验证文件大小的规则函数  
    // 如：validType : ['fileSize[1,"MB"]']  
    fileSize : {  
        validator : function(value, array) {  
            var size = array[0];  
            var unit = array[1];  
            if (!size || isNaN(size) || size == 0) {  
                $.error('验证文件大小的值不能为 "' + size + '"');  
            } else if (!unit) {  
                $.error('请指定验证文件大小的单位');  
            }  
            var index = -1;  
            var unitArr = new Array("bytes", "kb", "mb", "gb", "tb", "pb", "eb", "zb", "yb");  
            for (var i = 0; i < unitArr.length; i++) {  
                if (unitArr[i] == unit.toLowerCase()) {  
                    index = i;  
                    break;  
                }  
            }  
            if (index == -1) {  
                $.error('请指定正确的验证文件大小的单位：["bytes", "kb", "mb", "gb", "tb", "pb", "eb", "zb", "yb"]');  
            }  
            // 转换为bytes公式  
            var formula = 1;  
            while (index > 0) {  
                formula = formula * 1024;  
                index--;  
            }  
            // this为页面上能看到文件名称的文本框，而非真实的file  
            // $(this).next()是file元素  
            return $(this).next().get(0).files[0].size < parseFloat(size) * formula;  
        },  
        message : '文件大小必须小于 {0}{1}'  
    }  
}); 

/*$('#uploadName').filebox({   
    validType : ['fileSize[1,"MB"]' ]  
});
*/
/*图片预览*/
function fileup(_obj)
{
	var _imgsrc=$(_obj).filebox("getValue");
	var _file=$(_obj).context.ownerDocument.activeElement.files[0];
	var filesize=_file.size;
	if(filesize<2*1024*1024)
	{
		$("#viewimg").attr("src",getObjectURL(_file));
	}
	else
	{
		$(_obj).filebox("setValue","");
		alert("请上传小于2MB的图片");
	}
}

function getObjectURL(file)
{
	var url=null;
	if(window.createObjectURL!=undefined)
	{
		url=window.createObjectURL(file);
	}
	else if(window.URL!=undefined)
	{
		url=window.URL.createObjectURL(file);
	}
	else if(window.webkitURL!=undefined)
	{
		url=window.webkitURL.createObjectURL(file);
	}
	return url;
}

function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};

var id=getParameter('id');

$(function(){	
	$('#patentForm').form('load', 'sysPatent_selectPatentShopOne.action?iprPatentShop.id='+id);
	$("#patentForm").form({ 
		 onLoadSuccess: function () { 
			 
			 var curWwwPath = window.document.location.href;
	            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	            var pathName = window.document.location.pathname;
	            var pos = curWwwPath.indexOf(pathName);
	            //获取主机地址，如： http://localhost:8083
	            var localhostPaht = curWwwPath.substring(0, pos);
	            //获取带"/"的项目名，如：/uimcardprj
	            var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
			   $("#viewimg").attr('src',localhostPaht+"/"+$('#patentphoto').val()); 
			   $("#viewimg1").attr('src',localhostPaht+"/"+$('#patentphoto1').val()); 
			// document.getElementById("filepath").innerHTML=$('#newicon').val();
		 } 
	});
});

function uploadfile(){
	var file=document.getElementById('filebox_file_id_1').files[0];
	if(file!=null)
	{
	    var curWwwPath = window.document.location.href;
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	    var pathName = window.document.location.pathname;
	    var pos = curWwwPath.indexOf(pathName);
	    //获取主机地址，如： http://localhost:8083
	    var localhostPaht = curWwwPath.substring(0, pos);
	    //获取带"/"的项目名，如：/uimcardprj
	    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	    
	    var myurl ="http://localhost:8080/wqt/upload/fileUploadServlet?kind=patent";
	    $('#upload').form('submit',{
	        url:myurl,
	        onSubmit:function(){
	            return $("#upload").form();
	        },
	        success:function(data){
	            if (data !='false') {
	                $.messager.alert('提示消息','上传成功！','info',function (){
	                	 $("#patentshopphoto").val(data);
	                });
	            }else{
	                $.messager.alert('提示消息','上传失败！','info',function (){
	                    window.parent.closefileupload("");
	                });
	            }
	        }
	    });
	}
	else
	{
		alert("请选择要上传的图片!");
	}
}

function photoUpload(){
	var shopid=$("#id").val();
	var patentno=$("#patentno").val();
	if(patentno==""){
		alert("请先填写注册号")
	}else{
		if(shopid==""){
			alert("请先检测");
		}else{
			layer.open({
				type : 2,
				title : '图片上传',
				shadeClose : true,
				shade : 0.8,
				area : [ '580px', '430px' ],
				content : 'patent_addUpload.html?shopid='+shopid,
			});
		}
	}
}

