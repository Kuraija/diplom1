package group.proga;
//fill this LATER when TableViewController is done 100%

        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Menu;
        import javafx.scene.control.MenuBar;
        import javafx.scene.control.MenuItem;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.layout.AnchorPane;

public class TableViewOldPupilsController {

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
    private Button NewPupilButton;

    @FXML
    private MenuItem OpenNewTablesMenuItem;

    @FXML
    private MenuItem OpenOldMenuItem;

    @FXML
    private TableView<?> PupilListTableView;

    @FXML
    private TableColumn<?, ?> PupilMotherPKColumn;

    @FXML
    private TableColumn<?, ?> PupilStartDateColumn;

    @FXML
    private TableColumn<?, ?> PupilStopDateColumn;

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

    @FXML
    private MenuBar mainMenuBar;

    @FXML
    private TableColumn<?, ?> pupilClassColumn;

    @FXML
    private TableColumn<?, ?> pupilFatherNameColumn;

    @FXML
    private TableColumn<?, ?> pupilFatherPKColumn;

    @FXML
    private TableColumn<?, ?> pupilID_invisbl_Column;

    @FXML
    private TableColumn<?, ?> pupilMotherNameColumn;

    @FXML
    private TableColumn<?, ?> pupilNameColumn;

    @FXML
    private TableColumn<?, ?> pupilPKcolumn;

    @FXML
    private TableColumn<?, ?> pupilSurnameColumn;

    @FXML
    private TableColumn<?, ?> tickColumn;

    @FXML
    void DeleteThisPupilFromDB(ActionEvent event) {

    }

    @FXML
    void EditThisPupil(ActionEvent event) {

    }

    @FXML
    void createNewPupil(ActionEvent event) {

    }

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
    void initialize() {
        assert CalendarMenuItem != null : "fx:id=\"CalendarMenuItem\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert CatalogsMenu != null : "fx:id=\"CatalogsMenu\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert ClassMenuItem != null : "fx:id=\"ClassMenuItem\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert EditButton != null : "fx:id=\"EditButton\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert EmployeesMenuItem != null : "fx:id=\"EmployeesMenuItem\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert ExportTableMenuItem != null : "fx:id=\"ExportTableMenuItem\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert FormerPupilsMenuItem != null : "fx:id=\"FormerPupilsMenuItem\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert NewPupilButton != null : "fx:id=\"NewPupilButton\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert OpenNewTablesMenuItem != null : "fx:id=\"OpenNewTablesMenuItem\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert OpenOldMenuItem != null : "fx:id=\"OpenOldMenuItem\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert PupilListTableView != null : "fx:id=\"PupilListTableView\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert PupilMotherPKColumn != null : "fx:id=\"PupilMotherPKColumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert PupilStartDateColumn != null : "fx:id=\"PupilStartDateColumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert PupilStopDateColumn != null : "fx:id=\"PupilStopDateColumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert PupilsMenuItem != null : "fx:id=\"PupilsMenuItem\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert SubjectsMenuItem != null : "fx:id=\"SubjectsMenuItem\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert TablesMenu != null : "fx:id=\"TablesMenu\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert mainMenuAnchorPane != null : "fx:id=\"mainMenuAnchorPane\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert mainMenuAnchorPane1 != null : "fx:id=\"mainMenuAnchorPane1\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert mainMenuBar != null : "fx:id=\"mainMenuBar\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert pupilClassColumn != null : "fx:id=\"pupilClassColumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert pupilFatherNameColumn != null : "fx:id=\"pupilFatherNameColumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert pupilFatherPKColumn != null : "fx:id=\"pupilFatherPKColumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert pupilID_invisbl_Column != null : "fx:id=\"pupilID_invisbl_Column\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert pupilMotherNameColumn != null : "fx:id=\"pupilMotherNameColumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert pupilNameColumn != null : "fx:id=\"pupilNameColumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert pupilPKcolumn != null : "fx:id=\"pupilPKcolumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert pupilSurnameColumn != null : "fx:id=\"pupilSurnameColumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";
        assert tickColumn != null : "fx:id=\"tickColumn\" was not injected: check your FXML file 'TableViewOldPupils.fxml'.";

    }

}
