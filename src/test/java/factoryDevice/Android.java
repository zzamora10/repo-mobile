package factoryDevice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.GetProperties;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Android implements IDevice{
    @Override
    public AppiumDriver create() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", GetProperties.getInstance().getAppiumDeviceName());
        capabilities.setCapability("appium:platformVersion",GetProperties.getInstance().getAppiumPlatformVersion());
        capabilities.setCapability("appium:appPackage", getInstance().getAppiumAppPackage());
        capabilities.setCapability("appium:appActivity",GetProperties.getInstance().getAppiumAppActivity());
        capabilities.setCapability("platformName",GetProperties.getInstance().getAppiumPlatformName());
        capabilities.setCapability("appium:automationName",GetProperties.getInstance().getAppiumAutomationName());
        AndroidDriver android = null;
        try {
            android = new AndroidDriver(new URL(GetProperties.getInstance().getAppiumUrl()),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        android.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return android;
    }

    private static GetProperties getInstance() {
        return GetProperties.getInstance();
    }
}