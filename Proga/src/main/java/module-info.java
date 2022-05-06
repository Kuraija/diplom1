module group.proga {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens group.proga to javafx.fxml;
    exports group.proga;
    exports group.proga.entities;//I added this line
    exports group.proga.dbthings;//I added this line
}