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

import java.net.URL;
import java.util.ResourceBundle;

import static Controllers.MainWindowController.modifyProductIndex;
import static Model.Inventory.getAllPartsList;

public class ModifyProductController implements Initializable {

    @FXML private TextField modifyProductId;
    @FXML private TextField modifyProductName;
    @FXML private TextField modifyProductInv;
    @FXML private TextField modifyProductPrice;
    @FXML private TextField modifyProductMax;
    @FXML private TextField modifyProductMin;

    //Parts table and search
    @FXML private TextField partToSearch;
    @FXML private TableView<Part> partsTableView;
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> partInvColumn;
    @FXML private TableColumn<Part, Double> partPriceColumn;


    //associated parts table
    @FXML private TableView<Part> associatedPartsTableView;
    @FXML private TableColumn<Part, Integer> associatedPartIdColumn;
    @FXML private TableColumn<Part, String> associatedPartNameColumn;
    @FXML private TableColumn<Part, Integer> associatedPartInvColumn;
    @FXML private TableColumn<Part, Double> associatedPartPriceColumn;


    //private int modifyProductIndex = MainWindowController.selectedIndex();

    int modifyProductIndex = MainWindowController.selectedIndex();

    private ObservableList<Part> associatedPartsList = FXCollections.observableArrayList();
    //private Product selectedProduct;
    private int modIndex = modifyProductIndex();
    private int productId;

    public void saveModifyProductButton(ActionEvent actionEvent) throws Exception {

        //String prId = modifyProductId.getText();
        String prName = modifyProductName.getText();
        int prInv = Integer.parseInt(modifyProductInv.getText());
        double prPrice = Double.parseDouble(modifyProductPrice.getText());
        int prMax = Integer.parseInt(modifyProductMax.getText());
        int prMin = Integer.parseInt(modifyProductMin.getText());

        Product modProduct = new Product();

        //modProduct.setProductId(Integer.parseInt(prId));
        modProduct.setProductId(productId);
        modProduct.setProductName(prName);
        modProduct.setProductStock(prInv);
        modProduct.setProductPrice(prPrice);
        modProduct.setProductMax(prMax);
        modProduct.setProductMin(prMin);

        modProduct.setAssociatedParts(associatedPartsList);
        Inventory.updateProduct(modIndex, modProduct);



        Parent cancelModifyProductParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene cancelModifyProductScene = new Scene(cancelModifyProductParent);

        Stage cancelModifyProductWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        cancelModifyProductWindow.setScene(cancelModifyProductScene);
        cancelModifyProductWindow.show();

    }

    public void cancelModifyProductButton(ActionEvent actionEvent) throws Exception{

        Parent cancelModifyProductParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene cancelModifyProductScene = new Scene(cancelModifyProductParent);

        Stage cancelModifyProductWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        cancelModifyProductWindow.setScene(cancelModifyProductScene);
        cancelModifyProductWindow.show();

    }

    public void deleteModifyProductButton(ActionEvent actionEvent) {

        ObservableList<Part> selectedParts, allParts;
        allParts = partsTableView.getItems();

        selectedParts = partsTableView.getSelectionModel().getSelectedItems();

        for (Part part: selectedParts) {
            allParts.remove(part);
        }

    }

    public void addModifyProductButton(ActionEvent actionEvent) {

        Part selectedPart = partsTableView.getSelectionModel().getSelectedItem();
        associatedPartsList.add(selectedPart);
        populateAssociatedPartsTableView();

    }

    public void searchProductButton(ActionEvent actionEvent) {

        String search = partToSearch.getText();

        ObservableList foundProducts = Inventory.searchPart(search);
        if (foundProducts.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.setTitle("No match found");
            alert.setHeaderText("No part found matching " + search);
            alert.showAndWait();
        } else {
            partsTableView.setItems(foundProducts);
        }

    }

    @Override
    public void initialize (URL url, ResourceBundle rb) {

        //get product index
        Product product = Inventory.getAllProductsList().get(modIndex);

        //get ID don't think it's needed
        productId = Inventory.getAllProductsList().get(modIndex).getProductId();

        associatedPartsList = product.getAllAssociatedParts();

        //set up parts list table on Add product window load
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partInvColumn.setCellValueFactory(new PropertyValueFactory<>("partInv"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));

        partsTableView.setItems(Inventory.getAllPartsList());

        associatedPartIdColumn.setCellValueFactory(new PropertyValueFactory<>("partId"));
        associatedPartNameColumn.setCellValueFactory(new PropertyValueFactory<>("PartName"));
        associatedPartInvColumn.setCellValueFactory(new PropertyValueFactory<>("PartInv"));
        associatedPartPriceColumn.setCellValueFactory(new PropertyValueFactory<>("PartPrice"));

        populatePartsTableView();
        populateAssociatedPartsTableView();


        //associatedPartIdColumn.setCellValueFactory(modifyProduct.getPar);
        //associatedPartsTableView.setItems(Product.associatedParts);

        //associatedPartsTableView.setItems(associatedPartsList);
        //associatedPartsTableView.refresh();


    }

    public void addProductParts (Product product) {

        modifyProductId.setText(String.valueOf(product.getProductId()));
        modifyProductName.setText(product.getProductName());
        modifyProductInv.setText(String.valueOf(product.getProductStock()));
        modifyProductPrice.setText(String.valueOf(product.getProductPrice()));
        modifyProductMax.setText(String.valueOf(product.getProductMax()));
        modifyProductMin.setText(String.valueOf(product.getProductMin()));

        //Product modifyProduct = Inventory.getAllProductsList().get(modifyProductIndex);
        //selectedProduct  = product;
        //associatedPartsList = product.getAllAssociatedParts();


    }

    public void populatePartsTableView() {
        partsTableView.setItems(getAllPartsList());
    }

    public void populateAssociatedPartsTableView() {
        associatedPartsTableView.setItems(associatedPartsList);
    }
}