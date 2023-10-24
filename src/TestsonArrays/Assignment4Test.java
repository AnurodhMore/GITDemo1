package TestsonArrays;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4Test {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.cssSelector("ul li [href=\"/windows\"]")).click();
		
	    driver.findElement(By.cssSelector("a[href*='windows']")).click();
	    
	    Set<String> windows = driver.getWindowHandles(); // will have all infor related to all open windows
		// [PARENTID, CHILDID]
		
		Iterator<String> it = windows.iterator(); // it wi;; iterate through windows to get id
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());
		
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());


	}                                           

}
