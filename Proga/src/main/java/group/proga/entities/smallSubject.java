package group.proga.entities;
// subject part to show in Employees details list
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class smallSubject {

    public CheckBox subjTick;
    public StringProperty subjID;
    public StringProperty subjName;
    public TextField subjPayment;
    public StringProperty whoWhatId;

    public smallSubject(String subjIDs,
                        String subjNames) {
        this.subjTick = new CheckBox();
        Object obj = subjIDs;
        this.subjID = new SimpleStringProperty((String)obj);
        obj = subjNames;
        this.subjName = new SimpleStringProperty((String)obj);
        this.subjPayment = null;
        this.whoWhatId = null;
    }

    public smallSubject(String subjIDs,
                        String subjNames,
                        String subjPayments,
                        String whoWhatIds) {
        this.subjTick = new CheckBox();
        Object obj = subjIDs;
        this.subjID = new SimpleStringProperty((String)obj);
        obj = subjNames;
        this.subjName = new SimpleStringProperty((String)obj);
        //obj = subjPayments;
        //this.subjPayment = new SimpleStringProperty((String)obj);
        this.subjPayment = new TextField(subjPayments);
        obj = whoWhatIds;
        this.whoWhatId = new SimpleStringProperty((String)obj);
    }

    public CheckBox getSubjTick() {
        return subjTick;
    }

    public void setSubjTick(CheckBox subjTick) {
        this.subjTick = subjTick;
    }

    public void setSubjTickValue(Boolean selected) {
        this.subjTick.setSelected(selected);
    }
    public Boolean getSubjTickValue() {
        return this.subjTick.isSelected();
    }

    public String getSubjID() {
        return subjID.get();
    }

    public StringProperty subjIDProperty() {
        return subjID;
    }

    public void setSubjID(String subjID) {
        this.subjID.set(subjID);
    }

    public String getSubjName() {
        return subjName.get();
    }

    public StringProperty subjNameProperty() {
        return subjName;
    }

    public void setSubjName(String subjName) {
        this.subjName.set(subjName);
    }

    public TextField getSubjPayment() {
        return subjPayment;
    }

    public String getSubjPaymentValue() {
        return subjPayment.getText();
    }

//    public StringProperty subjPaymentProperty() {
//        Object obj;
//        obj = subjPayment.getText();
//        return new SimpleStringProperty((String)obj);
//    }
    //idk about this one

    public void setSubjPayment(TextField subjPayment) {
        this.subjPayment = subjPayment;
    }

    public void setWhoWhatId(String wwi) {
        this.whoWhatId.set(wwi);
    }
    public String getWhoWhatId() {
        return whoWhatId.get();
    }

}
