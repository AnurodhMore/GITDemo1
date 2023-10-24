package TestsonArrays;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");	
		
		//to find out no of frames in a web page and then accrodingly switching by INDEX as well rather than just webelement 
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		
	//	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		driver.findElement(By.id("draggable")).click();

		
		Actions a1 = new Actions(driver);
		WebElement source = driver.findElement(By.cssSelector("div[id='draggable']"));
		WebElement dest = driver.findElement(By.cssSelector("div[id='droppable']"));

		a1.dragAndDrop(source , dest ).build().perform();
		
		//switching from frame to webpage
		driver.switchTo().defaultContent();
	}
}
