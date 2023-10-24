package TestsonArrays;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// There are some Java methods which will call URLs and get you the status code
		// Step 1-  get all URLs tied up to the links using selenium
		// Java methods will call URLs and get you the status code\
		// if status code > 400 then the URL is not working -> link which tied to url is broken 
		
	//	String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
// Above is an example for individual link
		
		
		HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection(); // new URL is method and .openconn is class
		conn.setRequestMethod("HEAD");
		conn.connect();
		
		int respCode = conn.getResponseCode();
		System.out.println(respCode);
	}

}
