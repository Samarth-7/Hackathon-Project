package TestCases;

import org.testng.annotations.Test;

import PageObject.SearchCourse;
import TestBase.TestNGBaseClass;
import Util.ExcelUtils;

public class TC01_SearchCourse extends TestNGBaseClass  {
	

	
	@Test(priority=1)
	public void search() throws InterruptedException {
		
		logger.info("****** Starting TestCase01 Search Course ******");
		SearchCourse sc = new SearchCourse(driver);
		sc.courseSearch(p.getProperty("SearchText"));
		logger.info("Search operation Sucessfull");
		Thread.sleep(4000);
			
	}
	@Test(priority=2)
	public void selectLang() throws InterruptedException {
		SearchCourse sc = new SearchCourse(driver);
	    sc.languageList1();
	    Thread.sleep(2000);
		sc.languageList(p.getProperty("Language"));
		logger.info("Slected Language and printed all List of Language");
		Thread.sleep(3000);				
		
	}
	
	@Test(priority=3)
	public void selectLevel() throws InterruptedException {
		SearchCourse sc = new SearchCourse(driver);
		sc.levelList1();
		sc.levelList(p.getProperty("Level"));
		logger.info("Selected Level");
	}
	
	
	@Test(priority=4)
	public void courseTitleandRating() throws InterruptedException {
		SearchCourse sc = new SearchCourse(driver);
		Thread.sleep(5000);
		sc.courseDetails();
		logger.info("Sucessfully printed Course Details");
		Thread.sleep(5000);
		sc.forEnterprise();
		logger.info("Sucessfully clicked on For Enterprise");
	}
	
	
	@Test(priority=5)
	public void Excelwrite() throws InterruptedException 
  	{
  		
		SearchCourse sc = new SearchCourse(driver);
  		ExcelUtils.writeToExcel(sc.LanguageList,sc.LevelList,sc.CourseName,sc.CourseRating,sc.CourseDuration);
  		logger.info("Successfully entered data into the excel");
 
  	}
	
	

}
