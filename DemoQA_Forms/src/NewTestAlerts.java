import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
