package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModifyPartController {

    public void saveModifyPart(ActionEvent actionEvent) {
    }

    public void cancelModifyPart(ActionEvent actionEvent) throws Exception{

        Parent cancelModifyParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene cancelModifyScene = new Scene(cancelModifyParent);

        Stage cancelModifyWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        cancelModifyWindow.setScene(cancelModifyScene);
        cancelModifyWindow.show();

    }

}
