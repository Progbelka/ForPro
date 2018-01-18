package de.hszg.stud.svtsar.forpro_frontend.model;

import java.io.Serializable;
import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The persistent class for the product database table.
 * 
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private IntegerProperty productIdProperty;

	private int productId;

	private StringProperty nameProperty;

	private String name;

	private DoubleProperty priceProperty;
	
	private double price;

	private Category category;

	private List<ProductInStock> productInStocks;

	private List<ProductInStore> productInStores;

	public Product() {
		this.productIdProperty = new SimpleIntegerProperty();
		this.nameProperty = new SimpleStringProperty();
		this.priceProperty = new SimpleDoubleProperty();
	}

	public int getProductId() {
		return this.productIdProperty.get();
	}

	public void setProductId(int productId) {
		this.productIdProperty.set(productId);
	}

	public IntegerProperty productIdProperty() {
		return productIdProperty;
	}

	public String getName() {
		return this.nameProperty.get();
	}

	public void setName(String name) {
		this.nameProperty.set(name);
	}

	public StringProperty nameProperty() {
		return nameProperty;
	}

	public double getPrice() {
		return this.priceProperty.get();
	}

	public void setPrice(double price) {
		this.priceProperty.set(price);;
	}
	
	public DoubleProperty priceProperty() {
		return priceProperty;
	}
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductInStock> getProductInStocks() {
		return this.productInStocks;
	}

	public void setProductInStocks(List<ProductInStock> productInStocks) {
		this.productInStocks = productInStocks;
	}

	public ProductInStock addProductInStock(ProductInStock productInStock) {
		getProductInStocks().add(productInStock);
		productInStock.setProduct(this);

		return productInStock;
	}

	public ProductInStock removeProductInStock(ProductInStock productInStock) {
		getProductInStocks().remove(productInStock);
		productInStock.setProduct(null);

		return productInStock;
	}

	public List<ProductInStore> getProductInStores() {
		return this.productInStores;
	}

	public void setProductInStores(List<ProductInStore> productInStores) {
		this.productInStores = productInStores;
	}

	public ProductInStore addProductInStore(ProductInStore productInStore) {
		getProductInStores().add(productInStore);
		productInStore.setProduct(this);

		return productInStore;
	}

	public ProductInStore removeProductInStore(ProductInStore productInStore) {
		getProductInStores().remove(productInStore);
		productInStore.setProduct(null);

		return productInStore;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", productInStocks=" + productInStocks + ", productInStores=" + productInStores + "]";
	}

}