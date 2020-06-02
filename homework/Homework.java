package homework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Homework extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int maxCharacters = 255;

        primaryStage.setTitle("Homework");

        ProgressBar bar = new ProgressBar(0.0);

        TextArea textArea = new TextArea();

        Button publishButton = new Button("Publish");

        publishButton.setOnAction(event -> {
            Stage okStage = new Stage();
            okStage.setTitle("Success!");
            okStage.initModality(Modality.APPLICATION_MODAL);

            Label label = new Label("Message published!");
            Button okButton = new Button("OK");
            okButton.setOnAction(okEvent -> {
                textArea.clear();
                bar.setProgress(0.0);
                okStage.close();
            });

            VBox okRoot = new VBox();
            okRoot.getChildren().addAll(label, okButton);

            Scene okScene = new Scene(okRoot, 200, 100);
            okScene.getStylesheets().add(Homework.class.getResource("homework.css").toExternalForm());
            okStage.setScene(okScene);

            okStage.show();
        });

        textArea.setOnKeyPressed(event -> {
            int characterCount = textArea.getText().length();
            double characterFraction = (double) characterCount / (double) maxCharacters;
            System.out.println(characterFraction);
            if (characterFraction > 1.0) {
                bar.setProgress(1.0);
                publishButton.setDisable(true);
            } else {
                bar.setProgress(characterFraction);
                publishButton.setDisable(false);
            }
        });

        HBox controlArea = new HBox();
        controlArea.getStyleClass().add("box");
        controlArea.getChildren().addAll(bar, publishButton);

        VBox root = new VBox();
        root.getChildren().addAll(textArea, controlArea);

        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(Homework.class.getResource("homework.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}