
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
	$('#estradeForm').form('load', 'sysEscompany_selectEsTradeCompanyShopOne.action?esTradeCompanyShop.id='+id);
	$("#estradeForm").form({ 
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
	 $.ajax({
			url:"sysEscompany_selectEsTradeCompanyShopPhotoList.action?esTradeCompanyShop.id="+id,
			type:"get",
			data:{
				'esTradeCompanyShop.id':id
			},
			dataType:"json",
			success:function(data){
				var data=data.msg
				var dd="";
				for(var i=0;i<data.length;i++){
					dd+='<div style="border: 1px solid red;">'
						+'<div style="height:20px; width:20px;text-align:center; font-size:15px;cursor:pointer; float:right"onclick="dodelete('+data[i].id+')">X</div>'
						+'<img style="width:200px;height:200px;" src="/wqt'+data[i].photopath+'">'
						+'</div>';
				}
				$("#viewimg").attr("src",'/wqt'+data[0].photopath);
				$("#viewimg1").attr("src",'/wqt'+data[1].photopath);
				$("#viewimg2").attr("src",'/wqt'+data[2].photopath);
				$("#viewimg3").attr("src",'/wqt'+data[3].photopath);
			}
		})
});

function dodelete(id){
	console.log(id)
	var m=confirm("您确定删除此张图片？")
	if(m==true){
		$.ajax({
			type:"get",
			url:"sysCopyright_delIprCopyrightShopPhoto",	
			dataType:"json",
			data:{
				'iprCopyrightShopPhoto.id':id
			},
			success:function(data){
				window.location.reload();
			}
		})	
		
	}
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


//保存按钮
function submitForm()
{
	var provincename=$('#provinceid').textbox('getText');
	var cityname=$('#cityid').textbox('getText');
	var areaname=$('#areaid').textbox('getText');
	$('#provincename').textbox('setValue',provincename);
	$('#cityname').textbox('setValue',cityname);
	$('#areaname').textbox('setValue',areaname);
	var a=$('#provincename').textbox('getValue');
	//商标名称
//	if(a==null || a=="")
//	{	
//		
//		alert("请输入专利名称");
//		console.log(a+"--"+b+"--"+c)
//		return;
//	}
//	var re = /^[0-9]*$/;	//0-9位数字
//	if(!re.test(price)){
//		console.log(price);
//		alert("请输入正确的价格");
//		$('#_easyui_textbox_input3').css('color','red');
//		return
//	}
//	if(!re.test(bottomprice)){
//		console.log(bottomprice);
//		alert("请输入正确的价格");
//		$('#_easyui_textbox_input4').css('color','red');
//		return
//	}
	
//	$('input').each(function(index,ev){
//		if($(ev).val()=='请选择' || $(ev).val()==''){
//			alert("请填写完整信息")
////			console.log($(ev).val());
//			console.log(this);
//			$(this).parent().prev().css({"color":"red"});
//			return false;
//		}else{
//			$(this).parent().prev().css({"color":"black"});
//		}
//	});
//	$('select').each(function(index,ev){
//		if($(ev).val()=='请选择'){
//			alert("请填写完整信息")
////			console.log($(ev).val());
//			console.log(this);
//			$(this).css({"color":"red"});
//			return false;
//		}else{
//			$(this).css({"color":"black"});
//		}
//	});
	
	var arr=[];
	$('input').each(function(index,ev){
	    if($(ev).is(":checked")){
	    	var data=$(this).val();
	    	arr.push(data);
		}
	})
    $("#capitalid").val(arr.join());
	
	
    $('#estradeForm').form('submit', {   
	   onSubmit: function(){  
	    	return $(this).form('enableValidation').form('validate');
	    },  
	    success:function(data)
	    {  
	    	alert(data);
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	        parent.layer.close(index);
	        parent.window.location.href='tradeCompany_list.html';
	    }  
	});
}


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
		$(_obj).filebox("setValue","");
		alert("请上传小于200KB的图片");
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
		$(_obj).filebox("setValue","");
		alert("请上传小于200KB的图片");
	}
}
function fileup2(_obj)
{
	var _imgsrc=$(_obj).filebox("getValue");
	var _file=$(_obj).context.ownerDocument.activeElement.files[0];
	
	var filesize=_file.size;
	if(filesize<200*1024)
	{
		$("#viewimg2").attr("src",getObjectURL(_file));
	}
	else
	{
		$(_obj).filebox("setValue","");
		alert("请上传小于200KB的图片");
	}
}
function fileup3(_obj)
{
	var _imgsrc=$(_obj).filebox("getValue");
	var _file=$(_obj).context.ownerDocument.activeElement.files[0];
	
	var filesize=_file.size;
	if(filesize<200*1024)
	{
		$("#viewimg3").attr("src",getObjectURL(_file));
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
	var file2=document.getElementById('filebox_file_id_3').files[0];
	var file3=document.getElementById('filebox_file_id_4').files[0];
	if(file1!=null || file2!=null || file3!=null || file!=null)
	{
	    var curWwwPath = window.document.location.href;
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	    var pathName = window.document.location.pathname;
	    var pos = curWwwPath.indexOf(pathName);
	    //获取主机地址，如： http://localhost:8083
	    var localhostPaht = curWwwPath.substring(0, pos);	
	    //获取带"/"的项目名，如：/uimcardprj
	    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	    
	    var myurl ="http://www.w7tong.com/wqt/upload/fileUploadServlet?kind=es";
	    $('#upload').form('submit',{
	        url:myurl,
	        onSubmit:function(){
	            return $("#upload").form();
	        },
	        success:function(data){
	            if (data !='false') {
	                $.messager.alert('提示消息','上传成功！','info',function (){
	                	 $("#companyphoto").val(data);
	                });
	            }else{
	                $.messager.alert('提示消息','上传失败！','info',function (){
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
//	                $.messager.alert('提示消息','2上传成功！','info',function (){
	                	 $("#companyphoto1").val(data);
//	                });
	            }else{
//	                $.messager.alert('提示消息','2上传失败！','info',function (){
	                    window.parent.closefileupload("");
//	                });
	            }
	        }
	    });
	    $('#upload2').form('submit',{
	        url:myurl,
	        onSubmit:function(){
	            return $("#upload2").form();
	        },
	        success:function(data){
	            if (data !='false') {
//	                $.messager.alert('提示消息','3上传成功！','info',function (){
	                	 $("#companyphoto2").val(data);
//	                });
	            }else{
//	                $.messager.alert('提示消息','3上传失败！','info',function (){
	                    window.parent.closefileupload("");
//	                });
	            }
	        }
	    });
	    $('#upload3').form('submit',{
	        url:myurl,
	        onSubmit:function(){
	            return $("#upload3").form();
	        },
	        success:function(data){
	            if (data !='false') {
//	                $.messager.alert('提示消息','4上传成功！','info',function (){
	                	 $("#companyphoto3").val(data);
//	                });
	            }else{
//	                $.messager.alert('提示消息','4上传失败！','info',function (){
	                    window.parent.closefileupload("");
//	                });
	            }
	        }
	    });
	}
	else
	{
		alert("请选择要上传的图片!");
	}
}

	
$(function () {
           $('#provinceid').combobox({
                onChange: function () {
                	var provinceid=$('#provinceid').textbox('getValue');
                	$.ajax({
                		url:'sysEscompany_selEsTradeCompanyCity.action',
                		type:'get',
                		data:{
                			'esTradeCompanyCity.provinceid':provinceid
                		},
                		dataType:'json',
                		success:function(data){
                			var json = data.msg;
                			var data = [];
                			for(var i=0;i<json.length;i++){
                			var value = json[i].id;
                			var text = json[i].cityname;
                			data.push({"text":text,"value":value});
                			}
                			$("#cityid").combobox("loadData",data);
                		}
                	})
                	$.ajax({
                		url:'sysEscompany_selEsTradeCompanyprovince.action',
                		type:'get',
                		data:{
                			'esTradeCompanyProvince.id':provinceid
                		},
                		dataType:'json',
                		success:function(data){
                			$("#areaCode").textbox('setValue',data.msg[0].areacodename);
                			$("#areacode").textbox('setValue',data.msg[0].areacode);
                		}
                	})
                }
            });
           
           $('#cityid').combobox({
                onChange: function () {
                	var city=$('#cityid').textbox('getValue');
                	$.ajax({
                		url:'sysEscompany_selEsTradeCompanyArea.action',
                		type:'get',
                		data:{
                			'esTradeCompanyArea.cityid':city
                		},
                		dataType:'json',
                		success:function(data){
                			var json = data.msg;
                			var data = [];
                			for(var i=0;i<json.length;i++){
                			var value = json[i].id;
                			var text = json[i].areaname;
                			data.push({"text":text,"value":value});
                			}
                			$("#areaid").combobox("loadData",data);
                		}
                	})
                }
            });
	
	$("#provincename").next().hide();
	$("#cityname").next().hide();
	$("#areaname").next().hide();
	$("#areacode").next().hide();
	$("#capitalid").next().hide();
	$("#intangiblecapital").next().hide();
	
	$.ajax({
		url:'sysEscompany_selectEsTradeCapital.action',
		type:'get',
		dataType:'json',
		success:function(data){
			var json = data.msg;
			var dd='';
			for(var i=0;i<data.msg.length;i++){
				dd+='<b>'+json[i].capitalname+':</b>'
				+'<input style="vertical-align: middle;" value="'+json[i].id+'" type="checkbox"  id="capital'+i+'"  name="esTradeCompanyShop.capital'+i+'" />&nbsp;'
			}
			$("#capital").html(dd);
			
			var intangiblecapital = $("#intangiblecapital").textbox('getText');
			var array = intangiblecapital.split(",");
			console.log("a"+array);
			for (var j = 0; j < array.length; j++) {
				for(var i=0;i<json.length;i++){
					if($.trim(array[j])==json[i].id){
						$('#capital'+i).attr("checked","checked");
					}
				}
			}
			
			    
			
		}
	
	})
})

function doClose()
{   
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='tradeCompany_list.html';
}
