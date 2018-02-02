package de.hszg.stud.svtsar.forpro_frontend.view;

import de.hszg.stud.svtsar.forpro_frontend.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProductController {

	private App app;
	
	@FXML
	private Button createProductButton;
	
	@FXML
	private void createProductButton() {
		this.app.createProduct();
	}
	
	@FXML
	private void initialize() {
		
	}
	public void setApp(App app) {
		this.app = app;
		
	}
}
