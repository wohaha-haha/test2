package org.demon.provider.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class Provider {
	public static void main(String[] args) throws Exception {
		Log4jConfigurer.initLogging("classpath:config/log4j.properties");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:config/applicationContext-provider.xml"});
        context.start();

        System.in.read(); // 按任意键退出
    }
}
