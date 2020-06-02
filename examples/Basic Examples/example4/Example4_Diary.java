package example4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Example4_Diary extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Diary");
        Database database = new Database();

        TableView tableView = new TableView();
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TableColumn<String, Entry> dateColumn = new TableColumn<>("Date");
        dateColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.6));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<String, Entry> numberColumn = new TableColumn<>("Number");
        numberColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.39));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        tableView.getColumns().add(dateColumn);
        tableView.getColumns().add(numberColumn);
        tableView.setItems(database.getData());

        Button addButton = new Button();
        addButton.setMinSize(75.0, 0.0);
        addButton.setText("Add");
        addButton.setOnAction(addEvent -> {
            Stage addWindow = new Stage();
            addWindow.initModality(Modality.APPLICATION_MODAL);
            addWindow.setTitle("Add Entry");

            VBox addRoot = new VBox();
            addRoot.getStyleClass().add("inputContainer");
            HBox buttonContainer = new HBox();
            buttonContainer.getStyleClass().add("horizontalButtonContainer");

            TextArea textArea = new TextArea();
            textArea.setPrefSize(400, 300);

            Button submitButton = new Button();
            submitButton.setText("Add");
            submitButton.setMinSize(75.0, 0.0);
            submitButton.setOnAction(submitEvent -> {
                database.add(textArea.getText());
                addWindow.close();
            });

            Button cancelButton = new Button();
            cancelButton.setText("Cancel");
            cancelButton.setMinSize(75.0, 0.0);
            cancelButton.setOnAction(submitEvent -> addWindow.close());

            buttonContainer.getChildren().addAll(submitButton, cancelButton);
            addRoot.getChildren().addAll(textArea, buttonContainer);

            Scene addScene = new Scene(addRoot);
            addScene.getStylesheets().add(Example4_Diary.class.getResource("diary.css").toExternalForm());
            addWindow.setScene(addScene);
            addWindow.show();
        });

        Button deleteButton = new Button();
        deleteButton.setMinSize(75.0, 0.0);
        deleteButton.setText("Delete");
        deleteButton.setOnAction(event -> {
            int index = tableView.getSelectionModel().getSelectedIndex();
            if (index != -1)
                database.remove(index);
        });

        Button openButton = new Button();
        openButton.setMinSize(75.0, 0.0);
        openButton.setText("Open");
        openButton.setOnAction(openEvent -> {
            int index = tableView.getSelectionModel().getSelectedIndex();
            if (index != -1) {
                Stage openWindow = new Stage();
                openWindow.initModality(Modality.APPLICATION_MODAL);
                openWindow.setTitle("Entry");

                VBox addRoot = new VBox();
                addRoot.getStyleClass().add("inputContainer");
                HBox buttonContainer = new HBox();
                buttonContainer.getStyleClass().add("horizontalButtonContainer");

                TextArea textArea = new TextArea();
                textArea.setPrefSize(400, 300);
                textArea.setText(database.getData().get(index).getContent());

                Button submitButton = new Button();
                submitButton.setText("Save");
                submitButton.setMinSize(75.0, 0.0);
                submitButton.setOnAction(submitEvent -> {
                    database.edit(index, textArea.getText());
                    openWindow.close();
                });

                Button deleteButton2 = new Button();
                deleteButton2.setText("Delete");
                deleteButton2.setMinSize(75.0, 0.0);
                deleteButton2.setOnAction(submitEvent -> {
                    database.remove(index);
                    openWindow.close();
                });

                Button closeButton = new Button();
                closeButton.setText("Close");
                closeButton.setMinSize(75.0, 0.0);
                closeButton.setOnAction(submitEvent -> openWindow.close());

                buttonContainer.getChildren().addAll(submitButton, deleteButton2, closeButton);
                addRoot.getChildren().addAll(textArea, buttonContainer);

                Scene addScene = new Scene(addRoot);
                addScene.getStylesheets().add(Example4_Diary.class.getResource("diary.css").toExternalForm());
                openWindow.setScene(addScene);
                openWindow.show();
            }
        });

        GridPane root = new GridPane();
        root.add(addButton, 0, 0);
        root.add(deleteButton, 0, 1);
        root.add(openButton, 0, 2);
        root.add(tableView, 1, 0, 1, 4);
//        root.setGridLinesVisible(true);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(Example4_Diary.class.getResource("diary.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}