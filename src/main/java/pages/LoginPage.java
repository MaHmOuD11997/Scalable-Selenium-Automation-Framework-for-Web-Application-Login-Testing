package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait; // تعريف الانتظار الصريح

    // Locators
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");

    // لوكيتور عام يجمع رسائل الخطأ (مطلوب أو بيانات خاطئة)
    By errorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text') or contains(@class, 'oxd-input-field-error-message')]");

    // Logout Locators
    By userDropdown = By.className("oxd-userdropdown-name");
    By logoutLink = By.xpath("//a[text()='Logout']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // 4. تعريف Explicit Wait (10 ثواني)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Enter Username: {0}")
    public void enterUsername(String username) {
        // استخدام Wait قبل التفاعل مع العنصر
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }

    @Step("Enter Password")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    @Step("Click Login Button")
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Perform Login with Username: {0} and Password: {1}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    @Step("Get Error Message")
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }

    @Step("Check if Dashboard is Displayed")
    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    // دالة تسجيل الخروج الجديدة
    @Step("Perform Logout")
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public boolean isLoginPageDisplayed() {
        return wait.until(ExpectedConditions.urlContains("login"));
    }
}