package pageObjectsTests;

import base.CommonAPI;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomLister extends CommonAPI implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("User wants to know all of the Failed tests on April 11,2021");
        failedTest(result.getMethod().getMethodName());
    }
}
