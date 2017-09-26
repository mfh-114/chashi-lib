package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.ProcessorCounter;
import org.mfh114.chashi.core.async.AsyncTaskManager;
import org.mfh114.chashi.core.async.Task;
import org.testng.annotations.Test;

public class AsyncTaskManagerTester {

	@Test(groups="unit-test")
	public void verifyAsyncTaskManager(){
		
		System.out.println("Verify async task ...");
		
		AsyncTaskManager asyncTaskManager = new AsyncTaskManager(ProcessorCounter.getNumOfCPUCore());
		asyncTaskManager.addTask(); //add new Task instance
		
	}
	
}
