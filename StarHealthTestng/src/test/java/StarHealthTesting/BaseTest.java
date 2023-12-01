package StarHealthTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    WebDriver driver;

   

    @BeforeClass
    public void launchWebsite() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\91630\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.starhealth.in/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void hoverAndClickMenuOption() {

        WebElement plansMenu = driver.findElement(By.xpath("(//span[@class='ant-collapse-header-text'])[6]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(plansMenu).perform();
        WebElement forMyFamilyOption = driver.findElement(By.linkText("For My Family"));
        actions.moveToElement(forMyFamilyOption).click().perform();
    }

    @Test(priority = 2, dataProvider = "userDataProvider")
    public void fillDataAndClickNext(String name, String mobile, String pincode) {
        // Type name, mobile, and email
        WebElement nameInput = driver.findElement(By.xpath("//input[@id='name']"));
        nameInput.sendKeys(name);

        WebElement mobileInput = driver.findElement(By.xpath("//input[@id='contact_no']"));
        mobileInput.sendKeys(mobile);

        WebElement emailInput = driver.findElement(By.xpath(" //input[@id='pinCode']"));
        emailInput.sendKeys(pincode);

       
        driver.findElement(By.xpath(" //input[@id='pinCode']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='My Family']")).click();
    }

    @Test(priority = 3)
    public void clickBackButton() {
       
        WebElement backButton = driver.findElement(By.id("backButton"));
        backButton.click();
    }

    @Test(priority = 4, dataProvider = "userDataProvider")
    public void validateDataFields(String name, String mobile, String pincode) {
        // Validate data for name, mobile, and email fields
        WebElement nameInput = driver.findElement(By.xpath("//input[@id='name']"));
        WebElement mobileInput = driver.findElement(By.xpath("//input[@id='contact_no']"));
        WebElement emailInput = driver.findElement(By.xpath(" //input[@id='pinCode']"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nameInput.getAttribute("value"), name, "Name field value is not as expected");
        softAssert.assertEquals(mobileInput.getAttribute("value"), mobile, "Mobile field value is not as expected");
        softAssert.assertEquals(emailInput.getAttribute("value"), pincode, "Email field value is not as expected");

        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void clickTwitterLogo() throws InterruptedException {
        
        Thread.sleep(5000);
        driver.findElement(By.tagName("body")).sendKeys(org.openqa.selenium.Keys.CONTROL, org.openqa.selenium.Keys.END);

        // Click on the Twitter logo present in the footer
        WebElement twitterLogo = driver.findElement(By.xpath("(//img)[103]")); 
        twitterLogo.click();
    }

    @Test(priority = 6)
    public void validateTwitterPage() {
        
        String parentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }


        String twitterPageUrl = driver.getCurrentUrl();
        Assert.assertFalse(twitterPageUrl.contains("starhealthins"), "Twitter page URL doesn't contain 'starhealthins'");

      
        driver.close();
        driver.switchTo().window(parentWindowHandle);
    }

    @AfterClass
    public void tearDown() {
        // Quit the driver session
        driver.quit();
    }

   
    @DataProvider(name = "userDataProvider")
    public Object[][] userDataProvider() {
        // Provide test data from an Excel sheet or any other source
        return new Object[][] {
                {"Gaurav Mall", "9793477123", "273008"},
                
        };
    }
}
