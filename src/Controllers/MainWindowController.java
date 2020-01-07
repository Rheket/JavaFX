package Controllers;

import Model.Inventory;
import Model.Part;
import Model.Product;
import Model.InHouse;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML public TextField partToSearch;
    @FXML public TextField productToSearch;

    //Sets up the parts table view
    @FXML private TableView<Part> partsTableView;
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> partInvColumn;
    @FXML private TableColumn<Part, Double> partPriceColumn;

    //Sets up the products table view
    @FXML private TableView<Product> productTableView;
    @FXML private TableColumn<Product, Integer> productIdColumn;
    @FXML private TableColumn<Product, String> productNameColumn;
    @FXML private TableColumn<Product, Integer> productInvColumn;
    @FXML private TableColumn<Product, Double> productPriceColumn;

    //Part to modify
    private static Part partModify;
    private static int partIndex;
    //Product to modify
    private static Product productModify;
    private static int productIndex;

    public void updatePartsTable() {

        partsTableView.setItems(Inventory.getAllPartsList());

    }

    public static int selectedIndex() {

        return partIndex;
    }

    public void addParts(ActionEvent actionEvent) throws Exception{

        Parent addPartsParent = FXMLLoader.load(getClass().getResource("/GUI/AddPart.fxml"));
        Scene addPartsScene = new Scene(addPartsParent);

        Stage addPartsWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        addPartsWindow.setScene(addPartsScene);
        addPartsWindow.show();

    }

    public void modifyParts(ActionEvent actionEvent) throws Exception{

        //select part and get Index of selected part
        partModify = partsTableView.getSelectionModel().getSelectedItem();
        partIndex = Inventory.getAllPartsList().indexOf(partModify);

        //change scenes to Modify Part screen
        Parent modifyPartsParent = FXMLLoader.load(getClass().getResource("/GUI/ModifyPart.fxml"));
        Scene modifyPartsScene = new Scene(modifyPartsParent);

        Stage modifyPartsWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        modifyPartsWindow.setScene(modifyPartsScene);
        modifyPartsWindow.show();

    }

    public void addProducts(ActionEvent actionEvent) throws Exception{

        Parent addProductsParent = FXMLLoader.load(getClass().getResource("/GUI/AddProduct.fxml"));
        Scene addProductsScene = new Scene(addProductsParent);

        Stage addProductsWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        addProductsWindow.setScene(addProductsScene);
        addProductsWindow.show();

    }

    public void modifyProducts(ActionEvent actionEvent) throws Exception{

        //select product and get Index of selected part
        productModify = productTableView.getSelectionModel().getSelectedItem();
        productIndex = Inventory.getAllProductsList().indexOf(productModify);

        //change scenes to Modify Products screen.

        Parent modifyProductsParent = FXMLLoader.load(getClass().getResource("/GUI/ModifyProduct.fxml"));
        Scene modifyProductsScene = new Scene(modifyProductsParent);

        Stage modifyProductsWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        modifyProductsWindow.setScene(modifyProductsScene);
        modifyProductsWindow.show();

    }

    public void deleteParts() {

        ObservableList<Part> selectedParts, allParts;
        allParts = partsTableView.getItems();

        selectedParts = partsTableView.getSelectionModel().getSelectedItems();

        for (Part part: selectedParts) {
            allParts.remove(part);
        }

    }

    @FXML
    public void handleSearchParts() {

        String search = partToSearch.getText();

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

    public void searchProducts(ActionEvent actionEvent) {

        String search = productToSearch.getText();

    }

    public void deleteProducts(ActionEvent actionEvent) {

        ObservableList<Product> selectedProducts, allProducts;
        allProducts = productTableView.getItems();

        selectedProducts = productTableView.getSelectionModel().getSelectedItems();

        for (Product product: selectedProducts) {
            allProducts.remove(product);
        }

    }

    public void exitMainScreen() {
        System.exit(0);
    }

    @Override
    public void initialize (URL url, ResourceBundle rb) {

        //initialize parts
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partInvColumn.setCellValueFactory(new PropertyValueFactory<>("partInv"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));

        partsTableView.setItems(Inventory.partInventory);

        //Inventory.addPart(new InHouse(Inventory.getPartId(), "Handle Bars", 50, 49.99, 50, 1, 1));
        //Inventory.addPart(new InHouse(Inventory.getPartId(), "Wheels", 100, 24.99, 100, 1, 2));

        //initialize products
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productInvColumn.setCellValueFactory(new PropertyValueFactory<>("productInv"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

        productTableView.setItems(Inventory.productInventory);

    }



}
