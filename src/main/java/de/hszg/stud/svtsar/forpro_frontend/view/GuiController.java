package de.hszg.stud.svtsar.forpro_frontend.view;

import de.hszg.stud.svtsar.forpro_frontend.App;
import de.hszg.stud.svtsar.forpro_frontend.model.Category;
import de.hszg.stud.svtsar.forpro_frontend.model.Product;
import de.hszg.stud.svtsar.forpro_frontend.model.Store;
import de.hszg.stud.svtsar.forpro_frontend.model.Stock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.MenuItem;

public class GuiController {
	private App app;

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
	private Button createProductBtn;
	
	
	@FXML
	private MenuItem Product;
	
	@FXML
	private MenuItem Category;

	@FXML
	private MenuItem Stocks;
	
	@FXML
	private MenuItem Stores;
	
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

//	@FXML
//	private void createProductEvent() {
//		this.app.createProduct();
//	}

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
	public void setApp(App app) {
		this.app = app;
		productTable.setItems(app.getAllProducts());
		categoryTable.setItems(app.getAllCategories());
		storeTable.setItems(app.getAllStores());
		stocksTable.setItems(app.getAllStocks());
	}
}
