package TestsonArrays;

import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test3Wait {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		String[] itemsNeeded = {"Cucumber", "Brocolli","Beetroot", "Carrot"};
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		Thread.sleep(3000);
		
// 		getItems(driver, itemsNeeded);
		
		Test3Wait b = new Test3Wait(); // creating an object of the class
		b.getItems(driver, itemsNeeded);
      
    	
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		
		w1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//Explicit wait
		//WebDriverWait w = new WebDriverWait(driver,5);
		
		w1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	   
      }
	
	// you can use static if you want to create object
	  
	public void getItems(WebDriver driver, String[] itemsNeeded)

	{
		int j = 0; //so that it does not iterate through all items
		 List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // beacuse of prodcuts have same product name
	       
			
	       for(int i=0; i<products.size(); i++) // iterate through loop to find name
	       {
	    	 String[] name =  products.get(i).getText().split("-");
	    	 //format it to extarct actual veggie name
	    	 // name[0] - Brocolli   //name[1] - 1 kg
	    	 
	    	 String formattedName = name[0].trim(); // remove white spaces after every veggies name
	    	 
	    	 
	    	 
	    	 
	    	// convert array into arraylist for easy search
	    	 //
	    	 List itemsNeededList = Arrays.asList(itemsNeeded);
	    	 
	    	 
	    	 if(itemsNeededList.contains(formattedName)) // match that name with required product
	    	 {
	    		 //Click on Add to cart
	    		 
	    		 
	    		 j++;
	    		 
	    		 driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
	    			// driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();  //Click on Add to cart 	
	    	//		 break;  cannot use break in array list 
	    			 
	    			// if(j==3)
	    		       if(j==itemsNeeded.length)
	    			 {
	    				 break;
	    			 }
	         }
	}

	}}
