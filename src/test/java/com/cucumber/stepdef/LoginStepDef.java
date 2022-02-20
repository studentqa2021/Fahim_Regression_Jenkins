package com.cucumber.stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.generic.MasterPageFactory;
import com.util.BaseConfig;
import com.util.Highlighter;
import com.util.ScreenShot;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDef {
	
	WebDriver driver;
	MasterPageFactory obj;
	
	@Given("User need to open any browser")
	public void user_need_to_open_any_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    
	}

	@Given("Put application {string}")
	public void put_application(String string) throws Exception {
		driver.get(BaseConfig.getValue("URL"));
		driver.manage().window().maximize();
	}

	@When("put username {string}")
	public void put_username(String string) throws Exception {
		obj = new MasterPageFactory(driver);
		Highlighter.getColor(obj.getUsername(), driver);
		obj.getUsername().sendKeys(BaseConfig.getValue("Username"));
	}

	@When("put password {string}")
	public void put_password(String string) throws Exception {
		Highlighter.getColor(obj.getPassword(), driver);
		obj.getPassword().sendKeys(BaseConfig.getValue("Password"));
	}

	@When("click login button")
	public void click_login_button() {
		Highlighter.getColor(obj.getSubmit(), driver);
		obj.getSubmit().click();
	}

	@Then("login will be successful with valid credential")
	public void login_will_be_successful_with_valid_credential() throws Throwable {
		ScreenShot.getScreenShot(driver, "Login Test status");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(obj.getLoginStatusSuccessMsg().getText(), "Login Successfully");
		soft.assertTrue(obj.getSignOffList().get(7).isDisplayed());
				
		soft.assertAll();
	}

	@Then("close the browser when test finish")
	public void close_the_browser_when_test_finish() {
	    driver.quit();
	}


}
