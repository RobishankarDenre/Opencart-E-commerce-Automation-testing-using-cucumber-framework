package stepsDefinitions;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class RegistrationSteps {
	WebDriver driver;
	AccountRegistrationPage regpage;
	HomePage hp;
//	BaseClass bc;

	@Given("the user navigates to Register Account page")
	public void the_user_navigates_to_register_account_page() {
		hp = new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickRegister();

	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(DataTable dataTable) throws InterruptedException {

		regpage = new AccountRegistrationPage(BaseClass.getDriver());
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		regpage.setFirstName(dataMap.get("firstName"));
		regpage.setLastName(dataMap.get("lastName"));
		regpage.setEmail(dataMap.get("mailId") + BaseClass.randomeString() + "@gmail.com");
		regpage.setTelephone(dataMap.get("telephone"));
//		String pass = bc.randomAlphaNumeric();
		regpage.setPassword(dataMap.get("password"));
		regpage.setConfirmPassword(dataMap.get("password"));

		Thread.sleep(Duration.ofSeconds(10));

	}

	@When("the user selects Privacy Policy")
	public void the_user_selects_privacy_policy() {
		regpage.setPrivacyPolicy();

	}

	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() {
		regpage.clickContinue();

	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() {
		String confmsg = regpage.getConfirmationMsg();
		System.out.println(confmsg);

	}

}
