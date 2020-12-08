package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class EmailGenerationPage extends AbstractPage {

    public EmailGenerationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mail")
    WebElement copyEmailButton;
    @FindBy(xpath = "//*[@title='Google Cloud Sales ']")
    WebElement receivedEmailButton;
    @FindBy(xpath = "//h3[contains(.,'USD')]")
    WebElement costFromEmail;

    public EmailGenerationPage copyEmail() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(copyEmailButton));
        copyEmailButton.click();
        copyEmailButton.sendKeys(Keys.LEFT_CONTROL, "c");
        return this;
    }

    public void switchToCalculatorPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public EmailGenerationPage openEmail() {
        new WebDriverWait(driver, 80)
                .until(ExpectedConditions.elementToBeClickable(receivedEmailButton));
        receivedEmailButton.click();
        return this;
    }

    public String getCostFromEmail() {
        new WebDriverWait(driver, 80)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(.,'USD')]")));
        return costFromEmail.getText();
    }
}
