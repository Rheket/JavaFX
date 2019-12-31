package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowController {
    public Button addPartsButton;
    public Button deletePartsButton;
    public Button modifyPartsButton;
    public Button searchPartsButton;
    public Button searchProductsButton;
    public Button addProductsButton;
    public Button modifyProductsButton;
    public Button deleteProductsButton;

    public void addParts(ActionEvent actionEvent) throws Exception{

        Parent addPartsParent = FXMLLoader.load(getClass().getResource("/GUI/AddPart.fxml"));
        Scene addPartsScene = new Scene(addPartsParent);

        Stage addPartsWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        addPartsWindow.setScene(addPartsScene);
        addPartsWindow.show();

    }

    public void modifyParts(ActionEvent actionEvent) throws Exception{

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

        Parent modifyProductsParent = FXMLLoader.load(getClass().getResource("/GUI/ModifyProduct.fxml"));
        Scene modifyProductsScene = new Scene(modifyProductsParent);

        Stage modifyProductsWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        modifyProductsWindow.setScene(modifyProductsScene);
        modifyProductsWindow.show();

    }

    public void deleteParts(ActionEvent actionEvent) {


    }

    public void searchParts(ActionEvent actionEvent) {
    }

    public void searchProducts(ActionEvent actionEvent) {
    }

    public void deleteProducts(ActionEvent actionEvent) {
    }

    public void exitMainScreen(ActionEvent actionEvent) {
        System.exit(0);
    }
}
