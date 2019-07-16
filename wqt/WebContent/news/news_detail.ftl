<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=0.25,maximum-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <meta name='keywords' content='${wqtnews.title?if_exists}'>
    <meta name='Description' content='${wqtnews.title?if_exists}'>
    <title>${wqtnews.title?if_exists}</title>
    <link rel="shortcut icon " type="images/x-icon" href="/image/logo.ico">
    <link rel="stylesheet" href="/templates/css/wqt_header.css">
    <link rel="stylesheet" href="/news/css/news_detail.css">
    <link rel="stylesheet" href="/news/css/sliding.css">
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

<!--banner-->
<div class="banner center">
    <p style='white-space: nowrap;'>
        <i></i>
        我的位置：
        <a href="http://www.w7tong.com" target="_blank">首页</a>
		>
		<a href="http://www.w7tong.com/news/news.html" target="_blank">万企通资讯</a>
		>
		  <#if wqtnews.kindkey=='ipr'>
		      <a href="http://www.w7tong.com/news/2_0/1.html">知识产权</a>
		  <#elseif  wqtnews.kindkey=='es'>
		      <a href="http://www.w7tong.com/news/1_0/1.html">企业服务</a>
		  <#elseif  wqtnews.kindkey=='ptgg'>
		      <a href="http://www.w7tong.com/news/4_0/1.html">平台公告</a>
		  <#else>
		      <a href="http://www.w7tong.com/news/3_0/1.html">成功案例</a>
		  </#if>
        >
        <a href="/${wqtnews.htmlpath?if_exists}">${wqtnews.title?if_exists}</a>

    </p>
</div>

<!--内容-->
<div class="news_det center">
    <div class="lf news_lf">
        <div class="txt">
            <div class="txt_title">
                <h1>${wqtnews.title?if_exists}</h1>
                <p class="p1">发布者：<span>万企通</span></p>
                <div class="time">
                    <p class="time_day">
                    </p>
                    <p class="time_year">
                          发布于：${wqtnews.developtime?string('yyyy-MM-dd hh:mm:ss')}
                    </p>
                    <i></i>
                </div>
            </div>

            <div class="txt_cont">
                 ${wqtnews.content?if_exists}
            </div>

            <div class="tet_footer">
                <div class="bq lf">
                    标签：                                        
                      <#if wqtnews.l_NewsLabel?exists>
                           <#list wqtnews.l_NewsLabel as newsLabel>
                               <a href="${newsLabel.url?if_exists}" target="_black">${newsLabel.labelname?if_exists}</a>
                           </#list>
                      </#if>
                </div>
                <div class="cang_share rt" id="share">
                    <div class="share bdsharebuttonbox bdshare-button-style0-16">
                        <a href="javascript:;" class="bds_more" data-cmd="more">分享</a>
                    </div>
                </div>
            </div>

            <!--上下篇-->
            <div class="ff">
                <ul class="clearfix">
                    <li class="lf">
                      <#if wqtnews.preWqtNews?exists>
                        <a href="/${wqtnews.preWqtNews.htmlpath?if_exists}" title="${wqtnews.preWqtNews.title?if_exists}">
                            <i class="i1"></i>
                            上一篇：
                            <span>${wqtnews.preWqtNews.title?if_exists}</span>
                        </a>
                         </#if>
                    </li>
                    <li class="rt">
                      <#if wqtnews.nextWqtNews?exists>
                        <a href="/${wqtnews.nextWqtNews.htmlpath?if_exists}" title="${wqtnews.nextWqtNews.title?if_exists}">
                            <i class="i2"></i>
                            下一篇：
                            <span>${wqtnews.nextWqtNews.title?if_exists}</span>
                        </a>
                      </#if>
                    </li>
                </ul>
            </div>

            <!--相关推荐-->
            <div class="tt clearfix">
                <p class="tt_title lf">
                    <i></i>
                    相关推荐
                </p>
                <ul class="lf">
                    <#if wqtnews.l_news?exists && wqtnews.l_news?size gt 3>
                        <#list 0..2 as wqtindex >
                            <li>
                             <a href="/${wqtnews.l_news[wqtindex].htmlpath?if_exists}" title="${wqtnews.l_news[wqtindex].title?if_exists}"> ${wqtnews.l_news[wqtindex].title?if_exists}</a>
			   				</li>
                        </#list>
                    </#if>
                </ul>
                <ul class="lf">
                    <#if wqtnews.l_news?exists && wqtnews.l_news?size gte 6>
                        <#list 3..5 as wqtindex>
                               <li><a href="/${wqtnews.l_news[wqtindex].htmlpath?if_exists}" title="${wqtnews.l_news[wqtindex].title?if_exists}"> ${wqtnews.l_news[wqtindex].title?if_exists}</a></li>
                        </#list>
                    </#if>
                </ul>
            </div>


            <div class="news_comments" id="comments">
                <h3>评论列表(${wqtnews.title?if_exists})</h3>
                <ul>
                  <#if wqtnews.l_NewsComment?exists>
                     <#assign rootlist=wqtnews.l_NewsComment/>
                     <#list rootlist as root>
		                    <li class="comments-item firth-hf">
		                        <div class="comments-item-bd">
		                            <div class="single-reply">
		                                <div class="ui-avatar lf">
		                                   <#if root.userid?exists && root.userid!=0>
			                                    <a href="javascript:;">
			                                        <img src="http://pic.w7tong.com/avatar/wqt.png" alt="" class="avatar">
			                                    </a>
			                               <#else>
			                                     <a href="javascript:;">
			                                        <img src="http://pic.w7tong.com/avatar/niming.png" alt="" class="avatar">
			                                    </a>
			                               </#if>
		                                </div>
		                                <div class="comments-content">
		                                    <a href="javascript:;" class="comments-name">${root.username?if_exists}</a>
		                                    <span class="hf-time">${root.commenttime?if_exists?string('yyyy-MM-dd hh:mm:ss')} <a href="javascript:;" class="xx_fh" data_id="${root.id?if_exists}">回复该评论</a></span>
		                                    <div class="msgarticle">
		                                        ${root.newscomment?if_exists}
		                                    </div>
		                                </div>
		                            </div>
		                            <!--二级回复-->
		                            <#if root.children?exists>
		                              <#assign rootlist=root.children/>
		                              <div class="comments-list">
		                                 <ul>
		                                   <#include "children.ftl">
		                                 </ul>
		                              </div>
		                            </#if>
		                        </div>
		                    </li>
                        </#list>
                    </#if>
                </ul>
                <!--页标-->
                <div class="trademark-list-page">
                 <#if wqtnews.commentpage gte 1>
                    <span class="first_page">
                        <#if wqtnews.commentpage gt 1 && wqtnews.commentnum gt 1>
	                         <a href="/news/${wqtnews.id?if_exists}.html">首页</a>
	                    </#if>
                    </span>
                    <span class="prev">
                    	<#if wqtnews.commentpage gt 1 && wqtnews.commentnum gt 1>
                             <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${wqtnews.commentnum?number-1}">上一页</a>
                        </#if>
                    </span>
                    <span class="page_list">
                        <#if wqtnews.commentpage?exists>
                          <#if (wqtnews.commentpage gt wqtnews.commentnum)  && (wqtnews.commentnum gt 8) && (wqtnews.commentnum+4 lt wqtnews.commentpage)>
                                <#list wqtnews.commentnum-4..wqtnews.commentnum+4 as t>
						   	         <#if t_index?number=='5'?number-1>
						   	            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}" class="active">${t}</a>
						   	         <#else>
						   	            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}" >${t}</a>
						   	         </#if>
						   	     </#list>
                          <#elseif (wqtnews.commentpage gt wqtnews.commentnum)  && (wqtnews.commentnum gt 8) && (wqtnews.commentnum+4 gte wqtnews.commentpage)>
                                <#list wqtnews.commentnum-4..wqtnews.commentpage as t>
						   	         <#if t_index?number=='5'?number-1>
						   	            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}" class="active">${t}</a>
						   	         <#else>
						   	            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}" >${t}</a>
						   	         </#if>
						   	    </#list>
                          <#elseif (wqtnews.commentnum==wqtnews.commentpage)>
                                <#if wqtnews.commentpage gt 8>
					   	          <#list (wqtnews.commentnum-7)..wqtnews.commentnum as t>
						   	         <#if t_index?number==wqtnews.commentnum-1>
			                            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}"  class="active">${t}</a>
			                         <#else>
			                            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}">${t}</a>
			                         </#if>
						   	      </#list>
						   	   <#else>
						   	      <#list 1..wqtnews.commentpage as t>
						   	         <#if t_index?number==wqtnews.commentnum-1>
						   	            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}"  class="active">${t}</a>
			                         <#else>
			                            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}">${t}</a>
			                         </#if>
						   	      </#list>
						   	  </#if>
                          <#else>
                              <#if wqtnews.commentpage gt 8>
					   	          <#list 1..8 as t>
						   	         <#if t_index?number==wqtnews.commentnum-1>
			                            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}"  class="active">${t}</a>
			                         <#else>
			                            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}">${t}</a>
			                         </#if>
						   	      </#list>
						   	  <#else>
						   	      <#list 1..wqtnews.commentpage as t>
						   	         <#if t_index?number==wqtnews.commentnum-1>
						   	            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}"  class="active">${t}</a>
			                         <#else>
			                            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${t}">${t}</a>
			                         </#if>
						   	      </#list>
						   	  </#if>
                          </#if>
                       </#if>
                    </span>
                    <span class="next">
                        <#if wqtnews.commentnum lte wqtnews.commentpage-1>
                            <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${wqtnews.commentnum+1}">下一页</a>
			            </#if>
                    </span>
                    <span class="last_page">
                        <#if wqtnews.commentnum lte wqtnews.commentpage-1>
                           <a href="/news/${wqtnews.id?if_exists}.html?commentpagenum=${wqtnews.commentpage}">尾页</a>
                        </#if>
                    </span>
                    <span class="first_page">
                         共<i id="page_count">${wqtnews.commentpage}</i>页/当前第
                         <i id="current_page">
                              ${wqtnews.commentnum}
                         </i>页&nbsp;
                    </span>
                 </#if>  
                </div>
                <div class="hfk">
                    <h4>发表评论！</h4>
                    <textarea name="" id="hf_textarea" cols="50" rows="100" placeholder="评论前请先完成滑块拼图！"></textarea>
                </div>
                <!--拼图-->
                <div class="container" style="width: 310px;margin: 20px 0;display: inline-block;">
                    <div id="silderpuzzle" style="position: relative;padding-bottom: 15px;"></div>
                </div>
                <div id="tj">
                    <button type="button" class="hf_tj" data_id="${wqtnews.id?if_exists}">提交</button>
                </div>
            </div>
        </div>
    </div>
    <!--热文榜-->
    <div class="rt news_rt">
        <div class="news_rt_tit">
            <i></i>
            热文榜
        </div>
        <div class="news_rt_cont">
            <ul>
               <#if wqtnews.l_hotNews?exists>
			      <#list wqtnews.l_hotNews as hotnews>
			            <li><a href="/${hotnews.htmlpath?if_exists}" title="${hotnews.title?if_exists}">${hotnews.title?if_exists}</a></li>
				  </#list>
			  </#if>
            </ul>
        </div>
    </div>

    <div class="brand_db rt">
        <a href="http://ipr.w7tong.com/brandseek.html" target="_blank"><img src="/news/image/news_detail/banner_1.png" width="280" height="220" alt=""></a>
    </div>
</div>
<div class="pl_bg">
    <div class="text_pl">
        <p class="text_title">正在回复：<span></span></p>
        <textarea name="" id="child_text" cols="30" rows="10" placeholder="请先完成滑块拼图......"></textarea>
        <a href="javascript:;" class="fb c1">发布</a>
        <a href="javascript:;" class="qx c1">取消</a>
    </div>
</div>
<!--footer-->
<#include "/templates/footer.ftl">


<script src="https://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="/news/js/sliding.js"></script>
<script src="/templates/js/wqt_header.js"></script>
<script src="/common/commonurl.js"></script>
<script src="/common/share.js"></script>
<script src="/news/js/news.js"></script>

</body>
</html>