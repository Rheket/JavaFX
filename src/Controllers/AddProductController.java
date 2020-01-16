package Controllers;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    @FXML private TextField productId;
    @FXML private TextField productName;
    @FXML private TextField productInv;
    @FXML private TextField productPrice;
    @FXML private TextField productMax;
    @FXML private TextField productMin;
    @FXML private TextField addProductSearchBox;
    //@FXML private TextField productMachOrCompID;

    // parts table view
    @FXML private TableView<Part> partsTableView;
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> partInvColumn;
    @FXML private TableColumn<Part, Double> partPriceColumn;

    // associated parts table view
    @FXML private TableView<Part> associatedPartsTableView;
    @FXML private TableColumn<Part, Integer> associatedPartIdColumn;
    @FXML private TableColumn<Part, String> associatedPartNameColumn;
    @FXML private TableColumn<Part, Integer> associatedPartInvColumn;
    @FXML private TableColumn<Part, Double> associatedPartPriceColumn;

    private ObservableList<Part> productPartsList = FXCollections.observableArrayList();

    public void saveProductButton(ActionEvent actionEvent) throws IOException {

        Product prod = new Product();

        //int pId = Integer.parseInt(this.productId.getText());
        String pName = this.productName.getText();
        int pInv = Integer.parseInt(this.productInv.getText());
        double pPrice = Double.parseDouble(this.productPrice.getText());
        int pMax = Integer.parseInt(this.productMax.getText());
        int pMin = Integer.parseInt(this.productMin.getText());

        //prod.setProductId(pId);
        prod.setProductName(pName);
        prod.setProductStock(pInv);
        prod.setProductPrice(pPrice);
        prod.setProductMax(pMax);
        prod.setProductMin(pMin);
        prod.setAssociatedParts(productPartsList);

        //Product.setAssociatedParts(associatedParts);

        if (this.productId.getText().length() == 0) {
            prod.setProductId(Inventory.getProductId());
            Inventory.addProduct(prod);
        } else {
            prod.setProductId(Integer.parseInt(this.productId.getText()));
            Inventory.updateProduct(MainWindowController.selectedIndex(), prod);
        }

        Parent saveProductParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene saveProductScene = new Scene(saveProductParent);

        Stage saveProductWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        saveProductWindow.setScene(saveProductScene);
        saveProductWindow.show();

    }

    public void cancelAddProductButton(ActionEvent actionEvent) throws Exception{

        Parent cancelAddProductParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene cancelAddProductScene = new Scene(cancelAddProductParent);

        Stage cancelAddProductWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        cancelAddProductWindow.setScene(cancelAddProductScene);
        cancelAddProductWindow.show();

    }

    public void deleteProductButton(ActionEvent actionEvent) {

        Part selectedPart = associatedPartsTableView.getSelectionModel().getSelectedItem();

        if(selectedPart != null) {
            productPartsList.remove(selectedPart);
            associatedPartsTableView.setItems(productPartsList);
        }

    }

    public void addProductButton(ActionEvent actionEvent) {

        Part selectedPart = partsTableView.getSelectionModel().getSelectedItem();

        if (selectedPart != null) {
            productPartsList.add(selectedPart);
            associatedPartsTableView.setItems(productPartsList);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("Select a Part");
            alert.setHeaderText("Product must have at least 1 part associated");
        }

    }

    public void searchPartToAdd() {

        String search = addProductSearchBox.getText();

        ObservableList foundParts = Inventory.searchPart(search);
        if (foundParts.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No match found");
            alert.setHeaderText("No part found matching " + search);
            alert.showAndWait();
        } else {
            partsTableView.setItems(foundParts);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //set up parts list table on Add product window load
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partInvColumn.setCellValueFactory(new PropertyValueFactory<>("partInv"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));

        partsTableView.setItems(Inventory.getAllPartsList());

        //set up associated parts table
        associatedPartIdColumn.setCellValueFactory(new PropertyValueFactory<>("partId"));
        associatedPartNameColumn.setCellValueFactory(new PropertyValueFactory<>("PartName"));
        associatedPartInvColumn.setCellValueFactory(new PropertyValueFactory<>("PartInv"));
        associatedPartPriceColumn.setCellValueFactory(new PropertyValueFactory<>("PartPrice"));

        // CHANGED THIS, this loads the associated parts table.
        //associatedPartsTableView.setItems(Product.associatedParts);

        partsTableView.setItems(Inventory.getAllPartsList());

        //associatedPartsTableView.setItems(associatedParts);
        associatedPartsTableView.refresh();

    }


}