package group.proga;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import group.proga.dbthings.DatabaseHandler;
import group.proga.entities.Employee;
import group.proga.entities.smallGroupStudio;
import group.proga.entities.smallHourlyStudio;
import group.proga.entities.smallSubject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class TableViewGroupStudiosController {

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
    private Button DeleteGStudioButton;

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
    private Button NewGStudioButton;

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
    private Button editGStudioButton;

    @FXML
    private AnchorPane mainMenuAnchorPane;

    @FXML
    private AnchorPane mainMenuAnchorPane1;

    @FXML
    private MenuBar mainMenuBar;

    @FXML
    private TableView<smallGroupStudio> GStudiosTableView;

    @FXML
    private TableColumn<smallGroupStudio, String> gStudio_NameColumn;

    @FXML
    private TableColumn<smallGroupStudio, CheckBox> gStudio_TickColumn;

    @FXML
    private TableColumn<smallGroupStudio, String> idGStudio_invisColumn;



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
    void deleteGStudio(ActionEvent event) {
        System.out.println(" you clicked  deleteGStudio");
//!!!!!!!!!!! I need here a pop up message of "are you sure?"
        ObservableList<smallGroupStudio> removeThese = FXCollections.observableArrayList();
        String delID;//ID to delete from database
        for (smallGroupStudio oneRow : obsList){
            if (oneRow.getGStudioTick().isSelected()){
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
                for (smallGroupStudio oneRow : removeThese) {
                    System.out.println("Now prrrrrrrrrrrrrrrrint one ROW ID:");
                    System.out.println(oneRow.getGStudioID());
                    delID = oneRow.getGStudioID();
                    //sql
                    //DELETE FROM `tbl_group_studios` WHERE `id_group_studios` = 5;
                    con.createStatement().executeUpdate("DELETE FROM `tbl_group_studios` WHERE `id_group_studios` = "+delID+";");
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
    void createNewGStudio(ActionEvent event) {

    }


    @FXML
    void editGstudio(ActionEvent event) {

    }

    ObservableList<smallGroupStudio> obsList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        assert CalendarMenuItem != null : "fx:id=\"CalendarMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert CatalogsMenu != null : "fx:id=\"CatalogsMenu\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert ClassMenuItem != null : "fx:id=\"ClassMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert DeleteGStudioButton != null : "fx:id=\"DeleteGStudioButton\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert EmployeesMenuItem != null : "fx:id=\"EmployeesMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert ExportTableMenuItem != null : "fx:id=\"ExportTableMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert FormerPupilsMenuItem != null : "fx:id=\"FormerPupilsMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert GStudiosTableView != null : "fx:id=\"GStudiosTableView\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert GroupStudiosMenuItem != null : "fx:id=\"GroupStudiosMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert HourlyStudiosMenuItem != null : "fx:id=\"HourlyStudiosMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert NewGStudioButton != null : "fx:id=\"NewGStudioButton\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert OpenNewTablesMenuItem != null : "fx:id=\"OpenNewTablesMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert OpenOldMenuItem != null : "fx:id=\"OpenOldMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert PupilsMenuItem != null : "fx:id=\"PupilsMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert ServicesMenuItem != null : "fx:id=\"ServicesMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert SubjectsMenuItem != null : "fx:id=\"SubjectsMenuItem\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert TablesMenu != null : "fx:id=\"TablesMenu\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert editGStudioButton != null : "fx:id=\"editGStudioButton\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert gStudio_NameColumn != null : "fx:id=\"gStudio_NameColumn\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert gStudio_TickColumn != null : "fx:id=\"gStudio_TickColumn\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert idGStudio_invisColumn != null : "fx:id=\"idGStudio_invisColumn\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert mainMenuAnchorPane != null : "fx:id=\"mainMenuAnchorPane\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert mainMenuAnchorPane1 != null : "fx:id=\"mainMenuAnchorPane1\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";
        assert mainMenuBar != null : "fx:id=\"mainMenuBar\" was not injected: check your FXML file 'TableViewGroupStudios.fxml'.";


        //my code to fill up table:::::::::::::::
        System.out.println("now to fill table from DB");
        DatabaseHandler dbHandler = new DatabaseHandler();
        Connection con = null;
        try {
            con = dbHandler.getDbConnection();
            /*
            SELECT id_group_studios, group_studios_name
            FROM progschema.tbl_group_studios
            ORDER BY group_studios_name ASC;
            */
            ResultSet rs = con.createStatement().executeQuery("SELECT id_group_studios, group_studios_name FROM progschema.tbl_group_studios ORDER BY group_studios_name ASC;");
            while (rs.next()) {
                System.out.println("in a while of g studios tbl");
                obsList.add(new smallGroupStudio(rs.getString("id_group_studios"),rs.getString("group_studios_name")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        gStudio_TickColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,CheckBox>("gStudioTick"));
        idGStudio_invisColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,String>("gStudioID"));
        gStudio_NameColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,String>("gStudioName"));
        GStudiosTableView.setItems( obsList);

    }

}

