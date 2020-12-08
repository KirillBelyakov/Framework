package pages;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AbstractPage {
    protected WebDriver driver;
    protected Logger logger;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        logger = LogManager.getRootLogger();
    }
}
