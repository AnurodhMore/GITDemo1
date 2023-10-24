package TestsonArrays;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksTest2 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");// TODO Auto-generated method stub
		
		List<WebElement> links = driver.findElements(By.cssSelector(" li[class='gf-li'] a "));
		
		SoftAssert a = new SoftAssert();
		
		for(WebElement link: links)
		{
			String url = link.getAttribute("href");
			// Above is an example for individual link
					
					
					HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection(); // new URL is method and .openconn is class
					conn.setRequestMethod("HEAD");
					conn.connect();
					
					int respCode = conn.getResponseCode();
					System.out.println(respCode);
					a.assertTrue(respCode>400, "The link with text "+link.getText()+" is broken with code "+respCode);
				//	Assert.assertTrue(respCode>400, "The link with text "+link.getText()+" is broken with code "+respCode);
//					if(respCode>400)
//					{
//						System.out.println("The link with text "+link.getText()+" is broken with code "+respCode);
//						Assert.assertTrue(false);
//					}
					
		}
		a.assertAll();

	}

}

// Example from Instructor

// public class BrokenLinks {



//public static void main(String[] args) throws MalformedURLException, IOException {
//
//// TODO Auto-generated method stub
//
//System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
//
//         WebDriver driver=new ChromeDriver();
//
//         
//
//         //broken URL
//
//         //Step 1 - IS to get all urls tied up to the links using Selenium
//
//         //  Java methods will call URL's and gets you the status code
//
//         //if status code >400 then that url is not working-> link which tied to url is broken
//
//         //a[href*="soapui"]'
//
//         driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//
//         
//
//         
//
//      List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
//
//      SoftAssert a =new SoftAssert();
//
//     
//
//      for(WebElement link : links)
//
//      {
//
//       
//
//          String url= link.getAttribute("href");
//
//         
//
//          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
//
//          conn.setRequestMethod("HEAD");
//
//          conn.connect();
//
//          int respCode = conn.getResponseCode();
//
//          System.out.println(respCode);
//
//          a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
//
//         
//
//     
//
//      }
//
//     
//
//      a.assertAll();





















