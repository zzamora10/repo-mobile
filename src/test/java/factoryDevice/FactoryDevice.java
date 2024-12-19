package factoryDevice;

import java.util.HashMap;
import java.util.Map;

public class FactoryDevice {
    public static IDevice make(String deviceType){
        Map<String,IDevice> deviceMap=new HashMap<>();
        deviceMap.put("android",new Android());
        deviceMap.put("cloud",new AndroidCloud());
        deviceMap.put("ios",new Ios());

        return deviceMap.containsKey(deviceType.toLowerCase())?
                deviceMap.get(deviceType.toLowerCase()):
                deviceMap.get("android");
    }
}
