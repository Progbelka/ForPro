package de.hszg.stud.svtsar.forpro_frontend.view;

import de.hszg.stud.svtsar.forpro_frontend.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CategoryController {
	
	private App app;
	
	@FXML
	private Button createCategoryButton;
	
	@FXML
	private void createCategoryButton() {
		this.app.createProduct();
	}
	
	
}
