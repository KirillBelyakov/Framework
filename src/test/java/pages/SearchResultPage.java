package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends AbstractPage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    WebElement calculatorLink;

    public CalculatorPage pickQueryResult() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(calculatorLink));
        calculatorLink.click();
        logger.info("Страница калькулятора открыта");
        return new CalculatorPage(driver);
    }
}
