package com.crm.autodesk.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImpl implements IRetryAnalyzer {
	
	int count=1;
	int retrycount=5;
	
	public boolean retry(ITestResult result) {
	
	while(count<retrycount) {
		count++;
		return true;
	}
	return false;
		
			
	}

}
