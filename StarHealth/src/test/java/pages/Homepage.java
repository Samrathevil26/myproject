package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.base;


public class Homepage {
	@FindBy(xpath = "//span[text()='Buy Now']")
	public static WebElement buyNow;


	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String get_homepage_title() throws InterruptedException{
		String title = base.driver.getTitle();
		return title;
		
	}


	public void click_On_BuyNow() throws InterruptedException {
		Thread.sleep(2000);
		buyNow.click();
		
	}


}