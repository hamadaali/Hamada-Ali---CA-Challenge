package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public JavascriptExecutor js;

    private final By ProfileButton = By.className("purina-profile");
    private final By signUpButton = By.xpath("//button[normalize-space(text())='Create Account']");
    private final By emailAddress = By.id("emailAddress");
    private final By continueButton = By.xpath("//button[normalize-space(text())='Continue']");
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By zipCode = By.id("postalCode");
    private final By dogDropdownButton = By.id("dogCount-trigger");
    private final By trustPopup = By.className("onetrust-close-btn-handler");
    private final By password = By.id("password");
    private final By confirmPassword = By.id("confirmPassword");
    private final By agreeToTerms = By.id("terms");
    private final By submitButton = By.xpath("//button[normalize-space(text())='Create Account']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);
    }
    public void NavigateToSignUpPage(){
        wait.until(ExpectedConditions.elementToBeClickable(ProfileButton));
        driver.findElement(ProfileButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        driver.findElement(signUpButton).click();

    }
    public void enterEmailAddress(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddress)).sendKeys(email);
    }
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }
    public void closeTrustPopup() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("onetrust-banner-sdk"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(trustPopup));
        driver.findElement(trustPopup).click();
    }
    public void personalInformation(String fName, String lName, String zCode) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).sendKeys(zCode);


    }
    public void passwordInformation(String pass, String cPass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword)).sendKeys(cPass);
        wait.until(ExpectedConditions.elementToBeClickable(agreeToTerms));
        driver.findElement(agreeToTerms).click();
    }
    public void createAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();
    }
}
