package example1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Example1_Basic extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        Label text = new Label();
        text.setText("Hello World!");

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(text);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}