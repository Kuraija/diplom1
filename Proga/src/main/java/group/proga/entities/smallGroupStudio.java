package group.proga.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

// group stuio part to show in Employees details list
public class smallGroupStudio {

    public CheckBox gStudioTick;
    public StringProperty gStudioID;
    public StringProperty gStudioName;
    public TextField gStudioPayment;
    public StringProperty whoWhatId;

    public smallGroupStudio(String gStudioIDs,
                            String gStudioNames) {
        this.gStudioTick = new CheckBox();
        Object obj = gStudioIDs;
        this.gStudioID = new SimpleStringProperty((String)obj);
        obj = gStudioNames;
        this.gStudioName = new SimpleStringProperty((String)obj);
        this.gStudioPayment =null;
        this.whoWhatId =null;
    }

    public smallGroupStudio(String gStudioIDs,
                        String gStudioNames,
                        String gStudioPayments,
                            String whoWhatIds) {
        this.gStudioTick = new CheckBox();
        Object obj = gStudioIDs;
        this.gStudioID = new SimpleStringProperty((String)obj);
        obj = gStudioNames;
        this.gStudioName = new SimpleStringProperty((String)obj);
        this.gStudioPayment = new TextField(gStudioPayments);
        obj = whoWhatIds;
        this.whoWhatId = new SimpleStringProperty((String)obj);
    }

    public CheckBox getGStudioTick() {
        return gStudioTick;
    }

    public void setGStudioTick(CheckBox tick) {
        this.gStudioTick = tick;
    }

    public void setGStudioTickValue(Boolean selected) {
        this.gStudioTick.setSelected(selected);
    }

    public Boolean getGStudioTickValue() {
        return this.gStudioTick.isSelected();
    }

   public String getGStudioID() {
        return gStudioID.get();
    }

    public StringProperty gStudioIDProperty() {
        return gStudioID;
    }

    public void setGStudioID(String id) {
        this.gStudioID.set(id);
    }

    public String getGStudioName() {
        return gStudioName.get();
    }

    public StringProperty gStudioNameProperty() {
        return gStudioName;
    }

    public void setGStudioName(String name) {
        this.gStudioName.set(name);
    }

    public TextField getGStudioPayment() {
        return gStudioPayment;
    }

    public String getGStudioPaymentValue() {
        return gStudioPayment.getText();
    }

    public void setGStudioPayment(TextField pay) {
        this.gStudioPayment = pay;
    }


    public void setWhoWhatId(String wwi) {
        this.whoWhatId.set(wwi);
    }
    public String getWhoWhatId() {
        return whoWhatId.get();
    }

}
