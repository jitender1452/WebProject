package WebdriverPro.web.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {

	public WebDriver driver;

	public Elements(WebDriver driver) {
		this.driver = driver;
	}

	//-----------------waits----------------
	public WebElement waitForElementPresent(By by){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}

	public void waitForElementDissappear(By by){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}


	//--------------Conditions---------------

	public boolean isElementPresent(By by){

		if(getElements(by).size()>0)
			return true;
		else return false;
	}


	//-----------Actions-------------
	public WebElement getElement(By by){
		return driver.findElement(by);	
	}

	public List<WebElement> getElements(By by){
		return driver.findElements(by);
	}

	public void hoverOver(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void click(By by){
		getElement(by).click();
	}

	public void enter(By by, String value){
		getElement(by).sendKeys(value);
	}




}
