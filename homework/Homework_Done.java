package homework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Homework_Done extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int maxCharacters = 255;

        primaryStage.setTitle("Homework");

        ProgressIndicator indicator = new ProgressIndicator(0.0);

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
                indicator.setProgress(0.0);
                okStage.close();
            });

            VBox okRoot = new VBox();
            okRoot.getChildren().addAll(label, okButton);

            Scene okScene = new Scene(okRoot, 200, 100);
            okScene.getStylesheets().add(Homework_Done.class.getResource("homework_Done.css").toExternalForm());
            okStage.setScene(okScene);

            okStage.show();
        });

        textArea.setOnKeyPressed(event -> {
            int characterCount = textArea.getText().length();
            double characterFraction = (double) characterCount / (double) maxCharacters;
            if (characterFraction > 1.0) {
                indicator.setProgress(1.0);
                publishButton.setDisable(true);
            } else {
                indicator.setProgress(characterFraction);
                publishButton.setDisable(false);
            }
        });

        HBox controlArea = new HBox();
        controlArea.getStyleClass().add("box");
        controlArea.getChildren().addAll(indicator, publishButton);

        VBox root = new VBox();
        root.getChildren().addAll(textArea, controlArea);

        Scene scene = new Scene(root, 300, 230);
        scene.getStylesheets().add(Homework_Done.class.getResource("homework_Done.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}