package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import singletonSession.Session;

import java.time.Duration;
import java.util.List;

public class AppiumControl {
    protected By locator;
    protected WebElement control;
    public AppiumControl(By locator) {
        this.locator = locator;
    }
    public void findControl() {
        control = Session.getInstance().getDevice().findElement(locator);
    }
    public void click() {
        findControl();
        control.click();
    }
    public String getText() {
        findControl();
        return control.getText();
    }
    public boolean isControlDisplayed() {
        try {
            findControl();
            return control.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void findListControls() {
        Duration originalTimeout = Session.getInstance().getDevice().manage().timeouts().getImplicitWaitTimeout();
        // Reducir espera implícita
        Session.getInstance().getDevice().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // Realizar la búsqueda
        control = Session.getInstance().getDevice().findElement(locator);
        // Restaurar la configuración de la espera implícita original
        Session.getInstance().getDevice().manage().timeouts().implicitlyWait(originalTimeout);
    }

    public boolean isFindControl() {
        try {
            findListControls();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
