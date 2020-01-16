package Controllers;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddPartController implements Initializable {

    @FXML private Label machineIdLabel;
    @FXML private RadioButton inHouseRadioButton;
    @FXML private RadioButton outsourcedRadioButton;

    private ToggleGroup outsourcedToggleGroup;

    //gather input
    @FXML private TextField partId;
    @FXML private TextField partName;
    @FXML private TextField partInv;
    @FXML private TextField partPrice;
    @FXML private TextField partMax;
    @FXML private TextField partMin;
    @FXML private TextField partMachOrCompID;


    public void cancelAddPart(ActionEvent actionEvent) throws Exception{

        Parent cancelAddParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene cancelAddScene = new Scene(cancelAddParent);

        Stage cancelAddWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        cancelAddWindow.setScene(cancelAddScene);
        cancelAddWindow.show();

    }

    public void saveAddPart(ActionEvent actionEvent) throws IOException {

        if (this.outsourcedToggleGroup.getSelectedToggle().equals(this.inHouseRadioButton)) {

            InHouse p = new InHouse();

            //p.setPartId(Integer.parseInt(partId.getText()));
            p.setPartName(this.partName.getText());
            p.setPartInv(Integer.parseInt(this.partInv.getText()));
            p.setPartPrice(Double.parseDouble(this.partPrice.getText()));
            p.setPartMax(Integer.parseInt(this.partMax.getText()));
            p.setPartMin(Integer.parseInt(this.partMin.getText()));
            p.setMachineId(Integer.parseInt(this.partMachOrCompID.getText()));

            if (this.partId.getText().length() == 0) {
                p.setPartId(Inventory.getPartId());
                Inventory.addPart(p);
            } else {
                p.setPartId(Integer.parseInt(this.partId.getText()));
                Inventory.updatePart(MainWindowController.selectedIndex(), p);
            }



        } else {
            Outsourced o = new Outsourced();

            //o.setPartId(Integer.parseInt(partId.getText()));
            o.setPartName(this.partName.getText());
            o.setPartInv(Integer.parseInt(this.partInv.getText()));
            o.setPartPrice(Double.parseDouble(this.partPrice.getText()));
            o.setPartMax(Integer.parseInt(this.partMax.getText()));
            o.setPartMin(Integer.parseInt(this.partMin.getText()));
            o.setCompanyName(this.partMachOrCompID.getText());

            if (this.partId.getText().length() == 0) {
                o.setPartId(Inventory.getPartId());
                Inventory.addPart(o);
            } else {
                o.setPartId(Integer.parseInt(this.partId.getText()));
                Inventory.updatePart(MainWindowController.selectedIndex(), o);
            }

        }

        //getInput.add(new Part(pId, pName, pPrice, pInv, pMax, pMin, pMC));

        //
        // MainWindowController.partsTableView.setItems(getInput);

        Parent addPartParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene addPartScene = new Scene(addPartParent);

        Stage addPartWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        addPartWindow.setScene(addPartScene);
        addPartWindow.show();

    }

    /*
     * Updates machine ID label
     */
    public void radioButtonChanged() {

        if
        (this.outsourcedToggleGroup.getSelectedToggle().equals(inHouseRadioButton))
            machineIdLabel.setText("Machine ID");


        if
        (this.outsourcedToggleGroup.getSelectedToggle().equals(outsourcedRadioButton))
            machineIdLabel.setText("Company Name");

    }




    @Override
    public void initialize (URL url, ResourceBundle rb) {

        machineIdLabel.setText("Machine ID");
        inHouseRadioButton.setSelected(true);
        outsourcedToggleGroup = new ToggleGroup();
        this.inHouseRadioButton.setToggleGroup(outsourcedToggleGroup);
        this.outsourcedRadioButton.setToggleGroup(outsourcedToggleGroup);


    }



}