package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
* <p>Title: FrontRouteInterceptor</p>
* <p>Description: 前台路由级别的拦截器</p>
* <p>Company: Talk is cheap.Show me code.</p> 
* @author qinjie
* @date Oct 29, 2017 10:21:39 PM
*/
public class FrontRouteInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		System.out.println("FrontRouteInterceptor......");
		inv.invoke();//非常重要，一定要调用，使之继续往下执行Controller下的方法
	}

}
