package TestCases;


import org.testng.annotations.Test;

import PageObject.CoursesForCampus;
import TestBase.TestNGBaseClass;

public class TC02_FormFilling extends TestNGBaseClass {
	
	
	@Test(priority=1,groups={"Regression"})
	public void formFilling() throws InterruptedException {
		
		logger.info("****** Starting TestCase02 Form Filling ******");
		CoursesForCampus cc= new CoursesForCampus(driver);
		
//		cc.setFirstName(p.getProperty("FirstName"));
//		cc.setLastName(p.getProperty("LastName"));
//		cc.setEmail(p.getProperty("Email"));
//		cc.setPhoneNumber(p.getProperty("PhoneNumber"));
//		cc.selectInstitutionType();
//		cc.setInstitutionName(p.getProperty("InstitutionName"));
//		logger.info("Provided Data from Property File");
		
		cc.setFirstName(randomString());
		cc.setLastName(randomString());
		cc.setEmail(randomString()+"gmail.com");
		cc.setPhoneNumber(randomNumber());
		logger.info("Provided random Data");
		
		cc.selectInstitutionType();
		cc.setInstitutionName(randomString());
		logger.info("Selected Institute Type");
		
		cc.selectjobrole();
//		cc.selectDepertment();
		logger.info("Selected Job Role & Department");
		cc.selectNeed();
		logger.info("Selected Need");
		Thread.sleep(1000);
//		cc.selectnoOfLearners();
		logger.info("Selected Number Of Learners");
		cc.selectCountry();
		cc.selectState();
		logger.info("Selected Country and State");
		cc.clickSubmit();
		logger.info("Sucessfully Clicked on Submit Button");
		cc.getErrorMsg();
		logger.info("got the Error Msg");
	}
	
}
