package pages;

import models.Calculator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.CalculatorCreator;
import service.GeneratorXpath;

import java.util.ArrayList;

import static util.WaitMethod.waitForElementToBeClickable;
import static util.WaitMethod.waitPresenceOfElementLocated;

public class CalculatorPage extends AbstractPage {
    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor executor = (JavascriptExecutor) driver;
    private Calculator calculator = CalculatorCreator.withCredentialsFromProperty();
    private GeneratorXpath generatorXpath = new GeneratorXpath();
    private static final By FRAME = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");
    private static final By EMAIL_INPUT_BOX = By.xpath("//input[@type='email']");
    private static final By SEND_EMAIL_BUTTON = By.xpath("//*[@aria-label='Send Email']");
    private static final By COST_FROM_ESTIMATE = By.xpath("//h2[@class='md-title']/b[@class='ng-binding']");

    private By VALUE_OF_OPERATING_SYSTEM_BUTTON = By.xpath(generatorXpath.getXpathForOperatingSystemValue());
    private By VALUE_OF_MACHINE_CLASS_BUTTON = By.xpath(generatorXpath.getXpathForMachineClass());
    private By VALUE_OF_MACHINE_SERIES_BUTTON = By.xpath(generatorXpath.getXpathForMachineSeries());
    private By VALUE_OF_MACHINE_TYPE_BUTTON = By.xpath(generatorXpath.getXpathForMachineType());
    private By VALUE_NUMBER_OF_GPUS_BUTTON = By.xpath(generatorXpath.getXpathForNumberOfGpus());
    private By VALUE_OF_GPU_TYPE_BUTTON = By.xpath(generatorXpath.getXpathForGpuType());
    private By VALUE_OF_LOCAL_SSD_BUTTON = By.xpath(generatorXpath.getXpathForLocalSSD());
    private By VALUE_OF_DATACENTER_LOCATION_BUTTON = By.xpath(generatorXpath.getXpathForDatacenterLocation());
    private By VALUE_OF_COMMITTED_USAGE_BUTTON = By.xpath(generatorXpath.getXpathForCommitedUsage());

    private static final By VALUE_OF_VM_TYPE_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'VM class')]");
    private static final By VALUE_OF_INSTANCE_TYPE_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Instance type:')]");
    private static final By VALUE_OF_REGION_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Region:')]");
    private static final By VALUE_OF_LOCAL_SSD_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Total available')]");
    private static final By VALUE_OF_COMMITMENT_TERM_FROM_ESTIMATE =
            By.xpath("//div[@class='md-list-item-text ng-binding' and contains(.,'Commitment')]");


    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement numberOfInstancesInput;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    WebElement operatingSystemDropDownList;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    WebElement machineClassDropDownList;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
    WebElement machineSeriesDropDownList;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    WebElement machineTypeDropDownList;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    WebElement addGPUCheckBox;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    WebElement numberOfGPUDropDownList;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    WebElement gpuTypeDropDownList;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    WebElement localSSDDropDownList;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    WebElement datacenterLocationDropDownList;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    WebElement commitedUsageDropDownList;

    @FindBy(xpath = "//*[@id='mainForm']/descendant::button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    WebElement addToEstimateButton;

    @FindBy(xpath = "//h2[@class='md-title']/b[@class='ng-binding']")
    WebElement costFromEstimate;

    @FindBy(id = "email_quote")
    WebElement emailButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@aria-label='Send Email']")
    WebElement sendEmailButton;

    public CalculatorPage open() {
        driver.get("https://cloud.google.com/products/calculator");
        return this;
    }

    public CalculatorPage frameSwitch() {
        waitPresenceOfElementLocated(driver, FRAME);
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        logger.info("Переключение фрейма успешно");
        return this;
    }

    public CalculatorPage setNumberOfInstances() {
        waitForElementToBeClickable(driver, numberOfInstancesInput);
        numberOfInstancesInput.sendKeys(calculator.getNumberOfInstances());
        logger.info("Количество сущностей установлено");
        return this;
    }

    public CalculatorPage setOperatingSystem() {
        waitForElementToBeClickable(driver, operatingSystemDropDownList);
        clickThroughJS(operatingSystemDropDownList);
        waitForElementToBeClickable(driver, VALUE_OF_OPERATING_SYSTEM_BUTTON);
        clickThroughJS(driver.findElement(VALUE_OF_OPERATING_SYSTEM_BUTTON));
        logger.info("Операционная система выбрана");
        return this;
    }

    public CalculatorPage setMachineClass() {
        waitForElementToBeClickable(driver, machineClassDropDownList);
        clickThroughJS(machineClassDropDownList);
        waitForElementToBeClickable(driver, VALUE_OF_MACHINE_CLASS_BUTTON);
        clickThroughJS(driver.findElement(VALUE_OF_MACHINE_CLASS_BUTTON));
        logger.info("Класс виртуальной машины выбран");
        return this;
    }

    public CalculatorPage setMachineSeries() {
        waitForElementToBeClickable(driver, machineSeriesDropDownList);
        clickThroughJS(machineSeriesDropDownList);
        waitForElementToBeClickable(driver, VALUE_OF_MACHINE_SERIES_BUTTON);
        clickThroughJS(driver.findElement(VALUE_OF_MACHINE_SERIES_BUTTON));
        logger.info("Серия виртуальной машины выбрана");
        return this;
    }

    public CalculatorPage setMachineType() {
        waitForElementToBeClickable(driver, machineTypeDropDownList);
        clickThroughJS(machineTypeDropDownList);
        waitForElementToBeClickable(driver, VALUE_OF_MACHINE_TYPE_BUTTON);
        clickThroughJS(driver.findElement(VALUE_OF_MACHINE_TYPE_BUTTON));
        logger.info("Тип виртуальной машины выбран");
        return this;
    }

    public CalculatorPage addGPUMark() {
        waitForElementToBeClickable(driver, addGPUCheckBox);
        clickThroughJS(addGPUCheckBox);
        return this;
    }

    public CalculatorPage setNumberOfGPU() {
        waitForElementToBeClickable(driver, numberOfGPUDropDownList);
        clickThroughJS(numberOfGPUDropDownList);
        waitForElementToBeClickable(driver, VALUE_NUMBER_OF_GPUS_BUTTON);
        clickThroughJS(driver.findElement(VALUE_NUMBER_OF_GPUS_BUTTON));
        logger.info("количество GPU выбрано");
        return this;
    }

    public CalculatorPage setGPUType() {
        waitForElementToBeClickable(driver, gpuTypeDropDownList);
        clickThroughJS(gpuTypeDropDownList);
        waitForElementToBeClickable(driver, VALUE_OF_GPU_TYPE_BUTTON);
        clickThroughJS(driver.findElement(VALUE_OF_GPU_TYPE_BUTTON));
        logger.info("значение GPU type выбрано");
        return this;
    }

    public CalculatorPage setLocalSSD() {
        waitForElementToBeClickable(driver, localSSDDropDownList);
        clickThroughJS(localSSDDropDownList);
        waitForElementToBeClickable(driver, VALUE_OF_LOCAL_SSD_BUTTON);
        clickThroughJS(driver.findElement(VALUE_OF_LOCAL_SSD_BUTTON));
        logger.info("значение LocalSSD выбрано");
        return this;
    }

    public CalculatorPage setDatacenterLocation() {
        waitForElementToBeClickable(driver, datacenterLocationDropDownList);
        clickThroughJS(datacenterLocationDropDownList);
        waitForElementToBeClickable(driver, VALUE_OF_DATACENTER_LOCATION_BUTTON);
        clickThroughJS(driver.findElement(VALUE_OF_DATACENTER_LOCATION_BUTTON));
        logger.info("DatacenterLocation выбрано");
        return this;
    }

    public CalculatorPage setCommittedUsage() {
        waitForElementToBeClickable(driver, commitedUsageDropDownList);
        clickThroughJS(commitedUsageDropDownList);
        waitForElementToBeClickable(driver, VALUE_OF_COMMITTED_USAGE_BUTTON);
        clickThroughJS(driver.findElement(VALUE_OF_COMMITTED_USAGE_BUTTON));
        logger.info("значение Committed Usage установлено");
        return this;
    }

    public CalculatorPage addToEstimate() {
        waitForElementToBeClickable(driver, addToEstimateButton);
        clickThroughJS(addToEstimateButton);
        logger.info("Расчёт по стоимости добавлен");
        return this;
    }

    public void switchToEmailPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minemail.com/");
    }

    public CalculatorPage clickEmailEstimate() {
        waitForElementToBeClickable(driver, emailButton);
        clickThroughJS(emailButton);
        return this;
    }

    public CalculatorPage inputEmail() {
        waitPresenceOfElementLocated(driver, EMAIL_INPUT_BOX);
        emailInput.sendKeys(Keys.LEFT_CONTROL, "v");
        return this;
    }

    public CalculatorPage sendEmail() {
        waitPresenceOfElementLocated(driver, SEND_EMAIL_BUTTON);
        clickThroughJS(sendEmailButton);
        return this;
    }

    public void clickThroughJS(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", webElement);
    }

    public String getCost() {
        waitPresenceOfElementLocated(driver, COST_FROM_ESTIMATE);
        return costFromEstimate.getText();
    }

    public String getValueOfVMMachine() {
        waitPresenceOfElementLocated(driver, VALUE_OF_VM_TYPE_FROM_ESTIMATE);
        return driver.findElement(VALUE_OF_VM_TYPE_FROM_ESTIMATE).getText();
    }

    public String getValueOfInstanceType() {
        waitPresenceOfElementLocated(driver, VALUE_OF_INSTANCE_TYPE_FROM_ESTIMATE);
        return driver.findElement(VALUE_OF_INSTANCE_TYPE_FROM_ESTIMATE).getText();
    }

    public String getValueOfRegion() {
        waitPresenceOfElementLocated(driver, VALUE_OF_REGION_FROM_ESTIMATE);
        return driver.findElement(VALUE_OF_REGION_FROM_ESTIMATE).getText();
    }

    public String getValueOfLocalSSD() {
        waitPresenceOfElementLocated(driver, VALUE_OF_LOCAL_SSD_FROM_ESTIMATE);
        return driver.findElement(VALUE_OF_LOCAL_SSD_FROM_ESTIMATE).getText();
    }

    public String getCommitmentTerm() {
        waitPresenceOfElementLocated(driver, VALUE_OF_COMMITMENT_TERM_FROM_ESTIMATE);
        return driver.findElement(VALUE_OF_COMMITMENT_TERM_FROM_ESTIMATE).getText();
    }


}
