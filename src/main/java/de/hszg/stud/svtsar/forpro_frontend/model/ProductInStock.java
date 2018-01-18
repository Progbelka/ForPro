package de.hszg.stud.svtsar.forpro_frontend.model;

import java.io.Serializable;


/**
 * The persistent class for the product_in_stock database table.
 * 
 */
public class ProductInStock implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int productInStockId;

	private int amountAvailable;

	private Stock stock;

	private Product product;

	public ProductInStock() {
	}

	public int getAmountAvailable() {
		return this.amountAvailable;
	}

	public void setAmountAvailable(int amountAvailable) {
		this.amountAvailable = amountAvailable;
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
		return productInStockId;
	}

	public void setProductInStockId(int productInStockId) {
		this.productInStockId = productInStockId;
	}

}