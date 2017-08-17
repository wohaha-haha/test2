package org.boot;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
//@Component
public class BootDemon implements  ApplicationListener<ContextRefreshedEvent> {

	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		if(event.getApplicationContext().getParent() == null) 
		{
			int i=0;
			while(true) 
			{
				System.out.println("Let's inspect the beans provided by Spring Boot:"+(i++));
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
