package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeSteps {

    @Given("^user gives employee name \"([^\"]*)\" salary \"([^\"]*)\" age \"([^\"]*)\"$")
    public void userGivesEmployeeNameSalaryAge(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^user calls \"([^\"]*)\" with POST request$")
    public void userCallsWithPOSTRequest(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^AddEmployeeAPI is success with status code (\\d+)$")
    public void addemployeeapiIsSuccessWithStatusCode(int arg0) {
    }

    @And("^\"([^\"]*)\" is \"([^\"]*)\"$")
    public void is(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
