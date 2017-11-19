JFinal从入门到入魔教程

#Jfinal3.0系列教程
##第一课总结
###使用Eclipse+Maven构建JFinal的HelloWorld项目步骤：
- 配置MAVEN
- 安装eclipse Maven插件
- 设置eclipse Maven插件的相关配置
- pom.xml中填写JFinal的相关依赖描述，并且等待依赖包下载完成
- 创建MyConfig配置类
- web.xml中进行JFinal配置
- 建立Controller，并且继承JFinal的Controller
- 建立Route映射
- 编写JFinal的Jetty启动方法，并且启动项目
- 浏览器输入访问地址，看结果

## 第14讲.AOP间述
##Interceptor的分类
- Method Interceptor 方法级别
- Class Interceptor 类级别 当前类中的所有方法都有效
- Router Interceptor 路由级别 当前路由中所有方法都有效
- Global Interceptor 全局拦截 web请求所有的请求方法进行拦截
- Inject Interceptor 业务注入拦截器 对指定需要被注入的方法有效，可以是整个业务类，也可以某个方法

拦截器栈 多个Interceptor进行组合形成的拦截器栈

注解：
Before 添加拦截
Clear  清除拦截

## 第20讲.Interceptor总结	
## 拦截器的优先级
1、Global
2、Inject（InjectInterceptor RouteInterceptor）
3、Class
4、Method





