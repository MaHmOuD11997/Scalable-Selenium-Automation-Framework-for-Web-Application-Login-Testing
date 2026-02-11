package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest { // وراثة من BaseTest

    // 5. DataProvider: يغطي جميع حالات الفشل في تيست واحد
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                { "WrongUser", "admin123", "Invalid credentials" }, // مستخدم خاطئ
                { "Admin", "wrongpass", "Invalid credentials" },   // كلمة مرور خاطئة
                { "Admin", "", "Required" },                       // كلمة مرور فارغة
                { "", "admin123", "Required" }                     // اسم مستخدم فارغ
        };
    }

    @Test(priority = 1, description = "Valid Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify successful login with valid credentials")
    public void testValidLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "admin123");
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "User should be redirected to dashboard");
    }

    // استخدام DataProvider هنا لتقليل الكود المكرر
    @Test(priority = 2, dataProvider = "loginData", description = "Invalid Login Scenarios")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify error messages for invalid login attempts")
    public void testInvalidLogin(String username, String password, String expectedError) {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        // التحقق من أن رسالة الخطأ تحتوي على النص المتوقع
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedError),
                "Error message mismatch! Expected part of: " + expectedError);
    }

    // 6. اختبار تسجيل الخروج (Logout Test)
    @Test(priority = 3, description = "Logout Test")
    @Description("Verify successful logout")
    public void testLogout() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LoginPage loginPage = new LoginPage(driver);

        // تسجيل الدخول أولاً
        loginPage.login("Admin", "admin123");

        // إجراء تسجيل الخروج
        loginPage.logout();

        // التحقق من العودة لصفحة تسجيل الدخول
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Logout failed, user not redirected to login page");
    }
}