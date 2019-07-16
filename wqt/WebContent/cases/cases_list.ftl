<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=0.25">
    <title>售后回访列表页</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/cases/css/cases_list.css">
    <link rel="stylesheet" href="/templates/css/footer.css">
	<script>
        //百度推送
        (function(){
                var bp = document.createElement('script');
                var curProtocol = window.location.protocol.split(':')[0];
                if (curProtocol === 'https') {
                    bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
                }else {
                    bp.src = 'http://push.zhanzhang.baidu.com/push.js';
                }
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(bp, s);
        })();
        //百度统计
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?e97b0d63dc2f6999abf0ec6dc77b6596";
          var s = document.getElementsByTagName("script")[0];
          s.parentNode.insertBefore(hm, s);
        })();
    </script>
</head>
<body>
       <#assign allpage='1'>
       <#if wqtCasesList.casepage?exists>
             <#assign allpage=wqtCasesList.casepage?string>
      </#if>
      <#assign curpage='1'>
      <#if wqtCasesList.pagenum?exists>
             <#assign curpage=wqtCasesList.pagenum?string>
      </#if>
      <!--头部-->
      <#include "/templates/wqt_header.ftl">
    <!--导航栏-->
    <div class="center banner">
        当前位置：
        <a href="/">万企通企业服务网</a>
        >
        <a href="/cases/caseslist.html">案例列表</a>
    </div>
    <!--左边内容-->
    <div class="cf_content center clear">
        <div class="lf content_left">
            <ul>
                <#if wqtCasesList.l_WqtCases?exists>
	                  <#list wqtCasesList.l_WqtCases as rwqtCases>
                           <li>
			                    <div class="content_left_img lf">
			                      <a href="/${rwqtCases.htmlpath?if_exists}" target="_blank">
			                        <img src="${rwqtCases.caseimg?if_exists}" alt="" width="170" height="120">
			                      </a>
			                    </div>
			                    <div class="content_left_cont lf">
			                        <a class="title" href="/${rwqtCases.htmlpath?if_exists}" target="_blank">${rwqtCases.title?if_exists}</a>
			                        <p class="cont">${rwqtCases.beforetext?if_exists}</p>
			                        <a class="detail" href="/${rwqtCases.htmlpath?if_exists}" target="_blank">查看详情</a>
			                        <span class="qx">[&nbsp${rwqtCases.periodsnum?if_exists}&nbsp]</span>
			                    </div>
			                </li>            
					  </#list>
				</#if>
            </ul>
           <div class="company_list_result_pages  publicblock">
              <#if wqtCasesList.casepage?exists>
                <span class="backhome">
                    <a href="/cases/caseslist_${curpage}.html" id="firstPage">首页</a></span>
			    <span class="prevpage">
			        <#if curpage?number gt 1>
				        <a href="/cases/caseslist_${wqtCasesList.pagenum?number-1}.html" id="prevA">上一页</a>
					<#else>
					    <a href="javaScript:void(0);" id="prevA">上一页</a>
					</#if>
			    </span>
			    <span class="pagesN">
			         <#if wqtCasesList.casepage?exists>
					   	  <#if (wqtCasesList.casepage?number gt curpage?number)  && (curpage?number gt 8) && (curpage?number+4 lt wqtCasesList.casepage?number)>
					   	     <#list curpage?number-4..curpage?number+4 as t>
					   	         <#if t_index?number=='5'?number-1>
					   	            <a href="/cases/caseslist_${t}.html" class="active">${t}</a>
					   	         <#else>
					   	            <a href="/cases/caseslist_${t}.html" >${t}</a>
					   	         </#if>
					   	     </#list>
					   	  <#elseif (wqtCasesList.casepage?number gt curpage?number)  && (curpage?number gt 8) && (curpage?number+4 gte wqtCasesList.casepage?number)>
					   	      <#list curpage?number-4..wqtCasesList.casepage?number as t>
					   	         <#if t_index?number=='5'?number-1>
					   	           <a href="/cases/caseslist_${t}.html" class="active">${t}</a>
					   	         <#else>
					   	            <a href="/cases/caseslist_${t}.html" >${t}</a>
					   	         </#if>
					   	     </#list>
					   	  <#else>
					   	      <#if wqtCasesList.casepage?number gt 8>
					   	          <#list 1..8 as t>
						   	         <#if t_index?number==curpage?number-1>
						   	             <a href="/cases/caseslist_${t}.html"  class="active">${t}</a>
			                         <#else>
			                            <a href="/cases/caseslist_${t}.html">${t}</a>
			                         </#if>
						   	      </#list>
						   	  <#else>
						   	      <#list 1..wqtCasesList.casepage?number as t>
						   	         <#if t_index?number==curpage?number-1>
						   	            <a href="/cases/caseslist_${t}.html"  class="active">${t}</a>
			                         <#else>
			                            <a href="/cases/caseslist_${t}.html">${t}</a>
			                         </#if>
						   	      </#list>
						   	  </#if>
					   	  </#if>
					   	</#if>
			    </span>
			    <span class="nextpage">
			        <#if wqtCasesList.casepage?exists>
				   	    <#if wqtCasesList.casepage?number gt curpage?number>
				   	      <a href="/cases/caseslist_${curpage?number+1}.html" id="nextA">下一页</a>
				   	    <#else>
				   	       <a href="javascript:void(0)" id="nextA">下一页</a>
				   	    </#if>
			   	   <#else>
			   	    <a href="javascript:void(0)" id="nextA">下一页</a>
			       </#if>
			    </span>
			    <span class="lastpage">
			                 <a href="/cases/caseslist_${allpage}.html" id="nextPage">尾页</a>
			    </span>
			    <span class="total">
			                    共<span id="allPage2">${wqtCasesList.casepage?if_exists}</span>页/当前为第
			                    <strong id="nowPage2">${wqtCasesList.casepage?if_exists}</strong>
			                    页
			     </span>
			  
              </#if>
            </div>
        </div>
		<div class="content_right rt">
            <a href="/shop/brandshop.html" target="_black"><img src="/cases/image/cases_list/brand_shop.jpg" width="300" height="200" alt=""></a>
            <a href="/copyrightmark/copyright.html" target="_black"><img src="/cases/image/cases_list/copyright_shop.jpg" width="300" height="200" alt=""></a>
            <a href="/patentmark/patent.html" target="_black"><img src="/cases/image/cases_list/patent_shop.jpg" width="300" height="200" alt=""></a>
        </div>
    </div>
    <!--底部-->
    <#include "/templates/footer.ftl">
</body>
<script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
</html>