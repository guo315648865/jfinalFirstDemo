package com.lwg.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.SqlReporter;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.template.Engine;
import com.lwg.examples.controller.FirstController;
import com.lwg.examples.model.Account;
import com.lwg.examples.model.Employee;
import com.lwg.examples.utils.CommonUtils;
import com.lwg.examples.utils.task.Task1Task;

public class JfinalConfig extends JFinalConfig{
	/**
	 * 配置常量
	 */
	@Override
	public void configConstant(Constants cs) {
		// 第一次使用use加载配置将成为主配置，随后可用PropKit.get(...)获取值;
		//非第一次使用use加载配置，需要每次使用usr配置指定文件，再来取值，如String a=PropKit.use("jdbc.properties").get("host");
		PropKit.use("jdbc.properties");//加载在缓存中
		//PropKit.useless("jdbc.properties");//清楚缓存
		cs.setDevMode(true);//设置控制台打印日志
		//在 Controller 中可以通过 getPara(int index)分别取出这些值。默认是-;
		//例如http://localhost/controllerKey/method/v0-v1-N2 这个请求getPara(0)将返回”v0”
		//注意参数中 N2或者n2 返回的是负2
		cs.setUrlParaSeparator("-");
	}
	/**
	 * 配置访问映射
	 */
	@Override
	public void configRoute(Routes me) {
		me.add("/examples/first", FirstController.class);//
		me.add(new AdminRoutes());
		me.add(new FrontRoutes());
		
	}
	
	
	/**
	 * Handler可以接管所有 web 请求，并对应用拥有完全的控制权，可以很方便地实现更高层的功能性扩展
	 */
	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 配置全局拦截器
	 * 拦截所有的action请求，除非使用@clean 在 controller中
	 */
	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 配置数据库信息
	 */
	@Override
	public void configPlugin(Plugins arg0) {
		// 配置c3p0连接池插件
		DruidPlugin druidPlugin=new DruidPlugin(PropKit.get("jdbc_url"), PropKit.get("jdbc_uname"),PropKit.get("jdbc_pass"));
		arg0.add(druidPlugin);
		ActiveRecordPlugin arp =new ActiveRecordPlugin(druidPlugin);
		arg0.add(arp);
		arp.addMapping("security_account","id",Account.class);
		arp.addMapping("security_employee", Employee.class);//主键为id时可以默认省略
		//arg0.add(new EhCachePlugin());
		arp.setShowSql(true);
		SqlReporter.setLog(true);//打印日志sql
		
		//jfinal 任务调度 注意需要加cron4j的包,
		Cron4jPlugin cron4j=new Cron4jPlugin();
		cron4j.addTask("* * * * *", new Task1Task());//* * * * *表示每分钟执行一次
		arg0.add(cron4j);
		
		Cron4jPlugin cp=new Cron4jPlugin("task.properties","cron4j"); //如果配置文件是cron4j ，可以省略；task2.daemon=true表示守护进程  
		arg0.add(cp);
	}
	/**
	 * 共享到页面
	 */
	@Override
	public void configEngine(Engine me) {
		me.addSharedObject("rootPath", "http://localhost:8080/jfinalFirstDemo");//页面可以#(rootPath)调用 见页面 template.html java扩展
		me.addSharedObject("comm", new CommonUtils());//页面可以 通过#(comm.getTemple('bbbb'))调用 见页面 template.html java扩展
		me.addSharedMethod(new CommonUtils());//页面就可以直接调用该类里的方法了,而不需要加包路劲 如：#(getTemple('bbbb')) 见页面 template.html java扩展
	}
	@Override
	public void afterJFinalStart() {
		// TODO Auto-generated method stub
		super.afterJFinalStart();
		System.out.println("==============服务启动=================");
	}
	
	@Override
	public void beforeJFinalStop() {
		// TODO Auto-generated method stub
		super.beforeJFinalStop();
		System.out.println("==============服务停止=================");
	}

}
