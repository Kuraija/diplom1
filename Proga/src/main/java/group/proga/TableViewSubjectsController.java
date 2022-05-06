package group.proga;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import group.proga.dbthings.DatabaseHandler;
import group.proga.entities.Employee;
import group.proga.entities.GradeClass;
import group.proga.entities.smallGroupStudio;
import group.proga.entities.smallSubject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class TableViewSubjectsController {

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
    private Button DeleteSubjectButton;

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
    private Button NewSubjectButton;

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
    private Button editSubjectButton;

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
    private TableView<smallSubject> SubjectsTableView;

    @FXML
    private TableColumn<smallSubject, String> idSubj_invisColumn;

    @FXML
    private TableColumn<smallSubject, String> subj_NameColumn;

    @FXML
    private TableColumn<smallSubject, CheckBox> subj_TickColumn;

    ObservableList<smallSubject> obsList = FXCollections.observableArrayList();

    @FXML
    void deleteSubject(ActionEvent event) {
        System.out.println(" you clicked  deleteSubject");
//!!!!!!!!!!! I need here a pop up message of "are you sure?"
        ObservableList<smallSubject> removeThese = FXCollections.observableArrayList();
        String delID;//ID to delete from database
        for (smallSubject oneRow : obsList){
            if (oneRow.getSubjTick().isSelected()){
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
                for (smallSubject oneRow : removeThese) {
                    System.out.println("Now prrrrrrrrrrrrrrrrint one ROW ID:");
                    System.out.println(oneRow.getSubjID());
                    delID = oneRow.getSubjID();
                    //sql
                    //DELETE FROM `tbl_subjects` WHERE `id_subject` = 5;
                    con.createStatement().executeUpdate("DELETE FROM `tbl_subjects` WHERE `id_subject` = "+delID+";");
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
    void createNewSubject(ActionEvent event) {

    }

    @FXML
    void editSubject(ActionEvent event) {

    }


    @FXML
    void initialize() {
        assert CalendarMenuItem != null : "fx:id=\"CalendarMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert CatalogsMenu != null : "fx:id=\"CatalogsMenu\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert ClassMenuItem != null : "fx:id=\"ClassMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert DeleteSubjectButton != null : "fx:id=\"DeleteSubjectButton\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert EmployeesMenuItem != null : "fx:id=\"EmployeesMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert ExportTableMenuItem != null : "fx:id=\"ExportTableMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert FormerPupilsMenuItem != null : "fx:id=\"FormerPupilsMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert GroupStudiosMenuItem != null : "fx:id=\"GroupStudiosMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert HourlyStudiosMenuItem != null : "fx:id=\"HourlyStudiosMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert NewSubjectButton != null : "fx:id=\"NewSubjectButton\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert OpenNewTablesMenuItem != null : "fx:id=\"OpenNewTablesMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert OpenOldMenuItem != null : "fx:id=\"OpenOldMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert PupilsMenuItem != null : "fx:id=\"PupilsMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert ServicesMenuItem != null : "fx:id=\"ServicesMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert SubjectsMenuItem != null : "fx:id=\"SubjectsMenuItem\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert SubjectsTableView != null : "fx:id=\"SubjectsTableView\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert TablesMenu != null : "fx:id=\"TablesMenu\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert editSubjectButton != null : "fx:id=\"editSubjectButton\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert idSubj_invisColumn != null : "fx:id=\"idSubj_invisColumn\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert mainMenuAnchorPane != null : "fx:id=\"mainMenuAnchorPane\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert mainMenuAnchorPane1 != null : "fx:id=\"mainMenuAnchorPane1\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert mainMenuBar != null : "fx:id=\"mainMenuBar\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert subj_NameColumn != null : "fx:id=\"subj_NameColumn\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";
        assert subj_TickColumn != null : "fx:id=\"subj_TickColumn\" was not injected: check your FXML file 'TableViewSubjects.fxml'.";

        //my code to fill up table:::::::::::::::
        System.out.println("now to fill table from DB");
        DatabaseHandler dbHandler = new DatabaseHandler();
        Connection con = null;
        try {
            con = dbHandler.getDbConnection();
            /*
            SELECT id_subject, subject_name
            FROM progschema.tbl_subjects
            ORDER BY subject_name ASC;
            */
            ResultSet rs = con.createStatement().executeQuery("SELECT id_subject, subject_name FROM progschema.tbl_subjects ORDER BY subject_name ASC;");
            while (rs.next()) {
                System.out.println("in a while of SubjectTable");
                obsList.add(new smallSubject(rs.getString("id_subject"),rs.getString("subject_name")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        subj_TickColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,CheckBox>("subjTick"));
        idSubj_invisColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,String>("subjID"));
        subj_NameColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,String>("subjName"));
        SubjectsTableView.setItems( obsList);

    }

}

