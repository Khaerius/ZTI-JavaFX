package example3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Example3_CSS extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSS");

        Text text = new Text();
        text.setId("responseText");

        Button btn = new Button();
        btn.setText("Hello World!");
        btn.setOnAction(event -> {
            System.out.println("Hello World!");
            text.setText("Hello!");
        });

        VBox vBox = new VBox();
        vBox.getChildren().add(btn);
        vBox.getChildren().add(text);

        Scene scene = new Scene(vBox, 382, 382);
        scene.getStylesheets().add(Example3_CSS.class.getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}