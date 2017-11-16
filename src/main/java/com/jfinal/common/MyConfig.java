package com.jfinal.common;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.controller.BlogController;
import com.jfinal.controller.IndexController;
import com.jfinal.controller.UserController;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.model.Blog;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.route.AdminRoute;
import com.jfinal.route.FrontRoute;
import com.jfinal.template.Engine;

/**
 * <p>
 * Title: MyConfig
 * </p>
 * <p>
 * Description: Jfinal配置文件
 * </p>
 * <p>
 * Company: Talk is cheap.Show me code.
 * </p>
 * 
 * @author qinjie
 * @date Oct 29, 2017 10:21:57 PM
 */
public class MyConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		PropKit.use("a_little_config.txt");//使用配置文件
		me.setDevMode(true);// 开发模式
	}

	@Override
	public void configEngine(Engine me) {
		// 模板引擎配置 Jfinal3.0新增
	}

	@Override
	public void configHandler(Handlers me) {
		//上下文
		me.add(new ContextPathHandler("ctx"));
	}

	@Override
	public void configInterceptor(Interceptors me) {

	}

	@Override
	public void configPlugin(Plugins me) {
		System.out.println(PropKit.get("jdbcUrl"));
		System.out.println(PropKit.get("user"));
		System.out.println(PropKit.get("password"));
		DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"),PropKit.get("user"),PropKit.get("password"));
		me.add(druidPlugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		me.add(arp);
		arp.addMapping("t_blog", Blog.class);
	}

	@Override
	public void configRoute(Routes me) {

		// 第1讲 搭建Jfinal框架
		// me.add("/",IndexController.class);

		// 第4讲.Route的基本使用
		// me.add("/",IndexController.class)<=>me.add("/",IndexController.class,"")
		// me.add("/",IndexController.class);
		// me.add("/", IndexController.class, "/abc");
		// me.add("/blog", BlogController.class, "/blog");
		// me.add("/user", UserController.class, "/user");

		// 第5讲.Route路由的分包技法
		me.add(new FrontRoute());
		me.add(new AdminRoute());

		// 第6讲.路由级别拦截器RouteInterceptor

	}

	@Override
	public void afterJFinalStart() {
		// 系统启动后完成回调
		System.out.println("---afterJFinalStart---");
	}

	@Override
	public void beforeJFinalStop() {
		// 系统关闭前完成回调
		System.out.println("---beforeJFinalStop---");
	}

	public static void main(String[] me) {
		//JFinal.start("src/main/webapp", 80, "/", 5);//init datasource error（去除最后一个参数即可）解决文档：http://www.jfinal.com/feedback/992
		JFinal.start("src/main/webapp", 80, "/");
	}
}
