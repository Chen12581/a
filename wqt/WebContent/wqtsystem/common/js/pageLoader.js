
var MaskUtil = (function(){  
      
    var $mask,$maskMsg;  
      
    var defMsg = '正在加载，请等待....';  
      
    function init(){  
        if(!$mask){  
            $mask = $("<div class=\"datagrid-mask mymask\"></div>").appendTo("body");  
        }  
        if(!$maskMsg){  
            $maskMsg = $("<div class=\"datagrid-mask-msg mymask\">"+defMsg+"</div>")  
                .appendTo("body").css({'font-size':'12px'});  
        }  
          
        $mask.css({width:"100%",height:$(document).height()});  
          
        var scrollTop = $(document.body).scrollTop();  
          
        $maskMsg.css({  
            left:( $(document.body).outerWidth(true) - 190 ) / 2  
            ,top:( ($(window).height() - 45) / 2 ) + scrollTop  
        });   
                  
    }  
      
    return {  
        mask:function(msg){  
            init();  
            $mask.show();  
            $maskMsg.html(msg||defMsg).show();  
        }  
        ,unmask:function(){  
            $mask.hide();  
            $maskMsg.hide();  
        }  
    }  
      
}());  

MaskUtil.mask();  
window.onload = function(){  
	MaskUtil.unmask();  
}  


/*var height = window.screen.height-250;  
var width = window.screen.width;  
var leftW = 300;  
if(width>1200){  
    leftW = 500;  
}
else if(width>1000){  
    leftW = 350;  
}
else {  
    leftW = 100;  
}  
   
 var _html = "<div id='loading' style='position:absolute;left:0;width:100%;height:" + height + "px;top:0;background:#E0ECFF;opacity:0.8;filter:alpha(opacity=80);'>"  
                +"<div style='position:absolute; cursor1:wait;left:"+leftW+"px;top:200px;width:auto;height:16px; padding:10px 5px 10px 30px;"
                       +"font-size:12px;;background:#fff url(../../support/easyui/themes/default/images/loading.gif) no-repeat scroll 5px 10px;border:2px solid #ccc;color:#000;'>"
          +"正在加载，请等待...</div></div>";  
   
 window.onload = function(){  
    var _mask = document.getElementById('loading');  
    
    //setTimeout("alert('5 seconds!')",5000);
    
    //_mask.parentNode.removeChild(_mask);  
 }  
  
       
 document.write(_html);  */