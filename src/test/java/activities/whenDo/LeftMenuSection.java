package activities.whenDo;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;


public class LeftMenuSection {

    public Button allTaskButton = new Button(By.xpath("//android.widget.CheckedTextView[@resource-id=\"com.vrproductiveapps.whendo:id/design_menu_item_text\" and @text=\"All Tasks\"]"));
    public Button editCategoryButton = new Button(By.xpath("//android.widget.CheckedTextView[@resource-id=\"com.vrproductiveapps.whendo:id/design_menu_item_text\" and @text=\"Edit Lists\"]"));

    public Button machineButton = new Button(By.xpath("//android.widget.CheckedTextView[@resource-id=\"com.vrproductiveapps.whendo:id/design_menu_item_text\" and @text=\"Manage Notebooks\"]"));

    public Label getCategoryNameLeftMenu(String name) {
        Label control = new Label(By.xpath("//android.widget.CheckedTextView[@text='" + name + "']"));
        return control;
    }
}