package GBWeb.config;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class SeleniumHandler {

    private WebDriver driver;

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

    public void stop() {
        if (driver != null)
            driver.quit();
    }

    private WebDriver getChromeDriver(boolean headlessMode) {
        ChromeConfig.setChromeDriverPath();
        return new ChromeDriver(ChromeConfig.getChromeOptions(headlessMode));
    }
}
