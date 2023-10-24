package TestsonArrays;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertificateTest2 {

	public static void main(String[] args)
	{
		
// ChromeOptions class helps you to set the behaviour for your chrome browser
		ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
	//	System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
        
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());



		}

}
