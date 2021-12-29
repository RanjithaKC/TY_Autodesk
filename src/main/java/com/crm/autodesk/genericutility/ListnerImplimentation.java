package com.crm.autodesk.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplimentation implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// capture the method name
		String methodName = result.getMethod().getMethodName();
		
		//capture the current date
		String CurrentDate = new JavaUtility().getSystemDateWithFormat();
		
		//concatenate
		String screenShotName = methodName+"_"+CurrentDate;
		
		try {
			new WebDriverUtility().takeScreenshot(BaseClass.sdriver, screenShotName);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
