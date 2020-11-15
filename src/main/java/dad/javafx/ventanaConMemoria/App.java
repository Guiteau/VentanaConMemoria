package dad.javafx.ventanaConMemoria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import dad.javafx.controller.Controller;
import dad.javafx.model.Model;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.stage.Stage;

public class App extends Application {

	private Controller controller;
	private Model model;
	private Scene escenaManejo;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene escena = new Scene(controller.getView(), model.getWidthValue(), model.getHeightValue());

		primaryStage.setScene(escena);
		primaryStage.setTitle("Ventana con memoria");
		primaryStage.show();
		
		escenaManejo = escena;
		
	}

	@Override
	public void stop() throws Exception {
		
		try (OutputStream output = new FileOutputStream(
				model.getRutaPerfil() + "\\.VentanaConMemoria\\ventana.config")) {

			Properties properties = new Properties();
			
			properties.setProperty("background.red", Double.toString(controller.getRedSlider().getValue()));
			properties.setProperty("background.green", Double.toString(controller.getGreenSlider().getValue()));
			properties.setProperty("background.blue", Double.toString(controller.getBlueSlider().getValue()));
			properties.setProperty("size.width", Double.toString(escenaManejo.getWidth()));
			properties.setProperty("size.height", Double.toString(escenaManejo.getHeight()));
			properties.setProperty("location.x", Double.toString(escenaManejo.getX()));
			properties.setProperty("location.y", Double.toString(escenaManejo.getY()));

			properties.store(output, null);

		} catch (IOException ex1) {

			ex1.printStackTrace();

		}

		super.stop();

	}

	@Override
	public void init() {

		
		try {
			controller = new Controller();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Properties properties = new Properties();
		
		model = new Model();
		
		Path path = Paths.get(model.getRutaPerfil() + "\\.VentanaConMemoria\\ventana.config");
		
		if(Files.exists(path,
	            new LinkOption[]{ LinkOption.NOFOLLOW_LINKS })) {
									
			try (InputStream input = new FileInputStream(
					model.getRutaPerfil() + "\\.VentanaConMemoria\\ventana.config")) {

				properties.load(input);
			
				model.setRedSliderValue(Double.parseDouble(properties.getProperty("background.red")));
				model.setGreenSliderValue(Double.parseDouble(properties.getProperty("background.green")));
				model.setBlueSliderValue(Double.parseDouble(properties.getProperty("background.blue"))); 
				model.setWidthValue(Double.parseDouble(properties.getProperty("size.width")));
				model.setHeightValue(Double.parseDouble(properties.getProperty("size.height")));
				model.setxValue(Double.parseDouble(properties.getProperty("location.x")));
				model.setyValue(Double.parseDouble(properties.getProperty("location.y")));
	            
	            controller.getRedSlider().setValue(model.getRedSliderValue());
	            controller.getGreenSlider().setValue(model.getGreenSliderValue());
	            controller.getBlueSlider().setValue(model.getBlueSliderValue());
	            
	            controller.getView().setLayoutX(model.getxValue());
	            controller.getView().setLayoutY(model.getyValue());
	            
	            
	    		if (model.getRedSliderValue() > model.getGreenSliderValue()
	    				&& model.getRedSliderValue() > model.getBlueSliderValue()) {

	    			controller.getView().setBackground(
	    					new Background(new BackgroundFill(model.getRedColor(), CornerRadii.EMPTY, Insets.EMPTY)));

	    		} else if (model.getGreenSliderValue() > model.getRedSliderValue()
	    				&& model.getGreenSliderValue() > model.getBlueSliderValue()) {

	    			controller.getView().setBackground(
	    					new Background(new BackgroundFill(model.getGreenColor(), CornerRadii.EMPTY, Insets.EMPTY)));

	    		} else if (model.getBlueSliderValue() > model.getRedSliderValue() 
	    				&& model.getBlueSliderValue() > model.getGreenSliderValue()){

	    			controller.getView().setBackground(
	    					new Background(new BackgroundFill(model.getBlueColor(), CornerRadii.EMPTY, Insets.EMPTY)));

	    		}
	            

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		} else {
			
			@SuppressWarnings("unused")
			File file = new File(model.getRutaPerfil() + "\\.VentanaConMemoria\\ventana.config");
			
			//rellenamos el fichero con una configuración por defecto
			
			try (OutputStream output = new FileOutputStream(
							model.getRutaPerfil() + "\\.VentanaConMemoria\\ventana.config")) {
				
				properties.setProperty("background.red", "0");
				properties.setProperty("background.green", "0");
				properties.setProperty("background.blue", "0");
				properties.setProperty("size.width", "428");
				properties.setProperty("size.height", "278");
				properties.setProperty("location.x", "0");
				properties.setProperty("location.y", "0");

				properties.store(output, null);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {

		launch(args);

	}

}
