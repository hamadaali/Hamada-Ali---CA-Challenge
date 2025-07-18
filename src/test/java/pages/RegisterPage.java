package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private final By password = By.id("password");
    private final By confirmPassword = By.id("confirmPassword");
    private final By agreeToTerms = By.id("terms");
    private final By submitButton = By.xpath("//button[normalize-space(text())='Create Account']");
    private final By VerifyRegistration = By.xpath("/html/body/main/div/div/div/div/div/div/div/h1");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        js = (JavascriptExecutor) driver;
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
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        driver.findElement(continueButton).click();
    }
    public void closeTrustPopup() {
        try {
            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div")));
            WebElement acceptCookies = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/button"));
            if (acceptCookies.isDisplayed()) {
                acceptCookies.click();
                wait.until(ExpectedConditions.invisibilityOf(cookieBanner));
            }
        } catch (Exception e) {
           System.out.println("No cookie banner found.");
        }
    }
    public void personalInformation(String fName, String lName, String zCode) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).sendKeys(zCode);

        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");

        wait.until(ExpectedConditions.elementToBeClickable(dogDropdownButton));
        driver.findElement(dogDropdownButton).click();
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/main/div/div/div/div/form/div[2]/div[5]/div[1]/select")
        ));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='option' and contains(., '2')]") // Adjust based on actual HTML
        ));
        option.click();

    }
    public void passwordInformation(String pass, String cPass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword)).sendKeys(cPass);
        wait.until(ExpectedConditions.elementToBeClickable(agreeToTerms));
        driver.findElement(agreeToTerms).click();

    }
    public void createAccountButton() {
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();
    }
    public String verifyRegistration() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyRegistration));
        return driver.findElement(VerifyRegistration).getText();
    }
}
