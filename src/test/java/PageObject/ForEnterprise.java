package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForEnterprise extends BasePage {

	public ForEnterprise(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Solutions")
	WebElement Solutions;
 
	@FindBy(xpath="//a[@target='https://www.coursera.org/campus']")
	WebElement for_campus;
	
	public void clicksolution() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", Solutions);
		Thread.sleep(3000);
	}
	public void clickcampus() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", for_campus);
		Thread.sleep(3000);
	}	
}
