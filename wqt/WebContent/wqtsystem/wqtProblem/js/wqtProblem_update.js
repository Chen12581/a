
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
	$('#id').val(id);	
	$('#wqtProblemForm').form('load', 'sysProblem_selectWqtProblemList.action?wqtProblem.id='+id);
	$("#wqtProblemForm").form({ 
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
//			   $("#viewimg").attr('src',localhostPaht+"/"+$('#newicon').val()); 
			// document.getElementById("filepath").innerHTML=$('#newicon').val();
		 } 
	});
});

//保存按钮
function submitForm()
{
	var ue =  UE.getEditor('uecontent');
	var newscontent = ue.getContent();

    //截取一段内容用于展示
    var text = ue.getContentTxt();
    $('#simpledesc').val(text.substring(0,140));

	//alert(newscontent);
	$("#content").val(newscontent);
	
      	    $('#wqtProblemForm').form('submit', {   
      		    onSubmit: function(){  
      		    	return $(this).form('enableValidation').form('validate');
      		    },  
      		    success:function(data)
      		    {  
      		    	var obj = JSON.parse(data);
      		    	alert(obj.msg);
      		    	window.history.back();  //返回上一页
      		    }  
      		});
}

$(function(){
	$('#problemkind').combobox({
        onChange: function () {
        	var problemkind=$('#problemkind').textbox('getValue');
        	$.ajax({
        		url:'sysProblem_selectWqtsonproblemkind.action',
        		type:'get',
        		data:{
        			'wqtProblemKind.problemkind':problemkind
        		},
        		dataType:'json',
        		success:function(data){
        			var json = data.result;
        			var data = [];
        			for(var i=0;i<json.length;i++){
        			var value = json[i].sonproblemkind;
        			var text = json[i].sonproblemkindname;
        			data.push({"text":text,"value":value});
        			}
        			$("#sonproblemkind").combobox("loadData",data);
        		}
        	})
        }
    });
	
})


//关闭窗口
function doClose()
{   
	window.history.back();  //返回上一页
}