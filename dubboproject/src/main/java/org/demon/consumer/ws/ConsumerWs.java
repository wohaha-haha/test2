package org.demon.consumer.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.demon.api.DemoService;

@WebService
public class ConsumerWs {
	DemoService demoService;
	@WebMethod
	public String  hello(String name) 
	{
		return demoService.sayHello(name);
	}
	   @WebMethod(exclude=true)
	public DemoService getDemoService() {
		return demoService;
	}
	   @WebMethod(exclude=true)
	public void setDemoService(DemoService demoService) {
		this.demoService = demoService;
	}
	
}
