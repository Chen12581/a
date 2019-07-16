/**
 * Created by Administrator on 2018/1/15.
 */

//查询按钮
function doSubmitForm()
{
	var title="";
	var state="";
	var kind="";
	title=$('#title').textbox('getValue');
	state=$('#state').combobox('getValue');
	kind=$('#kind').combobox('getValue');
	var url='sysCases_selectWqtCasesPage.action';
	
	url+='?wqtCases.title='+title
	     +'&wqtCases.state='+state
	     +'&wqtCases.kind='+kind;
	
    $("#dictDataGrid").datagrid({
    	url : url
    });
}

function delNews(newsid)
{
	var m=confirm("您确定删除此新闻？")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysCases_deleteWqtCases.action",	
			dataType:"json",
			data:{
				'wqtCases.id':newsid
			},
			success:function(data){
				if(data!=null){
					alert('删除成功');
				}else{
					alert('删除失败');
				}
				window.location.reload();
			}
		})		
	}
}


function formatorderkind(val,row,index){ 
	var text="";
	if(row.orderkind=="1")
    {
		 text="买家";
    }
	else if(row.orderkind=="2")
    {
		 text="卖家";
    }
    return text; 
}

function formatkind(val,row,index){ 
	var text="";
	if(row.kind=='1')
    {
		 text="知识产权";
    }
	else if(row.kind=='2')
    {
		 text="企业服务";
    }
	else if(row.kind=='3')
    {
		 text="其他";
    }
    return text; 
}

function formatstatus(val,row,index){ 
	var text="";
	if(row.state=='0')
    {
		 text="编辑中";
    }
	else if(row.state=='1')
    {
		 text="已发布";
    }
	else if(row.state=='2')
    {
		 text="已上线";
    }
	else if(row.state=='3')
    {
		 text="定时上线";
    }
    return text; 
} 


//操作列表
function formatOper(val,row,index){
	var text='';
	    text='<a href="javascript:void(0);" id="view1" name="view1" style="margin-left:5px;" onclick="editNews('+row.id+')">修改</a>'+
	         '<a href="javascript:void(0);" id="view2" name="view2" style="margin-left:5px;" onclick="developNews('+row.id+')">发布</a>'+
	         '<a href="javascript:void(0);" id="view3" name="view3" style="margin-left:5px;" onclick="previewNews('+row.id+','+row.state+')">预览</a>'+
	         '<a href="javascript:void(0);" id="view4" name="view4" style="margin-left:5px;" onclick="onlineNews('+row.id+','+row.state+')">上线</a>'+
	         '<a href="javascript:void(0);" id="view7" name="view7" style="margin-left:5px;" onclick="timeonline('+row.id+','+row.state+')">定时上线</a>'+
	         '<a href="javascript:void(0);" id="view6" name="view6" style="margin-left:5px;" onclick="delNews('+row.id+')">删除</a>';
    return text;
}  


function timeonline(newsid,state)
{
	 if(state=='1')
	 {
		 layer.open({
			    type : 2,
			    title : '定时上线',
			    shadeClose : true,
			    shade : 0.8,
			    area : [ '400px', '300px' ],
			    content : 'timeonline.html?newsid=' + newsid
			});
	 }
	 else
	 {
		 alert("此新闻还没有发布,不能设置定时上线");
	 }
}
//新增新闻
function  addNews()
{
	window.location.href='wqtCases_add.html';
}

//修改新闻
function editNews(newsid)
{
	window.location.href='wqtCases_update.html?newsid='+newsid;
}

//发布新闻
function developNews(newsid)
{
	var m=confirm("您确定此案例都编辑完成，现在发布")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysCases_updateWqtCases.action",	
			dataType:"json",
			data:{
				'wqtCases.id':newsid,
				'wqtCases.state':'1',
			},
			success:function(data){
				alert(data.msg);
				window.location.reload();
			}
		})		
	}
  
}


//预览新闻
function previewNews(newsid,state)
{
	    if(state=='1' || state=='2')
		{
	    	$.ajax({
				type:"post",
				url:"sysCases_selWqtCasesNewsById.action",	
				dataType:"json",
				data:{
					'wqtCases.id':newsid
				},
				success:function(data){
					var curWwwPath = window.document.location.href;
		            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
		            var pathName = window.document.location.pathname;
		            var pos = curWwwPath.indexOf(pathName);
		            //获取主机地址，如： http://localhost:8083
		            var localhostPaht = curWwwPath.substring(0, pos);
		            //获取带"/"的项目名，如：/uimcardprj
		            var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
					window.open(localhostPaht+"/"+data.result.htmlpath);
				}
			})		
		}
	    else
	    {
	    	alert("此新闻还没有发布,不能预览");
	    }
}


//上线新闻
function onlineNews(newsid,state)
{
	   if(state=='1' || state=='2')
		{
	    	$.ajax({
				type:"post",
				url:"sysCases_updateWqtCases.action",	
				dataType:"json",
				data:{
					'wqtCases.state':2,
					'wqtCases.id':newsid
				},
				success:function(data){
					alert('此新闻上线成功');
					doSubmitForm();
				}
			})		
		}
	    else
	    {
	    	alert("此新闻还没有发布,不能上线");
	    }
}


//新增新闻


$(function(){
	var kind=$('#kind').textbox('getValue');
	$('#kind').combobox({
        onChange: function () {
        	var kind=$('#kind').textbox('getValue');
        	if(kind==1){
        		$.ajax({
            		url:'sysCases_selBrandKind.action',
            		type:'get',
            		dataType:'json',
            		success:function(data){
            			var json = data.result;
            			var data = [];
            			for(var i=0;i<json.length;i++){
    	        			var value = json[i].id;
    	        			var text = json[i].kindname;
    	        			data.push({"text":value+text,"value":text});
            			}
            			$("#kindname").combobox("loadData",data);
            		}
            	})
        	}else if(kind==2){
        		$.ajax({
            		url:'sysCases_selectCopyrightKind.action',
            		type:'get',
            		dataType:'json',
            		success:function(data){
            			var json = data.msg;
            			var data = [];
            			for(var i=0;i<json.length;i++){
    	        			var value = json[i].id;
    	        			var text = json[i].copyrightdesc;
    	        			data.push({"text":text,"value":text});
            			}
            			$("#kindname").combobox("loadData",data);
            		}
            	})
        	}else if(kind==3){
        		$.ajax({
            		url:'sysCases_selPatentKind.action',
            		type:'get',
            		dataType:'json',
            		success:function(data){
            			var json = data.msg;
            			var data = [];
            			for(var i=0;i<json.length;i++){
    	        			var value = json[i].id;
    	        			var text = json[i].kindname;
    	        			data.push({"text":text,"value":text});
            			}
            			$("#kindname").combobox("loadData",data);
            		}
            	})
        	}
//        	
        }
    });
})

