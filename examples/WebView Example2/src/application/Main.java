package application;


import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		WebView webView = new WebView();
		WebEngine webengine = webView.getEngine();
		
		Button js = new Button();
		js.setText("Skrypt Javascript");
		js.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (webengine != null) 
                {
                    webengine.executeScript("test()");
                }
            }
        });
		
		try {
			webengine.setJavaScriptEnabled(true);
			File file = new File("C:\\Users\\karol\\eclipse-workspace-java\\WebView Example2\\src\\HTMLExample.html");
			webengine.load(file.toURI().toURL().toString());
			
			StackPane root = new StackPane();
	        HBox hh = new HBox();
	        hh.getChildren().add(js);
	        hh.getChildren().add(webView);


	        root.getChildren().add(hh);
			Scene scene = new Scene(root,960,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
