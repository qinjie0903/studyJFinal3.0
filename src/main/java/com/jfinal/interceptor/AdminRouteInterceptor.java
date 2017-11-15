package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;


/**
* <p>Title: AdminRouteInterceptor</p>
* <p>Description: 后台路由级别的拦截器</p>
* <p>Company: Talk is cheap.Show me code.</p> 
* @author qinjie
* @date Oct 29, 2017 10:21:27 PM
*/
public class AdminRouteInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		System.out.println("AdminRouteInterceptor......");
		inv.invoke();//非常重要，一定要调用，使之继续往下执行Controller下的方法
	}

}
