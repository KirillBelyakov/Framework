package service;

import models.Calculator;

public class GeneratorXpath {
    private Calculator calculator = CalculatorCreator.withCredentialsFromProperty();

    public String getXpathForOperatingSystemValue() {
        return String.format("//md-option/div[text()[contains(.,'%s')]]", calculator.getOperatingSystem());
    }

    public String getXpathForMachineClass() {
        return String.format("//div[@class='md-select-menu-container md-active md-clickable']//div[text()='%s']",
                calculator.getMachineClass());
    }

    public String getXpathForMachineSeries() {
        return String.format("//*[@id='select_option_187']//div[contains(text(),'%s')]", calculator.getMachineSeries());
    }

    public String getXpathForMachineType() {
        return String.format("//md-option//div[text()[contains(.,'%s')]]", calculator.getMachineType());
    }

    public String getXpathForNumberOfGpus() {
        return String.format("//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s']",
                calculator.getNumberOfGpu());
    }

    public String getXpathForGpuType() {
        return String.format("//md-option//div[text()[contains(.,'%s')]]", calculator.getGpuType());
    }

    public String getXpathForLocalSSD() {
        return String.format("//md-option//div[text()[contains(.,'%s')]]", calculator.getLocalSSD());
    }

    public String getXpathForDatacenterLocation() {
        return String.format("//div[@id='select_container_91']//div[text()[contains(.,'%s')]]",
                calculator.getDatacenterLocation());
    }

    public String getXpathForCommitedUsage() {
        return String.format("//div[@id='select_container_98']//div[text()[contains(.,'%s')]]",
                calculator.getCommittedUsage());
    }
}
