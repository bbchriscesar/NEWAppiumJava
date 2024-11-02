package com.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSettingsAutomation {
    public static void main(String[] args) {

        UiAutomator2Options options = getUiAutomator2Options();
        AppiumDriver driver = null;

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
            Thread.sleep(4000);

            // Scroll to a specific text
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().textContains(\"Accessibility\"))"));

            Thread.sleep(2000);

            // Scroll to end of page
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollToEnd(10)"));

            Thread.sleep(2000);

            // Scroll back to top
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollToBeginning(10)"));

            Thread.sleep(2000);

            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Apps\"]")).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();

            Thread.sleep(2000);


        } catch (MalformedURLException | InterruptedException e) {
            System.out.println("Exception occurred: " + e.getMessage());

        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private static UiAutomator2Options getUiAutomator2Options() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Android Emulator");
        options.setAppPackage("com.android.settings");
        options.setAppActivity(".Settings");
        options.setAutomationName("UiAutomator2");
        options.setUdid("emulator-5554");
        options.setPlatformVersion("15");
        return options;
    }
}