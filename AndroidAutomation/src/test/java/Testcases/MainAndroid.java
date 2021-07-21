package Testcases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MainAndroid 
{
	  @Test
		  public void LaunchApp() throws MalformedURLException 
		  {
		  	  File f = new File("src");
		  	  File fs = new File (f, "selendroid-test-app.apk");
		  
			  DesiredCapabilities cap = new DesiredCapabilities();
			  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator5");
			  cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
			  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			  AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		  
			  //Verify title of the page 
			    String context = driver.getContext();
			    driver.context("NATIVE_APP");
			    Assert.assertEquals(driver.getTitle(), "selendroid-test-app");
			    
			   // Verify the elements
			    List<AndroidElement> elementsOne = driver.findElementsByAccessibilityId("");
		        int numberOfTags = elementsOne.size();
		        System.out.println("No. of Elemnts on this App are: " +numberOfTags);
		        
		        //Clicking EN button
		        driver.findElement(By.id("en_button")).click();
			  
		        
			  
		  }
}
