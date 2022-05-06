package group.proga.entities;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

public class Pupil {

    public CheckBox pupilTick;
    public StringProperty pupilID;
    public StringProperty pupilName;
    public StringProperty pupilSurname;
    public StringProperty pupilPK;
    public StringProperty pupilClass;
    public StringProperty pupilStartDate;
    public StringProperty pupilEndDate;
    public StringProperty pupilMotherPK;
    public StringProperty pupilMotherName;
    public StringProperty pupilFatherPK;
    public StringProperty pupilFatherName;




    //---------------
    //private final BooleanProperty delete = new SimpleBooleanProperty();


    public Pupil( String pupilIDs,String pupilClasss,
                   String pupilSurnames,String pupilNames,
                  String pupilPKs,
                  String pupilStartDates, String pupilEndDates,
                  String pupilMotherPKs, String pupilMotherNames,
                  String pupilFatherPKs, String pupilFatherNames)
    {
        this.pupilTick = new CheckBox();
        Object id = pupilIDs;
        this.pupilID = new SimpleStringProperty((String)id);
        Object na = pupilNames;
        this.pupilName = new SimpleStringProperty((String)na);
        Object su = pupilSurnames;
        this.pupilSurname = new SimpleStringProperty((String)su);
        Object pk = pupilPKs;
        this.pupilPK = new SimpleStringProperty((String) pk);
        Object cl = pupilClasss;
        this.pupilClass = new SimpleStringProperty((String)cl);
        Object ad = pupilStartDates;
        this.pupilStartDate = new SimpleStringProperty((String)ad);
        Object ed = pupilEndDates;
        this.pupilEndDate = new SimpleStringProperty((String)ed);
        Object mpk = pupilMotherPKs;
        this.pupilMotherPK = new SimpleStringProperty((String)mpk);
        Object mn = pupilMotherNames;
        this.pupilMotherName = new SimpleStringProperty((String)mn);
        Object fpk = pupilFatherPKs;
        this.pupilFatherPK = new SimpleStringProperty((String)fpk);
        Object fn = pupilFatherNames;
        this.pupilFatherName = new SimpleStringProperty((String)fn);
    }

    public CheckBox getPupilTick() {
        return pupilTick;
    }

    public void setPupilTick(CheckBox pupilTick) {
        this.pupilTick = pupilTick;
    }


    public CheckBox pupiltickProperty() {
        System.out.println(" in CheckBoxProperty" );
        return this.pupilTick;
    }

//    public String getPupilID() {
//        return pupilID.get();
//    }

//    public Integer getPupilID(){
//        System.out.println(" in int getPupilID(" );
//        Integer i;
//        i = Integer.valueOf(this.pupilID.getValue());
//        //hopefully it returns int
//        return i;
//    }



    public StringProperty pupilIDProperty() {
        System.out.println(" in StringProperty" );
        return this.pupilID;
    }

    public StringProperty pupilNameProperty() {
        System.out.println(" in StringProperty firstNameProperty" );
        return this.pupilName;
    }
    public StringProperty pupilSurnameProperty() {
        System.out.println(" in StringProperty" );
        return this.pupilSurname;
    }
    public StringProperty pupilPKProperty() {
        System.out.println(" in StringProperty" );
        return this.pupilPK;
    }

    public StringProperty pupilClassProperty() {
        System.out.println(" in StringProperty" );
        return this.pupilClass;
    }

    public StringProperty pupilStartDateProperty() {
        System.out.println(" in StringProperty" );
        return this.pupilStartDate;
    }

    public StringProperty pupilEndDateProperty() {
        System.out.println(" in StringProperty" );
        return this.pupilEndDate;
    }

    public StringProperty pupilMotherPKProperty() {
        System.out.println(" in StringProperty" );
        return this.pupilMotherPK;
    }

    public StringProperty pupilMotherNameProperty() {
        System.out.println(" in StringProperty" );
        return this.pupilMotherName;
    }

    public StringProperty pupilFatherPKProperty() {
        System.out.println(" in StringProperty" );
        return this.pupilFatherPK;
    }

    public StringProperty pupilFatherNameProperty() {
        System.out.println(" in StringProperty" );
        return this.pupilFatherName;
    }


    public void setPupilID(String pupilID) {
        this.pupilID.set(pupilID);
    }
    public String getPupilID(){
        String s;
        s = this.pupilID.getValue();
        return s;
    }

    public String getPupilName() {
        String s;
        s = this.pupilName.getValue();
        return s;
    }

    public void setPupilName(String pupilName) {
        this.pupilName.set(pupilName);
    }

    public String getPupilSurname() {
        String s;
        s = this.pupilSurname.getValue();
        return s;
    }

    public void setPupilSurname(String pupilSurname) {
        this.pupilSurname.set(pupilSurname);
    }

    public String getPupilPK() {
        String s;
        s = this.pupilPK.getValue();
        return s;
    }

    public void setPupilPK(String pupilPK) {
        this.pupilPK.set(pupilPK);
    }

    public String getPupilClass() {
        String s;
        s = this.pupilClass.getValue();
        return s;
    }

    public void setPupilClass(String pupilClass) {
        this.pupilClass.set(pupilClass);
    }

    public String getPupilStartDate() {
        String s;
        s = this.pupilStartDate.getValue();
        return s;
    }

    public void setPupilStartDate(String pupilStartDate) {
        this.pupilStartDate.set(pupilStartDate);
    }

    public String getPupilEndDate() {
        String s;
        s = this.pupilEndDate.getValue();
        return s;
    }

    public void setPupilEndDate(String pupilEndDate) {
        this.pupilEndDate.set(pupilEndDate);
    }

    public String getPupilMotherPK() {
        String s;
        s = this.pupilMotherPK.getValue();
        return s;
    }

    public void setPupilMotherPK(String pupilMotherPK) {
        this.pupilMotherPK.set(pupilMotherPK);
    }

    public String getPupilMotherName() {
        String s;
        s = this.pupilMotherName.getValue();
        return s;
    }

    public void setPupilMotherName(String pupilMotherName) {
        this.pupilMotherName.set(pupilMotherName);
    }

    public String getPupilFatherPK() {
        String s;
        s = this.pupilFatherPK.getValue();
        return s;
    }

    public void setPupilFatherPK(String pupilFatherPK) {
        this.pupilFatherPK.set(pupilFatherPK);
    }

    public String getPupilFatherName() {
        String s;
        s = this.pupilFatherName.getValue();
        return s;
    }

    public void setPupilFatherName(String pupilFatherName) {
        this.pupilFatherName.set(pupilFatherName);
    }
}
