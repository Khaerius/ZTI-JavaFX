package application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FXMLController {
	
	public Label label2 = null;
	
	@FXML
    public void buttonClicked(Event e){
        System.out.println("Button clicked");
    }

}
