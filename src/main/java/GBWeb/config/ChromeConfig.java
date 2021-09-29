package GBWeb.config;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeOptions;

@Slf4j
public class ChromeConfig {

    private static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";

    static void setChromeDriverPath() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        log.info("Path to chrome driver: ()", System.getProperty("webdriver.chrome.driver"));
    }

    static ChromeOptions getChromeOptions(boolean headlessMode) {
        ChromeOptions options = new ChromeOptions()
                .addArguments("--lang=ru")
                .addArguments("start-maximized");

        if (headlessMode)
            options.addArguments("--headless");

        return options;
    }
}
