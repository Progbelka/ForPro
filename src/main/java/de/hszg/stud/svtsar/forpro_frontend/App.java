package de.hszg.stud.svtsar.forpro_frontend;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import de.hszg.stud.svtsar.forpro_frontend.model.Category;
import de.hszg.stud.svtsar.forpro_frontend.model.Product;
import de.hszg.stud.svtsar.forpro_frontend.model.Stock;
import de.hszg.stud.svtsar.forpro_frontend.model.Store;
import de.hszg.stud.svtsar.forpro_frontend.view.CategoryController;
import de.hszg.stud.svtsar.forpro_frontend.view.FilterController;
import de.hszg.stud.svtsar.forpro_frontend.view.GuiController;
import de.hszg.stud.svtsar.forpro_frontend.view.ProductController;
import de.hszg.stud.svtsar.forpro_frontend.view.StockController;
import de.hszg.stud.svtsar.forpro_frontend.view.StoreController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class App extends Application {

	private Client client;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		setClient();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/GUI.fxml"));
		BorderPane pane = loader.load();
		loader.setRoot(this);
		GuiController controller = loader.getController();
		controller.setApp(this);

		primaryStage.setTitle("Goods movement");
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}

	private void setClient() {
		ClientConfig config = new ClientConfig();
		config.register(JacksonFeature.class);

		client = ClientBuilder.newClient(config);
	}

	public ObservableList<Product> getAllProducts() {
		Response response = client.target("http://localhost:8080/forpro-backend").path("products/getAll")
				.request(MediaType.APPLICATION_JSON).get();

		if (response.getStatus() != 200) {
			System.err.println(response.readEntity(String.class));
			return FXCollections.observableArrayList();
		} else {
			List<Product> products = response.readEntity(new GenericType<List<Product>>() {
			});
			System.out.println(" list = "+products.toString());
			return FXCollections.observableArrayList(products);
		}
	}
	
	public Product getProductByName(String name) {
		Response response = client.target("http://localhost:8080/forpro-backend").path("products/findByName")
				.request(MediaType.APPLICATION_JSON).get();

		if (response.getStatus() != 200) {
			return null;
		} else {
			Product product = response.readEntity(new GenericType<Product>() {});
			System.out.println(" Product by name = "+product.toString());
			return product;
		}
	}

	public ObservableList<Category> getAllCategories() {
		Response response = client.target("http://localhost:8080/forpro-backend").path("category/getAll")
				.request(MediaType.APPLICATION_JSON).get();
		System.out.println("Response "+response.toString());	// CHECK
		if (response.getStatus() != 200) {
			System.err.println(response.readEntity(String.class));
			return FXCollections.observableArrayList();
		} else {
			List<Category> category = response.readEntity(new GenericType<List<Category>>() {});
			System.out.println("Category list to String = "+category.toString());	//CHECK
			System.out.println("List to return " +FXCollections.observableArrayList(category));
			return FXCollections.observableArrayList(category);
		}
	}

	public ObservableList<Store> getAllStores() {
		Response response = client.target("http://localhost:8080/forpro-backend").path("stores/getAll")
				.request(MediaType.APPLICATION_JSON).get();

		if (response.getStatus() != 200) {
			System.err.println(response.readEntity(String.class));
			return FXCollections.observableArrayList();
		} else {
			List<Store> store = response.readEntity(new GenericType<List<Store>>() {

			});
			return FXCollections.observableArrayList(store);
		}
	}
	
	public ObservableList<Stock> getAllStocks() {
		Response response = client.target("http://localhost:8080/forpro-backend").path("stocks/getAll")
				.request(MediaType.APPLICATION_JSON).get();

		if (response.getStatus() != 200) {
			System.err.println(response.readEntity(String.class));
			return FXCollections.observableArrayList();
		} else {
			List<Stock> stock = response.readEntity(new GenericType<List<Stock>>() {

			});
			return FXCollections.observableArrayList(stock);
		}
	}

//	public boolean createProduct() {
//
//		Product product = new Product();
//		product.setName("Check");
//		product.setPrice(20.05);
//
//		Response response = client.target("http://localhost:8080/forpro-backend").path("products/create").request()
//				.put(Entity.json(product));
//
//		if (response.getStatus() != 200) {
//			System.err.println(response.readEntity(String.class));
//			return false;
//		} else {
//			return true;
//		}
//
//	}

	
public void getProductManagerWindow() throws IOException {
	
		ProductController productController = new ProductController();
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/ProductController.fxml"));
			loader.setController(productController);
			productController.setApp(this);
			BorderPane pane = (BorderPane) loader.load();

			Stage stage = new Stage();		
			stage.setTitle("Product manager");
			stage.setScene(new Scene(pane));
			stage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
public void getCategoryManagerWindow() throws IOException {
	
	CategoryController categoryController = new CategoryController();
	try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/CategoryController.fxml"));
		loader.setController(categoryController);
		categoryController.setApp(this);
		BorderPane pane = (BorderPane) loader.load();

		Stage stage = new Stage();	
		stage.setTitle("Category manager");
		stage.setScene(new Scene(pane));
		stage.show();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public void getStockManagerWindow() throws IOException {
	
	StockController stockController = new StockController();
	try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/StockController.fxml"));
		loader.setController(stockController);
		stockController.setApp(this);
		
		BorderPane pane = (BorderPane) loader.load();

		Stage stage = new Stage();	
		stage.setTitle("Stock manager");
		stage.setScene(new Scene(pane));
		stage.show();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public void getStoreManagerWindow() throws IOException {
	
	StoreController storeController = new StoreController();
	try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/StoreController.fxml"));
		loader.setController(storeController);
		storeController.setApp(this);
		
		BorderPane pane = (BorderPane) loader.load();

		Stage stage = new Stage();	
		stage.setTitle("Store manager");
		stage.setScene(new Scene(pane));
		stage.show();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public void getFilterWindow() throws IOException {
	
	FilterController filterController = new FilterController();
	try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/FilterController.fxml"));
		loader.setController(filterController);

		BorderPane pane = (BorderPane) loader.load();

		Stage stage = new Stage();	
		stage.setTitle("Filter");
		stage.setScene(new Scene(pane));
		stage.show();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

}
