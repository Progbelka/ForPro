package de.hszg.stud.svtsar.forpro_frontend.model;

import java.io.Serializable;


/**
 * The persistent class for the product_in_store database table.
 * 
 */
public class ProductInStore implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int productInStoreId;

	private int amountAvailable;

	private Product product;

	private Store store;

	public ProductInStore() {
	}

	public int getAmountAvailable() {
		return this.amountAvailable;
	}

	public void setAmountAvailable(int amountAvailable) {
		this.amountAvailable = amountAvailable;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getProductInStoreId() {
		return productInStoreId;
	}

	public void setProductInStoreId(int productInStoreId) {
		this.productInStoreId = productInStoreId;
	}

}