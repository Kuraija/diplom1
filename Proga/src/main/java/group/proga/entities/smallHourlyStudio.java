package group.proga.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class smallHourlyStudio {
    public CheckBox hStudioTick;
    public StringProperty hStudioID;
    public StringProperty hStudioName;
    public TextField hStudioPayment;
    public StringProperty whoWhatId;

    public smallHourlyStudio(String hStudioIDs,
                             String hStudioNames) {
        this.hStudioTick = new CheckBox();
        Object obj = hStudioIDs;
        this.hStudioID = new SimpleStringProperty((String)obj);
        obj = hStudioNames;
        this.hStudioName = new SimpleStringProperty((String)obj);
        this.hStudioPayment = null;
        this.whoWhatId = null;
    }

    public smallHourlyStudio(String hStudioIDs,
                            String hStudioNames,
                            String hStudioPayments,
                             String whoWhatIds) {
        this.hStudioTick = new CheckBox();
        Object obj = hStudioIDs;
        this.hStudioID = new SimpleStringProperty((String)obj);
        obj = hStudioNames;
        this.hStudioName = new SimpleStringProperty((String)obj);
        this.hStudioPayment = new TextField(hStudioPayments);
        obj = whoWhatIds;
        this.whoWhatId = new SimpleStringProperty((String)obj);
    }

    public CheckBox getHStudioTick() {
        return hStudioTick;
    }

    public void setHStudioTick(CheckBox tick) {
        this.hStudioTick = tick;
    }

    public Boolean getHStudioTickValue() {
        return this.hStudioTick.isSelected();
    }

    public void setHStudioTickValue(Boolean selected) {
        this.hStudioTick.setSelected(selected);
    }


    public String getHStudioID() {
        return hStudioID.get();
    }

    public StringProperty hStudioIDProperty() {
        return hStudioID;
    }

    public void setHStudioID(String id) {
        this.hStudioID.set(id);
    }

    public String getHStudioName() {
        return hStudioName.get();
    }

    public StringProperty hStudioNameProperty() {
        return hStudioName;
    }

    public void setHStudioName(String name) {
        this.hStudioName.set(name);
    }

    public TextField getHStudioPayment() {
        return hStudioPayment;
    }

    public String getHStudioPaymentValue() {
        return hStudioPayment.getText();
    }

    public void setHStudioPayment(TextField pay) {
        this.hStudioPayment = pay;
    }


    public void setWhoWhatId(String wwi) {
        this.whoWhatId.set(wwi);
    }
    public String getWhoWhatId() {
        return whoWhatId.get();
    }
}
