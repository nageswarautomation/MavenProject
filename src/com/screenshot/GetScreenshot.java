package com.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class GetScreenshot extends MainTest  {
	
	
	public static String capture(String screenshotName) throws IOException {
        //take a  screenshot
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		//create new file in destination file
		
		File dstFile=new File("C:\\sj_testing\\Test Framework\\Screen shot"+screenshotName+".png");
		
		//copy the screenshot to new file in destination folder
		FileUtils.copyFile(src, dstFile);
		
		return null;
	
	}

}
		