package de.hszg.stud.svtsar.forpro_frontend.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the stock database table.
 * 
 */
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	private int stockId;

	private String city;

	private String country;

	private List<ProductInStock> productInStocks;

	public Stock() {
	}

	public int getStockId() {
		return this.stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
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