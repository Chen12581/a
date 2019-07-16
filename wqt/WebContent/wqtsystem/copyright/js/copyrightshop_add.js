
$(function(){	
	  $('#brandindustry').combobox({  
	        onSelect: function (row) {  
	            if (row != null) {  
	                $('#brandkind').combobox({  
	                    url: "sysBrand_brandKindsel?industryid=" + row.value
	                });  
	            }  
	        }  
	    });  
});


//保存
function submitForm()
{
	var copyrightkind=$('#copyrightkind').textbox('getValue');
	var copyrightname=$('#copyrightname').textbox('getValue');
	var price=$('#price').textbox('getValue');
	var bottomprice=$('#bottomprice').textbox('getValue');
	//商标名称
	if(copyrightname==null || copyrightname=="")
	{
		alert("请输入版权名称");
		return;
	}
	if(copyrightkind==null || copyrightkind=="")
	{
		alert("请输入版权类别");
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
	    $('#copyrightForm').form('submit', {   
		   onSubmit: function(){  
		    	return $(this).form('enableValidation').form('validate');
		    },  
		    success:function(data)
		    {  
		    	alert(data);
		    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		        parent.layer.close(index);
		        parent.window.location.href='copyrightshop_list.html';
		    }  
		});
}

//关闭窗口
function doClose()
{   
	
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='copyrightshop_list.html';
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



/*图片预览*/
function fileup(_obj)
{
	var _imgsrc=$(_obj).filebox("getValue");
	var _file=$(_obj).context.ownerDocument.activeElement.files[0];
	var filesize=_file.size;
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
function fileup1(_obj)
{
	var _imgsrc=$(_obj).filebox("getValue");
	var _file=$(_obj).context.ownerDocument.activeElement.files[0];
	
	var filesize=_file.size;
	if(filesize<200*1024)
	{
		$("#viewimg1").attr("src",getObjectURL(_file));
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
	var file1=document.getElementById('filebox_file_id_2').files[0];
	if(file!=null || file1!=null)
	{
	    var curWwwPath = window.document.location.href;
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	    var pathName = window.document.location.pathname;
	    var pos = curWwwPath.indexOf(pathName);
	    //获取主机地址，如： http://localhost:8083
	    var localhostPaht = curWwwPath.substring(0, pos);	
	    //获取带"/"的项目名，如：/uimcardprj
	    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	    
	    var myurl ="http://www.w7tong.com/wqt/upload/fileUploadServlet?kind=copyright";
	    $('#upload').form('submit',{
	        url:myurl,
	        onSubmit:function(){
	            return $("#upload").form();
	        },
	        success:function(data){
	            if (data !='false') {
	                $.messager.alert('提示消息','版权上传成功！','info',function (){
	                	 $("#copyrightphoto").val(data);
	                });
	            }else{
	                $.messager.alert('提示消息','版权上传失败！','info',function (){
	                    window.parent.closefileupload("");
	                });
	            }
	        }
	    });
	    $('#upload1').form('submit',{
	        url:myurl,
	        onSubmit:function(){
	            return $("#upload1").form();
	        },
	        success:function(data){
	            if (data !='false') {
	                $.messager.alert('提示消息','其他上传成功！','info',function (){
	                	 $("#copyrightphoto1").val(data);
	                });
	            }else{
	                $.messager.alert('提示消息','其他上传失败！','info',function (){
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


