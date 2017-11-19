package com.jfinal.service;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class InjectorInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		System.out.println("InjectorInterceptor");
		inv.invoke();
	}

}
