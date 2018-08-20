package bddSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleFeatureSteps {
	@Given("^I navigate to Google homepage$")
	public void i_navigate_to_Google_homepage() throws Throwable {
	    System.out.println("Dry Run");
	}

	@When("^I enter 'CitiusTech' in search text box$")
	public void i_enter_CitiusTech_in_search_text_box() throws Throwable {
		System.out.println("Dry Run");
	}

	@When("^click the search button$")
	public void click_the_search_button() throws Throwable {
		System.out.println("Dry Run");
	}

	@Then("^I should see results regarding 'CitiusTech'$")
	public void i_should_see_results_regarding_CitiusTech() throws Throwable {
		System.out.println("Dry Run");
	}
}
