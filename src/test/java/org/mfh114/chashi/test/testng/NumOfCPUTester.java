package org.mfh114.chashi.test.testng;

import org.mfh114.chashi.ProcessorCounter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumOfCPUTester {

	@Test(groups = "unit-test")
	public void verifyCPU(){
		System.out.println("Verify number of cpu core ...");
		
		Assert.assertEquals(ProcessorCounter.getNumOfCPUCore(), 4);
	}
	
}
