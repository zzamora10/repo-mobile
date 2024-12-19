package activities.whenDo;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class CategoryDetailScreen {
    public TextBox titleTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/categoryTitle"));
    public Button colorRedButton = new Button(By.id("com.vrproductiveapps.whendo:id/color_select10"));
    public Button colorBlueButton = new Button(By.id("com.vrproductiveapps.whendo:id/color_select3"));
    public Button colorGreenButton = new Button(By.id("com.vrproductiveapps.whendo:id/color_select5"));
    public Button colorYellowButton = new Button(By.id("com.vrproductiveapps.whendo:id/color_select7"));
    public Button saveButton = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    public Button deleteButton = new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
}
