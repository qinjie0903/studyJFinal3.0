package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class MethodInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		System.out.println("MethodInterceptor");
		inv.invoke();
	}

}
