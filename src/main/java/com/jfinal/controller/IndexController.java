package com.jfinal.controller;

import com.jfinal.core.Controller;

/**
* <p>Title: IndexController</p>
* <p>Description: 控制器（继承Jfinal的Controller），首页</p>
* <p>Company: Talk is cheap.Show me code.</p> 
* @author qinjie
* @date Oct 29, 2017 10:21:50 PM
*/
public class IndexController extends Controller {
	
	/**
	 * action定义模板（public 无参 无返回值）
	 */
	public void index() {
		//第8讲.Controller介绍简术和Action定义
		String msg = getPara("msg","defaultMsg");
		String[] checkbox=getParaValues("test");//接收checkbox内容
		setAttr("msg", "hello jfinal3.0 "+ msg);
		renderTemplate("index.html");
	}
}
