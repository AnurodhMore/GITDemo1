package TestsonArrays;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignement8 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(3000);

		String expectedValue = "India";
		
		List<WebElement> values = driver.findElements(By.className("ui-menu-item"));
		
		for(int i=0; i<values.size(); i++)
		{
			if(values.get(i).getText().equalsIgnoreCase(expectedValue))
			{
				values.get(i).click();
				System.out.println(values.get(i).getText());
			}
		}
		
	}

}
