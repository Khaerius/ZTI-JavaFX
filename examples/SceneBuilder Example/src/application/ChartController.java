package application;

import javafx.scene.control.TextField;

import javafx.event.Event;
import javafx.fxml.FXML;

public class ChartController {
	
	public TextField text = null;
	
	@FXML
    public void ButtonClicked(Event e){
		text.setText("Scene Builder");
    }

}
