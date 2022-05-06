package group.proga.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

public class Employee {
//here I changed just getters and Constructor from automatic ones


    public CheckBox empTick;
    public StringProperty empID;
    public StringProperty empName;
    public StringProperty empSurname;
    public StringProperty empStatus;
    public StringProperty empIsTeacher;
    public StringProperty empIsHomeroomTeacher;

    public Employee ( String empIDs,String empNames,
                  String empSurnames,String empStatuss, String empIsTeachers) {
        this.empTick = new CheckBox();
        Object id = empIDs;
        this.empID = new SimpleStringProperty((String) id);
        Object na = empNames;
        this.empName = new SimpleStringProperty((String) na);
        Object su = empSurnames;
        this.empSurname = new SimpleStringProperty((String) su);
        Object st = empStatuss;
        this.empStatus = new SimpleStringProperty((String) st);
        Object ist = empIsTeachers;
        this.empIsTeacher = new SimpleStringProperty((String) ist);
    }

    public Employee ( String empIDs,String empNames,
                      String empSurnames,String empStatuss,
                      String empIsTeachers, String empIsHomeroomTeachers) {
        this.empTick = new CheckBox();
        Object id = empIDs;
        this.empID = new SimpleStringProperty((String) id);
        Object na = empNames;
        this.empName = new SimpleStringProperty((String) na);
        Object su = empSurnames;
        this.empSurname = new SimpleStringProperty((String) su);
        Object st = empStatuss;
        this.empStatus = new SimpleStringProperty((String) st);
        Object ist = empIsTeachers;
        this.empIsTeacher = new SimpleStringProperty((String) ist);
        Object ht = empIsHomeroomTeachers;
        this.empIsHomeroomTeacher = new SimpleStringProperty((String) ht);

    }

    public CheckBox getEmpTick() {
        return empTick;
    }

    public void setEmpTick(CheckBox empTick) {
        this.empTick = empTick;
    }

    public String getEmpID() {
        String s;
        s = this.empID.getValue();
        return s;
    }

    public StringProperty empIDProperty() {
        return this.empID;
    }

    public void setEmpID(String empID) {
        this.empID.set(empID);
    }

    public String getEmpName() {
        String s;
        s = this.empName.getValue();
        return s;
    }

    public StringProperty empNameProperty() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName.set(empName);
    }

    public String getEmpSurname() {
        String s;
        s = this.empSurname.getValue();
        return s;
    }

    public StringProperty empSurnameProperty() {
        return empSurname;
    }

    public void setEmpSurname(String empSurname) {
        this.empSurname.set(empSurname);
    }

    public String getEmpStatus() {
        String s;
        s = this.empStatus.getValue();
        System.out.println("now will return getEmpStatus wich it ="+s);
        return s;
    }

    public StringProperty empStatusProperty() {
        String string;
        Integer inti;
        inti = Integer.valueOf(this.empStatus.getValue());
        if (inti==1){
            string="работает";
        }
        else
        {
            string=" ";
        }
        Object obj;
        StringProperty stringProperty;
        obj = string;
        stringProperty = new SimpleStringProperty((String)obj);
        return stringProperty;
    }

    public void setEmpStatus(String empStatuss) {
        this.empStatus.set(empStatuss);
    }


    //-------------new ones:
    public String getEmpIsTeacher() {
        String s;
        s = this.empIsTeacher.getValue();
        System.out.println("now will return getEmpIsTeacher wich it ="+s);
        return s;
    }

    public StringProperty empIsTeacherProperty() {
        return empIsTeacher;
    }

    public void setEmpIsTeacher(String empIsTeacher) {
        this.empIsTeacher.set(empIsTeacher);
    }

    public String getEmpIsHomeroomTeacher() {
        return empIsHomeroomTeacher.get();
    }

    public StringProperty empIsHomeroomTeacherProperty() {
        return empIsHomeroomTeacher;
    }

    public void setEmpIsHomeroomTeacher(String empIsHomerromTeacher) {
        this.empIsHomeroomTeacher.set(empIsHomerromTeacher);
    }
}
