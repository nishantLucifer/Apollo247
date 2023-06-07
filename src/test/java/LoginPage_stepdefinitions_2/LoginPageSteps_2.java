package LoginPage_stepdefinitions_2;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import com.pages.*;
import com.pages.HomePage;
import com.pages.LandingPage;
import com.pages.LoginPage;
import com.utility.Utility;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps_2 extends Utility{
	public LandingPage ldp;
	public LoginPage lp;
	public HomePage hp;
	public Utility ut;
	public void objectMethod()throws IOException
	{
		ldp = new LandingPage();
		lp  = new LoginPage();
		hp  = new HomePage();
		ut  = new Utility();
	}
	
	@Given("Chrome is opened and apollo247 app is opened")
	public void chrome_is_opened_and_apollo247_app_is_opened() throws InterruptedException, IOException {
		objectMethod();
		Utility.implicitWait();
		System.out.println("******Chrome is opened and Landing page is visisble******");
	}
	@When("User navigate on landing page")
	public void user_navigate_on_landing_page() throws InterruptedException, IOException {
		objectMethod();
		logger = report.createTest("test01");
	    logger.log(Status.INFO, "Validating landing page title");
	    
	    try {
		String actualtitle = ldp.validateLandinPageTitle();
		String expectedtitle = "Apollo 247 - Online Doctor Consultation & Book Lab Tests at Home"; 
		assertEquals(expectedtitle, actualtitle);
		System.out.println("**** Titles are Matching of the website********"); 
		Utility.implicitWait();
		logger.log(Status.INFO, "Step1 is executed");
	    }
		catch(AssertionError e)
        {
            e.printStackTrace();
            logger.log(Status.FAIL, "Step 1 is failed");
            captureScreenshotOnFailure();
            assert false;
        }
	}
	
	@Then("Fields on navigation page are visible to the user")
	public void fields_on_navigation_page_are_visible_to_the_user() throws Exception {
		objectMethod();
		System.out.println("************ALL TEXT ON WEBSITE ARE *************");
		System.out.println("ELEMENT IS DISPLAYED - ASSERT PASSED");
		assertEquals(true, ldp.isEnable());
		System.out.println("ELEMENT IS ENABLED - ASSERT PASSED");
		ut.captureScreenshot();
		Utility.implicitWait();
		logger.log(Status.INFO, "Step2 is executed");
	}
	
	@Then("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException, IOException {
		objectMethod();
		ldp.cancelpopupbutton();
		Utility.implicitWait();
		ldp.loginbutton_open();
		Utility.implicitWait(); 
		logger.log(Status.INFO, "Step3 is executed");
	}
	
	@Then("User enters invalid {string} mobile number")
	public void user_enters_invalid_mobile_number(String string) throws Exception {
	  objectMethod();
	  lp.Parameterizedmobilelogin(string);
	  Utility.implicitWait();
	  lp.mobilelogin();
	  Utility.implicitWait();
	  lp.login_click(); 
	  logger.log(Status.INFO, "Step4 is executed");
	}
	
	
	@When("User enters invalid OTP")
	public void user_enters_invalid_OTP() throws Exception {
		objectMethod();
		Thread.sleep(7000);
		lp.afterotp_button();
		Utility.implicitWait();
		logger.log(Status.INFO, "Step5 is executed");
		
	}
	
	
	@Then("User should get the error text on console")
	public void user_should_get_the_error_text_on_console() throws Exception {
		objectMethod();
		lp.otpError();
		ut.captureScreenshot();
		logger.log(Status.INFO, "Step6 is executed");
	}
	

}


	