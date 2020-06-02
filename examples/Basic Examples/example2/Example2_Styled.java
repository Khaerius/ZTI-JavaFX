package example2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Example2_Styled extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Styling");

        Text text = new Text();
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 20));
        text.setFill(Paint.valueOf("#ff3333"));

        Button btn = new Button();
        btn.setText("Hello World");
        btn.setOnAction(event -> {
            System.out.println("Hello World!");
            text.setText("Hello!");
        });

        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(btn);
        root.getChildren().add(text);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}