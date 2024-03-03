package StepDefination;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import PageObject.CoursesForCampus;
import PageObject.ForEnterprise;
import PageObject.SearchCourse;
import TestBase.CucumberBaseClass;
import Util.ExcelUtils;
import io.cucumber.java.en.*;

public class Step_Defination {
	public static List<String> LanguageList;
	public static List<String> LevelList;
	public static List<String> CourseName;
	public static List<String> CourseRating;
	public static List<String> CourseDuration;
	static Properties p;
	WebDriver driver = CucumberBaseClass.getDriver();
	SearchCourse sc;
	ForEnterprise fe;
	CoursesForCampus cc;
	
	@Given("User is on the home page of Coursera")
	public void user_is_on_the_home_page_of_coursera() {
		CucumberBaseClass.getLogger().info("****** Starting Search Course ******");
	}

	@When("User search for the Web Development \\(search_name : {string} )")
	public void user_search_for_the_web_development_search_name(String search_name) throws InterruptedException {
		sc = new SearchCourse(driver);
		sc.courseSearch(search_name);
		CucumberBaseClass.getLogger().info("Search operation Sucessfull");
		Thread.sleep(3000);
	}

	@Then("User prints the Availabel languages")
	public void user_prints_the_availabel_languages() {
		sc = new SearchCourse(driver);
		sc.languageList1();
		CucumberBaseClass.getLogger().info("Printed all List of Language");
	}

	@Then("User prints the Availabel levels")
	public void user_prints_the_availabel_levels() {
		sc = new SearchCourse(driver);
		sc.levelList1();
		CucumberBaseClass.getLogger().info("Printed all List of Levels");
	}

	@When("User selects the language\\(select_lang : {string})")
	public void user_selects_the_language_select_lang(String select_lang) throws InterruptedException {
		sc = new SearchCourse(driver);
		sc.languageList(select_lang);
		CucumberBaseClass.getLogger().info("Slected Language");
	}

	@When("User selects the level \\(select_level: {string})")
	public void user_selects_the_level_select_level(String select_level) throws InterruptedException {
		sc = new SearchCourse(driver);
		sc.levelList(select_level);
		CucumberBaseClass.getLogger().info("Slected Level");
	}

	@Then("print the course name with ratings")
	public void print_the_course_name_with_ratings() {
		sc = new SearchCourse(driver);
		sc.courseDetails();
		CucumberBaseClass.getLogger().info("Printed the Course name, rating & duration");
		}
	

	@Then("save data in Excel")
	public void save_data_in_excel() {
		sc = new SearchCourse(driver);
  		ExcelUtils.writeToExcel(sc.LanguageList,sc.LevelList,sc.CourseName,sc.CourseRating,sc.CourseDuration);
  	    CucumberBaseClass.getLogger().info("Successfully entered data into the excel");
	}


	@When("user click on enterprice")
	public void user_click_on_enterprice() throws InterruptedException {
		sc = new SearchCourse(driver);
		sc.forEnterprise();
		CucumberBaseClass.getLogger().info("Successfully clicked on for Enterprise");
	}

	@When("user click on solution")
	public void user_click_on_solution() throws InterruptedException {
	    fe = new ForEnterprise(driver);
	    fe.clicksolution();
	    CucumberBaseClass.getLogger().info("Successfully clicked on solution");
	}

	@When("user click on for campus")
	public void user_click_on_for_campus() throws InterruptedException {
		fe = new ForEnterprise(driver);
		fe.clickcampus();
		CucumberBaseClass.getLogger().info("Successfully clicked on COurses for campus");
	}

	@When("fill the form")
	public void fill_the_form() throws InterruptedException, IOException {
		CucumberBaseClass.getLogger().info("****** Starting Form Filling ******");
        cc= new CoursesForCampus(driver);
        p=CucumberBaseClass.getProperties();
		
//		cc.setFirstName(p.getProperty("FirstName"));
//		cc.setLastName(p.getProperty("LastName"));
//		cc.setEmail(p.getProperty("Email"));
//		cc.setPhoneNumber(p.getProperty("PhoneNumber"));
//		cc.selectInstitutionType();
//		cc.setInstitutionName(p.getProperty("InstitutionName"));
//		CucumberBaseClass.getLogger().info("Provided Data from Property File");
		
		cc.setFirstName(CucumberBaseClass.randomString());
		cc.setLastName(CucumberBaseClass.randomString());
		cc.setEmail(CucumberBaseClass.randomString()+"gmail.com");
		cc.setPhoneNumber(CucumberBaseClass.randomNumber());
		CucumberBaseClass.getLogger().info("Provided random Data");
		
		cc.selectInstitutionType();
		cc.setInstitutionName(CucumberBaseClass.randomString());
		CucumberBaseClass.getLogger().info("Selected Institute Type");
		
		cc.selectjobrole();
		cc.selectDepertment();
		CucumberBaseClass.getLogger().info("Selected Job Role & Department");
		cc.selectNeed();
		CucumberBaseClass.getLogger().info("Selected Need");
		Thread.sleep(1000);
		cc.selectnoOfLearners();
		CucumberBaseClass.getLogger().info("Selected Number Of Learners");
		cc.selectCountry();
		cc.selectState();
		CucumberBaseClass.getLogger().info("Selected Country and State");
		cc.clickSubmit();
		CucumberBaseClass.getLogger().info("Sucessfully Clicked on Submit Button");
	}

	@When("getting the error msg")
	public void getting_the_error_msg() {
		cc= new CoursesForCampus(driver);
		cc.getErrorMsg();
		CucumberBaseClass.getLogger().info("got the Error Msg");
	}

}
