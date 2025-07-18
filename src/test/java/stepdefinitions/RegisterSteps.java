package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.RegisterPage;
import utilities.DriverManager;

public class RegisterSteps {
    private final LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    private final RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());
    @Given("I am on the Registration page")
    public void iAmOnTheRegistrationPage() {
        DriverManager.getDriver().get("https://www.petfinder.com/");
        registerPage.NavigateToSignUpPage();
    }

    @When("I enter email {string} and continue")
    public void iEnterEmailAndContinue(String email) {
        registerPage.enterEmailAddress(email);
        registerPage.clickContinueButton();
    }

    @And("I enter First name {string} and last name {string} and zip code {string}")
    public void iEnterFirstNameAndLastNameAndZipCode(String fname, String lname, String zip) {
        registerPage.closeTrustPopup();
        registerPage.personalInformation(fname, lname, zip);
        registerPage.clickContinueButton();
    }

    @And("I enter password {string} and confirm password {string} and click agree to terms")
    public void iEnterPasswordAndConfirmPasswordAndClickAgreeToTerms(String pass, String cpass) {
        registerPage.passwordInformation(pass, cpass);
        registerPage.createAccountButton();
    }

    @Then("I should be receive activation email")
    public void iShouldBeReceiveActivationEmail() {
        Assert.assertTrue(registerPage.verifyRegistration().contains("Verify your email"));
    }
}
