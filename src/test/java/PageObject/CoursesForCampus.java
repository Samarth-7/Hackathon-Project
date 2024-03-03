package PageObject;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CoursesForCampus extends BasePage {

	public CoursesForCampus(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(xpath="//img[contains(@alt,\"Coursera for Campus\")]")
	WebElement cfclogo;
	
	@FindBy(xpath="//input[@id=\"FirstName\"]")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id=\"LastName\"]")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id=\"Email\"]")
	WebElement Email;
	
	@FindBy(xpath="//input[@id=\"Phone\"]")
	WebElement Phone;
	
	@FindBy(xpath="//select[@id=\"Institution_Type__c\"]")
	WebElement InstitutionType;
	
	@FindBy(xpath="//input[@id=\"Company\"]")
	WebElement InstitutionName;
	
	@FindBy(xpath="//select[@id=\"Title\"]")
	WebElement jobRole;
	
	@FindBy(xpath="//select[@id=\"Department\"]")
	WebElement departmentName;
	
	@FindBy(xpath="//select[@id=\"What_the_lead_asked_for_on_the_website__c\"]")
	WebElement needsDropdown;
	
	@FindBy(xpath="//select[@id=\"Self_reported_employees_to_buy_for__c\"]")
	WebElement noOfLearners;
	
	@FindBy(xpath="//select[@id=\"Country\"]")
	WebElement CountryDropDown;
	
	@FindBy(xpath="//select[@id=\"State\"]")
	WebElement StateDropDown;
	
	@FindBy(xpath="//*[@id=\"mktoForm_1512\"]/div[50]/span/button")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@role='alert' and @class='mktoErrorMsg']")
	WebElement errormsg;
	
	
	
	public boolean checkLogoPresence() {
		boolean status = cfclogo.isDisplayed();
		return status;
	}
	
	public void setFirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		LastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void setPhoneNumber(String number) {
		Phone.sendKeys(number);
	}
	
	public void selectInstitutionType() {
		InstitutionType.click();
		Select dd = new Select(InstitutionType);
		dd.selectByVisibleText("Other");
	}
	
	public void setInstitutionName(String iname) {
		InstitutionName.sendKeys(iname);
	}
	
	
	public void selectjobrole() {
		jobRole.click();
		Select dd = new Select(jobRole);
		dd.selectByVisibleText("Student");
	}
	
	
	public void selectDepertment() {
		departmentName.click();
		Select dd = new Select(departmentName);
		dd.selectByVisibleText("Other");
	}
	
	public void selectNeed() throws InterruptedException {
		js.executeScript("arguments[0].click()", needsDropdown);
		Select dd = new Select(needsDropdown);
		dd.selectByVisibleText("Other");
	}
	
	public void selectnoOfLearners() {
		js.executeScript("arguments[0].click()", noOfLearners);
		Select dd = new Select(noOfLearners);
		dd.selectByVisibleText("1-4");
	}
	
	public void selectCountry() {
//		CountryDropDown.click();
		Select dd = new Select(CountryDropDown);
		dd.selectByVisibleText("India");
	}
	
	public void selectState() {
//		StateDropDown.click();
		Select dd = new Select(StateDropDown);
		dd.selectByVisibleText("Maharashtra");
	}
	
	public void clickSubmit() {
		js.executeScript("arguments[0].click()",submitBtn);

	}
	
	public String getErrorMsg() {
		System.out.println("--------------- Error Message ---------------");
		System.out.println(errormsg.getText());
		try {
			return(errormsg.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
		
	}
	
	
	
	

}
