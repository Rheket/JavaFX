package Controllers;

import Module.Part;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class AddPartController implements Initializable {

    @FXML private TextField idTextField;
    @FXML private TextField nameTextField;
    @FXML private TextField invTextField;
    @FXML private TextField priceCostTextField;
    @FXML private TextField maxTextField;
    @FXML private TextField minTextField;
    @FXML private TextField machineIdTextField;
    @FXML private TextField companyNameTextField;

    @FXML private Label machineIdLabel;
    @FXML private RadioButton inHouseRadioButton;
    @FXML private RadioButton outsourcedRadioButton;

    private ToggleGroup outsourcedToggleGroup;
    private boolean toggleInHouse;

    //set up table
    @FXML private TableView<Part> tableView;
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> partInvColumn;
    @FXML private TableColumn<Part, Integer> partPriceColumn;


    public void cancelAddPart(ActionEvent actionEvent) throws Exception{

        Parent cancelAddParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene cancelAddScene = new Scene(cancelAddParent);

        Stage cancelAddWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        cancelAddWindow.setScene(cancelAddScene);
        cancelAddWindow.show();

    }

    public void saveAddPart(ActionEvent actionEvent) {

        //Columns in Table
        partIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("Part ID"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("Part Name"));
        partInvColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("Part Inventory Level"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("Part Price/Cost per Unit"));

        //Add data for testing
        tableView.setItems(getParts());

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

    /*
     * return observable list of parts
     */
    public ObservableList<Part> getParts() {

        ObservableList<Part> part = FXCollections.observableArrayList();
        //part.add(new Part(10,"Socks",15,5, 1, 100, "1"));

        return part;

    }


}
