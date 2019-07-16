
//分页
// $(function(){
//     /* 定义变量 */
//     var sUrl=wqturl+'/suggestlist',
//         oData={},
//         oStr='';
//     /* fn */
//     ajaxFn(sUrl,oData);
//     function ajaxFn(url,Data){
//         pagesize = parseInt(Data.pagesize || '10');
//         currpage = parseInt(Data.currpage || '1');
//         $.ajax({
//             type:'post',
//             url:url,
//             dataType:'json',
//             data:{
//                 'pagination.size':10,
//                 'pagination.currPage':currpage
//             },
//             error:function(XmlHttpRequest,textStatus,errorThrown){
//                 console.log(XmlHttpRequest.status);
//             },
//             success:function(data){
// 				console.log(data);
//                 var time='';
//                 var answer='';
//                 var total=parseInt(data.msg.total);
//                 var pages=parseInt(data.msg.pages);
//                 var ddata=data.msg.rows;
//                 console.log(total,pages,ddata);
//                 var str_a = ''; //用于创建分页a标签
//                 var str = '<tr>' +
//                     '<th width="35%">建议内容</th>' +
//                     '<th width="35%">回复情况</th>' +
//                     '<th width="15%">建议时间</th>' +
//                     '<th width="15%" colspan="2">操作</th>' +
//                     '</tr>';
//                 for(var i=0;i<ddata.length;i++){
//                     time=ddata[i].inserttime.slice(0,11);
//                     if(ddata[i].answer==undefined){
//                         answer='暂未回复';
//                     }else{
//                         answer=ddata[i].answer;
//                     }
//                     str+='<tr>'+
//                         '<td class="content">'+ddata[i].suggest+'</td>'+
//                         '<td class="hf">'+answer+'</td>'+
//                         '<td class="time">'+time+'</td>'+
//                         '<td><a class="out" href="javascript:void(0)" style="color: #969696;" onclick="delate('+ddata[i].id+')">删除</a></td>'+
//                         '</tr>'
//                 }
//                 $('.information table').html(str);
//                 if(pages>1){
//                     $('div.company_list_result_pages').show();
//                     $('.pagesN').html('');
//                     $('#allPage2').html(pages);
//                     if(pages<8){
//                         for(var i=0;i<pages;i++){
//                             str_a = '';
//                             str_a += '<a href="javascript:void(0)">'+(i+1)+'</a>';
//                             var newA = $(str_a);
//                             $('.pagesN').append(newA);
//                         }
//                     }else{
//                         if(currpage<5){
//                             for(var i=0;i<8;i++){
//                                 str_a = '';
//                                 str_a += '<a href="javascript:void(0)">'+(i+1)+'</a>';
//                                 var newA = $(str_a);
//                                 $('.pagesN').append(newA);
//                             }
//                         }else if(currpage>=5&&currpage<parseInt(pages)-3){
//                             for(var i=0;i<8;i++){
//                                 str_a = '';
//                                 str_a += '<a href="javascript:void(0)">'+(i+currpage-3)+'</a>';
//                                 var newA = $(str_a);
//                                 $('.pagesN').append(newA);
//                             }
//                         }else{
//                             for(var i=0;i<8;i++){
//                                 str_a = '';
//                                 str_a += '<a href="javascript:void(0)">'+(i+parseInt(pages)-7)+'</a>';
//                                 var newA = $(str_a);
//                                 $pagesN.append(newA);
//                             }
//                         }
//                     };
//                 }else{
//                     $('div.company_list_result_pages').hide();
//                 };
//                 $("#firstPage").off("click");
//                 $("span.pagesN a").off("click");
//                 $("#nextPage").off("click");
//                 $("#prevA").off("click");
//                 $("#nextA").off("click");
//                 $("#btn").off("click");
//                 $("#pages").off("keydown");
//                 pageJsFn(url);
//             }
//         })
//     }
//     /* 页标js */
//     function pageJsFn(url){
//         var $allPageV = parseInt($('#allPage2').html()),    //总页数
//             $pagesNA = $("span.pagesN a"),                 //页码标签
//             $nowPage2V = parseInt($("#nowPage2").html());//当前页
//         /* 当前页高亮显示 */
//         if($allPageV<=8){
//             $pagesNA.eq($nowPage2V-1).addClass("active").siblings().removeClass("active");
//         }else{
//             if($nowPage2V<5){
//                 $pagesNA.eq($nowPage2V-1).addClass("active").siblings().removeClass("active");
//             }else if($nowPage2V>=5&&$nowPage2V<$allPageV-3){
//                 $pagesNA.eq(3).addClass("active").siblings().removeClass("active");
//             }else{
//                 $pagesNA.eq(7-$allPageV+$nowPage2V).addClass("active").siblings().removeClass("active");
//             }
//         };
//         /* 点击跳到第一页 */
//         $("#firstPage").on('click',function(e){
//             stopDefault(e);
//             $nowPage2V = 1;
//             $('#nowPage2').html($nowPage2V);
//             oData.currpage = parseInt($nowPage2V);
//             ajaxFn(url,oData);
//         });
//         /* 点击页标a标签 */
//         $pagesNA.each(function(){
//             $(this).on('click',function(e){
//                 stopDefault(e);
//                 $nowPage2V = $(this).html();
//                 $('#nowPage2').html($nowPage2V);
//                 oData.currpage = parseInt($nowPage2V);
//                 ajaxFn(url,oData);
//             });
//         });
//         /* 点击跳到尾页 */
//         $("#nextPage").on('click',function(e){
//             stopDefault(e);
//             $nowPage2V = $allPageV;
//             $('#nowPage2').html($nowPage2V);
//             oData.currpage = parseInt($nowPage2V);
//             ajaxFn(url,oData);
//         });
//         /* 点击上一页、点击下一页 */
//         $("#prevA").click(prevFn);
//         $('#nextA').click(nextFn);
//         /* input输值跳转 */
//         $('#pages').on('keydown',function(e){
//             var e = e||event;
//             if(!((e.keyCode>=48&&e.keyCode<=57)||(e.keyCode>=96&&e.keyCode<=105)||(e.keyCode==9)||(e.keyCode==8)||(e.keyCode==116)||(e.keyCode==13)))stopDefault(e);//阻止默认事件，去掉move的时候选中文本;
//             if(e.keyCode==13)inputFn();
//         });
//         $('#btn').click(inputFn);
//         /* 上一页fn */
//         function prevFn(e){
//             stopDefault(e);
//             if($nowPage2V>1){
//                 $nowPage2V--;
//                 $('#nowPage2').html($nowPage2V);
//                 oData.currpage = $nowPage2V;
//                 ajaxFn(url,oData);
//             };
//         };
//         /* 下一页fn */
//         function nextFn(e){
//             stopDefault(e);
//             if($nowPage2V<$allPageV){
//                 $nowPage2V++;
//                 $('#nowPage2').html($nowPage2V);
//                 oData.currpage = $nowPage2V;
//                 ajaxFn(url,oData);
//             };
//         };
//         /* input跳转fn */
//         function inputFn(){
//             if(parseInt($("#pages").val())<2){
//                 $nowPage2V = 1;
//                 $('#nowPage2').html($nowPage2V);
//             }else if(parseInt($("#pages").val())>$allPageV-1){
//                 $nowPage2V = $allPageV;
//                 $('#nowPage2').html($nowPage2V);
//             }else{
//                 $nowPage2V = parseInt($("#pages").val());
//                 $('#nowPage2').html(parseInt($("#pages").val()));
//             };
//             $("#pages").val('');
//             oData.currpage = parseInt($nowPage2V);
//             ajaxFn(url,oData);
//         }
//     }
// });


// 删除
function delate(id){
    var r=confirm('确认删除？');
    if(r){
        $.ajax({
            type:'post',
            url:wqturl+'/delUserSuggest.action',
            dataType:'json',
            data:{
                'id':id
            },
            success:function (data) {
                if(data.result=='1'){
                    window.location.reload();
                }else if(data.result=='2'){
                    window.location.href = wqturl + "/casLogin?service=" + data.msg;
                }
            }
        })
    }
}