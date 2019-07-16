package com.wqt.listener;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.imageio.plugins.common.I18N;

/*struts防止SQL注入拦截器*/
public class IllegalCharacterInterceptor extends AbstractInterceptor {

 @Override
 public String intercept(ActionInvocation invocation) throws Exception {
	 
  //定义非法字符集，用以过滤struts传回参数
  String igrelStringBuffer[] = new String[]{"=","\"",">","<","eq","lt","gt","neq","gte","lte","having","dual","select","when","where","'","between","like","in","exists","null","()","DBMS"};
  
  
  //通过核心调度器invocation来获得调度的Action上下文
  ActionContext actionContext = invocation.getInvocationContext();
  //获取Action上下文的值栈
  ValueStack stack = actionContext.getValueStack();
  //获取上下文的请求参数
  Map valueTreeMap = actionContext.getParameters();
  //获得请求参数集合的迭代器
  Iterator iterator = valueTreeMap.entrySet().iterator();
  //遍历组装请求参数
  while(iterator.hasNext()){
   //获得迭代的键值对
   Entry entry = (Entry) iterator.next();
   //获得键值对中的键值
   String key = (String) entry.getKey();
   //原请求参数，因为有可能一键对多值所以这里用的String[]
   String[] oldValues = null;
   //对参数值转换成String类型的
   try{
	   if(entry.getValue() instanceof String){
	    oldValues = new String[]{entry.getValue().toString()};
	   }else{
	    oldValues = (String[])entry.getValue();
	   }
   }catch(Exception e){
	   StringBuffer sb = new StringBuffer();
	   sb.append(entry.getValue());
	   oldValues = new String[]{sb.toString()};
   }
   //处理后的请求参数
   String newValueStr = null;
   //对请求参数过滤处理
   if(oldValues.length>1){
    newValueStr = "{" ;
    for(int i=0 ;i<oldValues.length; i++){
     //替换掉非法参数
    	for(int j = 0 ; j< igrelStringBuffer.length ; j++){
    		if(oldValues[i].indexOf(igrelStringBuffer[j]) != -1){
    			newValueStr+=",";
    		}
	     	if(i!=oldValues.length-1){
	     		newValueStr+=",";
	     	}
    	}
    }
    newValueStr+="}";
   }else if(oldValues.length==1){
    //替换掉非法参数
	   for(int i=0 ;i<oldValues.length; i++){
		   for(int j = 0 ; j< igrelStringBuffer.length ; j++){
	    		if(oldValues[i].indexOf(igrelStringBuffer[j]) != -1){
	    			newValueStr+=",";
	    		}
		     	if(i!=oldValues.length-1){
		     		newValueStr+=",";
		     	}
	    	}
	   }

   }else{
    newValueStr = null;
   }
   //处理后的请求参数加入值栈中
   stack.setValue(key, newValueStr);
  }
  String result = null;
  try {
   // 调用下一个拦截器，如果拦截器不存在，则执行Action  
   result = invocation.invoke();
  } catch (Exception e) {
   e.printStackTrace();
  }
  return result;
 }

}