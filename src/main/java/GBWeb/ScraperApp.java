package GBWeb;

import GBWeb.config.SeleniumHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScraperApp {

    private static final String PARIS_HOTELS_URL =
            "https://www.tripadvisor.ru/Hotels-g187147-Paris_Ile_de_France-Hotels.html";

    private final SeleniumHandler handler = new SeleniumHandler();

    public static void main(String[] args) {
        ScraperApp scraperApp = new ScraperApp();
        scraperApp.startCrawling();
    }

    private void startCrawling() {
        if (handler.start(true)) {
            handler.openPage(PARIS_HOTELS_URL);
            log.info("Opened page: ()", PARIS_HOTELS_URL);
        }
    }
}
