package controls;

import org.openqa.selenium.By;

public class ComboBox extends AppiumControl{
    private String option;

    public ComboBox(By locator) {
        super(locator);
    }
    //   //android.widget.CheckedTextView[@text='{0}']"
    public ComboBox(By locator , String locatorOption) {
        super(locator);
        option = locatorOption;
    }

    public void select(String value){
        findControl();
        control.click();
        Label optionControl = new Label(By.xpath(String.format(option,value)));
        optionControl.click();
    }
}
