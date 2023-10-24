package TestsonArrays;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		//Adding more than one element so findElements
		
       List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // beacuse of prodcuts have same product name
       
		
       for(int i=0; i<products.size(); i++) // iterate through loop to find name
       {
    	 String name =  products.get(i).getText();
    	 
    	 if(name.contains("Cucumber")) // match that name with required product
    	 {
    		 //Click on Add to cart
    		 
    			 driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();  //Click on Add to cart 	
    			 break; 
    		  
         }
    	 
       }

	}

}
