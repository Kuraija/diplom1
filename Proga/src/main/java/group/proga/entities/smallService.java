package group.proga.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class smallService {

    public CheckBox serviceTick;
    public StringProperty serviceID;
    public StringProperty serviceName;
    public TextField servicePayment;
    public StringProperty whoWhatId;

    public smallService(String serviceIDs,
                        String serviceNames) {
        this.serviceTick = new CheckBox();
        Object obj = serviceIDs;
        this.serviceID = new SimpleStringProperty((String)obj);
        obj = serviceNames;
        this.serviceName = new SimpleStringProperty((String)obj);
        this.servicePayment = null;
        this.whoWhatId = null;
    }

    public smallService(String serviceIDs,
                             String serviceNames,
                             String servicePayments,
                        String whoWhatIds) {
        this.serviceTick = new CheckBox();
        Object obj = serviceIDs;
        this.serviceID = new SimpleStringProperty((String)obj);
        obj = serviceNames;
        this.serviceName = new SimpleStringProperty((String)obj);
        this.servicePayment = new TextField(servicePayments);
        obj = whoWhatIds;
        this.whoWhatId = new SimpleStringProperty((String)obj);
    }

    public CheckBox getServiceTick() {
        return serviceTick;
    }

    public void setServiceTick(CheckBox tick) {
        this.serviceTick = tick;
    }

    public void setServiceTickValue(Boolean selected) {
        this.serviceTick.setSelected(selected);
    }

    public Boolean getServiceTickValue() {
        return this.serviceTick.isSelected();
    }

    public String getServiceID() {
        return serviceID.get();
    }

    public StringProperty serviceIDProperty() {
        return serviceID;
    }

    public void setServiceID(String id) {
        this.serviceID.set(id);
    }

    public String getServiceName() {
        return serviceName.get();
    }

    public StringProperty serviceNameProperty() {
        return serviceName;
    }

    public void setServiceName(String name) {
        this.serviceName.set(name);
    }

    public TextField getServicePayment() {
        return servicePayment;
    }

    public void setServicePayment(TextField pay) {
        this.servicePayment = pay;
    }

    public String getServicePaymentValue() {
        return servicePayment.getText();
    }

    public void setWhoWhatId(String wwi) {
        this.whoWhatId.set(wwi);
    }
    public String getWhoWhatId() {
        return whoWhatId.get();
    }
}
