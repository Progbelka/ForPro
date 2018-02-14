package de.hszg.stud.svtsar.forpro_frontend.view;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import de.hszg.stud.svtsar.forpro_frontend.App;
import de.hszg.stud.svtsar.forpro_frontend.model.Stock;
import de.hszg.stud.svtsar.forpro_frontend.model.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class StoreController {

	private App app;
	private Client client;

	private void setClient() {
		ClientConfig config = new ClientConfig();
		config.register(JacksonFeature.class);

		client = ClientBuilder.newClient(config);
	}
	
	@FXML
	private TextField storeCityTF;
	
	@FXML
	private TextField storeCountryTF;
	
	@FXML
	private TextField storeAddressTF;
	
	@FXML
	private Button createStoreButton;
	
	@FXML
	private ComboBox<Store> StoreComboUPD;
	
	@FXML
	private TextField StoreNewCountryTF;
	
	@FXML
	private TextField StoreNewCityTF;
	
	@FXML
	private TextField StoreNewAddressTF;
	
	@FXML
	private Button saveUpdates;
	
	@FXML
	private ComboBox<Store> StoreComboDEL;
	
	@FXML
	private Button deleteStore;


	@FXML
	private void initialize() {
		
	}
	
	public void setApp(App app) {
		this.app = app;
		setClient();
	}
	@FXML
	public boolean createStore() {
		
		setClient();
		Store store = new Store();
		store.setCity(storeCityTF.getText());
		store.setCountry(storeCountryTF.getText());
//		stock.setAddress(stockAddressTF.getText());

		Response response = client.target("http://localhost:8080/forpro-backend").path("stocks/create").request()
				.put(Entity.json(store));

		if (response.getStatus() != 200) {
			System.err.println(response.readEntity(String.class));
			return false;
		} else {
			return true;
		}

	}
}
