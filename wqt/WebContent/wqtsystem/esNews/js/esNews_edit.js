/* 获取url的search */
function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};

var newsid=getParameter('newsid');

$(function(){	
	$('#id').val(newsid);	
	$('#new_editform').form('load', 'sysEsNews_selectEsNewsOne.action?esnews.id='+newsid);
	$('#new_editform').form('load', 'sysEsNews_NewsBookmarkOne.action?esNewsBookmark.newsid='+newsid);
	$("#new_editform").form({ 
		 onLoadSuccess: function () { 
			 var ue =  UE.getEditor('uecontent');
			 ue.ready(function() {//编辑器初始化完成再赋值
				 ue.setContent($('#content').val());
				});
			 
			 var curWwwPath = window.document.location.href;
	            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	            var pathName = window.document.location.pathname;
	            var pos = curWwwPath.indexOf(pathName);
	            //获取主机地址，如： http://localhost:8083
	            var localhostPaht = curWwwPath.substring(0, pos);
	            //获取带"/"的项目名，如：/uimcardprj
	            var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	            $("#viewimg").attr('src',localhostPaht+$('#newicon').val());
			// document.getElementById("filepath").innerHTML=$('#newicon').val();
		 } 
	});
});


//提交信息
function doSubmitForm()
{
	//新闻标题
	var title=$("#title").val();
	if(title==null || title=='')
	{
		alert("请输入新闻标题");
		return;
	}

    //新闻关键词
    var mkeyword=$("#mkeyword").val();
    if(mkeyword==null || mkeyword=='')
    {
        alert("请输入新闻标题");
        return;
    }

    //文章的描述
    var mdesc=$("#mdesc").val();
    if(mdesc==null || mdesc=='')
    {
        alert("请输入新闻来源");
        return;
    }
	
	//新闻来源
	var sourcfrom=$("#sourcfrom").val();
	if(sourcfrom==null || sourcfrom=='')
	{
		alert("请输入新闻来源");
		return;
	}
	
	//新闻图标
	var headfile=$('#file').val();
	if(headfile==null && headfile=="")
	{
		alert("请输入新闻图标");
		return;
	}
	
	var ue =  UE.getEditor('uecontent');
	var newscontent = ue.getContent();

    //截取一段内容用于展示
    var text = ue.getContentTxt();
    $('#hits').val(text.substring(0,140));

	if(newscontent==null && newscontent=="")
	{
		alert("请输入新闻内容");
		return;
	}
	//alert(newscontent);
	$("#content").val(newscontent);
	
	$('#new_editform').form('submit', {   
		onSubmit: function(){  
			return $(this).form('enableValidation').form('validate');
		},  
		success:function(data)
		{  
			alert(data);
			window.history.back();  //返回上一页
		}  
	});
	
}

//关闭窗口
function doClose()
{   
	window.history.back();  //返回上一页
}


$(function(){	
	   
});

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



/*图片预览*/
function fileup(_obj)
{
	var _imgsrc=$(_obj).filebox("getValue");
	var _file=$(_obj).context.ownerDocument.activeElement.files[0];
	var filesize=_file.size;
	console.log(filesize);
	if(filesize<200*1024)
	{
		$("#viewimg").attr("src",getObjectURL(_file));
	}
	else
	{
		alert("请上传小于200KB的图片");
		$(_obj).filebox("setValue","");
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
	    
	    var myurl ="http://www.w7tong.com/upload/fileUploadServlet?kind=newses";
	    $('#upload').form('submit',{
	        url:myurl,
	        onSubmit:function(){
	            return $("#upload").form();
	        },
	        success:function(data){
	            if (data !='false') {
	                $.messager.alert('提示消息','上传成功！','info',function (){
	                	 $("#newicon").val(data);
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