package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1. استخدام WebDriverManager بدلاً من تحديد المسار يدوياً
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ملاحظة: قمنا بإزالة Implicit Wait لاستخدام Explicit Wait في الصفحات كما طلبت
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // 2. منطق Screenshot on Failure
        if (ITestResult.FAILURE == result.getStatus()) {
            saveScreenshot(driver);
        }

        if (driver != null) {
            driver.quit();
        }
    }

    // 3. إرفاق الصورة لتقرير Allure
    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}