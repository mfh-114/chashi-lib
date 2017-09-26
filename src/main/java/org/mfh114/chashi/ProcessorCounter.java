package org.mfh114.chashi;

public class ProcessorCounter {

	private ProcessorCounter(){}
	
	public static int getNumOfCPUCore(){
		
		return Runtime.getRuntime().availableProcessors();
		
	}
	
}
