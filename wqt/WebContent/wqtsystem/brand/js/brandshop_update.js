

//查询按钮
function submitForm()
{
	var brandname=$('#brandname').textbox('getValue');
	var initialnoticeissue=$('#initialnoticeissue').textbox('getValue');
	var regnoticeissue=$('#regnoticeissue').textbox('getValue');
	var brandkind = $('#Brandkind').val();
	var ownermobile=$('#ownermobile').textbox('getValue');
	var price=$('#price').textbox('getValue');
	var bottomprice=$('#bottomprice').textbox('getValue');
	//商标名称
	if(brandname==null || brandname==""){
		alert("请输入商标名称");
		return;
	}
	if(brandkind == null || brandkind == ""){
		alert("请输入商标类别");
		return;
	}
	var re = /^[0-9]*$/;	//0-9位数字
	var re1 = /^1([38]\d|5[0-35-9]|7[3678])\d{8}$/;    //11位手机号
	if(!re.test(initialnoticeissue)){
		alert("请在初审公告期号处输入数字");
		$('#_easyui_textbox_input3').css('color','red');
		return
	}else{
		$('#_easyui_textbox_input3').css('color','black');
	}
	if(!re.test(regnoticeissue)){
		alert("请在注册公告期号处输入数字");
		$('#_easyui_textbox_input4').css('color','red');
		return
	}
	else{
		$('#_easyui_textbox_input4').css('color','black');
	}
	if(!re.test(price)){
		alert("请输入正确的价格");
		$('#_easyui_textbox_input5').css('color','red');
		return
	}else{
		$('#_easyui_textbox_input5').css('color','black');
	}
	if(!re.test(bottomprice)){
		alert("请输入正确的价格");
		$('#_easyui_textbox_input6').css('color','red');
		return
	}else{
		$('#_easyui_textbox_input6').css('color','black');
	}
	
	if(!re1.test(ownermobile)){
		alert("号码不能为空或格式错误");
		$('#_easyui_textbox_input8').css('color','red');
		return
	}else{
		$('#_easyui_textbox_input8').css('color','black');
	}
	
	$("#ownerForm").form('submit',{
		 onSubmit: function(){ 
			 return $(this).form('enableValidation').form('validate');
		 }
	})
    $('#brandForm').form('submit', {   
	    onSubmit: function(){  
	    	return $(this).form('enableValidation').form('validate');
	    },  
	    success:function(data)
	    {  
	    	alert(data);
	    	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	        parent.layer.close(index);
	        parent.window.location.href='brandshop_hanging.html';
	    }  
	}); 
}

function reload(){
	var regcode=$("#regcode").val();
	var shopid='';
	if(regcode==null || regcode==""){
		alert("请输入注册号")
	}
	var re = /^[0-9]*$/;
	if(!re.test(regcode)){
		alert("请输入数字")
	}else{
		$.ajax({
			url:"sysBrand_selBrandRegcode.action",
			type:"get",
			data:{
				'regcode':regcode
			},
			dataType:"json",
			success:function(data){
				if(data==null){
					alert("信息过期，请重新登录");
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
				     parent.layer.close(index);
				     parent.window.location.href='brandshop_hanging.html';
				}else{
					if(data.msg==1){
						$("#tipsmsg").css("color",'red');
					}else{
						$("#tipsmsg").css("color",'green');
					}
				}
				$('#brandForm').form('load', data);
				
				shopid=$("#brandid").val();
				$("#brandshopid").attr("name",shopid);
				
				$.ajax({
					type:"GET",
					url:"sysBrand_selBrandShopowner.action?brandshopid="+shopid,
					dataType:"json",
					success:function(data){
						$('#ownerForm').form('load', data);
					}
				})
				if(regcode!=""){
					$.ajax({
						type:"GET",
						url:"sysBrand_selIprBrandShopItem.action?shopid="+shopid,
						dataType:"json",
						data:{
							'brandShopItem.shopid':shopid
						},
						success:function(data){
							var data=data.msg.list;
							var dd="";
							for(var i=0;i<data.length;i++){
								dd+='<span style=" display: block; float: left; border: 1px solid #000;margin-right:5px;margin-top:5px; padding: 3px">'+data[i].itemname+'</span>';
							}
							$("#branditem").html(dd);
								
						}
					})
					$.ajax({
						type:"GET",
						url:"sysBrand_selIprBrandShopGroup.action?shopid="+shopid,
						dataType:"json",
						data:{
							'brandShopGroup.shopid':shopid
						},
						success:function(data){
							var data=data.msg.list;
							var dd="";
							for(var i=0;i<data.length;i++){
								dd+='<span style=" display: block; float: left; border: 1px solid #000;margin-right:5px;margin-top:5px; padding: 3px">'+data[i].groupcode+'</span>';
							}
							$("#brandgroup").html(dd);
								
						}
					})
				}else{
					alert("注册号不能为空！");
				}
			}
			
		})
				$.ajax({
					url:"sysBrand_selectBrandKind.action?regcode="+regcode,
					type:"get",
					dataType:"json",
					success:function(data){
						if(data.msg!=null){
							var dd="";
							if(data.msg[0].brandkind!=undefined){
								dd='<span style="border: 1px solid #000;margin-right:5px;padding: 3px">'+data.msg[0].brandkind.substring(0,2)+data.msg[0].kindname+'</span>';
								$("#brandkind").html(dd);
								var Brandkind=data.msg[0].brandkind;
								Brandkind=Brandkind.substring(0,2);
								$("#Brandkind").val(Brandkind);
							}else{
								$("#brandkind").html('');
							}
						}
					}
				})
		
	}
}

function test(){
	var shopid=$("#brandid").val();
	var regcode=$("#regcode").val();
	if(regcode==''){
		alert("请先填选注册号");
	}else{
		if(shopid==''){
			alert("请先检测");
		}else{
			layer.open({
			    type : 2,
			    title : ' 类别信息',
			    shadeClose : true,
			    shade : 0.8,
			    area : [ '800px', '600px' ],
			    content : 'brandshop_shop.html?shopid='+shopid,
			});
		}
		
	}
}

var id=getParameter('brandid');

function getParameter(sProp) {
    var re = new RegExp(sProp + "=([^\&]*)", "i");
    var a = re.exec(document.location.search);
    if (a == null)
        return null;
    return a[1];
};

$(function(){	
	$('#brandForm').form('load', 'sysBrand_selectBrandShopOne.action?brandShop.id='+id);
	$("#brandForm").form({ 
		 onLoadSuccess: function () { 
			 
			 var curWwwPath = window.document.location.href;
	            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	            var pathName = window.document.location.pathname;
	            var pos = curWwwPath.indexOf(pathName);
	            //获取主机地址，如： http://localhost:8083
	            var localhostPaht = curWwwPath.substring(0, pos);
	            //获取带"/"的项目名，如：/uimcardprj
	            var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
			   $("#viewimg").attr('src',localhostPaht+"/"+$('#brandphoto').val()); 
			   $("#viewimg1").attr('src',localhostPaht+"/"+$('#brandphoto1').val()); 
			// document.getElementById("filepath").innerHTML=$('#newicon').val();
		 } 
	});
	$.ajax({
		url:"sysBrand_selIprBrandShopInfo.action?shopid="+id,
		type:"get",
		dataType:"json",
		success:function(data){
			if(data.msg[0]!=null){
				var cc="";
				cc='<span style="border: 1px solid #000;margin-right:5px;padding: 3px">'+data.msg[0].brandkind.substring(0,2)+data.msg[0].kindname+'</span>';
				if(data.msg[0].brandkind!=undefined){
					$("#brandkind").html(cc);
					
				}else{
					$("#brandkind").html("");
				}
				var Brandkind=data.msg[0].brandkind;
				Brandkind=Brandkind.substring(0,2); 
				if(Brandkind<10){
					Brandkind=Brandkind.substring(1,2);
				}
				$("#Brandkind").val(Brandkind);
			}
		}
	})
	
	$.ajax({
						type:"GET",
						url:"sysBrand_selIprBrandShopItem.action?shopid="+id,
						dataType:"json",
						data:{
							'brandShopItem.shopid':id
						},
						success:function(data){
							var data=data.msg.list;
							var dd="";
							for(var i=0;i<data.length;i++){
								dd+='<span style="display: block; float: left; border: 1px solid #000;margin-right:5px; margin-top:5px; padding: 3px">'+data[i].itemname+'</span>';
							}
							$("#branditem").html(dd);
								
						}
					})
					$.ajax({
						type:"GET",
						url:"sysBrand_selIprBrandShopGroup.action?shopid="+id,
						dataType:"json",
						data:{
							'brandShopGroup.shopid':id
						},
						success:function(data){
							var data=data.msg.list;
							var dd="";
							for(var i=0;i<data.length;i++){
								dd+='<span style="display: block; float: left;  border: 1px solid #000;margin-right:5px; margin-top:5px; padding: 3px">'+data[i].groupcode+'</span>';
							}
							$("#brandgroup").html(dd);
								
						}
					})
	$('#ownerForm').form('load', 'sysBrand_selBrandShopowner.action?brandshopid='+id);
	$("#brandshopid").val(id);
});



function photoUpload(){
	var shopid=$("#brandid").val();
	var regcode=$("#regcode").val();
	if(regcode==""){
		alert("请先填写注册号")
	}else{
		if(shopid==''){
			alert("请先检测");
		}else{
			layer.open({
				type : 2,
				title : '图片上传',
				shadeClose : true,
				shade : 0.8,
				area : [ '600px', '630px' ],
				content : 'brandshop_addUpload.html?shopid='+shopid,
			});
		}
	}
}

//关闭窗口
function doClose()
{   
	
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
     parent.layer.close(index);
     parent.window.location.href='brandshop_hanging.html';
}