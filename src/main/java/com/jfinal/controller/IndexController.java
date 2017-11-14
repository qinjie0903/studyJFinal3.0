package com.jfinal.controller;

import com.jfinal.core.Controller;

/**
* <p>Title: IndexController</p>
* <p>Description: 控制器（继承Jfinal的Controller）</p>
* <p>Company: Talk is cheap.Show me code.</p> 
* @author qinjie
* @date Oct 29, 2017 10:21:50 PM
*/
public class IndexController extends Controller {
	
	public void index() {
		setAttr("msg", "hello jfinal3.0");
		renderTemplate("index.html");
	}
}
