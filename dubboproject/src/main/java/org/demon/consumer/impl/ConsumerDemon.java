package org.demon.consumer.impl;

import org.demon.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class ConsumerDemon {

	public static void main(String[] args) throws Exception {
		Log4jConfigurer.initLogging("classpath:config/log4j.properties");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:config/bapplicationContext-consumer.xml" });
		context.start();

		DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
		String hello = demoService.sayHello("world"); // 执行远程方法

		System.out.println(hello); // 显示调用结果
	}

}
