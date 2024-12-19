package runner;

import activities.whenDo.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class CategoryStep {
    List<String> titulosListMap = new ArrayList<>();
    Map<String, String> variableMap = new HashMap<>();
    TaskListScreen taskListScreen = new TaskListScreen();
    TaskDetailScreen taskDetailScreen = new TaskDetailScreen();
    LeftMenuSection leftMenuSection = new LeftMenuSection();
    CategoryListScreen categoryListScreen = new CategoryListScreen();
    CategoryDetailScreen categoryDetailScreen = new CategoryDetailScreen();
    SyncDialog syncDialog = new SyncDialog();

    @Given("WhenDo App is open")
    public void whendoAppIsOpen() {
    }

    @When("I create a new ListCategory")
    public void iCreateANewListCategory(List<Map<String, String>> datos) {
        //seleccionamos el boton que habilita el menu Lateral
        taskListScreen.sideBarButton.click();
        //damos click en edit List
        leftMenuSection.editCategoryButton.click();

        //para poder ingresar varias listas
        for (Map<String, String> data : datos) {
            //seleccionamos el boton Nueva Lista
            categoryListScreen.addCategoryButton.click();
            //ingresamos el nombre de la nueva lista
            categoryDetailScreen.titleTxtBox.setText(data.get("tituloList"));
            //almacenamos los valores en una array para poder validarlos luego
            titulosListMap.add(data.get("tituloList"));
            //ingresamos el color de la lista
            String color = data.get("color");
            //evaluamos el color indicador para poder seleccionar el boton
            if (color != null) {
                switch (color) {
                    case "rojo":
                        categoryDetailScreen.colorRedButton.click();
                        break;
                    case "azul":
                        categoryDetailScreen.colorBlueButton.click();
                        break;
                    case "verde":
                        categoryDetailScreen.colorGreenButton.click();
                        break;
                    case "amarillo":
                        categoryDetailScreen.colorYellowButton.click();
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("El valor de 'color' es null.");
            }
            //damos click en el boton Guardar
            categoryDetailScreen.saveButton.click();
        }
    }

    @Then("the list should be displayed")
    public void theListShouldBeDisplayed() {
        //recorremos el array con los titulos de la lista
        for (int i = 0; i < titulosListMap.size(); i++) {
            //validamos que las listas fueron creadas
            System.out.println(titulosListMap.get(i));
            Assertions.assertTrue(categoryListScreen.getCategoryListName(titulosListMap.get(i)).isControlDisplayed(),
                    "ERROR la lista no fue creada");
        }
        //regresa a pantalla principal
        categoryListScreen.backButton.click();
    }

    @And("I save random value in {}")
    public void iSaveRandomValueIn(String variableName) {
        variableMap.put(variableName, new Date().getTime() + "");
    }

    @When("I create a new task in list")
    public void iCreateANewTaskInList(Map<String, String> data) {
        //seleccionamos el boton que habilita el menu Lateral
        taskListScreen.sideBarButton.click();

        //buscamos si existe la lista indicada
        if (leftMenuSection.getCategoryNameLeftMenu(getValueCategory(data.get("list"))).isFindControl()) {
            //seleccionamos la lista indicada
            leftMenuSection.getCategoryNameLeftMenu(getValueCategory(data.get("list"))).click();
        } else {

            taskListScreen.searchButton.click();

            // Crear la lista y agregar valores
            List<Map<String, String>> newdatos = new ArrayList<>();
            Map<String, String> map1 = new HashMap<>();
            map1.put("tituloList", getValueCategory(data.get("list")));
            map1.put("color", "rojo");
            newdatos.add(map1);

            //si no existe la creamos reutilizando el metodo de creacion de listCategory
            iCreateANewListCategory(newdatos);
            //regresa a pantalla principal
            categoryListScreen.backButton.click();
            //seleccionamos el boton que habilita el menu Lateral
            taskListScreen.sideBarButton.click();
            //ingresamos en la lista creada
            leftMenuSection.getCategoryNameLeftMenu(getValueCategory(data.get("list"))).click();
        }

        //registramos la tarea
        taskListScreen.addTaskButton.click();
        taskDetailScreen.titleTxtBox.setText(getValueCategory(data.get("task")));
        taskDetailScreen.noteTxtBox.setText(getValueCategory(data.get("note")));
        taskDetailScreen.saveButton.click();
    }

    @Then("the task {string} should be displayed")
    public void theTaskShouldBeDisplayed(String expectedResult) {
        Assertions.assertTrue(taskListScreen.getTaskName(getValueCategory(expectedResult)).isControlDisplayed(),
                "ERROR la tarea no fue creada");
    }

    private String getValueCategory(String value) {
        for (String key : variableMap.keySet()) {
            value = value.replace(key, variableMap.get(key));
        }
        return value;
    }

}