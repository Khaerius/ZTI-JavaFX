package example5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Example5_Controls extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Controls");
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        // primaryStage.setOpacity(0.25);

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton radio1 = new RadioButton("+");
        radio1.setToggleGroup(toggleGroup);
        radio1.setSelected(true);

        RadioButton radio2 = new RadioButton("-");
        radio2.setToggleGroup(toggleGroup);

        ObservableList<String> options = FXCollections.observableArrayList("1", "2", "5");
        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setValue("1");

        CheckBox checkBox = new CheckBox("x2");

        Separator separator = new Separator();

        ProgressBar bar = new ProgressBar(0.0);

        ProgressIndicator indicator = new ProgressIndicator(0.0);

        Button applyButton = new Button();
        applyButton.setText("Apply");
        applyButton.setOnAction(event -> {
            String valueString = comboBox.getValue();
            int value = Integer.parseInt(valueString);
            if (checkBox.isSelected())
                value *= 2;
            if (radio2.isSelected())
                value = -value;

            double progress = bar.getProgress();
            progress += (double) value / 100.0;
            if (progress < 0.0)
                progress = 0.0;
            else if (progress > 1.0)
                progress = 1.0;

            bar.setProgress(progress);
            indicator.setProgress(progress);
        });

        VBox radioBox = new VBox();
        radioBox.getChildren().addAll(radio1, radio2);
        radioBox.getStyleClass().add("box");
        radioBox.setId("radioBox");

        HBox settingsBox = new HBox();
        settingsBox.getChildren().addAll(radioBox, comboBox, checkBox);
        settingsBox.getStyleClass().add("box");

        HBox progressBox = new HBox();
        progressBox.getChildren().addAll(bar, indicator, applyButton);
        progressBox.getStyleClass().add("box");

        VBox root = new VBox();
        root.getChildren().addAll(settingsBox, separator, progressBox);
        root.getStyleClass().add("box");

        Scene scene = new Scene(root, 300, 150);
        scene.getStylesheets().add(Example5_Controls.class.getResource("controls.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}