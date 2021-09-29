package GBWeb.config;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

@Slf4j
public class SeleniumHandler {

    private static final int WAIT_TIME_MAX = 6;
    private WebDriver driver;
    private Wait<WebDriver> wait;

    public boolean start(boolean headlessMode) {
        try {
            driver = getChromeDriver(headlessMode);
        } catch (Exception e) {
            log.warn("Driver was not initialized: ()", e.getMessage());
            return false;
        }
        return true;
    }

    public boolean openPage(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            log.warn("Error opening page: ()", url);
            return false;
        }
        return true;
    }

    public WebElement getElement(String xpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void click(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);arguments[0].click()", webElement);
    }

    public void stop() {
        if (driver != null)
            driver.quit();
    }

    private WebDriver getChromeDriver(boolean headlessMode) {
        ChromeConfig.setChromeDriverPath();
        return new ChromeDriver(ChromeConfig.getChromeOptions(headlessMode));
    }
}
