package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CoursesForCampus;
import PageObject.ForEnterprise;
import TestBase.TestNGBaseClass;


public class TC03_FormFilling extends TestNGBaseClass {
	
	@Test(priority=1)
	public void forcampus() throws InterruptedException {
		ForEnterprise fe = new ForEnterprise(driver);
		fe.clicksolution();
		Thread.sleep(2000);
		fe.clickcampus();
		logger.info("Sucessfully clicked on Coursera for Campus");
	}
	
	
	@Test(priority=1,dependsOnMethods={"forcampus"})
	public void givefirstName() throws InterruptedException {
		try {
		CoursesForCampus cc= new CoursesForCampus(driver);
//		boolean targetPage = cc.checkLogoPresence();
//	    Assert.assertEquals(targetPage,true,"Login Failed");
//		cc.setFirstName(p.getProperty("FirstName"));
		Thread.sleep(5000);
		cc.setFirstName(randomString());
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	
	}
	
	@Test(priority=2)
	public void givelastName() {
		CoursesForCampus cc= new CoursesForCampus(driver);
//		cc.setLastName(p.getProperty("LastName"));
		cc.setLastName(randomString());
		
	}
//	
	@Test(priority=3)
	public void giveEmail() {
		CoursesForCampus cc= new CoursesForCampus(driver);
//		cc.setEmail(p.getProperty("Email"));
		cc.setEmail(randomString()+"gmail.com");
		
	}
//	
	@Test(priority=4)
	public void givePhoneNumber() {
		CoursesForCampus cc= new CoursesForCampus(driver);
//		cc.setPhoneNumber(p.getProperty("PhoneNumber"));
		cc.setPhoneNumber(randomNumber());
		
	}
	
	@Test(priority=5)
	public void SelectInstituteType() {
		CoursesForCampus cc= new CoursesForCampus(driver);
		cc.selectInstitutionType();
		logger.info("Selected Institute Type");
		
	}
	
	@Test(priority=6)
	public void giveInstituteName() {
		CoursesForCampus cc= new CoursesForCampus(driver);
//		cc.setInstitutionName(p.getProperty("InstitutionName"));
		cc.setInstitutionName(randomString());
		
	}
	
	@Test(priority=7)
	public void SelectJobRole() {
		CoursesForCampus cc= new CoursesForCampus(driver);
		cc.selectjobrole();
		logger.info("Selected Job Role");
		
	}
	
	@Test(priority=8)
	public void SelectDepartment() {
		CoursesForCampus cc= new CoursesForCampus(driver);
		cc.selectDepertment();
		logger.info("Selected Department");
		
	}
	
	@Test(priority=9)
	public void SelectNeed() throws InterruptedException {
		CoursesForCampus cc= new CoursesForCampus(driver);
		cc.selectNeed();
		logger.info("Selected Need");
		Thread.sleep(1000);
		
	}
	
	@Test(priority=10,dependsOnMethods= {"SelectNeed"})
	public void SelectNoofLearners() {
		CoursesForCampus cc= new CoursesForCampus(driver);
		cc.selectnoOfLearners();
		logger.info("Selected Number Of Learners");
		
	}
	
	@Test(priority=11)
	public void SelectCountry() {
		CoursesForCampus cc= new CoursesForCampus(driver);
		cc.selectCountry();
		logger.info("Sucessfully Selected Country");
		
	}
	
	@Test(priority=12,dependsOnMethods= {"SelectCountry"})
	public void SelectState() {
		CoursesForCampus cc= new CoursesForCampus(driver);
		cc.selectState();
		logger.info("Sucessfully Selected State");
		
		
	}
	
	@Test(priority=13)
	public void ClickSubmitBtn() {
		CoursesForCampus cc= new CoursesForCampus(driver);
		cc.clickSubmit();
		logger.info("Sucessfully Clicked on Submit Button");
		
	}
	
	@Test(priority=14)
	public void getErrorMsg() {
		CoursesForCampus cc= new CoursesForCampus(driver);
		cc.getErrorMsg();
		logger.info("got the Error Msg");
		
	}

}
