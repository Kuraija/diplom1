package group.proga;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HiController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem CalendarMenuItem;

    @FXML
    private Menu CatalogsMenu;

    @FXML
    private MenuItem ClassMenuItem;

    @FXML
    private MenuItem EmployeesMenuItem;

    @FXML
    private MenuItem ExportTableMenuItem;

    @FXML
    private MenuItem FormerPupilsMenuItem;

    @FXML
    private MenuItem OpenNewTablesMenuItem;

    @FXML
    private MenuItem OpenOldMenuItem;

    @FXML
    private MenuItem PupilsMenuItem;

    @FXML
    private MenuItem GroupStudiosMenuItem;
    @FXML
    private MenuItem HourlyStudiosMenuItem;
    @FXML
    private MenuItem ServicesMenuItem;
    @FXML
    private MenuItem SubjectsMenuItem;

    @FXML
    private Menu TablesMenu;

    @FXML
    private Label hiLabel;

    @FXML
    private AnchorPane mainMenuAnchorPane;

    @FXML
    private MenuBar mainMenuBar;

    @FXML
    void openCalendar(ActionEvent event) {

    }

    @FXML
    void openClassesTable(ActionEvent event) {

    }

    @FXML
    void openCurrentPupilsTable(ActionEvent event) {
        hiLabel.getScene().getWindow().hide();
        group.proga.Menu mymenu = new group.proga.Menu();
        mymenu.openCurrentPupilsTable();
    }

    @FXML
    void openEmployeesTable(ActionEvent event) {
        hiLabel.getScene().getWindow().hide();
        group.proga.Menu mymenu = new group.proga.Menu();
        mymenu.openEmployeesTable();
    }

    @FXML
    void openExportTable(ActionEvent event) {

    }

    @FXML
    void openFoprmerPupilsTable(ActionEvent event) {
        hiLabel.getScene().getWindow().hide();
        group.proga.Menu mymenu = new group.proga.Menu();
        mymenu.openOldPupilsTable();
    }

    @FXML
    void openNewAccountantTables(ActionEvent event) {

    }

    @FXML
    void openOldAccountantTable(ActionEvent event) {

    }

    @FXML
    void openSubjectsTable(ActionEvent event) {
        hiLabel.getScene().getWindow().hide();
        group.proga.Menu mymenu = new group.proga.Menu();
        mymenu.openSubjectsTable();
    }
    @FXML
    void openGroupStudiosTable(ActionEvent event) {
        hiLabel.getScene().getWindow().hide();
        group.proga.Menu mymenu = new group.proga.Menu();
        mymenu.openGroupStudiosTable();
    }

    @FXML
    void openHourlyStudiosTable(ActionEvent event) {
        hiLabel.getScene().getWindow().hide();
        group.proga.Menu mymenu = new group.proga.Menu();
        mymenu.openHourlyStudiosTable();
    }
    @FXML
    void openServicesTable(ActionEvent event) {
        hiLabel.getScene().getWindow().hide();
        group.proga.Menu mymenu = new group.proga.Menu();
        mymenu.openServicesTable();
    }


    @FXML
    void initialize() {
        assert CalendarMenuItem != null : "fx:id=\"CalendarMenuItem\" was not injected: check your FXML file 'hi.fxml'.";
        assert CatalogsMenu != null : "fx:id=\"CatalogsMenu\" was not injected: check your FXML file 'hi.fxml'.";
        assert ClassMenuItem != null : "fx:id=\"ClassMenuItem\" was not injected: check your FXML file 'hi.fxml'.";
        assert EmployeesMenuItem != null : "fx:id=\"EmployeesMenuItem\" was not injected: check your FXML file 'hi.fxml'.";
        assert ExportTableMenuItem != null : "fx:id=\"ExportTableMenuItem\" was not injected: check your FXML file 'hi.fxml'.";
        assert FormerPupilsMenuItem != null : "fx:id=\"FormerPupilsMenuItem\" was not injected: check your FXML file 'hi.fxml'.";
        assert OpenNewTablesMenuItem != null : "fx:id=\"OpenNewTablesMenuItem\" was not injected: check your FXML file 'hi.fxml'.";
        assert OpenOldMenuItem != null : "fx:id=\"OpenOldMenuItem\" was not injected: check your FXML file 'hi.fxml'.";
        assert PupilsMenuItem != null : "fx:id=\"PupilsMenuItem\" was not injected: check your FXML file 'hi.fxml'.";
        assert SubjectsMenuItem != null : "fx:id=\"SubjectsMenuItem\" was not injected: check your FXML file 'hi.fxml'.";
        assert TablesMenu != null : "fx:id=\"TablesMenu\" was not injected: check your FXML file 'hi.fxml'.";
        assert hiLabel != null : "fx:id=\"hiLabel\" was not injected: check your FXML file 'hi.fxml'.";
        assert mainMenuAnchorPane != null : "fx:id=\"mainMenuAnchorPane\" was not injected: check your FXML file 'hi.fxml'.";
        assert mainMenuBar != null : "fx:id=\"mainMenuBar\" was not injected: check your FXML file 'hi.fxml'.";

    }

}

