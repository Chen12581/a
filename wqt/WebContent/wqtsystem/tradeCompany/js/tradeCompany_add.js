
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


//保存按钮
function submitForm()
{
	var provincename=$('#provinceid').textbox('getText');
	var cityname=$('#cityid').textbox('getText');
	var areaname=$('#areaid').textbox('getText');
	$('#provincename').textbox('setValue',provincename);
	$('#cityname').textbox('setValue',cityname);
	$('#areaname').textbox('setValue',areaname);	
	var cityid=$('#cityid').textbox('getText');
	var areaid=$('#areaid').textbox('getText');
	var regcapitalmoney=$('#regcapitalmoney').val();
	var price=$('#price').textbox('getValue');
	var mobileno=$('#mobileno').textbox('getValue');
	
	if($("#companyphoto").val()!=''||$("#companyphoto1").val()!=''){
	
	if(cityid==''){
		$('#cityid').prev().css({"color":"red"});
	}else{
		$('#cityid').prev().css({"color":"black"});
	}
	if(areaid==''){
		$('#areaid').prev().css({"color":"red"});
	}else{
		$('#areaid').prev().css({"color":"black"});
	}
	
	var re = /^[0-9]*$/;	//0-9位数字
	var re1=/^\s*$|^1[0-9]{10}$/;    //11位手机号
	if(!re.test(regcapitalmoney)){
		alert("请输入正确的金额");
		$('#_easyui_textbox_input4').css('color','red');
		return
	}else{
		$('#_easyui_textbox_input4').css('color','black');
	}
	
	if(!re.test(price)){
		alert("请输入正确的价格");
		$('#_easyui_textbox_input8').css('color','red');
		return
	}else{
		$('#_easyui_textbox_input8').css('color','black');
	}
	
	if(!re1.test(mobileno)){
		alert("请输入正确的11位手机号");
		$('#_easyui_textbox_input14').css('color','red');
		return
	}else{
		$('#_easyui_textbox_input14').css('color','black');
	}
	
	var arr=[];
	$('input').each(function(index,ev){
	    if($(ev).is(":checked")){
	    	var data=$(this).val();
	    	arr.push(data);
		}
	})
    $("#capitalid").val(arr.join());
	console.log($("#capitalid").val());
	var a=false;
	$('.allInput').each(function(index,ev){
		if($(ev).val()=='请选择' || $(ev).val()==''){
			alert("请填写完整信息")
			$(this).parent().prev().css({"color":"red"});
			a=false
			return a;
		}else{
			$(this).parent().prev().css({"color":"black"});
			a=true;
			return a;
		}
	});
	
	if(a){
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
	   
	}else{
		alert('请先上传');
	}
	
	
}



//关闭窗口
function doClose()
{   
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='tradeCompany_list.html';
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
	if(filesize<1024*1024)
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
	if(file1!=null && file2!=null && file3!=null && file!=null)
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
//	                $.messager.alert('提示消息','营业执照副本上传成功！','info',function (){
	                	 $("#companyphoto1").val(data);
//	                });
	            }else{
//	                $.messager.alert('提示消息','营业执照副本上传失败！','info',function (){
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
//	                $.messager.alert('提示消息','税务登记证正本上传成功！','info',function (){
	                	 $("#companyphoto2").val(data);
//	                });
	            }else{
//	                $.messager.alert('提示消息','税务登记证正本上传失败！','info',function (){
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
//	                $.messager.alert('提示消息','税务登记证副本上传成功！','info',function (){
	                	 $("#companyphoto3").val(data);
//	                });
	            }else{
//	                $.messager.alert('提示消息','税务登记证副本上传失败！','info',function (){
	                    window.parent.closefileupload("");
//	                });
	            }
	        }
	    });
	}
	else
	{
		alert("请把要上传的图片填写完整!");
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
	
	$.ajax({
		url:'sysEscompany_selectEsTradeCapital.action',
		type:'get',
		dataType:'json',
		success:function(data){
			var json = data.msg;
			var dd='';
			for(var i=0;i<data.msg.length;i++){
				dd+='<b>'+json[i].capitalname+':</b>'
				 +'<input style="vertical-align: middle;" value="'+json[i].id+'" type="checkbox" id="capital'+i+'"  name="esTradeCompanyShop.capital'+i+'" />&nbsp;'
			     	
			}
			$("#capital").html(dd);
		}
	})
	
	
})


