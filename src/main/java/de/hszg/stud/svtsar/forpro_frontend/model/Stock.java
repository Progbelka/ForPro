package de.hszg.stud.svtsar.forpro_frontend.model;

import java.io.Serializable;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * The persistent class for the stock database table.
 * 
 */
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	private IntegerProperty stockIdProperty;
	
	private StringProperty stockCityProperty;
	
	private StringProperty stockCountryProperty;
	
	private StringProperty stockAddressProperty;
	
	private int stockId;

	private String city;

	private String country;
	
	private String address;
	

	private List<ProductInStock> productInStocks;

	public Stock() {
		this.stockIdProperty = new SimpleIntegerProperty();
		this.stockCityProperty = new SimpleStringProperty();
		this.stockCountryProperty = new SimpleStringProperty();
		this.stockAddressProperty = new SimpleStringProperty();
	}

	public int getStockId() {
		return this.stockIdProperty.get();
	}

	public void setStockId(int stockId) {
		this.stockIdProperty.set(stockId);
	}

	public IntegerProperty stockIdProperty() {
		return stockIdProperty;
	}
	public String getCity() {
		return this.stockCityProperty.get();
	}

	public void setCity(String city) {
		this.stockCityProperty.set(city);
	}

	public StringProperty stockCityProperty() {
		return stockCityProperty;
	}
	public String getCountry() {
		return this.stockCountryProperty.get();
	}

	public void setCountry(String country) {
		this.stockCountryProperty.set(country);
	}
	
	public StringProperty stockCountryProperty() {
		return stockCountryProperty;
	}
	
	public String getAddress() {
		return this.stockAddressProperty.get();
	}
	
	public void setAddress(String address) {
		this.stockAddressProperty.set(address);
	}
	
	public StringProperty stockAddressProperty() {
		return stockAddressProperty;
	}
	
	public List<ProductInStock> getProductInStocks() {
		return this.productInStocks;
	}

	public void setProductInStocks(List<ProductInStock> productInStocks) {
		this.productInStocks = productInStocks;
	}

	public ProductInStock addProductInStock(ProductInStock productInStock) {
		getProductInStocks().add(productInStock);
		productInStock.setStock(this);

		return productInStock;
	}

	public ProductInStock removeProductInStock(ProductInStock productInStock) {
		getProductInStocks().remove(productInStock);
		productInStock.setStock(null);

		return productInStock;
	}


}