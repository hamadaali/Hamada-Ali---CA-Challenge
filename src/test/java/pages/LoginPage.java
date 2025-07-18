package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By ProfileButton = By.className("purina-profile");
    private final By signInButton = By.xpath("//button[normalize-space(text())='Log in']");
    private final By usernameField = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/form/div[1]/input");
    private final By PasswordField = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/form/div[2]/input");
    private final By submitButton = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/form/input[3]");
    private final By errorMessage = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/form/p");
    private final By homePopup = By.id("optlyCloseModal");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);
    }

    public void NavigateToLoginPage(){
        wait.until(ExpectedConditions.elementToBeClickable(ProfileButton));
        driver.findElement(ProfileButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(signInButton).click();

    }
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);

    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordField)).sendKeys(password);

    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();

    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        System.out.println(driver.findElement(errorMessage).getText());
        return driver.findElement(errorMessage).getText();
    }
    public void closePopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePopup));
        driver.findElement(homePopup).click();
    }
    public boolean displayProfileIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(ProfileButton));
        return driver.findElement(ProfileButton).isDisplayed();
    }

}