package com.qa.StepDefintion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.qa.PageObject.LoginPage;
import com.qa.PageObject.ResearchPage;
import com.qa.PageObject.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ResearchPaperStepDefintion extends Utils {

	WebDriver driver;
	ResearchPage rPage;
	LoginPage lPage;

	@Before
	public void setup() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	}

	@Given("User lanuch the Research Paper application")
	public void user_lanuch_the_research_paper_application() {

		driver.get("https://example/");

	}

	@When("user is on the Research Paper screen")
	public void user_is_on_the_research_paper_screen() {

		rPage = new ResearchPage(driver);		
		assertEquals(rPage.gethomePage_text(), "Access full paper by clicking here.");

	}

	@And("User clicks on {string} link")
	public void user_clicks_on_link(String link) {

		rPage.clickOn(link);

	}

	@Then("User gets {string}")
	public void user_gets(String result) throws InterruptedException {


		if(result.equals("You do not have permission to do that")) {

			assertEquals(rPage.getErrorMessageText(),result);
			assertEquals(rPage.getStatusCode(), "403");

		}else if(result.equals("paper.pdf")) {

			assertTrue(Utils.fileDownloaded(result,3000),"File is not downloaded");

		}

	}

	@And("User enters Institutional Username : {string} and Institutional Password: {string}")
	public void user_enters_institutional_username_and_institutional_password(String userName, String password) {

		lPage = new LoginPage(driver);
		lPage.userNameField().sendKeys(userName);
		lPage.pwdField().sendKeys(password);

	}

	@And("User clicks on Login button")
	public void user_clicks_on_Login_button() {

		lPage.loginButton().click();

	}

	@And("User is navigates back to Research Paper Access page")
	public void user_is_navigates_back_to_research_paper_access_page() {

		assertEquals(rPage.gethomePage_text(), "Access full paper by clicking here.");

	}

	@After
	public void exit() {


		driver.quit();

	}

}
