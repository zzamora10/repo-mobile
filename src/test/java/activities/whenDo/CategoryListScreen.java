package activities.whenDo;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class CategoryListScreen {
    public Button addCategoryButton = new Button(By.id("com.vrproductiveapps.whendo:id/addCategoryItem"));
    public Button backButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));

    public Label getCategoryListName(String name){
        Label control = new Label(By.xpath("//android.widget.TextView[@text='"+name+"']"));
        return control;
    }
}
