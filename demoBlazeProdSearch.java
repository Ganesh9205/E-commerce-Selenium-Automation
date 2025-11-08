package SeleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demoBlazeProdSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Qspiders\\Selenium\\selenium_workspace\\Selenium\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://demoblaze.com/");
		
		//Register User
		driver.findElement(By.id("signin2")).click();
		
		driver.findElement(By.id("sign-username")).sendKeys("User2");
		
		driver.findElement(By.id("sign-password")).sendKeys("User2QOBCKAJNCKW");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='sign-password']")).submit();
		
		//Click Category
		driver.findElement(By.linkText("Laptops")).click();
		
		//Click Product
		driver.findElement(By.linkText("MacBook air")).click();
		
		//Add to Cart
		driver.findElement(By.xpath("//a[normalize-space()='Add to cart']")).click();
		
		//Wait for alert to appear
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		//Switch and handle the alert
		Alert prodAddedAlert = driver.switchTo().alert();
		prodAddedAlert.accept();
		
		//Verify the product added in the cart
		driver.findElement(By.id("cartur")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
