package singletonSession;

import factoryDevice.FactoryDevice;
import io.appium.java_client.AppiumDriver;
import util.GetProperties;

public class Session {
    //  tener un attribute del mismo tipo de la clase
    private static Session session = null;
    private AppiumDriver device;
    // constructor privado
    private Session(){
        // todo mover a un archivo property
        device = FactoryDevice.make(GetProperties.getInstance().getDevice()).create();
    }
    // metodo estatico public -> acceso global
    public static Session getInstance(){
        if (session == null)
            session = new Session();
        return session;
    }

    public void closeSession(){
        device.quit();
        session = null;
    }

    public AppiumDriver getDevice(){
        return device;
    }
}

