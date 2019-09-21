package com.screenshot;

import java.io.IOException;

import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;


public class ListenerTest extends MainTest implements ITestListener{	

    @Override		
    public void onFinish(ITestContext Result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onStart(ITestContext Result ) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {					
        // TODO Auto-generated method stub				
        		
    }		
    //when test case get failed, this method is called
    @Override		
    public void onTestFailure(ITestResult Result) {					
        // TODO Auto-generated method stub
  
			try {
				GetScreenshot.capture(Result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
    			
    
    
    //when test case get skipped, this method is called
    @Override		
    public void onTestSkipped(ITestResult Result) {					
        // TODO Auto-generated method stub	
    	System.out.println("the name of the test case skipped is:"+Result.getName());
        		
    }		
    //when the test case get started, this method is called
    @Override		
    public void onTestStart(ITestResult Result) {					
        // TODO Auto-generated method stub
    	System.out.println("the name of the test case is started is :"+Result.getName());
        		
    }		
    //when the test case get passed, this method is called
    @Override		
    public void onTestSuccess(ITestResult Result) {					
        // TODO Auto-generated method stub	
    	System.out.println("the name of the test case is passed is:"+Result.getName());
        		
    }		
}		

	
