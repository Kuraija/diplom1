package group.proga;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import group.proga.dbthings.DatabaseHandler;
import group.proga.entities.smallHourlyStudio;
import group.proga.entities.smallService;
import group.proga.entities.smallSubject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class TableViewHourlyStudiosController {

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
    private Button DeleteHStudioButton;

    @FXML
    private MenuItem EmployeesMenuItem;

    @FXML
    private MenuItem ExportTableMenuItem;

    @FXML
    private MenuItem FormerPupilsMenuItem;

    @FXML
    private MenuItem GroupStudiosMenuItem;

    @FXML
    private MenuItem HourlyStudiosMenuItem;

    @FXML
    private Button NewHStudioButton;

    @FXML
    private MenuItem OpenNewTablesMenuItem;

    @FXML
    private MenuItem OpenOldMenuItem;

    @FXML
    private MenuItem PupilsMenuItem;

    @FXML
    private MenuItem ServicesMenuItem;

    @FXML
    private MenuItem SubjectsMenuItem;

    @FXML
    private Menu TablesMenu;

    @FXML
    private Button editHStudioButton;

    @FXML
    private AnchorPane mainMenuAnchorPane;

    @FXML
    private AnchorPane mainMenuAnchorPane1;

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

    }

    @FXML
    void openEmployeesTable(ActionEvent event) {

    }

    @FXML
    void openExportTable(ActionEvent event) {

    }

    @FXML
    void openFoprmerPupilsTable(ActionEvent event) {

    }

    @FXML
    void openGroupStudiosTable(ActionEvent event) {

    }

    @FXML
    void openHourlyStudiosTable(ActionEvent event) {

    }

    @FXML
    void openNewAccountantTables(ActionEvent event) {

    }

    @FXML
    void openOldAccountantTable(ActionEvent event) {

    }

    @FXML
    void openServicesTable(ActionEvent event) {

    }

    @FXML
    void openSubjectsTable(ActionEvent event) {

    }

    @FXML
    private TableView<smallHourlyStudio> HourlyStudiosTableView;

    @FXML
    private TableColumn<smallHourlyStudio, String> hStudio_NameColumn;

    @FXML
    private TableColumn<smallHourlyStudio, CheckBox> hStudio_TickColumn;

    @FXML
    private TableColumn<smallHourlyStudio, String> idHstudio_invisColumn;

    ObservableList<smallHourlyStudio> obsList = FXCollections.observableArrayList();

    @FXML
    void createNewHStudio(ActionEvent event) {

    }

    @FXML
    void deleteHstudio(ActionEvent event) {
        System.out.println(" you clicked  deleteHstudio");
//!!!!!!!!!!! I need here a pop up message of "are you sure?"
        ObservableList<smallHourlyStudio> removeThese = FXCollections.observableArrayList();
        String delID;//ID to delete from database
        for (smallHourlyStudio oneRow : obsList){
            if (oneRow.getHStudioTick().isSelected()){
                removeThese.add(oneRow);
                System.out.println("---------------remove them ---------------------------");
            }
        }
        obsList.removeAll(removeThese);
        if (!removeThese.isEmpty()) {
            //if to delete picked out from database
            System.out.println("in IF del list is not empty:");
            DatabaseHandler dbHandler = new DatabaseHandler();
            Connection con = null;
            try {
                con = dbHandler.getDbConnection();
                for (smallHourlyStudio oneRow : removeThese) {
                    System.out.println("Now prrrrrrrrrrrrrrrrint one ROW ID:");
                    System.out.println(oneRow.getHStudioID());
                    delID = oneRow.getHStudioID();
                    //sql
                    //DELETE FROM `tbl_studio_hourly` WHERE `id_studio_hourly` = 4;
                    con.createStatement().executeUpdate("DELETE FROM `tbl_studio_hourly` WHERE `id_studio_hourly` = "+delID+";");
                }}
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            removeThese.clear();
            if (!removeThese.isEmpty()){
                System.out.println("ERRRRROR!!!!!!! for some reason delete list did not get cleared?!?!?!?");
            }
        }
        else{
            //nothing to delete message?
        }
    }

    @FXML
    void editHStudio(ActionEvent event) {

    }


    @FXML
    void initialize() {
        assert CalendarMenuItem != null : "fx:id=\"CalendarMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert CatalogsMenu != null : "fx:id=\"CatalogsMenu\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert ClassMenuItem != null : "fx:id=\"ClassMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert DeleteHStudioButton != null : "fx:id=\"DeleteHStudioButton\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert EmployeesMenuItem != null : "fx:id=\"EmployeesMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert ExportTableMenuItem != null : "fx:id=\"ExportTableMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert FormerPupilsMenuItem != null : "fx:id=\"FormerPupilsMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert GroupStudiosMenuItem != null : "fx:id=\"GroupStudiosMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert HourlyStudiosMenuItem != null : "fx:id=\"HourlyStudiosMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert HourlyStudiosTableView != null : "fx:id=\"HourlyStudiosTableView\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert NewHStudioButton != null : "fx:id=\"NewHStudioButton\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert OpenNewTablesMenuItem != null : "fx:id=\"OpenNewTablesMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert OpenOldMenuItem != null : "fx:id=\"OpenOldMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert PupilsMenuItem != null : "fx:id=\"PupilsMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert ServicesMenuItem != null : "fx:id=\"ServicesMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert SubjectsMenuItem != null : "fx:id=\"SubjectsMenuItem\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert TablesMenu != null : "fx:id=\"TablesMenu\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert editHStudioButton != null : "fx:id=\"editHStudioButton\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert hStudio_NameColumn != null : "fx:id=\"hStudio_NameColumn\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert hStudio_TickColumn != null : "fx:id=\"hStudio_TickColumn\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert idHstudio_invisColumn != null : "fx:id=\"idHstudio_invisColumn\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert mainMenuAnchorPane != null : "fx:id=\"mainMenuAnchorPane\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert mainMenuAnchorPane1 != null : "fx:id=\"mainMenuAnchorPane1\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";
        assert mainMenuBar != null : "fx:id=\"mainMenuBar\" was not injected: check your FXML file 'TableViewHourlyStudios.fxml'.";


        //my code to fill up table:::::::::::::::
        System.out.println("now to fill table from DB");
        DatabaseHandler dbHandler = new DatabaseHandler();
        Connection con = null;
        try {
            con = dbHandler.getDbConnection();
            /*
            SELECT id_studio_hourly, name_studio_hourly
            FROM progschema.tbl_studio_hourly
            ORDER BY name_studio_hourly ASC;
            */
            ResultSet rs = con.createStatement().executeQuery("SELECT id_studio_hourly, name_studio_hourly FROM progschema.tbl_studio_hourly ORDER BY name_studio_hourly ASC;");
            while (rs.next()) {
                System.out.println("in a while of H studios");
                obsList.add(new smallHourlyStudio(rs.getString("id_studio_hourly"),rs.getString("name_studio_hourly")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        hStudio_TickColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,CheckBox>("hStudioTick"));
        idHstudio_invisColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,String>("hStudioID"));
        hStudio_NameColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,String>("hStudioName"));
        HourlyStudiosTableView.setItems( obsList);

    }

}

