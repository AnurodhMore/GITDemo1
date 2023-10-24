package TestsonArrays;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CookiesTest {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.google.com/");
		// Take Screenshot
		// Cast driver object with TakesScreenshot method
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// To get file in local machine we have to use FileUtils
		FileUtils.copyFile(src,new File("C:\\Users\\anumore\\screenshot.png"));  //imported commonsio jars

	}

}
