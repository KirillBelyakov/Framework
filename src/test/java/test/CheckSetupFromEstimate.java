package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CalculatorPage;
import service.TestDataReader;

import static org.testng.Assert.assertTrue;

public class CheckSetupFromEstimate extends CommonConditions {

    @Test
    public void checkCorrectFilling() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new CalculatorPage(driver).getValueOfVMMachine()
                        .contains(TestDataReader.getTestData("testData.valueOfMachineClass").toLowerCase()),
                "значение VM установлено не верно");
        softAssert.assertTrue(new CalculatorPage(driver).getValueOfInstanceType()
                        .contains(TestDataReader.getTestData("testData.valueOfMachineType")),
                "значение Machine Type установлено не верно");
        softAssert.assertTrue(new CalculatorPage(driver).getValueOfRegion()
                        .contains(TestDataReader.getTestData("testData.valueOfDatacenterLocation")),
                "значение DatacenterLocation установлено не верно");
        assertTrue(new CalculatorPage(driver).getValueOfLocalSSD()
                        .contains(TestDataReader.getTestData("testData.valueOfLocalSSD")),
                "значение LocalSSD установлено не верно");
        softAssert.assertTrue(new CalculatorPage(driver).getCommitmentTerm()
                        .contains(TestDataReader.getTestData("testData.valueOfCommittedUsage")),
                "значение Committed Usage установлено не верно");
        softAssert.assertTrue(new CalculatorPage(driver).getCost()
                        .contains(TestDataReader.getTestData("testData.cost")),
                "значение стоимости не верно");
        softAssert.assertAll();
    }
}
