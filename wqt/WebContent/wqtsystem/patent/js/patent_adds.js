

//关闭窗口
function doClose()
{   
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
}

function ajaxLoading(){   
    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");   
    $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});   
 }   
 function ajaxLoadEnd(){   
     $(".datagrid-mask").remove();   
     $(".datagrid-mask-msg").remove();               
}

function save(){
	var fileName=$("#file").val();
    var suffix=(fileName.substr(fileName.lastIndexOf(".")+1)).toUpperCase();
    if(!(suffix=='XLSX')){
        alert("请上传XLSX类型的文件！");
        return false;
    }
	$('#storeForm').form('submit', {   
		onSubmit: function(){  
			ajaxLoading();
			return $(this).form('enableValidation').form('validate');
			ajaxLoadEnd();
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

function uploadfile(){
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    //shopid=1111 其中1111位店铺的ID，要传入到后台去的
    //var myurl = localhostPaht + projectName+"/upload/fileUploadServlet?kind=interview";
    
     var myurl = "http://www.w7tong.com/wqt/upload/fileUploadServlet?kind=patent";

    $('#upload').form('submit',{
        url:myurl,
        onSubmit:function(){
            return $("#upload").form();
        },
        success:function(data){
//				读取后台返回的原始数据
//                var data = eval('(' + data + ')'); // change the JSON string to javascript object
            if (data.success){
                alert(data.message)
            };

            if (data !='false') {
                $.messager.alert('提示消息','上传成功！','info',function (){
                	$("#file").val(data);
                    console.log(data);
                    // window.parent.closefileupload(data);
                });
            }else{
                $.messager.alert('提示消息','上传失败！','info',function (){
                    window.parent.closefileupload("");
                });
            }
        }

    });
}


