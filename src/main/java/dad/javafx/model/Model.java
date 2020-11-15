package dad.javafx.model;

import javafx.scene.paint.Color;

public class Model {
	
	String rutaPerfil;
	Color redColor;
	Color greenColor;
	Color blueColor;
	double redSliderValue;
	double greenSliderValue;
	double blueSliderValue;
	double widthValue;
	double heightValue;
	double xValue;
	double yValue;
	
	public Model() {
		
		redColor = Color.RED;
		greenColor = Color.GREEN;
		blueColor = Color.BLUE;
		
		rutaPerfil = System.getProperty("user.home");
		
	}

	public double getWidthValue() {
		return widthValue;
	}


	public void setWidthValue(double widthValue) {
		this.widthValue = widthValue;
	}


	public double getHeightValue() {
		return heightValue;
	}


	public void setHeightValue(double heightValue) {
		this.heightValue = heightValue;
	}


	public double getxValue() {
		return xValue;
	}


	public void setxValue(double xValue) {
		this.xValue = xValue;
	}


	public double getyValue() {
		return yValue;
	}


	public void setyValue(double yValue) {
		this.yValue = yValue;
	}


	public String getRutaPerfil() {
		return rutaPerfil;
	}


	public void setRutaPerfil(String rutaPerfil) {
		this.rutaPerfil = rutaPerfil;
	}


	public Color getRedColor() {
		return redColor;
	}


	public void setRedColor(Color redColor) {
		this.redColor = redColor;
	}


	public Color getGreenColor() {
		return greenColor;
	}


	public void setGreenColor(Color greenColor) {
		this.greenColor = greenColor;
	}


	public Color getBlueColor() {
		return blueColor;
	}


	public void setBlueColor(Color blueColor) {
		this.blueColor = blueColor;
	}
	
	public double getRedSliderValue() {
		return redSliderValue;
	}


	public void setRedSliderValue(double redSliderValue) {
		this.redSliderValue = redSliderValue;
	}


	public double getGreenSliderValue() {
		return greenSliderValue;
	}


	public void setGreenSliderValue(double greenSliderValue) {
		this.greenSliderValue = greenSliderValue;
	}


	public double getBlueSliderValue() {
		return blueSliderValue;
	}


	public void setBlueSliderValue(double blueSliderValue) {
		this.blueSliderValue = blueSliderValue;
	}

}
