<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<#if wqtNewsListData.kindid=='1'>
        <title>企业服务资讯_工商注册资讯_代理记账资讯_财税服务资讯_万企通</title>
		<meta name="keywords" content="工商注册资讯，企业服务资讯，代理记账资讯，财税服务资讯">
		<meta name="Description" content="万企通企业服务网掌握最新的企业服务资讯,提供最实用的工商注册资讯、代理记账资讯、财税服务资讯、财经要闻,了解最新业内热点财税资讯到万企通财税。">
    <#elseif wqtNewsListData.kindid=='2'>
		<title>知识产权资讯_商标交易资讯_专利资讯_版权资讯_万企通</title>
		<meta name="keywords" content="知识产权资讯，商标资讯，专利资讯，版权资讯">
		<meta name="Description" content="万企通知识产权资讯频道为您提供商标转让资讯、专利转让资讯、版权登记资讯等,为您推荐知识产权相关专业的新闻资讯。">
	<#elseif wqtNewsListData.kindid=='3'>
		<title>成功案例_企业服务成功案例_知识产权成功案例_万企通</title>
		<meta name="keywords" content="成功案例，企业服务成功案例，知识产权成功案例">
		<meta name="Description" content="万企通知识产权资讯频道为您提供商标转让资讯、专利转让资讯、版权登记资讯等,为您推荐知识产权相关专业的新闻资讯。">
	<#elseif wqtNewsListData.kindid=='4'>
		<title>平台公告_万企通</title>
		<meta name="keywords" content="平台公告，万企通">
		<meta name="Description" content="万企通知识产权资讯频道为您提供商标转让资讯、专利转让资讯、版权登记资讯等,为您推荐知识产权相关专业的新闻资讯。">
    </#if>
    <meta name="keywords" content="${wqtNewsListData.mkeyword?if_exists}">
    <meta name="Description" content="${wqtNewsListData.mdesc?if_exists}">
	<meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/news/css/news.css">
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
<!--header-->
<#include "/templates/wqt_header.ftl">


<div class="content">
    <div class="banner">
        <div class="lf scroll_box" style="overflow:hidden; position:relative; width:890px">
            <ul style="width: 3560px; left: 0px; position: relative; overflow: hidden; padding: 0px; margin: 0px;">
                <li style="float: left; width: 890px;">
                    <a href="http://ipr.w7tong.com/shop/brandshop.html"><img src="/news/image/banner_bg01.png" alt=""></a>
                </li>
                <li style="float: left; width: 890px;">
                    <a href="http://ipr.w7tong.com/patent/sysq.html"><img src="/news/image/banner_bg02.png" alt=""></a>
                </li>
            </ul>
            <ol>
                <li class="hover"></li>
                <li></li>
            </ol>
        </div>

        <div class="rtr latest_list">
            <div>
                <p>最新资讯</p>
            </div>
            <ul>
                <#if wqtNewsListData.l_hotNews?exists && wqtNewsListData.l_hotNews?size gt 5>
                      <#list 0..5 as hotNewsindex>
                          <li><a href="/${ wqtNewsListData.l_hotNews[hotNewsindex].htmlpath?if_exists}" title="${ wqtNewsListData.l_hotNews[hotNewsindex].title}">
                              <#if wqtNewsListData.l_hotNews[hotNewsindex].title?length gt 15>
                                 ${ wqtNewsListData.l_hotNews[hotNewsindex].title?substring(0,15)}...
                              <#else>
                                  ${ wqtNewsListData.l_hotNews[hotNewsindex].title}
                              </#if>
                          </a></li>
                      </#list>
                <#elseif wqtNewsListData.l_hotNews?exists && wqtNewsListData.l_hotNews?size lte 5> 
                       <#list wqtNewsListData.l_hotNews as hotNews>
                           <li><a href="/${hotNews.htmlpath?if_exists}" title="${hotNews.title}">
                              <#if hotNews.title?length gt 15>
                                 ${hotNews.title?substring(0,15)}...
                              <#else>
                                  ${hotNews.title}
                              </#if>
                          </a></li>
                       </#list>
                </#if>
            </ul>
        </div>
    </div>

    <div class="content_bt clear">
        <div class="lf clear">
            <ul class="theme_list clear">
               <#if wqtNewsListData.kindid=='1'>
                  <li  class="active"><a href="/news/1_${wqtNewsListData.labelid?if_exists}/1.html">企业服务</a></li>
               <#else>
                  <li ><a href="/news/1_${wqtNewsListData.labelid?if_exists}/1.html">企业服务</a></li>
               </#if>
               
                <#if wqtNewsListData.kindid?number==2>
                  <li  class="active"><a href="/news/2_${wqtNewsListData.labelid?if_exists}/1.html">知识产权</a></li>
               <#else>
                  <li><a href="/news/2_${wqtNewsListData.labelid?if_exists}/1.html">知识产权</a></li>
               </#if>
               
               <#if wqtNewsListData.kindid?number==3>
				<li  class="active"><a href="/news/3_${wqtNewsListData.labelid?if_exists}/1.html">成功案例</a></li>
				<#else>
					<li ><a href="/news/3_${wqtNewsListData.labelid?if_exists}/1.html">成功案例</a></li>
				</#if>       
				
			   <#if wqtNewsListData.kindid?number==4>
			   <li  class="active"><a href="/news/4_${wqtNewsListData.labelid?if_exists}/1.html">平台公告</a></li>
               <#else>
                  <li ><a href="/news/4_${wqtNewsListData.labelid?if_exists}/1.html">平台公告</a></li>
               </#if>
			   
			   <div class='bot_fw'>
					<span>其他资讯</span>
					<div class='bbt'>
						<ul>
							<li><a href='http://www.w7tong.com/news/news.html' target='_blant'>万企通资讯</a></li>
							<li><a href='http://ipr.w7tong.com/news/news.html' target='_blant'>知识产权资讯</a></li>
							<li><a href='http://es.w7tong.com/news/newslist.html' target='_blant'>企业服务资讯</a></li>
							<li><a href='http://wd.w7tong.com/news/newslist.html' target='_black'>网店转让资讯</a></li>
						</ul>
					</div>
			   </div>
                
            </ul>

            <div class="content_box">
                <div class="news_list dynamic">
                    <#if wqtNewsListData.kindid?number==1 || wqtNewsListData.kindid?number==2>
		                 <#if wqtNewsListData.l_News?exists>
		                     <#list wqtNewsListData.l_News as hotNews>
				                    <div class="news_detail clear">
				                        <div class="title">
				                            <a href="/${hotNews.htmlpath?if_exists}" target="_blank">${hotNews.title?if_exists}</a>
				                        </div>
				                        <dl>
				                            <dt>
				                                <a target="_blank" href="/${hotNews.htmlpath?if_exists}"><img src="${hotNews.newicon?if_exists}" alt=""></a>
				                            </dt>
				                            <dd>
				                                <p><a target="_blank" href="/${hotNews.htmlpath?if_exists}">
				                                  ${hotNews.hits?if_exists}
				                                </a></p>
				                                <ul>
				                                    <li class="time"><i></i><span>${hotNews.developtime?if_exists?string('yyyy-MM-dd')}</span></li>
				                                   <!-- <li class="browse"><i></i><span>248</span></li>
				                                    <li class="message"><i></i><span>0</span></li>-->
				                                </ul>
												<div class='biq'>标签：
												 <#if hotNews.l_NewsLabel?exists>
		                                               <#list hotNews.l_NewsLabel as newsLabel>
		                                                    <span>
		                                                        <a href="${newsLabel.url?if_exists}" target="_black">${newsLabel.labelname?if_exists}</a>
		                                                   </span>
		                                               </#list>
		                                          </#if>
												</div>
				                            </dd>
				                        </dl>
				                    </div>
		                       </#list>
		                   </#if>
		                   <div class="trademark-list-page">
		                      <#if wqtNewsListData.newspage gte 1>
			                    <span class="first_page">
			                        <#if wqtNewsListData.newspage gt 1 && wqtNewsListData.pagenum gt 1>
				                         <a id="firstPage" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/1.html">首页</a>
				                    </#if>
			                    </span>
			                    <span class="prev">
			                    	<#if wqtNewsListData.newspage gt 1 && wqtNewsListData.pagenum gt 1>
			                             <a id="prevA" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${wqtNewsListData.pagenum?number-1}.html">上一页</a>
			                        </#if>
			                    </span>
			                    <span class="page_list">
			                        <#if wqtNewsListData.newspage?exists>
			                          <#if (wqtNewsListData.newspage gt wqtNewsListData.pagenum)  && (wqtNewsListData.pagenum gt 8) && (wqtNewsListData.pagenum+4 lt wqtNewsListData.newspage)>
			                                <#list wqtNewsListData.pagenum-4..wqtNewsListData.pagenum+4 as t>
									   	         <#if t_index?number=='5'?number-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" class="active">${t}</a>
									   	         <#else>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" >${t}</a>
									   	         </#if>
									   	     </#list>
			                          <#elseif (wqtNewsListData.newspage gt wqtNewsListData.pagenum)  && (wqtNewsListData.pagenum gt 8) && (wqtNewsListData.pagenum+4 gte wqtNewsListData.newspage)>
			                                <#list wqtNewsListData.pagenum-4..wqtNewsListData.newspage as t>
									   	         <#if t_index?number=='5'?number-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" class="active">${t}</a>
									   	         <#else>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" >${t}</a>
									   	         </#if>
									   	    </#list>
			                          <#elseif (wqtNewsListData.pagenum==wqtNewsListData.newspage)>
			                                <#if wqtNewsListData.newspage gt 8>
								   	          <#list (wqtNewsListData.pagenum-7)..wqtNewsListData.pagenum as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	   <#else>
									   	      <#list 1..wqtNewsListData.newspage as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	  </#if>
			                          <#else>
			                              <#if wqtNewsListData.newspage gt 8>
								   	          <#list 1..8 as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	  <#else>
									   	      <#list 1..wqtNewsListData.newspage as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	  </#if>
			                          </#if>
			                       </#if> 
			                    </span>
			                    <span class="next">
			                        <#if wqtNewsListData.pagenum lte wqtNewsListData.newspage-1>
			                            <a id="nextA" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${wqtNewsListData.pagenum+1}.html">下一页</a>
						            </#if>
			                    </span>
			                    <span class="last_page">
			                        <#if wqtNewsListData.pagenum lte wqtNewsListData.newspage-1>
			                           <a id="nextPage" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${wqtNewsListData.newspage}.html">尾页</a>
			                        </#if>
			                    </span>
			                    <span class="first_page">
			                                                                        共<i id="page_count">${wqtNewsListData.newspage}</i>页/当前第
			                         <i id="current_page">
			                              ${wqtNewsListData.pagenum}
			                         </i>页&nbsp;
			                    </span>
			                 </#if>    
		                   </div>
			             </#if>
			             
			            <#if wqtNewsListData.kindid?number==4>
		                 <#if wqtNewsListData.l_Notice?exists>
		                     <#list wqtNewsListData.l_Notice as notice>
				                    <div class="news_detail clear">
				                        <div class="title">
				                            <a href="/${notice.htmlpath?if_exists}" target="_blank">${notice.title?if_exists}</a>
				                        </div>
				                        <dl>
				                            <dt>
				                                <a href="/${notice.htmlpath?if_exists}" target="_blank"><img src="${notice.noticeicon?if_exists}" alt=""></a>
				                            </dt>
				                            <dd>
				                                <p><a href="/${notice.htmlpath?if_exists}" target="_blank">
				                                  ${notice.hits?if_exists}
				                                </a></p>
				                                <ul>
				                                    <li class="time"><i></i><span>${notice.developtime?if_exists?string('yyyy-MM-dd')}</span></li>
				                                   <!-- <li class="browse"><i></i><span>248</span></li>
				                                    <li class="message"><i></i><span>0</span></li>-->
				                                </ul>
												<div class='biq'>
												</div>
				                            </dd>
				                        </dl>
				                    </div>
		                       </#list>
		                   </#if>
		                   <div class="trademark-list-page">
		                      <#if wqtNewsListData.noticepage gte 1>
			                    <span class="first_page">
			                        <#if wqtNewsListData.noticepage gt 1 && wqtNewsListData.pagenum gt 1>
				                         <a id="firstPage" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/1.html">首页</a>
				                    </#if>
			                    </span>
			                    <span class="prev">
			                    	<#if wqtNewsListData.noticepage gt 1 && wqtNewsListData.pagenum gt 1>
			                             <a id="prevA" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${wqtNewsListData.pagenum?number-1}.html">上一页</a>
			                        </#if>
			                    </span>
			                    <span class="page_list">
			                        <#if wqtNewsListData.noticepage?exists>
			                          <#if (wqtNewsListData.noticepage gt wqtNewsListData.pagenum)  && (wqtNewsListData.pagenum gt 8) && (wqtNewsListData.pagenum+4 lt wqtNewsListData.noticepage)>
			                                <#list wqtNewsListData.pagenum-4..wqtNewsListData.pagenum+4 as t>
									   	         <#if t_index?number=='5'?number-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" class="active">${t}</a>
									   	         <#else>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" >${t}</a>
									   	         </#if>
									   	     </#list>
			                          <#elseif (wqtNewsListData.noticepage gt wqtNewsListData.pagenum)  && (wqtNewsListData.pagenum gt 8) && (wqtNewsListData.pagenum+4 gte wqtNewsListData.noticepage)>
			                                <#list wqtNewsListData.pagenum-4..wqtNewsListData.noticepage as t>
									   	         <#if t_index?number=='5'?number-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" class="active">${t}</a>
									   	         <#else>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" >${t}</a>
									   	         </#if>
									   	    </#list>
			                          <#elseif (wqtNewsListData.pagenum==wqtNewsListData.noticepage)>
			                                <#if wqtNewsListData.noticepage gt 8>
								   	          <#list (wqtNewsListData.pagenum-7)..wqtNewsListData.pagenum as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	   <#else>
									   	      <#list 1..wqtNewsListData.noticepage as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	  </#if>
			                          <#else>
			                              <#if wqtNewsListData.noticepage gt 8>
								   	          <#list 1..8 as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	  <#else>
									   	      <#list 1..wqtNewsListData.noticepage as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	  </#if>
			                          </#if>
			                       </#if> 
			                    </span>
			                    <span class="next">
			                        <#if wqtNewsListData.pagenum lte wqtNewsListData.noticepage-1>
			                            <a id="nextA" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${wqtNewsListData.pagenum+1}.html">下一页</a>
						            </#if>
			                    </span>
			                    <span class="last_page">
			                        <#if wqtNewsListData.pagenum lte wqtNewsListData.noticepage-1>
			                           <a id="nextPage" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${wqtNewsListData.noticepage}.html">尾页</a>
			                        </#if>
			                    </span>
			                    <span class="first_page">
			                                                                        共<i id="page_count">${wqtNewsListData.noticepage}</i>页/当前第
			                         <i id="current_page">
			                              ${wqtNewsListData.pagenum}
			                         </i>页&nbsp;
			                    </span>
			                 </#if>    
		                   </div>
			             </#if>
			             
			            <#if wqtNewsListData.kindid?number==3>
		                 <#if wqtNewsListData.l_cases?exists>
		                     <#list wqtNewsListData.l_cases as cases>
				                    <div class="news_detail clear">
				                        <div class="title">
				                            <a href="/${cases.htmlpath?if_exists}" target="_blank">${cases.title?if_exists}</a>
				                        </div>
				                        <dl>
				                            <dt>
				                                <a href="/${cases.htmlpath?if_exists}" target="_blank"><img src="${cases.caseimg?if_exists}" alt=""></a>
				                            </dt>
				                            <dd>
				                                <p><a href="/${cases.htmlpath?if_exists}" target="_blank">
				                                  ${cases.beforetext?if_exists}
				                                </a></p>
				                                <ul>
				                                    <li class="time"><i></i><span>${cases.createtime?if_exists?date('yyyy-MM-dd')}</span></li>
				                                   <!-- <li class="browse"><i></i><span>248</span></li>
				                                    <li class="message"><i></i><span>0</span></li>-->
				                                </ul>
												<div class='biq'>标签：
												    万企通
												</div>
				                            </dd>
				                        </dl>
				                    </div>
		                       </#list>
		                   </#if>
		                   <div class="trademark-list-page">
		                      <#if wqtNewsListData.casepage gte 1>
			                    <span class="first_page">
			                        <#if wqtNewsListData.casepage gt 1 && wqtNewsListData.pagenum gt 1>
				                         <a id="firstPage" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/1.html">首页</a>
				                    </#if>
			                    </span>
			                    <span class="prev">
			                    	<#if wqtNewsListData.casepage gt 1 && wqtNewsListData.pagenum gt 1>
			                             <a id="prevA" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${wqtNewsListData.pagenum?number-1}.html">上一页</a>
			                        </#if>
			                    </span>
			                    <span class="page_list">
			                        <#if wqtNewsListData.casepage?exists>
			                          <#if (wqtNewsListData.casepage gt wqtNewsListData.pagenum)  && (wqtNewsListData.pagenum gt 8) && (wqtNewsListData.pagenum+4 lt wqtNewsListData.casepage)>
			                                <#list wqtNewsListData.pagenum-4..wqtNewsListData.pagenum+4 as t>
									   	         <#if t_index?number=='5'?number-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" class="active">${t}</a>
									   	         <#else>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" >${t}</a>
									   	         </#if>
									   	     </#list>
			                          <#elseif (wqtNewsListData.casepage gt wqtNewsListData.pagenum)  && (wqtNewsListData.pagenum gt 8) && (wqtNewsListData.pagenum+4 gte wqtNewsListData.casepage)>
			                                <#list wqtNewsListData.pagenum-4..wqtNewsListData.casepage as t>
									   	         <#if t_index?number=='5'?number-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" class="active">${t}</a>
									   	         <#else>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html" >${t}</a>
									   	         </#if>
									   	    </#list>
			                          <#elseif (wqtNewsListData.pagenum==wqtNewsListData.casepage)>
			                                <#if wqtNewsListData.casepage gt 8>
								   	          <#list (wqtNewsListData.pagenum-7)..wqtNewsListData.pagenum as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	   <#else>
									   	      <#list 1..wqtNewsListData.casepage as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	  </#if>
			                          <#else>
			                              <#if wqtNewsListData.casepage gt 8>
								   	          <#list 1..8 as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	  <#else>
									   	      <#list 1..wqtNewsListData.casepage as t>
									   	         <#if t_index?number==wqtNewsListData.pagenum-1>
									   	            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html"  class="active">${t}</a>
						                         <#else>
						                            <a href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${t}.html">${t}</a>
						                         </#if>
									   	      </#list>
									   	  </#if>
			                          </#if>
			                       </#if> 
			                    </span>
			                    <span class="next">
			                        <#if wqtNewsListData.pagenum lte wqtNewsListData.casepage-1>
			                            <a id="nextA" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${wqtNewsListData.pagenum+1}.html">下一页</a>
						            </#if>
			                    </span>
			                    <span class="last_page">
			                        <#if wqtNewsListData.pagenum lte wqtNewsListData.casepage-1>
			                           <a id="nextPage" href="/news/${wqtNewsListData.kindid?if_exists}_${wqtNewsListData.labelid?if_exists}/${wqtNewsListData.casepage}.html">尾页</a>
			                        </#if>
			                    </span>
			                    <span class="first_page">
			                                                                        共<i id="page_count">${wqtNewsListData.casepage}</i>页/当前第
			                         <i id="current_page">
			                              ${wqtNewsListData.pagenum}
			                         </i>页&nbsp;
			                    </span>
			                 </#if>    
		                   </div>
			             </#if>
                </div>
            </div>


        </div>

        <div class="rt">

            <div class="recommend_list">
                <div class="r_title"><p></p></div>

                <ul>
                    <li><a href="http://ipr.w7tong.com/patentmark/patent.html"><img src="/news/image/re01.png" alt=""></a></li>

                    <li><a href="http://ipr.w7tong.com/brandseek.html"><img src="/news/image/re02.png" alt=""></a></li>

                    <li><a href="http://es.w7tong.com/gsfw/gszc1.html"><img src="/news/image/re03.png" alt=""></a></li>
                </ul>
            </div>
            <div class="newt">
                    <div class="newt_titl">今日新品<a href="http://ipr.w7tong.com/shop/brandshop.html">更多<span>></span></a></a></div>
                    <div class="newt_list">
                        <ul>
                          <#if wqtNewsListData.l_IprBrandShop?exists>
			                  <#list wqtNewsListData.l_IprBrandShop as iprBrandShop>
		                            <li class="clear">
		                                <a href="http://ipr.w7tong.com/${iprBrandShop.htmlpath?if_exists}" class="img" target="_blank"><img src="${iprBrandShop.brandshopphoto?if_exists}" alt=""></a>
		                                <div class="list_content">
		                                    <h2>${iprBrandShop.brandname?if_exists}</h2>
		                                    <p>类别：第${iprBrandShop.brandkind?substring(0,2)}类-${iprBrandShop.kindname?if_exists}</p>
		                                    <p>售价：<span>￥${iprBrandShop.price?if_exists}元</span></p>
		                                    <a href="http://ipr.w7tong.com/${iprBrandShop.htmlpath?if_exists}" class="btn_buy" target="_blank">立即购买</a>
		                                </div>
		                            </li>
                              </#list>
			                </#if>
                        </ul>
                    </div>
                </div>
        </div>
    </div>
</div>
<!--footer-->
    <#include "/templates/footer.ftl">


<script src="https://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/news/js/news.js"></script>
</body>
</html>