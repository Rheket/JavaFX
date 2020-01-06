package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    public void saveProductButton(ActionEvent actionEvent) {
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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
