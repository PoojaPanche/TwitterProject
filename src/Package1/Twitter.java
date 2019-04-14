package Package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Twitter {
	
	// Twitter credential
	static String user = "@PooPanchi";
	static String passWord ="bG59GDejesbWV7q";
	
	public static void main(String[] args) throws InterruptedException {
		// Launch Chrome Browser
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		WebDriver driver = new ChromeDriver(chromeOptions);

		// Launch Twitter
		
		driver.get("https://twitter.com/login");
		driver.manage().window().maximize();

		// Twitter Login
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Phone, email or username']"));
		username.sendKeys(user);
		WebElement password = driver.findElement(By.xpath("//input[@class='js-password-field']"));
		password.sendKeys(passWord);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		

		// Search for POTUS

		WebElement searchword = driver.findElement(By.xpath("//input[@id='search-query']"));
		searchword.sendKeys("POTUS");
		driver.findElement(By.xpath("//button[@class='Icon Icon--medium Icon--search nav-search']")).click();
		 Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement potus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/POTUS']")));
		potus.click();
       
		//Validate to following POTUS
	
		String validate = driver.findElement(By.xpath("//span[@class='user-actions-follow-button js-follow-btn follow-button']")).getText();
		driver.findElement(By.xpath("//span[@class='user-actions-follow-button js-follow-btn follow-button']")).click();
		if ("Following\nFollowing".equalsIgnoreCase(validate)) {
			System.out.println("You are following POTUS");
		} 
		else {
			System.out.println("You are Not following POTUS");
		}

		Thread.sleep(5000);

		// Logout

		driver.findElement(By.id("user-dropdown-toggle")).click();
		driver.findElement(By.id("signout-button")).click();

		

	}
	


}
