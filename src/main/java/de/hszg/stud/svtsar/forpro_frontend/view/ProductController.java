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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class ProductController {
	private App app;
	private Client client;

	private void setClient() {
		ClientConfig config = new ClientConfig();
		config.register(JacksonFeature.class);

		client = ClientBuilder.newClient(config);
	}
	
	@FXML
	private TextField productNameTF;
	
	@FXML
	private TextField productPriceTF;
	
	@FXML
	private ComboBox<Category> CategoryComboCR;
	
	@FXML
	private ComboBox<Category> CategoryComboUPD;
	
	@FXML
	private ComboBox<Product> ProductNameComboUPD;
	
	@FXML
	private Button createProductButton;
	
	@FXML
	private ComboBox<Category> OtherCategoryComboUPD;
	
	@FXML
	private TextField newProductName;
	
	@FXML
	private TextField newProductPrice;
	
	@FXML
	private Button saveUpdates;
	
	@FXML
	private ComboBox<Category> CategoryComboDEL;
	
	@FXML
	private ComboBox<Product> ProductNameComboDEL;
	
	@FXML
	private Button ProductDELBtn;
	
	@FXML
	private void initialize() {
		
	}
	
	public void setApp(App app) {
		this.app = app;
		setClient();
		
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
		
		StringConverter<Product> productStringConverter = new StringConverter<Product>() {
			@Override
			public Product fromString(String s) {
				return null;
			}
			@Override
			public String toString(Product product) {
				return product.getName();
			}
			
		};
		
		CategoryComboCR.setConverter(categoryStringConverter);
		ProductNameComboUPD.setConverter(productStringConverter);
		CategoryComboUPD.setConverter(categoryStringConverter);

		CategoryComboCR.setItems(app.getAllCategories());
		CategoryComboUPD.setItems(app.getAllCategories());
		ProductNameComboUPD.setItems(app.getAllProducts());
	}
	

	@FXML
	public boolean createProduct() {
		
		setClient();
		Product product = new Product();
		product.setName(productNameTF.getText());
		product.setPrice(Double.parseDouble(productPriceTF.getText()));

		Response response = client.target("http://localhost:8080/forpro-backend").path("products/create").request()
				.put(Entity.json(product));

		if (response.getStatus() != 200) {
			System.err.println(response.readEntity(String.class));
			return false;
		} else {
			return true;
		}

	}
}
