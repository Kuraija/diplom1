package group.proga;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import group.proga.dbthings.DatabaseHandler;
import group.proga.entities.Pupil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OnePupilController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCancelOnePupil;

    @FXML
    private Button buttonSaveOnePupil;

    @FXML
    private Label pupilClassLabel;

    @FXML
    private TextField pupilClassTextField;

    @FXML
    private Label pupilFatherNameLabel;

    @FXML
    private TextField pupilFatherNameTextField;

    @FXML
    private Label pupilFatherPKLabel;

    @FXML
    private TextField pupilFatherPKTextField;

    @FXML
    private Label pupilMotherNameLabel;

    @FXML
    private TextField pupilMotherNameTextField;

    @FXML
    private Label pupilMotherPKLabel;

    @FXML
    private TextField pupilMotherPKTextField;

    @FXML
    private Label pupilNameLabel;

    @FXML
    private TextField pupilNameTextField;

    @FXML
    private Label pupilPKLabel;

    @FXML
    private TextField pupilPKTextField;

    @FXML
    private Label pupilStartDateLabel;

    @FXML
    private DatePicker pupilStartDatePicker;

    @FXML
    private Label pupilStopDateLabel;

    @FXML
    private DatePicker pupilStopDatePicker;

    @FXML
    private Label pupilSurnameLabel;

    @FXML
    private TextField pupilSurnameTextField;

    private Stage stage;
    private Scene scene;
    Boolean itIsNewPupil = true;
    String PupilID = "";

    @FXML
    void cancelOnePupil(ActionEvent event) {
        System.out.println(" you clicked  cancelOnePupil(ActionEvent event)");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("TableViewPupils.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void saveOnePupil(ActionEvent event) {
        System.out.println(" you clicked  saveOnePupil(ActionEvent event)");
        DatabaseHandler dbHandlerSave = new DatabaseHandler();
        Connection con = null;
        try {
            con = dbHandlerSave.getDbConnection();
            if (itIsNewPupil){
                //we are saving NEW pupil so use INSERT INTO
                //will need to change this:
                //INSERT INTO progschema.tbl_pupils(pupil_name,pupil_surname,pupil_class_id) VALUES ('NewName','NewSurname',2);
                con.createStatement().executeUpdate("INSERT INTO progschema.tbl_pupils" +
                        "(pupil_name,pupil_surname,pupil_class_id) " +
                        "VALUES ('"+pupilNameTextField.getText()+"','" +
                        pupilSurnameTextField.getText()+"'," +
                        "2);");
                cancelOnePupil(event);//to close the window and open LIST
            }
            else{
                //we arATE progschema.tbl_pupils SETe saving old pupil, so use UPDATE
                //will need to change this:
                /*                UPD

                pupil_nameupil_surname ='                        pupil_class_id = 2
 ='Anja',AnjaSurn',
                        p                WHERE pupil_id = 68;
                */
                con.createStatement().executeUpdate("UPDATE progschema.tbl_pupils SET" +
                        " pupil_name='" +pupilNameTextField.getText()+
                        "', pupil_surname ='" +pupilSurnameTextField.getText()+
                        "', pupil_class_id = 2" +
                        " WHERE pupil_id = "+ PupilID+";");
                cancelOnePupil(event);//to close the window and open LIST
            }
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }


    }


    @FXML
    void initialize() {
        assert buttonCancelOnePupil != null : "fx:id=\"buttonCancelOnePupil\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert buttonSaveOnePupil != null : "fx:id=\"buttonSaveOnePupil\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilClassLabel != null : "fx:id=\"pupilClassLabel\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilClassTextField != null : "fx:id=\"pupilClassTextField\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilFatherNameLabel != null : "fx:id=\"pupilFatherNameLabel\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilFatherNameTextField != null : "fx:id=\"pupilFatherNameTextField\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilFatherPKLabel != null : "fx:id=\"pupilFatherPKLabel\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilFatherPKTextField != null : "fx:id=\"pupilFatherPKTextField\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilMotherNameLabel != null : "fx:id=\"pupilMotherNameLabel\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilMotherNameTextField != null : "fx:id=\"pupilMotherNameTextField\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilMotherPKLabel != null : "fx:id=\"pupilMotherPKLabel\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilMotherPKTextField != null : "fx:id=\"pupilMotherPKTextField\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilNameLabel != null : "fx:id=\"pupilNameLabel\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilNameTextField != null : "fx:id=\"pupilNameTextField\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilPKLabel != null : "fx:id=\"pupilPKLabel\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilPKTextField != null : "fx:id=\"pupilPKTextField\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilStartDateLabel != null : "fx:id=\"pupilStartDateLabel\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilStartDatePicker != null : "fx:id=\"pupilStartDatePicker\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilStopDateLabel != null : "fx:id=\"pupilStopDateLabel\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilStopDatePicker != null : "fx:id=\"pupilStopDatePicker\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilSurnameLabel != null : "fx:id=\"pupilSurnameLabel\" was not injected: check your FXML file 'OnePupil.fxml'.";
        assert pupilSurnameTextField != null : "fx:id=\"pupilSurnameTextField\" was not injected: check your FXML file 'OnePupil.fxml'.";


        System.out.println("in openOnePupilToEdit:");
        DatabaseHandler dbHandler = new DatabaseHandler();
        Connection con = null;
        try {
            con = dbHandler.getDbConnection();
            //SELECT actual_data FROM progschema.dump WHERE iddump =1;
            ResultSet rs = con.createStatement().executeQuery("SELECT actual_data FROM progschema.dump WHERE iddump =1;");
            if (rs.next()) {
                //if was opened OLD pupil
                itIsNewPupil = false;
                PupilID = rs.getString("actual_data");//save ID of Pupil to show in this window

                //now get data of this pupil:
                //SELECT p.pupil_id,c.class_name,p.pupil_surname,p.pupil_name,
                // p.pupil_personal_code,p.pupil_start_date,p.pupil_stop_date,
                // p.mother_personal_code,p.mother_name, p.father_personal_code,
                // p.father_name FROM progschema.tbl_pupils AS p,
                // progschema.tbl_classes AS c WHERE p.pupil_id = PupilID;"
                //
                //clean up DUMP table:
                con.createStatement().executeUpdate("DELETE FROM progschema.dump WHERE iddump = 1;");
                //get pupil data:
                rs = con.createStatement().executeQuery("SELECT p.pupil_id,c.class_name,p.pupil_surname,p.pupil_name,p.pupil_personal_code,p.pupil_start_date,p.pupil_stop_date, p.mother_personal_code,p.mother_name, p.father_personal_code,p.father_name FROM progschema.tbl_pupils AS p, progschema.tbl_classes AS c WHERE p.pupil_id =" + PupilID + ";");
                while (rs.next()) {
                    Pupil ThisPupil = new Pupil(rs.getString("pupil_id"), rs.getString("class_name"),
                            rs.getString("pupil_surname"), rs.getString("pupil_name"),
                            rs.getString("pupil_personal_code"), rs.getString("pupil_start_date"),
                            rs.getString("pupil_stop_date"), rs.getString("mother_personal_code"),
                            rs.getString("mother_name"), rs.getString("father_personal_code"),
                            rs.getString("father_name"));

                    //fill that pupil data to the form:
                    System.out.println("NOW WILL INITIALIZE:");
                    System.out.println("NOW will set texts:");
                    pupilNameTextField.setText(ThisPupil.getPupilName());//works
                    System.out.println("did pupilNameTextField");
                    pupilSurnameTextField.setText(ThisPupil.getPupilSurname());
                    System.out.println("pupilSurnameTextField");
                    pupilPKTextField.setText(ThisPupil.getPupilPK());
                    System.out.println("NOW pupilPKTextField");
                    pupilClassTextField.setText(ThisPupil.getPupilClass());
                    System.out.println("NOW pupilClassTextField");
                    pupilMotherNameTextField.setText(ThisPupil.getPupilMotherName());
                    System.out.println("NOW pupilMotherNameTextField");
                    pupilMotherPKTextField.setText(ThisPupil.getPupilMotherPK());
                    System.out.println("NOW pupilMotherPKTextField");
                    pupilFatherNameTextField.setText(ThisPupil.getPupilFatherName());
                    System.out.println("NOW pupilFatherNameTextField");
                    pupilFatherPKTextField.setText(ThisPupil.getPupilFatherPK());
                    System.out.println("NOW pupilFatherPKTextField");
                    //for start date:
                    String stringDate =ThisPupil.getPupilStartDate();//like 2022-02-09
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate localDate;
                    if (stringDate != null && !stringDate.isEmpty()) {
                        localDate = LocalDate.parse(stringDate, formatter);
                        pupilStartDatePicker.setValue(localDate);
                    }
                    else{
                        pupilStartDatePicker.setValue(null);
                    }
                    //for end date:
                    stringDate =ThisPupil.getPupilEndDate();
                    if (stringDate != null && !stringDate.isEmpty()) {
                        localDate = LocalDate.parse(stringDate, formatter);
                        pupilStopDatePicker.setValue(localDate);
                    }
                    else{
                        pupilStopDatePicker.setValue(null);
                    }
                }
            }//end of IF was opened one pupil to fill data
        else{// if was opened A NEW pupil for creation
                itIsNewPupil = true;
            }

        }
        catch(ClassNotFoundException e){
                e.printStackTrace();
            } catch(SQLException throwables){
                throwables.printStackTrace();
            }
        }



}
