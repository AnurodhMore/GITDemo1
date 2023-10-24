package TestsonArrays;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingTest {

	public static void main(String[] args) throws InterruptedException 
	
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;  // perfrom js opeartions for scrolling
		
		js.executeScript("window.scroll(0,500)");

		//document.querySelector(".tableFixHead")  table is specifically located by tagname.classname here
		Thread.sleep(3000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		
		// .tableFixHead td:nth-child(4)  - css for td  tagname.classname space tagname
		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum =0;
		for(int i=0; i<values.size(); i++)
		{
			
			
	//		Integer.parseInt(values.get(i).getText());
			// since we will get string thorugh text and if we have to add then have to convert to int
			
			sum = sum + Integer.parseInt(values.get(i).getText());			
		}
		
		System.out.println(sum);
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(": ")[1]);
		
		Assert.assertEquals(sum,total);
	}

}
