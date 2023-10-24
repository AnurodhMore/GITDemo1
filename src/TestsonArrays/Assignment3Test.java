package TestsonArrays;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3Test {

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector("input.form-control")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("learning");
		
		driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		
		WebElement statDropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select(statDropdown);
		
		//dropdown.selectByIndex(2);
		dropdown.selectByVisibleText("Consultant");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.cssSelector("input[id='terms']")).click();
		
		driver.findElement(By.cssSelector("input[name='signin']")).click();
		
		
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a[class='nav-link btn btn-primary']")));

		
		List<WebElement> products1  = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
		
		for(int i=0; i < products1.size(); i++) 
		{
			products1.get(i).click();
			
 			
		}
		
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
		
	}

}
