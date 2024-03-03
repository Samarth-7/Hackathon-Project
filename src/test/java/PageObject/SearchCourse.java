package PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCourse extends BasePage{

	public SearchCourse(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@class=\"react-autosuggest__input\"]")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@aria-label=\"Submit Search\" and @class=\"nostyle search-button\"]")
	WebElement searchIcon;
	
	@FindBy(xpath="//*[@id=\"search-results-header-wrapper\"]/div/div[1]/div/div[2]/div[2]/button/span")
	WebElement langList;
	
	@FindBy(xpath="//div[@id=\"checkbox-group\"]//label//div[@class=\"cds-checkboxAndRadio-labelText\"]")
	List<WebElement> languages;
	
	@FindBy(xpath="//div[@class='css-1hllf5q']//button[1]")
	WebElement applyBtn;
	
	@FindBy(xpath="//div[@data-testid='search-filter-group-Level']//div[@class=\"css-nsxeb5\"]//div[@class=\"cds-checkboxAndRadio-labelText\"]")
    List<WebElement> levels;
	
	@FindBy(xpath="//*[@class=\"cds-119 cds-113 cds-115 cds-CommonCard-titleLink css-si869u cds-142\"]")
	List<WebElement> courseTitle;
	
	@FindBy(xpath="//*[@class='cds-119 css-11uuo4b cds-121']")
	List<WebElement> courseRating;
	
	@FindBy(xpath="//*[@class=\"cds-CommonCard-metadata\"]")
	List<WebElement> courseHours;
	
	@FindBy(xpath="//span[contains(text(),'Businesses')]")
	WebElement enterprise;
	
	public static List<String> LanguageList;
	public static List<String> LevelList;
	public static List<String> CourseName;
	public static List<String> CourseRating;
	public static List<String> CourseDuration;
	
	
	public void courseSearch(String CourseName) throws InterruptedException {
		searchBox.sendKeys(CourseName);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", searchIcon);
		Thread.sleep(3000);
	}
	
	
	public void languageList(String select_lang) throws InterruptedException {
		langList.click();
		try {
			System.out.println("--------------- Available Languages ---------------");
			for(WebElement l:languages) {
			System.out.println(l.getText());
			if(l.getText().contains(select_lang)) {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", l);
			}
		}
		applyBtn.click();
		}
		catch(Exception e) {
		
		}
	}
	
	public List<String> languageList1(){
		langList.click();
		LanguageList = new ArrayList<String>();
		for(int i=0;i<languages.size();i++)
		{
			   String k=languages.get(i).getText();
			   LanguageList.add(k);	
		}
		applyBtn.click();
		return LanguageList;
	}
	
	public void levelList(String select_level) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfAllElements(levels));
	    System.out.println("--------------- Available Levels ---------------");
		for(WebElement l1:levels) {
			if(l1.getText().contains(select_level)) {
				l1.click();
			}
			System.out.println(l1.getText());
		}
		
	}
	
	public List<String> levelList1(){
		LevelList = new ArrayList<String>();
		for(int i=0;i<levels.size();i++)
		{
			   String k=levels.get(i).getText();
			   LevelList.add(k);	
		}
		return LevelList;
	}
	
	public List<String> courseDetails() {
		System.out.println("--------------- Title & Rating of first 2 Courses ---------------");
		CourseName = new ArrayList<String>();
		CourseRating = new ArrayList<String>();
		CourseDuration = new ArrayList<String>();
		for(int i=0;i<2;i++) {
			String title=courseTitle.get(i).getText();
			String rating =courseRating.get(i).getText();
			String hours =courseHours.get(i).getText();
			
			String[] temp = hours.split(" · ");
			System.out.println(title+" "+rating +" "+ temp[2]);
			CourseName.add(title);
			CourseRating.add(rating);
			CourseDuration.add(temp[2]);
		}
		return CourseName;
		
	}
	
	
	public void forEnterprise() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", enterprise);
		
	}
	
	

}
