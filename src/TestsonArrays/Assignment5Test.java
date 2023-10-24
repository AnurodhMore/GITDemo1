package TestsonArrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5Test {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.cssSelector("ul li [href='/nested_frames']")).click();
		
//		driver.switchTo().frame(1);
		
		driver.switchTo().frame("frame-top");

		driver.switchTo().frame("frame-middle");
		

		
		System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());
		

	}

}
