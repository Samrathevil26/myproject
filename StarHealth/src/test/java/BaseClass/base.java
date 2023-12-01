package BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterAll;
public class base {
public static WebDriver driver=new ChromeDriver();

	
	@AfterAll
	public static void Close_Browser() throws InterruptedException {
		System.out.println("Browser closed");
		driver.close();
	}

}
