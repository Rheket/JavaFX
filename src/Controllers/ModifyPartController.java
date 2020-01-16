package Controllers;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
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

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {

    @FXML private Label machineIdLabel;
    @FXML private RadioButton inHouseRadioButton;
    @FXML private RadioButton outsourcedRadioButton;
    @FXML private ToggleGroup outsourcedToggleGroup;

    //modify data
    @FXML private TextField modifyPartId;
    @FXML private TextField modifyPartName;
    @FXML private TextField modifyPartInv;
    @FXML private TextField modifyPartPrice;
    @FXML private TextField modifyPartMax;
    @FXML private TextField modifyPartMin;
    @FXML private TextField modifyPartMachOrCompID;

    int mIndex = MainWindowController.selectedIndex();

    public void cancelModifyPart(ActionEvent actionEvent) throws Exception{

        Parent cancelModifyParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene cancelModifyScene = new Scene(cancelModifyParent);

        Stage cancelModifyWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        cancelModifyWindow.setScene(cancelModifyScene);
        cancelModifyWindow.show();

    }

    public void saveModifyPart(ActionEvent actionEvent) throws Exception{

        String pId = modifyPartId.getText();
        String pName = modifyPartName.getText();
        String pInv = modifyPartInv.getText();
        String pPrice = modifyPartPrice.getText();
        String pMax = modifyPartMax.getText();
        String pMin = modifyPartMin.getText();
        String pMachOrCompID = modifyPartMachOrCompID.getText();

        if (this.outsourcedToggleGroup.getSelectedToggle().equals(this.inHouseRadioButton)) {

            InHouse iPart = new InHouse();

            iPart.setPartId(Integer.parseInt(pId));
            iPart.setPartName(pName);
            iPart.setPartInv(Integer.parseInt(pInv));
            iPart.setPartPrice(Double.parseDouble(pPrice));
            iPart.setPartMax((Integer.parseInt(pMax)));
            iPart.setPartMin(Integer.parseInt(pMin));
            iPart.setMachineId(Integer.parseInt(pMachOrCompID));

            Inventory.updatePart(mIndex, iPart);

        } else {

            Outsourced oPart = new Outsourced();

            oPart.setPartId(Integer.parseInt(pId));
            oPart.setPartName(pName);
            oPart.setPartInv(Integer.parseInt(pInv));
            oPart.setPartPrice(Double.parseDouble(pPrice));
            oPart.setPartMax((Integer.parseInt(pMax)));
            oPart.setPartMin(Integer.parseInt(pMin));
            oPart.setCompanyName(pMachOrCompID);

            Inventory.updatePart(mIndex, oPart);

        }

        Parent saveModifyParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene saveModifyScene = new Scene(saveModifyParent);

        Stage saveModifyWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        saveModifyWindow.setScene(saveModifyScene);
        saveModifyWindow.show();

    }

    /*
     * Updates machine ID label
     */
    public void radioButtonChanged() {

        if (this.outsourcedToggleGroup.getSelectedToggle().equals(inHouseRadioButton))
            machineIdLabel.setText("Machine ID");

        if (this.outsourcedToggleGroup.getSelectedToggle().equals(outsourcedRadioButton))
            machineIdLabel.setText("Company Name");

    }

    @Override
    public void initialize (URL url, ResourceBundle rb) {


        machineIdLabel.setText("Machine ID");

        outsourcedToggleGroup = new ToggleGroup();

        this.inHouseRadioButton.setToggleGroup(outsourcedToggleGroup);
        this.outsourcedRadioButton.setToggleGroup(outsourcedToggleGroup);

        inHouseRadioButton.setSelected(true);
    }

    public void initData (Part part) {

        modifyPartId.setText(String.valueOf(part.getPartId()));
        modifyPartName.setText(part.getPartName());
        modifyPartInv.setText(String.valueOf(part.getPartInv()));
        modifyPartPrice.setText(String.valueOf(part.getPartPrice()));
        modifyPartMax.setText(String.valueOf(part.getPartMax()));
        modifyPartMin.setText(String.valueOf(part.getPartMin()));


        if(part instanceof InHouse) {

            inHouseRadioButton.setSelected(true);
            modifyPartMachOrCompID.setText(String.valueOf(InHouse.getMachineId()));

        } else {

            outsourcedRadioButton.setSelected(true);
            modifyPartMachOrCompID.setText(String.valueOf(Outsourced.getCompanyName()));

        }
    }

}