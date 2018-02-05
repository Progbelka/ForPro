package de.hszg.stud.svtsar.forpro_frontend.model;

import java.io.Serializable;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * The persistent class for the store database table.
 * 
 */
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	private IntegerProperty storeIdProperty;
	
	private StringProperty storeCityProperty;
	
	private StringProperty storeCountryProperty;
	
	private StringProperty storeAddressProperty;
	
	private int storeId;

	private String address;

	private String city;

	private String country;

	private List<ProductInStore> productInStores;

	public Store() {
		this.storeIdProperty = new SimpleIntegerProperty();
		this.storeCityProperty = new SimpleStringProperty();
		this.storeCountryProperty = new SimpleStringProperty();
		this.storeAddressProperty = new SimpleStringProperty();
	}

	public int getStoreId() {
		return this.storeIdProperty.get();
	}

	public void setStoreId(int storeId) {
		this.storeIdProperty.set(storeId);
	}
	
	public IntegerProperty storeIdProperty() {
		return storeIdProperty;
	}

	public String getAddress() {
		return this.storeAddressProperty.get();
	}

	public void setAddress(String address) {
		this.storeAddressProperty.set(address);
	}

	public StringProperty storeAddressProperty() {
		return storeAddressProperty;
	}
	public String getCity() {
		return this.storeCityProperty.get();
	}

	public void setCity(String city) {
		this.storeCityProperty.set(city);
	}

	public StringProperty storeCityProperty() {
		return storeCityProperty;
	}
	public String getCountry() {
		return this.storeCountryProperty.get();
	}

	public void setCountry(String country) {
		this.storeCountryProperty.set(country);
	}
	public StringProperty storeCountryProperty() {
		return storeCountryProperty;
	}

	public List<ProductInStore> getProductInStores() {
		return this.productInStores;
	}

	public void setProductInStores(List<ProductInStore> productInStores) {
		this.productInStores = productInStores;
	}

	public ProductInStore addProductInStore(ProductInStore productInStore) {
		getProductInStores().add(productInStore);
		productInStore.setStore(this);

		return productInStore;
	}

	public ProductInStore removeProductInStore(ProductInStore productInStore) {
		getProductInStores().remove(productInStore);
		productInStore.setStore(null);

		return productInStore;
	}

}