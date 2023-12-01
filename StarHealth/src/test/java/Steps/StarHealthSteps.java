package Steps;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;

import BaseClass.base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Buynow;
import pages.Homepage;

public class StarHealthSteps {
	public static String ph_no;
	 Homepage homePage=new Homepage(base.driver);
	 Buynow buyNowPage=new Buynow(base.driver);
	 
	@Given("User launches the Star Health application with {string}")
	public void user_launches_the_star_health_application_with(String URL) {
		
	  base.driver.manage().window().maximize();
	  base.driver.get(URL);
	 
	}
	
	@Then("User waits for the Welcome to Star Health pop-up and closes it")
	public void user_waits_for_the_welcome_to_star_health_pop_up_and_closes_it() {
	    
	}

	@Then("User validates the Star Health home page title using a JUnit assertion")
	public void user_validates_the_star_health_home_page_title_using_a_j_unit_assertion() throws InterruptedException {
		
		Thread.sleep(2000);
		String title=homePage.get_homepage_title();
		boolean isEqual=title.equals("Star Health Insurance: Medical, Accident and Travel insurance policies");
		Assert.assertTrue(isEqual);
		//System.out.println("Star Health Home Page Title: " + title);
		
		
	}

	@When("User clicks on the Buy Now button")
	public void user_clicks_on_the_buy_now_button() throws InterruptedException {
		Thread.sleep(2000);
		homePage.click_On_BuyNow();
	}

	@Then("User types Name as {string}")
	public void user_types_name_as(String FullName) throws InterruptedException {
		Thread.sleep(2000);
		buyNowPage.give_name(FullName);
	}

	@Then("User types Phone as {string}")
	public void user_types_phone_as(String PhNo) throws InterruptedException {
		ph_no=PhNo;
		buyNowPage.give_phno(PhNo);
	}

	@Then("User types the PIN as {string}")
	public void user_types_the_pin_as(String PIN) throws InterruptedException {
		buyNowPage.give_pin(PIN);
	}
	
	@Then("User clicks on I need health insurance from the drop-down menu")
	public void user_clicks_on_i_need_health_insurance_from_the_drop_down_menu() throws InterruptedException {
		buyNowPage.click_dropdown();
		Thread.sleep(1000);
	}
	
	
	@When("User selects the option {string}")
	public void user_selects_the_option(String OptionPlan) throws InterruptedException {
		base.driver.findElement(By.xpath("//li[text()="+"'"+OptionPlan+"'"+"]")).click();
		Thread.sleep(3000);
	}

	@Then("User sees the Plan for My Family page")
	public void user_sees_the_plan_for_my_family_page() throws InterruptedException {
		base.driver.findElement(By.xpath("//li[text()='My Family']")).click();
		Thread.sleep(1000);
	}

	@When("User validates that the mobile number is the same as the previously entered number using a JUnit assertion")
	public void user_validates_that_the_mobile_number_is_the_same_as_the_previously_entered_number_using_a_j_unit_assertion() throws InterruptedException {
		Thread.sleep(3000);
		String phoneNumber=buyNowPage.ContactNo_verify();
		Assert.assertEquals("Phone Number Matched ", ph_no, phoneNumber);
	}

	
	@Then("User clicks on the Star Health logo")
	public void user_clicks_on_the_star_health_logo() throws InterruptedException {
		buyNowPage.click_logo();
	}

	@Then("The Application should redirect to the home page")
	public void the_application_should_redirect_to_the_home_page() {
	   
	}

	@When("User closes the child tab")
	public void user_closes_the_child_tab() {
		 String parentWindowHandle = base.driver.getWindowHandle();

	       
	        Set<String> allWindowHandles = base.driver.getWindowHandles();

	       
	        for (String handle : allWindowHandles) {
	            if (!handle.equals(parentWindowHandle)) {
	           
	                base.driver.switchTo().window(handle);

	                
	            }
	        }

	        // Switch back to the parent window
	        base.driver.switchTo().window(parentWindowHandle);
	    }
	

	@Then("User navigates back to the parent tab")
	public void user_navigates_back_to_the_parent_tab() {
		Set<String> allWindowHandles = base.driver.getWindowHandles();

        // Get the current window handle
        String currentWindowHandle = base.driver.getWindowHandle();

        // Iterate over all window handles
        for (String handle : allWindowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                // Switch back to the parent window
                base.driver.switchTo().window(currentWindowHandle);
                break;  // Assuming there is only one child window, break out of the loop after switching
            }
	   
        }
	}
}
	


