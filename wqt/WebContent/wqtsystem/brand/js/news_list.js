/**
 * Created by Administrator on 2018/1/15.
 */

//查询按钮
function doSubmitForm()
{
	var title="";
	var state="";
	var kindid="";
	title=$('#title').textbox('getValue');
	state=$('#state').combobox('getValue');
	kindid=$('#kindid').combobox('getValue');
	var url='sysnew_selTSysNewsPage';
	
	url+='?sysnews.title='+title
	     +'&sysnews.state='+state+'&sysnews.kindid='+kindid;
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
			url:"sysnew_delTSysNews",	
			dataType:"json",
			data:{
				'newsid':newsid
			},
			success:function(data){
				alert(data.msg);
				doSubmitForm();
			}
		})		
	}
}

function formatplate(val,row,index){ 
	var text="com网站";
	if(row.platename=="1")
    {
		 text="com网站";
    }
	else if(row.platename=="2")
    {
		 text="cn网站";
    }
	else 
    {
		 text="com网站";
    }
    return text; 
}


function formatkind(val,row,index){ 
	var text="行业资讯";
	if(row.kindid=='1')
    {
		 text="行业资讯";
    }
	else if(row.kindid=='2')
    {
		 text="网站公告";
    }
	else if(row.kindid=='3')
    {
		 text="售后回访";
    }
	else 
    {
		 text="行业资讯";
    }
    return text; 
}

function formatstatus(val,row,index){ 
	var text="编辑中";
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
	else 
    {
		 text="编辑中";
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
	window.location.href='news_add.html';
}


//修改新闻
function editNews(newsid)
{
	window.location.href='news_edit.html?newsid='+newsid;
}

//发布新闻
function developNews(newsid)
{
	var m=confirm("您确定此新闻都编辑完成，现在发布")
	if(m==true){
		$.ajax({
			type:"post",
			url:"sysnew_developTSysNews",	
			dataType:"json",
			data:{
				'newsid':newsid
			},
			success:function(data){
				alert(data.msg);
				doSubmitForm();
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
				url:"sysnew_selTSysNewsById",	
				dataType:"json",
				data:{
					'sysnews.id':newsid
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
					window.open(localhostPaht+"/"+data.htmlpath);
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
				url:"sysnew_updateTSysNews",	
				dataType:"json",
				data:{
					'sysnews.state':2,
					'sysnews.id':newsid
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
function  doAdd()
{
	window.location.href='news_add.html';
}



