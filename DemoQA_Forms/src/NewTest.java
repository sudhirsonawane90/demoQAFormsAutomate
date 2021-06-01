import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;


public class NewTest {
	
	WebDriver driver = new ChromeDriver();
	
  @Test
  public void f() throws InterruptedException {
	  JavascriptExecutor Js = (JavascriptExecutor) driver;
	  Js.executeScript("window.scrollBy(0,250)");
	  WebElement menuForms = driver.findElement(By.xpath("(//div[contains(@class,'card mt-4')])[2]"));
	  Actions focusMenu = new Actions(driver);
	  focusMenu.moveToElement(menuForms).click().build().perform();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("(//li[@id='item-0'])[2]")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("firstName")).sendKeys("Sudhir");
	  driver.findElement(By.id("lastName")).sendKeys("Sonawane");
	  driver.findElement(By.id("userEmail")).sendKeys("test@abcdef.com");
	  driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
	  driver.findElement(By.id("userNumber")).sendKeys("0123456789");
	  //Selecting Date of birth from the calendar
	  driver.findElement(By.id("dateOfBirthInput")).click();
	  WebElement dobCalendar = driver.findElement(By.xpath("(//div[@class='react-datepicker']//div)[2]"));
	  Actions calendar = new Actions(driver);
	  calendar.moveToElement(dobCalendar).build().perform();
	  WebElement year = driver.findElement(By.xpath("//div[@class='react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select']//select[1]"));
	  Select yearDOB = new Select(year);
	  yearDOB.selectByValue("2002");
	  WebElement month = driver.findElement(By.xpath("//div[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select']//select[1]"));
	  Select monthDOB = new Select(month);
	  monthDOB.selectByIndex(0);
	  WebElement date = driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--024']"));
	  Actions dateSelect = new Actions(driver);
	  dateSelect.moveToElement(date).click().build().perform();
	  //Selecting subject
	  driver.findElement(By.id("subjectsInput")).click();
	  WebElement enterMaths = driver.findElement(By.id("subjectsInput"));
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  enterMaths.sendKeys("Maths");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebElement radio = driver.findElement(By.xpath("//label[text()='Reading']"));
	  Actions radioHobbie = new Actions(driver);
	  radioHobbie.moveToElement(radio).click().build().perform();
	  WebElement uploadPic = driver.findElement(By.id("uploadPicture"));
	  uploadPic.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\koala.jpg");
	  driver.findElement(By.id("currentAddress")).sendKeys("Milap nagar, Dombivali");
	  //State
	  driver.findElement(By.id("state")).click();
	  driver.findElement(By.id("react-select-3-option-3")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //City
	  WebDriverWait city = new WebDriverWait(driver, 10);
	  city.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"city\"]/div/div[2]/div")));
	  driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[2]/div")).click();
	  driver.findElement(By.xpath("//div[text()='Jaiselmer']")).click();
	  
	  //Submit
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("submit")).click();
  }


  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "F:\\Study\\chromedriver_win32 (90)\\chromedriver.exe");
	  driver.navigate().to("https://demoqa.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
}