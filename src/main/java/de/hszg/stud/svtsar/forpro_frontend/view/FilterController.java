package de.hszg.stud.svtsar.forpro_frontend.view;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import de.hszg.stud.svtsar.forpro_frontend.App;
import de.hszg.stud.svtsar.forpro_frontend.model.Category;
import de.hszg.stud.svtsar.forpro_frontend.model.Product;
import de.hszg.stud.svtsar.forpro_frontend.model.ProductInStock;
import de.hszg.stud.svtsar.forpro_frontend.model.ProductInStore;
import de.hszg.stud.svtsar.forpro_frontend.model.Stock;
import de.hszg.stud.svtsar.forpro_frontend.model.Store;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FilterController {

	private App app;
	private Client client;

	private void setClient() {
		ClientConfig config = new ClientConfig();
		config.register(JacksonFeature.class);
		
		client = ClientBuilder.newClient(config);
	}
	
	
	@FXML
	private TableView filterTable;
	
	@FXML
	private TableColumn<Category, String> categoryNameColumn;
	
	@FXML
	private TableColumn<Product, String> productNameColumn;
	
	@FXML
	private TableColumn<Store, String> storeCityColumn;
	
	@FXML
	private TableColumn<Stock, String> stockCityColumn;
	
	@FXML
	private TableColumn<ProductInStock, Integer> productInStockQ;
	
	@FXML
	private TableColumn<ProductInStore, Integer> productInStoreQ;
	
	@FXML
	private void initialize() {
		categoryNameColumn.setCellValueFactory(cellData -> cellData.getValue().categoryNameProperty());
		productNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());	
		storeCityColumn.setCellValueFactory(cellData -> cellData.getValue().storeCityProperty());
		stockCityColumn.setCellValueFactory(cellData -> cellData.getValue().stockCityProperty());
//		productInStockQ.setCellValueFactory(cellData -> cellData.getValue().getAmountAvailable());
//		productInStockQ.setCellValueFactory(cellData -> cellData.getValue().getAmountAvailable());
	}
	
	public void setApp(App app) {
		this.app = app;
		setClient(); 
		
		filterTable.setItems(getFilteredValues());
	}

	private ObservableList getFilteredValues() {
		// TODO Auto-generated method stub
		return null;
	}
}
