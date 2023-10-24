package TestsonArrays;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int j = 0;

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" }; // for multiple veggies

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));

		for (int i = 0; i < products.size(); i++) {
			// String name = products.get(i).getText()
			String[] name = products.get(i).getText().split("-"); // after splitting it returns as an array
			// format it to get actual vegetable name

			String formattedName = name[0].trim(); // remove white spaces after every veggies name

			// check whether name you extarcted is present in array or not
			// convert array to arraylist for easy search

			List itemsNeededList = Arrays.asList(itemsNeeded);

//		if(name.contains("Cucumber"))
			// if(itemsNeededList.contains(name))
			if (itemsNeededList.contains(formattedName)) {

				j++; // using another variable so that once all the elements are found, it will
						// stoplooping instead
				// of going through all the elements
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				// break; cannot be used in arraylist\

				// if(j==3)
				if (j == itemsNeeded.length) {
					break;
				}

			}
			driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();

			driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
			
			driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
			
			driver.findElement(By.cssSelector("button.promoBtn")).click();
			
			System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


		}

	}

}
