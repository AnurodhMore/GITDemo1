package TestsonArrays;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowhandlesTest {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/"); 
		
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
// since here switching to new tab, we have to give instructions to selenium
		
		Set<String> windows = driver.getWindowHandles(); // will have all information related to all open windows
		// [PARENTID, CHILDID]
		
		Iterator<String> it = windows.iterator(); // it wi;; iterate through windows to get id
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red ")).getText());
		
		String sentence = driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
		
		String[] splittedString = sentence.split(" with");
		String [] splitted = splittedString[0].split("at ");
		System.out.println(splitted[1]);
		
		driver.switchTo().window(parentId);
		
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(splitted[1]);
		//*[@id="interview-material-container"]/div/div[2]/p[2]
	}

}
