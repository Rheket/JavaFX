package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModifyProductController {

    public void saveModifyProductButton(ActionEvent actionEvent) {
    }

    public void cancelModifyProductButton(ActionEvent actionEvent) throws Exception{

        Parent cancelModifyProductParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene cancelModifyProductScene = new Scene(cancelModifyProductParent);

        Stage cancelModifyProductWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        cancelModifyProductWindow.setScene(cancelModifyProductScene);
        cancelModifyProductWindow.show();

    }

    public void deleteModifyProductButton(ActionEvent actionEvent) {
    }

    public void addModifyProductButton(ActionEvent actionEvent) {
    }

    public void searchProductButton(ActionEvent actionEvent) {
    }

}
