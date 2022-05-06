package group.proga.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

public class GradeClass {
    public CheckBox classTick;
    public StringProperty classID;
    public StringProperty className;
    public StringProperty emplID;

    public GradeClass(String classIDs, String classNames, String EmplIDs) {
        this.classTick = new CheckBox();
        Object id = classIDs;
        this.classID = new SimpleStringProperty((String) id);
        Object cn = classNames;
        this.className= new SimpleStringProperty((String) cn);
        Object ei = EmplIDs;
        this.emplID = new SimpleStringProperty((String) ei);
    }

    public CheckBox getClassTick() {
        return classTick;
    }

    public void setClassTick(CheckBox classTick) {
        this.classTick = classTick;
    }

    public void setClassTickValue(Boolean selected) {
        this.classTick.setSelected(selected);
    }

    public Boolean getClassTickValue() {
        return this.classTick.isSelected();
    }

    public String getClassID() {
        return classID.get();
    }

    public StringProperty classIDProperty() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID.set(classID);
    }

    public String getClassName() {
        return className.get();
    }

    public StringProperty classNameProperty() {
        return className;
    }

    public void setClassName(String className) {
        this.className.set(className);
    }

    public String getEmplID() {
        return emplID.get();
    }

    public StringProperty emplIDProperty() {
        return emplID;
    }

    public void setEmplID(String emplID) {
        this.emplID.set(emplID);
    }

}
