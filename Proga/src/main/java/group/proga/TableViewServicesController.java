package group.proga;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import group.proga.dbthings.DatabaseHandler;
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

public class TableViewServicesController {

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
    private Button DeleteServiceButton;

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
    private Button NewServiceButton;

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
    private Button editServiceButton;

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
    private TableView<smallService> ServicesTableView;

    @FXML
    private TableColumn<smallService, String> idService_invisColumn;

    @FXML
    private TableColumn<smallService, String> service_NameColumn;

    @FXML
    private TableColumn<smallService, CheckBox> service_TickColumn;

    ObservableList<smallService> obsList = FXCollections.observableArrayList();

    @FXML
    void createNewService(ActionEvent event) {

    }

    @FXML
    void deleteService(ActionEvent event) {
        System.out.println(" you clicked  deleteService");
//!!!!!!!!!!! I need here a pop up message of "are you sure?"
        ObservableList<smallService> removeThese = FXCollections.observableArrayList();
        String delID;//ID to delete from database
        for (smallService oneRow : obsList){
            if (oneRow.getServiceTick().isSelected()){
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
                for (smallService oneRow : removeThese) {
                    System.out.println("Now prrrrrrrrrrrrrrrrint one ROW ID:");
                    System.out.println(oneRow.getServiceID());
                    delID = oneRow.getServiceID();
                    //sql
                    //DELETE FROM `tbl_service` WHERE `id_service` = 5;
                    con.createStatement().executeUpdate("DELETE FROM `tbl_service` WHERE `id_service` = "+delID+";");
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
    void editService(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert CalendarMenuItem != null : "fx:id=\"CalendarMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert CatalogsMenu != null : "fx:id=\"CatalogsMenu\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert ClassMenuItem != null : "fx:id=\"ClassMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert DeleteServiceButton != null : "fx:id=\"DeleteServiceButton\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert EmployeesMenuItem != null : "fx:id=\"EmployeesMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert ExportTableMenuItem != null : "fx:id=\"ExportTableMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert FormerPupilsMenuItem != null : "fx:id=\"FormerPupilsMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert GroupStudiosMenuItem != null : "fx:id=\"GroupStudiosMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert HourlyStudiosMenuItem != null : "fx:id=\"HourlyStudiosMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert NewServiceButton != null : "fx:id=\"NewServiceButton\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert OpenNewTablesMenuItem != null : "fx:id=\"OpenNewTablesMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert OpenOldMenuItem != null : "fx:id=\"OpenOldMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert PupilsMenuItem != null : "fx:id=\"PupilsMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert ServicesMenuItem != null : "fx:id=\"ServicesMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert ServicesTableView != null : "fx:id=\"ServicesTableView\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert SubjectsMenuItem != null : "fx:id=\"SubjectsMenuItem\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert TablesMenu != null : "fx:id=\"TablesMenu\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert editServiceButton != null : "fx:id=\"editServiceButton\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert idService_invisColumn != null : "fx:id=\"idService_invisColumn\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert mainMenuAnchorPane != null : "fx:id=\"mainMenuAnchorPane\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert mainMenuAnchorPane1 != null : "fx:id=\"mainMenuAnchorPane1\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert mainMenuBar != null : "fx:id=\"mainMenuBar\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert service_NameColumn != null : "fx:id=\"service_NameColumn\" was not injected: check your FXML file 'TableViewServices.fxml'.";
        assert service_TickColumn != null : "fx:id=\"service_TickColumn\" was not injected: check your FXML file 'TableViewServices.fxml'.";


        //my code to fill up table:::::::::::::::
        System.out.println("now to fill table from DB");
        DatabaseHandler dbHandler = new DatabaseHandler();
        Connection con = null;
        try {
            con = dbHandler.getDbConnection();
            /*
            SELECT id_service, service_name
            FROM progschema.tbl_service
            ORDER BY service_name ASC;
            */
            ResultSet rs = con.createStatement().executeQuery("SELECT id_service, service_name FROM progschema.tbl_service ORDER BY service_name ASC;");
            while (rs.next()) {
                System.out.println("in a while of ServiceTable");
                obsList.add(new smallService(rs.getString("id_service"),rs.getString("service_name")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        service_TickColumn.setCellValueFactory(new PropertyValueFactory<smallService,CheckBox>("serviceTick"));
        idService_invisColumn.setCellValueFactory(new PropertyValueFactory<smallService,String>("serviceID"));
        service_NameColumn.setCellValueFactory(new PropertyValueFactory<smallService,String>("serviceName"));
        ServicesTableView.setItems( obsList);

    }

}

