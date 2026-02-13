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
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;



import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1. استخدام WebDriverManager بدلاً من تحديد المسار يدوياً
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        // ملاحظة: قمنا بإزالة Implicit Wait لاستخدام Explicit Wait في الصفحات كما طلبت
    }


    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE && driver != null) {
            saveScreenshot();
        }

        if (driver != null) {
            driver.quit();
        }
    }


    // 3. إرفاق الصورة لتقرير Allure
    @Attachment(value = "Failure Screenshot", type = "image/png")
    public void saveScreenshot() {

        if (driver == null) {
            return;
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File("screenshots/" + System.currentTimeMillis() + ".png");

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}