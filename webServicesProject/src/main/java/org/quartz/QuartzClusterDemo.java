package org.quartz;

import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzClusterDemo  extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		 System.out.println("Job started..");  
	}

}
