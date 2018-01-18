package de.hszg.stud.svtsar.forpro_frontend.model;

import java.io.Serializable;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * The persistent class for the store database table.
 * 
 */
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	private IntegerProperty storeIdProperty;
	
	private int storeId;

	private String address;

	private String city;

	private String country;

	private List<ProductInStore> productInStores;

	public Store() {
		this.storeIdProperty = new SimpleIntegerProperty();
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
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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