import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class NewTest1 {
	WebDriver driver = new ChromeDriver();
  @Test(priority = 1)
  public void a() throws InterruptedException {
	  //click on "Alert, Frame  Windows" on home page
	  driver.findElement(By.xpath("//div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[3]")).click();
	  Thread.sleep(5000);
	  
  }
  
  @Test(priority = 2)
  public void b() {
	  //click on "Browser window"
	  driver.findElement(By.xpath("(//li[@id='item-0'])[3]")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
  
  @Test(priority = 3)
  public void c() {
	  //"Buttons"
	  //Click on new tab button
	  driver.findElement(By.id("tabButton")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.switchTo().defaultContent();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //Click on new window button
	  driver.findElement(By.id("windowButton")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.switchTo().defaultContent();
	  //Click on new window message button
	  driver.findElement(By.id("messageWindowButton")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	}
  
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver", "F:\\Study\\chromedriver_win32 (90)\\chromedriver.exe");
	  driver.navigate().to("https://demoqa.com/");
	  driver.manage().window().maximize();
  }
  

  @AfterClass
  public void afterClass() {
	  driver.close();
	  driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

}
