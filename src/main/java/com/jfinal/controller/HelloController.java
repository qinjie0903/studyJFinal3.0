package com.jfinal.controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller{

	/**
	 * action定义模板（public 无参 无返回值）
	 */
	public void hello() {
		setAttr("msg", "hello jfinal3.0 ");
		renderTemplate("hello.html");
	}
}
