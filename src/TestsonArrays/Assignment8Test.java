package TestsonArrays;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8Test {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://qaclickacademy.com/practice.php");

	    driver.findElement(By.id("autocomplete")).sendKeys("ind");

	    Thread.sleep(2000);

	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

	   System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
//	   public class Autodropdownassignment {
//
//
//
//		   public static void main(String[] args) {
//
//		   System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\chromedriver.exe");
//
//		   WebDriver driver = new ChromeDriver();
//
//		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//
//		   driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//
//		   driver.manage().window().maximize();
//
//		   String expected = "India";
//
//		   WebElement suggdd=driver.findElement(By.id("autocomplete"));
//
//		   suggdd.sendKeys("ind");
//
//		   List<WebElement> option = driver.findElements(By.className("ui-menu-item"));
//
//		   System.out.println(option.size());
//
//		   for(int i=0;i<option.size();i++)
//
//		   {
//
//		   if((option.get(i).getText()).equalsIgnoreCase(expected))
//
//		   {
//
//		   option.get(i).click();
//
//		   System.out.println(option.get(i).getText());
//
//		   }
//
//		   }



		                


		

	}

}
