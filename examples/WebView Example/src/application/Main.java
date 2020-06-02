package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			WebView webView = new WebView();
			webView.getEngine().load("http://google.com");
			//webView.setZoom(1.25);
			//webView.setFontScale(1.25);
			VBox vbox = new VBox(webView);
			Scene scene = new Scene(vbox,960,600);
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
