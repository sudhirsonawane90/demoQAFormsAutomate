import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class NewTestAlerts {
	
	WebDriver driver = new ChromeDriver();
	
  @Test
  public void f() throws IOException {
	  
	  //Click button to see alert
	  driver.findElement(By.id("alertButton")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.switchTo().alert().accept();
	  
	  //On button click, alert will appear after 5 seconds
	  driver.findElement(By.id("timerAlertButton")).click();
	  WebDriverWait alertWait = new WebDriverWait(driver, 10);
	  alertWait.until(ExpectedConditions.alertIsPresent());
	  driver.switchTo().alert().accept();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //On button click, confirm box will appear
	  driver.findElement(By.id("confirmButton")).click();
	  driver.switchTo().alert().accept();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //On button click, prompt box will appear
	  driver.findElement(By.id("promtButton")).click();
	  driver.switchTo().alert().sendKeys("Sudhir");
	  driver.switchTo().alert().accept();
	  File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(screenshot1, new File("F:\\Study\\Screenshots\\demoQAAlerts\\alert1.png"));
	  
	  //Selecting frame sub menu
	  JavascriptExecutor Js = (JavascriptExecutor) driver;
	  Js.executeScript("window.scrollBy(0,400)");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("(//li[@id='item-2'])[2]")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  int size = driver.findElements(By.tagName("iframe")).size();
	  System.out.println(size);
	  driver.switchTo().frame("frame1");
	  String iFrameText1 = driver.findElement(By.id("sampleHeading")).getText();
	  System.out.println(iFrameText1);
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame("frame2");
	  String iFrameText2 = driver.findElement(By.id("sampleHeading")).getText();
	  System.out.println(iFrameText2);
	  driver.switchTo().defaultContent();
	  JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	  Js1.executeScript("window.scrollBy(400,0)");
	  
	  //Selecting Nested frame - Outer and inner frames
	  /*driver.findElement(By.xpath("(//li[@id='item-3'])[2]"));
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.switchTo().frame("frame1");
	  String parentText = driver.findElement(By.id("frame1")).getText();
	  System.out.println(parentText);
	  driver.switchTo().frame("Child Iframe");
	  String childText = driver.findElement(By.id("Child Iframe")).getText();
	  System.out.println(childText);
	  driver.switchTo().parentFrame();
	  driver.switchTo().defaultContent();*/
	  
	  //Model Dialogs 
	  JavascriptExecutor Js2 = (JavascriptExecutor) driver;
	  Js2.executeScript("window.scrollBy(0,500)");
	  driver.findElement(By.xpath("(//li[@id='item-4'])[2]")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //Small modal
	  driver.findElement(By.id("showSmallModal")).click();
	  driver.switchTo().activeElement().isDisplayed();
	  String modal = driver.findElement(By.xpath("(//div[@class='modal-content']//div)[3]")).getText();
	  System.out.println(modal);
	  driver.findElement(By.id("closeSmallModal")).click();
	  driver.switchTo().defaultContent();
	  
	  //Large Modal
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("showLargeModal")).click();
	  driver.switchTo().activeElement();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  System.out.println("______________________*****________________________");
	  String LargeModal = driver.findElement(By.xpath("(//div[@class='modal-content']//div)[3]")).getText();
	  System.out.println(LargeModal);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("closeLargeModal")).click();
	 
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "F:\\Study\\chromedriver_win32 (90)");
	  driver.navigate().to("https://demoqa.com/alerts");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  driver.quit();
  }

}
