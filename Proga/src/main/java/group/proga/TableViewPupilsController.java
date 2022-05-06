package group.proga;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import group.proga.dbthings.DatabaseHandler;
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
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TableViewPupilsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
//----------menu


    @FXML
    private MenuBar mainMenuBar;

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
    private MenuItem SubjectsMenuItem;

    @FXML
    private Menu TablesMenu;

    @FXML
    private AnchorPane mainMenuAnchorPane;

    @FXML
    private AnchorPane mainMenuAnchorPane1;
//-----------menu end, buttons start
    @FXML
    private Button DeleteButton;

    @FXML
    private Button EditButton;

    @FXML
    private Button NewPupilButton;

    //-------------------buttons end, table starts
    @FXML
    private TableView<Pupil> PupilListTableView;

    @FXML
    private TableColumn<Pupil, CheckBox> tickColumn;

    @FXML
    private TableColumn<Pupil, String> pupilID_invisbl_Column;

    @FXML
    private TableColumn<Pupil, String> pupilClassColumn;

    @FXML
    private TableColumn<Pupil, String> pupilSurnameColumn;

    @FXML
    private TableColumn<Pupil, String> pupilNameColumn;

    @FXML
    private TableColumn<Pupil, String> pupilPKcolumn;

    @FXML
    private TableColumn<Pupil, String> PupilStartDateColumn;

    @FXML
    private TableColumn<Pupil, String> PupilStopDateColumn;

    @FXML
    private TableColumn<Pupil, String> PupilMotherPKColumn;

    @FXML
    private TableColumn<Pupil, String> pupilMotherNameColumn;

    @FXML
    private TableColumn<Pupil, String> pupilFatherPKColumn;

    @FXML
    private TableColumn<Pupil, String> pupilFatherNameColumn;


    ObservableList<Pupil> pupilData = FXCollections.observableArrayList();
    private Stage stage;
    private Scene scene;
    private Parent root;


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

    //-----------------------buttons:
    @FXML
    void DeleteThisPupilFromDB(ActionEvent event) {
        System.out.println(" you clicked  DeleteThisPupilFromDB");
//!!!!!!!!!!! I need here a pop up message of "are you sure?"
        ObservableList<Pupil> removeThesePupils = FXCollections.observableArrayList();
        String delID;//ID of pupil to delete from database
        for (Pupil oneRow : pupilData){
            if (oneRow.getPupilTick().isSelected()){
                removeThesePupils.add(oneRow);
                System.out.println("---------------remove them ---------------------------");
            }
        }
        pupilData.removeAll(removeThesePupils);
        if (!removeThesePupils.isEmpty()) {
            //if to delete picked out students from database

            System.out.println("in IF del list is not empty:");
            DatabaseHandler dbHandler = new DatabaseHandler();
            Connection con = null;
            try {
                con = dbHandler.getDbConnection();
                for (Pupil oneRow : removeThesePupils) {
                    System.out.println("Now prrrrrrrrrrrrrrrrint one ROW ID:");
                    System.out.println(oneRow.getPupilID());
                    delID = oneRow.getPupilID();
                    //DELETE FROM `tbl_pupils` WHERE `pupil_id` = delID;
                    con.createStatement().executeUpdate("DELETE FROM `tbl_pupils` WHERE `pupil_id` = "+delID+";");
                }}
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            removeThesePupils.clear();
            if (!removeThesePupils.isEmpty()){
                System.out.println("ERRRRROR!!!!!!! for some reason delete list did not get cleared?!?!?!?");
            }
        }
        else{
            //nothing to delete message?
        }



    }

    @FXML
    void EditThisPupil(ActionEvent event) {
        System.out.println(" you clicked  EditThisPupil(ActionEvent event");

        ObservableList<Pupil> openThesePupils = FXCollections.observableArrayList();
        String openID = "";//ID of pupil to open from database
        Integer counter =0;
        for (Pupil oneRow : pupilData){
            if (oneRow.getPupilTick().isSelected()){
                openThesePupils.add(oneRow);
                counter++;
                openID = oneRow.getPupilID();
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
                openThesePupils.clear();
                counter =0;

                //and now to open a window - not pop up:
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("OnePupil.fxml"));//removed this
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    System.out.println("did (Stage)((Node)event.getSource() for edit");
                    scene = new Scene(root);
                    stage.setScene(scene);
                    System.out.println("did stage.setScene(scene);");
                    stage.show();
                    //oneP.openOnePupilToEdit();//no need anymore
                    //System.out.println("did oneP.openOnePupilToEdit(openID, event)");
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
    void createNewPupil(ActionEvent event) {
        System.out.println(" you clicked  createNewPupil(ActionEvent event");
                //to open a window - not pop up:
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("OnePupil.fxml"));//removed this
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    System.out.println("did (Stage)((Node)event.getSource() for create");
                    scene = new Scene(root);
                    stage.setScene(scene);
                    System.out.println("did stage.setScene(scene);");
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
        }


    @FXML
    void initialize() {
        assert CalendarMenuItem != null : "fx:id=\"CalendarMenuItem\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert CatalogsMenu != null : "fx:id=\"CatalogsMenu\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert ClassMenuItem != null : "fx:id=\"ClassMenuItem\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert EditButton != null : "fx:id=\"EditButton\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert EmployeesMenuItem != null : "fx:id=\"EmployeesMenuItem\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert ExportTableMenuItem != null : "fx:id=\"ExportTableMenuItem\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert FormerPupilsMenuItem != null : "fx:id=\"FormerPupilsMenuItem\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert NewPupilButton != null : "fx:id=\"NewPupilButton\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert OpenNewTablesMenuItem != null : "fx:id=\"OpenNewTablesMenuItem\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert OpenOldMenuItem != null : "fx:id=\"OpenOldMenuItem\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert PupilListTableView != null : "fx:id=\"PupilListTableView\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert PupilMotherPKColumn != null : "fx:id=\"PupilMotherPKColumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert PupilStartDateColumn != null : "fx:id=\"PupilStartDateColumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert PupilStopDateColumn != null : "fx:id=\"PupilStopDateColumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert PupilsMenuItem != null : "fx:id=\"PupilsMenuItem\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert SubjectsMenuItem != null : "fx:id=\"SubjectsMenuItem\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert TablesMenu != null : "fx:id=\"TablesMenu\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert mainMenuAnchorPane != null : "fx:id=\"mainMenuAnchorPane\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert mainMenuAnchorPane1 != null : "fx:id=\"mainMenuAnchorPane1\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert mainMenuBar != null : "fx:id=\"mainMenuBar\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert pupilClassColumn != null : "fx:id=\"pupilClassColumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert pupilFatherNameColumn != null : "fx:id=\"pupilFatherNameColumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert pupilFatherPKColumn != null : "fx:id=\"pupilFatherPKColumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert pupilID_invisbl_Column != null : "fx:id=\"pupilID_invisbl_Column\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert pupilMotherNameColumn != null : "fx:id=\"pupilMotherNameColumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert pupilNameColumn != null : "fx:id=\"pupilNameColumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert pupilPKcolumn != null : "fx:id=\"pupilPKcolumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert pupilSurnameColumn != null : "fx:id=\"pupilSurnameColumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";
        assert tickColumn != null : "fx:id=\"tickColumn\" was not injected: check your FXML file 'TableViewPupils.fxml'.";

        //my code to fill up table:::::::::::::::
        System.out.println("now to fill table from DB");
        //pupilData.add(new Pupil("Hans","Grate","thisClass"));
        DatabaseHandler dbHandler = new DatabaseHandler();
        Connection con = null;
        try {
            con = dbHandler.getDbConnection();
            /*
            SELECT p.pupil_id, c.class_name,p.pupil_surname,p.pupil_name,
            p.pupil_personal_code,p.pupil_start_date,
            p.pupil_stop_date, p.mother_personal_code,
            p.mother_name, p.father_personal_code,
            p.father_name
            FROM progschema.tbl_pupils AS p, progschema.tbl_classes AS c
            WHERE c.id_classes = p.pupil_class_id;
            */
            ResultSet rs = con.createStatement().executeQuery("SELECT p.pupil_id,c.class_name,p.pupil_surname,p.pupil_name,p.pupil_personal_code,p.pupil_start_date,p.pupil_stop_date, p.mother_personal_code,p.mother_name, p.father_personal_code,p.father_name FROM progschema.tbl_pupils AS p, progschema.tbl_classes AS c WHERE c.id_classes = p.pupil_class_id;");
            while (rs.next()) {
                System.out.println("in a while");
                //String stringDate = rs.getDate("DATE(pupil_start_date)").toString();
                pupilData.add(new Pupil(rs.getString("pupil_id"),rs.getString("class_name"),
                        rs.getString("pupil_surname"),rs.getString("pupil_name"),
                        rs.getString("pupil_personal_code"),rs.getString("pupil_start_date"),
                        rs.getString("pupil_stop_date"),rs.getString("mother_personal_code"),
                        rs.getString("mother_name"),rs.getString("father_personal_code"),
                        rs.getString("father_name")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ///tickColumn.setCellValueFactory(cellData -> new CheckBoxTableCell<Pupil,CheckBox>());
        ///tickColumn.setCellValueFactory(new PropertyValueFactory<Pupil,CheckBox>("CheckBox"));
        ///tickColumn.setCellFactory(column -> new CheckBoxTableCell<>());
        //tickColumn.setCellValueFactory(cellData -> cellData.getValue().pupilTickProperty());
        tickColumn.setCellValueFactory(new PropertyValueFactory<Pupil, CheckBox>("pupilTick"));



        pupilID_invisbl_Column.setCellValueFactory(cellData -> cellData.getValue().pupilIDProperty());
        pupilClassColumn.setCellValueFactory(cellData -> cellData.getValue().pupilClassProperty());
        pupilSurnameColumn.setCellValueFactory(cellData -> cellData.getValue().pupilSurnameProperty());
        pupilNameColumn.setCellValueFactory(cellData -> cellData.getValue().pupilNameProperty());
        pupilPKcolumn.setCellValueFactory(cellData -> cellData.getValue().pupilPKProperty());
        PupilStartDateColumn.setCellValueFactory(cellData -> cellData.getValue().pupilStartDateProperty());
        PupilStopDateColumn.setCellValueFactory(cellData -> cellData.getValue().pupilEndDateProperty());
        PupilMotherPKColumn.setCellValueFactory(cellData -> cellData.getValue().pupilMotherPKProperty());
        pupilMotherNameColumn.setCellValueFactory(cellData -> cellData.getValue().pupilMotherNameProperty());
        pupilFatherPKColumn.setCellValueFactory(cellData -> cellData.getValue().pupilFatherPKProperty());
        pupilFatherNameColumn.setCellValueFactory(cellData -> cellData.getValue().pupilFatherNameProperty());

        System.out.println("did setCellValueFactory");
        PupilListTableView.setItems(pupilData);

    }

}
