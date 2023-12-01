package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buynow {

	@FindBy(xpath = "//input[@id='name']")
	public static WebElement name;

	@FindBy(xpath = "//input[@id='contact_no']")
	public static WebElement contactNo;

	@FindBy(xpath = "//input[@id='pinCode']")
	public static WebElement pinCode;

	@FindBy(xpath = "//div[@id='grouped-select']")
	public static WebElement dropDown;

	@FindBy(xpath = "//input[@id='contact_no']")
	public static WebElement contactNumberVeriry;

	@FindBy(xpath = "//img[@class='jss341']")
	public static WebElement logo;

	public Buynow(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
	public void give_name(String fullname) throws InterruptedException {
		Thread.sleep(2000);
		name.sendKeys(fullname);
	}

	public void give_phno(String phno) throws InterruptedException {
		Thread.sleep(2000);
		contactNo.sendKeys(phno);
	}

	public void give_pin(String pin) throws InterruptedException {
		Thread.sleep(2000);
		pinCode.sendKeys(pin);
	}

	public void click_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		dropDown.click();
	}

	public String ContactNo_verify() throws InterruptedException {
		Thread.sleep(2000);
		String C_no = contactNumberVeriry.getAttribute("value");
		return C_no;
	}

	public void click_logo() throws InterruptedException {
		Thread.sleep(2000);
		logo.click();
	}

}
