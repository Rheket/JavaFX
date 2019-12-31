package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {

    @FXML private Label machineIdLabel;
    @FXML private RadioButton inHouseRadioButton;
    @FXML private RadioButton outsourcedRadioButton;
    @FXML private ToggleGroup outsourcedToggleGroup;

    public void cancelModifyPart(ActionEvent actionEvent) throws Exception{

        Parent cancelModifyParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene cancelModifyScene = new Scene(cancelModifyParent);

        Stage cancelModifyWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        cancelModifyWindow.setScene(cancelModifyScene);
        cancelModifyWindow.show();

    }

    public void saveModifyPart(ActionEvent actionEvent) {
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


    }

}