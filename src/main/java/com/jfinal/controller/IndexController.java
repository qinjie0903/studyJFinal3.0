package com.jfinal.controller;

import java.io.File;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Duang;
import com.jfinal.aop.Enhancer;
import com.jfinal.core.Controller;
import com.jfinal.interceptor.AInterceptor;
import com.jfinal.interceptor.BInterceptor;
import com.jfinal.interceptor.ClassInterceptor;
import com.jfinal.interceptor.GlobalInterceptor;
import com.jfinal.interceptor.MethodInterceptor;
import com.jfinal.model.Blog;
import com.jfinal.render.ViewType;
import com.jfinal.service.InjectorInterceptor;
import com.jfinal.service.ServiceImpl;
import com.jfinal.service.ServiceImpl1;

/**
 * <p>
 * Title: IndexController
 * </p>
 * <p>
 * Description: 控制器（继承Jfinal的Controller），首页
 * </p>
 * <p>
 * Company: Talk is cheap.Show me code.
 * </p>
 * 
 * @author qinjie
 * @date Oct 29, 2017 10:21:50 PM
 */

@Before(ClassInterceptor.class)
public class IndexController extends Controller {

	/**
	 * action定义模板（public 无参 无返回值）
	 */
	//第19讲.Clear注解符的使用
	@Clear({ClassInterceptor.class,GlobalInterceptor.class})
	public void index() {
		// 第8讲.Controller介绍简术和Action定义
		String msg = getPara("msg", "defaultMsg");
		String[] checkbox = getParaValues("test");// 接收checkbox内容
		setAttr("msg", "hello jfinal3.0 " + msg);

		getModel(Blog.class);
		renderTemplate("index.html");

		// render("");

		// 第12讲.Controller中Render的讲解
		// 服务器端跳转
		// forwardAction("/add");
		// 浏览器重定向
		// redirect("/add");

	}

	public void add() {
		renderTemplate("add.html");
	}

	public void doAdd() {
		// 第10讲.Controller中getModel的使用方法
		// System.out.println(getModel(Blog.class));
		System.out.println(getModel(Blog.class, "b"));// 别名
		renderText("提交成功");
	}

	public void sss() {

		// 第13讲.Controller其他讲解

		// 文件上传和下载
		getFile();// 文件上传
		renderFile(new File("/upload"));// 文件下载
		// renderFreeMarker("");
		// 必须先调用getFile系列方法，才能使用getPara系列方法
		getFile();
		getPara("file");

		// session
		setSessionAttr("s1", "1232132");// 设置session
		getSessionAttr("s1");// 得到session
		removeSessionAttr("s1");// 移除session
	}

	/**
	 * 测试Method Interceptor 用法
	 */

	@Before(MethodInterceptor.class)
	public void testMethod() {
		renderTemplate("index.html");
	}

	public void testInjectMethod() {
		// 关键点如下
		ServiceImpl serviceImpl = Duang.duang(ServiceImpl.class);
		serviceImpl.testInject();
		serviceImpl.common();
		
		System.out.println("---第一种方式------");
		ServiceImpl1 serviceImpl1 = Duang.duang(ServiceImpl1.class);
		serviceImpl1.testInject();
		serviceImpl1.common();
		//第17讲.Duang duang特效（二）
		System.out.println("---第二种方式------");
		ServiceImpl1 serviceImpl2 = Duang.duang(ServiceImpl1.class,InjectorInterceptor.class);
		//ServiceImpl1 serviceImpl3 = Enhancer.enhance(ServiceImpl1.class);
		serviceImpl2.testInject();
		serviceImpl2.common();
		
		renderTemplate("index.html");
	}

	/**
	 * 拦截器栈(先执行的放左边)
	 */
	@Before({AInterceptor.class,BInterceptor.class})
	public void testInterceptorStack() {
		//第18讲.拦截器栈的使用
		renderTemplate("index.html");
	}
	
	
}
