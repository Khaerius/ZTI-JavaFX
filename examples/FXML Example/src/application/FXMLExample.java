package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class FXMLExample extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	FXMLController controller = new FXMLController();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(controller);
        loader.setLocation(new URL("file:///C:\\Users\\karol\\eclipse-workspace-java\\FXML Example\\src\\application\\fxmlexample.fxml"));
        VBox vbox = loader.<VBox>load();

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
