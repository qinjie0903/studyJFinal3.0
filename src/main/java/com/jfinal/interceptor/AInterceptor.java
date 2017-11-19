package com.jfinal.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		System.out.println("AInterceptor");
		inv.invoke();
	}

	
}
