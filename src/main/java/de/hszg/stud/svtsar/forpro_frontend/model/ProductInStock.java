package de.hszg.stud.svtsar.forpro_frontend.model;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;


/**
 * The persistent class for the product_in_stock database table.
 * 
 */
public class ProductInStock implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private IntegerProperty productInStockIdProperty;
	
	private int productInStockId;
	
	private IntegerProperty amountAvailableProperty;

	private int amountAvailable;

	private Stock stock;

	private Product product;

	public ProductInStock() {
	}

	public int getAmountAvailable() {
		return this.amountAvailableProperty.get();
	}

	public void setAmountAvailable(int amountAvailable) {
		this.amountAvailableProperty.set(amountAvailable);
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductInStockId() {
		return productInStockIdProperty.get();
	}

	public void setProductInStockId(int productInStockId) {
		this.productInStockIdProperty.set(productInStockId);
	}

}