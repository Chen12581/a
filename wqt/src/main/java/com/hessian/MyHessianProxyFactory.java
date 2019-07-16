/**    
 * @Title: MyHessianProxyFactory.java 
 * @Package com.talkweb.yygh.framework 
 * @author HuQingyun  
 * @date 2013-10-16 上午10:44:50 
 * @version V1.0    
 */
package com.hessian;

import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * This class is used for :
 * 
 * @author HuQingyun
 * @version 1.0
 * @date 2013-10-16 上午10:44:50
 */
public class MyHessianProxyFactory extends HessianProxyFactoryBean {

	public void setConnectTimeOut(int connectTimeOut) {
		if (connectTimeOut > 0) {
			HessianProxyFactory proxyFactory = new HessianProxyFactory();
			//proxyFactory.setConnectTimeout(connectTimeOut);
			proxyFactory.setOverloadEnabled(true); 
			super.setProxyFactory(proxyFactory);
		}
	}


}
