package com.jfinal.controller;

import com.jfinal.core.Controller;

/**
* <p>Title: AdminController</p>
* <p>Description: </p>
* <p>Company: Talk is cheap.Show me code.</p> 
* @author qinjie
* @date Oct 29, 2017 10:21:45 PM
*/
public class AdminController extends Controller {
	
	public void index() {
		setAttr("msg", "hello jfinal3.0");
		renderTemplate("index.html");
	}
}
