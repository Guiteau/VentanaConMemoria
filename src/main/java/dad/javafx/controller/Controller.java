package dad.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class Controller implements Initializable{
	
    @FXML
    private VBox view;

	@FXML
    private Label redLabel;

	@FXML
    private Slider redSlider;

    @FXML
    private Label greenLabel;

	@FXML
    private Slider greenSlider;

    @FXML
    private Label blueLabel;

    @FXML
    private Slider blueSlider;
    

    public Controller() throws IOException{
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
		
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}
	
    public Label getRedLabel() {
		return redLabel;
	}

	public void setRedLabel(Label redLabel) {
		this.redLabel = redLabel;
	}

	public Slider getRedSlider() {
		return redSlider;
	}

	public void setRedSlider(Slider redSlider) {
		this.redSlider = redSlider;
	}

	public Label getGreenLabel() {
		return greenLabel;
	}

	public void setGreenLabel(Label greenLabel) {
		this.greenLabel = greenLabel;
	}

	public Slider getGreenSlider() {
		return greenSlider;
	}

	public void setGreenSlider(Slider greenSlider) {
		this.greenSlider = greenSlider;
	}

	public Label getBlueLabel() {
		return blueLabel;
	}

	public void setBlueLabel(Label blueLabel) {
		this.blueLabel = blueLabel;
	}

	public Slider getBlueSlider() {
		return blueSlider;
	}

	public void setBlueSlider(Slider blueSlider) {
		this.blueSlider = blueSlider;
	}
	
    public VBox getView() {
		return view;
	}
    
    public void setView(VBox view) {
		this.view = view;
	}

}
