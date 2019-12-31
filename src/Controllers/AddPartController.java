package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AddPartController {


    public void cancelAddPart(ActionEvent actionEvent) throws Exception{

        Parent cancelAddParent = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene cancelAddScene = new Scene(cancelAddParent);

        Stage cancelAddWindow = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        cancelAddWindow.setScene(cancelAddScene);
        cancelAddWindow.show();

    }


    public void saveAddPart(ActionEvent actionEvent) {
    }
}


