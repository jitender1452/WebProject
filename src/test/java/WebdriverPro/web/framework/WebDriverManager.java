package WebdriverPro.web.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverManager {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void launchBrowser(){
		driver = new FirefoxDriver();
		System.out.println(PropertyManager.getProperty("browser"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void quitBrowser(){
		driver.close();
		driver.quit();
	}

}
