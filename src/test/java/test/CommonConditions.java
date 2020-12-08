package test;


import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.GoogleCloudHomePage;
import util.TestListener;

@Listeners({TestListener.class})

public class CommonConditions {
    protected WebDriver driver;

    @BeforeClass()
    public void setUpBrowser() {
        driver = DriverSingleton.getDriver();
        new GoogleCloudHomePage(driver).openPage()
                .clickSearchButton()
                .inputSearchQuery()
                .pickQueryResult()
                .frameSwitch()
                .setNumberOfInstances()
                .setOperatingSystem()
                .setMachineClass()
                .setMachineSeries()
                .setMachineType()
                .addGPUMark()
                .setNumberOfGPU()
                .setGPUType()
                .setLocalSSD()
                .setDatacenterLocation()
                .setCommittedUsage()
                .addToEstimate();
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
        DriverSingleton.closeDriver();
    }
}
