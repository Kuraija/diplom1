package group.proga;

import group.proga.dbthings.DatabaseHandler;
import group.proga.entities.Pupil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu {

    void openCurrentPupilsTable() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/group/proga/TableViewPupils.fxml"));
        try{
            loader.load();
        }catch (IOException e){e.printStackTrace();}
        Parent root= loader.getRoot();//putj k nuznomu failu
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    void openOldPupilsTable() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/group/proga/TableViewOldPupils.fxml"));
        try{
            loader.load();
        }catch (IOException e){e.printStackTrace();}
        Parent root= loader.getRoot();
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    void openEmployeesTable() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/group/proga/TableViewEmployees.fxml"));
        try{
            loader.load();
        }catch (IOException e){e.printStackTrace();}
        Parent root= loader.getRoot();
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    void openSubjectsTable() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/group/proga/TableViewSubjects.fxml"));
        try{
            loader.load();
        }catch (IOException e){e.printStackTrace();}
        Parent root= loader.getRoot();
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    void openServicesTable() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/group/proga/TableViewServices.fxml"));
        try{
            loader.load();
        }catch (IOException e){e.printStackTrace();}
        Parent root= loader.getRoot();
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    void openHourlyStudiosTable() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/group/proga/TableViewHourlyStudios.fxml"));
        try{
            loader.load();
        }catch (IOException e){e.printStackTrace();}
        Parent root= loader.getRoot();
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
    void openGroupStudiosTable() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/group/proga/TableViewGroupStudios.fxml"));
        try{
            loader.load();
        }catch (IOException e){e.printStackTrace();}
        Parent root= loader.getRoot();
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}
