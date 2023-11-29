package browserTesting;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserAutomationTesting {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91630\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	@Test
	public void testFacebookSignUpAndLoginAuthentication() {
		driver.get("https://www.facebook.com");

		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("Gaurav");

		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys("Mall");

		WebElement email = driver.findElement(By.name("reg_email__"));
		email.sendKeys("gauravmallgkp@gmail.com");

		WebElement password = driver.findElement(By.name("reg_passwd__"));
		password.sendKeys("*****");

		WebElement signUpButton = driver.findElement(By.name("websubmit"));
		signUpButton.click();

		WebElement loginEmail = driver.findElement(By.id("email"));
		loginEmail.sendKeys("gauravmallgkp@gmail.com");

		WebElement loginPassword = driver.findElement(By.id("pass"));
		loginPassword.sendKeys("*****");

		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();

		// Facebook Authentication
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlContains("success")); 

		assertTrue(driver.getCurrentUrl().contains("success"));
		
	}

	@Test
	public void testGoogleSearch() {
	
		driver.get("https://www.google.com");

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium WebDriver");
		searchBox.sendKeys(Keys.RETURN);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));

		assertTrue(driver.getTitle().contains("Selenium WebDriver"));
		// Add more assertions or verifications if needed
	}

}
