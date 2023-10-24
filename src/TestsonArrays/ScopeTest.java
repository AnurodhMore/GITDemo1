package TestsonArrays;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeTest {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	// getting the count of links on webpage
       System.out.println(driver.findElements(By.tagName("a")).size());
       
       //Count of footer section - Limiting webdriver scope
       // finding count of links in the footer section. so declaring a web element and using it as a sub-driver.
       WebElement footerdriver = driver.findElement(By.id("gf-BIG"));   
       System.out.println(footerdriver.findElements(By.tagName("a")).size());
       
       
       // Select a particular section and find count of links for it
       WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //navigating from footerdriver to chromedriver hirearchicaly
       System.out.println(coloumndriver.findElements(By.tagName("a")).size());
       
       //click on each link and check if the windows are opening
       for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
		{
			
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
			
		}// opens all the tabs
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> it=abc.iterator();
		
		while(it.hasNext())  // if any window is present
		{
			
		   driver.switchTo().window(it.next());  // it.next prints window ID
		   System.out.println(driver.getTitle());
		
		}
    	   
       }
       

	}


