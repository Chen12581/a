<#list rootlist?if_exists  as root>
    <li class="comments-item">
        <div class="comments-item-bd">
            <div class="single-reply">
                <div class="ui-avatar lf">
                    <a href="javascript:;">
                        <img src="" alt="" class="avatar">
                    </a>
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
               