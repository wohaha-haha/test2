package org.boot;

public class BootInit implements Runnable{  
	public void initMt() 
	{
		   new Thread(new BootInit()).start();  
	}

	public void run() {
		// TODO Auto-generated method stub
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
