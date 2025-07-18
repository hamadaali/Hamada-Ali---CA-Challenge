package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utilities.DriverManager;



public class LoginSteps {
    private final LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        DriverManager.getDriver().get("https://www.petfinder.com/");
        loginPage.NavigateToLoginPage();
    }
    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickSubmit();

    }

    @Then("I should be logged in successfully")
    public void i_Should_Be_LoggedIn_Successfully() {
        loginPage.closePopup();
        Assert.assertTrue(loginPage.displayProfileIcon());
    }

    @Then("I should get an error alert message {string}")
    public void iShouldGetAnErrorAlertMessage(String errorMessage) {
        Assert.assertTrue(loginPage.getErrorMessage().contains(errorMessage));
    }
    @Then("I should get validation error message")
    public void i_Should_Get_Validation_Error_Message() {
    }


}
