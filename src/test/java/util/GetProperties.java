package util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private static GetProperties getProperties = null;
    private String device;
    private String appiumUrl;
    private String appiumDeviceName;
    private String appiumPlatformVersion;
    private String appiumPlatformName;
    private String appiumAutomationName;
    private String appiumAppPackage;
    private String appiumAppActivity;

    private GetProperties() {
        Properties properties = new Properties();
        String fileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        try {
            properties.load(inputStream);
            device = properties.getProperty("device");
            appiumUrl= properties.getProperty("appiumUrl");
            appiumDeviceName= properties.getProperty("appiumDeviceName");
            appiumPlatformVersion= properties.getProperty("appiumPlatformVersion");
            appiumPlatformName= properties.getProperty("appiumPlatformName");
            appiumAutomationName= properties.getProperty("appiumAutomationName");
            appiumAppPackage= properties.getProperty("appiumAppPackage");
            appiumAppActivity= properties.getProperty("appiumAppActivity");
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static GetProperties getInstance() {
        if (getProperties == null)
            getProperties = new GetProperties();
        return getProperties;
    }

    public String getDevice() {
        return device;
    }

    public String getAppiumUrl() {
        return appiumUrl;
    }

    public String getAppiumDeviceName() {
        return appiumDeviceName;
    }

    public String getAppiumPlatformVersion() {
        return appiumPlatformVersion;
    }

    public String getAppiumPlatformName() {
        return appiumPlatformName;
    }

    public String getAppiumAutomationName() {
        return appiumAutomationName;
    }

    public String getAppiumAppPackage() {
        return appiumAppPackage;
    }

    public String getAppiumAppActivity() {
        return appiumAppActivity;
    }
}

