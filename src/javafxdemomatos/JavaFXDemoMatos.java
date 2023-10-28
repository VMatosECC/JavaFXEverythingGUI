
package javafxdemomatos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// This app demonstrates the use of a variety of JavaFX containers and controls.
// The stage is used by two scenes, each showing how to define and use
// common JavaFX components. The app shows how how one scene can pass 
// and receive data itemes from the other scenes.
public class JavaFXDemoMatos extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
