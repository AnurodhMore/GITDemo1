package TestsonArrays;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		int j = 0; //so that it does not iterate through all items
   	 
		
		String[] itemsNeeded = {"Cucumber", "Brocolli","Beetroot", "Carrot"};
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		Thread.sleep(3000);
		//Adding more than one element so findElements
		
       List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // beacuse of prodcuts have same product name
       //getting all names with css selectors of product names	
		
       for(int i=0; i<products.size(); i++) // iterate through loop to find name
       {
    	 //check whether name you extracted is present in array or not
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

	}

}
