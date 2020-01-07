package Controllers;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.beans.Observable;
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
    //@FXML private TextField productMachOrCompID;

    // parts table view
    @FXML private TableView<Part> partsTableView;
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> partInvColumn;
    @FXML private TableColumn<Part, Double> partPriceColumn;

    // associated parts table view
    @FXML private TableView<Part> associatedParts;
    @FXML private TableColumn<Part, Integer> associatedPartIdColumn;
    @FXML private TableColumn<Part, String> associatedPartNameColumn;
    @FXML private TableColumn<Part, Integer> associatedPartInvColumn;
    @FXML private TableColumn<Part, Double> associatedPartPriceColumn;

    public void saveProductButton(ActionEvent actionEvent) throws IOException {

        Product prod = new Product();

        prod.setProductId(Integer.parseInt(productId.getText()));
        prod.setProductName(this.productName.getText());
        prod.setProductStock(Integer.parseInt(this.productInv.getText()));
        prod.setProductPrice(Double.parseDouble(this.productPrice.getText()));
        prod.setProductMax(Integer.parseInt(this.productMax.getText()));
        prod.setProductMin(Integer.parseInt(this.productMin.getText()));

        prod.setAssociatedParts(Product.associatedParts);

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
    }

    public void addProductButton(ActionEvent actionEvent) {

        Part selectedPart = partsTableView.getSelectionModel().getSelectedItem();

        if (selectedPart != null) {
            Product.associatedParts.add(selectedPart);
            addAssociatedPart();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("Select a Part");
            alert.setHeaderText("Product must have at least 1 part associated");
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
        associatedPartIdColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("associatedPartId"));
        associatedPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("associatedPartName"));
        associatedPartInvColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("associatedPartInv"));
        associatedPartPriceColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("associatedPartPrice"));
        associatedParts.setItems(Product.getAllAssociatedParts());

        addAssociatedPart();



    }

    private void addAssociatedPart() {
        associatedParts.setItems(Product.associatedParts);
    }

}
