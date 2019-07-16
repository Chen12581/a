
//$(function(){	
//	  $('#brandindustry').combobox({  
//	        onSelect: function (row) {  
//	            if (row != null) {  
//	                $('#brandkind').combobox({  
//	                    url: "sysBrand_brandKindsel?industryid=" + row.value
//	                });  
//	            }  
//	        }  
//	    });  
//});


var id=getParameter('id');

function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};



$(function(){	
	$('#patentBuyForm').form('load', 'sysPatentBuy_selectPatentBuyOne.action?iprPatentBuy.id='+id);
	$("#patentBuyForm").form({ 
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
			// document.getElementById("filepath").innerHTML=$('#newicon').val();
		 } 
	});
});


//保存按钮
function submitForm()
{
      	    $('#patentBuyForm').form('submit', {   
      		    onSubmit: function(){  
      		    	return $(this).form('enableValidation').form('validate');
      		    },  
      		    success:function(data)
      		    {  
      		    	var obj = JSON.parse(data);
      		    	alert(obj.msg);
      		    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
      		        parent.layer.close(index);
      		        parent.window.location.href='patentBuy_list.html';
      		    }  
      		});
}



//关闭窗口
function doClose()
{   
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='patentBuy_list.html';
}