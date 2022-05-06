package group.proga;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Objects;
import java.util.ResourceBundle;

import group.proga.dbthings.DatabaseHandler;
import group.proga.entities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OneEmployeeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private Stage stage;
    private Scene scene;
    Boolean itIsNewEmpl = true;
    String EmplID = "";
    ObservableList<String> availableStatusChoices = FXCollections.observableArrayList("работает", "не работает");
    ObservableList<GradeClass> allGrades = FXCollections.observableArrayList();
    ObservableList<smallSubject> allSubjects = FXCollections.observableArrayList();
    ObservableList<smallGroupStudio> allGStudios = FXCollections.observableArrayList();
    ObservableList<smallHourlyStudio> allHStudios = FXCollections.observableArrayList();
    ObservableList<smallService> allServices = FXCollections.observableArrayList();


    @FXML
    private Button buttonCancelOneEmpl;

    @FXML
    private Button buttonCancelOneEmpl1;

    @FXML
    private Button buttonSaveOneEmpl;

    @FXML
    private Button buttonSaveOneEmpl1;

    @FXML
    private TableView<GradeClass> emplHomeroom_TableView;

    @FXML
    private TableColumn<GradeClass, String> emplClassID_invColumn;

    @FXML
    private TableColumn<GradeClass, CheckBox> emplClass_TickColumn;

    @FXML
    private TableColumn<GradeClass, String> emplClass_name;


    @FXML
    private TitledPane emplGStudio_TitledPane;

    @FXML
    private AnchorPane emplGStudio_AnchorPane;

    @FXML
    private TableView<smallGroupStudio> emplGStudio_TableView;

    @FXML
    private TableColumn<smallGroupStudio, String> emplGStudioID_invColumn;

    @FXML
    private TableColumn<smallGroupStudio, CheckBox> emplGStudio_TickColumn;

    @FXML
    private TableColumn<smallGroupStudio, String> emplGstudio_nameColumn;

    @FXML
    private TableColumn<smallGroupStudio, TextField> emplGStudio_paymentColumn;


    @FXML
    private TitledPane emplHstudio_TitledPane;

    @FXML
    private AnchorPane emplHStudio_AnchorPane;

    @FXML
    private TableView<smallHourlyStudio> emplHStudio_TableView;

    @FXML
    private TableColumn<smallHourlyStudio, String> emplHStudioID_invColumn;

    @FXML
    private TableColumn<smallHourlyStudio, CheckBox> emplHStudio_TickColumn;

    @FXML
    private TableColumn<smallHourlyStudio, String> emplHStudio_nameColumn;

    @FXML
    private TableColumn<smallHourlyStudio, TextField> emplHStudio_paymentColumn;

    @FXML
    private TitledPane emplHomeroom_TitledPane;

    @FXML
    private Label emplIsTeacherLabel;

    @FXML
    private Label emplNameLabel;

    @FXML
    private TextField emplNameTextField;


    @FXML
    private TitledPane emplServis_TitledPane;

    @FXML
    private AnchorPane emplServis_AnchorPane;

    @FXML
    private TableView<smallService> emplServiss_TableView;

    @FXML
    private TableColumn<smallService, String> emplServisID_invColumn;

    @FXML
    private TableColumn<smallService, CheckBox> emplServis_TickColumn;

    @FXML
    private TableColumn<smallService, TextField> emplService_paymentColumn;

    @FXML
    private TableColumn<smallService, String> emplServis_nameColumn;



    @FXML
    private ChoiceBox<String> emplStatussChoiceBox;

    @FXML
    private Label emplStatussLabel;

    @FXML
    private TableColumn<smallSubject, String> emplSubjectID_invColumn;


    @FXML
    private TitledPane emplSubject_TitledPane;

    @FXML
    private TableView<smallSubject> emplSubject_TableView;

    @FXML
    private TableColumn<smallSubject, CheckBox> emplSubject_TickColumn;

    @FXML
    private TableColumn<smallSubject, String> emplSubject_nameColumn;

    @FXML
    private TableColumn<smallSubject, TextField> emplSubject_paymentColumn;

    @FXML
    private Label emplSurnameLabel;

    @FXML
    private TextField emplSurnameTextField;

    @FXML
    private RadioButton empl_NOTaTeacherRadioButton;

    @FXML
    private RadioButton empl_isTeacherRadioButton;

    @FXML
    private ToggleGroup teacherToggleGroup;

    @FXML
    void cancelOneEmpl(ActionEvent event) {
        System.out.println(" you clicked  cancelOnePupil(ActionEvent event)");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("TableViewEmployees.fxml"));
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
    void saveOneEmpl(ActionEvent event) {
if(itIsNewEmpl == true)
{
    //if it is a new empl
    System.out.println("in saveOneEmpl:");
    DatabaseHandler dbHandler = new DatabaseHandler();
    Connection con = null;
    try {
        //first get all data input into table - maybe can do this outside of try?:

        String emplStatus = emplStatussChoiceBox.getValue();
        if ((availableStatusChoices.get(0)).equals(emplStatus))
        {
            //if works
            emplStatus = "1";
        }
        else
        {
            emplStatus = "0";
        }

        //get radio buttons
        RadioButton selectedRadioButton = (RadioButton) teacherToggleGroup.getSelectedToggle();
        String emplIsATeacher;
        if (empl_isTeacherRadioButton.equals(selectedRadioButton))
        {
            emplIsATeacher = "1";
        }
        else
        {
            emplIsATeacher = "0";
        }
        //now finish all empl input data into db:
        con = dbHandler.getDbConnection();
        con.createStatement().executeUpdate("INSERT INTO progschema.tbl_employees "+
                "(employee_name, employee_surname, employee_status, employee_is_teacher) "+
                "VALUES ('" +emplNameTextField.getText()+"', '"+
                        emplSurnameTextField.getText()+"', "+emplStatus+","+emplIsATeacher+");");
        //get newly created emplID
        ResultSet rs = con.createStatement().executeQuery("SELECT LAST_INSERT_ID();");
        if (rs.next())
        {
            EmplID = rs.getString("LAST_INSERT_ID()");
        }
        //now to save classes:
            int classAmount = allGrades.size();
        for (int i = 0; i<classAmount; i++)
        {
            if (allGrades.get(i).getClassTickValue())//actually what user ticked NOW
            {
                //if user selected this class as one this teacher homerooms - set it as their homeroom
                //UPDATE progschema.tbl_classes
                //SET employee_id='1'
                //WHERE id_classes='6';
                con.createStatement().executeUpdate("UPDATE progschema.tbl_classes SET employee_id='"+
                        EmplID+"' WHERE id_classes='"+allGrades.get(i).getClassID()+"';");
            }
        }
        // now set subjects:
        //needs :   EmplID   if allSubjects.getSubjTickValue then  allSubjects.getSubjID & allSubjects.getSubjPayment
        int subjAmount = allSubjects.size();
        for (int i = 0; i<subjAmount; i++) {
            if (allSubjects.get(i).getSubjTickValue()) {
            /*
                INSERT INTO progschema.tbl_who_does_subject
                (employee_id, subject_id, payment)
                VALUES ('19','3','800');
            * */
//                System.out.println("in allSubjects.get(i).getSubjTickValue:");
//                System.out.println("EmplID:"+EmplID);
//                System.out.println("allSubjects.get(i).getSubjID():"+allSubjects.get(i).getSubjID());
//                System.out.println("allSubjects.get(i).getSubjPaymentValue():"+allSubjects.get(i).getSubjPaymentValue());
                con.createStatement().executeUpdate("INSERT INTO progschema.tbl_who_does_subject (employee_id, subject_id, payment) VALUES ('"+
                        EmplID+"','"+allSubjects.get(i).getSubjID()+"','"+allSubjects.get(i).getSubjPaymentValue()+"');");

            }
        }
        //now set group studios:
//needs :   EmplID   if allGStudios.getGStudioTickValue then  allGStudios.getGStudioID & allGStudios.getGStudioPaymentValue
        int gStudioAmount = allGStudios.size();
        for (int i = 0; i<gStudioAmount; i++) {
            if (allGStudios.get(i).getGStudioTickValue()) {
            /*
                INSERT INTO progschema.tbl_who_does_stiduo_g
                (employee_id, studio_in_group_id, payment_rate)
                VALUES ('19','3','800');
            * */
                con.createStatement().executeUpdate("INSERT INTO progschema.tbl_who_does_stiduo_g "
                        +"(employee_id, studio_in_group_id, payment_rate) VALUES ('"+
                        EmplID+"','"+allGStudios.get(i).getGStudioID()+"','"+allGStudios.get(i).getGStudioPaymentValue()+"');");
            }
        }
//now set hourly studios:
//needs :   EmplID   if allHStudios.getHStudioTickValue then  allHStudios.getHStudioID & allHStudios.getHStudioPaymentValue
        int hStudioAmount = allHStudios.size();
        for (int i = 0; i<hStudioAmount; i++) {
            if (allHStudios.get(i).getHStudioTickValue()) {
            /*
                INSERT INTO progschema.tbl_who_does_stiduo_h
                (employee_id, studio_hourly_id, payment_rate)
                VALUES ('19','3','800');
            * */
                con.createStatement().executeUpdate("INSERT INTO progschema.tbl_who_does_stiduo_h "
                        +"(employee_id, studio_hourly_id, payment_rate) VALUES ('"+
                        EmplID+"','"+allHStudios.get(i).getHStudioID()+"','"+allHStudios.get(i).getHStudioPaymentValue()+"');");
            }
        }
//now set services:
//needs :   EmplID   if allServices.getServiceTickValue then  allServices.getServiceID & allServices.getServicePaymentValue
        int servicesAmount = allServices.size();
        for (int i = 0; i<servicesAmount; i++) {
            if (allServices.get(i).getServiceTickValue()) {
            /*
                INSERT INTO progschema.tbl_who_does_service
                (employee_id, service_id, payment_rate)
                VALUES ('19','3','800');
            * */
                con.createStatement().executeUpdate("INSERT INTO progschema.tbl_who_does_service "
                        +"(employee_id, service_id, payment_rate) VALUES ('"+
                        EmplID+"','"+allServices.get(i).getServiceID()+"','"+allServices.get(i).getServicePaymentValue()+"');");
            }
        }
    }
    catch(ClassNotFoundException e){
        e.printStackTrace();
    } catch(SQLException throwables){
        throwables.printStackTrace();
    }

    }
else{
    //if it is an old empl
    //I actually can just add many IFs in first -new empl - IF instead
    //but quicker is to add cases to a copy of "new empl" actions:
    System.out.println("in saveOneEmpl which already exists:");
    DatabaseHandler dbHandler = new DatabaseHandler();
    Connection con = null;
    try {
        //first get all data input into table - maybe can do this outside of try?:

        String emplStatus = emplStatussChoiceBox.getValue();
        if ((availableStatusChoices.get(0)).equals(emplStatus)) {
            //if works
            emplStatus = "1";
        } else {
            emplStatus = "0";
        }

        //get radio buttons
        RadioButton selectedRadioButton = (RadioButton) teacherToggleGroup.getSelectedToggle();
        String emplIsATeacher;
        if (empl_isTeacherRadioButton.equals(selectedRadioButton)) {
            emplIsATeacher = "1";
        } else {
            emplIsATeacher = "0";
        }
        //now finish all empl input data into db:
        //EmplID is already saved there
        /*
        UPDATE progschema.tbl_employees
        SET employee_name=emplNameTextField.getText(),
        employee_surname=emplSurnameTextField.getText(),
        employee_status=emplStatus,
        employee_is_teacher=emplIsATeacher
        WHERE employee_id =EmplID;
        * */

        con = dbHandler.getDbConnection();
        System.out.println(" Now will make Update ith basic stuff");
//        System.out.println(" employee_name='\" + emplNameTextField.getText()="+emplNameTextField.getText());
//        System.out.println(" employee_surname='\" + emplSurnameTextField.getText()="+emplSurnameTextField.getText());
//        System.out.println(" employee_status='\" + emplStatus="+emplStatus);
//        System.out.println(" employee_is_teacher='\" + emplIsATeacher="+emplIsATeacher);
//        System.out.println(" employee_id ='\" + EmplID ="+EmplID);

        con.createStatement().executeUpdate("UPDATE progschema.tbl_employees SET " +
                "employee_name='" + emplNameTextField.getText() +
                "', employee_surname='" + emplSurnameTextField.getText() +
                "', employee_status='" + emplStatus +
                "', employee_is_teacher='" + emplIsATeacher +
                "' WHERE employee_id ='" + EmplID + "';");

        System.out.println(" made update with basic stuff");
        //now to save classes: - done
        int classAmount = allGrades.size();
        for (int i = 0; i < classAmount; i++) {
            if (allGrades.get(i).getClassTickValue())//actually what user ticked NOW
            {
                //if this class is selected as one this teacher homerooms - set it as their homeroom
                // but only if empl is NOT already homerooming it:

                System.out.println(" in IF if this class is selected as one this teacher homerooms - set it as their homeroom");
                if (allGrades.get(i).getEmplID() != EmplID)
                    //UPDATE progschema.tbl_classes
                    //SET employee_id='1'
                    //WHERE id_classes='6';
                    con.createStatement().executeUpdate("UPDATE progschema.tbl_classes SET employee_id='" +
                            EmplID + "' WHERE id_classes='" + allGrades.get(i).getClassID() + "';");
            }
        }
        // now set subjects: - done
        int subjAmount = allSubjects.size();

        for (int i = 0; i<subjAmount; i++) {
            if (allSubjects.get(i).getSubjTickValue()) {
                //if TICK was selected:
                System.out.println(" in IF  subject tick waas selected");

                if (allSubjects.get(i).getWhoWhatId() != null) {
                    //if it has WhoWhatId - UPDATE payment in this record

                    System.out.println(" in IF  subject tick waas selected + it has WhoWhatId - UPDATE payment in this record");
                    /*
                    UPDATE progschema.tbl_who_does_subject
                    SET payment='2'
                    WHERE id_who_does_which_subject ='1';
                    * */
                    con.createStatement().executeUpdate("UPDATE progschema.tbl_who_does_subject " +
                            "SET payment='" + allSubjects.get(i).getSubjPaymentValue() + "' WHERE id_who_does_which_subject ='" +
                            allSubjects.get(i).getWhoWhatId() + "';");
                } else {
                    //if it does NOT have WhoWhatId - CREATE new such record
                    System.out.println(" in IF  subject tick if it does NOT have WhoWhatId");
                    /*
                    INSERT INTO progschema.tbl_who_does_subject(employee_id,subject_id,payment)
                    VALUES ('15','1','900');
                    * */
                    con.createStatement().executeUpdate("INSERT INTO progschema.tbl_who_does_subject(employee_id,subject_id,payment) " +
                            "VALUES ('" + EmplID + "','" + allSubjects.get(i).getSubjID() +
                            "','" + allSubjects.get(i).getSubjPaymentValue() + "');");
                }
            } else {
                //if TICK was not selected:
                if (allSubjects.get(i).getWhoWhatId() != null) {
                    //if it has WhoWhatId - DELETE this pay record

                    System.out.println(" in IF  subject tick not selected + it has WhoWhatId");
                    /*
                    DELETE FROM progschema.tbl_who_does_subject WHERE id_who_does_which_subject='11';
                    * */
                    con.createStatement().executeUpdate("DELETE FROM progschema.tbl_who_does_subject WHERE id_who_does_which_subject='" +
                            allSubjects.get(i).getWhoWhatId() + "';");
                }
                // else - if it has NO WhoWhatId - do nothing
            }
        }
// to set group Studios: - allGStudios
            int gStudioAmount = allGStudios.size();

            for (int i = 0; i<gStudioAmount; i++) {
                if (allGStudios.get(i).getGStudioTickValue()) {
                    //if TICK was selected:
                    if (allGStudios.get(i).getWhoWhatId() != null) {
                        //if it has WhoWhatId - UPDATE payment in this record

                        System.out.println(" in IF G studio  tick  selected + it has WhoWhatId");
                    /*
                    UPDATE progschema.tbl_who_does_stiduo_g
                    SET payment_rate='2'
                    WHERE id_who_does_g ='1';
                    * */
                        con.createStatement().executeUpdate("UPDATE progschema.tbl_who_does_stiduo_g " +
                                "SET payment_rate='" + allGStudios.get(i).getGStudioPaymentValue() + "' WHERE id_who_does_g ='" +
                                allGStudios.get(i).getWhoWhatId() + "';");
                    } else {
                        //if it does NOT have WhoWhatId - CREATE new such record
                        System.out.println(" in IF G studio  tick  selected + if it does NOT have WhoWhatId");
                    /*
                    INSERT INTO progschema.tbl_who_does_stiduo_g(employee_id,studio_in_group_id,payment_rate)
                    VALUES ('15','1','900');
                    * */
                        con.createStatement().executeUpdate("INSERT INTO progschema.tbl_who_does_stiduo_g(employee_id,studio_in_group_id,payment_rate) " +
                                "VALUES ('" + EmplID + "','" + allGStudios.get(i).getGStudioID() +
                                "','" + allGStudios.get(i).getGStudioPaymentValue() + "');");
                    }
                } else {
                    //if TICK was not selected:
                    if (allGStudios.get(i).getWhoWhatId() != null) {
                        //if it has WhoWhatId - DELETE this pay record
                        System.out.println(" in IF G studio  if TICK was not selected + has WhoWhatId");
                    /*
                    DELETE FROM progschema.tbl_who_does_stiduo_g WHERE id_who_does_g='14';
                    * */
                        con.createStatement().executeUpdate("DELETE FROM progschema.tbl_who_does_stiduo_g WHERE id_who_does_g='" +
                                allGStudios.get(i).getWhoWhatId() + "';");
                    }
                    // else - if it has NO WhoWhatId - do nothing
                }
            }

// to set Hourly Studios: - allHStudios
                int hStudioAmount = allHStudios.size();

                for (int i = 0; i<hStudioAmount; i++) {
                    if (allHStudios.get(i).getHStudioTickValue()) {
                        //if TICK was selected:
                        if (allHStudios.get(i).getWhoWhatId() != null) {
                            //if it has WhoWhatId - UPDATE payment in this record
                            System.out.println(" in IF H studio  if TICK was selected + has WhoWhatId");
                    /*
                    UPDATE progschema.tbl_who_does_stiduo_h
                    SET payment_rate='2'
                    WHERE id_who_does_h ='2';
                    * */
                            con.createStatement().executeUpdate("UPDATE progschema.tbl_who_does_stiduo_h " +
                                    "SET payment_rate='" + allHStudios.get(i).getHStudioPaymentValue() + "' WHERE id_who_does_h ='" +
                                    allHStudios.get(i).getWhoWhatId() + "';");
                        } else {
                            //if it does NOT have WhoWhatId - CREATE new such record
                            System.out.println(" in IF H studio  if TICK was selected + has NO WhoWhatId");
                    /*
                    INSERT INTO progschema.tbl_who_does_stiduo_h(employee_id,studio_hourly_id,payment_rate)
                    VALUES ('15','1','900');
                    * */
                            con.createStatement().executeUpdate("INSERT INTO progschema.tbl_who_does_stiduo_h(employee_id,studio_hourly_id,payment_rate) " +
                                    "VALUES ('" + EmplID + "','" + allHStudios.get(i).getHStudioID() +
                                    "','" + allHStudios.get(i).getHStudioPaymentValue() + "');");
                        }
                    } else {
                        //if TICK was not selected:
                        if (allHStudios.get(i).getWhoWhatId() != null) {
                            //if it has WhoWhatId - DELETE this pay record
                            System.out.println(" in IF H studio  if TICK was NOT selected + has WhoWhatId");
                    /*
                    DELETE FROM progschema.tbl_who_does_stiduo_h WHERE id_who_does_h='5';
                    * */
                            con.createStatement().executeUpdate("DELETE FROM progschema.tbl_who_does_stiduo_h WHERE id_who_does_h='" +
                                    allHStudios.get(i).getWhoWhatId() + "';");
                        }
                        // else - if it has NO WhoWhatId - do nothing
                    }
                }
// now save services: allServices
                    int servicesAmount = allServices.size();

                    for (int i = 0; i<servicesAmount; i++) {
                        if (allServices.get(i).getServiceTickValue()) {
                            //if TICK was selected:
                            if (allServices.get(i).getWhoWhatId() != null) {
                                //if it has WhoWhatId - UPDATE payment in this record
                                System.out.println(" in IF service  if TICK was selected + has WhoWhatId");
                    /*
                    UPDATE progschema.tbl_who_does_service
                    SET payment_rate='2'
                    WHERE id_who_does_which_service ='2';
                    * */
                                con.createStatement().executeUpdate("UPDATE progschema.tbl_who_does_service " +
                                        "SET payment_rate='" + allServices.get(i).getServicePaymentValue() + "' WHERE id_who_does_which_service ='" +
                                        allServices.get(i).getWhoWhatId() + "';");
                            } else {
                                //if it does NOT have WhoWhatId - CREATE new such record
                                System.out.println(" in IF service  if TICK was selected + has NO WhoWhatId");
                    /*
                    INSERT INTO progschema.tbl_who_does_service(employee_id,service_id,payment_rate)
                    VALUES ('15','2','900');
                    * */
                                con.createStatement().executeUpdate("INSERT INTO progschema.tbl_who_does_service(employee_id,service_id,payment_rate) " +
                                        "VALUES ('" + EmplID + "','" + allServices.get(i).getServiceID() +
                                        "','" + allServices.get(i).getServicePaymentValue() + "');");
                            }
                        } else {
                            //if TICK was not selected:
                            if (allServices.get(i).getWhoWhatId() != null) {
                                //if it has WhoWhatId - DELETE this pay record
                                System.out.println(" in IF service  if TICK was NOT selected + has WhoWhatId");
                    /*
                    DELETE FROM progschema.tbl_who_does_service WHERE id_who_does_which_service='5';
                    * */
                                con.createStatement().executeUpdate("DELETE FROM progschema.tbl_who_does_service WHERE id_who_does_which_service='" +
                                        allServices.get(i).getWhoWhatId() + "';");
                            }
                            // else - if it has NO WhoWhatId - do nothing
                        }
                    }
    }
    catch(ClassNotFoundException e){
        e.printStackTrace();
    } catch(SQLException throwables){
        throwables.printStackTrace();
    }
}
//now all was saved, close the window:
        System.out.println(" you clicked  save One Empl and it was saved");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("TableViewEmployees.fxml"));
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
    void initialize() {

        System.out.println("in openOneEmplToEdit:");
        DatabaseHandler dbHandler = new DatabaseHandler();
        Connection con = null;
        try {
            con = dbHandler.getDbConnection();
            //SELECT actual_data FROM progschema.dump WHERE iddump =1;
            ResultSet rs = con.createStatement().executeQuery("SELECT actual_data FROM progschema.dump WHERE iddump =1;");
            if (rs.next()) {
                //if was opened OLD pupil
                itIsNewEmpl = false;
                EmplID = rs.getString("actual_data");//save ID  to show in this window
                //clean up DUMP table:
                con.createStatement().executeUpdate("DELETE FROM progschema.dump WHERE iddump = 1;");

                //HERE I NEED TO FILL OLD EMPL:
                /*
                SELECT employee_name, employee_surname, employee_status, employee_is_teacher
                FROM progschema.tbl_employees
                WHERE employee_id='1';
                * */
                rs = con.createStatement().executeQuery("SELECT employee_name, employee_surname, employee_status, employee_is_teacher FROM progschema.tbl_employees WHERE employee_id='"+EmplID+"';");
                while (rs.next())
                {
                    Employee ThisEmployee = new Employee (EmplID, rs.getString("employee_name"), rs.getString("employee_surname"), rs.getString("employee_status"),rs.getString("employee_is_teacher"));
                    /*
                    SELECT * FROM progschema.tbl_classes;
                     */

                    rs = con.createStatement().executeQuery("SELECT * FROM progschema.tbl_classes;");
                    while (rs.next()) {
                        GradeClass gClass;

                        System.out.println("!!!!!!!!!!!!NOW WILL DO (rs.getString(employee_id).equals(EmplID)");
                        System.out.println("rs.getString(employee_id====" + rs.getString("employee_id"));
                        System.out.println("and EmplID==="+EmplID);
                        //Objects.equals(rs.getString("employee_id"),EmplID)
                        //if (rs.getString("employee_id").equals(EmplID)){
                        gClass = new GradeClass(rs.getString("id_classes"),rs.getString("class_name"),rs.getString("employee_id"));
                        if (Objects.equals(rs.getString("employee_id"),EmplID))
                        {
                            //if thisEmpl is homeroom teacher in this class
                           // gClass = new GradeClass(rs.getString("id_classes"),rs.getString("class_name"),rs.getString("employee_id"));
                            gClass.setClassTickValue(true);
                        }
                        else
                        {
                            //if thisEmpl is NOT a homeroom teacher in this class
                            //gClass = new GradeClass(rs.getString("id_classes"),rs.getString("class_name"),rs.getString("employee_id"));
                            gClass.setClassTickValue(false);
                        }
                        allGrades.add(gClass);


                    }
                    /*
                    SELECT progschema.tbl_subjects.id_subject,
                    progschema.tbl_subjects.subject_name, a.payment, a.id_who_does_which_subject
                    FROM ( SELECT payment, subject_id, id_who_does_which_subject FROM progschema.tbl_who_does_subject
                    WHERE employee_id='1' ) AS a RIGHT JOIN progschema.tbl_subjects ON subject_id=id_subject ;
                    * */
                    rs = con.createStatement().executeQuery("SELECT progschema.tbl_subjects.id_subject,"+
                            "progschema.tbl_subjects.subject_name, a.payment, a.id_who_does_which_subject "+
                            "FROM ( SELECT payment, subject_id, id_who_does_which_subject FROM progschema.tbl_who_does_subject "+
                            "WHERE employee_id='"+EmplID+"' ) AS a RIGHT JOIN progschema.tbl_subjects ON subject_id=id_subject ;");

                    while (rs.next()) {
                        smallSubject smallSubj;

                        System.out.println("!!!!!!!!!!!!NOW WILL fill subjects! empl id==");
                        System.out.println(EmplID);
                        //Objects.equals(rs.getString("employee_id"),EmplID)
                        //if (rs.getString("employee_id").equals(EmplID)){
                        smallSubj = new smallSubject(rs.getString("id_subject"),rs.getString("subject_name"),rs.getString("payment"),rs.getString("id_who_does_which_subject"));
                        if (rs.getString("payment")!=null)
                        {
                            //if teacher teaches this
                            // gClass = new GradeClass(rs.getString("id_classes"),rs.getString("class_name"),rs.getString("employee_id"));
                            smallSubj.setSubjTickValue(true);
                        }
                        else
                        {
                            //if thisEmpl is NOT a homeroom teacher in this class
                            //gClass = new GradeClass(rs.getString("id_classes"),rs.getString("class_name"),rs.getString("employee_id"));
                            smallSubj.setSubjTickValue(false);
                        }
                        allSubjects.add(smallSubj);
                    }
                    //now to get Group Studios data:
                    /*
                    SELECT progschema.tbl_group_studios.id_group_studios,
                    progschema.tbl_group_studios.group_studios_name, a.payment_rate, a.id_who_does_g
                    FROM ( SELECT payment_rate, studio_in_group_id, id_who_does_g FROM progschema.tbl_who_does_stiduo_g
                    WHERE employee_id='1' ) AS a RIGHT JOIN progschema.tbl_group_studios ON studio_in_group_id=id_group_studios;
                    * */
                    rs = con.createStatement().executeQuery("SELECT progschema.tbl_group_studios.id_group_studios,"+
                            "progschema.tbl_group_studios.group_studios_name, a.payment_rate, a.id_who_does_g "+
                            "FROM ( SELECT payment_rate, studio_in_group_id, id_who_does_g FROM progschema.tbl_who_does_stiduo_g "+
                            "WHERE employee_id='"+EmplID+"' ) AS a RIGHT JOIN progschema.tbl_group_studios ON studio_in_group_id=id_group_studios;");

                    while (rs.next()) {
                        smallGroupStudio groupStudio;

                        System.out.println("!!!!!!!!!!!!NOW WILL fill Group studios!");
                        groupStudio = new smallGroupStudio(rs.getString("id_group_studios"),rs.getString("group_studios_name"),rs.getString("payment_rate"),rs.getString("id_who_does_g"));
                        if (rs.getString("payment_rate")!=null)
                        {
                            //if teacher teaches this
                            groupStudio.setGStudioTickValue(true);
                        }
                        else
                        {
                            //if thisEmpl is NOT a homeroom teacher in this class
                            groupStudio.setGStudioTickValue(false);
                        }
                        allGStudios.add(groupStudio);


                    }
                    //now to get Hourly Studios data:
                    /*
                    SELECT progschema.tbl_studio_hourly.id_studio_hourly,
                    progschema.tbl_studio_hourly.name_studio_hourly, a.payment_rate
                    FROM ( SELECT payment_rate, studio_hourly_id FROM progschema.tbl_who_does_stiduo_h
                    WHERE employee_id='1' ) AS a RIGHT JOIN progschema.tbl_studio_hourly ON studio_hourly_id=id_studio_hourly;
                    * */
                    rs = con.createStatement().executeQuery("SELECT progschema.tbl_studio_hourly.id_studio_hourly,"+
                            "progschema.tbl_studio_hourly.name_studio_hourly, a.payment_rate, a.id_who_does_h "+
                            "FROM ( SELECT payment_rate, studio_hourly_id, id_who_does_h FROM progschema.tbl_who_does_stiduo_h "+
                            "WHERE employee_id='"+EmplID+"' ) AS a RIGHT JOIN progschema.tbl_studio_hourly ON studio_hourly_id=id_studio_hourly;");

                    while (rs.next()) {
                        smallHourlyStudio hourlyStudio;

                        System.out.println("!!!!!!!!!!!!NOW WILL fill Horly studios!");
                        hourlyStudio = new smallHourlyStudio(rs.getString("id_studio_hourly"),rs.getString("name_studio_hourly"),rs.getString("payment_rate"),rs.getString("id_who_does_h"));
                        if (rs.getString("payment_rate")!=null)
                        {
                            //if teacher teaches this
                            hourlyStudio.setHStudioTickValue(true);
                        }
                        else
                        {
                            //if thisEmpl is NOT a homeroom teacher in this class
                            hourlyStudio.setHStudioTickValue(false);
                        }
                        allHStudios.add(hourlyStudio);
                    }
                    //now to get Services data:
                    /*
                    SELECT progschema.tbl_service.id_service,
                    progschema.tbl_service.service_name, a.payment_rate, a.id_who_does_which_service
                    FROM ( SELECT payment_rate, service_id, id_who_does_which_service FROM progschema.tbl_who_does_service
                    WHERE employee_id='1' ) AS a RIGHT JOIN progschema.tbl_service ON service_id=id_service;
                    * */
                    rs = con.createStatement().executeQuery("SELECT progschema.tbl_service.id_service,"+
                            "progschema.tbl_service.service_name, a.payment_rate, a.id_who_does_which_service "+
                            "FROM ( SELECT payment_rate, service_id, id_who_does_which_service FROM progschema.tbl_who_does_service "+
                            "WHERE employee_id='"+EmplID+"' ) AS a RIGHT JOIN progschema.tbl_service ON service_id=id_service;");

                    while (rs.next()) {
                        smallService service;

                        System.out.println("!!!!!!!!!!!!NOW WILL fill services!");
                        service = new smallService(rs.getString("id_service"),rs.getString("service_name"),rs.getString("payment_rate"),rs.getString("id_who_does_which_service"));
                        if (rs.getString("payment_rate")!=null)
                        {
                            //if teacher does this
                            service.setServiceTickValue(true);
                        }
                        else
                        {
                            //if thisEmpl does NOT
                            service.setServiceTickValue(false);
                        }
                        allServices.add(service);
                    }





                    // filling with gathered data:
                    emplNameTextField.setText(ThisEmployee.getEmpName());
                    emplSurnameTextField.setText(ThisEmployee.getEmpSurname());
                    //ObservableList<String> availableStatusChoices = FXCollections.ObservableArrayList("работает", "не работает");
                    emplStatussChoiceBox.setItems(availableStatusChoices);
                    if (ThisEmployee.getEmpStatus().equals("1")) {
                        emplStatussChoiceBox.setValue("работает");
                        System.out.println("ThisEmployee.getEmpStatus()==1");
                    }
                    else {
                        emplStatussChoiceBox.setValue("не работает");
                        System.out.println("ThisEmployee.getEmpStatus()!=1");
                    }
                    if (ThisEmployee.getEmpIsTeacher().equals("1")) {
                        empl_isTeacherRadioButton.setSelected(true);
                        System.out.println("ThisEmployee.getEmpIsTeacher()====1");
                    }
                    else {
                        empl_NOTaTeacherRadioButton.setSelected(true);
                        System.out.println("empl_NOTaTeacherRadioButton()!=1");
                    }
                    //now tables:
                    //classes:
                    emplClass_TickColumn.setCellValueFactory(new PropertyValueFactory<GradeClass,CheckBox>("classTick"));
                    emplClass_name.setCellValueFactory(new PropertyValueFactory<GradeClass,String>("className"));
                    emplClassID_invColumn.setCellValueFactory(new PropertyValueFactory<GradeClass,String>("classID"));
                    //emplClassID_invColumn.setCellValueFactory(cellData -> cellData.getValue().classIDProperty());//this also works
                    //emplClass_name.setCellValueFactory(cellData -> cellData.getValue().classNameProperty());
                    emplHomeroom_TableView.setItems(allGrades);
                    //subjects:
                    emplSubjectID_invColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,String>("subjID"));
                    emplSubject_TickColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,CheckBox>("subjTick"));
                    emplSubject_nameColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,String>("subjName"));
                    emplSubject_paymentColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,TextField>("subjPayment"));
                    emplSubject_TableView.setItems(allSubjects);
                    //group studios:
                    emplGStudioID_invColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,String>("gStudioID"));
                    emplGStudio_TickColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,CheckBox>("gStudioTick"));
                    emplGstudio_nameColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,String>("gStudioName"));
                    emplGStudio_paymentColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,TextField>("gStudioPayment"));
                    emplGStudio_TableView.setItems(allGStudios);
                    //hourly studios:
                    emplHStudioID_invColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,String>("hStudioID"));
                    emplHStudio_TickColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,CheckBox>("hStudioTick"));
                    emplHStudio_nameColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,String>("hStudioName"));
                    emplHStudio_paymentColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,TextField>("hStudioPayment"));
                    emplHStudio_TableView.setItems(allHStudios);
                    //services:
                    emplServisID_invColumn.setCellValueFactory(new PropertyValueFactory<smallService,String>("serviceID"));
                    emplServis_TickColumn.setCellValueFactory(new PropertyValueFactory<smallService,CheckBox>("serviceTick"));
                    emplServis_nameColumn.setCellValueFactory(new PropertyValueFactory<smallService,String>("serviceName"));
                    emplService_paymentColumn.setCellValueFactory(new PropertyValueFactory<smallService,TextField>("servicePayment"));
                    emplServiss_TableView.setItems(allServices);

                }


            }
            else
            {
                itIsNewEmpl = true;

                    /*
                    SELECT * FROM progschema.tbl_classes;
                     */
                    rs = con.createStatement().executeQuery("SELECT * FROM progschema.tbl_classes;");
                    while (rs.next()) {
                        GradeClass gClass;
                        gClass = new GradeClass(rs.getString("id_classes"),rs.getString("class_name"),rs.getString("employee_id"));
                        //gClass.setClassTickValue(false);//idk if need this
                        allGrades.add(gClass);
                        }
                    /*
                    SELECT progschema.tbl_subjects.id_subject,
                    progschema.tbl_subjects.subject_name
                    FROM progschema.tbl_subjects;
                    * */
                    rs = con.createStatement().executeQuery("SELECT progschema.tbl_subjects.id_subject,"+
                            "progschema.tbl_subjects.subject_name "+
                            "FROM progschema.tbl_subjects;");

                    while (rs.next()) {
                        smallSubject smallSubj;
                        smallSubj = new smallSubject(rs.getString("id_subject"),rs.getString("subject_name"),null,null);
                        //smallSubj.setSubjTickValue(false);//maybe need this
                        allSubjects.add(smallSubj);
                        }
                    //now to get Group Studios data:
                    /*
                    SELECT progschema.tbl_group_studios.id_group_studios,
                    progschema.tbl_group_studios.group_studios_name
                    FROM progschema.tbl_group_studios;
                    * */
                    rs = con.createStatement().executeQuery("SELECT progschema.tbl_group_studios.id_group_studios,"+
                            "progschema.tbl_group_studios.group_studios_name "+
                            "FROM progschema.tbl_group_studios;");
                    while (rs.next()) {
                        smallGroupStudio groupStudio;
                        groupStudio = new smallGroupStudio(rs.getString("id_group_studios"),rs.getString("group_studios_name"),null,null);
                        //groupStudio.setGStudioTickValue(false);//idk if need
                        allGStudios.add(groupStudio);
                    }
                    //now to get Hourly Studios data:
                    /*
                    SELECT progschema.tbl_studio_hourly.id_studio_hourly,
                    progschema.tbl_studio_hourly.name_studio_hourly
                    FROM progschema.tbl_studio_hourly;
                    * */
                    rs = con.createStatement().executeQuery("SELECT progschema.tbl_studio_hourly.id_studio_hourly,"+
                            "progschema.tbl_studio_hourly.name_studio_hourly "+
                            "FROM progschema.tbl_studio_hourly;");

                    while (rs.next()) {
                        smallHourlyStudio hourlyStudio;
                        hourlyStudio = new smallHourlyStudio(rs.getString("id_studio_hourly"),rs.getString("name_studio_hourly"),null,null);
                        //hourlyStudio.setHStudioTickValue(false);//idk if need
                        allHStudios.add(hourlyStudio);
                    }
                    //now to get Services data:
                    /*
                    SELECT progschema.tbl_service.id_service,
                    progschema.tbl_service.service_name
                    FROM progschema.tbl_service;
                    * */
                    rs = con.createStatement().executeQuery("SELECT progschema.tbl_service.id_service,"+
                            "progschema.tbl_service.service_name "+
                            "FROM progschema.tbl_service;");

                    while (rs.next()) {
                        smallService service;
                        service = new smallService(rs.getString("id_service"),rs.getString("service_name"),null,null);
                        //service.setServiceTickValue(false);//idk if need
                        allServices.add(service);
                    }
                    // filling with gathered data:
                    emplStatussChoiceBox.setItems(availableStatusChoices);
                    //emplStatussChoiceBox.setValue("не работает");//maybe will need
                    empl_isTeacherRadioButton.setSelected(true);
                    //now tables:
                    //classes:
                    emplClass_TickColumn.setCellValueFactory(new PropertyValueFactory<GradeClass,CheckBox>("classTick"));
                    emplClass_name.setCellValueFactory(new PropertyValueFactory<GradeClass,String>("className"));
                    emplClassID_invColumn.setCellValueFactory(new PropertyValueFactory<GradeClass,String>("classID"));
                    //emplClassID_invColumn.setCellValueFactory(cellData -> cellData.getValue().classIDProperty());//this also works
                    //emplClass_name.setCellValueFactory(cellData -> cellData.getValue().classNameProperty());
                    emplHomeroom_TableView.setItems(allGrades);
                    //subjects:
                    emplSubjectID_invColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,String>("subjID"));
                    emplSubject_TickColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,CheckBox>("subjTick"));
                    emplSubject_nameColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,String>("subjName"));
                    emplSubject_paymentColumn.setCellValueFactory(new PropertyValueFactory<smallSubject,TextField>("subjPayment"));
                    emplSubject_TableView.setItems(allSubjects);
                    //group studios:
                    emplGStudioID_invColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,String>("gStudioID"));
                    emplGStudio_TickColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,CheckBox>("gStudioTick"));
                    emplGstudio_nameColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,String>("gStudioName"));
                    emplGStudio_paymentColumn.setCellValueFactory(new PropertyValueFactory<smallGroupStudio,TextField>("gStudioPayment"));
                    emplGStudio_TableView.setItems(allGStudios);
                    //hourly studios:
                    emplHStudioID_invColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,String>("hStudioID"));
                    emplHStudio_TickColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,CheckBox>("hStudioTick"));
                    emplHStudio_nameColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,String>("hStudioName"));
                    emplHStudio_paymentColumn.setCellValueFactory(new PropertyValueFactory<smallHourlyStudio,TextField>("hStudioPayment"));
                    emplHStudio_TableView.setItems(allHStudios);
                    //services:
                    emplServisID_invColumn.setCellValueFactory(new PropertyValueFactory<smallService,String>("serviceID"));
                    emplServis_TickColumn.setCellValueFactory(new PropertyValueFactory<smallService,CheckBox>("serviceTick"));
                    emplServis_nameColumn.setCellValueFactory(new PropertyValueFactory<smallService,String>("serviceName"));
                    emplService_paymentColumn.setCellValueFactory(new PropertyValueFactory<smallService,TextField>("servicePayment"));
                    emplServiss_TableView.setItems(allServices);

            }
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

            }

}
