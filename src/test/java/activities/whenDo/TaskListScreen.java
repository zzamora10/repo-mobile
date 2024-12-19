package activities.whenDo;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class TaskListScreen {

    public Button addTaskButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    public Button searchButton = new Button(By.id("com.vrproductiveapps.whendo:id/search"));
    public Button sideBarButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]"));

    public Label getTaskName(String name){
        Label control = new Label(By.xpath("//android.widget.TextView[@text='"+name+"']"));
        return control;
    }
}