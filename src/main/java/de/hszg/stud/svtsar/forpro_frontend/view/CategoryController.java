package de.hszg.stud.svtsar.forpro_frontend.view;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import de.hszg.stud.svtsar.forpro_frontend.App;
import de.hszg.stud.svtsar.forpro_frontend.model.Category;
import de.hszg.stud.svtsar.forpro_frontend.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class CategoryController {
	
	private App app;
	private Client client;

	private void setClient() {
		ClientConfig config = new ClientConfig();
		config.register(JacksonFeature.class);

		client = ClientBuilder.newClient(config);
	}
	
	ObservableList<String> categoryList =  FXCollections.observableArrayList();
	
	@FXML
	private TextField categoryNameTF;
	
//	@FXML
//	private TextField parentCategoryName;
	
	@FXML
	private Button createCategoryButton;
	
	@FXML 
	private ComboBox<Category> categoryListCombo;
	
	@FXML
	private TextField categoryNewNameTF;
	
	@FXML
	private Button saveUpdating;
	
	@FXML
	private ComboBox<Category> categoryComboDel;
	
	@FXML
	private Button categoryDeleteButton;
		
	@FXML
	private Button backButton;
	
	public void setApp(App app) {
		this.app = app;
		setClient();
		
	}
	
	@FXML
	private void loadItems() {
		StringConverter<Category> categoryStringConverter = new StringConverter<Category>() {
			@Override
			public Category fromString(String s) {
				return null;
			}
			@Override
			public String toString(Category category) {
				return category.getName();
			}
			
		};
		
		categoryListCombo.setConverter(categoryStringConverter);
		
		categoryListCombo.setItems(app.getAllCategories());
		
	}
	@FXML
	private void initialize() {
		
//		categoryList.addAll("test", "check");
//		categoryListCombo.setItems(categoryList);

	}
	@FXML
	public boolean createCategory() {
		
		setClient();
		Category category = new Category();
		category.setName(categoryNameTF.getText());


		Response response = client.target("http://localhost:8080/forpro-backend").path("category/create").request()
				.put(Entity.json(category));

		if (response.getStatus() != 200) {
			System.err.println(response.readEntity(String.class));
			return false;
		} else {
			return true;
		}

	}
}
