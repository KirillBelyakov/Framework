package test;

import org.testng.TestNG;

public class TestRunner {

    public static void main(String[] args) {

        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{CheckSetupFromEstimate.class});
    }
}
