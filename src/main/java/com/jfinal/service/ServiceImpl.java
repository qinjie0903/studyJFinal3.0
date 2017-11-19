package com.jfinal.service;

import com.jfinal.aop.Before;
import com.jfinal.aop.Duang;

/**
 * 
* <p>Title: ServiceImpl</p>
* <p>Description: ServiceImpl是我们需要加强的目标类</p>
* <p>Company: Talk is cheap.Show me code.</p> 
* @author qinjie
* @date Nov 19, 2017 11:28:20 AM
 */

//@Before(InjectorInterceptor.class)
public class ServiceImpl {

	//@Before(InjectorInterceptor.class)
	public void testInject() {
		System.out.println("testInject");
	}
	
	public void common(){
		System.out.println("common");
	}
			

}
