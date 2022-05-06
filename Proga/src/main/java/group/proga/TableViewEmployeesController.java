package group.proga;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import group.proga.dbthings.DatabaseHandler;
import group.proga.entities.Employee;
import group.proga.entities.Pupil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TableViewEmployeesController {

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
    private Button DeleteButton;

    @FXML
    private Button EditButton;

    @FXML
    private MenuItem EmployeesMenuItem;

    @FXML
    private MenuItem ExportTableMenuItem;

    @FXML
    private MenuItem FormerPupilsMenuItem;

    @FXML
    private Button NewEmployeeButton;

    @FXML
    private MenuItem OpenNewTablesMenuItem;

    @FXML
    private MenuItem OpenOldMenuItem;

    @FXML
    private MenuItem PupilsMenuItem;

    @FXML
    private MenuItem SubjectsMenuItem;

    @FXML
    private Menu TablesMenu;

    @FXML
    private TableView<Employee> EmployeeListTableView;

    @FXML
    private TableColumn<Employee, String> employeeID_invisbl_Column;

    @FXML
    private TableColumn<Employee, CheckBox> tickColumn;

    @FXML
    private TableColumn<Employee, String> employeeSurnameColumn;

    @FXML
    private TableColumn<Employee, String> employeeNameColumn;

    @FXML
    private TableColumn<Employee, String> employeeStatussColumn;

    @FXML
    private AnchorPane mainMenuAnchorPane;

    @FXML
    private MenuBar mainMenuBar;


    //---------------------------------
    ObservableList<Employee> empData = FXCollections.observableArrayList();
    private Stage stage;
    private Scene scene;

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
    void openNewAccountantTables(ActionEvent event) {

    }

    @FXML
    void openOldAccountantTable(ActionEvent event) {

    }

    @FXML
    void openSubjectsTable(ActionEvent event) {

    }

    @FXML
    void DeleteThisEmployeeFromDB(ActionEvent event) {

        System.out.println(" you clicked  DeleteThisEmployeeFromDB");
//!!!!!!!!!!! I need here a pop up message of "are you sure?"
        ObservableList<Employee> removeTheseEmployeees = FXCollections.observableArrayList();
        String delID;//ID of pupil to delete from database
        for (Employee oneRow : empData){
            if (oneRow.getEmpTick().isSelected()){
                removeTheseEmployeees.add(oneRow);
                System.out.println("---------------remove them ---------------------------");
            }
        }
        empData.removeAll(removeTheseEmployeees);
        if (!removeTheseEmployeees.isEmpty()) {
            //if to delete picked out students from database

            System.out.println("in IF del list is not empty:");
            DatabaseHandler dbHandler = new DatabaseHandler();
            Connection con = null;
            try {
                con = dbHandler.getDbConnection();
                for (Employee oneRow : removeTheseEmployeees) {
                    System.out.println("Now prrrrrrrrrrrrrrrrint one ROW ID:");
                    System.out.println(oneRow.getEmpID());
                    delID = oneRow.getEmpID();
                    //DELETE FROM `tbl_pupils` WHERE `pupil_id` = delID;
                    con.createStatement().executeUpdate("DELETE FROM `tbl_employees` WHERE `employee_id` = "+delID+";");
                }}
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            removeTheseEmployeees.clear();
            if (!removeTheseEmployeees.isEmpty()){
                System.out.println("ERRRRROR!!!!!!! for some reason delete list did not get cleared?!?!?!?");
            }
        }
        else{
            //nothing to delete message?
        }

    }

    @FXML
    void EditThisEmployee(ActionEvent event) {
        System.out.println(" you clicked  EditThisEmployee");

        ObservableList<Employee> openTheseEmployees = FXCollections.observableArrayList();
        String openID = "";//ID to open from database
        Integer counter =0;
        for (Employee oneRow : empData){
            if (oneRow.getEmpTick().isSelected()){
                openTheseEmployees.add(oneRow);
                counter++;
                openID = oneRow.getEmpID();
                System.out.println("---------------open them ---------------------------");
            }
        }
        if (counter > 1){
            //make pop up message of you need to select only one pupil
            System.out.println("make pop up message of you need to select only one pupil");
        }
        else{
            //else for when selected only one pupil and now can open it:
            if (counter ==1) {
                //OnePupilController oneP = new OnePupilController();//no need anymore
                //save ID to DB
                System.out.println("in IF you picked one pupil to edit:");
                DatabaseHandler dbHandler = new DatabaseHandler();
                Connection con = null;
                try {
                    con = dbHandler.getDbConnection();
                    //INSERT INTO `progschema`.`dump` (`iddump`, `actual_data`) VALUES ('1', 'openID');
                    con.createStatement().executeUpdate("INSERT INTO `progschema`.`dump` (`iddump`, `actual_data`) VALUES ('1', '"+openID+"');");
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                //clean up things:
                openTheseEmployees.clear();
                counter =0;

                //and now to open a window - not pop up:
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("OneEmployee.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    //System.out.println("did (Stage)((Node)event.getSource() for edit");
                    scene = new Scene(root);
                    stage.setScene(scene);
                    //System.out.println("did stage.setScene(scene);");
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                //pop up message that no  pupil was selected
            }
        }
    }

    @FXML
    void createNewEmployee(ActionEvent event) {
        System.out.println(" you clicked  createNewEmployee(ActionEvent event");
        //to open a window - not pop up:
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("OneEmployee.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            //System.out.println("did (Stage)((Node)event.getSource() for create");
            scene = new Scene(root);
            stage.setScene(scene);
            //System.out.println("did stage.setScene(scene);");
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert CalendarMenuItem != null : "fx:id=\"CalendarMenuItem\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert CatalogsMenu != null : "fx:id=\"CatalogsMenu\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert ClassMenuItem != null : "fx:id=\"ClassMenuItem\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert EditButton != null : "fx:id=\"EditButton\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert EmployeeListTableView != null : "fx:id=\"EmployeeListTableView\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert EmployeesMenuItem != null : "fx:id=\"EmployeesMenuItem\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert ExportTableMenuItem != null : "fx:id=\"ExportTableMenuItem\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert FormerPupilsMenuItem != null : "fx:id=\"FormerPupilsMenuItem\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert NewEmployeeButton != null : "fx:id=\"NewEmployeeButton\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert OpenNewTablesMenuItem != null : "fx:id=\"OpenNewTablesMenuItem\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert OpenOldMenuItem != null : "fx:id=\"OpenOldMenuItem\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert PupilsMenuItem != null : "fx:id=\"PupilsMenuItem\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert SubjectsMenuItem != null : "fx:id=\"SubjectsMenuItem\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert TablesMenu != null : "fx:id=\"TablesMenu\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert employeeID_invisbl_Column != null : "fx:id=\"employeeID_invisbl_Column\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert employeeNameColumn != null : "fx:id=\"employeeNameColumn\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert employeeStatussColumn != null : "fx:id=\"employeeStatussColumn\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert employeeSurnameColumn != null : "fx:id=\"employeeSurnameColumn\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert mainMenuAnchorPane != null : "fx:id=\"mainMenuAnchorPane\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert mainMenuBar != null : "fx:id=\"mainMenuBar\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";
        assert tickColumn != null : "fx:id=\"tickColumn\" was not injected: check your FXML file 'TableViewEmployees.fxml'.";



        //my code to fill up table:::::::::::::::
        System.out.println("now to fill table from DB");
        DatabaseHandler dbHandler = new DatabaseHandler();
        Connection con = null;
        try {
            con = dbHandler.getDbConnection();
            /*
            SELECT employee_id, employee_surname, employee_name,
            employee_status, employee_is_teacher
            FROM progschema.tbl_employees
            ORDER BY employee_is_teacher DESC, employee_surname ASC, employee_name ASC
            ;
            */
            ResultSet rs = con.createStatement().executeQuery("SELECT employee_id, employee_surname, employee_name, employee_status, employee_is_teacher FROM progschema.tbl_employees ORDER BY employee_is_teacher DESC, employee_surname ASC, employee_name ASC;");
            while (rs.next()) {
                System.out.println("in a while");
                empData.add(new Employee(rs.getString("employee_id"),rs.getString("employee_name"),
                        rs.getString("employee_surname"),rs.getString("employee_status"),rs.getString("employee_is_teacher")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        tickColumn.setCellValueFactory(new PropertyValueFactory<Employee, CheckBox>("empTick"));
        employeeID_invisbl_Column.setCellValueFactory(cellData -> cellData.getValue().empIDProperty());
        employeeSurnameColumn.setCellValueFactory(cellData -> cellData.getValue().empSurnameProperty());
        employeeNameColumn.setCellValueFactory(cellData -> cellData.getValue().empNameProperty());
        employeeStatussColumn.setCellValueFactory(cellData -> cellData.getValue().empStatusProperty());

        System.out.println("did setCellValueFactory");
        EmployeeListTableView.setItems(empData);
    }

}
