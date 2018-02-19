package de.hszg.stud.svtsar.forpro_frontend.view;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import de.hszg.stud.svtsar.forpro_frontend.App;
import de.hszg.stud.svtsar.forpro_frontend.model.Product;
import de.hszg.stud.svtsar.forpro_frontend.model.Stock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StockController {

	private App app;
	private Client client;

	private void setClient() {
		ClientConfig config = new ClientConfig();
		config.register(JacksonFeature.class);

		client = ClientBuilder.newClient(config);
	}
	
	@FXML
	private TextField stockCityTF;
	
	@FXML
	private TextField stockCountryTF;
	
//	@FXML
//	private TextField stockAddressTF;
	
	@FXML
	private Button createStock;
	
	@FXML
	private Label created;
	
	@FXML
	private ComboBox<Stock> StockComboUPD;
	
	@FXML
	private TextField StockNewCountryTF;
	
	@FXML
	private TextField StockNewCityTF;
	
	@FXML
	private TextField StockNewAddressTF;
	
	@FXML
	private Button saveUpdates;
	
	@FXML
	private ComboBox<Stock> StockComboDEL;
	
	@FXML
	private Button deleteStock;
	
	@FXML
	private void initialize() {
		
	}
	
	public void setApp(App app) {
		this.app = app;
		setClient();
	}
	@FXML
	public boolean createStock() {
		
		setClient();
		Stock stock = new Stock();
		stock.setCity(stockCityTF.getText());
		stock.setCountry(stockCountryTF.getText());
//		stock.setAddress(stockAddressTF.getText());

		created.setText("Stock was created");
		stockCityTF.clear();
		stockCityTF.clear();
		Response response = client.target("http://localhost:8080/forpro-backend").path("stocks/create").request()
				.put(Entity.json(stock));

		if (response.getStatus() != 200) {
			System.err.println(response.readEntity(String.class));
			return false;
		} else {
			return true;
		}

	}
}
