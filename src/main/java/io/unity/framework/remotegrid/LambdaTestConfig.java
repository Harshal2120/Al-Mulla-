package io.unity.framework.remotegrid;

import io.unity.framework.readers.json_file_readers;
import io.unity.framework.runner.TestRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LambdaTestConfig {

    WebDriver driver;

    public LambdaTestConfig(WebDriver driver) {

        this.driver = driver;
    }


    public void addTestName(String TestName) {

        json_file_readers config = new json_file_readers();

        if (config.getPlatform(TestRunner.currentConfig).equalsIgnoreCase("web")) {
            if (config.get_grid_platForm(TestRunner.currentConfig).equalsIgnoreCase("lambdatest")) {

                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("lambda-name=" + TestName + "");

            }

        }

        if (config.getPlatform(TestRunner.currentConfig).equalsIgnoreCase("android") || config.getPlatform(TestRunner.currentConfig).equalsIgnoreCase("ios")) {
            if (config.get_appium_platform(TestRunner.currentConfig).equalsIgnoreCase("lambdatest")) {

                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("lambda-name=" + TestName + "");

            }

        }


    }

    public void markTestPassed() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("lambda-status=passed");
    }

    public void markTestFailed() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("lambda-status=failed");
    }
}


