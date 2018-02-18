package de.hszg.stud.svtsar.forpro_frontend.view;


import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import de.hszg.stud.svtsar.forpro_frontend.App;
import de.hszg.stud.svtsar.forpro_frontend.model.Category;
import de.hszg.stud.svtsar.forpro_frontend.model.Product;
import de.hszg.stud.svtsar.forpro_frontend.model.Store;
import de.hszg.stud.svtsar.forpro_frontend.model.Stock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import javafx.util.StringConverter;
import javafx.scene.control.MenuItem;

public class GuiController {
	private App app;
	private Client client;

	private void setClient() {
		ClientConfig config = new ClientConfig();
		config.register(JacksonFeature.class);
		
		client = ClientBuilder.newClient(config);
	}

	
	@FXML
	private TableView<Product> productTable;

	@FXML
	private TableColumn<Product, Integer> productIdColumn;

	@FXML
	private TableColumn<Product, String> productNameColumn;

	@FXML
	private TableColumn<Product, Double> productPriceColumn;

	
	@FXML
	private TableView<Category> categoryTable;

	 @FXML
	 private TableColumn<Category, Integer> categoryIdColumn;

	@FXML
	private TableColumn<Category, String> categoryNameColumn;

	
	@FXML
	private TableView<Store> storeTable;

	@FXML
	private TableColumn<Store, Integer> storeIdColumn;

	@FXML
	private TableColumn<Store, String> storeCityColumn;
	
	@FXML
	private TableColumn<Store, String> storeCountryColumn;
	
	@FXML
	private TableColumn<Store, String> storeAddressColumn;
	
	
	@FXML
	private TableView<Stock> stocksTable;

	@FXML
	private TableColumn<Stock, Integer> stockIdColumn;

	@FXML
	private TableColumn<Stock, String> stockCityColumn;
	
	@FXML
	private TableColumn<Stock, String> stockCountryColumn;
	
	@FXML
	private TableColumn<Stock, String> stockAddressColumn;
	
	@FXML
	private Button filterBtn;
	
	@FXML
	private MenuItem Product;
	
	@FXML
	private MenuItem Category;

	@FXML
	private MenuItem Stocks;
	
	@FXML
	private MenuItem Stores;
	


	@FXML
	private void getProductManager() throws Exception {
		this.app.getProductManagerWindow();
	}
	@FXML
	private void getCategoryManager() throws Exception {
		this.app.getCategoryManagerWindow();
	}
	@FXML
	private void getStoreManager() throws Exception {
		this.app.getStoreManagerWindow();
	}
	@FXML
	private void getStockManager() throws Exception {
		this.app.getStockManagerWindow();
	}
	
	@FXML 
	private ComboBox<Category> categoryListCombo;
	
	@FXML 
	private ComboBox<Product> productListCombo;
	
	@FXML 
	private ComboBox<Stock> stockListCombo;
	
	@FXML 
	private ComboBox<Store> storeListCombo;
	
	@FXML
	private void filter() throws IOException{
		String category = categoryListCombo.getValue().toString();
		String product = productListCombo.getValue().toString();
		
		if(stockListCombo.getValue() != null) {
			String stock = stockListCombo.getValue().toString();
		}
		if(storeListCombo.getValue() != null) {			
			String store = storeListCombo.getValue().toString();
		}
		
		this.app.getFilterWindow();
	}
	
	@FXML
	private void initialize() {
		
		productIdColumn.setCellValueFactory(cellData -> cellData.getValue().productIdProperty().asObject());
		productNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		productPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
		
		categoryIdColumn.setCellValueFactory(cellData -> cellData.getValue().categoryIdProperty().asObject());
		categoryNameColumn.setCellValueFactory(cellData -> cellData.getValue().categoryNameProperty());
		
		storeIdColumn.setCellValueFactory(cellData -> cellData.getValue().storeIdProperty().asObject());
		storeCityColumn.setCellValueFactory(cellData -> cellData.getValue().storeCityProperty());
		storeCountryColumn.setCellValueFactory(cellData -> cellData.getValue().storeCountryProperty());
		storeAddressColumn.setCellValueFactory(cellData -> cellData.getValue().storeAddressProperty());
		
		stockIdColumn.setCellValueFactory(cellData -> cellData.getValue().stockIdProperty().asObject());
		stockCityColumn.setCellValueFactory(cellData -> cellData.getValue().stockCityProperty());
		stockCountryColumn.setCellValueFactory(cellData -> cellData.getValue().stockCountryProperty());
		stockAddressColumn.setCellValueFactory(cellData -> cellData.getValue().stockAddressProperty());
		
	}
	
	
	public void setApp(App app) {
		this.app = app;
		setClient(); 
		
		productTable.setItems(app.getAllProducts());
		categoryTable.setItems(app.getAllCategories());
		storeTable.setItems(app.getAllStores());
		stocksTable.setItems(app.getAllStocks());
		
		
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
		
		StringConverter<Stock> stockStringConverter = new StringConverter<Stock>() {
			@Override
			public Stock fromString(String s) {
				return null;
			}
			@Override
			public String toString(Stock stock) {
				return stock.getCity();
			}
			
		};
		
		StringConverter<Store> storeStringConverter = new StringConverter<Store>() {
			@Override
			public Store fromString(String s) {
				return null;
			}
			@Override
			public String toString(Store store) {
				return store.getCity();
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
		
		categoryListCombo.setConverter(categoryStringConverter);
		stockListCombo.setConverter(stockStringConverter);
		storeListCombo.setConverter(storeStringConverter);
		productListCombo.setConverter(productStringConverter);

		categoryListCombo.setItems(app.getAllCategories());
		productListCombo.setItems(app.getAllProducts());
		stockListCombo.setItems(app.getAllStocks());
		storeListCombo.setItems(app.getAllStores());
	}
}
