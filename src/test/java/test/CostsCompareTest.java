package test;

import org.testng.annotations.Test;
import pages.CalculatorPage;
import pages.EmailGenerationPage;

import static org.testng.Assert.assertTrue;

public class CostsCompareTest extends CommonConditions {

    @Test
    public void costCompareTest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        String costEstimate = new CalculatorPage(driver).getCost();
        calculatorPage.switchToEmailPage();
        new EmailGenerationPage(driver).copyEmail().switchToCalculatorPage();
        calculatorPage.frameSwitch().clickEmailEstimate().inputEmail().sendEmail().switchToEmailPage();
        String costFromEmail = new EmailGenerationPage(driver).openEmail().getCostFromEmail();
        assertTrue(costEstimate.contains(costFromEmail), "Значения стоимости не равны");
    }
}
