package Project1;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
	public AndroidDriver driver;
  @Test
  public void Camera() {
	  driver.get("http://demowebshop.tricentis.com");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElement(By.xpath("//span[@class='icon']")).click();
      driver.findElement(By.xpath("//a[contains(text(),'Electronics')]//following-sibling::span")).click();
      driver.findElement(By.xpath("//li[@class='active']//ul//a[contains(text(),'Camera, photo')]")).click();
      WebElement drop=driver.findElement(By.xpath("//select[@id='products-pagesize']"));
      Select sel = new Select(drop);
      sel.selectByVisibleText("12");
      String expected="Digital SLR Camera 12.2 Mpixel";
      JavascriptExecutor je = (JavascriptExecutor) driver;
      
      WebElement element = driver.findElement(By.xpath("((//div[@class='details'])[3]//following::a)[1]"));
       je.executeScript("arguments[0].scrollIntoView(true);",element); 
      String actual=element.getText();
      Assert.assertEquals(actual, expected);
	  
	  
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities capability = new DesiredCapabilities();
      capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Sanskriti");
     capability.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
     capability.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
     driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
     driver.get("http://demowebshop.tricentis.com");
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close(); 
  }

}
