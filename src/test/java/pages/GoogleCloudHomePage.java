package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String PAGE_URL = "https://cloud.google.com/";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//*[@class='devsite-search-form']")
    WebElement searchButton;

    @FindBy(name = "q")
    WebElement searchInputLine;


    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(PAGE_URL);
        logger.info("Домашняя страница Google Cloud открыта");
        return this;
    }

    public GoogleCloudHomePage clickSearchButton() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
        return this;

    }

    public SearchResultPage inputSearchQuery() {
        searchInputLine.sendKeys(SEARCH_QUERY + '\n');
        logger.info("поиск Google Cloud Platform Pricing Calculator начат");
        return new SearchResultPage(driver);
    }
}